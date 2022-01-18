#!/usr/bin/env bash
set -x
export UID=$(id -u)
export GID=$(id -g)

. bash_functions

runtime_environment=""
tag=""
browser=""
result_file_value=""
debug=false

if [[ "$1" == "--help" ]]; then
    echo "
    [-b <browser> Browser name: chrome]
    [-t <tag> Tag name]
    [-r <runtime environment> Runtime environment name: local, remote]
    [-d Debug mode. Disabled by default]
    "
    exit 1
fi

while getopts ":b:e:t:r:d" opt; do
    case ${opt} in
        b)
            browser=$(browser_set $OPTARG)
            ;;
        d)
            debug=true
            ;;
        t)
            tag=$(build_tag_set $OPTARG)
            ;;
        r)
            runtime_environment=$(run_environment $OPTARG)
            ;;
    esac
done

if [[ -z $runtime_environment ]]; then
    runtime_environment="local"
fi

if [[ -z $browser ]]; then
    echo "Setting default browser: Chrome"
    browser="chrome"
fi

if [[ -z $tag ]]; then
    tag=$(build_tag_set)
fi

if [[ "$browser" == "chrome" ]] && [[ "$runtime_environment" == "remote" ]]; then
    browser="remote_chrome"
fi

rm -rf report

run_tests $runtime_environment $debug $tag $browser


if [[ -e $("pwd")/report/result_file ]]; then
    result_file_value=$(<$("pwd")/report/result_file)
    echo "Tests status: $result_file_value"
fi

rm_env_file_if_exist
exit 0

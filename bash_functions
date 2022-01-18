#@IgnoreInspection BashAddShebang
function run_environment {
    if [[ "$1" == "local" ]]; then
        echo "local"
    elif [[ "$1" == "remote" ]]; then
        echo "remote"
    else
        "Bad runtime environment name"
        exit 1
    fi
}

function browser_set {
    if [[ "$1" == "chrome" ]];then
        echo "chrome"
    else
        echo "Bad browser name or browser not supported yet"
        exit 1
    fi
}

function build_tag_set {
    if [[ "$1" == "chrome" ]] || [[ -z "$1" ]];then
        echo $(date +%d%m%y%H%M)
    else
        echo $1
    fi
}

function rm_env_file_if_exist {
    if [[ -e compose.env ]]; then
        rm compose.env
    fi
}

function generate_env_file {
    #Parameters order:
    # $1 browser
    # $2 build tag

    if [[ -z "$2" ]]; then
        echo "There are no correct parameters amount to generate compose.env file!!"
        exit 1
    fi

    export browser=$1
    export tag=$2
    export BINTRAY_KEY=$BINTRAY_KEY
    export BINTRAY_USER=$BINTRAY_USER
    export TESTRAIL_USER=$TESTRAIL_USER
    export TESTRAIL_PASS=$TESTRAIL_PASS

    rm_env_file_if_exist
    envsubst < "compose.env.template" > "compose.env"

}

#Parameters order:
# $1 runtime environment
# $2 debug
# $3 tag
# $4 browser
function run_tests {
    generate_env_file $4 $3
    if [[ "$1" == "remote" ]]; then
        if $2; then
            docker-compose -f docker-compose-debug.yml -p "$3" up --build --abort-on-container-exit
        else
            docker-compose -p "$3" up --build --abort-on-container-exit
        fi
            docker-compose -p "$3" down
    elif [[ "$1" ==  "local" ]]; then
        if $2; then
            echo "No debug mode in local tests run. Running in normal mode"
        fi
        ./run_tests.sh "$4" "$3"
    fi
}
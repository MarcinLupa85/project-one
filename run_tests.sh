#!/bin/bash


mkdir -p report

gradle clean test -i -Pdriver_type="$browser" -Pbuild_tag=$tag

echo "END"

if [[ -f /.dockerenv ]]; then
    chown -R $USER_ID:$GROUP_ID gradleCache
    chown -R $USER_ID:$GROUP_ID report
    chown -R $USER_ID:$GROUP_ID build
fi
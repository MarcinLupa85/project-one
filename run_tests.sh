#!/bin/bash


mkdir -p report

gradle clean test -i -Pdriver_type="$browser" -Pbuild_tag=$tag

echo "END"

if [[ -f /.dockerenv ]]; then
    echo "CHANGING ACCESS MODIFIERS"
    chmod -R 777 gradleCache
    chmod -R 777 report
    chmod -R 777 build
    chmod -R 777 .gradle
fi
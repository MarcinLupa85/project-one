#!/bin/bash


mkdir -p report

gradle clean test -i -Pdriver_type="$browser" -Pbuild_tag=$tag

echo "END"

if [[ -f /.dockerenv ]]; then
    useradd -ms /bin/bash jenkins;
    chown -R jenkins:jenkins gradleCache
    chown -R jenkins:jenkins report
    chown -R jenkins:jenkins build
fi
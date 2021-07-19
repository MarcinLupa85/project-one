#!/bin/bash


mkdir -p report

./gradlew clean test -i -Pdriver_type="$browser" -Pbuild_tag=$tag --info

echo "END"


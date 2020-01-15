#!/bin/bash


mkdir -p report

gradle clean test -i -Pdriver_type="$browser" -Pbuild_tag=$tag

echo "END"
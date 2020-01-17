#!/bin/bash

while read -u 10 p; do
    if [ "$p" == "fail" ]; then
        exit 1
    else
        echo "$p"
    fi
done 10<report/result_file
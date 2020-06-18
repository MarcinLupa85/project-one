#!/usr/bin/env bash

docker build -t statoilfuelretail/engage-selenium-base:new -f TestsBaseDockerfile .
docker build -t statoilfuelretail/engage-selenium:new -f TestsDockerfile .
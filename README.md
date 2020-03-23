# A JaxRS Aries Testservice provided via Docker Container

## Travis and Docker build status

[![Build Master](https://img.shields.io/badge/branch-master-brightgreen.svg)](https://github.com/klibio/io.klib.aries.example/tree/master): 
[![Build Status Master branch](https://api.travis-ci.org/klibio/io.klib.aries.example.svg?branch=master)](https://travis-ci.org/klibio/io.klib.aries.example)

[![Docker Hub](https://img.shields.io/badge/Docker%20Hub-io.klib.aries.example-blue)](https://hub.docker.com/r/klibio/io.klib.aries.example/)

## Execute the docker image

1. start the docker container via

    `docker container run -p 8080:8080 klibio/io.klib.aries.example`

2. visit [http://localhost:8080](http://localhost:8080), you should see the JaxRS Aries Dashboard. 

3. call a specific path e.g. [http://localhost:8080/Jon](http://localhost:8080/Jon) should return "Hello Jon."


## building jar from the source

1. go into the main repository folder
2. start build process via `./gradlew export.Launch`
3. build result application jar is stored inside

    `./io.klib.aries.example/generated/distributions/executable`

## Building the image manually

1. Build the docker image from the main repository folder via 

    `docker build -t klibio/io.klib.aries.example:<tag> .`





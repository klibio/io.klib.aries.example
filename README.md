# A JaxRS Aries Testservice implemented into a Docker Container


## Travis and Docker

[![Build Master](https://img.shields.io/badge/branch-master-brightgreen.svg)](https://github.com/klibio/io.klib.aries.example/tree/master): 
[![Build Status Master branch](https://api.travis-ci.org/klibio/io.klib.aries.example.svg?branch=master)](https://travis-ci.org/klibio/io.klib.aries.example)

[![Docker Hub](https://img.shields.io/badge/Docker%20Hub-io.klib.aries.example-blue)](https://hub.docker.com/r/klibio/io.klib.aries.example/)

## Exporting the jar from the soruce

1. Go into the main repository folder
2. Use ./gradlew export.Launch
3. You will find the jar inside 

    ``<main repository folder>\io.klib.aries.example\generated\distributions\executable``

## Building the image manually

1. Build the docker image from the main repository folder via 

    ``docker build -t <your_username>/<your_repo>:<your_tag> .``

## Consuming the service

1. Start the docker container via

    ``docker container run -p 8080:8080 <your_username>/<your_repo>:<your_tag>``
2. Launch your internet browser and visit ``localhost:8080``, you should see the JaxRS Aries Dashboard. ``localhost:8080/Jon`` should return "Hello Jon."



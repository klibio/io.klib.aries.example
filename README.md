# io.klib.aries.example

Build the project with `./gradlew export.launch --no-daemon`, the project jar can be found in `io.klib.aries.example/generated/distributions/executable/launch.jar`.

You can launch a container with the dockerfile via `docker container run -p 8080:8080 --name<your_name> klibio/io.klib.aries.example:master-latest`

There are a variety of tags available:
* master_x86-64_latest
* master_arm32v7_latest
* develop_x86-64_latest

As you can see we provide one image for the standard x86-64 architecture and one for arm32v7.

To deploy this container to a kubernetes cluster we used four Raspberry Pis and followed [this](https://github.com/teamserverless/k8s-on-raspbian#pick-k3s) guide to set up the cluster with k3s. Don't forget to use the ARM based image.

Aries Service reachable under [localhost:8080](localhost:8080)

You can use the deployed service by adding a PATH: [localhost:8080/Jon](localhost:8080/Jon) will return "Hello Jon".


[![Build Master](https://img.shields.io/badge/branch-master-brightgreen.svg)](https://github.com/klibio/io.klib.aries.example/tree/master): 
[![Build Status Master branch](https://api.travis-ci.org/klibio/io.klib.aries.example.svg?branch=master)](https://travis-ci.org/klibio/io.klib.aries.example)

[![Docker Hub](https://img.shields.io/badge/Docker%20Hub-io.klib.aries.example-blue)](https://hub.docker.com/r/klibio/io.klib.aries.example/)
#!/bin/bash

sudo docker rm -f test
./gradlew clean export.launch
sudo docker build -t test .
sudo docker run --name test -d -p 8080:8080 --network testnetwork test:latest


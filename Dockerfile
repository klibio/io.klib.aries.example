FROM openjdk:8-alpine

RUN mkdir -p /usr/src/app
COPY generated/distributions/executable/launch.jar /usr/src/app
WORKDIR /usr/src/app
CMD java -jar launch.jar
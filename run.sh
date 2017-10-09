#!/usr/bin/env bash

set -e

echo "Build the project and docker images"
#mvn clean install
echo "Clean and install all maven projects"
mvn clean package -U -Dmaven.test.skip=true

# Export the active docker machine IP
export DOCKER_IP=$(docker-machine ip $(docker-machine active))

echo "DOCKER_IP is " 
echo $DOCKER_IP

# docker-machine doesn't exist in Linux, assign default ip if it's not set
#DOCKER_IP=${DOCKER_IP:-0.0.0.0}

# Remove existing containers
docker-compose stop
#docker-compose rm -f

echo "Start the config service first and wait for it to become available"
docker-compose up -d --build

echo  "Attach to the log output of the cluster"
docker-compose logs

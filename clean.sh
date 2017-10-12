#!/usr/bin/env bash

set -e

echo "Remove Network containers"


export DOCKER_IP=$(docker-machine ip $(docker-machine active))

echo "DOCKER_IP is " 
echo $DOCKER_IP

# docker-machine doesn't exist in Linux, assign default ip if it's not set
#DOCKER_IP=${DOCKER_IP:-0.0.0.0}

# Remove existing containers
docker rm -f core-node
docker rm -f full-node
docker rm -f config-node
docker rm -f zipkin-node
docker rm -f hystrix-node
docker rm -f turbine-node
docker rm -f eureka-node
docker rm -f mongo-node
docker rm -f admin-node
echo  "Attach to the log output of the cluster"
docker-compose logs

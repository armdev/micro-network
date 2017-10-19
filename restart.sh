#!/usr/bin/env bash

set -e

echo "Restarting all nodes"


docker restart frontend-node
docker restart admin-node
docker restart airline-node
docker restart full-node
docker restart core-node
docker restart hystrix-node
docker restart turbine-node
docker restart zipkin-node
docker restart eureka-node
docker restart config-node
docker restart mysql-node

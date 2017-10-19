# Spring cloud Micro Network

## Acknowledgement

Tested on Windows 10 using DockerToolbox

## RUN



```shell
./run.sh
```

Stop all containers:

```shell
docker stop $(docker ps -a -q)
```

Remove all containers :

```shell
docker rm $(docker ps -a -q)
```

Remove all images

```shell
docker rmi $(docker images -q)
```

Remove all images which has name none
```shell
docker rmi $(docker images | grep "^<none>" | awk "{print $3}")
```

Services

## Eureka node

http://192.168.99.100:8761/

## core-node

http://192.168.99.100:8585/swagger-ui.html 

## full-node

http://192.168.99.100:8686/swagger-ui.html

## airline-node

http://192.168.99.100:9090/swagger-ui.html

## frontend-node

http://192.168.99.100:9999/frontend-node/index.jsf

## turbine-node

http://192.168.99.100:8082/turbine.stream

## hystrix-node

http://192.168.99.100:8081/hystrix/

## Hystrix monitor turbine

http://192.168.99.100:8081/hystrix/monitor?stream=http%3A%2F%2F192.168.99.100%3A8082%2Fturbine.stream

For see hystrix monitor please do some clicks in http://192.168.99.100:8686/swagger-ui.html dummy API methods and switch to link

##

http://192.168.99.100:8081/hystrix/monitor?stream=http%3A%2F%2F192.168.99.100%3A8082%2Fturbine.stream

## Zipkin node 

This node will show logs from other nodes after you click core-node http://192.168.99.100:8585/swagger-ui.html API methods.

http://192.168.99.100:9411/

## Admin Node

http://192.168.99.100:1111/login.html

User admin
Password admin123

## Restart all nodes
./restart.sh 

## Benchmark

docker-compose -f  apache-benchmark/docker-compose.yml up

## Scale

1. docker service create --name frontend frontend-node
2. docker service scale frontend=2
3. docker ps -a
4. not tested fully
https://docs.docker.com/engine/reference/commandline/service_create/#parent-command

https://docs.docker.com/engine/swarm/swarm-tutorial/scale-service/










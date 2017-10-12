# micro-network
Spring cloud Network


# How to run?

cd to parent folder

./clean.sh

./run.sh


Tested on Windows 10 using DockerToolbox


# Usefull commands


# Stop all containers

docker stop $(docker ps -a -q)

# Remove all containers

docker rm $(docker ps -a -q)

# Remove all images

docker rmi $(docker images -q)


# Remove all images which has name none

docker rmi $(docker images | grep "^<none>" | awk "{print $3}")

Access links

Eureka node

http://192.168.99.100:8761/

core-node

http://192.168.99.100:8585/swagger-ui.html 

full-node

http://192.168.99.100:8686/swagger-ui.html

turbine-node

http://192.168.99.100:8082/turbine.stream

hystrix-node

http://192.168.99.100:8081/hystrix/

Hystrix monitor turbine

http://192.168.99.100:8081/hystrix/monitor?stream=http%3A%2F%2F192.168.99.100%3A8082%2Fturbine.stream

For see hystrix monitor please do some clicks in http://192.168.99.100:8686/swagger-ui.html dummy API methods and switch to link

http://192.168.99.100:8081/hystrix/monitor?stream=http%3A%2F%2F192.168.99.100%3A8082%2Fturbine.stream

Zipkin node will show logs from core-node after you click core node http://192.168.99.100:8585/swagger-ui.html dummy API methods.

http://192.168.99.100:9411/

Admin Tool Access
http://192.168.99.100:1111/login.html
User admin
Password admin123









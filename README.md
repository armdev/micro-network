# micro-network
Spring cloud Network

#How to run?

cd to parent folder

./clean.sh

./run.sh


Tested on Windows 10 using DockerToolbox


Usefull commands


#Stop all containers

docker stop $(docker ps -a -q)

# Remove all coontainers

docker rm $(docker ps -a -q)

# Remove all images

docker rmi $(docker images -q)


# Remove all images which has name <none> 

docker rmi $(docker images | grep "^<none>" | awk "{print $3}")
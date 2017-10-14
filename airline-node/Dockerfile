#FROM openjdk:8-jdk-alpine
FROM airhacks/java
COPY target/airline-node.jar /opt/airline-node.jar
ENTRYPOINT ["java","-Xmx512m", "-jar","/opt/airline-node.jar"]
EXPOSE 9090
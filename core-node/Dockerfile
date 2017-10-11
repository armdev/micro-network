#FROM openjdk:8-jdk-alpine
FROM airhacks/java
COPY target/core-node.jar /opt/core-node.jar
ENTRYPOINT ["java","-Xmx512m", "-jar","/opt/core-node.jar"]
EXPOSE 8585
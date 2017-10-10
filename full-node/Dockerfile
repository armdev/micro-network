#FROM openjdk:8-jdk-alpine
FROM airhacks/java
COPY target/full-node.jar /opt/full-node.jar
ENTRYPOINT ["java","-Xmx256m", "-jar","/opt/full-node.jar"]
EXPOSE 8686
#FROM openjdk:8-jdk-alpine
FROM airhacks/java
COPY target/core-node.jar /opt/core-ndocker-maode.jar
ENTRYPOINT ["java","-Xmx256m", "-jar","/opt/core-node.jar"]
EXPOSE 8585
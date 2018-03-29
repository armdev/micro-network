#FROM openjdk:8-jdk-alpine
FROM airhacks/java
COPY target/fullnode.jar /opt/fullnode.jar
ENTRYPOINT ["java","-Xmx512m", "-jar","/opt/fullnode.jar"]
EXPOSE 8686
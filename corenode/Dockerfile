#FROM openjdk:8-jdk-alpine
FROM airhacks/java
COPY target/corenode.jar /opt/corenode.jar
ENTRYPOINT ["java","-Xmx512m", "-jar","/opt/corenode.jar"]
EXPOSE 8585
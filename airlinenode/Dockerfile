#FROM openjdk:8-jdk-alpine
FROM airhacks/java
COPY target/airlinenode.jar /opt/airlinenode.jar
ENTRYPOINT ["java","-Xmx512m", "-jar","/opt/airlinenode.jar"]
EXPOSE 9090
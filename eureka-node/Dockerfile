#FROM openjdk:8-jdk-alpine
FROM airhacks/java
COPY target/eureka-node.jar /opt/eureka-node.jar
ENTRYPOINT ["java","-Xmx256m", "-jar","/opt/eureka-node.jar"]
EXPOSE 8761
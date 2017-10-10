#FROM openjdk:8-jdk-alpine
FROM airhacks/java
#COPY target/eureka-node.jar /opt/eureka-node.jar
#ENTRYPOINT ["java","-Xmx256m", "-jar","/opt/eureka-node.jar"]
#EXPOSE 8761
VOLUME /tmp
ADD target/eureka-node.jar /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8761
FROM airhacks/java
COPY target/frontendnode.jar /opt/frontendnode.jar
ENTRYPOINT ["java","-Xmx1024m", "-jar","/opt/frontendnode.jar"]
EXPOSE 9999

#FROM airhacks/java
#VOLUME /tmp
#ADD target/frontend-node.jar /frontend-node.jar
#RUN bash -c 'touch /frontend-node.jar'
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/frontend-node.jar"]
#EXPOSE 9999
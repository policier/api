FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ARG JAR_FILE
COPY target/productservice-2.0.0.RELEASE.jar /app.jar
EXPOSE 8080/TCP
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
COPY target/eureka-1.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8187
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]
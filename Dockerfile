FROM openjdk:8-jdk-alpine
LABEL maintainer="dpmdavemiller@gmail.com"
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/moviebuff-api-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} moviebuff-api.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/moviebuff.jar"]
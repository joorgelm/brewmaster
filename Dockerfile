FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/brewmaster-1.0.0-SNAPSHOT.jar

WORKDIR /opt/app

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]

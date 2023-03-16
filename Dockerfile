FROM khipu/openjdk17-alpine:latest
ARG JAR_FILE=build/libs/AeroParker.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]


FROM khipu/openjdk17-alpine:latest
ARG JAR_FILE=build/libs/AeroParker.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
ENV MY_SQL_URL=jdbc:mysql://127.0.0.1:3306/aero
ENV MY_SQL_PASS=plyWood!1701
ENV MY_SQL_USER=root

FROM openjdk:17-jdk-slim
LABEL authors="wajidali"

WORKDIR /app

COPY target/session-demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
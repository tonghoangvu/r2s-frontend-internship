# syntax=docker/dockerfile:1

FROM maven:3.8.4-openjdk-17-slim AS build
COPY pom.xml pom.xml
RUN mvn dependency:go-offline
COPY src/ src/
RUN mvn package -DskipTests && cp target/*.jar app.jar

FROM openjdk:17-alpine
WORKDIR /app
EXPOSE 8082
ENV ACTIVE_PROFILE = "dev"
COPY --from=build app.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=${ACTIVE_PROFILE}", "-jar", "/app/app.jar"]

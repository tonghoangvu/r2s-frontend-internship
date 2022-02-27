# syntax=docker/dockerfile:1
FROM openjdk:17-alpine
WORKDIR /app
EXPOSE 8082

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src
CMD ["./mvnw", "spring-boot:run"]

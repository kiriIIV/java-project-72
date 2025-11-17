FROM gradle:8.7-jdk21-alpine AS build
WORKDIR /app
COPY . .
RUN gradle shadowJar

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/app-1.0-SNAPSHOT-all.jar app.jar
EXPOSE 7070
CMD ["java", "-jar", "app.jar"]
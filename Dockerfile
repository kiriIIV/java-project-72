FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY . .
RUN ./gradlew shadowJar
EXPOSE 7070
CMD ["java", "-jar", "build/libs/app-1.0-SNAPSHOT-all.jar"]
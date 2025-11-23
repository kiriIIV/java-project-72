FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradlew .

RUN chmod +x gradlew

RUN ./gradlew dependencies --no-daemon

COPY src src
COPY config config

RUN ./gradlew clean build --no-daemon

EXPOSE 7070

RUN ./gradlew installDist --no-daemon

CMD ./build/install/app/bin/app
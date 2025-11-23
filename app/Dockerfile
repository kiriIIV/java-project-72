FROM gradle:8.12.1-jdk21

RUN groupadd -r nonroot && useradd -r -g nonroot nonroot

WORKDIR /app
RUN chown -R nonroot:nonroot /app

COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradlew .
COPY src src
COPY config config

RUN chmod +x gradlew

EXPOSE 7070

RUN ./gradlew installDist

USER nonroot
CMD ["./build/install/app/bin/app"]
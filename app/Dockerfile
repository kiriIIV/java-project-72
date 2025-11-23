FROM gradle:8.12.1-jdk21

RUN groupadd -r nonroot && useradd -r -g nonroot nonroot

WORKDIR /app
RUN chown -R nonroot:nonroot /app

COPY gradle gradle
COPY build.gradle.kts .
COPY config config
EXPOSE 7070

RUN ./gradlew installDist

USER nonroot
CMD ["./build/install/app/bin/app"]
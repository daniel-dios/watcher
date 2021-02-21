FROM gradle:6.8.2-jdk11 as builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN ./gradlew clean build

FROM openjdk:11.0.10-jdk
COPY --from=builder /home/gradle/src/build/libs/watcher-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
CMD ["java", "-jar", "app.jar"]
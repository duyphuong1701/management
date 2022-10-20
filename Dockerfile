FROM gradle:jdk11 as gradleimage
COPY . /home/gradle/source
WORKDIR /home/gradle/source
RUN gradle build

FROM openjdk:11-jre-slim
COPY --from=gradleimage /home/gradle/source/build/libs/*.jar /app/
WORKDIR /app
ENTRYPOINT ["java", "-jar", "management-0.0.1-SNAPSHOT-boot.jar"]
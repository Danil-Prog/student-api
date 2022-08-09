FROM openjdk:11-jre-slim-buster
VOLUME /tmp
ADD out/student-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
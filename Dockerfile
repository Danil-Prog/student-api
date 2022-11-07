FROM openjdk:11-jre-slim-buster
VOLUME /tmp
ADD out/artifacts/student-api.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
FROM eclipse-temurin:21-jdk
ARG JAR_FILE=build/libs/*.jar

WORKDIR /app
COPY ${JAR_FILE} app.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "app.jar"]
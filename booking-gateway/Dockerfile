FROM eclipse-temurin:21-jdk
ARG JAR_FILE=build/libs/*.jar

WORKDIR /app
COPY ${JAR_FILE} app.jar
EXPOSE 9080
ENTRYPOINT ["java", "-jar", "app.jar"]
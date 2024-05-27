FROM openjdk:17-slim
EXPOSE 8080
ARG JAR_FILE="*.jar"
ADD ${JAR_FILE} notification_service.jar
ENTRYPOINT ["java", "-jar", "notification_service.jar"]

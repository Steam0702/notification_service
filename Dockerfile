FROM adoptopenjdk:17-jre-hotspot
EXPOSE 8080
ARG JAR_FILE="*.jar"
ADD ${JAR_FILE} notification_service.jar
ENTRYPOINT ["java", "-jar", "notification_service.jar"]

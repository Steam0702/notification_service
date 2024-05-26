FROM adoptopenjdk:17-jre-hotspot
EXPOSE 8080
ADD ${JAR_FILE} notification_service.jar
ENTRYPOINT ["java", "-jar", "notification_service.jar"]

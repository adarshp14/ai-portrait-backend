FROM eclipse-temurin:23-jdk-alpine
VOLUME /tmp
COPY target/*.jar ai-image-generator-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/ai-image-generator-0.0.1-SNAPSHOT.jar"]

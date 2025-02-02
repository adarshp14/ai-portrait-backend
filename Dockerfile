###############################
# Stage 1: Build the application
###############################
FROM eclipse-temurin:23-jdk-alpine AS builder

# Install necessary build tools (curl, tar, bash)
RUN apk add --no-cache curl tar bash

# Install Maven manually
ENV MAVEN_VERSION=3.9.3
ENV MAVEN_HOME=/usr/share/maven
ENV PATH=${MAVEN_HOME}/bin:${PATH}
RUN mkdir -p ${MAVEN_HOME} \
    && curl -fsSL "https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz" \
    | tar -xzC ${MAVEN_HOME} --strip-components=1

# Set the working directory
WORKDIR /app

# Copy Maven configuration and source code
COPY pom.xml .
COPY src ./src

# Build the application (the JAR will be created in the target directory)
RUN mvn clean package -DskipTests

###############################
# Stage 2: Create the runtime image
###############################
FROM eclipse-temurin:23-jdk-alpine

# Define a temporary volume (if needed by your application)
VOLUME /tmp

# Set the working directory
WORKDIR /app

# Copy the generated JAR from the builder stage using your original JAR name
COPY --from=builder /app/target/*.jar ai-image-generator-0.0.1-SNAPSHOT.jar

# Expose the port (Render will set the PORT environment variable dynamically)
EXPOSE 8080

# Start the application using Render’s PORT (default to 8080 if PORT is not set)
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-8080} -jar ai-image-generator-0.0.1-SNAPSHOT.jar"]

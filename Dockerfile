# Base image
FROM openjdk:17-jdk-slim

# Set working directory in the container
WORKDIR /app

# Copy the built JAR file into the container
ARG JAR_FILE=build/libs/inhating-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

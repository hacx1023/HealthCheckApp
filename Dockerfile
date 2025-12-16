# Use official Java runtime as base image
FROM eclipse-temurin:17-jre
# Set working directory inside container
WORKDIR /app
# Copy the packaged JAR file into the container
COPY target/health-check-app-1.0-SNAPSHOT.jar app.jar
# Set the command to run your JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
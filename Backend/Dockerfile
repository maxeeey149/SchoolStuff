# Use a lightweight JDK runtime image
FROM eclipse-temurin:17-jre

# Set the working directory inside the container
WORKDIR /backend

# Copy the JAR file into the container
COPY backend.jar backend.jar

# Expose the default Spring Boot port (or any other port your app uses)
EXPOSE 9000

# Run the JAR file
CMD ["java", "-jar", "app.jar"]
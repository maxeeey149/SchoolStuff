# Use a lightweight JDK runtime image
FROM eclipse-temurin:17-jre

# Set the working directory inside the container
WORKDIR /target

# Copy the JAR file into the container
COPY target/backend.jar backend.jar

# Expose the default Spring Boot port (or any other port your app uses)
EXPOSE 9000

# Run the JAR file
CMD ["java", "-jar", "backend.jar"]
```dockerfile
# ================================
# Stage 1: Build the application
# ================================
FROM eclipse-temurin:17-jdk-jammy AS builder

WORKDIR /app

# Copy Maven project files
COPY pom.xml .

# Download dependencies first
# This improves Docker build caching
RUN apt-get update && apt-get install -y maven && \
    mvn dependency:go-offline -B && \
    rm -rf /var/lib/apt/lists/*

# Copy source code
COPY src ./src

# Build Spring Boot JAR
RUN mvn clean package -DskipTests


# ================================
# Stage 2: Run the application
# ================================
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copy the generated JAR from builder stage
COPY --from=builder /app/target/*.jar app.jar

# Render provides the PORT environment variable
EXPOSE 8080

# Start Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
```

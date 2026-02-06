# Build Stage
# Using Maven with Eclipse Temurin JDK 25
FROM maven:3.9-eclipse-temurin-25 AS build

WORKDIR /app

# Clone the repository
RUN git clone https://github.com/IrvinTM/pos.git .

# Build the application
RUN mvn clean package -DskipTests

# Run Stage
# Using Eclipse Temurin JDK 25 Runtime
FROM eclipse-temurin:25-jdk

WORKDIR /app

EXPOSE 8080

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]
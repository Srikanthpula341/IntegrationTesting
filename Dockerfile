#FROM openjdk:17.0.2-jdk-slim
#ARG JAR_FILE=target/*.jar
#WORKDIR /app
#COPY ${JAR_FILE} integration-testing-0.0.1.jar
#RUN jar ufe integration-testing-0.0.1.jar com.sockshop.IntegrationTestingApplicationTests
#ENTRYPOINT ["java", "-jar", "integration-testing-0.0.1.jar"]
#ENV PORT 8000
#EXPOSE $PORT
#HEALTHCHECK --interval=1m --timeout=3s CMD wget -q -T 3 -s http://localhost:8999
FROM openjdk:17.0.2-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Maven project file
COPY pom.xml .

# Copy the source code
COPY src ./src

# Run Maven build to download dependencies
RUN apt-get update && \
    apt-get install -y maven && \
    mvn test

# Set the entry point to run the tests
ENTRYPOINT ["mvn", "test"]

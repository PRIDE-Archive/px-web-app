# Build stage
FROM maven:3.3.9-jdk-8-alpine AS build-env

# Create app directory
WORKDIR /px-web-app

COPY src ./src
COPY pom.xml ./
COPY config/application.yml ./application.yml
RUN mvn clean package -DskipTests

# Package stage
FROM maven:3.3.9-jdk-8-alpine
WORKDIR /px-web-app
COPY --from=build-env /px-web-app/target/px-web-app.jar ./
ENTRYPOINT java ${JAVA_OPTS} -jar px-web-app.jar
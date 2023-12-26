# FROM maven:3.8.4-openjdk-17
# ARG build
# COPY . .
# RUN mvn clean package -DskipTests

# FROM openjdk:17.0.1-jdk-slim
# COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar
# EXPOSE 8080
# ENTRY ["java","-jar","demo.jar"]

FROM maven:3.8.4-openjdk-17
COPY . .
RUN mvn clean package -DskipTests
COPY target/demo-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]

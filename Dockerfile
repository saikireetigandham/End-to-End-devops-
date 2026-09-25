FROM eclipse-temurin:21-jre AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN  mvn clean package 
FROM eclipse-temurin:21-jre AS runtime
WORKDIR /app
COPY --from=builder /app/target/spring-boot-app-0.0.1-SNAPSHOT.jar ./spring-boot-app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "spring-boot-app.jar"]

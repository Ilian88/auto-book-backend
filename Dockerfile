FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY /build/libs/auto-book-rest-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "auto-book-rest-0.0.1-SNAPSHOT.jar"]
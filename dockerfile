FROM openjdk
WORKDIR /app
ARG JAR_FILE=build/libs/spring-boot-realworld-example-app-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /app/realworld.jar
ENTRYPOINT ["java", "-jar", "realworld.jar"]
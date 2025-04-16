FROM openjdk:17-oracle
LABEL authors="afa"
WORKDIR /app
COPY build/libs/*.jar myApp.jar
VOLUME /app/data
ENTRYPOINT ["java", "-jar", "myApp.jar"]
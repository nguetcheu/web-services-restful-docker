FROM eclipse-temurin:21

LABEL mentainer="dnguetcheu@gmail.com"

WORKDIR /app

COPY target/web-services-restful-0.0.1-SNAPSHOT.jar /app/springboot-restful-webservices.jar

ENTRYPOINT ["java", "-jar", "springboot-restful-webservices.jar"]
FROM maven:3.8.5-openjdk-17

WORKDIR /rides

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean
RUN mvn package -DskipTests

FROM openjdk:17-jdk

COPY /target/web-application-for-selling-cable-and-wire-products-0.0.1-SNAPSHOT.jar /web-app/launch-app.jar

ENTRYPOINT ["java","-jar","/web-app/launch-app.jar"]

EXPOSE 8080
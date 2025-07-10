FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-21.0.6-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:21.0.6-jdk

EXPOSE 8080

COPY --from=build /target/sorteioNumeros-0.0.1-SNAPSHOT.jar sorteio.jar

ENTRYPOINT ["java", "-jar", "sorteio.jar"]
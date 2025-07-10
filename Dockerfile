# Etapa de build
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app
COPY . .

RUN apt-get update && apt-get install -y maven
RUN mvn clean install

# Etapa de execução
FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY --from=build /app/target/sorteioNumeros-0.0.1-SNAPSHOT.jar sorteio.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "sorteio.jar"]

# --- Estágio 1: Build da Aplicação ---
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# --- Estágio 2: Criação da Imagem Final ---
# Usa uma imagem JRE (Java Runtime Environment) enxuta, que é menor e mais segura
# CORREÇÃO AQUI: Substituindo a imagem 'openjdk' pela 'eclipse-temurin'
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app
COPY --from=build /app/target/text-to-pdf-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
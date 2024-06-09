# Usar una imagen base de OpenJDK 17
FROM openjdk:17-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR
COPY target/gateway-store-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que se ejecuta la aplicación
EXPOSE 8080

# Ejecutar el archivo JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

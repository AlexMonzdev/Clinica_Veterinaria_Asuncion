# Usar una imagen oficial
FROM amazoncorretto:21-alpine-jdk


# Copiar el archivo JAR al contenedor
COPY target/ClinicaVeterinaria_Asuncion-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]

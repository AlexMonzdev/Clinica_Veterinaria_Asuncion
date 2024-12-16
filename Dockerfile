# Usar una imagen oficial
FROM amazoncorretto:21-alpine-jdk


# Copiar el archivo JAR al contenedor
COPY target/ClinicaVeterinaria_Asuncion-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto 8080 (si tu aplicación escucha en este puerto)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]

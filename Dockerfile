# Usa una imagen base de Amazon Corretto con Java 21
FROM amazoncorretto:21

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR desde el contexto de construcción al contenedor
COPY ClinicaVeterinaria_Asuncion-0.0.1-SNAPSHOT.jar /app/ClinicaVeterinaria_Asuncion.jar

# Expone el puerto que utilizará la aplicación
EXPOSE 8080

# Ejecuta la aplicación Java
CMD ["java", "-jar", "ClinicaVeterinaria_Asuncion.jar"]

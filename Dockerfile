# Usar una imagen oficial de OpenJDK 17
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR al contenedor
COPY target/ClinicaVeterinaria_Asuncion-0.0.1-SNAPSHOT.jar /app/ClinicaVeterinaria_Asuncion.jar

# Exponer el puerto 8080 (si tu aplicación escucha en este puerto)
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "ClinicaVeterinaria_Asuncion.jar"]

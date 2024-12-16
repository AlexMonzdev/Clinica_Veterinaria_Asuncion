# Usar una imagen de OpenJDK para Java
FROM openjdk:11-jre-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR desde el host al contenedor
COPY target/ClinicaVeterinaria_Asuncion-0.0.1-SNAPSHOT.jar /app/ClinicaVeterinaria_Asuncion-0.0.1-SNAPSHOT.jar

# Exponer el puerto en el que la aplicación escuchará (5432 o el puerto que uses)
EXPOSE 8080

# Comando para ejecutar la aplicación Java
CMD ["java", "-jar", "ClinicaVeterinaria_Asuncion-0.0.1-SNAPSHOT.jar"]

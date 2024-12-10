# Sistema de Gestión para Clínica Veterinaria

### 🏁 **Contexto General**

Margarita está a punto de abrir su clínica veterinaria y necesita un sistema para gestionar los datos de sus pacientes y sus tutores. Este sistema será esencial para mantener organizada toda la información de los animales atendidos y sus responsables.

En este primer sprint, nos enfocaremos en las funcionalidades más importantes del sistema: el **gestor de pacientes** y el **gestor de tutores**. Margarita quiere empezar con un sistema sencillo pero funcional, que permita registrar, buscar, listar, actualizar y eliminar tanto pacientes como tutores.

El sistema será implementado como una **API REST** desarrollada en **Java Spring Boot**, y los datos serán almacenados en una base de datos.


## 📍Caracteristicas
- [x] - Se conecta a una API real a través de JPA
- [x] - Configuración de JPA a través del back-end en Java
- [x] - Cada producto añadido en JPA recibe un ID único
- [x] - Los productos añadidos en la base de datos aparecen en el front-end, identificados por su nombre
- [x] - La eliminación y edición de productos en la base de datos se puede ver en el front-end
- [x] - CRUD probado con Postman
-------------------------------------------------
- [x] - Cambio a base de datos MySQL en Sprint 2
- [x] - Utilizar Clases DTO & Services
- [x] - Tests de Acceptación
- [x] - Tests Unitarios
- [x] - Export Postman Collections con Endpoints
- [x] - Gestor de Citas
- [x] - Estadísticas Generales
      

## Tecnologias Utilizadas


### <ins>Back End</ins>
- [x] <img src="https://img.shields.io/badge/Intellij Idea-000?logo=intellij-idea&style=for-the-badge"/> 

- [x] <img src= "https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>

- [x] <img src= "https://badgen.net/badge/icon/maven?icon=maven&label"/>


### <ins>Data & APIs</ins>

- [x] <img src= "https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white"/>

- [x] <img src= "https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white"/>

- [x] <img src= "https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white"/>

- [x] Dependencies: H2, Spring Web, JPA


### <ins>Misc</ins>

- [x] <img src="https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white"/>

- [x] <img src= "https://img.shields.io/badge/github-%23121011.svg?&style=for-the-badge&logo=github&logoColor=white"/>

- [x] <img src= "https://shields.io/badge/simple__diarizer-Trello-blue?logo=Trello&style=flat"/>

- [x] <img src= "https://img.shields.io/badge/Lucid-282C33?logo=lucid&logoColor=fff&style=for-the-badge"/>


## 🌈 Documentación Endpoints

### Diagram ER Database
![ER Diagram2](https://github.com/aSACo-FactoriaF5/ClinicaVeterinaria_Asuncion/blob/main/Images/ER%20Diagram2.png)

### Postman Collections
![Postman](https://github.com/aSACo-FactoriaF5/ClinicaVeterinaria_Asuncion/blob/main/Images/Postman%20Collections.png)


## Imagenes

### Database ER


### Front End Screenshot
![FrontEnd](https://github.com/aSACo-FactoriaF5/ClinicaVeterinaria_Asuncion/blob/main/Images/Inicio%20Frontend.png)


### **Diagrama Entidad Relacion**
![vet-asuncion_1](https://github.com/user-attachments/assets/29b1ca2f-803b-47ad-abe8-beab43e00b93)

### **Diagrama UML**
![uml](https://github.com/aSACo-FactoriaF5/ClinicaVeterinaria_Asuncion/blob/main/Images/UML%20Vet%20Clinic.drawio.png)


### **Vista Kanban**
![kanban](https://github.com/aSACo-FactoriaF5/ClinicaVeterinaria_Asuncion/blob/main/Images/Kanban%20View.png)


### **Vista Proyecto**
![project](https://github.com/aSACo-FactoriaF5/ClinicaVeterinaria_Asuncion/blob/main/Images/Project%20View.png)


## Endpoints Ejemplos

### **Registrar un guardian**

- **Método HTTP:** POST
- **URL: POST/guardian**
- **Request Body:**

```
{
  "name": "Alice Johnson",
  "email": "alice.johnson@email.com",
  "phone": "987654321",
  "address": "123 Meadow Lane"
}

```
- **Response Body:**

```
{
  "id": 1,
  "name": "Alice Johnson",
  "email": "alice.johnson@email.com",
  "phone": "987654321",
  "address": "123 Meadow Lane"
}

```
  

## Contributors
- **Carla Sanchez**
  [<img src="https://img.shields.io/badge/github-%23121011.svg?&style=for-the-badge&logo=github&logoColor=white" alt="GitHub" />](https://github.com/Carlassanchez24)
  [<img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn" />](https://www.linkedin.com/in/carla-sanchez24/)
  
- **Alex Monzon**
  [<img src="https://img.shields.io/badge/github-%23121011.svg?&style=for-the-badge&logo=github&logoColor=white" alt="GitHub" />](https://github.com/AlexMonzdev)
  [<img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn" />](https://www.linkedin.com/in/alexmonzon/)
  
- **Stefano Micciche**
  [<img src="https://img.shields.io/badge/github-%23121011.svg?&style=for-the-badge&logo=github&logoColor=white" alt="GitHub" />](https://github.com/StefanoMicciche)
[<img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn" />](https://www.linkedin.com/in/stefano-micciche-48949021b/)

- **Andreea Celmare**
  [<img src="https://img.shields.io/badge/github-%23121011.svg?&style=for-the-badge&logo=github&logoColor=white" alt="GitHub" />](https://github.com/andreeaclmr) [<img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn" />](https://www.linkedin.com/in/andreea-alina-celmare/)

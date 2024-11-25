# Sistema de Gestión para Clínica Veterinaria

### 🏁 **Contexto General**

Margarita está a punto de abrir su clínica veterinaria y necesita un sistema para gestionar los datos de sus pacientes y sus tutores. Este sistema será esencial para mantener organizada toda la información de los animales atendidos y sus responsables.

En este primer sprint, nos enfocaremos en las funcionalidades más importantes del sistema: el **gestor de pacientes** y el **gestor de tutores**. Margarita quiere empezar con un sistema sencillo pero funcional, que permita registrar, buscar, listar, actualizar y eliminar tanto pacientes como tutores.

El sistema será implementado como una **API REST** desarrollada en **Java Spring Boot**, y los datos serán almacenados en una base de datos.

# **Epic 1 - Inicio Proyecto**

**User Story 1**: Planteamiento de herramientas y documentación

1. API REST
2. Java Spring Boot H2
    - Definir las rutas básicas de la API (e.g., /pacientes, /tutores) y los métodos HTTP soportados (GET, POST, PUT, DELETE).
    - Crear controladores básicos para manejar las solicitudes HTTP.

**User Story 2:** Estudio individual de propuesta de stakeholder

**User Story 3:** Estudio de diagrama de clases

**User Story 4:** Estudio de tecnologías y base de datos.

**User story 5:** Documentación.

- Crear un documento README con información básica sobre el proyecto, como tecnologías utilizadas, estructura del proyecto, y cómo ejecutar la aplicación.

## Criterios de aceptación:

Se ha definido un conjunto de herramientas y tecnologías a utilizar en el proyecto, incluyendo:

- Lenguaje de programación: Java
- Framework: Spring Boot
- Base de datos: H2 (para desarrollo)
- Cada miembro del equipo ha revisado y comprendido la propuesta del stakeholder.
- Se ha creado un diagrama de clases UML que representa las entidades del sistema (paciente, tutor, etc.) y sus relaciones.

---

# **Epic 2: Gestión de Pacientes**

La Epic 2 tiene como objetivo centralizar la gestión de la información de los pacientes.

**User Story 1: Iniciar proyecto con Spring**

- Especificar la versión de Spring a utilizar y las dependencias adicionales necesarias (e.g., Spring Data JPA para la interacción con la base de datos).

**User Story 2: Creación de clases y estructura de carpetas**

- Definir una estructura de paquetes clara y coherente

**User story 3:** Registrar y gestionar toda la información de los pacientes.

- Nombre del paciente.
- Género del paciente (**Mujer**; **Hombre**)
- Nombre y apellido del paciente.
- Edad.
- Nro de identificación (Autogenerado)
- Tutor asociado (por ID)

**User story 4**: Buscar pacientes.

- Buscar pacientes por su nro de ID único.
- Ver todos los detalles del paciente, incluyendo el tutor asociado.

**User story 5**: Listar pacientes.

- Listar todos los pacientes registrados en el sistema.
- Mostrar información básica (**Nombre y apellido; Género**; **Tutor asociado** )

**User story 6**: Eliminar tutores.

- Permitir eliminar un paciente del sistema, asegurando que ya no esté disponible.

## Criterios de Aceptación

- **Base de datos:** Especificar el tipo de base de datos a utilizar (e.g., MySQL, PostgreSQL) y el esquema de la tabla de pacientes.
- **Tutor asociado:** Definir cómo se realizará la asociación entre el paciente y el tutor (e.g., mediante una llave foránea en la tabla de pacientes).
- **Número de identificación único:** Especificar el algoritmo de generación (e.g., UUID) y garantizar su unicidad.

---

# Epic 3 - Crear Gestor de Tutores

La Epic 3 tiene como objetivo centralizar la gestión de la información de los tutores.

**User story 1**: Los datos serán almacenados en una base de datos.

**User story 2**: Registrar y gestionar toda la información de los tutores.

- Nombre del tutor.
- Especie (**Perro** o **Gato**)
- Raza (Opcional y por defecto **desconocido**)
- Edad.
- Nro de identificación (Autogenerado)
- Paciente asociado (por ID)

**User story 3**: Buscar tutores.

- Buscar pacientes por su nro de ID único.
- Ver todos los detalles del tutor, incluyendo el paciente asociado.

**User story 4**: Listar tutores.

- Listar todos los tutores registrados en el sistema.
- Mostrar información básica (**Nombre; Especie**; **Paciente asociado** )

**User story 5**: Eliminar tutores.

- Permitir eliminar un paciente del sistema, asegurando que ya no esté disponible.

## Criterios de aceptación

- **Base de datos:** Los datos de los tutores se almacenarán en una tabla específica de la base de datos, relacionada con la tabla de pacientes mediante la clave foránea "paciente_id".
- **Integridad de datos:** Se implementarán mecanismos para garantizar la integridad de los datos, como la validación de campos obligatorios y la prevención de duplicados en el número de identificación del tutor.
- **Relación tutor-paciente:** Se debe definir claramente la relación entre un tutor y un paciente. ¿Un tutor puede tener múltiples pacientes? ¿Un paciente puede tener múltiples tutores?

---

# **Epic 4 - Crear entorno TDD**

La Epic 4 tiene como objetivo garantizar la calidad del código.

- Se ha seleccionado un framework de pruebas adecuado para el proyecto (ej: JUnit)
- Se ha definido una estructura de carpetas y paquetes clara para organizar las pruebas.
- Se han creado clases de prueba base para encapsular la lógica común de las pruebas.

## Criterios de aceptación:

- Se han creado clases de prueba para cada servicio de la capa de negocio.
- Se han escrito casos de prueba para verificar diferentes escenarios de entrada y salida.
- Se ha utilizado un estilo de codificación claro y conciso para las pruebas.
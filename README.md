# Proyectos para Prueba Técnica PersonalSoft

Este repositorio alberga dos proyectos fundamentales como parte de la prueba técnica para PersonalSoft. A continuación, se detalla cada proyecto junto con las tecnologías utilizadas.

## Proyecto API-Services

### Descripción
El proyecto **API-Services** es una aplicación **Spring Boot** en la versión **2.1.5.RELEASE**. Su objetivo principal es proporcionar servicios REST con operaciones para almacenar y recuperar datos. La aplicación integra autenticación básica de Spring y utiliza la especificación **JPA (Java Persistence API)** para la persistencia de datos.

### Tecnologías Utilizadas
- **Spring Boot 2.1.5.RELEASE**
- **JPA (Java Persistence API)**
- Autenticación Básica de Spring
- **MySQL** como base de datos
- **Lombok**
- **Maven**
- **Jersey** para consumir servicios REST

## Proyecto Web

### Descripción
El proyecto **Web** es una aplicación web construida sobre **JSF (JavaServer Faces)** y **PrimeFaces**. Esta aplicación consume los servicios proporcionados por el proyecto **API-Services**. Utiliza **EJB (Enterprise JavaBeans)** para realizar operaciones de eliminación de datos en cada tabla, siendo esta la única operación manejada a nivel de EJB en el proyecto web.

### Tecnologías Utilizadas
- **JSF 2 (JavaServer Faces)**
- **PrimeFaces 11**
- **EJB (Enterprise JavaBeans)**
- **Spring Security** para el acceso a la aplicación web
- **Payara 5** como servidor de aplicaciones
- **MySQL** como base de datos
- **Maven**

### Acceso a la Aplicación Web
- **Usuario:** bandesal
- **Contraseña:** 123

#### Autenticación para Servicios REST
- **Usuario:** admin
- **Contraseña:** admin

### Script base de Datos 
- **bandesalschema.sql**

### Data Sources Creado
- **jdbc/bandesaldb**

### Template Utilizado
- ***avalon-theme*** 
- ***avalon-theme-4.1.0.jar***
### Collection Postman
- ***Bandesal-Api.postman_collection.json*** 

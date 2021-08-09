# Laboratorio número 1 TBD: Aplicaciones de coordinación y voluntariado 
Repositorio de proyecto de laboratorio 1 para Taller de Base de Datos correspondiente al Grupo 1

## Base de datos

Ejecutar el script dbCreate.sql que se encuentra en la carpeta db del del repositorio para crear las tablas de la base de datos. Luego, ejecutar el script loadData.sql para cargar los datos dump o faker.

## Backend
Antes de iniciar su ejecución, es necesario tener instalado java-11-open-jdk

Para iniciarlo, se debe escribir el siguiente comando en la terminal, dentro de la carpeta backend
```
$ ./gradlew bootrun
```
El backend estará corriendo en http://localhost:8082/

Las consultas se pueden realizar de la siguiente manera:

Crear una nueva tabla (reemplazar coordinator por los demás nombres de las tablas)
```
POST /coordinator/
```
Obtener todos los coordinadores
```
GET /allCoordinator
```
Obtener un coordinador dado su id
```
GET /coordinators/5
```
Editar un coordinador dado su id
```
PUT /coordinators/5
```
Borrar un coordinador dado su id
```
DELETE /coordinator/5
```

## Frontend

Para cargar las dependencias, es necesario ejecutar, dentro de la carpeta frontend
```
$ npm install
```
Luego, ejecutar (teniendo instalado vue.js previamente)
```
$ npm run serve
```
El frontend estará corriendo en http://localhost:8080/


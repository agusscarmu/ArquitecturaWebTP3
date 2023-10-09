# Arquitectura Web - TP3 - SpringBoot

## Registro de Estudiantes - Ejercicio Integrador

Este proyecto se centra en el diseño de un registro de estudiantes con la siguiente información: nombres, apellido, edad, género, número de documento, ciudad de residencia, número de libreta universitaria, carreras en las que están inscritos, antigüedad en cada una de esas carreras y si se graduaron o no. El ejercicio integrador se divide en varias funcionalidades implementadas como servicios REST.

#### Base de datos utilizada
- MySQL
- Nombre de la base de datos: TercerEntrega


## Funcionalidades y Servicios REST

### a) Dar de Alta un Estudiante

- Método HTTP: POST
- Endpoint: `/estudiantes/nuevo`
- Descripción: Permite agregar un nuevo estudiante al registro utilizando un JSON en el cuerpo de la solicitud.

### b) Matricular un Estudiante en una Carrera

- Método HTTP: POST
- Endpoint: `/inscripciones/matricular`
- Descripción: Permite matricular a un estudiante en una carrera específica utilizando un JSON en el cuerpo de la solicitud.

### c) Recuperar Todos los Estudiantes con Ordenamiento por Dni

- Método HTTP: GET
- Endpoint: `/estudiantes` -> Ordena por DNI
- Endpoint alternativo: `/estudiantes/orderBy/{orden}` -> Orden especifico (puede ser por apellido, edad, libreta, ciudad) 
- Descripción: Recupera todos los estudiantes del registro y permite especificar un criterio de ordenamiento simple, como ordenar por dni, apellido, edad, libreta, ciudad, etc.

### d) Recuperar un Estudiante por Libreta Universitaria

- Método HTTP: GET
- Endpoint: `/estudiantes/getByLibreta/{libreta}`
- Descripción: Permite obtener un estudiante en base a su número de libreta universitaria.

### e) Recuperar Todos los Estudiantes por Género

- Método HTTP: GET
- Endpoint: `/estudiantes/genre/{genero}`
- Descripción: Permite filtrar y recuperar todos los estudiantes en base a su género (Masculino o Femenino).

### f) Recuperar Carreras con Estudiantes Inscriptos Ordenados por Cantidad

- Método HTTP: GET
- Endpoint: `/carreras/inscriptos`
- Descripción: Devuelve una lista de carreras con estudiantes inscritos, ordenada por la cantidad de estudiantes inscritos en cada una.

### g) Recuperar Estudiantes de una Carrera por Ciudad de Residencia

- Método HTTP: GET
- Endpoint: `/inscripciones/filter/{ciudad}/{idCarrera}`
- Descripción: Permite filtrar y recuperar estudiantes de una determinada carrera, filtrados por ciudad de residencia.

### h) Generar un Reporte de Carreras con Inscripciones y Egresados por Año

- Método HTTP: GET
- Endpoint: `/inscripciones/reporte`
- Descripción: Genera un informe de las carreras que incluye información sobre inscriptos y egresados por año. Las carreras se ordenan alfabéticamente, y los años se presentan de manera cronológica.
## Uso de los Endpoints

Cada endpoint se puede utilizar enviando solicitudes HTTP al servidor con las rutas y los métodos correspondientes. Para los endpoints que requieren datos en el cuerpo de la solicitud, asegúrate de utilizar un formato JSON válido.

A continuación, se muestra unos ejemplos de solicitud utilizando Postman:

**Ejemplo de solicitud POST para dar de alta un estudiante:**

- Método: POST
- URL: `http://localhost:8080/estudiantes/nuevo`
- Cuerpo de la solicitud (JSON):

```json
{
    "dni": 123456789,
    "libretaUniversitaria": 987654321,
    "nombre": "Juan",
    "apellido": "Pérez",
    "edad": 25,
    "genero": "Masculino",
    "ciudad": "Ciudad Ejemplo"
}
```

**Ejemplo de solicitud POST para matricular un estudiante a una carrera:**

- Método: POST
- URL: `http://localhost:8080/inscripciones/matricular`
- Cuerpo de la solicitud (JSON):

```json
{
    "dni": 123456789,
    "libretaUniversitaria": 987654321,
    "idCarrera": 1, 
    "antiguedad": 1,
    "anioInscripcion": 2023
}
```

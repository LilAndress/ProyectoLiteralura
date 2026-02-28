📚 Literalura

Literalura es una aplicación de consola desarrollada con Java + Spring Boot + PostgreSQL que permite buscar libros desde la API pública de Gutendex y almacenarlos en una base de datos local.

El sistema permite consultar libros guardados, filtrarlos por idioma y mostrar estadísticas básicas.

🚀 Tecnologías utilizadas

Java 17+

Spring Boot

Spring Data JPA

PostgreSQL

Hibernate

Jackson (mapeo JSON)

API: https://gutendex.com/

⚙️ Funcionalidades

🔎 Buscar libro por título (consume la API Gutendex)

📚 Listar todos los libros guardados

🌎 Listar libros por idioma

📊 Mostrar cantidad de libros en inglés

📊 Mostrar cantidad de libros en español

🗄️ Modelo de datos
📘 Libro

Título

Idioma

Número de descargas

Autor

✍️ Autor

Nombre

Año de nacimiento

Año de fallecimiento

Relación:
Un libro tiene un autor y un autor puede tener varios libros.

🔌 Configuración de Base de Datos

En application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=postgres
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
🧠 Cómo funciona

Se realiza una búsqueda por título en la API Gutendex.

Se toma el primer resultado.

Se mapean los datos JSON a objetos Java usando Jackson.

Se guardan Libro y Autor en PostgreSQL.

Se pueden realizar consultas y estadísticas usando Spring Data JPA.

▶️ Ejecución

Al ejecutar la aplicación se muestra un menú interactivo en consola:

1 - Buscar libro por título
2 - Listar todos los libros
3 - Listar libros por idioma
4 - Cantidad de libros en inglés
5 - Cantidad de libros en español
0 - Salir
🎯 Objetivo del proyecto

Practicar:

Consumo de APIs con HttpClient

Manejo de HttpRequest y HttpResponse

Mapeo JSON con Jackson

Persistencia con Spring Data JPA

Relaciones entre entidades

Consultas derivadas

Uso de Streams para estadísticas

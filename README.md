# 🛍️ RopaPlus - Backend API

Este repositorio contiene la **API RESTful** para la plataforma de comercio electrónico **RopaPlus**. Desarrollada con **Java** y **Spring Boot**, gestiona la lógica de negocio, la persistencia de datos y la seguridad básica del sistema.

## 🚀 Tecnologías Utilizadas

* **Java:** JDK 17
* **Framework:** Spring Boot 3.5.7
* **Base de Datos:** MySQL
* **ORM:** Spring Data JPA (Hibernate)
* **Herramientas:** Maven, Lombok
* **Documentación:** SpringDoc OpenAPI (Swagger UI)

## 📋 Prerrequisitos

Antes de ejecutar este proyecto, asegúrate de tener instalado:

1.  **Java Development Kit (JDK) 17** o superior.
2.  **Maven** (o usar el wrapper `mvnw` incluido).
3.  **MySQL Server** corriendo en el puerto `3306`.

## ⚙️ Configuración de la Base de Datos

1.  Crea una base de datos en MySQL llamada `tienda_ropa_db` (o el nombre configurado en `application.properties`).
2.  Verifica las credenciales en `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/tienda_ropa_db?serverTimezone=UTC
    spring.datasource.username=root
    spring.datasource.password=tu_contraseña
    ```
3.  **Datos Iniciales:** Ejecuta el siguiente script SQL para insertar las categorías base y el administrador:
    ```sql
    INSERT INTO categorias (nombre, descripcion) VALUES 
    ('Zapatillas', 'Calzado técnico y urbano'),
    ('Ropa Deportiva', 'Indumentaria técnica'),
    ('Accesorios', 'Complementos deportivos'),
    ('Training', 'Equipamiento de entrenamiento');

    -- Usuario Admin (Pass: admin123)
    INSERT INTO usuarios (nombre_completo, email, password, rol, activo, fecha_registro) 
    VALUES ('Super Admin', 'admin@ropaplus.com', 'admin123', 'ADMIN', 1, NOW());
    ```

## 🛠️ Instalación y Ejecución

1.  **Clonar el repositorio:**
    ```bash
    git clone <URL_DEL_REPO_BACKEND>
    cd tienda-ropa-backend
    ```

2.  **Instalar dependencias:**
    ```bash
    ./mvnw clean install
    ```

3.  **Ejecutar la aplicación:**
    ```bash
    ./mvnw spring-boot:run
    ```
    La aplicación iniciará en `http://localhost:8080`.

## 📚 Documentación de API (Swagger)

Una vez iniciada la aplicación, puedes explorar y probar todos los endpoints interactivos en:

👉 **[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)**

### Endpoints Principales:
* `POST /api/usuarios/login`: Autenticación de usuarios.
* `POST /api/usuarios/registro`: Registro de nuevos clientes.
* `GET /api/productos`: Catálogo público de productos.
* `POST /api/productos`: Creación de productos (Requiere JSON con categoría y género).

## 👥 Equipo de Desarrollo

* **Adolfo Medina** - Backend Developer

---

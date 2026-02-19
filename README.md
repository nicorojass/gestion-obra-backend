# 🏗️ Gestión de Obras - Backend SaaS

Backend desarrollado en **Spring Boot** para un sistema de gestión de obras de construcción.

El objetivo del proyecto es administrar obras, controlar materiales utilizados y generar certificados de avance con impacto financiero, siguiendo una arquitectura moderna orientada a un futuro frontend web.

---

## 🚀 Funcionalidades principales

### ✅ Gestión de Obras
- Crear, editar, eliminar y listar obras
- Obtener detalle por ID
- Consultar materiales y certificados asociados a una obra

### ✅ Gestión de Materiales
- CRUD completo de materiales
- Control de stock:
  - Cantidad estimada
  - Cantidad acopiada
  - Cantidad en proveedor
  - Cantidad consumida
- Asociación directa a una obra

### ✅ Certificados de Avance
- Generación de certificados por obra
- Registro de materiales utilizados en cada certificado
- Cálculo automático del monto total certificado
- Validación de consumo (no se puede consumir más que lo disponible)

---

## 🛠️ Tecnologías utilizadas

- Java 21
- Spring Boot 4
- Spring Data JPA (Hibernate)
- MySQL
- Bean Validation (Jakarta Validation)
- Lombok
- Arquitectura REST + DTOs + Mapper manual

---

## 📌 Arquitectura del Proyecto

El backend está organizado siguiendo buenas prácticas:

- **Controllers** → Exponen endpoints REST
- **DTOs** → Contratos limpios para frontend
- **Services** → Lógica de negocio
- **Repositories** → Persistencia con JPA
- **Mapper** → Conversión Entity ↔ DTO
- **Validaciones** → Con Bean Validation
- **Relaciones** → Modelado real de dominio

---

## 📂 Entidades principales

### Obra
- nombre
- ubicación
- descripción

### Material
- tipo (enum)
- unidad de medida (enum)
- cantidades (estimada, acopiada, consumida, proveedor)
- precio unitario

### CertificadoAvance
- fecha automática
- descripción del trabajo
- porcentaje de avance
- monto total calculado
- materiales utilizados (tabla intermedia)

---

## 🔗 Endpoints disponibles

### Obras
| Método | Endpoint |
|-------|----------|
| GET | `/api/obras` |
| GET | `/api/obras/{id}` |
| POST | `/api/obras` |
| PUT | `/api/obras/{id}` |
| DELETE | `/api/obras/{id}` |
| GET | `/api/obras/{id}/materiales` |
| GET | `/api/obras/{id}/certificados` |

### Materiales
| Método | Endpoint |
|-------|----------|
| GET | `/api/materiales` |
| GET | `/api/materiales/{id}` |
| POST | `/api/materiales` |
| PUT | `/api/materiales/{id}` |
| DELETE | `/api/materiales/{id}` |

### Certificados de Avance
| Método | Endpoint |
|-------|----------|
| GET | `/api/certificados-avance` |
| GET | `/api/certificados-avance/{id}` |
| GET | `/api/certificados-avance/{id}/materiales` |
| POST | `/api/certificados-avance` |
| DELETE | `/api/certificados-avance/{id}` |

---

## ⚙️ Instalación y ejecución local

### 1. Clonar repositorio

```bash
git clone https://github.com/tuusuario/gestion-obras-backend.git
cd gestion-obras-backend
```

### 2. Configurar base de datos MySQL

Crear una base llamada:
```bash
CREATE DATABASE db_gestion_obra;
```

Configurar en application.properties:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/db_gestion_obra
spring.datasource.username=root
spring.datasource.password=tu_password

spring.jpa.hibernate.ddl-auto=update
```

### 3. Ejecutar el proyecto
```bash
mvn spring-boot:run
```

## 📈 Próximos pasos (Roadmap)

- JWT Authentication + Roles (Admin / Jefe de Obra / Inversor)
- Dashboard financiero por obra
- Paginación y filtros avanzados
- Documentación Swagger OpenAPI
- Deploy con Docker

## 👨‍💻 Autor

Proyecto desarrollado por Nico como parte de un sistema SaaS completo para gestión de obras.
📌 Backend Developer en formación con enfoque en Spring Boot + Arquitectura profesional.

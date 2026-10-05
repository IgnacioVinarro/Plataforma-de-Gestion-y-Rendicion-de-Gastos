## Tecnologías y versiones

Versiones utilizadas en este proyecto:

- **Frontend:** Angular 22.2.x; Angular CLI del proyecto `^22.2.1`.
- **Herramientas de frontend:** Node.js `22.23.3`; npm `10.9.9`.
- **Backend:** Java / JDK `21.0.12.1`; Spring Boot `4.1.1`.
- **Base de datos:** MySQL Server `8.4.11`.
- **Control de versiones:** Git `2.55.0`.

### Extensiones opcionales de VS Code

- Extension Pack for Java
- Spring Boot Extension Pack
- Angular Language Service

## Cómo levantar el proyecto en Windows

### 1. Instalar los requisitos

Instalar:

- JDK de Java 21.
- Node.js `22.23.3`.
- MySQL Community Server `8.4.11`.
- Git.

Descargas oficiales:

- [JDK de Java 21](https://www.oracle.com/latam/java/technologies/downloads/#java21)
- [Node.js 22.23.3](https://nodejs.org/en/download/archive/v22.23.3)
- [MySQL Community Server 8.4](https://dev.mysql.com/downloads/mysql/)
- [Git](https://git-scm.com/)

No es necesario instalar Maven por separado: el backend incluye Maven Wrapper. Tampoco hace falta instalar Angular CLI globalmente: npm instalará la versión definida en el proyecto.

### 2. Clonar el repositorio

Abrir PowerShell en la carpeta donde se guardará el proyecto y ejecutar:

```powershell
git clone https://github.com/IgnacioVinarro/Plataforma-de-Gestion-y-Rendicion-de-Gastos.git
cd Plataforma-de-Gestion-y-Rendicion-de-Gastos
```

### 3. Crear la base de datos y el usuario local

Abrir la consola de MySQL desde PowerShell:

```powershell
& "C:\Program Files\MySQL\MySQL Server 8.4\bin\mysql.exe" -u root -p
```

Ingresar la contraseña de `root` definida al configurar MySQL. En la consola de MySQL, ejecutar estas sentencias. Reemplazar `REEMPLAZAR_POR_UNA_CLAVE_LOCAL` por una contraseña local elegida para el usuario de la aplicación:

```sql
CREATE DATABASE gastos_db
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_0900_ai_ci;

CREATE USER 'gastos_app'@'localhost'
    IDENTIFIED BY 'REEMPLAZAR_POR_UNA_CLAVE_LOCAL';

GRANT ALL PRIVILEGES ON gastos_db.* TO 'gastos_app'@'localhost';
```

La contraseña elegida debe coincidir con `DB_PASSWORD` en el archivo `.env`. No guardar contraseñas reales en este README ni subirlas al repositorio.

### 4. Preparar la configuración local

Desde la raíz del repositorio, crear `.env` a partir de la plantilla:

```powershell
Copy-Item .env.example .env
```

Abrir `.env` en VS Code y reemplazar `DB_PASSWORD` por la contraseña local asignada a `gastos_app`.

`.env` contiene datos propios de cada computadora y no se sube a Git. `.env.example` es una plantilla compartible con valores de ejemplo.

### 5. Iniciar el backend

Abrir una terminal en la raíz del repositorio y ejecutar:

```powershell
cd backend\gastos-api
.\mvnw.cmd spring-boot:run
```

Dejar esta terminal abierta mientras se usa la aplicación.

### 6. Iniciar el frontend

Abrir una segunda terminal en la raíz del repositorio y ejecutar:

```powershell
cd frontend\gastos-web
npm.cmd ci
npm.cmd start
```

Dejar también esta terminal abierta. El frontend y el backend son dos procesos separados.

### 7. Comprobar la aplicación

- Abrir [http://localhost:4200](http://localhost:4200). Debe aparecer la página **Plataforma de Gastos**.
- Abrir [http://localhost:8080/api/salud](http://localhost:8080/api/salud). Debe responder:

```json
{"estado":"ok"}
```
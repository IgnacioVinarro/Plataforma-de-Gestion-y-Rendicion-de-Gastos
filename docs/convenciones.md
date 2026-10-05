# Convenciones de trabajo

## Ramas

- `main` contiene la versión estable del proyecto.
- Cada tarea se desarrolla en una rama separada.
- El formato es `PDGYRG-XX-descripcion-corta`, usando la clave de Jira de la tarea.
- La descripción va en minúsculas, sin espacios ni acentos.

Ejemplo: `PDGYRG-48-trabajo-control-automatico`.

## Commits

Los mensajes siguen el formato `tipo: descripción breve`.

Tipos permitidos:

- `feat`: agrega una funcionalidad.
- `fix`: corrige un problema.
- `chore`: realiza tareas de mantenimiento o configuración.
- `docs`: modifica documentación.
- `refactor`: reorganiza código sin cambiar su comportamiento.

## Idioma y nombres

Los nombres creados para el dominio del sistema se escriben en español y no se mezclan con nombres en inglés.

- Tablas: minúsculas.
- Variables y funciones: español y `camelCase`.
- Clases: español y `PascalCase`.

Se mantienen sin traducir los nombres exigidos por Java, Spring, Angular y otras herramientas.

## Pull requests

- Todo cambio se propone mediante un pull request dirigido a `main`.
- Cada pull request necesita al menos una revisión aprobada.
- El control automático de CI debe finalizar correctamente antes de integrar el cambio.
- No se suben cambios directamente a `main`.
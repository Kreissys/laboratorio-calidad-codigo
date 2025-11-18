#  Laboratorio N°14: Pruebas Estáticas e Integración Continua

> **Curso:** Construcción y Pruebas de Software | **Ciclo:** IV | **Fecha:** 17/11/2025  
> **Integrantes:** [Carlos Alberto LLano Flores] - [Jimenez Araos Sergio]

---

##  1. Problemas Detectados

**Checkstyle identificó 31 violaciones:**

| Categoría | % | Problemas Principales |
|-----------|---|-----------------------|
| **Documentación** | 40% | Falta Javadoc, `package-info.java` ausente, sin `@param`/`@return` |
| **Diseño** | 25% | Campo público, lista sin genéricos, constructor público |
| **Calidad** | 20% | Parámetros no `final`, método confuso `x()`, código duplicado |
| **Formato** | 15% | Líneas >80 chars, espacios finales, sin salto de línea |

---

## ✅ 2. Cambios Realizados

### Documentación
-  Javadoc completo en clases/métodos con `@param` y `@return`
-  Archivo `package-info.java` creado

### Encapsulación
-  Campo privado `lastErrorMessage` con getter
-  Lista tipada: `List<String>`
-  Constructor privado en clase utilitaria `Main`

### Calidad del Código
-  Parámetros marcados como `final`
-  Método renombrado: `x()` → `calculateStringLength()`
-  Validación null: `username == null ||`
-  Lógica email corregida: `&&` → `||`
-  Código duplicado eliminado

### Formato
-  Líneas <80 caracteres
-  Sin espacios finales
-  Salto de línea al final

---

##  3. Conclusiones

### Detección Temprana
Las pruebas estáticas identifican errores **antes de ejecutar**, previniendo `NullPointerException` y otros bugs.

### Mantenibilidad
Código documentado reduce errores futuros y facilita colaboración entre desarrolladores.

### Automatización CI/CD
GitHub Actions garantiza **calidad consistente** sin intervención manual en cada commit.

### Prevención de Deuda Técnica
Corregir problemas de diseño tempranamente evita bugs críticos en producción.

### Colaboración
Forks + Pull Requests + análisis estático = **revisión objetiva** enfocada en lógica de negocio.

### Estándares
Checkstyle asegura conformidad con **Google Java Style Guide**, facilitando integración de equipos.

---

## 📦 Recursos del Proyecto

**Repositorio:** [`github.com/[Kreissys]/laboratorio-calidad-codigo`](https://github.com/Kreissys/laboratorio-calidad-codigo)  
**Fork:** [`github.com/[SerJimenez1]/laboratorio-calidad-codigo`](https://github.com/Kreissys/laboratorio-calidad-codigo-2)  
**Pull Request:** [#1](https://github.com/Kreissys/laboratorio-calidad-codigo/pull/1)

**Pipeline CI:** ![Build Status](https://img.shields.io/badge/build-passing-brightgreen) `✅ 0 violaciones`

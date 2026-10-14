# ClinicaVeterinaria

Proyecto Java Maven para practicar refactoring con principios SOLID en un taller colaborativo.

El sistema funciona desde el inicio, pero contiene violaciones intencionales de SRP, OCP, LSP, ISP y DIP. La idea es que cada integrante refactorice una zona del código sin romper la ejecución.

## Setup en 5 minutos


Compilar con Maven. Salida esperada:

```text
=== ClinicaVeterinaria funcionando ===
```

## Estructura del proyecto

```text
src/main/java/clinicaveterinaria/
├── Main.java
├── interfaces/
│   ├── IAnimal.java
│   ├── IBaseDatos.java
│   ├── IServicioClinica.java
│   ├── ITratamiento.java
│   └── IVeterinarioService.java
├── model/
│   ├── Mascota.java
│   ├── Veterinario.java
│   ├── Cita.java
│   ├── Tratamiento.java
│   ├── Factura.java
│   └── clases auxiliares para animales y enums
├── repository/
│   ├── BaseDatos.java
│   └── DirectoBaseDatos.java
└── service/
    ├── ReservaService.java
    ├── DiagnosticoService.java
    ├── FacturacionService.java
    ├── ReporteService.java
    └── servicios CRUD y clases con violaciones intencionales
```

## Trabajo del taller

- Integrante 1: refactorizar SRP.
## ✅ Checklist de Validación

| Criterio | Estado | Observación |
| :--- | :---: | :--- |
| **El proyecto compila** | **Sí** | Todo el código refactorizado mantiene la integridad de tipos e interfaces. |
| **Veterinario ya no reserva, diagnostica, factura ni reporta** | **Sí** | Las responsabilidades operativas y de negocio se delegaron a sus respectivos servicios (`ReservaService`, `DiagnosticoService`, `FacturacionService`, `ReporteService`). |
| **La funcionalidad del Main se mantiene** | **Sí** | El flujo de ejecución original sigue intacto mediante la orquestación de servicios. |
| **Los nombres de servicios son claros** | **Sí** | Cada clase de servicio refleja explícitamente su único propósito funcional. |

---

## 💬 Preguntas de Discusión

### 1. ¿Cuántas razones para cambiar tenía `Veterinario` antes del refactoring?
Antes de la refactorización, la clase/concepto de `Veterinario` acumulaba **al menos 5 razones distintas para cambiar** (violando el *Principio de Responsabilidad Única - SRP*):
1. Cambios en la gestión de datos propios del veterinario (nombre, especialidad, disponibilidad).
2. Cambios en la lógica de agendamiento o reserva de citas.
3. Cambios en la emisión o formato de diagnósticos y tratamientos.
4. Cambios en los cálculos de cobro, tarifas o facturación de atenciones.
5. Cambios en la generación o diseño de reportes clínicos y estadísticos.

---

### 2. ¿Qué ganamos al separar modelo y servicios?
* **Alta cohesión y bajo acoplamiento:** Los modelos de datos (`Mascota`, `Veterinario`, `Factura`) se convierten en entidades puras que solo representan la información del dominio, mientras que las reglas de negocio viven en los servicios.
* **Mantenibilidad y legibilidad:** Al modificar una regla de negocio (ej. cómo se calcula una factura), no se corre el riesgo de romper la estructura de la entidad ni otras partes del sistema.
* **Reutilización de código:** Los servicios pueden ser reutilizados por múltiples componentes sin depender de una sola entidad concreta.
* **Facilidad de pruebas unitarias (Testing):** Permite probar la lógica de un servicio aislando sus dependencias mediante *mocks* o interfaces sin necesidad de depender de implementaciones concretas.

---

### 3. ¿Qué clase debería cambiar si mañana cambia el formato del reporte?
Debería cambiar únicamente **`ReporteService`** (o `GestorReportesClinica`). Gracias a la aplicación de SRP, los cambios en el formato de salida, diseño o plantilla de presentación de reportes no afectan a la persistencia de datos (`BaseDatos`), a la entidad `Veterinario`, ni a los servicios de facturación o citas.
- Integrante 2: refactorizar OCP.
- Integrante 3: refactorizar LSP.
- Integrante 4: refactorizar ISP y DIP.

Lee `guia.md` para instrucciones, checklists y preguntas de discusión.

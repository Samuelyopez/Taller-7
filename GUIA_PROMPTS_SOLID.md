# 🎯 Guía Maestra: Prompts para Refactorización SOLID

Esta guía contiene los prompts optimizados para transformar un código monolítico en una arquitectura limpia, paso a paso, utilizando Inteligencia Artificial (como Antigravity).

---

## 🟢 S - Single Responsibility Principle (SRP)
**Objetivo:** Separar la lógica de negocio de la interfaz de usuario y las validaciones.

> **Prompt:** 
> "Refactoriza esta clase aplicando el Principio de Responsabilidad Única (SRP). 
> 1. Extrae la lógica matemática a un servicio independiente.
> 2. Crea manejadores separados para la entrada de datos (Input) y la salida (Output).
> 3. Aplica DDD: Crea un 'Value Object' llamado Operand que valide las reglas del dominio (ej. no números negativos para raíces) antes de ser usado por el servicio."

---

## 🟡 O - Open/Closed Principle (OCP)
**Objetivo:** Hacer que el sistema sea extensible sin modificar el código fuente existente.

> **Prompt:**
> "Aplica el principio Open/Closed para eliminar los bloques 'switch' o 'if/else' de las operaciones. 
> 1. Define interfaces para las operaciones (ej. BinaryOperation y UnaryOperation).
> 2. Crea una clase independiente para cada operación (Suma, Resta, etc.).
> 3. Implementa un sistema de registro dinámico (usando un Map) en el motor principal para que podamos añadir nuevas operaciones simplemente inyectándolas."

---

## 🔵 L - Liskov Substitution Principle (LSP)
**Objetivo:** Asegurar que las clases derivadas puedan sustituir a sus bases sin romper el programa.

> **Prompt:**
> "Revisa la jerarquía de nuestras operaciones para asegurar que cumplen con el Principio de Sustitución de Liskov. 
> 1. Verifica que ninguna implementación de las interfaces de operación lance excepciones inesperadas que la interfaz no prevea.
> 2. Asegura que el comportamiento de los métodos sea consistente en todas las subclases, manteniendo la integridad del contrato de la interfaz."

---

## 🟠 I - Interface Segregation Principle (ISP)
**Objetivo:** Evitar que los clientes dependan de métodos que no usan.

> **Prompt:**
> "Aplica Segregación de Interfaz a nuestro sistema de operaciones. 
> 1. Divide las interfaces genéricas en interfaces más pequeñas y específicas (ej. BasicOperation para aritmética común y ScientificOperation para funciones avanzadas).
> 2. Asegura que si creamos una calculadora básica, esta no tenga ninguna dependencia ni conocimiento de las clases de funciones científicas."

---

## 🔴 D - Dependency Inversion Principle (DIP)
**Objetivo:** Desacoplar módulos de alto nivel de los de bajo nivel (infraestructura).

> **Prompt:**
> "Finaliza la refactorización aplicando Inversión de Dependencia (DIP). 
> 1. Crea interfaces abstractas para los manejadores de consola (InputProvider y OutputProvider).
> 2. Haz que el motor de la calculadora (Engine) dependa únicamente de estas interfaces y no de clases concretas.
> 3. Implementa Inyección de Dependencias por constructor para que el motor reciba sus herramientas desde el exterior (clase Main)."

---

### ✨ Tip Pro: Prueba de Oro
Después de aplicar todos los principios, usa este prompt para verificar la calidad:
> *"Crea una nueva operación llamada 'Power' (Potencia) e inyéctala en el sistema. Si no tuviste que modificar el código del motor central para que funcione, ¡has aplicado SOLID correctamente!"*

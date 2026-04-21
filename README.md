# Taller 7: Domina los Principios S.O.L.I.D. 🚀

Este repositorio contiene la solución completa al Taller 7 de Fundamentos de Ingeniería de Software, enfocado en la refactorización de un monolito hacia una arquitectura limpia utilizando **SOLID**, **TDD** (Test-Driven Design) y **DDD** (Domain-Driven Design).

---

## 🎭 Fase 1: El Monolito (La Trampa)
Iniciamos con una clase `Calculadora.java` básica donde todo el código está mezclado (Spaghetti Code).
- **Acceso:** [Calculadora.java](./Resultado/Calculadora.java)
- **Problemas:** Acoplamiento extremo, difícil de testear, imposible de extender sin modificar el código original.

## 🧠 Fase 2: Reflexión Crítica
El análisis detallado de los problemas de diseño se encuentra en el archivo:
- [RespuestaFase2.md](./Resultado/RespuestaFase2.md)

## 🛠️ Fase 3: La Senda SOLID (Refactorización Iterativa)

La refactorización se realizó paso a paso, creando paquetes independientes para cada principio:

### 1. S - Single Responsibility Principle (SRP)
- **Cambio:** Se separó la lógica en `ArithmeticService`, la entrada en `ConsoleInputHandler` y la salida en `ConsoleOutputHandler`.
- **DDD:** Se implementó el Value Object `Operand` para validar reglas de negocio (ej. no raíces de negativos) antes de operar.
- **Ubicación:** [Resultado con SRP y DDD](./Resultado%20con%20SRP%20y%20DDD/)

### 2. O - Open/Closed Principle (OCP)
- **Cambio:** Se introdujeron las interfaces `BinaryOperation` y `UnaryOperation`. Ahora el motor de la calculadora es cerrado a modificación pero abierto a extensión.
- **Ubicación:** [Resultado con Liskov](./Resultado%20con%20Liskov/) (Nota: Se aplicó OCP en esta fase).

### 3. I - Interface Segregation Principle (ISP)
- **Cambio:** Segregamos las interfaces en categorías: `BasicOperation` y `ScientificOperation`. Esto evita que una calculadora básica dependa de funciones avanzadas.
- **Ubicación:** [Principio con interface](./Principio%20con%20interface/)

### 4. D - Dependency Inversion Principle (DIP)
- **Cambio:** El motor (`CalculatorEngine`) ya no depende de la consola. Depende de las abstracciones `InputProvider` y `OutputProvider`.
- **Inyección de Dependencias:** El `Main` actúa como contenedor, inyectando las implementaciones concretas.
- **Final:** Se añadió la operación `Power` (Potencia) sin tocar el motor, demostrando la flexibilidad total.
- **Ubicación:** [Resultado Final con DIP](./Resultado%20Final%20con%20DIP/)

---

## 🧪 Evidencia de Calidad (TDD/DDD)
- **TDD:** Se incluyeron clases de prueba unitaria como `OperandTest.java` para asegurar que las reglas de dominio se cumplen antes de implementar la lógica.
- **DDD:** El dominio está aislado. Las validaciones de "no dividir por cero" o "no logaritmos negativos" están en el corazón del negocio, no en la interfaz.

---

## 🤖 Bitácora de Antigravity (Pair Programming con IA)

### Prompts Principales
1.  **Inicial:** *"Calculadora SoLiD... quiero todo en la misma clase"* (Para crear el monolito).
2.  **SRP:** *"aplica el principio 1.S - Single Responsibility Principle y DDD"*.
3.  **OCP:** *"añade la O - Open/Closed Principle... hazlo con dos interfaces (binaria y unaria)"*.
4.  **ISP:** *"aplica I - Interface Segregation... principalmente en las operaciones"*.
5.  **DIP:** *"aplica D - Dependency Inversion... inyecta los handlers de I/O"*.

### Errores y Correcciones
- **Error:** Inicialmente, el `Main` tenía lógica de validación. 
- **Guía:** Se le instruyó a la IA mover esa lógica al Value Object `Operand` para cumplir con **DDD**.
- **Mejora:** Se solicitó separar el manejo de entrada y salida para que el motor fuera testeable sin necesidad de un usuario real (Mocking ready).

---

**Entregado por:** Samuel Lopez
**Materia:** Fundamentos de Ingeniería de Software
**Nivel de Entrega:** Maestro Jedi 🎖️

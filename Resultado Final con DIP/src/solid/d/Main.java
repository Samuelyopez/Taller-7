package solid.d;

import solid.d.application.CalculatorEngine;
import solid.d.infrastructure.ConsoleInputHandler;
import solid.d.infrastructure.ConsoleOutputHandler;
import solid.d.interfaces.BinaryOperation;
import solid.d.interfaces.UnaryOperation;
import solid.d.operations.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase de Inicio / Contenedor de Dependencias
 * Responsabilidad: Instanciar los módulos de bajo nivel e inyectarlos en el alto nivel.
 */
public class Main {
    public static void main(String[] args) {
        // 1. Configuramos los módulos de Bajo Nivel (Configurables)
        ConsoleInputHandler inputLocal = new ConsoleInputHandler();
        ConsoleOutputHandler outputLocal = new ConsoleOutputHandler();

        // 2. Preparamos las operaciones (OCP)
        Map<Integer, BinaryOperation> bOps = new HashMap<>();
        bOps.put(1, new Addition());
        bOps.put(2, new Subtraction());
        bOps.put(3, new Multiplication());
        bOps.put(4, new Division());
        bOps.put(7, new Power()); // ¡La nueva operación inyectada!

        Map<Integer, UnaryOperation> uOps = new HashMap<>();
        uOps.put(5, new SquareRoot());
        uOps.put(6, new NaturalLog());

        // 3. INYECCIÓN DE DEPENDENCIAS: 
        // El motor recibe sus dependencias por constructor.
        CalculatorEngine engine = new CalculatorEngine(inputLocal, outputLocal, bOps, uOps);

        // 4. Arrancamos el sistema
        engine.run();
    }
}

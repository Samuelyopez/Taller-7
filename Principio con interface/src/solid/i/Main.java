package solid.i;

import solid.i.domain.Operand;
import solid.i.infrastructure.ConsoleInputHandler;
import solid.i.infrastructure.ConsoleOutputHandler;
import solid.i.interfaces.*;
import solid.i.operations.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ConsoleInputHandler input = new ConsoleInputHandler();
        ConsoleOutputHandler output = new ConsoleOutputHandler();

        // SEGREGACIÓN: Registramos las operaciones en mapas específicos
        Map<Integer, BinaryOperation> basicBinaryOps = new HashMap<>();
        basicBinaryOps.put(1, new Addition());
        basicBinaryOps.put(2, new Subtraction());
        basicBinaryOps.put(3, new Multiplication());
        basicBinaryOps.put(4, new Division());

        Map<Integer, UnaryOperation> scientificUnaryOps = new HashMap<>();
        scientificUnaryOps.put(5, new SquareRoot());
        scientificUnaryOps.put(6, new NaturalLog());

        boolean salir = false;

        while (!salir) {
            output.mostrarMenu();
            int opcion = input.leerOpcion();

            if (opcion == 7) {
                salir = true;
                output.mostrarMensaje("Cerrando calculadora...");
                continue;
            }

            try {
                if (basicBinaryOps.containsKey(opcion)) {
                    // Solo interactuar con Operaciones Básicas
                    BinaryOperation op = basicBinaryOps.get(opcion);
                    if (op instanceof BasicOperation) {
                        double n1 = input.leerNumero("Primer número: ");
                        double n2 = input.leerNumero("Segundo número: ");
                        output.mostrarResultado(op.getName(), op.execute(new Operand(n1, false), new Operand(n2, false)));
                    }

                } else if (scientificUnaryOps.containsKey(opcion)) {
                    // Solo interactuar con Operaciones Científicas
                    UnaryOperation op = scientificUnaryOps.get(opcion);
                    if (op instanceof ScientificOperation) {
                        double n = input.leerNumero("Número: ");
                        output.mostrarResultado(op.getName(), op.execute(new Operand(n, opcion == 5)));
                    }

                } else {
                    output.mostrarError("Opción no válida.");
                }
            } catch (Exception e) {
                output.mostrarError(e.getMessage());
            }
        }
    }
}

package solid.o;

import solid.o.domain.Operand;
import solid.o.infrastructure.ConsoleInputHandler;
import solid.o.infrastructure.ConsoleOutputHandler;
import solid.o.interfaces.BinaryOperation;
import solid.o.interfaces.UnaryOperation;
import solid.o.operations.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ConsoleInputHandler input = new ConsoleInputHandler();
        ConsoleOutputHandler output = new ConsoleOutputHandler();

        // REGSITRO DINÁMICO (Cerrado a modificación, Abierto a extensión)
        Map<Integer, BinaryOperation> binaryOps = new HashMap<>();
        binaryOps.put(1, new Addition());
        binaryOps.put(2, new Subtraction());
        binaryOps.put(3, new Multiplication());
        binaryOps.put(4, new Division());

        Map<Integer, UnaryOperation> unaryOps = new HashMap<>();
        unaryOps.put(5, new SquareRoot());
        unaryOps.put(6, new NaturalLog());

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
                if (binaryOps.containsKey(opcion)) {
                    double n1 = input.leerNumero("Primer número: ");
                    double n2 = input.leerNumero("Segundo número: ");
                    Operand op1 = new Operand(n1, false);
                    Operand op2 = new Operand(n2, false);
                    
                    BinaryOperation op = binaryOps.get(opcion);
                    output.mostrarResultado(op.getName(), op.execute(op1, op2));

                } else if (unaryOps.containsKey(opcion)) {
                    double n = input.leerNumero("Número: ");
                    // Regla de negocio delegada al Value Object
                    Operand op = new Operand(n, opcion == 5); 
                    
                    UnaryOperation opUnaria = unaryOps.get(opcion);
                    output.mostrarResultado(opUnaria.getName(), opUnaria.execute(op));

                } else {
                    output.mostrarError("Opción no válida.");
                }
            } catch (Exception e) {
                output.mostrarError(e.getMessage());
            }
        }
    }
}

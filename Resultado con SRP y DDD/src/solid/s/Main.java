package solid.s;

import solid.s.application.ArithmeticService;
import solid.s.domain.Operand;
import solid.s.infrastructure.ConsoleInputHandler;
import solid.s.infrastructure.ConsoleOutputHandler;

/**
 * Clase principal (Orquestador)
 * Su responsabilidad es inicializar los componentes y arrancar el flujo.
 */
public class Main {
    public static void main(String[] args) {
        ConsoleInputHandler input = new ConsoleInputHandler();
        ConsoleOutputHandler output = new ConsoleOutputHandler();
        ArithmeticService service = new ArithmeticService();

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
                if (opcion >= 1 && opcion <= 4) {
                    double n1 = input.leerNumero("Primer número: ");
                    double n2 = input.leerNumero("Segundo número: ");
                    
                    Operand op1 = new Operand(n1, false);
                    Operand op2 = new Operand(n2, false);
                    
                    double res = 0;
                    String nombreOp = "";

                    switch (opcion) {
                        case 1: res = service.sumar(op1, op2); nombreOp = "Suma"; break;
                        case 2: res = service.restar(op1, op2); nombreOp = "Resta"; break;
                        case 3: res = service.multiplicar(op1, op2); nombreOp = "Multiplicación"; break;
                        case 4: res = service.dividir(op1, op2); nombreOp = "División"; break;
                    }
                    output.mostrarResultado(nombreOp, res);

                } else if (opcion == 5) {
                    double n = input.leerNumero("Número para raíz: ");
                    // DDD: Validamos mediante el Value Object del dominio
                    Operand op = new Operand(n, true); 
                    output.mostrarResultado("Raíz Cuadrada", service.raizCuadrada(op));

                } else if (opcion == 6) {
                    double n = input.leerNumero("Número para logaritmo: ");
                    Operand op = new Operand(n, false);
                    output.mostrarResultado("Logaritmo Natural", service.logaritmoNatural(op));
                } else {
                    output.mostrarError("Opción no válida.");
                }
            } catch (IllegalArgumentException | ArithmeticException e) {
                output.mostrarError(e.getMessage());
            } catch (Exception e) {
                output.mostrarError("Error inesperado: " + e.getMessage());
            }
        }
    }
}

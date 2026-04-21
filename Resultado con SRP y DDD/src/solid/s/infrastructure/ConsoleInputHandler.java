package solid.s.infrastructure;

import java.util.Scanner;

/**
 * Clase de Infraestructura: ConsoleInputHandler
 * Única responsabilidad: Leer datos del usuario desde la consola.
 */
public class ConsoleInputHandler {
    private final Scanner scanner;

    public ConsoleInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int leerOpcion() {
        try {
            System.out.print("Seleccione una opción: ");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public double leerNumero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número válido.");
            }
        }
    }
}

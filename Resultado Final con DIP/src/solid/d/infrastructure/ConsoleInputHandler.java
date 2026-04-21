package solid.d.infrastructure;

import solid.d.interfaces.InputProvider;
import java.util.Scanner;

public class ConsoleInputHandler implements InputProvider {
    private final Scanner scanner;

    public ConsoleInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int readOption() {
        try {
            System.out.print("Seleccione una opción: ");
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    @Override
    public double readNumber(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número válido.");
            }
        }
    }
}

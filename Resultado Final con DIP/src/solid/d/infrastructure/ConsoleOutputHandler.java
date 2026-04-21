package solid.d.infrastructure;

import solid.d.interfaces.OutputProvider;

public class ConsoleOutputHandler implements OutputProvider {
    @Override
    public void displayMenu() {
        System.out.println("\n=== CALCULADORA MAESTRA (D - Dependency Inversion) ===");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Raíz Cuadrada");
        System.out.println("6. Logaritmo Natural");
        System.out.println("7. Potencia (NUEVA!)");
        System.out.println("8. Salir");
    }

    @Override
    public void displayResult(String operationName, double result) {
        System.out.println(">>> [ÉXITO] " + operationName + ": " + result);
    }

    @Override
    public void displayError(String message) {
        System.out.println(">>> [ERROR] " + message);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
}

package solid.s.infrastructure;

/**
 * Clase de Infraestructura: ConsoleOutputHandler
 * Única responsabilidad: Mostrar información y resultados al usuario.
 */
public class ConsoleOutputHandler {

    public void mostrarMenu() {
        System.out.println("\n=== CALCULADORA SOLID (S - SRP) ===");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Raíz Cuadrada");
        System.out.println("6. Logaritmo Natural");
        System.out.println("7. Salir");
    }

    public void mostrarResultado(String operacion, double resultado) {
        System.out.println(">>> RESULTADO " + operacion.toUpperCase() + ": " + resultado);
    }

    public void mostrarError(String mensaje) {
        System.out.println("ERROR: " + mensaje);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}

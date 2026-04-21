package solid.d.application;

import solid.d.domain.Operand;
import solid.d.interfaces.BinaryOperation;
import solid.d.interfaces.InputProvider;
import solid.d.interfaces.OutputProvider;
import solid.d.interfaces.UnaryOperation;

import java.util.Map;

/**
 * Módulo de Alto Nivel: CalculatorEngine
 * No depende de la consola (bajo nivel). 
 * Depende de abstracciones (InputProvider, OutputProvider, Operation).
 */
public class CalculatorEngine {
    private final InputProvider input;
    private final OutputProvider output;
    private final Map<Integer, BinaryOperation> binaryOps;
    private final Map<Integer, UnaryOperation> unaryOps;

    public CalculatorEngine(InputProvider input, 
                            OutputProvider output, 
                            Map<Integer, BinaryOperation> binaryOps, 
                            Map<Integer, UnaryOperation> unaryOps) {
        this.input = input;
        this.output = output;
        this.binaryOps = binaryOps;
        this.unaryOps = unaryOps;
    }

    public void run() {
        boolean salir = false;

        while (!salir) {
            output.displayMenu();
            int opcion = input.readOption();

            if (opcion == 8) {
                salir = true;
                output.displayMessage("Cerrando sistema maestro...");
                continue;
            }

            try {
                if (binaryOps.containsKey(opcion)) {
                    double n1 = input.readNumber("Ingresa primer valor: ");
                    double n2 = input.readNumber("Ingresa segundo valor: ");
                    BinaryOperation bOp = binaryOps.get(opcion);
                    output.displayResult(bOp.getName(), bOp.execute(new Operand(n1, false), new Operand(n2, false)));

                } else if (unaryOps.containsKey(opcion)) {
                    double n = input.readNumber("Ingresa valor: ");
                    // Regla de negocio delegada
                    Operand op = new Operand(n, opcion == 5); 
                    UnaryOperation uOp = unaryOps.get(opcion);
                    output.displayResult(uOp.getName(), uOp.execute(op));

                } else {
                    output.displayError("Opción desconocida.");
                }
            } catch (Exception e) {
                output.displayError(e.getMessage());
            }
        }
    }
}

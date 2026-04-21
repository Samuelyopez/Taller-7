package solid.d.operations;

import solid.d.domain.Operand;
import solid.d.interfaces.BinaryOperation;

/**
 * Nueva operación: Potencia
 * Demuestra que podemos extender el sistema sin modificar el motor.
 */
public class Power implements BinaryOperation {
    @Override
    public double execute(Operand op1, Operand op2) {
        return Math.pow(op1.getValue(), op2.getValue());
    }

    @Override
    public String getName() {
        return "Potencia";
    }
}

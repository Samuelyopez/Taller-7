package solid.o.operations;

import solid.o.domain.Operand;
import solid.o.interfaces.UnaryOperation;

public class SquareRoot implements UnaryOperation {
    @Override
    public double execute(Operand op1) {
        return Math.sqrt(op1.getValue());
    }

    @Override
    public String getName() {
        return "Raíz Cuadrada";
    }
}

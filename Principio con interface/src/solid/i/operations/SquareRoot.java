package solid.i.operations;

import solid.i.domain.Operand;
import solid.i.interfaces.UnaryOperation;
import solid.i.interfaces.ScientificOperation;

public class SquareRoot implements UnaryOperation, ScientificOperation {
    @Override
    public double execute(Operand op1) {
        return Math.sqrt(op1.getValue());
    }

    @Override
    public String getName() {
        return "Raíz Cuadrada";
    }
}

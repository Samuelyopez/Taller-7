package solid.d.operations;

import solid.d.domain.Operand;
import solid.d.interfaces.UnaryOperation;

public class NaturalLog implements UnaryOperation {
    @Override
    public double execute(Operand op1) {
        if (op1.getValue() <= 0) throw new IllegalArgumentException("Logaritmo requiere positivo.");
        return Math.log(op1.getValue());
    }
    @Override
    public String getName() { return "Logaritmo Natural"; }
}

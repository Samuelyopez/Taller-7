package solid.i.operations;

import solid.i.domain.Operand;
import solid.i.interfaces.UnaryOperation;
import solid.i.interfaces.ScientificOperation;

public class NaturalLog implements UnaryOperation, ScientificOperation {
    @Override
    public double execute(Operand op1) {
        if (op1.getValue() <= 0) {
            throw new IllegalArgumentException("El logaritmo natural solo está definido para números positivos.");
        }
        return Math.log(op1.getValue());
    }

    @Override
    public String getName() {
        return "Logaritmo Natural";
    }
}

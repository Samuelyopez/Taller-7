package solid.o.operations;

import solid.o.domain.Operand;
import solid.o.interfaces.UnaryOperation;

public class NaturalLog implements UnaryOperation {
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

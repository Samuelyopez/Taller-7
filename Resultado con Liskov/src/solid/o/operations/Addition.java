package solid.o.operations;

import solid.o.domain.Operand;
import solid.o.interfaces.BinaryOperation;

public class Addition implements BinaryOperation {
    @Override
    public double execute(Operand op1, Operand op2) {
        return op1.getValue() + op2.getValue();
    }

    @Override
    public String getName() {
        return "Suma";
    }
}

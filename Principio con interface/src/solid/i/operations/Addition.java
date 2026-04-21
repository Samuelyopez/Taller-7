package solid.i.operations;

import solid.i.domain.Operand;
import solid.i.interfaces.BinaryOperation;
import solid.i.interfaces.BasicOperation;

public class Addition implements BinaryOperation, BasicOperation {
    @Override
    public double execute(Operand op1, Operand op2) {
        return op1.getValue() + op2.getValue();
    }

    @Override
    public String getName() {
        return "Suma";
    }
}

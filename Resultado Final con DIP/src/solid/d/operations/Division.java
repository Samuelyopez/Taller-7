package solid.d.operations;

import solid.d.domain.Operand;
import solid.d.interfaces.BinaryOperation;

public class Division implements BinaryOperation {
    @Override
    public double execute(Operand op1, Operand op2) {
        if (op2.getValue() == 0) throw new ArithmeticException("Cero no divide.");
        return op1.getValue() / op2.getValue();
    }
    @Override
    public String getName() { return "División"; }
}

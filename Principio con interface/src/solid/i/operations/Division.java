package solid.i.operations;

import solid.i.domain.Operand;
import solid.i.interfaces.BinaryOperation;
import solid.i.interfaces.BasicOperation;

public class Division implements BinaryOperation, BasicOperation {
    @Override
    public double execute(Operand op1, Operand op2) {
        if (op2.getValue() == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return op1.getValue() / op2.getValue();
    }

    @Override
    public String getName() {
        return "División";
    }
}

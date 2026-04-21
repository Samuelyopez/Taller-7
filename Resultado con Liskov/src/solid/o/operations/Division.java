package solid.o.operations;

import solid.o.domain.Operand;
import solid.o.interfaces.BinaryOperation;

public class Division implements BinaryOperation {
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

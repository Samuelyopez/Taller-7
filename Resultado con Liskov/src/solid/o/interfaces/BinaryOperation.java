package solid.o.interfaces;

import solid.o.domain.Operand;

public interface BinaryOperation {
    double execute(Operand op1, Operand op2);
    String getName();
}

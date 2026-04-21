package solid.i.interfaces;

import solid.i.domain.Operand;

public interface BinaryOperation {
    double execute(Operand op1, Operand op2);
    String getName();
}

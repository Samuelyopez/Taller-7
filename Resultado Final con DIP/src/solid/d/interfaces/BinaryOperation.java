package solid.d.interfaces;

import solid.d.domain.Operand;

public interface BinaryOperation {
    double execute(Operand op1, Operand op2);
    String getName();
}

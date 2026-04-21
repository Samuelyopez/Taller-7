package solid.i.interfaces;

import solid.i.domain.Operand;

public interface UnaryOperation {
    double execute(Operand op1);
    String getName();
}

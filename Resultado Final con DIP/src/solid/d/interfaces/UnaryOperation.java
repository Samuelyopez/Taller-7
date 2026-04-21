package solid.d.interfaces;

import solid.d.domain.Operand;

public interface UnaryOperation {
    double execute(Operand op1);
    String getName();
}

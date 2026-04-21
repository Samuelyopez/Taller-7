package solid.o.interfaces;

import solid.o.domain.Operand;

public interface UnaryOperation {
    double execute(Operand op1);
    String getName();
}

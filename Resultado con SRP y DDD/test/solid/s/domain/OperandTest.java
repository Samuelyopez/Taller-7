package solid.s.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class OperandTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeValueForSquareRootFails() {
        // En DDD, el objeto de dominio debe proteger sus invariantes.
        // Un operando para raíz cuadrada no puede ser negativo.
        new Operand(-5.0, true); 
    }

    @Test
    public void testPositiveValueForSquareRootPasses() {
        Operand op = new Operand(25.0, true);
        assertEquals(25.0, op.getValue(), 0.001);
    }
    
    @Test
    public void testNormalValuePasses() {
        Operand op = new Operand(-10.0, false);
        assertEquals(-10.0, op.getValue(), 0.001);
    }
}

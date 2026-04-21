package solid.s.application;

import solid.s.domain.Operand;

/**
 * Servicio de Aplicación: ArithmeticService
 * Su única responsabilidad es realizar los cálculos matemáticos.
 * No sabe nada de la consola ni de la entrada de datos.
 */
public class ArithmeticService {

    public double sumar(Operand a, Operand b) {
        return a.getValue() + b.getValue();
    }

    public double restar(Operand a, Operand b) {
        return a.getValue() - b.getValue();
    }

    public double multiplicar(Operand a, Operand b) {
        return a.getValue() * b.getValue();
    }

    public double dividir(Operand a, Operand b) {
        if (b.getValue() == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return a.getValue() / b.getValue();
    }

    public double raizCuadrada(Operand a) {
        return Math.sqrt(a.getValue());
    }

    public double logaritmoNatural(Operand a) {
        if (a.getValue() <= 0) {
            throw new IllegalArgumentException("El logaritmo natural solo está definido para números positivos.");
        }
        return Math.log(a.getValue());
    }
}

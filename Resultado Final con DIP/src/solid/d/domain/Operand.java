package solid.d.domain;

public class Operand {
    private final double value;

    public Operand(double value, boolean isRestricted) {
        if (isRestricted && value < 0) {
            throw new IllegalArgumentException("Regla de Dominio: No se permiten números negativos.");
        }
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}

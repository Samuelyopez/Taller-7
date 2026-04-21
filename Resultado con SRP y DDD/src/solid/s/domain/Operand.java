package solid.s.domain;

/**
 * Value Object: Operand
 * Representa un número válido para ser operado.
 * Implementa reglas de dominio (DDD).
 */
public class Operand {
    private final double value;

    public Operand(double value, boolean isRestricted) {
        // Regla de dominio: No permitir raíces de números negativos
        if (isRestricted && value < 0) {
            throw new IllegalArgumentException("Regla de Dominio: No se permiten números negativos para esta operación.");
        }
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}

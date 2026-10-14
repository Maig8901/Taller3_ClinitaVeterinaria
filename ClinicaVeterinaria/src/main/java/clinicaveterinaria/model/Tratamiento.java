package clinicaveterinaria.model;
import java.util.Objects;

import clinicaveterinaria.interfaces.ITratamiento;


public abstract class Tratamiento implements ITratamiento {
    private int id;
    private final TipoTratamiento tipo;
    private String descripcion;
    private double costo;

    protected Tratamiento(int id, TipoTratamiento tipo, String descripcion, double costo) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    protected abstract double getFactorImpuesto();

    @Override
    public double calcularConImpuestos() {
        return costo * getFactorImpuesto();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public TipoTratamiento getTipo() { return tipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tratamiento)) return false;
        return id == ((Tratamiento) o).id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Tratamiento{id=" + id + ", tipo=" + tipo +
                ", descripcion='" + descripcion + "', costo=" + costo + '}';
    }
}

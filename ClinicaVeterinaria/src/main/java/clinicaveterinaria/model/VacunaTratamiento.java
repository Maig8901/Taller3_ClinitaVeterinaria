package clinicaveterinaria.model;

public class VacunaTratamiento extends Tratamiento {

    public VacunaTratamiento(int id, String descripcion, double costo) {
        super(id, TipoTratamiento.VACUNA, descripcion, costo);
    }

    @Override
    public double calcularCostoFinal() {
        return getCosto() + 5.0;
    }

    @Override
    protected double getFactorImpuesto() {
        return 1.12;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Observar fiebre durante 24 horas.";
    }

    @Override
    public String prepararSala() {
        return "Preparar refrigeracion y jeringas.";
    }
}

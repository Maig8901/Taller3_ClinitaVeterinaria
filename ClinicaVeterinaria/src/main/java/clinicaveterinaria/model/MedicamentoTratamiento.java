package clinicaveterinaria.model;

public class MedicamentoTratamiento extends Tratamiento {

    public MedicamentoTratamiento(int id, String descripcion, double costo) {
        super(id, TipoTratamiento.MEDICAMENTO, descripcion, costo);
    }

    @Override
    public double calcularCostoFinal() {
        return getCosto() * 1.10;
    }

    @Override
    protected double getFactorImpuesto() {
        return 1.08;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Administrar segun receta.";
    }

    @Override
    public String prepararSala() {
        return "Preparar receta y dosis.";
    }
}

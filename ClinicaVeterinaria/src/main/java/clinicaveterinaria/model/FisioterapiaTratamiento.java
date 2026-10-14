package clinicaveterinaria.model;

public class FisioterapiaTratamiento extends Tratamiento {

    public FisioterapiaTratamiento(int id, String descripcion, double costo) {
        super(id, TipoTratamiento.FISIOTERAPIA, descripcion, costo);
    }

    @Override
    public double calcularCostoFinal() {
        return getCosto() * 0.95;
    }

    @Override
    protected double getFactorImpuesto() {
        return 1.05;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Repetir sesiones dos veces por semana.";
    }

    @Override
    public String prepararSala() {
        return "Preparar camilla y bandas elasticas.";
    }
}

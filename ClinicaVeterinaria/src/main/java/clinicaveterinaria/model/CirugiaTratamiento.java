package clinicaveterinaria.model;

public class CirugiaTratamiento extends Tratamiento {

    public CirugiaTratamiento(int id, String descripcion, double costo) {
        super(id, TipoTratamiento.CIRUGIA, descripcion, costo);
    }

    @Override
    public double calcularCostoFinal() {
        return getCosto() * 1.25 + 80.0;
    }

    @Override
    protected double getFactorImpuesto() {
        return 1.35;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Ayuno previo y control postoperatorio.";
    }

    @Override
    public String prepararSala() {
        return "Preparar quirofano y anestesia.";
    }
}

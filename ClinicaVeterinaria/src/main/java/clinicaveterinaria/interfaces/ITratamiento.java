package clinicaveterinaria.interfaces;

public interface ITratamiento {
    double calcularCostoFinal();

    double calcularConImpuestos();

    String obtenerIndicaciones();

    String prepararSala();
}

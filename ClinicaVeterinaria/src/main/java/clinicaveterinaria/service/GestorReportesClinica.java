package clinicaveterinaria.service;
import java.util.Map;
import clinicaveterinaria.repository.BaseDatos;


public class GestorReportesClinica {
    private final Map<String, Integer> auditoria;

    public GestorReportesClinica(Map<String, Integer> auditoria) {
        this.auditoria = auditoria;
    }

    public void imprimirResumenOperaciones() {
        System.out.println("Resumen interno: " + auditoria);
    }
}
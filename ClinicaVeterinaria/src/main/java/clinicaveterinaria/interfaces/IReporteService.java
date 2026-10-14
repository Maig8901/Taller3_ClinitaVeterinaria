package clinicaveterinaria.interfaces;
import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Mascota;
import java.array.list;
public interface IReporteService{
    List<Cita> generarReporteCitasPorVenir(int veterinarioId);
    list<Mascota> generarReporteMascotaPorDueno (String duenoNombre);
    double calcularIngresoMensual();
}
package clinicaveterinaria.interfaces;
import clinicaveterinaria.model.Mascota;
public interface ImascotasService{
    void crearMascota(Mascota mascota);
    Mascota obtenerMascota(int id);
    void actualizarMascota(int id);
    void eliminarMascota(int id);
}
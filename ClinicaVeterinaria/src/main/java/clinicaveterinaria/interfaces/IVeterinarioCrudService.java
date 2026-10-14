
package clinicaveterinaria.interfaces;
import clinicaveterinaria.model.Veterinario;
public interface IVeterinarioCrudService
        extends IVeterinarioRecepcionService {
    void actualizarVeterinario(Veterinario veterinario);
    void eliminarVeterinario(int id);
}

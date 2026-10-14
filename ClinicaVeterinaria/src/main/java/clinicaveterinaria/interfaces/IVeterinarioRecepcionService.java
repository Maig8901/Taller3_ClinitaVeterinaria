
package clinicaveterinaria.interfaces;
import clinicaveterinaria.model.Veterinario;
public interface IVeterinarioRecepcionService {
    void crearVeterinario(Veterinario veterinario);
    Veterinario obtenerVeterinario(int id);
}

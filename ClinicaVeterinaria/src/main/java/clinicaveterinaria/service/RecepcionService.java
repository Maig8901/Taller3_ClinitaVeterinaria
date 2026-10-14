
package clinicaveterinaria.service;
import clinicaveterinaria.interfaces.IMascotaService;
import clinicaveterinaria.interfaces.ICitaService;
import clinicaveterinaria.interfaces.IVeterinarioRecepcionService;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Veterinario;
public class RecepcionService implements
        IMascotaService,
        ICitaService,
        IVeterinarioRecepcionService {
    private final IMascotaService mascotaService;
    private final ICitaService citaService;
    private final IVeterinarioRecepcionService veterinarioService;
    public RecepcionService(
            IMascotaService mascotaService,
            ICitaService citaService,
            IVeterinarioRecepcionService veterinarioService) {

        this.mascotaService = mascotaService;
        this.citaService = citaService;
        this.veterinarioService = veterinarioService;
    }
    @Override
    public void crearMascota(Mascota mascota) {
        mascotaService.crearMascota(mascota);
    }
    @Override
    public Mascota obtenerMascota(int id) {
        return mascotaService.obtenerMascota(id);
    }
    @Override
    public void actualizarMascota(Mascota mascota) {
        mascotaService.actualizarMascota(mascota);
    }
    @Override
    public void eliminarMascota(int id) {
        mascotaService.eliminarMascota(id);
    }
    @Override
    public void crearCita(Cita cita) {
        citaService.crearCita(cita);
    }
    @Override
    public Cita obtenerCita(int id) {
        return citaService.obtenerCita(id);
    }
    @Override
    public void cancelarCita(int id) {
        citaService.cancelarCita(id);
    }
    @Override
    public void crearVeterinario(Veterinario veterinario) {
        veterinarioService.crearVeterinario(veterinario);
    }
    @Override
    public Veterinario obtenerVeterinario(int id) {
        return veterinarioService.obtenerVeterinario(id);
    }
}

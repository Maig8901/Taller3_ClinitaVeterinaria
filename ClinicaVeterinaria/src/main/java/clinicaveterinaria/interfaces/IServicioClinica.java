package clinicaveterinaria.interfaces;

import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Factura;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Tratamiento;
import clinicaveterinaria.model.Veterinario;

import java.util.List;


public interface IServicioClinica 
extends IMascotasService
        ICitaService 
        IfacturaService 
        IReporteService 
        IVeterinarioCrudService
        IVeterinarioRecepcionService {
}

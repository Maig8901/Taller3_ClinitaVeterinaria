package clinicaveterinaria;

import java.time.LocalDate;

import clinicaveterinaria.model.Animal;
import clinicaveterinaria.model.Cita;
import clinicaveterinaria.model.Factura;
import clinicaveterinaria.model.Mascota;
import clinicaveterinaria.model.Pez;
import clinicaveterinaria.model.TipoAnimal;
import clinicaveterinaria.model.TipoTratamiento;
import clinicaveterinaria.model.Tratamiento;
import clinicaveterinaria.model.Veterinario;
import clinicaveterinaria.repository.BaseDatos;
import clinicaveterinaria.service.CalculadoraCostoTratamiento;
import clinicaveterinaria.service.Clinica;
import clinicaveterinaria.service.DiagnosticoService;
import clinicaveterinaria.service.FacturacionService;
import clinicaveterinaria.service.MascotaService;
import clinicaveterinaria.service.ReporteService;
import clinicaveterinaria.service.ReservaService;
import clinicaveterinaria.service.ServicioClinicaCompleto;
import clinicaveterinaria.service.TratamientoService;
import clinicaveterinaria.service.VeterinarioCrudService;

public class Main {
    public static void main(String[] args) {
        BaseDatos baseDatos = new BaseDatos();
        MascotaService mascotaService = new MascotaService(baseDatos);
        VeterinarioCrudService veterinarioCrudService = new VeterinarioCrudService(baseDatos);
        ReservaService reservaService = new ReservaService(baseDatos);
        DiagnosticoService diagnosticoService = new DiagnosticoService();
        FacturacionService facturacionService = new FacturacionService(baseDatos);
        TratamientoService tratamientoService = new TratamientoService(baseDatos);
        ReporteService reporteService = new ReporteService(baseDatos);

        Mascota mascota = new Mascota(1, "Luna", TipoAnimal.PERRO, 4, "Ana Perez");
        Veterinario veterinario = new Veterinario(1, "Dr. Ruiz", "Medicina general", true);
        Tratamiento tratamiento = new VacunaTratamiento(1, "Esterilizacion", 120.0);

        mascotaService.crearMascota(mascota);
        veterinarioCrudService.crearVeterinario(veterinario);
        tratamientoService.crearTratamiento(tratamiento);

        Cita cita = reservaService.reservarCita(1, mascota, veterinario, LocalDate.now());
        diagnosticoService.diagnosticar(cita, "Paciente estable para tratamiento.");
        Factura factura = facturacionService.generarFactura(1, cita, tratamiento.calcularCostoFinal());
        factura.setPagada(true);
        

        System.out.println("=== ClinicaVeterinaria funcionando ===");
        System.out.println(mascotaService.obtenerMascota(1));
        System.out.println(cita);
        System.out.println(factura);
        System.out.println("Preparacion: " + tratamientoService.prepararSala(tratamiento));
        System.out.println("Costo con impuestos: " + new CalculadoraCostoTratamiento().calcularConImpuestos(tratamiento));
        System.out.println("Citas Dr. Ruiz: " + reporteService.generarReporteCitasPorVeterinario(1).size());
        System.out.println("Mascotas de Ana Perez: " + reporteService.generarReporteMascotasPorDueno("Ana Perez").size());
        System.out.println("Ingresos del mes: " + reporteService.calcularIngresosMensual());

        demostrarViolacionesSinRomperEjecucion(baseDatos, veterinario, mascota, tratamiento);
        new Clinica().agendarConsultaRapida(mascota, veterinario);
        new ServicioClinicaCompleto(baseDatos).calcularTratamiento(tratamiento);
    }

    private static void demostrarViolacionesSinRomperEjecucion(BaseDatos baseDatos, Veterinario veterinario, Mascota mascota, Tratamiento tratamiento) {
        Cita citaDesdeModelo = new ReservaService(baseDatos).reservarCita(2, mascota, veterinario, LocalDate.now().plusDays(1));
        new DiagnosticoService().diagnosticar(citaDesdeModelo, "Ejemplo de SRP violado desde el modelo.");
        System.out.println(new ReporteService(baseDatos).generarReporteCitasPorVeterinario(veterinario.getId()).size());

        Animal pez = new Pez(3, "Nemo");
        pez.nadar();
        System.out.println("El pez heredó caminar() y volar(), aunque no debe usarlos.");
        System.out.println("Tratamiento OCP violado pero funcional: " + tratamiento.obtenerIndicaciones());
    }
}

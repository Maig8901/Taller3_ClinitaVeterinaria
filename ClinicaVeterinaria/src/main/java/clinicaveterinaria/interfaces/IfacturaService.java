package clinicaveterinaria.interfaces;
import clinicaveterinaria.model.Factura;
public interface IfacturaService{
    void crearFactura (Factura factura);
    void pagarFacturs(int id);
}
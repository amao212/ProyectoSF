package BusinessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BusinessLogic.Entities.Factura;
import DataAccess.FacturaDAC;
import Framework.AppException;

public class FacturaBL {
    
    public List<Factura> obtenerDatos() throws AppException{
        try {
            List <Factura> lstFactura = new ArrayList<Factura>();
            ResultSet rs = new FacturaDAC().getAllData();
            while (rs.next()) {
                Factura f = new Factura(rs.getInt("idFactura"),
                                        rs.getInt("usuarioId"),
                                        rs.getInt("clienteIdCliente"),
                                        rs.getInt("inventarioId"),
                                        rs.getString("estadoFactura"),
                                        rs.getString("totalFactura"),
                                        rs.getString("fechaIngresoFactura"),
                                        rs.getString("fehcaModificacionFactura"));
                lstFactura.add(f);
            }
            return lstFactura;
        } catch (Exception e) {
            throw new AppException(e, getClass(),"obtenerDatos");
        }
        
    }
}

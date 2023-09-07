package BusinessLogic;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import BusinessLogic.Entities.Usuario;
import DataAccess.UsuarioDAC;
import Framework.AppException;

public class UsuarioBL {
    public List<Usuario> obtenerDatos() throws AppException{
        try {
            List <Usuario> lstUsuario = new ArrayList<Usuario>();
            ResultSet rs = new UsuarioDAC().getAllData();
            while (rs.next()) {
                Usuario f = new Usuario(rs.getInt("idUsuario"),
                                        rs.getString("credencial"),
                                        rs.getString("password"),
                                        rs.getString("nombre"),
                                        rs.getString("apellido"),
                                        rs.getString("cedula"),
                                        rs.getString("estado"),
                                        rs.getString("fechaIngreso"),
                                        rs.getString("fechaModificacion"));
                lstUsuario.add(f);
            }
            return lstUsuario;
        } catch (Exception e) {
            throw new AppException(e, getClass(),"obtenerDatos");
        }
        
    }
    
}

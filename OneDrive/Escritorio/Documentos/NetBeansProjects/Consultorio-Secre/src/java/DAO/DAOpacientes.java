
package DAO;

import Clases.pacientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOpacientes implements Operaciones{
    Database db = new Database();
    
    @Override
    public String insertar(Object obj) {
        pacientes pac = (pacientes) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "insert into pacientes values(?,?,?,?,?,?,?,?,?)";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, pac.getIdPaciente());
            pst.setString(2, pac.getNombresPaciente());
            pst.setString(3, pac.getApellidosPaciente());
            pst.setDate(4, pac.getFechaNacPaciente());
            pst.setString(5, pac.getTelPaciente());
            pst.setString(6, pac.getEmailPaciente());
            pst.setString(7, pac.getDireccionPaciente());
            pst.setString(8, pac.getNombreemergPaciente());
            pst.setString(9, pac.getTelemergPaciente());
            int filas =  pst.executeUpdate();
            respuesta = "se registraron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String eliminar(Object obj) {
        pacientes pac = (pacientes) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "delete from pacientes where idPaciente=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, pac.getIdPaciente());
            int filas =  pst.executeUpdate();
            respuesta = "se eliminaron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String modificar(Object obj) {
        pacientes pac = (pacientes) obj;
        Connection conn;
        PreparedStatement pst;
        String sql= "update pacientes set nombresPaciente=?, apellidosPaciente=?, fechaNacPaciente=?"
                + ", telPaciente=?, emailPaciente=?, direccionPaciente=?"
                + ", nombreemergPaciente=?, telemergPaciente=? where idPaciente=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setString(1, pac.getNombresPaciente());
            pst.setString(2, pac.getApellidosPaciente());
            pst.setDate(3, pac.getFechaNacPaciente());
            pst.setString(4, pac.getTelPaciente());
            pst.setString(5, pac.getEmailPaciente());
            pst.setString(6, pac.getDireccionPaciente());
            pst.setString(7, pac.getNombreemergPaciente());
            pst.setString(8, pac.getTelemergPaciente());
            pst.setInt(9, pac.getIdPaciente());
            int filas =  pst.executeUpdate();
            respuesta = "se modificaron " + filas + " elementos";
            conn.close();       
        } catch (ClassNotFoundException | SQLException e) {
        }
        return respuesta; 
    }

    @Override
    public List<pacientes> consultar() {
        List<pacientes> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from pacientes";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new pacientes(
                        rs.getInt("idPaciente"), 
                        rs.getString("nombresPaciente"),
                        rs.getString("apellidosPaciente"),
                        rs.getDate("fechaNacPaciente"),
                        rs.getString("telPaciente"),
                        rs.getString("emailPaciente"),
                        rs.getString("direccionPaciente"),
                        rs.getString("nombreemergPaciente"),
                        rs.getString("telemergPaciente")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
       return datos;
    }

    @Override
    public List<pacientes> filtrar(String campo, String criterio) {
        List<pacientes> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from pacientes where " + campo + " like '%"+criterio+"%'";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new pacientes(
                        rs.getInt("idPaciente"), 
                        rs.getString("nombresPaciente"),
                        rs.getString("apellidosPaciente"),
                        rs.getDate("fechaNacPaciente"),
                        rs.getString("telPaciente"),
                        rs.getString("emailPaciente"),
                        rs.getString("direccionPaciente"),
                        rs.getString("nombreemergPaciente"),
                        rs.getString("telemergPaciente")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
      return datos;
    }
    
}


package DAO;

import Clases.enfermedades_hereditarias;
import Clases.pacientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOenfermedades_hereditarias implements Operaciones {
    Database db = new Database();
    
    @Override
    public String insertar(Object obj) {
        enfermedades_hereditarias enfh = (enfermedades_hereditarias) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "insert into enfermedades_hereditarias values(?,?,?)";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, enfh.getIdEnfermedadH());
            pst.setInt(2, enfh.getIdPaciente().getIdPaciente());
            pst.setString(3, enfh.getEnfermedadH());
            int filas =  pst.executeUpdate();
            respuesta = "se registraron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String eliminar(Object obj) {
        enfermedades_hereditarias enfh = (enfermedades_hereditarias) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "delete from enfermedades_hereditarias where idEnfermedadH=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, enfh.getIdEnfermedadH());
            int filas =  pst.executeUpdate();
            respuesta = "se eliminaron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String modificar(Object obj) {
        enfermedades_hereditarias enfh = (enfermedades_hereditarias) obj;
        Connection conn;
        PreparedStatement pst;
        String sql= "update enfermedades_hereditarias set idPaciente=?, enfermedadH=? where idEnfermedadH=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, enfh.getIdPaciente().getIdPaciente());
            pst.setString(2, enfh.getEnfermedadH());
            pst.setInt(3, enfh.getIdEnfermedadH());
            int filas =  pst.executeUpdate();
            respuesta = "se modificaron " + filas + " elementos";
            conn.close();       
        } catch (ClassNotFoundException | SQLException e) {
        }
        return respuesta; 
    }

    @Override
    public List<enfermedades_hereditarias> consultar() {
        List<enfermedades_hereditarias> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from enfermedades_hereditarias";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new enfermedades_hereditarias(
                        rs.getInt("idEnfermedadH"), 
                        new pacientes (rs.getInt("idPaciente")),
                        rs.getString("enfermedadH")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
       return datos;
    }

    @Override
    public List<enfermedades_hereditarias> filtrar(String campo, String criterio) {
        List<enfermedades_hereditarias> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from enfermedades_hereditarias where " + campo + " like '%"+criterio+"%'";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new enfermedades_hereditarias(
                        rs.getInt("idEnfermedadH"), 
                        new pacientes (rs.getInt("idPaciente")),
                        rs.getString("enfermedadH")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
      return datos;
    }
}

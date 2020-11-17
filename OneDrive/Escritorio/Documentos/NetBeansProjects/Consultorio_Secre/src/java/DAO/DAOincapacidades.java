
package DAO;

import Clases.incapacidades;
import Clases.registro_consultas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOincapacidades implements Operaciones {
    Database db = new Database();
    
    @Override
    public String insertar(Object obj) {
        incapacidades inca = (incapacidades) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "insert into incapacidades values(?,?,?)";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, inca.getIdInca());
            pst.setInt(2, inca.getIdregConsulta().getIdregConsulta());
            pst.setDate(3, inca.getFinalInca());
            int filas =  pst.executeUpdate();
            respuesta = "se registraron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String eliminar(Object obj) {
        incapacidades inca = (incapacidades) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "delete from incapacidades where idInca=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, inca.getIdInca());
            int filas =  pst.executeUpdate();
            respuesta = "se eliminaron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String modificar(Object obj) {
        incapacidades inca = (incapacidades) obj;
        Connection conn;
        PreparedStatement pst;
        String sql= "update incapacidades set idregConsulta=?, finalInca=? where idInca=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, inca.getIdregConsulta().getIdregConsulta());
            pst.setDate(2, inca.getFinalInca());
            pst.setInt(3, inca.getIdInca());
            int filas =  pst.executeUpdate();
            respuesta = "se modificaron " + filas + " elementos";
            conn.close();       
        } catch (ClassNotFoundException | SQLException e) {
        }
        return respuesta; 
    }

    @Override
    public List<incapacidades> consultar() {
        List<incapacidades> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from incapacidades";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new incapacidades(
                        rs.getInt("idInca"), 
                        new registro_consultas (rs.getInt("idregConsulta")),
                        rs.getDate("finalInca")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
       return datos;
    }

    @Override
    public List<incapacidades> filtrar(String campo, String criterio) {
        List<incapacidades> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from incapacidades where " + campo + " like '%"+criterio+"%'";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new incapacidades(
                        rs.getInt("idInca"), 
                        new registro_consultas (rs.getInt("idregConsulta")),
                        rs.getDate("finalInca")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
      return datos;
    }
}

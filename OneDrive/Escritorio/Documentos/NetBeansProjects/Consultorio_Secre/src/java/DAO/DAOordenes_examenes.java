
package DAO;

import Clases.ordenes_examenes;
import Clases.registro_consultas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOordenes_examenes implements Operaciones {
    Database db = new Database();
    
    @Override
    public String insertar(Object obj) {
        ordenes_examenes orde = (ordenes_examenes) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "insert into ordenes_examenes values(?,?,?)";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, orde.getIdOrden());
            pst.setInt(2, orde.getIdregConsulta().getIdregConsulta());
            pst.setString(3, orde.getExamen());
            int filas =  pst.executeUpdate();
            respuesta = "se registraron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String eliminar(Object obj) {
        ordenes_examenes orde = (ordenes_examenes) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "delete from ordenes_examenes where idOrden=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, orde.getIdOrden());
            int filas =  pst.executeUpdate();
            respuesta = "se eliminaron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String modificar(Object obj) {
        ordenes_examenes orde = (ordenes_examenes) obj;
        Connection conn;
        PreparedStatement pst;
        String sql= "update ordenes_examenes set idregConsulta=?, examen=? where idOrden=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, orde.getIdregConsulta().getIdregConsulta());
            pst.setString(2, orde.getExamen());
            pst.setInt(3, orde.getIdOrden());
            int filas =  pst.executeUpdate();
            respuesta = "se modificaron " + filas + " elementos";
            conn.close();       
        } catch (ClassNotFoundException | SQLException e) {
        }
        return respuesta; 
    }

    @Override
    public List<ordenes_examenes> consultar() {
        List<ordenes_examenes> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from ordenes_examenes";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new ordenes_examenes(
                        rs.getInt("idOrden"), 
                        new registro_consultas (rs.getInt("idregConsulta")),
                        rs.getString("examen")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
       return datos;
    }

    @Override
    public List<ordenes_examenes> filtrar(String campo, String criterio) {
        List<ordenes_examenes> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from ordenes_examenes where " + campo + " like '%"+criterio+"%'";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new ordenes_examenes(
                        rs.getInt("idOrden"), 
                        new registro_consultas (rs.getInt("idregConsulta")),
                        rs.getString("examen")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
      return datos;
    }
}


package DAO;

import Clases.empleados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOempleados implements Operaciones{
    Database db = new Database();
    
    @Override
    public String insertar(Object obj) {
        empleados emp = (empleados) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "insert into empleados values(?,?,?,?)";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, emp.getIdEmpleado());
            pst.setString(2, emp.getNombreEmpleado());
            pst.setString(3, emp.getDireccionEmpleado());
            pst.setString(4, emp.getTelEmpleado());
            int filas =  pst.executeUpdate();
            respuesta = "se registraron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String eliminar(Object obj) {
        empleados emp = (empleados) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "delete from empleados where idEmpleado=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, emp.getIdEmpleado());
            int filas =  pst.executeUpdate();
            respuesta = "se eliminaron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String modificar(Object obj) {
        empleados emp = (empleados) obj;
        Connection conn;
        PreparedStatement pst;
        String sql= "update empleados set nombreEmpleado=?, direccionEmpleado=?, telEmpleado=?  where idEmpleado=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setString(1, emp.getNombreEmpleado());
            pst.setString(2, emp.getDireccionEmpleado());
            pst.setString(3, emp.getTelEmpleado());
            pst.setInt(4, emp.getIdEmpleado());
            int filas =  pst.executeUpdate();
            respuesta = "se modificaron " + filas + " elementos";
            conn.close();       
        } catch (ClassNotFoundException | SQLException e) {
        }
        return respuesta; 
    }

    @Override
    public List<empleados> consultar() {
        List<empleados> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from empleados";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new empleados(
                        rs.getInt("idEmpleado"), 
                        rs.getString("nombreEmpleado"),
                        rs.getString("direccionEmpleado"),
                        rs.getString("telEmpleado")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
       return datos;
    }

    @Override
    public List<empleados> filtrar(String campo, String criterio) {
        List<empleados> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from empleados where " + campo + " like '%"+criterio+"%'";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new empleados(
                        rs.getInt("idEmpleado"), 
                        rs.getString("nombreEmpleado"),
                        rs.getString("direccionEmpleado"),
                        rs.getString("telEmpleado")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
      return datos;
    }
    
}


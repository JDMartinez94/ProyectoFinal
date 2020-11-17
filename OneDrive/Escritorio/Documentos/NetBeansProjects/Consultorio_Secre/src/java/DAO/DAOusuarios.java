
package DAO;

import Clases.empleados;
import Clases.usuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOusuarios implements Operaciones{
    Database db = new Database();
    
    @Override
    public String insertar(Object obj) {
        usuarios usu = (usuarios) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "insert into usuarios values(?,?,?,?,?)";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, usu.getIdUsuario());
            pst.setString(2, usu.getNombreUsuario());
            pst.setString(3, usu.getContra());
            pst.setString(4, usu.getTipoUsuario());
            pst.setInt(5, usu.getIdEmpleado().getIdEmpleado());
            int filas =  pst.executeUpdate();
            respuesta = "se registraron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String eliminar(Object obj) {
        usuarios usu = (usuarios) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "delete from usuarios where idUsuario=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, usu.getIdUsuario());
            int filas =  pst.executeUpdate();
            respuesta = "se eliminaron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String modificar(Object obj) {
        usuarios usu = (usuarios) obj;
        Connection conn;
        PreparedStatement pst;
        String sql= "update usuarios set nombreUsuario=?, contra=?, tipoUsuario=?, idEmpleado=? where idUsuario=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
             pst.setString(1, usu.getNombreUsuario());
            pst.setString(2, usu.getContra());
            pst.setString(3, usu.getTipoUsuario());
            pst.setInt(4, usu.getIdEmpleado().getIdEmpleado());
            pst.setInt(5, usu.getIdUsuario());
            int filas =  pst.executeUpdate();
            respuesta = "se modificaron " + filas + " elementos";
            conn.close();       
        } catch (ClassNotFoundException | SQLException e) {
        }
        return respuesta; 
    }

    @Override
    public List<usuarios> consultar() {
        List<usuarios> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from usuarios";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new usuarios(
                        rs.getInt("idUsuario"), 
                        rs.getString("nombreUsuario"),
                        rs.getString("contra"),
                        rs.getString("tipoUsuario"),
                        new empleados (rs.getInt("idEmpleado"))));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
       return datos;
    }

    @Override
    public List<usuarios> filtrar(String campo, String criterio) {
        List<usuarios> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from usuarios where " + campo + " like '%"+criterio+"%'";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new usuarios(
                        rs.getInt("idUsuario"), 
                        rs.getString("nombreUsuario"),
                        rs.getString("contra"),
                        rs.getString("tipoUsuario"),
                        new empleados (rs.getInt("idEmpleado"))));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
      return datos;
    }
    
    public List<usuarios> loguear(String user, String pw)
    {
        List<usuarios> data = new ArrayList<>(); 
        Connection con; 
        PreparedStatement pst; 
        ResultSet rs; 
        String sql = "select nombreUsuario, tipoUsuario from usuarios where nombreUsuario= '"+user+"' and contra ='"+pw+"'"; 
        
        try {
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getContraseña()); 
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(); 
            
            while(rs.next())
            {
                data.add(new usuarios(rs.getString("nombreusuario"), rs.getString("tipoUsuario")));
            }
            
            con.close();
            
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return data; 
    }


}


package DAO;

import Clases.citas;
import Clases.pacientes;
import Clases.usuarios;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOcitas implements Operaciones {
    Database db = new Database();
    
    @Override
    public String insertar(Object obj) {
        citas cit = (citas) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "insert into citas values(?,?,?,?,?,?)";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, cit.getIdCita());
            pst.setInt(2, cit.getIdPaciente().getIdPaciente());
            pst.setDate(3, cit.getFechaCita());
            pst.setTime(4, cit.getHoraCita());
            pst.setString(5, cit.getStatusCita());
            pst.setInt(6, cit.getIdUsuario().getIdUsuario());
            int filas =  pst.executeUpdate();
            respuesta = "se registraron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String eliminar(Object obj) {
        citas cit = (citas) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "delete from citas where idCita=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, cit.getIdCita());
            int filas =  pst.executeUpdate();
            respuesta = "se eliminaron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String modificar(Object obj) {
        citas cit = (citas) obj;
        Connection conn;
        PreparedStatement pst;
        String sql= "update citas set idPaciente=?, fechaCita=?, horaCita=?, statusCita=? , idUsuario=?   where idCita=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, cit.getIdPaciente().getIdPaciente());
            pst.setDate(2, cit.getFechaCita());
            pst.setTime(3, cit.getHoraCita());
            pst.setString(4, cit.getStatusCita());
            pst.setInt(5, cit.getIdUsuario().getIdUsuario());
            pst.setInt(6, cit.getIdCita());
            int filas =  pst.executeUpdate();
            respuesta = "se modificaron " + filas + " elementos";
            conn.close();       
        } catch (ClassNotFoundException | SQLException e) {
        }
        return respuesta; 
    }

    @Override
    public List<citas> consultar() {
        List<citas> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from citas";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new citas(
                        rs.getInt("idCita"), 
                        new pacientes (rs.getInt("idPaciente")),
                        rs.getDate("fechaCita"),
                        rs.getTime("horaCita"),
                        rs.getString("statusCita"),
                        new usuarios (rs.getInt("idUsuario"))));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
       return datos;
    }
    

    public List<citas> consultar2() {
        List<citas> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select c.idCita, p.nombresPaciente, p.apellidosPaciente, c.fechaCita, c.horaCita, c.statusCita, u.nombreUsuario\n" +
                    "from citas c \n" +
                    "join pacientes p on p.idPaciente = c.idPaciente\n" +
                    "join usuarios u on u.idUsuario = c.idUsuario\n" +
                    "where fechaCita = CURDATE();";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new citas(
                        rs.getInt("idCita"), 
                        new pacientes(rs.getString("nombresPaciente"), rs.getString("apellidosPaciente")),
                        rs.getDate("fechaCita"),
                        rs.getTime("horaCita"),
                        rs.getString("statusCita"),
                        new usuarios(rs.getString("nombreUsuario"))));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
       return datos;
    }
    
    
    public List<citas> consultar3() {
        List<citas> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select c.idCita, p.nombresPaciente, p.apellidosPaciente, c.fechaCita, c.horaCita, c.statusCita, u.nombreUsuario\n" +
                    "from citas c \n" +
                    "join pacientes p on p.idPaciente = c.idPaciente\n" +
                    "join usuarios u on u.idUsuario = c.idUsuario\n" +
                    "where fechaCita > CURDATE();";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new citas(
                        rs.getInt("idCita"), 
                        new pacientes(rs.getString("nombresPaciente"), rs.getString("apellidosPaciente")),
                        rs.getDate("fechaCita"),
                        rs.getTime("horaCita"),
                        rs.getString("statusCita"),
                        new usuarios(rs.getString("nombreUsuario"))));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
       return datos;
    }

    @Override
    public List<citas> filtrar(String campo, String criterio) {
        List<citas> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from citas where " + campo + " like '%"+criterio+"%'";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new citas(
                        rs.getInt("idCita"), 
                        new pacientes (rs.getInt("idPaciente")),
                        rs.getDate("fechaCita"),
                        rs.getTime("horaCita"),
                        rs.getString("statusCita"),
                        new usuarios (rs.getInt("idUsuario"))));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
      return datos;
    }
}

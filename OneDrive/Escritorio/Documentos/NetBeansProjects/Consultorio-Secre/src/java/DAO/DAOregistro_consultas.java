
package DAO;

import Clases.citas;
import Clases.registro_consultas;
import Clases.usuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOregistro_consultas implements Operaciones {
    Database db = new Database();
    
    @Override
    public String insertar(Object obj) {
        registro_consultas regc = (registro_consultas) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "insert into registro_consultas values(?,?,?,?)";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, regc.getIdregConsulta());
            pst.setInt(2, regc.getIdCita().getIdCita());
            pst.setString(3, regc.getDiagnosticoConsulta());
            pst.setInt(4, regc.getIdUsuario().getIdUsuario());
            int filas =  pst.executeUpdate();
            respuesta = "se registraron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String eliminar(Object obj) {
        registro_consultas regc = (registro_consultas) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "delete from registro_consultas where idregConsulta=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, regc.getIdregConsulta());
            int filas =  pst.executeUpdate();
            respuesta = "se eliminaron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String modificar(Object obj) {
        registro_consultas regc = (registro_consultas) obj;
        Connection conn;
        PreparedStatement pst;
        String sql= "update registro_consultas set idCita=?, diagnosticoConsulta=?, idUsuario=?  where idregConsulta=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, regc.getIdCita().getIdCita());
            pst.setString(2, regc.getDiagnosticoConsulta());
            pst.setInt(3, regc.getIdUsuario().getIdUsuario());
            pst.setInt(4, regc.getIdregConsulta());
            int filas =  pst.executeUpdate();
            respuesta = "se modificaron " + filas + " elementos";
            conn.close();       
        } catch (ClassNotFoundException | SQLException e) {
        }
        return respuesta; 
    }

    @Override
    public List<registro_consultas> consultar() {
        List<registro_consultas> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from registro_consultas";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new registro_consultas(
                        rs.getInt("idregConsulta"), 
                        new citas (rs.getInt("idCita")),
                        rs.getString("diagnosticoConsulta"),
                        new usuarios (rs.getInt("idUsuario"))));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
       return datos;
    }

    @Override
    public List<registro_consultas> filtrar(String campo, String criterio) {
        List<registro_consultas> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from registro_consultas where " + campo + " like '%"+criterio+"%'";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new registro_consultas(
                        rs.getInt("idregConsulta"), 
                        new citas (rs.getInt("idCita")),
                        rs.getString("diagnosticoConsulta"),
                        new usuarios (rs.getInt("idUsuario"))));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
      return datos;
    }
}

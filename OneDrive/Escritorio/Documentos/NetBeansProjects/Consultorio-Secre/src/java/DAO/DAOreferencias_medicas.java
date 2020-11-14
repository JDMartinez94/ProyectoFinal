
package DAO;

import Clases.referencias_medicas;
import Clases.registro_consultas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOreferencias_medicas implements Operaciones{
    Database db = new Database();
    
    @Override
    public String insertar(Object obj) {
        referencias_medicas refm = (referencias_medicas) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "insert into referencias_medicas values(?,?,?,?)";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, refm.getIdReferencia());
            pst.setInt(2, refm.getIdregConsulta().getIdregConsulta());
            pst.setString(3, refm.getMotivoRef());
            pst.setString(4, refm.getReferidoA());
            int filas =  pst.executeUpdate();
            respuesta = "se registraron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String eliminar(Object obj) {
        referencias_medicas refm = (referencias_medicas) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "delete from referencias_medicas where idReferencia=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, refm.getIdReferencia());
            int filas =  pst.executeUpdate();
            respuesta = "se eliminaron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String modificar(Object obj) {
        referencias_medicas refm = (referencias_medicas) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "update referencias_medicas set idregConsulta=?, motivoRef=?, ReferidoA=?  where idReferencia=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, refm.getIdregConsulta().getIdregConsulta());
            pst.setString(2, refm.getMotivoRef());
            pst.setString(3, refm.getReferidoA());
            pst.setInt(4, refm.getIdReferencia());
            int filas =  pst.executeUpdate();
            respuesta = "se modificaron " + filas + " elementos";
            conn.close();       
        } catch (ClassNotFoundException | SQLException e) {
        }
        return respuesta; 
    }

    @Override
    public List<referencias_medicas> consultar() {
        List<referencias_medicas> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from referencias_medicas";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new referencias_medicas(
                        rs.getInt("idReferencia"), 
                        new registro_consultas (rs.getInt("idregConsulta")),
                        rs.getString("motivoRef"),
                        rs.getString("ReferidoA")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
       return datos;
    }

    @Override
    public List<referencias_medicas> filtrar(String campo, String criterio) {
        List<referencias_medicas> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from referencias_medicas where " + campo + " like '%"+criterio+"%'";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new referencias_medicas(
                        rs.getInt("idReferencia"), 
                        new registro_consultas (rs.getInt("idregConsulta")),
                        rs.getString("motivoRef"),
                        rs.getString("ReferidoA")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
      return datos;
    }
}

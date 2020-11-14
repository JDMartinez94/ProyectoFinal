
package DAO;

import Clases.recetas_medicas;
import Clases.registro_consultas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOrecetas_medicas implements Operaciones{
    Database db = new Database();
    
    @Override
    public String insertar(Object obj) {
        recetas_medicas recm = (recetas_medicas) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "insert into recetas_medicas values(?,?,?,?)";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, recm.getIdregReceta());
            pst.setInt(2, recm.getIdregConsulta().getIdregConsulta());
            pst.setString(3, recm.getNombreMedicina());
            pst.setString(4, recm.getIndicaciones());
            int filas =  pst.executeUpdate();
            respuesta = "se registraron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String eliminar(Object obj) {
        recetas_medicas recm = (recetas_medicas) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "delete from recetas_medicas where idregReceta=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, recm.getIdregReceta());
            int filas =  pst.executeUpdate();
            respuesta = "se eliminaron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String modificar(Object obj) {
        recetas_medicas recm = (recetas_medicas) obj;
        Connection conn;
        PreparedStatement pst;
        String sql= "update recetas_medicas set idregConsulta=?, nombreMedicina=?, indicaciones=?  where idregReceta=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, recm.getIdregConsulta().getIdregConsulta());
            pst.setString(2, recm.getNombreMedicina());
            pst.setString(3, recm.getIndicaciones());
            pst.setInt(4, recm.getIdregReceta());
            int filas =  pst.executeUpdate();
            respuesta = "se modificaron " + filas + " elementos";
            conn.close();       
        } catch (ClassNotFoundException | SQLException e) {
        }
        return respuesta; 
    }

    @Override
    public List<recetas_medicas> consultar() {
        List<recetas_medicas> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from recetas_medicas";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new recetas_medicas(
                        rs.getInt("idregReceta"), 
                        new registro_consultas (rs.getInt("idregConsulta")),
                        rs.getString("nombreMedicina"),
                        rs.getString("indicaciones")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
       return datos;
    }

    @Override
    public List<recetas_medicas> filtrar(String campo, String criterio) {
        List<recetas_medicas> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from recetas_medicas where " + campo + " like '%"+criterio+"%'";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new recetas_medicas(
                        rs.getInt("idregReceta"), 
                        new registro_consultas (rs.getInt("idregConsulta")),
                        rs.getString("nombreMedicina"),
                        rs.getString("indicaciones")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
      return datos;
    }
}

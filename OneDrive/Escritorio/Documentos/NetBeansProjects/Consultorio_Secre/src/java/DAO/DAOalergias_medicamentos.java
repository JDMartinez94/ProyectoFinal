
package DAO;

import Clases.alergias_medicamentos;
import Clases.pacientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOalergias_medicamentos implements Operaciones {
    Database db = new Database();
    
    @Override
    public String insertar(Object obj) {
        alergias_medicamentos alem = (alergias_medicamentos) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "insert into alergias_medicamentos values(?,?,?)";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, alem.getIdAlergia());
            pst.setInt(2, alem.getIdPaciente().getIdPaciente());
            pst.setString(4, alem.getAlergia_a_med());
            int filas =  pst.executeUpdate();
            respuesta = "se registraron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String eliminar(Object obj) {
        alergias_medicamentos alem = (alergias_medicamentos) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "delete from alergias_medicamentos where idAlergia=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, alem.getIdAlergia());
            int filas =  pst.executeUpdate();
            respuesta = "se eliminaron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String modificar(Object obj) {
        alergias_medicamentos alem = (alergias_medicamentos) obj;
        Connection conn;
        PreparedStatement pst;
        String sql= "update alergias_medicamentos set idPaciente=?, alergia_a_med=? where idAlergia=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, alem.getIdPaciente().getIdPaciente());
            pst.setString(2, alem.getAlergia_a_med());
            pst.setInt(3, alem.getIdAlergia());
            int filas =  pst.executeUpdate();
            respuesta = "se modificaron " + filas + " elementos";
            conn.close();       
        } catch (ClassNotFoundException | SQLException e) {
        }
        return respuesta; 
    }

    @Override
    public List<alergias_medicamentos> consultar() {
        List<alergias_medicamentos> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from alergias_medicamentos";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new alergias_medicamentos(
                        rs.getInt("idAlergia"), 
                        new pacientes (rs.getInt("idPaciente")),
                        rs.getString("alergia_a_med")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
       return datos;
    }

    @Override
    public List<alergias_medicamentos> filtrar(String campo, String criterio) {
        List<alergias_medicamentos> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from alergias_medicamentos where " + campo + " like '%"+criterio+"%'";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new alergias_medicamentos(
                        rs.getInt("idAlergia"), 
                        new pacientes (rs.getInt("idPaciente")),
                        rs.getString("alergia_a_med")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
      return datos;
    }
}

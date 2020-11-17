
package DAO;

import Clases.operaciones;
import Clases.pacientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

public class DAOoperaciones implements Operaciones {
    Database db = new Database();
    
    @Override
    public String insertar(Object obj) {
        operaciones ope = (operaciones) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "insert into operaciones values(?,?,?,?)";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, ope.getIdOperacion());
            pst.setInt(2, ope.getIdPaciente().getIdPaciente());
            pst.setString(3, ope.getOperacion());
            pst.setInt(4, ope.getAnioOper());
            int filas =  pst.executeUpdate();
            respuesta = "se registraron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String eliminar(Object obj) {
        operaciones ope = (operaciones) obj; 
        Connection conn;
        PreparedStatement pst;
        String sql= "delete from operaciones where idOperacion=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, ope.getIdOperacion());
            int filas =  pst.executeUpdate();
            respuesta = "se eliminaron " + filas + " nuevo elemento";
            conn.close(); 
        } catch (ClassNotFoundException | SQLException e) {
        }
        
        return respuesta; 
    }

    @Override
    public String modificar(Object obj) {
        operaciones ope = (operaciones) obj;
        Connection conn;
        PreparedStatement pst;
        String sql= "update operaciones set idPaciente=?, operacion=?, anioOper=?  where idOperacion=?";
        String respuesta="";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),
            db.getUsuario(),
            db.getContraseña()            
            );
            
            pst= conn.prepareStatement(sql);
            pst.setInt(1, ope.getIdPaciente().getIdPaciente());
            pst.setString(2, ope.getOperacion());
            pst.setInt(3, ope.getAnioOper());
            pst.setInt(4, ope.getIdOperacion());
            int filas =  pst.executeUpdate();
            respuesta = "se modificaron " + filas + " elementos";
            conn.close();       
        } catch (ClassNotFoundException | SQLException e) {
        }
        return respuesta; 
    }

    @Override
    public List<operaciones> consultar() {
        List<operaciones> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from operaciones";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new operaciones(
                        rs.getInt("idOperacion"), 
                        new pacientes (rs.getInt("idPaciente")),
                        rs.getString("operacion"),
                        rs.getInt("anioOper")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
       return datos;
    }

    @Override
    public List<operaciones> filtrar(String campo, String criterio) {
        List<operaciones> datos = new ArrayList<>();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from operaciones where " + campo + " like '%"+criterio+"%'";
        try {
            Class.forName(db.getDriver());
            conn = DriverManager.getConnection(
            db.getUrl(),db.getUsuario(), db.getContraseña());
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                datos.add(new operaciones(
                        rs.getInt("idOperacion"), 
                        new pacientes (rs.getInt("idPaciente")),
                        rs.getString("operacion"),
                        rs.getInt("anioOper")));
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            
        }
      return datos;
    }
}

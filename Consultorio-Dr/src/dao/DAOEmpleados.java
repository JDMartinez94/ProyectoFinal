package dao;
import java.sql.*;
import java.util.*;
import modelo.Database;
import modelo.Empleados;
/**
 *
 * @author jdmar
 */
public class DAOEmpleados implements Operaciones {
    
    Database db = new Database();
    Empleados emp = new Empleados();
    

    @Override
    public boolean insertar(Object obj) {
        
        this.emp = (Empleados) obj;
        Connection con;
        PreparedStatement pst;
        String sql="insert into empleados (nombreEmpleado, direccionEmpleado, telEmpleado) values (?,?,?);";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);
            pst.setString(1, this.emp.getNombreEmpleado());
            pst.setString(2, this.emp.getDireccionEmpleado());
            pst.setString(3, this.emp.getTelEmpleado());
            
            int filas = pst.executeUpdate();
            if(filas>0){
                con.close();
                pst.close();
                return true;
            }else{
                con.close();
                pst.close();
                return false;
            }            
            
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modificar(Object obj) {
        
        this.emp = (Empleados) obj;
        Connection con;
        PreparedStatement pst;
        String sql="update empleados set nombreEmpleado = ?, direccionEmpleado = ?, telEmpleado = ? where idEmpleado = ?;";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);            
            pst.setString(1, this.emp.getNombreEmpleado());
            pst.setString(2, this.emp.getDireccionEmpleado());
            pst.setString(3, this.emp.getTelEmpleado());
            pst.setInt(4, this.emp.getIdEmpleado());
            
            int filas = pst.executeUpdate();
            if(filas>0){
                con.close();
                pst.close();
                return true;
            }else{
                con.close();
                pst.close();
                return false;
            }            
            
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(Object obj) {
        
        this.emp = (Empleados) obj;
        Connection con;
        PreparedStatement pst;
        String sql="delete from empleados where idEmpleado = ?;";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);                        
            pst.setInt(1, this.emp.getIdEmpleado());
            
            int filas = pst.executeUpdate();
            if(filas>0){
                con.close();
                pst.close();
                return true;
            }else{
                con.close();
                pst.close();
                return false;
            }            
            
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Object[]> consultar() {
        ArrayList <Object[]>  data = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql="";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                Object [] fila = new Object[4]; //Cantidad de columnas de la tabla
                for(int i=0; i<=3; i++){
                    fila[i]=rs.getObject(i+1);
                }
                data.add(fila);
            }
            con.close();
            pst.close();            
        }catch(ClassNotFoundException | SQLException e){
        e.printStackTrace();       
    }
        return data;
    }
    
}
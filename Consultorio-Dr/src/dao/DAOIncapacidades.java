package dao;
import java.sql.*;
import java.util.*;
import modelo.Database;
import modelo.Incapacidades;
/**
 *
 * @author jdmar
 */
public class DAOIncapacidades implements Operaciones {
    
    Database db = new Database();
    Incapacidades inca = new Incapacidades();
    

    @Override
    public boolean insertar(Object obj) {
        
        this.inca = (Incapacidades) obj;
        Connection con;
        PreparedStatement pst;
        String sql="insert into incapacidades (idregConsulta, finalInca) values (?, ?);";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);
            pst.setInt(1, this.inca.getIdregConsulta().getIdregConsulta());
            pst.setString(2, this.inca.getFinalInca());
            
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
        
        this.inca = (Incapacidades) obj;
        Connection con;
        PreparedStatement pst;
        String sql="update incapacidades set idregConsulta = ?, finalInca = ? where idInca = ?;";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);            
            pst.setInt(1, this.inca.getIdregConsulta().getIdregConsulta());
            pst.setString(2, this.inca.getFinalInca());
            pst.setInt(3, this.inca.getIdInca());            
            
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
        
        this.inca = (Incapacidades) obj;
        Connection con;
        PreparedStatement pst;
        String sql="delete from incapacidades where idInca = ?;";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);                        
            pst.setInt(1, this.inca.getIdInca());
            
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
        String sql="select * from incapacidades;";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                Object [] fila = new Object[3]; //Cantidad de columnas de la tabla
                for(int i=0; i<=2; i++){
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
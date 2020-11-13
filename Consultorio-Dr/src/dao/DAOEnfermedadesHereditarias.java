package dao;
import java.sql.*;
import java.util.*;
import modelo.Database;
import modelo.EnfermedadesHereditarias;
/**
 *
 * @author jdmar
 */
public class DAOEnfermedadesHereditarias implements Operaciones {
    
    Database db = new Database();
    EnfermedadesHereditarias enfHer = new EnfermedadesHereditarias();
    

    @Override
    public boolean insertar(Object obj) {
        
        this.enfHer = (EnfermedadesHereditarias) obj;
        Connection con;
        PreparedStatement pst;
        String sql = "insert into enfermedades_hereditarias (idPaciente, enfermedadH) values (?, ?);";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);
            pst.setInt(1, this.enfHer.getIdPaciente().getIdPaciente());
            pst.setString(2, this.enfHer.getEnfermedadH());
            
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
        
        this.enfHer = (EnfermedadesHereditarias) obj;
        Connection con;
        PreparedStatement pst;
        String sql = "update enfermedades_hereditarias set idPaciente = ?, enfermedadH = ? where idEnfermedadH = ?;";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);            
            pst.setInt(1, this.enfHer.getIdPaciente().getIdPaciente());
            pst.setString(2, this.enfHer.getEnfermedadH());
            pst.setInt(3, this.enfHer.getIdEnfermedadH());
            
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
        
        this.enfHer = (EnfermedadesHereditarias) obj;
        Connection con;
        PreparedStatement pst;
        String sql = "delete from enfermedades_hereditarias where idEnfermedadH = ?;";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);                        
            pst.setInt(1, this.enfHer.getIdEnfermedadH());
            
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
        String sql = "select * from enfermedades_hereditarias;";
        
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
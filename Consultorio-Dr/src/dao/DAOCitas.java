package dao;
import java.sql.*;
import java.util.*;
import modelo.Database;
import modelo.Citas;
/**
 *
 * @author jdmar
 */
public class DAOCitas implements Operaciones {
    
    Database db = new Database();
    Citas cit = new Citas();
    

    @Override
    public boolean insertar(Object obj) {
        
        this.cit = (Citas) obj;
        Connection con;
        PreparedStatement pst;
        String sql="insert into citas (idPaciente, fechaCita, horaCita, statusCita, idUsuario) values (?,?,?,?,?);";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);            
            pst.setInt(1, this.cit.getIdPaciente().getIdPaciente());
            pst.setString(2, this.cit.getFechaCita());
            pst.setString(3, this.cit.getHoraCita());
            pst.setString(4, this.cit.getStatusCita());
            pst.setInt(5, this.cit.getIdUsuario().getIdUsuario());
            
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
        
        this.cit = (Citas) obj;
        Connection con;
        PreparedStatement pst;
        String sql="update citas set idPaciente = ?, fechaCita = ?, horaCita = ?, statusCita = ?, idUsuario = ? where idCita = ?;";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);            
            pst.setInt(1, this.cit.getIdPaciente().getIdPaciente());
            pst.setString(2, this.cit.getFechaCita());
            pst.setString(3, this.cit.getHoraCita());
            pst.setString(4, this.cit.getStatusCita());
            pst.setInt(5, this.cit.getIdUsuario().getIdUsuario());
            pst.setInt(6, this.cit.getIdCita());
            
            
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
        
        this.cit = (Citas) obj;
        Connection con;
        PreparedStatement pst;
        String sql="delete from citas where idCita = ?;";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);                        
            pst.setInt(1, this.cit.getIdCita());
            
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
        String sql="select * from citas;";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                Object [] fila = new Object[6]; //Cantidad de columnas de la tabla
                for(int i=0; i<=5; i++){
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
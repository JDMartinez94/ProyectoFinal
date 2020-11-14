package dao;
import java.sql.*;
import java.util.*;
import modelo.Database;
import modelo.AlergiasMedicamentos;
/**
 *
 * @author jdmar
 */
public class DAOAlergiasMedicamentos implements Operaciones {
    
    Database db = new Database();
    AlergiasMedicamentos alermed = new AlergiasMedicamentos();

    @Override
    public boolean insertar(Object obj) {        
        this.alermed = (AlergiasMedicamentos) obj;
        Connection con;
        PreparedStatement pst;
        String sql="insert into alergias_medicamentos (idPaciente, alergia_a_med) values (?,?);";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);            
            pst.setInt(1, this.alermed.getIdPaciente().getIdPaciente());
            pst.setString(2, this.alermed.getAlergia_a_med());
            
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
        this.alermed = (AlergiasMedicamentos) obj;
        Connection con;
        PreparedStatement pst;
        String sql="update alergias_medicamentos set idPaciente = ?, alergia_a_med = ? where idAlergia = ?;";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);            
            pst.setInt(1, this.alermed.getIdPaciente().getIdPaciente());
            pst.setString(2, this.alermed.getAlergia_a_med());
            pst.setInt(3, this.alermed.getIdAlergia());
            
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
        this.alermed = (AlergiasMedicamentos) obj;
        Connection con;
        PreparedStatement pst;
        String sql="delete from alergias_medicamentos where idAlergia = ?;";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);                        
            pst.setInt(1, this.alermed.getIdAlergia());
            
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
        String sql="select * from alergias_medicamentos;";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUsuario(),db.getContra());
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                Object [] fila = new Object[5]; //Cantidad de columnas de la tabla
                for(int i=0; i<=4; i++){
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

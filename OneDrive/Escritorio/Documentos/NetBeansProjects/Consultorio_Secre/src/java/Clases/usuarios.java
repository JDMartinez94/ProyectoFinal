
package Clases;


public class usuarios {
    private int idUsuario; 
    private String nombreUsuario;
    private String contra; 
    private String tipoUsuario; 
    private empleados idEmpleado; 

    public usuarios() {
    }
    
    public usuarios(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public usuarios(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public usuarios(String nombreUsuario, String tipoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public usuarios(int idUsuario, String nombreUsuario, String contra, String tipoUsuario, empleados idEmpleado) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contra = contra;
        this.tipoUsuario = tipoUsuario;
        this.idEmpleado = idEmpleado;
    }

    public empleados getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(empleados idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    
}

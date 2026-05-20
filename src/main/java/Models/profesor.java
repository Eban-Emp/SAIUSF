
package Models;


public class profesor {
    private int id;
    private String nombre;
    private String apellido;
    private String grado_academico;
    private String cedula;
    private String telefono;
    private String correo;
    private int status;
    private String uuid;

    public profesor() {
    }

    public profesor(int id, String nombre, String apellido, String grado_academico, String cedula, String telefono, String correo, int status, String uuid) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.grado_academico = grado_academico;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.status = status;
        this.uuid = uuid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombre;
    }

    public void setNombres(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellido;
    }

    public void setApellidos(String apellido) {
        this.apellido = apellido;
    }

    public String getGrado_academico() {
        return grado_academico;
    }

    public void setGrado_academico(String grado_academico) {
        this.grado_academico = grado_academico;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    
    
    
}

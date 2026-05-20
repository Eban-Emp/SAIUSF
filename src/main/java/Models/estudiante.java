
package Models;


public class estudiante {
    private int id;
    private String nombres;
    private String apellidos;
    private String cedula;
    private String telefono;
    private String correo;
    private String sexo;
    private String procedencia;
    private int id_carrera;
    private String nombre_carrera;
    private String semestre;
    private int status;
    private String fecha_registro;
    private String uuid;

    public estudiante() {
    }

    public estudiante(int id, String nombres, String apellidos, String cedula, String telefono, String correo, String sexo, String procedencia, int id_carrera, String nombre_carrera, String semestre, int status, String fecha_registro, String uuid) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.sexo = sexo;
        this.procedencia = procedencia;
        this.id_carrera = id_carrera;
        this.nombre_carrera = nombre_carrera;
        this.semestre = semestre;
        this.status = status;
        this.fecha_registro = fecha_registro;
        this.uuid = uuid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public int getCarrera() {
        return id_carrera;
    }

    public void setCarrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }
    
    public String getNombreCarrera() {
        return nombre_carrera;
    }

    public void setNombreCarrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }
    
    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public int getEstado() {
        return status;
    }

    public void setEstado(int status) {
        this.status = status;
    }
    
    public String getFecha_registro(){
        return fecha_registro;
    }
    
    public void setFecha_registro(String fecha_registro){
        this.fecha_registro = fecha_registro;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
 
    
    
}

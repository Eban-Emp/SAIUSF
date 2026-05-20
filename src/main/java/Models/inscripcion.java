
package Models;


public class inscripcion {
    private int id;
    private int id_estudiante;
    private int id_curso;
    private String fecha_inscripcion;
    private String estado;
    private int status;
    private String nombre;
    private String apellido;
    private String nombre_completo;
    private String carrera_estudiante;
    private String sexo_estudiante;
    private String procedencia;
    private String nombre_curso;
    private String costo_curso;
    private String cedula;
    private String duracion;
    private String fecha_inicio;
    private String facilitador_completo;
    private String periodo;
    private String semestre;
    private String detalles;

    public inscripcion() {
    }

    public inscripcion(int id, int id_estudiante, int id_curso, String fecha_inscripcion, String estado, int status, String nombre, String apellido, String nombre_completo, String carrera_estudiante, String sexo_estudiante, String procedencia, String nombre_curso, String costo_curso, String cedula, String duracion, String fecha_inicio, String facilitador_completo, String periodo, String semestre, String detalles) {
        this.id = id;
        this.id_estudiante = id_estudiante;
        this.id_curso = id_curso;
        this.estado = estado;
        this.status = status;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombre_completo = nombre_completo;
        this.carrera_estudiante = carrera_estudiante;
        this.sexo_estudiante = sexo_estudiante;
        this.procedencia = procedencia;
        this.nombre_curso = nombre_curso;
        this.costo_curso = costo_curso;
        this.cedula = cedula;
        this.duracion = duracion;
        this.fecha_inicio = fecha_inicio;
        this.facilitador_completo = facilitador_completo;
        this.periodo = periodo;
        this.semestre = semestre;
        this.detalles = detalles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(String fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFacilitador_completo() {
        return facilitador_completo;
    }

    public void setFacilitador_completo(String facilitador_completo) {
        this.facilitador_completo = facilitador_completo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarrera_estudiante() {
        return carrera_estudiante;
    }

    public void setCarrera_estudiante(String carrera_estudiante) {
        this.carrera_estudiante = carrera_estudiante;
    }

    public String getSexo_estudiante() {
        return sexo_estudiante;
    }

    public void setSexo_estudiante(String sexo_estudiante) {
        this.sexo_estudiante = sexo_estudiante;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getCosto_curso() {
        return costo_curso;
    }

    public void setCosto_curso(String costo_curso) {
        this.costo_curso = costo_curso;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    
    
    
    
}

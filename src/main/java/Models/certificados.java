
package Models;


public class certificados {
    private int id;
    private int id_estudiante;
    private int id_curso;
    private String fecha_inscripcion;
    private String estado;
    private int status;

    public certificados() {
    }

    public certificados(int id, int id_estudiante, int id_curso, String fecha_inscripcion, String estado, int status ) {
        this.id = id;
        this.id_estudiante = id_estudiante;
        this.id_curso = id_curso;
        this.estado = estado;
        this.status = status;
        
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

    public String getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(String fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
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

    

        
}

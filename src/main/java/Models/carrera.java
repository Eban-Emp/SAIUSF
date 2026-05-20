
package Models;


public class carrera {
    private int Id;
    private String nombre;
    private int status;

    public carrera() {
    }

    public carrera(int Id, String nombre, int status) {
        this.Id = Id;
        this.nombre = nombre;
        this.status = status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCarrera() {
        return nombre;
    }

    public void setCarrera(String nombre) {
        this.nombre = nombre;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
}

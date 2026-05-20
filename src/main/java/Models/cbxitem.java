
package Models;


public class cbxitem {
    private int id;
    private String nombre;  

    public cbxitem() {
    }

    public cbxitem(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public cbxitem(int id) { 
   // Este constructor no hace nada, deberías asignar el id:
   this.id = id; 
}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
 public String toString(){
     return this.getNombre();
 }
    
    
}

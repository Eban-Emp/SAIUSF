
package Models;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String rol;
    private String status;
    
    public User() {
    }

    public User(int id, String name, String username, String password, String rol, String status) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return username;
    }

    public void setUsuario(String username) {
        this.username = username;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public String getClave() {
        return password;
    }

    public void setClave(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return status;
    }

    public void setEstado(String status) {
        this.status = status;
    }
    
    
    
    
}

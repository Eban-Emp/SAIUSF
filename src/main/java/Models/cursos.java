
package Models;

public class cursos {
    private int id;
    private String nombre;
    private String detalles;
    private int duracion_horas;
    private double precio;
    private int id_periodo;
    private int id_facilitador;
    private String fecha_inicial;
    private String uuid;
    private String modalidad;
    private String nombre_periodo;
    private String nombre_facilitador;

    public cursos() {
    }

    public cursos(int id, String nombre, String detalles, int duracion_horas, double precio, int id_periodo, int id_facilitador, String fecha_inicial, String uuid, String modalidad, String nombre_periodo, String nombre_facilitador) {
        this.id = id;
        this.nombre = nombre;
        this.detalles = detalles;
        this.duracion_horas = duracion_horas;
        this.precio = precio;
        this.id_periodo = id_periodo;
        this.id_facilitador = id_facilitador;
        this.fecha_inicial = fecha_inicial;
        this.uuid = uuid;
        this.modalidad = modalidad;
        this.nombre_periodo = nombre_periodo;
        this.nombre_facilitador = nombre_facilitador;
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

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getDuracion() {
        return duracion_horas;
    }

    public void setDuracion(int duracion_horas) {
        this.duracion_horas = duracion_horas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(int id_periodo) {
        this.id_periodo = id_periodo;
    }
    
    public int getId_facilitador() {
        return id_facilitador;
    }

    public void setId_facilitador(int id_facilitador) {
        this.id_facilitador = id_facilitador;
    }
    
    public String getFecha_inicial() {
        return fecha_inicial;
    }

    public void setFecha_inicial(String fecha_inicial) {
        this.fecha_inicial = fecha_inicial;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public int getDuracion_horas() {
        return duracion_horas;
    }

    public void setDuracion_horas(int duracion_horas) {
        this.duracion_horas = duracion_horas;
    }

    public String getNombre_periodo() {
        return nombre_periodo;
    }

    public void setNombre_periodo(String nombre_periodo) {
        this.nombre_periodo = nombre_periodo;
    }

    public String getNombre_facilitador() {
        return nombre_facilitador;
    }

    public void setNombre_facilitador(String nombre_facilitador) {
        this.nombre_facilitador = nombre_facilitador;
    }
    
    
    
}

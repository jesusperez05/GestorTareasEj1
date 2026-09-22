public class Tarea {

    String nombre;
    String descripcion;
    boolean completada;
    private Prioridades prioridad;

    // Constructor
    public Tarea(String nombre, String descripcion, Prioridades prioridad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.completada = false;
        this.prioridad = prioridad;
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Indica si la tarea está completada
    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public Prioridades getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridades prioridad) {
        this.prioridad = prioridad;
    }
}




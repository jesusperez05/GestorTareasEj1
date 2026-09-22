public class Tarea {

    private String nombre;
    private String descripcion;
    private boolean completada;
    private Prioridades prioridad;

    // Constructor
    public Tarea(String nombre, String descripcion, Prioridades prioridad) {
        setNombre(nombre);
        setDescripcion(descripcion);
        this.completada = false;
        this.prioridad = prioridad;
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        //Comprobando que el nombre no sea vacío
        if (!nombre.isEmpty()) {
            this.nombre = nombre;
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        //Comprobando que la descripción no esté vacío
        if (!descripcion.isEmpty()) {
            this.descripcion = descripcion;
        }
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




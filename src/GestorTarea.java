import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class GestorTarea {

    Scanner sc = new Scanner(System.in);

    ArrayList<Tarea> Tareas = new ArrayList<>();

    private void añadirTarea() {
        String nombre;
        String descripcion;
        Prioridades tipoPrioridad;


        System.out.println("\nAgregar Tarea");
        System.out.println("Introduce el nombre: ");
        nombre = sc.nextLine();

        System.out.println("Introduce la descripción: ");
        descripcion = sc.nextLine();

        System.out.println("¿Qué prioridad quiere tener?");
        tipoPrioridad = Prioridades.valueOf(sc.next().toUpperCase());

        // Crea y guarda la tarea
        Tarea tarea = new Tarea(nombre, descripcion, tipoPrioridad);
        Tareas.add(tarea);

        System.out.println("Tarea añadida correctamente.");
    }

    private void eliminarTarea() {
        String nombre;

        System.out.println("\nEliminar Tarea");
        System.out.println("Introduce el nombre: ");
        nombre = sc.nextLine();

        // Busca y elimina la tarea
        //No entiendo muy bien esto, habría estado bien si se hubiese usado if normal.
        boolean eliminada = Tareas.removeIf(
                tarea -> tarea.getNombre().equalsIgnoreCase(nombre)
        );

        if (eliminada) {
            System.out.println("Tarea eliminada correctamente.");
        } else {
            System.out.println("No se encontró una tarea con ese nombre.");
        }
    }

    private boolean completarTarea() {
        String nombre;

        System.out.println("\nCompletar Tarea");
        System.out.println("¿Qué tarea ha sido completada?");
        nombre = sc.nextLine();


        // Busca la tarea por nombre
        for (Tarea tarea : Tareas) {
            if (tarea.getNombre().equalsIgnoreCase(nombre)) {

                // Marca la tarea como completada
                tarea.setCompletada(true);

                System.out.println("Tarea marcada como completada.");
                return true;
            }
        }

        System.out.println("No se encontró una tarea con ese nombre.");
        return false;
    }

    // Muestra solo las tareas pendientes
    private void verTareasPendientes() {
        System.out.println("\n--- TAREAS PENDIENTES ---");

        boolean hayPendientes = false;

        for (Tarea tarea : Tareas) {

            if (!tarea.isCompletada()) {
                System.out.println("Nombre: " + tarea.getNombre());
                System.out.println("Descripción: " + tarea.getDescripcion());
                System.out.println("Prioridad: " + tarea.getPrioridad());
                System.out.println("-------------------------");

                hayPendientes = true;
            }
        }

        if (!hayPendientes) {
            System.out.println("No hay tareas pendientes.");
        }
    }

    public void iniciar() {
        int opcion;

        // Repite el menú hasta elegir salir
        do {
            System.out.println("\n======================");
            System.out.println("     GESTOR DE TAREAS");
            System.out.println("======================");
            System.out.println("1. Añadir tarea");
            System.out.println("2. Ver tareas pendientes");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Salir");
            System.out.println("======================");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {

                    case 1:
                        añadirTarea();
                        break;

                    case 2:
                        verTareasPendientes();
                        break;

                    case 3:
                        completarTarea();
                        break;

                    case 4:
                        eliminarTarea();
                        break;

                    case 5:
                        System.out.println("Saliendo del gestor...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

            } catch (NumberFormatException e) {

                // Controla si se introduce algo que no sea un número
                System.out.println("Debes introducir un número.");
                opcion = 0;
            }

        } while (opcion != 5);
    }
}


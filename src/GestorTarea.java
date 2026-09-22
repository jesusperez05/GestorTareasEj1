import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorTarea {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Tarea> Tareas = new ArrayList<>();

    private static void anhadirTarea() {
        String nombre;
        String descripcion;
        Prioridades tipoPrioridad;


        System.out.println("Agregar Tarea");
        System.out.print("Introduce el nombre: ");
        nombre = sc.nextLine();

        System.out.print("Introduce la descripción: ");
        descripcion = sc.nextLine();

        System.out.print("¿Qué prioridad quiere tener?");
        tipoPrioridad = Prioridades.valueOf(sc.next().toUpperCase());

        // Crea y guarda la tarea
        Tarea tarea = new Tarea(nombre, descripcion, tipoPrioridad);
        Tareas.add(tarea);

        System.out.println("Tarea añadida correctamente.");
    }

    private static void eliminarTarea() {
        String nombre;

        System.out.println("Eliminar Tarea");
        System.out.print("Introduce el nombre: ");
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

    private static boolean completarTarea() {
        String nombre;

        System.out.println("Completar Tarea");
        System.out.print("¿Qué tarea ha sido completada?");
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
    private static void verTareasPendientes() {
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

    public static void iniciar() {
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
            System.out.println("5. Filtrar tareas por prioridad");
            System.out.println("6. Guardar tareas en un archivo de texto");
            System.out.println("7. Salir");
            System.out.println("======================");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {

                    case 1:
                        anhadirTarea();
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
                        filtrarPorPrioridad();
                        break;

                    case 6:
                        guardarFicheroTexto();
                        break;

                    case 7:
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

        } while (opcion != 7);
    }

    private static void filtrarPorPrioridad() {
        //Pedir tipo de prioridad por scanner (ALTA, MEDIA, BAJA)
        Prioridades tipoPrioridad;

        System.out.print("Introduzca qué tipo de prioridad quiere ver (ALTA, MEDIA, BAJA): ");
        tipoPrioridad = Prioridades.valueOf(sc.next().toUpperCase());

        for (Tarea tarea : Tareas) {
            if (tarea.getPrioridad() == tipoPrioridad) {
                System.out.println("Nombre: " + tarea.getNombre());
                System.out.println("Descripción: " + tarea.getDescripcion());
                System.out.println("Prioridad: " + tarea.getPrioridad());
                System.out.println("-------------------------");
            }
        }

        iniciar();
    }

    private static void guardarFicheroTexto() {
        //Usamos BufferedWriter y recorremos cada línea guardándola en un fichero .txt

        String nombreFichero;
        System.out.print("Introduzca el nombre del fichero");
        nombreFichero = sc.next();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero));
            //Por cada línea guardo el texto
            for (Tarea tarea : Tareas) {
                bw.write("Nombre: " + tarea.getNombre());
                bw.newLine();
                bw.write("Descripción: " + tarea.getDescripcion());
                bw.newLine();
                bw.write("Prioridad: " + tarea.getPrioridad());
                bw.newLine();
                bw.write("-------------------------");
                bw.newLine();
            }

            System.out.println("Archivo guardado correctamente");
            bw.close();
        } catch (IOException e){
            System.out.println("Error al guardar la información");
        }
    }
}


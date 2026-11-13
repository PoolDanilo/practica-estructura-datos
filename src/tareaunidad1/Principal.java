package tareaunidad1;

import java.util.Scanner;

public class Principal {

    private static final Scanner teclado = new Scanner(System.in);
    private static final Lista lista = new Lista();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    insertarInicio();
                    break;
                case 2:
                    insertarFinal();
                    break;
                case 3:
                    insertarOrdenado();
                    break;
                case 4:
                    insertarPorReferencia();
                    break;
                case 5:
                    buscarMateria();
                    break;
                case 6:
                    lista.mostrarLista();
                    break;
                case 7:
                    actualizarMateria();
                    break;
                case 8:
                    eliminarMateria();
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n========== LISTA DE MATERIAS ==========");
        System.out.println("1. Insertar al inicio");
        System.out.println("2. Insertar al final");
        System.out.println("3. Insertar ordenado por codigo");
        System.out.println("4. Insertar por referencia");
        System.out.println("5. Buscar una materia");
        System.out.println("6. Mostrar lista");
        System.out.println("7. Actualizar una materia");
        System.out.println("8. Eliminar una materia");
        System.out.println("0. Salir");
    }

    private static void insertarInicio() {
        String[] datos = pedirDatosMateria();
        int creditos = Integer.parseInt(datos[2]);

        if (lista.insertarInicio(datos[0], datos[1], creditos)) {
            System.out.println("Materia insertada al inicio.");
        } else {
            System.out.println("Ese codigo ya esta registrado.");
        }
    }

    private static void insertarFinal() {
        String[] datos = pedirDatosMateria();
        int creditos = Integer.parseInt(datos[2]);

        if (lista.insertarFinal(datos[0], datos[1], creditos)) {
            System.out.println("Materia insertada al final.");
        } else {
            System.out.println("Ese codigo ya esta registrado.");
        }
    }

    private static void insertarOrdenado() {
        String[] datos = pedirDatosMateria();
        int creditos = Integer.parseInt(datos[2]);

        if (lista.insertarOrdenado(datos[0], datos[1], creditos)) {
            System.out.println("Materia insertada de forma ordenada.");
        } else {
            System.out.println("Ese codigo ya esta registrado.");
        }
    }

    private static void insertarPorReferencia() {
        String referencia = leerTexto("Codigo de la materia de referencia: ");
        String[] datos = pedirDatosMateria();
        int creditos = Integer.parseInt(datos[2]);

        if (lista.insertarPorReferencia(referencia, datos[0], datos[1], creditos)) {
            System.out.println("Materia insertada despues de la referencia.");
        } else if (lista.existe(datos[0])) {
            System.out.println("Ese codigo ya esta registrado.");
        } else {
            System.out.println("No se encontro la materia de referencia.");
        }
    }

    private static void buscarMateria() {
        String codigo = leerTexto("Ingrese el codigo a buscar: ");
        Nodo materia = lista.buscar(codigo);

        if (materia == null) {
            System.out.println("La materia no existe en la lista.");
        } else {
            System.out.println("Materia encontrada: " + materia);
        }
    }

    private static void actualizarMateria() {
        String codigo = leerTexto("Codigo de la materia a actualizar: ");

        if (!lista.existe(codigo)) {
            System.out.println("No se encontro esa materia.");
            return;
        }

        String nombre = leerTexto("Nuevo nombre: ");
        int creditos = leerEnteroPositivo("Nuevos creditos: ");

        lista.actualizar(codigo, nombre, creditos);
        System.out.println("Datos actualizados correctamente.");
    }

    private static void eliminarMateria() {
        String codigo = leerTexto("Codigo de la materia a eliminar: ");

        if (lista.eliminar(codigo)) {
            System.out.println("Materia eliminada.");
        } else {
            System.out.println("No se encontro esa materia.");
        }
    }

    private static String[] pedirDatosMateria() {
        String codigo = leerTexto("Codigo de la materia: ");
        String nombre = leerTexto("Nombre de la materia: ");
        int creditos = leerEnteroPositivo("Numero de creditos: ");
        return new String[]{codigo, nombre, String.valueOf(creditos)};
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return teclado.nextLine();
    }

    private static int leerEntero(String mensaje) {
        int numero;

        while (true) {
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(teclado.nextLine());
                if (numero >= 0) {
                    return numero;
                }
                System.out.println("Ingrese un numero valido.");
            } catch (NumberFormatException e) {
                System.out.println("Ingrese solo numeros enteros.");
            }
        }
    }

    private static int leerEnteroPositivo(String mensaje) {
        int numero;

        do {
            numero = leerEntero(mensaje);
            if (numero == 0) {
                System.out.println("Ingrese un numero mayor que cero.");
            }
        } while (numero == 0);

        return numero;
    }
}

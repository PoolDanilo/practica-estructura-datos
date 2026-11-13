package tareaunidad1;

public class Lista {

    private Nodo inicio;

    public Lista() {
        inicio = null;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public Nodo buscar(String codigo) {
        Nodo auxiliar = inicio;

        while (auxiliar != null) {
            if (auxiliar.getCodigo().equalsIgnoreCase(codigo)) {
                return auxiliar;
            }
            auxiliar = auxiliar.getSiguiente();
        }

        return null;
    }

    public boolean existe(String codigo) {
        return buscar(codigo) != null;
    }

    public boolean insertarInicio(String codigo, String nombre, int creditos) {
        if (existe(codigo)) {
            return false;
        }

        Nodo nuevo = new Nodo(codigo, nombre, creditos);
        nuevo.setSiguiente(inicio);
        inicio = nuevo;
        return true;
    }

    public boolean insertarFinal(String codigo, String nombre, int creditos) {
        if (existe(codigo)) {
            return false;
        }

        Nodo nuevo = new Nodo(codigo, nombre, creditos);

        if (estaVacia()) {
            inicio = nuevo;
            return true;
        }

        Nodo auxiliar = inicio;
        while (auxiliar.getSiguiente() != null) {
            auxiliar = auxiliar.getSiguiente();
        }
        auxiliar.setSiguiente(nuevo);
        return true;
    }

    public boolean insertarOrdenado(String codigo, String nombre, int creditos) {
        if (existe(codigo)) {
            return false;
        }

        Nodo nuevo = new Nodo(codigo, nombre, creditos);

        if (estaVacia() || codigo.compareToIgnoreCase(inicio.getCodigo()) < 0) {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            return true;
        }

        Nodo auxiliar = inicio;
        while (auxiliar.getSiguiente() != null
                && codigo.compareToIgnoreCase(auxiliar.getSiguiente().getCodigo()) > 0) {
            auxiliar = auxiliar.getSiguiente();
        }

        nuevo.setSiguiente(auxiliar.getSiguiente());
        auxiliar.setSiguiente(nuevo);
        return true;
    }

    // Inserta la nueva materia despues de la materia usada como referencia.
    public boolean insertarPorReferencia(String codigoReferencia, String codigo,
            String nombre, int creditos) {
        if (existe(codigo)) {
            return false;
        }

        Nodo referencia = buscar(codigoReferencia);
        if (referencia == null) {
            return false;
        }

        Nodo nuevo = new Nodo(codigo, nombre, creditos);
        nuevo.setSiguiente(referencia.getSiguiente());
        referencia.setSiguiente(nuevo);
        return true;
    }

    public boolean actualizar(String codigo, String nuevoNombre, int nuevosCreditos) {
        Nodo encontrado = buscar(codigo);
        if (encontrado == null) {
            return false;
        }

        encontrado.setNombreMateria(nuevoNombre);
        encontrado.setCreditos(nuevosCreditos);
        return true;
    }

    public boolean eliminar(String codigo) {
        if (estaVacia()) {
            return false;
        }

        if (inicio.getCodigo().equalsIgnoreCase(codigo)) {
            inicio = inicio.getSiguiente();
            return true;
        }

        Nodo auxiliar = inicio;
        while (auxiliar.getSiguiente() != null
                && !auxiliar.getSiguiente().getCodigo().equalsIgnoreCase(codigo)) {
            auxiliar = auxiliar.getSiguiente();
        }

        if (auxiliar.getSiguiente() == null) {
            return false;
        }

        auxiliar.setSiguiente(auxiliar.getSiguiente().getSiguiente());
        return true;
    }

    public void mostrarLista() {
        if (estaVacia()) {
            System.out.println("La lista no tiene materias registradas.");
            return;
        }

        Nodo auxiliar = inicio;
        int numero = 1;
        System.out.println("\n--- MATERIAS REGISTRADAS ---");
        while (auxiliar != null) {
            System.out.println(numero + ". " + auxiliar);
            auxiliar = auxiliar.getSiguiente();
            numero++;
        }
    }
}

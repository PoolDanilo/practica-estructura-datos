package tareaunidad1;

public class Nodo {

    private String codigo;
    private String nombreMateria;
    private int creditos;
    private Nodo siguiente;

    public Nodo(String codigo, String nombreMateria, int creditos) {
        this.codigo = codigo;
        this.nombreMateria = nombreMateria;
        this.creditos = creditos;
        this.siguiente = null;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo
                + " | Materia: " + nombreMateria
                + " | Creditos: " + creditos;
    }
}

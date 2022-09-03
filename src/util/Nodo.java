package util;

public class Nodo<T> {
    private T dato;
    private Nodo<T> siquiente;
    private Nodo<T> anterior;

    public Nodo() {}

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siquiente;
    }

    public void setSiguiente(Nodo<T> siquiente) {
        this.siquiente = siquiente;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }
}

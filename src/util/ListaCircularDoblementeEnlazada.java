package util;

public class ListaCircularDoblementeEnlazada<T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private Nodo<T> actual;
    private int numElementos;
    private Boolean nodoEncontrado;

    public ListaCircularDoblementeEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.actual = null;
        this.numElementos = 0;
        this.nodoEncontrado = null;
    }

    public Nodo<T> getCabeza() { return cabeza; }

    public Nodo<T> getCola() { return cola; }

    public Nodo<T> getActual() { return this.actual; }

    public void setActual(Nodo<T> nodo) { this.actual = nodo; }

    public Boolean getNodoEncontrado() { return this.nodoEncontrado; }

    public boolean isEmpty() {
        return (cabeza == null);
    }

    public int getSize() {
        return this.numElementos;
    }

    public void findElement(T objetivo) {
        this.actual = this.cabeza;
        this.nodoEncontrado = false;

        if (!this.isEmpty()) {
            do {
                if (this.actual.getDato().equals(objetivo)) {
                    this.nodoEncontrado = true;
                    return;
                } else {
                    this.actual = this.actual.getSiguiente();
                }

            }  while (this.actual != this.cola.getSiguiente());
        }
    }

    public boolean containsElement(T elemento) {
        this.findElement(elemento);
        return this.nodoEncontrado;
    }

    public void findIndex(int posicion) {
        int inicio = 0;
        this.actual = this.cabeza;
        this.nodoEncontrado = false;

        if ((!this.isEmpty()) && posicion == 0) {
            this.nodoEncontrado = true;
            return;
        }

        if ((!this.isEmpty()) && (posicion >= 0) && (posicion <= this.getSize())) {
            do {
                this.actual = this.actual.getSiguiente();
                inicio++;
            } while ((this.actual != this.cabeza) && (inicio <= posicion));
            this.nodoEncontrado = true;
        }

        return;
    }

    public Nodo<T> findNodoByIndex(int posicion) {
        findIndex(posicion);
        if (this.nodoEncontrado)
            return this.actual;
        else
            return null;
    }

    public T getNodo(T nodo) {
        this.findElement(nodo);
        if (this.nodoEncontrado)
            return this.actual.getDato();
        else
            return null;
    }

    public void reiniciarIndex() {
        this.actual = this.cabeza;
    }

    public void agregarNodo(T dato) {
        Nodo<T> nuevoNodo = new Nodo<T>();
        nuevoNodo.setDato(dato);

        if (this.isEmpty()) {
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
            this.cola.setSiguiente(this.cabeza);
            this.cabeza.setAnterior(this.cola);
        } else {
            this.cola.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(this.cola);
            this.cola = nuevoNodo;
            this.cola.setSiguiente(this.cabeza);
            this.cabeza.setAnterior(this.cola);
        }

        this.numElementos++;
    }

    public void agregarFrente(T dato) {
        Nodo<T> nuevoNodo = new Nodo<T>();
        nuevoNodo.setDato(dato);

        if (this.isEmpty()) {
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
            this.cabeza.setAnterior(this.cola);
            this.cola.setSiguiente(this.cabeza);
        } else {
            nuevoNodo.setSiguiente(this.cabeza);
            this.cabeza.setAnterior(nuevoNodo);
            this.cabeza = nuevoNodo;
            this.cabeza.setAnterior(this.cola);
            this.cola.setSiguiente(this.cabeza);
        }

        this.numElementos++;
    }

    public void agregarAtras(T dato) {
        Nodo<T> nuevoNodo = new Nodo<T>();
        nuevoNodo.setDato(dato);

        if (this.isEmpty()) {
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
            this.cabeza.setAnterior(this.cola);
            this.cola.setSiguiente(this.cabeza);
        } else {
            this.cola.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(this.cola);
            this.cola = nuevoNodo;
            this.cola.setSiguiente(this.cabeza);
        }

        this.numElementos++;
    }

    public void agregarEnPosicion(T dato, int posicion) {
        Nodo<T> nuevoNodo = new Nodo<T>();
        nuevoNodo.setDato(dato);

        if (this.isEmpty()) {
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
            this.cabeza.setAnterior(this.cola);
            this.cola.setSiguiente(this.cabeza);
        } else if (posicion <= 0) {
            nuevoNodo.setSiguiente(this.cabeza);
            this.cabeza.setAnterior(nuevoNodo);
            this.cabeza = nuevoNodo;
            this.cabeza.setAnterior(this.cola);
            this.cola.setSiguiente(this.cabeza);
        } else if (posicion >= this.getSize()) {
            this.cola.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(this.cola);
            this.cola = nuevoNodo;
            this.cola.setSiguiente(this.cabeza);
        } else {
            this.findIndex(posicion);

            nuevoNodo.setAnterior(this.actual.getAnterior());
            nuevoNodo.setSiguiente(this.actual);
            this.actual.getAnterior().setSiguiente(nuevoNodo);
            this.actual.setAnterior(nuevoNodo);
        }

        this.numElementos++;
    }

    public boolean removerElemento(T elemento) {
        this.findElement(elemento);

        if (this.nodoEncontrado) {
            if (this.actual == this.cabeza && this.getSize() == 1) {
                this.cabeza = null;
                this.cola = null;
            } else if (this.actual == this.cabeza) {
                this.cabeza = this.cabeza.getSiguiente();
                this.cabeza.setAnterior(this.cola);
                this.cola.setSiguiente(this.cabeza);
            } else if (this.actual == this.cola) {
                this.cola = this.cola.getAnterior();
                this.cola.setSiguiente(this.cabeza);
                this.cabeza.setAnterior(this.cola);
            } else {
                this.actual.getAnterior().setSiguiente(this.actual.getSiguiente());
                this.actual.getSiguiente().setAnterior(this.actual.getAnterior());
            }
            this.numElementos++;
        }
        return this.nodoEncontrado;
    }

    public void removerAlFrente() {
        if (!this.isEmpty()) {
            if (this.cabeza.getSiguiente() == this.cabeza) {
                this.cabeza = null;
                this.cola = null;
            } else {
                this.cabeza = this.cabeza.getSiguiente();
                this.cabeza.setAnterior(this.cola);
                this.cola.setSiguiente(this.cabeza);
            }
        }
        this.numElementos--;
    }

    public void removerAtras() {
        if (this.isEmpty()) {
            if (this.cabeza.getSiguiente() == this.cabeza) {
                this.cabeza = null;
                this.cola = null;
            } else {
                this.cola = this.cola.getAnterior();
                this.cola.setSiguiente(this.cabeza);
                this.cabeza.setAnterior(this.cola);
            }
        }
        this.numElementos--;
    }

    public void removerEnPosicion(int posicion) {
        if (posicion <= 0) {
            this.cabeza = this.cabeza.getSiguiente();
            this.cabeza.setAnterior(this.cola);
            this.cola.setSiguiente(this.cabeza);
        } else if (posicion >= this.getSize() - 1) {
            this.cola = this.cola.getAnterior();
            this.cola.setSiguiente(this.cabeza);
            this.cabeza.setAnterior(this.cola);
        } else {
            this.findIndex(posicion);
            this.actual.getAnterior().setSiguiente(this.actual.getSiguiente());
            this.actual.getSiguiente().setAnterior(this.actual.getAnterior());
        }
        this.numElementos--;
    }

    public String toString() {
        String cadenaDeElementos = "Lista: [ ";
        Nodo<T> posicionInicial = this.cabeza;

        if (!this.isEmpty()) {
            do {
                cadenaDeElementos += posicionInicial.getDato() + ", ";
                posicionInicial = posicionInicial.getSiguiente();
            } while (posicionInicial != this.cabeza);
        }
        cadenaDeElementos += " ]";

        return cadenaDeElementos;
    }

    public String toReverseString() {
        String cadenaInvertidaDeElementos = "Lista: [ ";
        Nodo<T> posicionInicial = this.cola;

        if (!this.isEmpty()) {
            do {
                cadenaInvertidaDeElementos += posicionInicial.getDato() + ", ";
                posicionInicial = posicionInicial.getAnterior();
            } while (posicionInicial != this.cola);
        }
        cadenaInvertidaDeElementos += " ]";

        return cadenaInvertidaDeElementos;
    }
}

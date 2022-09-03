package model.vo;

public class ProductoVo {
    private Integer codigo, cantidad;
    private String nombre;
    private Double valor;

    // setters y getters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * Retorna el objeto Producto como String
     * @return String
     */
    @Override
    public String toString() {
        return "[ codigo: "+this.getCodigo()+", "+"nombre: "+this.getNombre()+", "+"valor: "+this.getValor()+", "+"cantidad: "+this.getCantidad()+" ]";
    }
}

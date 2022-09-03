package model.dao;

import model.vo.ProductoVo;
import util.ListaCircularDoblementeEnlazada;

public class ProductoDao {
    private ListaCircularDoblementeEnlazada<ProductoVo> listaDeProductos;

    public ProductoDao() {
        listaDeProductos = new ListaCircularDoblementeEnlazada<ProductoVo>();
    }

    public void agregarProducto(ProductoVo producto) {
        listaDeProductos.agregarNodo(producto);
    }

    public void removerProducto(ProductoVo producto) {
        listaDeProductos.removerElemento(producto);
    }

    public ListaCircularDoblementeEnlazada<ProductoVo> listarProductos() {
        return listaDeProductos;
    }
}

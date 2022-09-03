package controller;

import model.vo.ProductoVo;
import view.VistaAgregarProducto;

public class ControladorAgregarProducto {
    private VistaAgregarProducto vistaAgregarProducto = new VistaAgregarProducto(this);
    
    public VistaAgregarProducto getVistaAgregarProducto() { return vistaAgregarProducto; }
    
    public void eventoBtnAgregarProd(ProductoVo producto) {
        if (ControladorMain.getCodigosProdSet().contains(producto.getCodigo())) {
            ControladorMain.crearNuevoAlert("Error", "Un producto con código "+producto.getCodigo()+" ya existe en la lista.", vistaAgregarProducto);
        } else {
            ControladorMain.getCodigosProdSet().add(producto.getCodigo());
            ControladorMain.getListaDeProductos().agregarNodo(producto);
            ControladorMain.crearNuevoAlert("Producto Agregado", "El producto: '"+producto.getNombre()+"' fue agregado exitosamente.", vistaAgregarProducto);
        }
    }
    
    public void eventoBtnLimpiar() {
        vistaAgregarProducto.getTxtCodigoProd().setText("");
        vistaAgregarProducto.getTxtNombreProd().setText("");
        vistaAgregarProducto.getTxtValorProd().setText("");
        vistaAgregarProducto.getTxtCantidadProd().setText("");
    }
    
    public void eventoBtnCancelar() {
        vistaAgregarProducto.dispose();
        vistaAgregarProducto.getLayeredPane().getParent().remove(vistaAgregarProducto);
        ControladorMain.setNumVistaAddProd(ControladorMain.getNumVistaAddProd() - 1);
    }    
}   



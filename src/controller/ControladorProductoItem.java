package controller;

import view.VistaProductoItem;

public class ControladorProductoItem {
    private static VistaProductoItem vistaProductoItem = VistaProductoItem.getInstanciaVistaProductoItem();

    public static VistaProductoItem getVistaProductoItem() { return vistaProductoItem; }

    public static void eventoBtnBuscar(int codigoProd) {
        if (!ControladorMain.getListaDeProductos().isEmpty()) {
            Boolean encontrado = false;
            try {
                
                ControladorMain.getListaDeProductos().setActual(ControladorMain.getListaDeProductos().getCabeza());
                
                do {
                    if (ControladorMain.getListaDeProductos().getActual().getDato().getCodigo() == codigoProd) {
                        encontrado = true;
                        break;
                    }
                    ControladorMain.getListaDeProductos().setActual(ControladorMain.getListaDeProductos().getActual().getSiguiente());
                } while (ControladorMain.getListaDeProductos().getActual() != ControladorMain.getListaDeProductos().getCabeza());
                
                if (encontrado)
                    vistaProductoItem.getLblItemResultado().setText(ControladorMain.getListaDeProductos().getActual().getDato().toString());
                else
                    ControladorMain.crearNuevoAlert("Error", "El producto con código "+codigoProd+" no se encuentra en la lista.", vistaProductoItem);
            } catch (Exception e) {
                ControladorMain.crearNuevoAlert("Error", e.getMessage(), vistaProductoItem);
            }
        } else {
            ControladorMain.crearNuevoAlert("Error", "La lista de productos está vacía.", vistaProductoItem);
        }
    }

    public static void eventoBtnItemAnterior() {
        ControladorMain.getListaDeProductos().setActual(ControladorMain.getListaDeProductos().getActual().getAnterior());
        vistaProductoItem.getLblItemResultado().setText(ControladorMain.getListaDeProductos().getActual().getDato().toString());
    }
    
    public static void eventoBtnItemSiguiente() {
        ControladorMain.getListaDeProductos().setActual(ControladorMain.getListaDeProductos().getActual().getSiguiente());
        vistaProductoItem.getLblItemResultado().setText(ControladorMain.getListaDeProductos().getActual().getDato().toString());
    }
}

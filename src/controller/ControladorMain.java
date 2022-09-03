package controller;

import java.util.HashSet;

import javax.swing.JInternalFrame;

import model.vo.ProductoVo;
import util.ListaCircularDoblementeEnlazada;
import view.VistaListaProductos;
import view.VistaMain;
import view.VistaProductoItem;

public class ControladorMain {
    private static ListaCircularDoblementeEnlazada<ProductoVo> listaDeProductos = new ListaCircularDoblementeEnlazada<ProductoVo>();
    
    private static VistaMain vistaMain = new VistaMain();
    
    private static int numVistaAddProd = 0;
    public static int getNumVistaAddProd() { return numVistaAddProd; }
    public static void setNumVistaAddProd(int numVistaAddProd) { ControladorMain.numVistaAddProd = numVistaAddProd; }
    
    public static ListaCircularDoblementeEnlazada<ProductoVo> getListaDeProductos() { return listaDeProductos; }

    private static HashSet<Integer> codigosProdSet = new HashSet<Integer>();

    public static HashSet<Integer> getCodigosProdSet() { return codigosProdSet; }
    
    public static void eventoItemAgregar() {
        ControladorAgregarProducto controllerAgregarProducto = new ControladorAgregarProducto();
        numVistaAddProd++;
        vistaMain.getPanelEscritorio().add(controllerAgregarProducto.getVistaAgregarProducto());
        controllerAgregarProducto.getVistaAgregarProducto().setLocation((numVistaAddProd * 50), (numVistaAddProd * 50));
        controllerAgregarProducto.getVistaAgregarProducto().moveToFront();
    }

    public static void eventoItemListar() {
        if (!ControladorListaProductos.getVistaListaProductos().isVisible()) {
            ControladorListaProductos.getVistaListaProductos().setVisible(true);
            vistaMain.getPanelEscritorio().add(ControladorListaProductos.getVistaListaProductos());
        }
        
        ControladorListaProductos.getVistaListaProductos().setLocation(
            (int)(vistaMain.getPanelEscritorio().getSize().getWidth() / 2) - 300, (int)(vistaMain.getPanelEscritorio().getSize().getHeight() / 2) - 200
            );
        ControladorListaProductos.getVistaListaProductos().moveToFront();
        
        try {
            VistaListaProductos.getInstanciaVistaListaProductos().getDefaultTableModel().setRowCount(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void eventoItemItemizar() {
        if (!ControladorProductoItem.getVistaProductoItem().isVisible()) {
            ControladorProductoItem.getVistaProductoItem().setVisible(true);
            vistaMain.getPanelEscritorio().add(ControladorProductoItem.getVistaProductoItem());
        }
        
        ControladorProductoItem.getVistaProductoItem().setLocation(
            (int)(vistaMain.getPanelEscritorio().getSize().getWidth() / 2) - 300, (int)(vistaMain.getPanelEscritorio().getSize().getHeight() / 2) - 200
        );
        ControladorProductoItem.getVistaProductoItem().moveToFront();

        try {
            VistaProductoItem.getInstanciaVistaProductoItem().getLblItemResultado().setText("");
            VistaProductoItem.getInstanciaVistaProductoItem().getTxtCodigoProd().setText("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void eventoItemSalir() { vistaMain.dispose(); }

    public static void crearNuevoAlert(String alertTitle, String alertMessage, JInternalFrame vista) {
        ControladorAlert.setAlert(alertTitle, alertMessage, vista);
        vistaMain.getPanelEscritorio().add(ControladorAlert.getVistaAlert());
        ControladorAlert.getVistaAlert().moveToFront();
    }
}

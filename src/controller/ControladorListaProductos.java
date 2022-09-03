package controller;

import javax.swing.table.DefaultTableModel;

import view.VistaListaProductos;

public class ControladorListaProductos {
    private static VistaListaProductos vistaListaProductos = VistaListaProductos.getInstanciaVistaListaProductos();

    public static VistaListaProductos getVistaListaProductos() { return vistaListaProductos; }

    public static void eventoBtnListarProductos() {
        Double total = 0d;
        vistaListaProductos.setModelo(new DefaultTableModel());
        vistaListaProductos.getModelo().addColumn("Codigo");
        vistaListaProductos.getModelo().addColumn("Nombre");
        vistaListaProductos.getModelo().addColumn("Valor");
        vistaListaProductos.getModelo().addColumn("Cantidad");
        vistaListaProductos.getModelo().addColumn("Total");
        
        if (!ControladorMain.getListaDeProductos().isEmpty()) {
            ControladorMain.getListaDeProductos().setActual(ControladorMain.getListaDeProductos().getCabeza());
            
            do {
                Object[] rowProducto = new Object[5];
                rowProducto[0] = ControladorMain.getListaDeProductos().getActual().getDato().getCodigo();
                rowProducto[1] = ControladorMain.getListaDeProductos().getActual().getDato().getNombre();
                rowProducto[2] = ControladorMain.getListaDeProductos().getActual().getDato().getValor();
                rowProducto[3] = ControladorMain.getListaDeProductos().getActual().getDato().getCantidad();
                rowProducto[4] = ControladorMain.getListaDeProductos().getActual().getDato().getValor() * ControladorMain.getListaDeProductos().getActual().getDato().getCantidad();
                vistaListaProductos.getModelo().addRow(rowProducto);
                ControladorMain.getListaDeProductos().setActual(ControladorMain.getListaDeProductos().getActual().getSiguiente());
                total += (Double)rowProducto[4];
            } while (ControladorMain.getListaDeProductos().getActual() != ControladorMain.getListaDeProductos().getCabeza());
        }

        vistaListaProductos.getLblResultado()
                .setText("El total neto de la compra es de $" + total);
        vistaListaProductos.getTabla().setModel(vistaListaProductos.getModelo());
        vistaListaProductos.getModelo().fireTableDataChanged();
    }
    
}

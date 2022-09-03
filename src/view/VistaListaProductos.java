package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.ControladorListaProductos;

public class VistaListaProductos extends JInternalFrame implements ActionListener {
    private JScrollPane panelScroll;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JLabel lblTitulo, lblConsulta, lblResultado;
    private JButton btnListarProductos;

    private static VistaListaProductos singleVistaListaProductos = null;
    
    private VistaListaProductos() {
        super("Lista de Productos", false, true, false, false);
        btnListarProd();
        etiqueta2();
        tabla();
        etiqueta3();
        setLayout(new FlowLayout());
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static VistaListaProductos getInstanciaVistaListaProductos() {
        if (singleVistaListaProductos == null)
            singleVistaListaProductos = new VistaListaProductos();
        return singleVistaListaProductos;
    }

    public DefaultTableModel getDefaultTableModel() { return modelo; }

    public void tabla() {
        tabla = new JTable(modelo);
        tabla.setPreferredScrollableViewportSize(new Dimension(500, 208));
        tabla.setFillsViewportHeight(true);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabla.setDefaultRenderer(Object.class, centerRenderer);

        add(tabla);
        panelScroll = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(panelScroll);
    }
    
    public void btnListarProd() {
        btnListarProductos = new JButton("Generar lista de Productos");
        btnListarProductos.setPreferredSize(new Dimension(500, 30));
        btnListarProductos.setFont(new Font("Arial", Font.BOLD, 20));
        btnListarProductos.addActionListener(this);
        add(btnListarProductos);
    }

    public void etiqueta1() {
        lblTitulo = new JLabel("Lista de Productos", SwingConstants.CENTER);
        lblTitulo.setPreferredSize(new Dimension(500, 30));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitulo);
    }

    public void etiqueta2() {
        lblConsulta = new JLabel("Mostrando los productos registrados hasta el momento");
        lblConsulta.setPreferredSize(new Dimension(500, 30)); 
        lblConsulta.setFont(new Font("Arial", Font.ITALIC, 12));
        add(lblConsulta);
    }

    public void etiqueta3() {
        lblResultado = new JLabel("El total neto de la compra es de $");
        lblResultado.setPreferredSize(new Dimension(500, 30)); 
        lblResultado.setFont(new Font("Arial", Font.PLAIN, 12));
        add(lblResultado);
    }

    public JTable getTabla() { return tabla; }

    public DefaultTableModel getModelo() { return modelo; }

    public void setTabla(JTable tabla) { this.tabla = tabla; }

    public void setModelo(DefaultTableModel modelo) { this.modelo = modelo; }

    public JLabel getLblResultado() { return this.lblResultado; }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnListarProductos) {
            try {
                ControladorListaProductos.eventoBtnListarProductos();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex.getLocalizedMessage());
                System.err.println(ex.getCause());
                System.err.println(ex.getStackTrace());
            }
        }
    }
}

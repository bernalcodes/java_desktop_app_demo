package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.ControladorProductoItem;

public class VistaProductoItem extends JInternalFrame implements ActionListener {
    private JLabel lblTitulo, lblSubtitulo, lblCodigoProd, lblItemResultado;
    private JTextField txtCodigoProd;
    private JButton btnBuscarItem, btnItemAnterior, btnItemSiguiente;

    private static VistaProductoItem singleVistaProductosItem = null;
    
    private VistaProductoItem() {
        super("Producto Itemizado", false, true, false, false);
        lblTitulo();
        lblSubtitulo();
        lblCodigoProd();
        txtCodigoProd();
        btnBuscarItem();
        btnItemAnterior();
        btnItemSiguiente();
        lblItemResultado();
        setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public JLabel getLblItemResultado() { return lblItemResultado; }

    public JTextField getTxtCodigoProd() { return txtCodigoProd; }
    
    public void lblTitulo() {
        lblTitulo = new JLabel("Búsqueda de Producto", SwingConstants.CENTER);
        lblTitulo.setPreferredSize(new Dimension(500, 30));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitulo);
    }

    public void lblSubtitulo() {
        lblSubtitulo = new JLabel("Ingrese el código de un producto para ubicar sus datos");
        lblSubtitulo.setPreferredSize(new Dimension(500, 30)); 
        lblSubtitulo.setFont(new Font("Arial", Font.ITALIC, 12));
        add(lblSubtitulo);
    }
    
    public static VistaProductoItem getInstanciaVistaProductoItem() {
        if (singleVistaProductosItem == null)
            singleVistaProductosItem = new VistaProductoItem();
        return singleVistaProductosItem;
    }

    public void lblCodigoProd() {
        lblCodigoProd = new JLabel("Código");
        lblCodigoProd.setPreferredSize(new Dimension(100, 30));
        add(lblCodigoProd);
    }

    public void txtCodigoProd() {
        txtCodigoProd = new JTextField();
        txtCodigoProd.setPreferredSize(new Dimension(100, 30));
        txtCodigoProd.setBorder(BorderFactory.createCompoundBorder(txtCodigoProd.getBorder(), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
        add(txtCodigoProd);
    }

    public void btnBuscarItem() {
        btnBuscarItem = new JButton("Buscar");
        btnBuscarItem.setPreferredSize(new Dimension(100, 30));
        btnBuscarItem.addActionListener(this);
        add(btnBuscarItem);
    }

    public void btnItemAnterior() {
        btnItemAnterior = new JButton("Anterior");
        btnItemAnterior.setPreferredSize(new Dimension(150, 30));
        btnItemAnterior.addActionListener(this);
        add(btnItemAnterior);
    }

    public void btnItemSiguiente() {
        btnItemSiguiente = new JButton("Siguiente");
        btnItemSiguiente.setPreferredSize(new Dimension(150, 30));
        btnItemSiguiente.addActionListener(this);
        add(btnItemSiguiente);
    }

    public void lblItemResultado() {
        lblItemResultado = new JLabel("", SwingConstants.CENTER);
        lblItemResultado.setPreferredSize(new Dimension(400, 100));
        add(lblItemResultado);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscarItem) {
            try { 
                ControladorProductoItem.eventoBtnBuscar(Integer.parseInt(txtCodigoProd.getText()));
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex.getLocalizedMessage());
                System.err.println(ex.getCause());
                System.err.println(ex.getStackTrace());
            }
        }

        if (e.getSource() == btnItemAnterior) {
            try { 
                ControladorProductoItem.eventoBtnItemAnterior();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex.getLocalizedMessage());
                System.err.println(ex.getCause());
                System.err.println(ex.getStackTrace());
            }
        }

        if (e.getSource() == btnItemSiguiente) {
            try { 
                ControladorProductoItem.eventoBtnItemSiguiente();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex.getLocalizedMessage());
                System.err.println(ex.getCause());
                System.err.println(ex.getStackTrace());
            }
        }
    }
}

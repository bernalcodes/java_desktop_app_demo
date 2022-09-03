package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControladorAgregarProducto;
import controller.ControladorMain;
import model.vo.ProductoVo;

public class VistaAgregarProducto extends JInternalFrame implements ActionListener {
    private ControladorAgregarProducto controllerAgregarProducto;
    private JLabel lblCodigoProd, lblNombreProd, lblValorProd, lblCantidadProd;
    private JTextField txtCodigoProd, txtNombreProd, txtValorProd, txtCantidadProd;
    private JButton btnLimpiar, btnAgregarProd, btnCancelar;
    
    public VistaAgregarProducto(ControladorAgregarProducto controllerAgregarProducto){
        super("Agregando un nuevo producto", false, true, false, false);
        this.controllerAgregarProducto = controllerAgregarProducto;
        setLayout(null);
        initComponents();
        setSize(new Dimension(550, 300));
        setVisible(true);
        setLocation(50, 50);
    }
    
    public JTextField getTxtCodigoProd() {
        return txtCodigoProd;
    }

    public JTextField getTxtNombreProd() {
        return txtNombreProd;
    }

    public JTextField getTxtValorProd() {
        return txtValorProd;
    }

    public JTextField getTxtCantidadProd() {
        return txtCantidadProd;
    }

    public void initComponents() {
        lblCodigoProd = new JLabel("Codigo del Producto");
        lblCodigoProd.setBounds(20, 20, 180, 30);

        txtCodigoProd = new JTextField();
        txtCodigoProd.setBounds(220, 20, 150, 30);
        txtCodigoProd.setBorder(BorderFactory.createCompoundBorder(txtCodigoProd.getBorder(), BorderFactory.createEmptyBorder(0, 5, 0, 0)));        
        
        lblNombreProd = new JLabel("Nombre del Producto");
        lblNombreProd.setBounds(20, 60, 180, 30);
        
        txtNombreProd = new JTextField();
        txtNombreProd.setBounds(220, 60, 150, 30);
        txtNombreProd.setBorder(BorderFactory.createCompoundBorder(txtNombreProd.getBorder(), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
        
        lblValorProd = new JLabel("Valor del Producto");
        lblValorProd.setBounds(20, 100, 180, 30);

        txtValorProd = new JTextField();
        txtValorProd.setBounds(220, 100, 150, 30);
        txtValorProd.setBorder(BorderFactory.createCompoundBorder(txtValorProd.getBorder(), BorderFactory.createEmptyBorder(0, 5, 0, 0)));

        lblCantidadProd = new JLabel("Cantidad de Producto");
        lblCantidadProd.setBounds(20, 140, 180, 30);
        
        txtCantidadProd = new JTextField();
        txtCantidadProd.setBounds(220, 140, 150, 30);
        txtCantidadProd.setBorder(BorderFactory.createCompoundBorder(txtCantidadProd.getBorder(), BorderFactory.createEmptyBorder(0, 5, 0, 0)));

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(410, 20, 100, 30);
        btnLimpiar.addActionListener(this);

        btnAgregarProd = new JButton("Agregar");
        btnAgregarProd.setBounds(75, 200, 150, 30);
        btnAgregarProd.addActionListener(this);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(325, 200, 150, 30);
        btnCancelar.addActionListener(this);
        
        add(lblCodigoProd);
        add(txtCodigoProd);
        add(lblNombreProd);
        add(txtNombreProd);
        add(lblValorProd);
        add(txtValorProd);
        add(lblCantidadProd);
        add(txtCantidadProd);
        add(btnLimpiar);
        add(btnAgregarProd);
        add(btnCancelar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLimpiar) {
            this.controllerAgregarProducto.eventoBtnLimpiar();
        }

        if (e.getSource() == btnAgregarProd) {
            if (txtCodigoProd.getText().equals("") || txtNombreProd.getText().equals("")
                || txtValorProd.getText().equals("") || txtCantidadProd.getText().equals("")) {
                    ControladorMain.crearNuevoAlert("Error al agregar producto", "No ha llenado los datos correctamente.", this);
            } else {
                ProductoVo producto = new ProductoVo();
                
                try {
                    producto.setCodigo(Integer.parseInt(txtCodigoProd.getText()));
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
    
                producto.setNombre(txtNombreProd.getText());
    
                try {
                    producto.setValor(Double.parseDouble(txtValorProd.getText()));
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
    
                try {
                    producto.setCantidad(Integer.parseInt(txtCantidadProd.getText()));
                } catch (Exception ex) {
                    System.err.println(ex.getMessage());
                }
    
                this.controllerAgregarProducto.eventoBtnAgregarProd(producto);

                controllerAgregarProducto.eventoBtnLimpiar();
            }
        }

        if (e.getSource() == btnCancelar) {
            this.controllerAgregarProducto.eventoBtnCancelar();
        }
    }
}

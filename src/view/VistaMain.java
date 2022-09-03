package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

public class VistaMain extends JFrame implements ActionListener {
    private JDesktopPane panelEscritorio;
    private JMenuBar barraMenu;
    private JMenu menuOpc1, menuOpc2;
    private JMenuItem itmAgregar, itmListar, itmItemizar, itmSalir;

    public VistaMain() {
        setLayout(new BorderLayout());
        crearBarraMenu();
        crearPanelEscritorio();
        setVisible(true);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setTitle("Gestión de Productos - Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void crearPanelEscritorio() {
        panelEscritorio = new JDesktopPane();
        panelEscritorio.setBackground(Color.darkGray);
        add(panelEscritorio);
    }

    public void crearBarraMenu() {
        barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);
        menuOpc1 = new JMenu("Operaciones");
        menuOpc2 = new JMenu("Ayuda");
        barraMenu.add(menuOpc1);
        barraMenu.add(menuOpc2);
        
        itmAgregar = new JMenuItem("Añadir");
        itmAgregar.setIcon(new ImageIcon(getClass().getResource("../resources/icons8-add-20.png")));
        itmAgregar.setAccelerator(KeyStroke.getKeyStroke('A', KeyEvent.ALT_DOWN_MASK));
        
        itmListar = new JMenuItem("Listar");
        itmListar.setIcon(new ImageIcon(getClass().getResource("../resources/icons8-list-view-20.png")));
        itmListar.setAccelerator(KeyStroke.getKeyStroke('L', KeyEvent.ALT_DOWN_MASK));
        
        itmItemizar = new JMenuItem("Item");
        itmItemizar.setIcon(new ImageIcon(getClass().getResource("../resources/icons8-product-20.png")));
        itmItemizar.setAccelerator(KeyStroke.getKeyStroke('W', KeyEvent.ALT_DOWN_MASK));
        
        itmSalir = new JMenuItem("Salir");
        itmSalir.setIcon(new ImageIcon(getClass().getResource("../resources/icons8-emergency-exit-20.png")));
        itmSalir.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.ALT_DOWN_MASK));
        
        menuOpc1.add(itmAgregar);
        menuOpc1.add(itmListar);
        menuOpc1.add(itmItemizar);
        menuOpc1.add(new JSeparator());
        menuOpc1.add(itmSalir);
        itmAgregar.addActionListener(this);
        itmListar.addActionListener(this);
        itmItemizar.addActionListener(this);
        itmSalir.addActionListener(this);
    }

    public JDesktopPane getPanelEscritorio() {
        return this.panelEscritorio;
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == itmAgregar) {
            controller.ControladorMain.eventoItemAgregar();
        }

        if (e.getSource() == itmListar) {
            controller.ControladorMain.eventoItemListar();
        }

        if (e.getSource() == itmItemizar) {
            controller.ControladorMain.eventoItemItemizar();
        }

        if (e.getSource() == itmSalir) {
            controller.ControladorMain.eventoItemSalir();
        }
    }
}

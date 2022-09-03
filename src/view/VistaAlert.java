package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.ControladorAlert;

public class VistaAlert extends JInternalFrame implements ActionListener {
    private JLabel lblAlert;
    private JButton btnAlert;
    
    public VistaAlert(String titleAlert, String mensajeAlert, JInternalFrame vista) {
        super(titleAlert, false, true, false, false);
        setLayout(null);
        initComponents(mensajeAlert);
        setSize(new Dimension(500, 150));
        setVisible(true);
        setLocation(vista.getLocation().x + 25, vista.getLocation().y + 25);
    }

    public void initComponents(String alertMessage) {
        lblAlert = new JLabel("<html><p>"+alertMessage+"</p><html>", SwingConstants.CENTER);
        lblAlert.setBounds(25, 20, 450, 40);
        
        btnAlert = new JButton("Ok");
        btnAlert.setBounds(200, 80, 100, 30);
        btnAlert.addActionListener(this);

        add(lblAlert);
        add(btnAlert);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAlert) {
            ControladorAlert.eventoBtnAlert();
        }
    }
}

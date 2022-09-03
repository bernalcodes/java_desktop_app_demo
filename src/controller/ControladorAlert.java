package controller;

import javax.swing.JInternalFrame;

import view.VistaAlert;

public class ControladorAlert {
    private static VistaAlert vistaAlert;
    
    public static void setAlert(String alertTitle, String alertMessage, JInternalFrame vista) {
        vistaAlert = new VistaAlert(alertTitle, alertMessage, vista);
    }

    public static VistaAlert getVistaAlert() {
        return vistaAlert;
    }

    public static void eventoBtnAlert() {
        vistaAlert.dispose();
        vistaAlert.getLayeredPane().getParent().remove(vistaAlert);
    }
}

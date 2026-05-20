package com.mycompany.saiusf;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.mycompany.saiusf.views.Login;
import javax.swing.UIManager;

/**
 *
 * @author Personsl
 */
public class SAIUSF {

    public static void main(String[] args) {
        
        com.formdev.flatlaf.FlatIntelliJLaf.setup();
    java.awt.EventQueue.invokeLater(() -> {
    });
        try {
            // Configuramos el estilo visual antes de crear las interfaces
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            
            // Personalización para que el Login se vea más limpio
            UIManager.put("Button.arc", 20); // Botones más redondeados
            UIManager.put("TextComponent.arc", 15); // Campos de texto redondeados
            
        } catch (Exception ex) {
            System.err.println("Fallo al inicializar FlatLaf");
        }

        // Ejecutamos el hilo de la interfaz
        java.awt.EventQueue.invokeLater(() -> {
            Login log = new Login();
            log.setLocationRelativeTo(null); // Centra el login en la pantalla
            log.setVisible(true);
        });
    }
}
package com.mycompany.saiusf.util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class PanelRedondeado extends JPanel {

    // Puedes cambiar este valor para que sea más o menos redondo por defecto
    private int arco = 30; 

    // Constructor vacío: VITAL para que aparezca en la paleta de NetBeans
    public PanelRedondeado() {
        super();
        setOpaque(false); // Hace que las esquinas sobrantes sean transparentes
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        // Activamos el suavizado (Anti-aliasing) para que el borde no se vea pixelado
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Pintamos el fondo del panel con el color que elegiste en NetBeans
        g2.setColor(getBackground());
        
        // Dibujamos el rectángulo redondeado: x, y, ancho, alto, arcoAncho, arcoAlto
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arco, arco);
        
        super.paintComponent(g);
    }

    // Opcional: Para poder cambiar el redondeo desde el código si lo necesitas
    public void setArco(int arco) {
        this.arco = arco;
        repaint(); // Vuelve a dibujar el panel con el nuevo radio
    }
}
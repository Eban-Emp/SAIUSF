
package com.mycompany.saiusf.views;

import Controllers.Logcontroller;
import Models.User;
import Models.UserDao;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.UIManager;



public class Login extends javax.swing.JFrame {
    private Image background_imagen; 
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Login.class.getName());
    User us = new User();
    UserDao usDao = new UserDao();
    
    

    
    public Login() {
    initComponents();
    try {
        java.net.URL urlLogo = getClass().getResource("/Logo.jpg");
        if (urlLogo != null) {
            javax.swing.ImageIcon miIcono = new javax.swing.ImageIcon(urlLogo);
            this.setIconImage(miIcono.getImage());
            System.out.println("¡Icono cargado exitosamente!");
        } else {
            System.err.println("¡ALERTA! Java no encuentra el archivo /Logo.jpg. Revisa la carpeta resources.");
        }
    } catch (Exception e) {
        System.err.println("Excepción al intentar cargar el icono: " + e.getMessage());
    }
    new Logcontroller(us, usDao, this);
    btncancelar.setOpaque(false);
    btnlog.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("Button.border"));
    
    btnlog.setContentAreaFilled(true);
    btnlog.setBorderPainted(true);
    
    btnlog.putClientProperty("JButton.buttonType", "roundRect");
    btnlog.putClientProperty("JButton.arc", 20); 
    
    btnlog.setForeground(java.awt.Color.WHITE);
}
    

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelcuerpo = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        btnlog = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        panellogo = new javax.swing.JPanel(){

            @Override
            public void paintComponent (Graphics g){

                int width = this.getSize().width;
                int height = this.getSize().height;

                if (background_imagen != null){
                    g.drawImage (background_imagen, 0, 0, width, height, null);
                }
                super.paintComponent(g);
            }

        };
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelcuerpo.setBackground(new java.awt.Color(204, 204, 204));
        panelcuerpo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(93, 93, 93));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Iniciar Sesión");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 210, -1));

        jLabel2.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Usuario");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 390, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(65, 65, 65));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("__________________");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, -1, 20));

        jLabel3.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Contraseña");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 390, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic Medium", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(65, 65, 65));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("__________________");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, 20));

        txtuser.setOpaque(false);
        txtuser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtuser.setForeground(new java.awt.Color(255, 255, 255));
        txtuser.setBorder(null);
        txtuser.addActionListener(this::txtuserActionPerformed);
        jPanel3.add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 340, 40));

        txtpass.setOpaque(false);
        txtpass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtpass.setForeground(new java.awt.Color(255, 255, 255));
        txtpass.setBorder(null);
        jPanel3.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 340, 40));

        btnlog.setBackground(new java.awt.Color(130, 130, 130));
        btnlog.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btnlog.setForeground(new java.awt.Color(255, 255, 255));
        btnlog.setText("Iniciar Sesión");
        btnlog.setBorder(null);
        btnlog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlog.addActionListener(this::btnlogActionPerformed);
        jPanel3.add(btnlog, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, 280, -1));

        jLabel8.setBackground(new java.awt.Color(93, 93, 93));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("X");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 60, 30));

        btncancelar.setBackground(new java.awt.Color(93, 93, 93));
        btncancelar.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setBorder(null);
        btncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancelar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btncancelar.addActionListener(this::btncancelarActionPerformed);
        jPanel3.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 60, 30));

        panelcuerpo.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 500, 650));

        panellogo.setBackground(new java.awt.Color(102, 102, 102));
        panellogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo-blanco.png"))); // NOI18N
        panellogo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 360, 220));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/entrada.jpg"))); // NOI18N
        panellogo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 650));

        panelcuerpo.add(panellogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 650));

        getContentPane().add(panelcuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed
        txtuser.transferFocus();
    }//GEN-LAST:event_txtuserActionPerformed

    private void btnlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogActionPerformed
        // El evento de login se maneja desde Logcontroller.
    }//GEN-LAST:event_btnlogActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // El evento de cancelar se maneja desde Logcontroller.
    }//GEN-LAST:event_btncancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btncancelar;
    public javax.swing.JButton btnlog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panelcuerpo;
    private javax.swing.JPanel panellogo;
    public javax.swing.JPasswordField txtpass;
    public javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables


}

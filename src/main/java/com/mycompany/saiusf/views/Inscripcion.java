
package com.mycompany.saiusf.views;

import Controllers.InscripcionmasivaController;
import Models.carreraDao;
import Models.cursosDao;
import Models.estudiante;
import Models.estudianteDao;
import Models.inscripcion;
import Models.inscripcionDao;




public class Inscripcion extends javax.swing.JFrame {
    
    estudiante est = new estudiante();
    estudianteDao estDao = new estudianteDao();
    cursosDao curDao = new cursosDao();
    carreraDao carDao = new carreraDao();
    inscripcion ins = new inscripcion();
    inscripcionDao insDao = new inscripcionDao();
    private InscripcionmasivaController inscon;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Inscripcion.class.getName());

    
    public Inscripcion() {
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
    this.setLocationRelativeTo(null);
    inscon = new InscripcionmasivaController(est, estDao, ins, insDao, curDao, carDao, this);
    // Aquí llamarás a tus métodos de llenar tabla
}

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRedondeado12 = new com.mycompany.saiusf.util.PanelRedondeado();
        cbxcursoins = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxcarrerains = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxsemestreins = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btninsmas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tableinsmas = new javax.swing.JTable();
        btnseleccionartodo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(228, 228, 228));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRedondeado12.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondeado12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxcursoins.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        panelRedondeado12.add(cbxcursoins, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 320, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Curso");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        panelRedondeado12.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 320, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Carrera");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        panelRedondeado12.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 320, 40));

        cbxcarrerains.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        panelRedondeado12.add(cbxcarrerains, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 320, 50));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Semestre");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        panelRedondeado12.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 320, 40));

        cbxsemestreins.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbxsemestreins.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "n/a", "Primer semestre", "Segundo semestre", "Tercer semestre", "Cuarto semestre", "Quinto semestre", "Sexto semestre" }));
        panelRedondeado12.add(cbxsemestreins, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 320, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Inscripción Múltiple");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRedondeado12.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 230, -1));

        btninsmas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btninsmas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADD.png"))); // NOI18N
        btninsmas.setText("Inscribir Estudiantes");
        panelRedondeado12.add(btninsmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 300, 40));

        jPanel1.add(panelRedondeado12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 360, 500));

        Tableinsmas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "nombres", "Apellidos", "Cédula", "Télefono", "Correo", "Sexo", "Procedencia", "Carrera", "Semestre", "Seleccionar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tableinsmas);
        if (Tableinsmas.getColumnModel().getColumnCount() > 0) {
            Tableinsmas.getColumnModel().getColumn(0).setResizable(false);
            Tableinsmas.getColumnModel().getColumn(0).setPreferredWidth(50);
            Tableinsmas.getColumnModel().getColumn(1).setResizable(false);
            Tableinsmas.getColumnModel().getColumn(2).setResizable(false);
            Tableinsmas.getColumnModel().getColumn(3).setResizable(false);
            Tableinsmas.getColumnModel().getColumn(4).setResizable(false);
            Tableinsmas.getColumnModel().getColumn(5).setResizable(false);
            Tableinsmas.getColumnModel().getColumn(6).setResizable(false);
            Tableinsmas.getColumnModel().getColumn(7).setResizable(false);
            Tableinsmas.getColumnModel().getColumn(8).setResizable(false);
            Tableinsmas.getColumnModel().getColumn(9).setResizable(false);
            Tableinsmas.getColumnModel().getColumn(10).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 840, 470));

        btnseleccionartodo.setText("Seleccionar Todo");
        jPanel1.add(btnseleccionartodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 23, 840, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable Tableinsmas;
    public javax.swing.JButton btninsmas;
    public javax.swing.JButton btnseleccionartodo;
    public javax.swing.JComboBox<Object> cbxcarrerains;
    public javax.swing.JComboBox<Object> cbxcursoins;
    public javax.swing.JComboBox<Object> cbxsemestreins;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.mycompany.saiusf.util.PanelRedondeado panelRedondeado12;
    // End of variables declaration//GEN-END:variables
}

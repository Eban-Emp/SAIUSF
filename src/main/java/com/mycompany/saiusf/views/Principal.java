
package com.mycompany.saiusf.views;

import Controllers.CarreraController;
import Controllers.CursosController;
import Controllers.EstudianteController;
import Controllers.PrincipalController;
import Controllers.ProfesorController;
import Controllers.ReporteController;
import Controllers.Usercontroller;
import Controllers.certificadoController;
import Models.certificados;
import Models.certificadosDao;
import Models.carrera;
import Models.carreraDao;
import Models.cursos;
import Models.cursosDao;
import Models.estudiante;
import Models.estudianteDao;
import Models.inscripcion;
import Models.inscripcionDao;
import Models.periodo;
import Models.periodoDao;
import Models.profesor;
import Models.profesorDao;


import Controllers.estadoController;
import Controllers.inscripcionController;
import Models.ReporteDao;
import Models.User;
import Models.UserDao;


public class Principal extends javax.swing.JFrame {
    
    carrera car = new carrera();
    carreraDao carDao = new carreraDao();
    profesor prof = new profesor();
    profesorDao profDao = new profesorDao();
    cursos cur = new cursos();
    cursosDao curDao = new cursosDao();
    estudiante est = new estudiante();
    estudianteDao estDao = new estudianteDao();
    inscripcion ins = new inscripcion();
    inscripcionDao insDao = new inscripcionDao();
    certificados cert = new certificados();
    certificadosDao certDao = new certificadosDao();
    User us = new User();
    UserDao usDao = new UserDao();
    ReporteDao repDao = new ReporteDao();
    private inscripcionController inscon;
    private EstudianteController estcon;
    private CursosController curcon;
    private CarreraController carcon;
    private ProfesorController profcon;
    private Usercontroller uscon;
    periodo per = new periodo();
    periodoDao perDao = new periodoDao();
    
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Principal.class.getName());

    
    public Principal() {
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
        btncerrars.addActionListener(e -> {
        jPopupMenu1.show(btncerrars, 0, btncerrars.getHeight());
    });
    Cerrar.addActionListener(e -> {
    });

        setLocationRelativeTo(null);
        new PrincipalController(this);
        carcon = new CarreraController(car, carDao, estDao, insDao, this);
        profcon = new ProfesorController(prof, profDao, curDao, insDao, this);
        curcon = new CursosController(cur, curDao, insDao, this);
        estcon = new EstudianteController(est, estDao, insDao, this);
        inscon = new inscripcionController(ins, insDao, this);
        uscon = new Usercontroller(us, usDao, this);
        new estadoController(per, perDao, ins, insDao, this);
        new certificadoController(cert, certDao, this);
        new ReporteController(ins, insDao, repDao, perDao, this);
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Sesión = new javax.swing.JMenuItem();
        Cerrar = new javax.swing.JMenuItem();
        Cambiarcontraseña = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        Aprobar = new javax.swing.JMenuItem();
        Reprobar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtbienvenido = new javax.swing.JLabel();
        btncerrars = new javax.swing.JButton();
        idUsuario = new javax.swing.JLabel();
        rolUsuario = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Panest = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TableEst = new javax.swing.JTable();
        aggest = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        panelRedondeado3 = new com.mycompany.saiusf.util.PanelRedondeado();
        txtIdest = new javax.swing.JLabel();
        nombreest = new javax.swing.JLabel();
        cedulaest = new javax.swing.JLabel();
        Apellidoest = new javax.swing.JLabel();
        panelRedondeado4 = new com.mycompany.saiusf.util.PanelRedondeado();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        newest = new javax.swing.JButton();
        editest = new javax.swing.JButton();
        txtnomest = new javax.swing.JTextField();
        txtapeest = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        txtcedest = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txttlfest = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        txtcorest = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        cbxSexEst = new javax.swing.JComboBox<>();
        cbxProEst = new javax.swing.JComboBox<>();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        cbxCarEst = new javax.swing.JComboBox<>();
        cbxSemEst = new javax.swing.JComboBox<>();
        elimest = new javax.swing.JButton();
        txtBuscarEst = new javax.swing.JTextField();
        btnaggmas = new javax.swing.JButton();
        Pancur = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableCur = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        aggcur = new javax.swing.JButton();
        panelRedondeado5 = new com.mycompany.saiusf.util.PanelRedondeado();
        txtIdcur = new javax.swing.JLabel();
        nombrecur = new javax.swing.JLabel();
        Preciocur = new javax.swing.JLabel();
        panelRedondeado6 = new com.mycompany.saiusf.util.PanelRedondeado();
        jLabel72 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        newcur = new javax.swing.JButton();
        editcur = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        txtnomcur = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtdetallescur = new javax.swing.JTextArea();
        txtduracioncur = new javax.swing.JTextField();
        txtpreciocur = new javax.swing.JTextField();
        cbxCurperiodo = new javax.swing.JComboBox<>();
        cbxCurprofesor = new javax.swing.JComboBox<>();
        elimcur = new javax.swing.JButton();
        cbxModalidad = new javax.swing.JComboBox<>();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtBuscarCur = new javax.swing.JTextField();
        Panprof = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableProf = new javax.swing.JTable();
        panelRedondeado9 = new com.mycompany.saiusf.util.PanelRedondeado();
        txtIdprof = new javax.swing.JLabel();
        nombreprof = new javax.swing.JLabel();
        cedulaprof = new javax.swing.JLabel();
        apellidoprof = new javax.swing.JLabel();
        panelRedondeado10 = new com.mycompany.saiusf.util.PanelRedondeado();
        jLabel82 = new javax.swing.JLabel();
        newprof = new javax.swing.JButton();
        editprof = new javax.swing.JButton();
        jLabel94 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        txtnomprof = new javax.swing.JTextField();
        txtapeprof = new javax.swing.JTextField();
        txtcedprof = new javax.swing.JTextField();
        txttlfprof = new javax.swing.JTextField();
        txtcorprof = new javax.swing.JTextField();
        elimprof = new javax.swing.JButton();
        jLabel106 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        cbxgradoac = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        aggprof = new javax.swing.JButton();
        txtBuscarProf = new javax.swing.JTextField();
        PanCar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCar = new javax.swing.JTable();
        panelRedondeado7 = new com.mycompany.saiusf.util.PanelRedondeado();
        txtIdcar = new javax.swing.JLabel();
        nomcar = new javax.swing.JLabel();
        panelRedondeado8 = new com.mycompany.saiusf.util.PanelRedondeado();
        jLabel79 = new javax.swing.JLabel();
        newcar = new javax.swing.JButton();
        editcar = new javax.swing.JButton();
        jLabel92 = new javax.swing.JLabel();
        txtnewcar = new javax.swing.JTextField();
        elimcar = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        aggcar = new javax.swing.JButton();
        txtBuscarCar = new javax.swing.JTextField();
        Panins = new javax.swing.JPanel();
        panelRedondeado1 = new com.mycompany.saiusf.util.PanelRedondeado();
        txtIdins = new javax.swing.JLabel();
        nombreins = new javax.swing.JLabel();
        cursoins = new javax.swing.JLabel();
        panelRedondeado2 = new com.mycompany.saiusf.util.PanelRedondeado();
        cbxcurest = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        cbxnomest = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        newins = new javax.swing.JButton();
        editins = new javax.swing.JButton();
        elimins = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableIns = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        aggins = new javax.swing.JButton();
        txtBuscarIns = new javax.swing.JTextField();
        btninsmas = new javax.swing.JButton();
        Pangestus = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        panelbordearribaredondeado6 = new com.mycompany.saiusf.util.Panelbordearribaredondeado();
        jLabel104 = new javax.swing.JLabel();
        panelRedondeado15 = new com.mycompany.saiusf.util.PanelRedondeado();
        txtperiodo = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        TablePer = new javax.swing.JTable();
        aggper = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        cbxPeriodoestado = new javax.swing.JComboBox<>();
        cbxCursoestado = new javax.swing.JComboBox<>();
        Filtrarestado = new javax.swing.JButton();
        idestado = new javax.swing.JLabel();
        panelbordearribaredondeado7 = new com.mycompany.saiusf.util.Panelbordearribaredondeado();
        jLabel107 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        TableEstado = new javax.swing.JTable();
        jLabel105 = new javax.swing.JLabel();
        Pancert = new javax.swing.JPanel();
        panelbordearribaredondeado2 = new com.mycompany.saiusf.util.Panelbordearribaredondeado();
        jLabel49 = new javax.swing.JLabel();
        panelRedondeado13 = new com.mycompany.saiusf.util.PanelRedondeado();
        FiltrarCert = new javax.swing.JButton();
        cbxCursocert = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        cbxPeriodocert = new javax.swing.JComboBox<>();
        jLabel73 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        panelbordearribaredondeado3 = new com.mycompany.saiusf.util.Panelbordearribaredondeado();
        jLabel74 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TableCert = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        exportarcert = new javax.swing.JButton();
        Panrep = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        TableReporte = new javax.swing.JTable();
        panelbordearribaredondeado4 = new com.mycompany.saiusf.util.Panelbordearribaredondeado();
        jLabel75 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        exportarreport = new javax.swing.JButton();
        panelbordearribaredondeado5 = new com.mycompany.saiusf.util.Panelbordearribaredondeado();
        jLabel78 = new javax.swing.JLabel();
        panelRedondeado14 = new com.mycompany.saiusf.util.PanelRedondeado();
        jLabel77 = new javax.swing.JLabel();
        cbxPeriodorep = new javax.swing.JComboBox<>();
        cbxCursorep = new javax.swing.JComboBox<>();
        Filtrarrep = new javax.swing.JButton();
        jLabel76 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        Panus = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tableus = new javax.swing.JTable();
        jLabel37 = new javax.swing.JLabel();
        panelRedondeado11 = new com.mycompany.saiusf.util.PanelRedondeado();
        txtIdus = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JLabel();
        Usuario = new javax.swing.JLabel();
        panelRedondeado12 = new com.mycompany.saiusf.util.PanelRedondeado();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        elimus = new javax.swing.JButton();
        editus = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtnomus = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        txtcontus = new javax.swing.JTextField();
        newus = new javax.swing.JButton();
        aggus = new javax.swing.JButton();
        txtBuscarUs = new javax.swing.JTextField();
        Panmenu = new javax.swing.JPanel();
        txtconfiguracion = new javax.swing.JLabel();
        txtdatos = new javax.swing.JLabel();
        panest = new com.mycompany.saiusf.util.PanelRedondeado();
        txtest = new javax.swing.JLabel();
        pancur = new com.mycompany.saiusf.util.PanelRedondeado();
        txtcur = new javax.swing.JLabel();
        panprof = new com.mycompany.saiusf.util.PanelRedondeado();
        txtprof = new javax.swing.JLabel();
        pancar = new com.mycompany.saiusf.util.PanelRedondeado();
        txtcar = new javax.swing.JLabel();
        panin = new com.mycompany.saiusf.util.PanelRedondeado();
        txtnins = new javax.swing.JLabel();
        panestins = new com.mycompany.saiusf.util.PanelRedondeado();
        txtestins = new javax.swing.JLabel();
        txtoperaciones = new javax.swing.JLabel();
        txtdocumentacion = new javax.swing.JLabel();
        pancert = new com.mycompany.saiusf.util.PanelRedondeado();
        txtcert = new javax.swing.JLabel();
        panrep = new com.mycompany.saiusf.util.PanelRedondeado();
        txtrep = new javax.swing.JLabel();
        panus = new com.mycompany.saiusf.util.PanelRedondeado();
        txtus = new javax.swing.JLabel();
        txtIdcron = new javax.swing.JLabel();

        Sesión.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png"))); // NOI18N
        Sesión.setText("Cerrar Sesión");
        jPopupMenu1.add(Sesión);

        Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Black-X-PNG-Pic.png"))); // NOI18N
        Cerrar.setText("Cerrar programa");
        jPopupMenu1.add(Cerrar);

        Cambiarcontraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Nuevo.png"))); // NOI18N
        Cambiarcontraseña.setText("Cambiar Contraseña");
        jPopupMenu1.add(Cambiarcontraseña);

        Aprobar.setText("Aprobar Estudiante");
        jPopupMenu2.add(Aprobar);

        Reprobar.setText("Reprobar Estudiante");
        jPopupMenu2.add(Reprobar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(17, 46, 66));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setMinimumSize(new java.awt.Dimension(1285, 870));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo Rojo.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 200, 80));

        txtbienvenido.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtbienvenido.setText("SISTEMA DE FORMACIÓN COMPLEMENTARIA");
        jPanel3.add(txtbienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, 60));

        // 1. Quita el fondo y el área de contenido
        btncerrars.setContentAreaFilled(false);

        // 2. Quita el borde
        btncerrars.setBorderPainted(false);

        // 3. Quita el recuadro que sale al hacer clic (opcional pero recomendado)
        btncerrars.setFocusable(false);
        btncerrars.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btncerrars.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/flechacerrar.png"))); // NOI18N
        btncerrars.setText("ADMINISTRADOR");
        btncerrars.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncerrars.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btncerrars.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btncerrars.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btncerrars.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btncerrars.addActionListener(this::btncerrarsActionPerformed);
        jPanel3.add(btncerrars, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, 450, 60));

        idUsuario.setForeground(new java.awt.Color(255, 255, 255));
        idUsuario.setText("id");
        jPanel3.add(idUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 30, -1));

        rolUsuario.setForeground(new java.awt.Color(255, 255, 255));
        rolUsuario.setText("rol");
        jPanel3.add(rolUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 20, 70, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 100));

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Panest.setBackground(new java.awt.Color(228, 228, 228));
        Panest.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Panest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableEst.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombres", "Apellidos", "Cedula", "Teléfono", "Correo", "Sexo", "Procedencia", "Carrera", "Semestre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(TableEst);
        if (TableEst.getColumnModel().getColumnCount() > 0) {
            TableEst.getColumnModel().getColumn(0).setResizable(false);
            TableEst.getColumnModel().getColumn(0).setPreferredWidth(50);
            TableEst.getColumnModel().getColumn(1).setResizable(false);
            TableEst.getColumnModel().getColumn(2).setResizable(false);
            TableEst.getColumnModel().getColumn(3).setResizable(false);
            TableEst.getColumnModel().getColumn(4).setResizable(false);
            TableEst.getColumnModel().getColumn(5).setResizable(false);
            TableEst.getColumnModel().getColumn(6).setResizable(false);
            TableEst.getColumnModel().getColumn(6).setPreferredWidth(45);
            TableEst.getColumnModel().getColumn(7).setResizable(false);
            TableEst.getColumnModel().getColumn(8).setResizable(false);
            TableEst.getColumnModel().getColumn(9).setResizable(false);
        }

        Panest.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 620, 610));

        aggest.setBackground(new java.awt.Color(190, 55, 55));
        aggest.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        aggest.setForeground(new java.awt.Color(255, 255, 255));
        aggest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        aggest.setText("Agregar Estudiante");
        aggest.addActionListener(this::aggestActionPerformed);
        Panest.add(aggest, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 290, 50));

        jLabel39.setBackground(new java.awt.Color(0, 102, 153));
        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Estudiantes");
        Panest.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 280, -1));

        panelRedondeado3.setBackground(new java.awt.Color(190, 55, 55));
        panelRedondeado3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIdest.setForeground(new java.awt.Color(190, 55, 55));
        panelRedondeado3.add(txtIdest, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 30, 20));

        nombreest.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        nombreest.setForeground(new java.awt.Color(190, 55, 55));
        nombreest.setText("N");
        panelRedondeado3.add(nombreest, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        cedulaest.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        cedulaest.setForeground(new java.awt.Color(190, 55, 55));
        cedulaest.setText("C");
        panelRedondeado3.add(cedulaest, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        Apellidoest.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        Apellidoest.setForeground(new java.awt.Color(190, 55, 55));
        Apellidoest.setText("C");
        panelRedondeado3.add(Apellidoest, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        Panest.add(panelRedondeado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 420, 220));

        panelRedondeado4.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondeado4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setBackground(new java.awt.Color(0, 102, 153));
        jLabel51.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(102, 0, 0));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel51.setText("Nombres:");
        panelRedondeado4.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, 25));

        jLabel52.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(204, 204, 204));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("_____________________");
        jLabel52.setEnabled(false);
        panelRedondeado4.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 400, 30));

        jLabel53.setBackground(new java.awt.Color(0, 102, 153));
        jLabel53.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(102, 0, 0));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel53.setText("Apellidos:");
        panelRedondeado4.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, 25));

        newest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Nuevo.png"))); // NOI18N
        newest.addActionListener(this::newestActionPerformed);
        panelRedondeado4.add(newest, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 40, 40));

        editest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        editest.addActionListener(this::editestActionPerformed);
        panelRedondeado4.add(editest, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, 40, 40));

        txtnomest.setOpaque (false);
        txtnomest.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtnomest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnomest.setBorder(null);
        txtnomest.setCaretColor(new java.awt.Color(255, 255, 255));
        panelRedondeado4.add(txtnomest, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 290, 25));

        txtapeest.setOpaque (false);
        txtapeest.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtapeest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtapeest.setBorder(null);
        txtapeest.setCaretColor(new java.awt.Color(255, 255, 255));
        panelRedondeado4.add(txtapeest, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 290, 25));

        jLabel54.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(204, 204, 204));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("_____________________");
        jLabel54.setEnabled(false);
        panelRedondeado4.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 400, 30));

        jLabel55.setBackground(new java.awt.Color(0, 102, 153));
        jLabel55.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(102, 0, 0));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel55.setText("Cedula:");
        panelRedondeado4.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 90, 25));

        jLabel56.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(204, 204, 204));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("_____________________");
        jLabel56.setEnabled(false);
        panelRedondeado4.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 400, 30));

        txtcedest.setOpaque (false);
        txtcedest.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtcedest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcedest.setBorder(null);
        txtcedest.setCaretColor(new java.awt.Color(255, 255, 255));
        panelRedondeado4.add(txtcedest, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 290, 25));

        jLabel59.setBackground(new java.awt.Color(0, 102, 153));
        jLabel59.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(102, 0, 0));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel59.setText("Teléfono:");
        panelRedondeado4.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 90, 25));

        jLabel60.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(204, 204, 204));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("_____________________");
        jLabel60.setEnabled(false);
        panelRedondeado4.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 400, 30));

        txttlfest.setOpaque (false);
        txttlfest.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txttlfest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttlfest.setBorder(null);
        txttlfest.setCaretColor(new java.awt.Color(255, 255, 255));
        panelRedondeado4.add(txttlfest, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 290, 25));

        jLabel61.setBackground(new java.awt.Color(0, 102, 153));
        jLabel61.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(102, 0, 0));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel61.setText("Correo:");
        panelRedondeado4.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 90, 25));

        jLabel62.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(204, 204, 204));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("_____________________");
        jLabel62.setEnabled(false);
        panelRedondeado4.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 400, 30));

        txtcorest.setOpaque (false);
        txtcorest.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtcorest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcorest.setBorder(null);
        txtcorest.setCaretColor(new java.awt.Color(255, 255, 255));
        panelRedondeado4.add(txtcorest, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 290, 25));

        jLabel64.setBackground(new java.awt.Color(0, 102, 153));
        jLabel64.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(102, 0, 0));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel64.setText("Sexo:");
        panelRedondeado4.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 90, 25));

        jLabel65.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(204, 204, 204));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("_____________________");
        jLabel65.setEnabled(false);
        panelRedondeado4.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 400, 30));

        jLabel66.setBackground(new java.awt.Color(0, 102, 153));
        jLabel66.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(102, 0, 0));
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel66.setText("Procedencia:");
        panelRedondeado4.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 100, 25));

        jLabel67.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(204, 204, 204));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("_____________________");
        jLabel67.setEnabled(false);
        panelRedondeado4.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 400, 30));

        cbxSexEst.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        cbxSexEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        panelRedondeado4.add(cbxSexEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 280, 25));

        cbxProEst.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        cbxProEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Interno", "Externo" }));
        panelRedondeado4.add(cbxProEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 280, 25));

        jLabel68.setBackground(new java.awt.Color(0, 102, 153));
        jLabel68.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(102, 0, 0));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel68.setText("Carrera:");
        panelRedondeado4.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 100, 25));

        jLabel69.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(204, 204, 204));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("_____________________");
        jLabel69.setEnabled(false);
        panelRedondeado4.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 400, 30));

        jLabel70.setBackground(new java.awt.Color(0, 102, 153));
        jLabel70.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(102, 0, 0));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel70.setText("Semestre:");
        panelRedondeado4.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 100, 25));

        jLabel71.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(204, 204, 204));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("_____________________");
        jLabel71.setEnabled(false);
        panelRedondeado4.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 400, 30));

        cbxCarEst.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        panelRedondeado4.add(cbxCarEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 280, 25));

        cbxSemEst.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        cbxSemEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "n/a", "Primer semestre", "Segundo semestre", "Tercer semestre", "Cuarto semestre", "Quinto semestre", "Sexto semestre" }));
        panelRedondeado4.add(cbxSemEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 280, 25));

        elimest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/EliminarD.png"))); // NOI18N
        elimest.addActionListener(this::elimestActionPerformed);
        panelRedondeado4.add(elimest, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 40, 40));

        Panest.add(panelRedondeado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 420, 520));

        txtBuscarEst.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        Panest.add(txtBuscarEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 310, 50));

        btnaggmas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnaggmas.setText("Carga Masiva de Alumnos");
        btnaggmas.addActionListener(this::btnaggmasActionPerformed);
        Panest.add(btnaggmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 700, 620, 40));

        jTabbedPane1.addTab("Gestión de Estudiantes", Panest);

        Pancur.setBackground(new java.awt.Color(228, 228, 228));
        Pancur.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pancur.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableCur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Detalles", "Duración", "Precio", "Periodo", "Facilitador", "Modalidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(TableCur);
        if (TableCur.getColumnModel().getColumnCount() > 0) {
            TableCur.getColumnModel().getColumn(0).setMinWidth(15);
            TableCur.getColumnModel().getColumn(0).setPreferredWidth(50);
            TableCur.getColumnModel().getColumn(0).setMaxWidth(50);
            TableCur.getColumnModel().getColumn(3).setMinWidth(15);
            TableCur.getColumnModel().getColumn(3).setPreferredWidth(35);
            TableCur.getColumnModel().getColumn(4).setMinWidth(15);
            TableCur.getColumnModel().getColumn(4).setPreferredWidth(35);
        }

        Pancur.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 620, 580));
        Pancur.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, -40, 40, 40));

        aggcur.setBackground(new java.awt.Color(190, 55, 55));
        aggcur.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        aggcur.setForeground(new java.awt.Color(255, 255, 255));
        aggcur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        aggcur.setText("Agregar Curso");
        aggcur.addActionListener(this::aggcurActionPerformed);
        Pancur.add(aggcur, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 290, 50));

        panelRedondeado5.setBackground(new java.awt.Color(190, 55, 55));
        panelRedondeado5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIdcur.setForeground(new java.awt.Color(190, 55, 55));
        panelRedondeado5.add(txtIdcur, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 30, 20));

        nombrecur.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        nombrecur.setForeground(new java.awt.Color(190, 55, 55));
        nombrecur.setText("N");
        panelRedondeado5.add(nombrecur, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        Preciocur.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        Preciocur.setForeground(new java.awt.Color(190, 55, 55));
        Preciocur.setText("P");
        panelRedondeado5.add(Preciocur, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        Pancur.add(panelRedondeado5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 420, 220));

        panelRedondeado6.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondeado6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setBackground(new java.awt.Color(0, 102, 153));
        jLabel72.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(102, 0, 0));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel72.setText("Nombre:");
        panelRedondeado6.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, 25));

        jLabel80.setBackground(new java.awt.Color(0, 102, 153));
        jLabel80.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(102, 0, 0));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("Detalles:");
        panelRedondeado6.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 90, 60));

        newcur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Nuevo.png"))); // NOI18N
        newcur.addActionListener(this::newcurActionPerformed);
        panelRedondeado6.add(newcur, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 40, 40));

        editcur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        editcur.addActionListener(this::editcurActionPerformed);
        panelRedondeado6.add(editcur, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 40, 40));

        jLabel81.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(204, 204, 204));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("_____________________");
        jLabel81.setEnabled(false);
        panelRedondeado6.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 400, 30));

        jLabel83.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(204, 204, 204));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("_____________________");
        jLabel83.setEnabled(false);
        panelRedondeado6.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 400, 30));

        jLabel84.setBackground(new java.awt.Color(0, 102, 153));
        jLabel84.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(102, 0, 0));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel84.setText("Duración:");
        panelRedondeado6.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 90, 25));

        jLabel85.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(204, 204, 204));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("_____________________");
        jLabel85.setEnabled(false);
        panelRedondeado6.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 400, 30));

        jLabel86.setBackground(new java.awt.Color(0, 102, 153));
        jLabel86.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(102, 0, 0));
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel86.setText("Precio:");
        panelRedondeado6.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 90, 25));

        jLabel87.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(204, 204, 204));
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setText("_____________________");
        jLabel87.setEnabled(false);
        panelRedondeado6.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 400, 30));

        jLabel88.setBackground(new java.awt.Color(0, 102, 153));
        jLabel88.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(102, 0, 0));
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel88.setText("Periodo:");
        panelRedondeado6.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 90, 25));

        jLabel89.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(204, 204, 204));
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("_____________________");
        jLabel89.setEnabled(false);
        panelRedondeado6.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 400, 30));

        jLabel90.setBackground(new java.awt.Color(0, 102, 153));
        jLabel90.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(102, 0, 0));
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel90.setText("Facilitador:");
        panelRedondeado6.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 100, 25));

        jLabel91.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(204, 204, 204));
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("_____________________");
        jLabel91.setEnabled(false);
        panelRedondeado6.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 400, 30));

        txtnomcur.setOpaque (false);
        txtnomcur.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtnomcur.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnomcur.setBorder(null);
        txtnomcur.setCaretColor(new java.awt.Color(255, 255, 255));
        txtnomcur.addActionListener(this::txtnomcurActionPerformed);
        panelRedondeado6.add(txtnomcur, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 290, 25));

        jScrollPane6.setBackground(new java.awt.Color(0, 102, 153));
        jScrollPane6.setForeground(new java.awt.Color(255, 255, 255));

        txtdetallescur.setColumns(20);
        txtdetallescur.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtdetallescur.setRows(5);
        txtdetallescur.setBorder(null);
        jScrollPane6.setViewportView(txtdetallescur);

        panelRedondeado6.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 290, 60));

        txtduracioncur.setOpaque (false);
        txtduracioncur.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtduracioncur.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtduracioncur.setBorder(null);
        txtduracioncur.setCaretColor(new java.awt.Color(255, 255, 255));
        panelRedondeado6.add(txtduracioncur, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 290, 25));

        txtpreciocur.setOpaque (false);
        txtpreciocur.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtpreciocur.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpreciocur.setBorder(null);
        txtpreciocur.setCaretColor(new java.awt.Color(255, 255, 255));
        panelRedondeado6.add(txtpreciocur, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 290, 25));

        cbxCurperiodo.setOpaque(false);
        cbxCurperiodo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        panelRedondeado6.add(cbxCurperiodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 290, 25));

        cbxCurperiodo.setOpaque(false);
        cbxCurprofesor.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        panelRedondeado6.add(cbxCurprofesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 290, 25));

        elimcur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/EliminarD.png"))); // NOI18N
        elimcur.addActionListener(this::elimcurActionPerformed);
        panelRedondeado6.add(elimcur, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 40, 40));

        cbxCurperiodo.setOpaque(false);
        cbxModalidad.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        cbxModalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Presencial", "Virtual", "Semipresencial" }));
        panelRedondeado6.add(cbxModalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 290, 25));

        jLabel108.setBackground(new java.awt.Color(0, 102, 153));
        jLabel108.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(102, 0, 0));
        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel108.setText("Modalidad");
        panelRedondeado6.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 100, 25));

        jLabel109.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(204, 204, 204));
        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel109.setText("_____________________");
        jLabel109.setEnabled(false);
        panelRedondeado6.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 400, 30));

        Pancur.add(panelRedondeado6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 420, 470));

        jLabel40.setBackground(new java.awt.Color(0, 102, 153));
        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Cursos");
        Pancur.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 280, -1));

        txtBuscarCur.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        Pancur.add(txtBuscarCur, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 310, 50));

        jTabbedPane1.addTab("Gestión de Cursos", Pancur);

        Panprof.setBackground(new java.awt.Color(228, 228, 228));
        Panprof.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Panprof.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableProf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido", "Grado Academico", "Cedula", "Teléfono", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(TableProf);
        if (TableProf.getColumnModel().getColumnCount() > 0) {
            TableProf.getColumnModel().getColumn(0).setPreferredWidth(50);
            TableProf.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        Panprof.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 620, 580));

        panelRedondeado9.setBackground(new java.awt.Color(190, 55, 55));
        panelRedondeado9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIdprof.setForeground(new java.awt.Color(190, 55, 55));
        panelRedondeado9.add(txtIdprof, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 30, 20));

        nombreprof.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        nombreprof.setForeground(new java.awt.Color(190, 55, 55));
        nombreprof.setText("N");
        panelRedondeado9.add(nombreprof, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        cedulaprof.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        cedulaprof.setForeground(new java.awt.Color(190, 55, 55));
        cedulaprof.setText("C");
        panelRedondeado9.add(cedulaprof, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        apellidoprof.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        apellidoprof.setForeground(new java.awt.Color(190, 55, 55));
        apellidoprof.setText("A");
        panelRedondeado9.add(apellidoprof, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        Panprof.add(panelRedondeado9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 420, 220));

        panelRedondeado10.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondeado10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel82.setBackground(new java.awt.Color(0, 102, 153));
        jLabel82.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(102, 0, 0));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel82.setText("Nombre:");
        panelRedondeado10.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, 25));

        newprof.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Nuevo.png"))); // NOI18N
        newprof.addActionListener(this::newprofActionPerformed);
        panelRedondeado10.add(newprof, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 40, 40));

        editprof.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        editprof.addActionListener(this::editprofActionPerformed);
        panelRedondeado10.add(editprof, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 40, 40));

        jLabel94.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(204, 204, 204));
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setText("_____________________");
        jLabel94.setEnabled(false);
        panelRedondeado10.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 400, 20));

        jLabel96.setBackground(new java.awt.Color(0, 102, 153));
        jLabel96.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(102, 0, 0));
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel96.setText("Apellido:");
        panelRedondeado10.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 90, 25));

        jLabel97.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(204, 204, 204));
        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setText("_____________________");
        jLabel97.setEnabled(false);
        panelRedondeado10.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 400, 30));

        jLabel98.setBackground(new java.awt.Color(0, 102, 153));
        jLabel98.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(102, 0, 0));
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel98.setText("Cedula:");
        panelRedondeado10.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 90, 25));

        jLabel99.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(204, 204, 204));
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("_____________________");
        jLabel99.setEnabled(false);
        panelRedondeado10.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 400, 30));

        jLabel100.setBackground(new java.awt.Color(0, 102, 153));
        jLabel100.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(102, 0, 0));
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel100.setText("Teléfono:");
        panelRedondeado10.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 90, 25));

        jLabel101.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(204, 204, 204));
        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel101.setText("_____________________");
        jLabel101.setEnabled(false);
        panelRedondeado10.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 400, 30));

        jLabel102.setBackground(new java.awt.Color(0, 102, 153));
        jLabel102.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(102, 0, 0));
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel102.setText("Correo:");
        panelRedondeado10.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 90, 25));

        jLabel103.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(204, 204, 204));
        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel103.setText("_____________________");
        jLabel103.setEnabled(false);
        panelRedondeado10.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 400, 30));

        txtnomprof.setOpaque (false);
        txtnomprof.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtnomprof.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnomprof.setBorder(null);
        txtnomprof.setCaretColor(new java.awt.Color(255, 255, 255));
        panelRedondeado10.add(txtnomprof, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 290, 25));

        txtapeprof.setOpaque (false);
        txtapeprof.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtapeprof.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtapeprof.setBorder(null);
        txtapeprof.setCaretColor(new java.awt.Color(255, 255, 255));
        panelRedondeado10.add(txtapeprof, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 290, 25));

        txtcedprof.setOpaque (false);
        txtcedprof.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtcedprof.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcedprof.setBorder(null);
        txtcedprof.setCaretColor(new java.awt.Color(255, 255, 255));
        panelRedondeado10.add(txtcedprof, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 290, 25));

        txttlfprof.setOpaque (false);
        txttlfprof.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txttlfprof.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txttlfprof.setBorder(null);
        txttlfprof.setCaretColor(new java.awt.Color(255, 255, 255));
        panelRedondeado10.add(txttlfprof, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 290, 25));

        txtcorprof.setOpaque (false);
        txtcorprof.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtcorprof.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcorprof.setBorder(null);
        txtcorprof.setCaretColor(new java.awt.Color(255, 255, 255));
        txtcorprof.addActionListener(this::txtcorprofActionPerformed);
        panelRedondeado10.add(txtcorprof, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 290, 25));

        elimprof.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/EliminarD.png"))); // NOI18N
        elimprof.addActionListener(this::elimprofActionPerformed);
        panelRedondeado10.add(elimprof, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 40, 40));

        jLabel106.setBackground(new java.awt.Color(0, 102, 153));
        jLabel106.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(102, 0, 0));
        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel106.setText("Grado Academico:");
        panelRedondeado10.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 150, 25));

        jLabel110.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(204, 204, 204));
        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setText("_____________________");
        jLabel110.setEnabled(false);
        panelRedondeado10.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 400, 30));

        cbxgradoac.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        cbxgradoac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Téc.", "Tec.", "Lcdo.", "Lcda.", "Ing.", "Esp.", "Mag.", "MSc.", "Dr.", "Dra.", " " }));
        panelRedondeado10.add(cbxgradoac, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 240, -1));

        Panprof.add(panelRedondeado10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 420, 390));

        jLabel42.setBackground(new java.awt.Color(0, 102, 153));
        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Facilitadores");
        Panprof.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 280, -1));

        aggprof.setBackground(new java.awt.Color(190, 55, 55));
        aggprof.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        aggprof.setForeground(new java.awt.Color(255, 255, 255));
        aggprof.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        aggprof.setText("Agregar Facilitador");
        aggprof.addActionListener(this::aggprofActionPerformed);
        Panprof.add(aggprof, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 290, 50));

        txtBuscarProf.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        Panprof.add(txtBuscarProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 310, 50));

        jTabbedPane1.addTab("Gestión de Profesores", Panprof);

        PanCar.setBackground(new java.awt.Color(228, 228, 228));
        PanCar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanCar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableCar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Carrera"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableCar);
        if (TableCar.getColumnModel().getColumnCount() > 0) {
            TableCar.getColumnModel().getColumn(0).setMinWidth(20);
            TableCar.getColumnModel().getColumn(0).setPreferredWidth(50);
            TableCar.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        PanCar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 620, 580));

        panelRedondeado7.setBackground(new java.awt.Color(190, 55, 55));
        panelRedondeado7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIdcar.setForeground(new java.awt.Color(190, 55, 55));
        panelRedondeado7.add(txtIdcar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 30, 20));

        nomcar.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        nomcar.setForeground(new java.awt.Color(190, 55, 55));
        nomcar.setText("C");
        panelRedondeado7.add(nomcar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        PanCar.add(panelRedondeado7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 420, 160));

        panelRedondeado8.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondeado8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel79.setBackground(new java.awt.Color(0, 102, 153));
        jLabel79.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(102, 0, 0));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel79.setText("Carrera");
        panelRedondeado8.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, 25));

        newcar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Nuevo.png"))); // NOI18N
        newcar.addActionListener(this::newcarActionPerformed);
        panelRedondeado8.add(newcar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 40, 40));

        editcar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        editcar.addActionListener(this::editcarActionPerformed);
        panelRedondeado8.add(editcar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 40, 40));

        jLabel92.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(204, 204, 204));
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("_____________________");
        jLabel92.setEnabled(false);
        panelRedondeado8.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 400, 30));

        txtnewcar.setOpaque (false);
        txtnewcar.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtnewcar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnewcar.setBorder(null);
        txtnewcar.setCaretColor(new java.awt.Color(255, 255, 255));
        panelRedondeado8.add(txtnewcar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 280, 25));

        elimcar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/EliminarD.png"))); // NOI18N
        elimcar.addActionListener(this::elimcarActionPerformed);
        panelRedondeado8.add(elimcar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 40, 40));

        PanCar.add(panelRedondeado8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 420, 150));

        jLabel41.setBackground(new java.awt.Color(0, 102, 153));
        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Carreras");
        PanCar.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 280, -1));

        aggcar.setBackground(new java.awt.Color(190, 55, 55));
        aggcar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        aggcar.setForeground(new java.awt.Color(255, 255, 255));
        aggcar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        aggcar.setText("Agregar Carrera");
        aggcar.addActionListener(this::aggcarActionPerformed);
        PanCar.add(aggcar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 290, 50));

        txtBuscarCar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        PanCar.add(txtBuscarCar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 310, 50));

        jTabbedPane1.addTab("Nuevas Carreras", PanCar);

        Panins.setBackground(new java.awt.Color(228, 228, 228));
        Panins.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Panins.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRedondeado1.setBackground(new java.awt.Color(190, 55, 55));
        panelRedondeado1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIdins.setForeground(new java.awt.Color(190, 55, 55));
        txtIdins.setText("jLabel2");
        panelRedondeado1.add(txtIdins, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        nombreins.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        nombreins.setForeground(new java.awt.Color(190, 55, 55));
        nombreins.setText("N");
        panelRedondeado1.add(nombreins, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        cursoins.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        cursoins.setForeground(new java.awt.Color(190, 55, 55));
        cursoins.setText("C");
        panelRedondeado1.add(cursoins, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        Panins.add(panelRedondeado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 420, 210));

        panelRedondeado2.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondeado2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxcurest.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        panelRedondeado2.add(cbxcurest, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 270, -1));

        jLabel44.setBackground(new java.awt.Color(0, 102, 153));
        jLabel44.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(102, 0, 0));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel44.setText("Estudiante:");
        panelRedondeado2.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, -1));

        jLabel45.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(204, 204, 204));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("_____________________");
        jLabel45.setEnabled(false);
        panelRedondeado2.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 400, 30));

        cbxnomest.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        panelRedondeado2.add(cbxnomest, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 270, -1));

        jLabel50.setBackground(new java.awt.Color(0, 102, 153));
        jLabel50.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(102, 0, 0));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel50.setText("Curso:");
        panelRedondeado2.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 25));

        newins.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Nuevo.png"))); // NOI18N
        newins.addActionListener(this::newinsActionPerformed);
        panelRedondeado2.add(newins, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 40, 40));

        editins.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        editins.addActionListener(this::editinsActionPerformed);
        panelRedondeado2.add(editins, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 40, 40));

        elimins.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/EliminarD.png"))); // NOI18N
        elimins.addActionListener(this::eliminsActionPerformed);
        panelRedondeado2.add(elimins, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 40, 40));

        Panins.add(panelRedondeado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 420, 180));

        jScrollPane2.setBackground(new java.awt.Color(0, 102, 153));

        TableIns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Estudiante", "Curso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TableIns);
        if (TableIns.getColumnModel().getColumnCount() > 0) {
            TableIns.getColumnModel().getColumn(0).setPreferredWidth(50);
            TableIns.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        Panins.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 620, 580));

        jLabel36.setBackground(new java.awt.Color(0, 102, 153));
        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Inscripciones");
        Panins.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 280, -1));

        aggins.setBackground(new java.awt.Color(190, 55, 55));
        aggins.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        aggins.setForeground(new java.awt.Color(255, 255, 255));
        aggins.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        aggins.setText("Inscribir Estudiante");
        aggins.addActionListener(this::agginsActionPerformed);
        Panins.add(aggins, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 290, 50));

        txtBuscarIns.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        Panins.add(txtBuscarIns, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 310, 50));

        btninsmas.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btninsmas.setText("Inscripción Múltiple");
        Panins.add(btninsmas, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 670, 620, 40));

        jTabbedPane1.addTab("Inscripciones", Panins);

        Pangestus.setBackground(new java.awt.Color(228, 228, 228));
        Pangestus.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pangestus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel63.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        Pangestus.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, -1, -1));

        panelbordearribaredondeado6.setBackground(new java.awt.Color(144, 41, 41));
        panelbordearribaredondeado6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel104.setBackground(new java.awt.Color(0, 102, 153));
        jLabel104.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(255, 255, 255));
        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel104.setText("Filtros de cursos");
        panelbordearribaredondeado6.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 260, -1));

        Pangestus.add(panelbordearribaredondeado6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1020, 80));

        panelRedondeado15.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondeado15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRedondeado15.add(txtperiodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 310, 40));

        jLabel95.setBackground(new java.awt.Color(0, 102, 153));
        jLabel95.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("Periodo nuevo");
        panelRedondeado15.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 20, 320, 30));

        TablePer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "periodo", "Fecha de inicio", "estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(TablePer);
        if (TablePer.getColumnModel().getColumnCount() > 0) {
            TablePer.getColumnModel().getColumn(0).setResizable(false);
            TablePer.getColumnModel().getColumn(0).setPreferredWidth(40);
            TablePer.getColumnModel().getColumn(1).setResizable(false);
            TablePer.getColumnModel().getColumn(2).setResizable(false);
            TablePer.getColumnModel().getColumn(3).setResizable(false);
        }

        panelRedondeado15.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 500, 100));

        aggper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ADD.png"))); // NOI18N
        panelRedondeado15.add(aggper, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 40, 40));

        Pangestus.add(panelRedondeado15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 1020, 110));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxPeriodoestado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbxPeriodoestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Periodo Académico..." }));
        jPanel6.add(cbxPeriodoestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 330, 40));

        cbxCursoestado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbxCursoestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Curso..." }));
        jPanel6.add(cbxCursoestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 320, 40));

        Filtrarestado.setBackground(new java.awt.Color(144, 41, 41));
        Filtrarestado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Filtrarestado.setForeground(new java.awt.Color(255, 255, 255));
        Filtrarestado.setText("Filtrar Cursos");
        jPanel6.add(Filtrarestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 170, 40));
        jPanel6.add(idestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, 40, 20));

        Pangestus.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 1020, 40));

        panelbordearribaredondeado7.setBackground(new java.awt.Color(144, 41, 41));
        panelbordearribaredondeado7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel107.setBackground(new java.awt.Color(0, 102, 153));
        jLabel107.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(255, 255, 255));
        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel107.setText("Filtros de cursos");
        panelbordearribaredondeado7.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 260, -1));

        Pangestus.add(panelbordearribaredondeado7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 1020, 80));

        TableEstado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre y Apellido", "Cedula", "Curso", "Duración", "Fecha de inicio", "Facilitador", "Estado", "Periodo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableEstado.setComponentPopupMenu(jPopupMenu2);
        jScrollPane9.setViewportView(TableEstado);
        if (TableEstado.getColumnModel().getColumnCount() > 0) {
            TableEstado.getColumnModel().getColumn(0).setResizable(false);
            TableEstado.getColumnModel().getColumn(0).setPreferredWidth(50);
            TableEstado.getColumnModel().getColumn(1).setPreferredWidth(200);
            TableEstado.getColumnModel().getColumn(2).setResizable(false);
            TableEstado.getColumnModel().getColumn(2).setPreferredWidth(200);
            TableEstado.getColumnModel().getColumn(3).setResizable(false);
            TableEstado.getColumnModel().getColumn(3).setPreferredWidth(200);
            TableEstado.getColumnModel().getColumn(4).setResizable(false);
            TableEstado.getColumnModel().getColumn(4).setPreferredWidth(100);
            TableEstado.getColumnModel().getColumn(5).setResizable(false);
            TableEstado.getColumnModel().getColumn(5).setPreferredWidth(150);
            TableEstado.getColumnModel().getColumn(6).setResizable(false);
            TableEstado.getColumnModel().getColumn(6).setPreferredWidth(200);
            TableEstado.getColumnModel().getColumn(7).setResizable(false);
            TableEstado.getColumnModel().getColumn(7).setPreferredWidth(200);
            TableEstado.getColumnModel().getColumn(8).setResizable(false);
        }

        Pangestus.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 1020, 360));

        jLabel105.setBackground(new java.awt.Color(0, 102, 153));
        jLabel105.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel105.setText("Estado De los Cursos");
        Pangestus.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 350, -1));

        jTabbedPane1.addTab("Estado", Pangestus);

        Pancert.setBackground(new java.awt.Color(228, 228, 228));
        Pancert.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pancert.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelbordearribaredondeado2.setBackground(new java.awt.Color(144, 41, 41));
        panelbordearribaredondeado2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setBackground(new java.awt.Color(0, 102, 153));
        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Filtros de cursos");
        panelbordearribaredondeado2.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 260, -1));

        Pancert.add(panelbordearribaredondeado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1020, 80));

        panelRedondeado13.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondeado13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FiltrarCert.setBackground(new java.awt.Color(144, 41, 41));
        FiltrarCert.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        FiltrarCert.setForeground(new java.awt.Color(255, 255, 255));
        FiltrarCert.setText("Filtrar Cursos");
        panelRedondeado13.add(FiltrarCert, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 170, 40));

        cbxCursocert.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbxCursocert.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Curso..." }));
        panelRedondeado13.add(cbxCursocert, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 380, 40));

        jLabel38.setBackground(new java.awt.Color(0, 102, 153));
        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel38.setText("Curso");
        panelRedondeado13.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 380, -1));

        cbxPeriodocert.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbxPeriodocert.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Periodo Académico..." }));
        panelRedondeado13.add(cbxPeriodocert, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 380, 40));

        jLabel73.setBackground(new java.awt.Color(0, 102, 153));
        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel73.setText("Periodo Académico");
        panelRedondeado13.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 380, -1));

        Pancert.add(panelRedondeado13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 1020, 90));

        jLabel43.setBackground(new java.awt.Color(0, 102, 153));
        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Emisión de certificados");
        Pancert.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 400, -1));

        panelbordearribaredondeado3.setBackground(new java.awt.Color(144, 41, 41));
        panelbordearribaredondeado3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setBackground(new java.awt.Color(0, 102, 153));
        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("Cursos Terminado y Emisión de Certificados");
        panelbordearribaredondeado3.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 640, -1));

        Pancert.add(panelbordearribaredondeado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 1020, 80));

        TableCert.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre y apellido", "Cedula", "Curso", "Duración", "Fecha de inicio", "Facilitador", "Estado", "Periodo", "Detalles"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(TableCert);
        if (TableCert.getColumnModel().getColumnCount() > 0) {
            TableCert.getColumnModel().getColumn(0).setResizable(false);
            TableCert.getColumnModel().getColumn(0).setPreferredWidth(50);
            TableCert.getColumnModel().getColumn(1).setResizable(false);
            TableCert.getColumnModel().getColumn(1).setPreferredWidth(200);
            TableCert.getColumnModel().getColumn(2).setResizable(false);
            TableCert.getColumnModel().getColumn(2).setPreferredWidth(200);
            TableCert.getColumnModel().getColumn(3).setResizable(false);
            TableCert.getColumnModel().getColumn(3).setPreferredWidth(200);
            TableCert.getColumnModel().getColumn(4).setResizable(false);
            TableCert.getColumnModel().getColumn(4).setPreferredWidth(100);
            TableCert.getColumnModel().getColumn(5).setResizable(false);
            TableCert.getColumnModel().getColumn(5).setPreferredWidth(150);
            TableCert.getColumnModel().getColumn(6).setResizable(false);
            TableCert.getColumnModel().getColumn(6).setPreferredWidth(200);
            TableCert.getColumnModel().getColumn(7).setResizable(false);
            TableCert.getColumnModel().getColumn(8).setResizable(false);
            TableCert.getColumnModel().getColumn(9).setResizable(false);
        }

        Pancert.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 1020, 400));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setText("Participantes Aprobados");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 230, 40));

        exportarcert.setBackground(new java.awt.Color(144, 41, 41));
        exportarcert.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        exportarcert.setForeground(new java.awt.Color(255, 255, 255));
        exportarcert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PDF.png"))); // NOI18N
        exportarcert.setText("Exportar Certificados");
        exportarcert.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        exportarcert.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel2.add(exportarcert, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 280, 40));

        Pancert.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 1020, 40));

        jTabbedPane1.addTab("Certificado", Pancert);

        Panrep.setBackground(new java.awt.Color(228, 228, 228));
        Panrep.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Panrep.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Curso", "Duración", "Fecha_inicio", "Cedula", "Nombres", "Apellidos", "Carrera", "Semestre", "Costo", "Sexo", "Procedencia", "Periodo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(TableReporte);
        if (TableReporte.getColumnModel().getColumnCount() > 0) {
            TableReporte.getColumnModel().getColumn(0).setResizable(false);
            TableReporte.getColumnModel().getColumn(0).setPreferredWidth(50);
            TableReporte.getColumnModel().getColumn(1).setResizable(false);
            TableReporte.getColumnModel().getColumn(2).setResizable(false);
            TableReporte.getColumnModel().getColumn(3).setResizable(false);
            TableReporte.getColumnModel().getColumn(4).setResizable(false);
            TableReporte.getColumnModel().getColumn(4).setPreferredWidth(200);
            TableReporte.getColumnModel().getColumn(5).setResizable(false);
            TableReporte.getColumnModel().getColumn(5).setPreferredWidth(200);
            TableReporte.getColumnModel().getColumn(6).setResizable(false);
            TableReporte.getColumnModel().getColumn(6).setPreferredWidth(200);
            TableReporte.getColumnModel().getColumn(7).setResizable(false);
            TableReporte.getColumnModel().getColumn(7).setPreferredWidth(200);
            TableReporte.getColumnModel().getColumn(8).setResizable(false);
            TableReporte.getColumnModel().getColumn(8).setPreferredWidth(100);
            TableReporte.getColumnModel().getColumn(9).setResizable(false);
            TableReporte.getColumnModel().getColumn(10).setResizable(false);
            TableReporte.getColumnModel().getColumn(11).setResizable(false);
            TableReporte.getColumnModel().getColumn(12).setResizable(false);
        }

        Panrep.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 1020, 400));

        panelbordearribaredondeado4.setBackground(new java.awt.Color(144, 41, 41));
        panelbordearribaredondeado4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setBackground(new java.awt.Color(0, 102, 153));
        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("Datos del reporte");
        panelbordearribaredondeado4.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 270, -1));

        Panrep.add(panelbordearribaredondeado4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 1020, 80));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exportarreport.setBackground(new java.awt.Color(144, 41, 41));
        exportarreport.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        exportarreport.setForeground(new java.awt.Color(255, 255, 255));
        exportarreport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PDF.png"))); // NOI18N
        exportarreport.setText("Exportar Reportes");
        exportarreport.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        exportarreport.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel5.add(exportarreport, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 280, 40));

        Panrep.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 1020, 40));

        panelbordearribaredondeado5.setBackground(new java.awt.Color(144, 41, 41));
        panelbordearribaredondeado5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel78.setBackground(new java.awt.Color(0, 102, 153));
        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("Nuevo Periodo");
        panelbordearribaredondeado5.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 240, -1));

        Panrep.add(panelbordearribaredondeado5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1020, 80));

        panelRedondeado14.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondeado14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setBackground(new java.awt.Color(0, 102, 153));
        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel77.setText("Periodo Académico");
        panelRedondeado14.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 380, -1));

        cbxPeriodorep.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbxPeriodorep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Periodo Académico..." }));
        panelRedondeado14.add(cbxPeriodorep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 380, 40));

        cbxCursorep.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbxCursorep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Curso..." }));
        panelRedondeado14.add(cbxCursorep, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 380, 40));

        Filtrarrep.setBackground(new java.awt.Color(144, 41, 41));
        Filtrarrep.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Filtrarrep.setForeground(new java.awt.Color(255, 255, 255));
        Filtrarrep.setText("Filtrar Cursos");
        panelRedondeado14.add(Filtrarrep, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 170, 40));

        jLabel76.setBackground(new java.awt.Color(0, 102, 153));
        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel76.setText("Curso");
        panelRedondeado14.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 380, -1));

        Panrep.add(panelRedondeado14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 1020, 110));

        jLabel93.setBackground(new java.awt.Color(0, 102, 153));
        jLabel93.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("Emisión de Reportes");
        Panrep.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 360, -1));

        jTabbedPane1.addTab("reportes", Panrep);

        Panus.setBackground(new java.awt.Color(228, 228, 228));
        Panus.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Panus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tableus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Usuario", "Rol", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(Tableus);
        if (Tableus.getColumnModel().getColumnCount() > 0) {
            Tableus.getColumnModel().getColumn(0).setResizable(false);
            Tableus.getColumnModel().getColumn(0).setPreferredWidth(50);
            Tableus.getColumnModel().getColumn(1).setResizable(false);
            Tableus.getColumnModel().getColumn(2).setResizable(false);
            Tableus.getColumnModel().getColumn(3).setResizable(false);
            Tableus.getColumnModel().getColumn(4).setResizable(false);
        }

        Panus.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 620, 580));

        jLabel37.setBackground(new java.awt.Color(0, 102, 153));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Usuarios");
        Panus.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 280, -1));

        panelRedondeado11.setBackground(new java.awt.Color(190, 55, 55));
        panelRedondeado11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIdus.setForeground(new java.awt.Color(190, 55, 55));
        txtIdus.setText("jLabel2");
        panelRedondeado11.add(txtIdus, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        nombreUsuario.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        nombreUsuario.setForeground(new java.awt.Color(190, 55, 55));
        nombreUsuario.setText("N");
        panelRedondeado11.add(nombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        Usuario.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        Usuario.setForeground(new java.awt.Color(190, 55, 55));
        Usuario.setText("U");
        panelRedondeado11.add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        Panus.add(panelRedondeado11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 420, 210));

        panelRedondeado12.setBackground(new java.awt.Color(255, 255, 255));
        panelRedondeado12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setBackground(new java.awt.Color(0, 102, 153));
        jLabel46.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(102, 0, 0));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel46.setText("Nombre del Usuario:");
        panelRedondeado12.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 25));

        jLabel47.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(204, 204, 204));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("_____________________");
        jLabel47.setEnabled(false);
        panelRedondeado12.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 400, 30));

        jLabel57.setBackground(new java.awt.Color(0, 102, 153));
        jLabel57.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(102, 0, 0));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel57.setText("Usuario:");
        panelRedondeado12.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, 25));

        elimus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/EliminarD.png"))); // NOI18N
        elimus.addActionListener(this::elimusActionPerformed);
        panelRedondeado12.add(elimus, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 40, 40));

        editus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        editus.addActionListener(this::editusActionPerformed);
        panelRedondeado12.add(editus, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 40, 40));

        jLabel48.setFont(new java.awt.Font("Yu Gothic Medium", 0, 36)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(204, 204, 204));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("_____________________");
        jLabel48.setEnabled(false);
        panelRedondeado12.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 400, 30));

        jLabel58.setBackground(new java.awt.Color(0, 102, 153));
        jLabel58.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(102, 0, 0));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel58.setText("Contraseña:");
        panelRedondeado12.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 90, 25));

        txtnomus.setOpaque (false);
        txtnomus.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtnomus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnomus.setBorder(null);
        txtnomus.setCaretColor(new java.awt.Color(255, 255, 255));
        panelRedondeado12.add(txtnomus, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 43, 230, -1));

        txtusuario.setOpaque (false);
        txtusuario.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtusuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtusuario.setBorder(null);
        txtusuario.setCaretColor(new java.awt.Color(255, 255, 255));
        panelRedondeado12.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 83, 290, -1));

        txtcontus.setOpaque (false);
        txtcontus.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtcontus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcontus.setBorder(null);
        txtcontus.setCaretColor(new java.awt.Color(255, 255, 255));
        panelRedondeado12.add(txtcontus, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 123, 290, -1));

        newus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Nuevo.png"))); // NOI18N
        newus.addActionListener(this::newusActionPerformed);
        panelRedondeado12.add(newus, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 40, 40));

        Panus.add(panelRedondeado12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 420, 210));

        aggus.setBackground(new java.awt.Color(190, 55, 55));
        aggus.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        aggus.setForeground(new java.awt.Color(255, 255, 255));
        aggus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        aggus.setText("Agregar Usuario");
        aggus.addActionListener(this::aggusActionPerformed);
        Panus.add(aggus, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 290, 50));

        txtBuscarUs.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        Panus.add(txtBuscarUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 310, 50));

        jTabbedPane1.addTab("Usuarios", Panus);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 65, 1080, 820));

        Panmenu.setBackground(new java.awt.Color(235, 218, 218));
        Panmenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtconfiguracion.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtconfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/engranaje.png"))); // NOI18N
        txtconfiguracion.setText("CONFIGURACIÓN");
        Panmenu.add(txtconfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 200, 60));

        txtdatos.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtdatos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtdatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/datos.png"))); // NOI18N
        txtdatos.setText("DATOS");
        Panmenu.add(txtdatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 60));

        panest.setBackground(new java.awt.Color(190, 55, 55));
        panest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtest.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtest.setForeground(new java.awt.Color(255, 255, 255));
        txtest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtest.setText("Gestión de estudiantes");
        txtest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtest.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        panest.add(txtest, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 0, 200, 40));

        Panmenu.add(panest, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 200, 40));

        pancur.setBackground(new java.awt.Color(235, 218, 218));
        pancur.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcur.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtcur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtcur.setText("Gestión de Cursos");
        txtcur.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtcur.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        pancur.add(txtcur, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        Panmenu.add(pancur, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 40));

        panprof.setBackground(new java.awt.Color(235, 218, 218));
        panprof.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtprof.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtprof.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtprof.setText("Gestión de Facilitadores");
        txtprof.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtprof.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        panprof.add(txtprof, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        Panmenu.add(panprof, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 200, 40));

        pancar.setBackground(new java.awt.Color(235, 218, 218));
        pancar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtcar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtcar.setText("Gestión de Carreras");
        txtcar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtcar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        pancar.add(txtcar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        Panmenu.add(pancar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 200, 40));

        panin.setBackground(new java.awt.Color(235, 218, 218));
        panin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtnins.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtnins.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtnins.setText("Inscripciones");
        txtnins.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panin.add(txtnins, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        Panmenu.add(panin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 200, 40));

        panestins.setBackground(new java.awt.Color(235, 218, 218));
        panestins.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtestins.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtestins.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtestins.setText("Estado");
        txtestins.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panestins.add(txtestins, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        Panmenu.add(panestins, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 200, 40));

        txtoperaciones.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtoperaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/config.png"))); // NOI18N
        txtoperaciones.setText("OPERACIONES");
        Panmenu.add(txtoperaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 200, 60));

        txtdocumentacion.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtdocumentacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/datos.png"))); // NOI18N
        txtdocumentacion.setText("DOCUMENTACIÓN");
        Panmenu.add(txtdocumentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 200, 60));

        pancert.setBackground(new java.awt.Color(235, 218, 218));
        pancert.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtcert.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtcert.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtcert.setText("Certificados");
        txtcert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pancert.add(txtcert, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        Panmenu.add(pancert, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 200, 40));

        panrep.setBackground(new java.awt.Color(235, 218, 218));
        panrep.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtrep.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtrep.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtrep.setText("Reportes");
        txtrep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panrep.add(txtrep, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        Panmenu.add(panrep, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 200, 40));

        panus.setBackground(new java.awt.Color(235, 218, 218));
        panus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtus.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtus.setText("Usuarios");
        txtus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panus.add(txtus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 40));

        Panmenu.add(panus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 200, 40));

        jPanel1.add(Panmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, 780));

        txtIdcron.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(txtIdcron, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 60, 10, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1280, 870));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnomcurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomcurActionPerformed
        txtnomcur.transferFocus();
    }//GEN-LAST:event_txtnomcurActionPerformed

    private void agginsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agginsActionPerformed
        if (inscon != null) {
            inscon.onAgregarInscripcion();
        }
    }//GEN-LAST:event_agginsActionPerformed

    private void newinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newinsActionPerformed
        if (inscon != null) {
            inscon.onNuevoInscripcion();
        }
    }//GEN-LAST:event_newinsActionPerformed

    private void editinsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editinsActionPerformed
        if (inscon != null) {
            inscon.onEditarInscripcion();
        }
    }//GEN-LAST:event_editinsActionPerformed

    private void btncerrarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarsActionPerformed
        jPopupMenu1.show(btncerrars, 0, btncerrars.getHeight());
    }//GEN-LAST:event_btncerrarsActionPerformed

    private void aggestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggestActionPerformed
        if (estcon != null) {
            estcon.onAgregarEstudiante();
        }
    }//GEN-LAST:event_aggestActionPerformed

    private void newestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newestActionPerformed
        if (estcon != null) {
            estcon.onNuevoEstudiante();
        }
    }//GEN-LAST:event_newestActionPerformed

    private void editestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editestActionPerformed
        if (estcon != null) {
            estcon.onEditarEstudiante();
        }
    }//GEN-LAST:event_editestActionPerformed

    private void aggcurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggcurActionPerformed
        if (curcon != null) {
            curcon.onAgregarCurso();
        }
    }//GEN-LAST:event_aggcurActionPerformed

    private void newcurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newcurActionPerformed
        if (curcon != null) {
            curcon.onNuevoCurso();
        }
    }//GEN-LAST:event_newcurActionPerformed

    private void editcurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editcurActionPerformed
        if (curcon != null) {
            curcon.onEditarCurso();
        }
    }//GEN-LAST:event_editcurActionPerformed

    private void newcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newcarActionPerformed
        if (carcon != null) {
            carcon.onNuevoCarrera();
        }
    }//GEN-LAST:event_newcarActionPerformed

    private void editcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editcarActionPerformed
        if (carcon != null) {
            carcon.onEditarCarrera();
        }
    }//GEN-LAST:event_editcarActionPerformed

    private void aggcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggcarActionPerformed
        if (carcon != null) {
            carcon.onAgregarCarrera();
        }
    }//GEN-LAST:event_aggcarActionPerformed

    private void newprofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newprofActionPerformed
        if (profcon != null) {
            profcon.onNuevoProfesor();
        }
    }//GEN-LAST:event_newprofActionPerformed

    private void editprofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editprofActionPerformed
        if (profcon != null) {
            profcon.onEditarProfesor();
        }
    }//GEN-LAST:event_editprofActionPerformed

    private void txtcorprofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorprofActionPerformed
        txtcorprof.transferFocus();
    }//GEN-LAST:event_txtcorprofActionPerformed

    private void aggprofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggprofActionPerformed
        if (profcon != null) {
            profcon.onAgregarProfesor();
        }
    }//GEN-LAST:event_aggprofActionPerformed

    private void elimusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elimusActionPerformed
        if (uscon != null) {
            uscon.onEliminarUsuario();
        }
    }//GEN-LAST:event_elimusActionPerformed

    private void editusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editusActionPerformed
        if (uscon != null) {
            uscon.onEditarUsuario();
        }
    }//GEN-LAST:event_editusActionPerformed

    private void aggusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggusActionPerformed
        if (uscon != null) {
            uscon.onAgregarUsuario();
        }
    }//GEN-LAST:event_aggusActionPerformed

    private void elimestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elimestActionPerformed
        if (estcon != null) {
            estcon.onEliminarEstudiante();
        }
    }//GEN-LAST:event_elimestActionPerformed

    private void elimcurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elimcurActionPerformed
        if (curcon != null) {
            curcon.onEliminarCurso();
        }
    }//GEN-LAST:event_elimcurActionPerformed

    private void elimprofActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elimprofActionPerformed
        if (profcon != null) {
            profcon.onEliminarProfesor();
        }
    }//GEN-LAST:event_elimprofActionPerformed

    private void elimcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elimcarActionPerformed
        if (carcon != null) {
            carcon.onEliminarCarrera();
        }
    }//GEN-LAST:event_elimcarActionPerformed

    private void eliminsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminsActionPerformed
        if (inscon != null) {
            inscon.onEliminarInscripcion();
        }
    }//GEN-LAST:event_eliminsActionPerformed

    private void newusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newusActionPerformed
        if (uscon != null) {
            uscon.onNuevoUsuario();
        }
    }//GEN-LAST:event_newusActionPerformed

    private void btnaggmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaggmasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnaggmasActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Principal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Apellidoest;
    public javax.swing.JMenuItem Aprobar;
    public javax.swing.JMenuItem Cambiarcontraseña;
    public javax.swing.JMenuItem Cerrar;
    public javax.swing.JButton FiltrarCert;
    public javax.swing.JButton Filtrarestado;
    public javax.swing.JButton Filtrarrep;
    private javax.swing.JPanel PanCar;
    private javax.swing.JPanel Pancert;
    private javax.swing.JPanel Pancur;
    private javax.swing.JPanel Panest;
    private javax.swing.JPanel Pangestus;
    public javax.swing.JPanel Panins;
    public javax.swing.JPanel Panmenu;
    private javax.swing.JPanel Panprof;
    private javax.swing.JPanel Panrep;
    private javax.swing.JPanel Panus;
    public javax.swing.JLabel Preciocur;
    public javax.swing.JMenuItem Reprobar;
    public javax.swing.JMenuItem Sesión;
    public javax.swing.JTable TableCar;
    public javax.swing.JTable TableCert;
    public javax.swing.JTable TableCur;
    public javax.swing.JTable TableEst;
    public javax.swing.JTable TableEstado;
    public javax.swing.JTable TableIns;
    public javax.swing.JTable TablePer;
    public javax.swing.JTable TableProf;
    public javax.swing.JTable TableReporte;
    public javax.swing.JTable Tableus;
    public javax.swing.JLabel Usuario;
    public javax.swing.JButton aggcar;
    public javax.swing.JButton aggcur;
    public javax.swing.JButton aggest;
    public javax.swing.JButton aggins;
    public javax.swing.JButton aggper;
    public javax.swing.JButton aggprof;
    public javax.swing.JButton aggus;
    public javax.swing.JLabel apellidoprof;
    public javax.swing.JButton btnaggmas;
    public javax.swing.JButton btncerrars;
    public javax.swing.JButton btninsmas;
    public javax.swing.JComboBox<Object> cbxCarEst;
    public javax.swing.JComboBox<Object> cbxCurperiodo;
    public javax.swing.JComboBox<Object> cbxCurprofesor;
    public javax.swing.JComboBox<Object> cbxCursocert;
    public javax.swing.JComboBox<Object> cbxCursoestado;
    public javax.swing.JComboBox<Object> cbxCursorep;
    public javax.swing.JComboBox<Object> cbxModalidad;
    public javax.swing.JComboBox<Object> cbxPeriodocert;
    public javax.swing.JComboBox<Object> cbxPeriodoestado;
    public javax.swing.JComboBox<Object> cbxPeriodorep;
    public javax.swing.JComboBox<Object> cbxProEst;
    public javax.swing.JComboBox<Object> cbxSemEst;
    public javax.swing.JComboBox<Object> cbxSexEst;
    public javax.swing.JComboBox<Object> cbxcurest;
    public javax.swing.JComboBox<Object> cbxgradoac;
    public javax.swing.JComboBox<Object> cbxnomest;
    public javax.swing.JLabel cedulaest;
    public javax.swing.JLabel cedulaprof;
    public javax.swing.JLabel cursoins;
    public javax.swing.JButton editcar;
    public javax.swing.JButton editcur;
    public javax.swing.JButton editest;
    public javax.swing.JButton editins;
    public javax.swing.JButton editprof;
    public javax.swing.JButton editus;
    public javax.swing.JButton elimcar;
    public javax.swing.JButton elimcur;
    public javax.swing.JButton elimest;
    public javax.swing.JButton elimins;
    public javax.swing.JButton elimprof;
    public javax.swing.JButton elimus;
    public javax.swing.JButton exportarcert;
    public javax.swing.JButton exportarreport;
    public javax.swing.JLabel idUsuario;
    public javax.swing.JLabel idestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public javax.swing.JTabbedPane jTabbedPane1;
    public javax.swing.JButton newcar;
    public javax.swing.JButton newcur;
    public javax.swing.JButton newest;
    public javax.swing.JButton newins;
    public javax.swing.JButton newprof;
    public javax.swing.JButton newus;
    public javax.swing.JLabel nombreUsuario;
    public javax.swing.JLabel nombrecur;
    public javax.swing.JLabel nombreest;
    public javax.swing.JLabel nombreins;
    public javax.swing.JLabel nombreprof;
    public javax.swing.JLabel nomcar;
    public com.mycompany.saiusf.util.PanelRedondeado pancar;
    public com.mycompany.saiusf.util.PanelRedondeado pancert;
    public com.mycompany.saiusf.util.PanelRedondeado pancur;
    private com.mycompany.saiusf.util.PanelRedondeado panelRedondeado1;
    private com.mycompany.saiusf.util.PanelRedondeado panelRedondeado10;
    private com.mycompany.saiusf.util.PanelRedondeado panelRedondeado11;
    private com.mycompany.saiusf.util.PanelRedondeado panelRedondeado12;
    private com.mycompany.saiusf.util.PanelRedondeado panelRedondeado13;
    private com.mycompany.saiusf.util.PanelRedondeado panelRedondeado14;
    private com.mycompany.saiusf.util.PanelRedondeado panelRedondeado15;
    private com.mycompany.saiusf.util.PanelRedondeado panelRedondeado2;
    private com.mycompany.saiusf.util.PanelRedondeado panelRedondeado3;
    private com.mycompany.saiusf.util.PanelRedondeado panelRedondeado4;
    private com.mycompany.saiusf.util.PanelRedondeado panelRedondeado5;
    private com.mycompany.saiusf.util.PanelRedondeado panelRedondeado6;
    private com.mycompany.saiusf.util.PanelRedondeado panelRedondeado7;
    private com.mycompany.saiusf.util.PanelRedondeado panelRedondeado8;
    private com.mycompany.saiusf.util.PanelRedondeado panelRedondeado9;
    private com.mycompany.saiusf.util.Panelbordearribaredondeado panelbordearribaredondeado2;
    private com.mycompany.saiusf.util.Panelbordearribaredondeado panelbordearribaredondeado3;
    private com.mycompany.saiusf.util.Panelbordearribaredondeado panelbordearribaredondeado4;
    private com.mycompany.saiusf.util.Panelbordearribaredondeado panelbordearribaredondeado5;
    private com.mycompany.saiusf.util.Panelbordearribaredondeado panelbordearribaredondeado6;
    private com.mycompany.saiusf.util.Panelbordearribaredondeado panelbordearribaredondeado7;
    public com.mycompany.saiusf.util.PanelRedondeado panest;
    public com.mycompany.saiusf.util.PanelRedondeado panestins;
    public com.mycompany.saiusf.util.PanelRedondeado panin;
    public com.mycompany.saiusf.util.PanelRedondeado panprof;
    public com.mycompany.saiusf.util.PanelRedondeado panrep;
    public com.mycompany.saiusf.util.PanelRedondeado panus;
    public javax.swing.JLabel rolUsuario;
    public javax.swing.JTextField txtBuscarCar;
    public javax.swing.JTextField txtBuscarCur;
    public javax.swing.JTextField txtBuscarEst;
    public javax.swing.JTextField txtBuscarIns;
    public javax.swing.JTextField txtBuscarProf;
    public javax.swing.JTextField txtBuscarUs;
    public javax.swing.JLabel txtIdcar;
    private javax.swing.JLabel txtIdcron;
    public javax.swing.JLabel txtIdcur;
    public javax.swing.JLabel txtIdest;
    public javax.swing.JLabel txtIdins;
    public javax.swing.JLabel txtIdprof;
    public javax.swing.JLabel txtIdus;
    public javax.swing.JTextField txtapeest;
    public javax.swing.JTextField txtapeprof;
    public javax.swing.JLabel txtbienvenido;
    public javax.swing.JLabel txtcar;
    public javax.swing.JTextField txtcedest;
    public javax.swing.JTextField txtcedprof;
    public javax.swing.JLabel txtcert;
    public javax.swing.JLabel txtconfiguracion;
    public javax.swing.JTextField txtcontus;
    public javax.swing.JTextField txtcorest;
    public javax.swing.JTextField txtcorprof;
    public javax.swing.JLabel txtcur;
    public javax.swing.JLabel txtdatos;
    public javax.swing.JTextArea txtdetallescur;
    public javax.swing.JLabel txtdocumentacion;
    public javax.swing.JTextField txtduracioncur;
    public javax.swing.JLabel txtest;
    public javax.swing.JLabel txtestins;
    public javax.swing.JTextField txtnewcar;
    public javax.swing.JLabel txtnins;
    public javax.swing.JTextField txtnomcur;
    public javax.swing.JTextField txtnomest;
    public javax.swing.JTextField txtnomprof;
    public javax.swing.JTextField txtnomus;
    public javax.swing.JLabel txtoperaciones;
    public javax.swing.JTextField txtperiodo;
    public javax.swing.JTextField txtpreciocur;
    public javax.swing.JLabel txtprof;
    public javax.swing.JLabel txtrep;
    public javax.swing.JTextField txttlfest;
    public javax.swing.JTextField txttlfprof;
    public javax.swing.JLabel txtus;
    public javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}

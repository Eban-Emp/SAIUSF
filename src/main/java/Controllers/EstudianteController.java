
package Controllers;

import Models.carreraDao;
import Models.cbxitem;
import Models.estudiante;
import Models.estudianteDao;
import Models.inscripcion;
import Models.inscripcionDao;
import com.formdev.flatlaf.FlatClientProperties;
import com.mycompany.saiusf.util.functionutil;
import com.mycompany.saiusf.views.Principal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class EstudianteController implements ActionListener, MouseListener, KeyListener{
    
    private estudiante est;
    private estudianteDao estDao;
    private inscripcionDao insDao;
    private carreraDao carDao = new carreraDao();
    private Principal views;
    
    
    
    DefaultTableModel modelo = new DefaultTableModel();
    private TableRowSorter<DefaultTableModel> sorter;
    
    

    public EstudianteController(estudiante est, estudianteDao estDao, inscripcionDao insDao, Principal views) {
    this.est = est;
    this.estDao = estDao;
    this.insDao = insDao;
    this.views = views;
    
    
    // 1. Limpieza absoluta
    views.txtBuscarEst.setText(""); 
    
    // 2. Aplicar propiedades de una sola vez
    views.txtBuscarEst.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar estudiante...");
    views.txtBuscarEst.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
    views.txtBuscarEst.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
    
    
    java.net.URL imgUrl = getClass().getResource("/img/filtrar.png");
if (imgUrl != null) {
    views.txtBuscarEst.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new ImageIcon(imgUrl));
} else {
    System.err.println("¡No se encontró la imagen en /img/filtrar.png!");
}

    // 1. Vincular el modelo de la vista a nuestra variable local
    this.modelo = (DefaultTableModel) views.TableEst.getModel();

    // 2. Primero cargamos los datos del DAO a la tabla
    // Es mejor que el sorter nazca con una tabla que ya tiene datos o estructura
    actualizarInterfazEst(); 

    // 3. Inicializar el Sorter y vincularlo a la tabla
    this.sorter = new TableRowSorter<>(modelo);
    this.views.TableEst.setRowSorter(sorter);

    // 4. Listeners (incluyendo el de búsqueda que agregaste)
    this.views.TableEst.addMouseListener(this);
    this.views.txtBuscarEst.addKeyListener(this);
    this.views.btnaggmas.addActionListener(this);
}

    public EstudianteController() {
}

    // --- MÉTODOS PÚBLICOS PARA CONEXIÓN CON VISTA PRINCIPAL ---

    public void onAgregarEstudiante() {
        if (validarCamposEst()) {
            llenarObjetoEstudiante();
            
            if (estDao.Ingresar(est)) {
                actualizarInterfazEst();
                String mensaje = "Datos agregados exitosamente.\n¿Desea agregar un nuevo estudiante?";
                int respuesta = JOptionPane.showConfirmDialog(
                    null, 
                    mensaje, 
                    "Registro Exitoso", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE
                );
                if (respuesta == JOptionPane.YES_OPTION) {
                    limpiarCamposEst();
                    views.jTabbedPane1.setSelectedIndex(0);
                    views.panest.setBackground(new Color(190, 55, 55));
                    views.txtest.setForeground(Color.WHITE);
                    views.panestins.setBackground(new Color(235, 218, 218));
                    views.txtestins.setForeground(Color.BLACK);
                } else {
                    limpiarCamposEst();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar el estudiante");
            }
        }
    }

    public void onEditarEstudiante() {
        if (views.txtIdest.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un estudiante de la tabla");
        } else if (validarCamposEst()) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Desea editar la información del estudiante?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (pregunta == JOptionPane.YES_OPTION) {
                llenarObjetoEstudiante();
                est.setId(Integer.parseInt(views.txtIdest.getText()));
                
                if (estDao.modificar(est)) {
                    actualizarInterfazEst();
                    JOptionPane.showMessageDialog(null, "Estudiante Modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            }
        }
    }

    public void onEliminarEstudiante() {
        if (views.txtIdest.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún estudiante de la tabla");
        } else {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar a este estudiante?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (pregunta == JOptionPane.YES_OPTION) {
                est.setId(Integer.parseInt(views.txtIdest.getText()));
                if (estDao.eliminar(est)) {
                    actualizarInterfazEst();
                    JOptionPane.showMessageDialog(null, "Estudiante Eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                }
            }
        }
    }

    public void onNuevoEstudiante() {
        limpiarCamposEst();
    }

    @Override
public void actionPerformed(ActionEvent e) {
    // --- BOTÓN AGREGAR ESTUDIANTE ---
    if (e.getSource() == views.aggest) {
    if (validarCamposEst()) {
        llenarObjetoEstudiante();
        
        if (estDao.Ingresar(est)) {
            // Actualizamos la interfaz primero para que se vea el nuevo registro al fondo
            actualizarInterfazEst();

            // Creamos el mensaje personalizado
            String mensaje = "Datos agregados exitosamente.\n¿Desea inscribir al estudiante en el curso?";
            
            // Mostramos un cuadro de confirmación (Sí/No)
            int respuesta = JOptionPane.showConfirmDialog(
                null, 
                mensaje, 
                "Registro Exitoso", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE
            );

            // Verificamos la elección del usuario
            if (respuesta == JOptionPane.YES_OPTION) {
                // AQUÍ LLAMAS AL MÉTODO O VISTA PARA INSCRIBIR
                limpiarCamposEst();
                views.jTabbedPane1.setSelectedIndex(4);
                views.panin.setBackground(new Color (190,55,55));
                views.txtnins.setForeground(Color.WHITE);
                views.panest.setBackground(new Color (235,218,218));
                views.txtest.setForeground(Color.BLACK);
                
            } else {
                // El usuario eligió "No", simplemente limpiamos o nos quedamos ahí
                limpiarCamposEst();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar");
        }
    }
} 

    // --- BOTÓN EDITAR ESTUDIANTE ---
    else if (e.getSource() == views.editest) {
        if (views.txtIdest.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un estudiante de la tabla");
        } else if (validarCamposEst()) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Desea editar el Estudiante?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (pregunta == JOptionPane.YES_OPTION) {
                llenarObjetoEstudiante();
                est.setId(Integer.parseInt(views.txtIdest.getText()));
                
                if (estDao.modificar(est)) {
                    actualizarInterfazEst();
                    JOptionPane.showMessageDialog(null, "Estudiante Modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            }
        }
    } 

    // --- BOTÓN ELIMINAR ESTUDIANTE ---
    else if (e.getSource() == views.elimest) {
        if (views.txtIdest.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún Estudiante de la Tabla");
        } else {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar a este estudiante?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (pregunta == JOptionPane.YES_OPTION) {
                est.setId(Integer.parseInt(views.txtIdest.getText()));
                if (estDao.eliminar(est)) {
                    actualizarInterfazEst();
                    JOptionPane.showMessageDialog(null, "Estudiante Eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                }
            }
        }
        // --- BOTÓN REFRESCAR ESTUDIANTE ---
    }
    else if (e.getSource() == views.newest){
        limpiarCamposEst();
        
    }
    // --- BOTÓN CARGA MASIVA DE ALUMNOS ---
    else if (e.getSource() == views.btnaggmas) { 

        // 1. Crear el selector de archivos
        javax.swing.JFileChooser selector = new javax.swing.JFileChooser();
        selector.setDialogTitle("Seleccionar PDF de Asistencia");

        // 2. Filtro para que solo se vean archivos PDF
        javax.swing.filechooser.FileNameExtensionFilter filtro = 
            new javax.swing.filechooser.FileNameExtensionFilter("Documentos PDF", "pdf");
        selector.setFileFilter(filtro);

        // 3. Abrir la ventana y capturar la respuesta
        int resultado = selector.showOpenDialog(views);

        // 4. Si el usuario le dio a "Abrir" o "Aceptar"
        if (resultado == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File archivoSeleccionado = selector.getSelectedFile();

            // Llamamos al método que procesa el PDF pasándole el archivo elegido
            procesarCargaMasiva(archivoSeleccionado);
        }
    }
}

// --- MÉTODOS DE APOYO ---

private boolean validarCamposEst() {
    // 1. Obtener y limpiar textos
    String nombre = views.txtnomest.getText().trim();
    String apellido = views.txtapeest.getText().trim();
    String cedula = views.txtcedest.getText().trim();
    String tlf = views.txttlfest.getText().trim();
    String correo = views.txtcorest.getText().trim();
    
    // 2. Verificar vacíos
    if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty() || tlf.isEmpty() || correo.isEmpty() ||
        views.cbxSexEst.getSelectedIndex() == -1 || views.cbxProEst.getSelectedIndex() == -1 ||
        views.cbxCarEst.getSelectedIndex() == -1 || views.cbxSemEst.getSelectedIndex() == -1) {
        
        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
        return false;
    }

    // 3. Validación: Nombres y Apellidos
    if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$") || !apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
        JOptionPane.showMessageDialog(null, "Los nombres y apellidos solo pueden contener letras");
        return false;
    }

    // --- NUEVAS VALIDACIONES ---

    // 4. Validación: Cédula (Solo números, mínimo 7, máximo 8 dígitos usualmente)
    // El regex ^\d{7,}$ significa: empezar con dígitos, mínimo 7, sin límite superior.
    if (!cedula.matches("^\\d{7,8}$")) {
        JOptionPane.showMessageDialog(null, "La cédula debe ser numérica y tener entre 7 y 8 dígitos");
        return false;
    }

    // 5. Validación: Teléfono (Prefijos VZLA y exactamente 11 dígitos)
    // ^(0414|0424|0412|0416) obliga a empezar con uno de esos.
    // \\d{7}$ obliga a que sigan exactamente 7 números más (total 11).
    if (!tlf.matches("^(0414|0424|0412|0416|0426)\\d{7}$")) {
        JOptionPane.showMessageDialog(null, "El teléfono debe empezar por 0414, 0424, 0412 o 0416 y tener 11 dígitos");
        return false;
    }

    // ---------------------------

    // 6. Validación: Correo Electrónico
    if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,8}$")) {
        JOptionPane.showMessageDialog(null, "El formato del correo electrónico no es válido");
        return false;
    }

    return true;
}

private void llenarObjetoEstudiante() {
    est.setNombres(views.txtnomest.getText().trim());
    est.setApellidos(views.txtapeest.getText().trim());
    est.setCedula(views.txtcedest.getText().trim());
    est.setTelefono(views.txttlfest.getText().trim());
    est.setCorreo(views.txtcorest.getText().trim());
    est.setSexo(views.cbxSexEst.getSelectedItem().toString());
    est.setProcedencia(views.cbxProEst.getSelectedItem().toString());
    est.setSemestre(views.cbxSemEst.getSelectedItem().toString());
    cbxitem itemCarrera = (cbxitem) views.cbxCarEst.getSelectedItem();
    if (itemCarrera != null) {
            est.setCarrera(itemCarrera.getId()); // Pasas el int
        }
}

private void actualizarInterfazEst() {
    RefrescarTablaEst();
    llenarest();
}
    
    public void RefrescarTablaEst(){
        functionutil.limpiarTabla((DefaultTableModel) views.TableEst.getModel(), views.TableEst);
        functionutil.limpiarTabla((DefaultTableModel) views.TableIns.getModel(), views.TableIns);
        functionutil.limpiarTabla((DefaultTableModel) views.TableEstado.getModel(), views.TableEstado);
        functionutil.limpiarTabla((DefaultTableModel) views.TableCert.getModel(), views.TableCert);
        functionutil.limpiarTabla((DefaultTableModel) views.TableReporte.getModel(), views.TableReporte);
    
        
        DefaultTableModel modeloins = (DefaultTableModel) views.TableIns.getModel();
        DefaultTableModel modeloestado = (DefaultTableModel) views.TableEstado.getModel();
        DefaultTableModel modelocert = (DefaultTableModel) views.TableCert.getModel();
        DefaultTableModel modelorep = (DefaultTableModel) views.TableReporte.getModel();
//        Estudiantes
        List<estudiante> lista = estDao.ListaEstudiantes();
        for (estudiante est1 : lista) {
        Object[] fila = {
            est1.getId(), 
            est1.getNombres(),  
            est1.getApellidos(),  
            est1.getCedula(),  
            est1.getTelefono(),  
            est1.getCorreo(),  
            est1.getSexo(),  
            est1.getProcedencia(),  
            est1.getNombreCarrera(),  
            est1.getSemestre(), 
        };
        modelo.addRow(fila);
    }
//        Inscripcion
        List<inscripcion> lista2 = insDao.ListaIns();
        for (inscripcion ins1 : lista2){
            Object[] fila2 ={
            ins1.getId(),
            ins1.getNombre_completo(),
            ins1.getNombre_curso(),
        };
        modeloins.addRow(fila2);
        }
//        Estado
        List<inscripcion> lista3 = insDao.ListaIns();
        for (inscripcion ins2 : lista3){
            Object[] fila3 ={
            ins2.getId(),
            ins2.getNombre_completo(),
            ins2.getCedula(),
            ins2.getNombre_curso(),
            ins2.getDuracion(),
            ins2.getFecha_inicio(),
            ins2.getFacilitador_completo(),
            ins2.getEstado(),
            ins2.getPeriodo(),
        };
        modeloestado.addRow(fila3);
        }
//        Certificado
        List<inscripcion> lista4 = insDao.ListaInsA();
        for (inscripcion ins3 : lista4){
            Object[] fila4 ={
            ins3.getId(),
            ins3.getNombre_completo(),
            ins3.getCedula(),
            ins3.getNombre_curso(),
            ins3.getDuracion(),
            ins3.getFecha_inicio(),
            ins3.getFacilitador_completo(),
            ins3.getEstado(),
            ins3.getPeriodo(),
            ins3.getDetalles(),
        };
        modelocert.addRow(fila4);
        }
//        Reporte
        List<inscripcion> lista5 = insDao.ListaIns();
        for (inscripcion ins4 : lista5){
            Object[] fila5 ={
            ins4.getId(),
            ins4.getNombre_curso(),
            ins4.getDuracion(),
            ins4.getFecha_inicio(),
            ins4.getCedula(),
            ins4.getNombre(),
            ins4.getApellido(),
            ins4.getCarrera_estudiante(),
            ins4.getSemestre(),
            ins4.getCosto_curso(),
            ins4.getSexo_estudiante(),
            ins4.getProcedencia(),
            ins4.getPeriodo(),
        };
        modelorep.addRow(fila5);
        }

    }
    
    
    public void limpiarCamposEst(){
        views.aggest.setEnabled(true);
        views.txtnomest.setText("");
        views.txtapeest.setText("");
        views.txtcedest.setText("");
        views.txttlfest.setText("");
        views.txtcorest.setText("");
        views.cbxSexEst.setSelectedIndex(0);
        views.cbxProEst.setSelectedIndex(0);
        views.cbxCarEst.setSelectedIndex(0);
        views.cbxSemEst.setSelectedIndex(0);
        actualizarInterfazEst();
    }

    @Override
public void mouseClicked(MouseEvent e) {
    if(e.getSource() == views.TableEst) {
        int fila = views.TableEst.rowAtPoint(e.getPoint());
        
        // Campos de texto y etiquetas
        views.txtIdest.setText(views.TableEst.getValueAt(fila, 0).toString());
        views.txtnomest.setText(views.TableEst.getValueAt(fila, 1).toString());
        views.nombreest.setText(views.TableEst.getValueAt(fila, 1).toString());
        views.txtapeest.setText(views.TableEst.getValueAt(fila, 2).toString());
        views.txtcedest.setText(views.TableEst.getValueAt(fila, 3).toString());
        views.Apellidoest.setText(views.TableEst.getValueAt(fila, 2).toString());
        views.cedulaest.setText(views.TableEst.getValueAt(fila, 3).toString());
        views.txttlfest.setText(views.TableEst.getValueAt(fila, 4).toString());
        views.txtcorest.setText(views.TableEst.getValueAt(fila, 5).toString());
        // Aplicamos la búsqueda manual para que coincida con tus objetos cbxitem
        seleccionarItemPorNombre(views.cbxSexEst, views.TableEst.getValueAt(fila, 6).toString());
        seleccionarItemPorNombre(views.cbxProEst, views.TableEst.getValueAt(fila, 7).toString());
        seleccionarItemPorNombre(views.cbxCarEst, views.TableEst.getValueAt(fila, 8).toString());
        seleccionarItemPorNombre(views.cbxSemEst, views.TableEst.getValueAt(fila, 9).toString());
        // Colores de la tarjeta
        views.nombreest.setForeground(Color.WHITE);
        views.Apellidoest.setForeground(Color.WHITE);
        views.cedulaest.setForeground(Color.WHITE);
        views.aggest.setEnabled(false);
    }
}

private void seleccionarItemPorNombre(javax.swing.JComboBox<Object> combo, String nombreBuscar) {
    for (int i = 0; i < combo.getItemCount(); i++) {
        // Usamos .toString() porque tu clase cbxitem devuelve el nombre en ese método
        if (combo.getItemAt(i).toString().equalsIgnoreCase(nombreBuscar)) {
            combo.setSelectedIndex(i);
            return; // Salimos del ciclo al encontrarlo
        }
    }
    // Opcional: Si no lo encuentra, podrías poner el índice en -1 o 0
    combo.setSelectedIndex(-1); 
}

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    private void llenarest() {
    List<estudiante> lista = estDao.ListaEstudiantes();
    
    // 1. Validar que la lista no sea nula
    if (lista != null) {
        // 2. Limpiar el combo antes de llenar para evitar duplicados
        views.cbxnomest.removeAllItems();
        
        // 3. Usar for-each para mayor claridad
        for (estudiante c : lista) {
            views.cbxnomest.addItem(new cbxitem(c.getId(), c.getNombres()));
        }
    } else {
        // Opcional: registrar un log o avisar al usuario
        System.out.println("Error: La lista de periodos retornó nula.");
    }
}
    
    public void filtrarEstudiante() {
    String filtro = views.txtBuscarEst.getText();
    if (filtro.isEmpty()) {
        sorter.setRowFilter(null);
    } else {
        // El (?i) hace que la búsqueda ignore mayúsculas y minúsculas
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filtro));
    }
}

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == views.txtBuscarEst) {
        filtrarEstudiante();
    }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == views.txtBuscarEst) {
        String texto = views.txtBuscarEst.getText();
        
        // Aplicar el filtro que ya teníamos
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
        
        // Lógica para quitar/poner el icono
        if (texto.isEmpty()) {
            // Si está vacío, volvemos a poner el icono
            views.txtBuscarEst.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, 
                new ImageIcon(getClass().getResource("/img/filtrar.png")));
        } else {
            // Si hay texto, quitamos el icono (ponemos null)
            views.txtBuscarEst.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, null);
        }
        views.txtBuscarEst.repaint(); // Refrescar para ver el cambio
    }
    }
    
    public void procesarCargaMasiva(File archivo) {
    // Usamos Loader porque es la versión que te funciona en NetBeans
    try (PDDocument document = Loader.loadPDF(archivo)) { 
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.setSortByPosition(true);
        String texto = stripper.getText(document);

        // 1. EXTRAER DATOS DE CABECERA CON FRENOS (REGEX)
        // Usamos el "freno" (?=...) para que no capture texto de etiquetas vecinas
        String nombreCarreraPDF = extraerDato(texto, "Carrera:\\s*(.*?)(?=\\s*Materia:|$)");
        String semestrePDF = extraerDato(texto, "Semestre:\\s*(.*?)(?=\\s*Sección:|$)");

        // 2. BUSCAR EL ID DE LA CARRERA EN LA BASE DE DATOS
        int idCarrera = carDao.obtenerIdPorNombre(nombreCarreraPDF);

        if (idCarrera == 0) {
            JOptionPane.showMessageDialog(null, 
                "Error: La carrera '" + nombreCarreraPDF + "' no está registrada.\n" +
                "Por favor, agrégala en Gestión de Carreras primero.");
            return;
        }

        // 3. VENTANA DE CONFIRMACIÓN (SÍ / NO)
        int respuesta = JOptionPane.showConfirmDialog(null, 
            "¿Desea cargar los estudiantes del PDF?\n" +
            "Carrera: " + nombreCarreraPDF + "\n" +
            "Semestre: " + semestrePDF, 
            "Confirmar Carga Masiva", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            String[] lineas = texto.split("\\r?\\n");
            int contadorExito = 0;
            int contadorError = 0;

            for (String linea : lineas) {
                // Filtro: Solo líneas que empiecen con: Numero + Espacio + V-Cédula
                if (linea.matches("^\\d+\\s+V-\\d+.*")) {
                    
                    String[] partes = linea.split("\\s+", 3);
                    
                    // VALIDACIÓN DE ÍNDICE: Evita el error "Index 2 out of bounds"
                    if (partes.length < 3) continue;

                    // Limpiar Cédula (quitar V-, puntos y espacios)
                    String cedulaLimpia = partes[1].replace("V-", "").replace(".", "").trim();
                    String nombreCompleto = partes[2].trim();

                    // SEPARAR APELLIDOS Y NOMBRES (Evita "Column nombre cannot be null")
                    String apellidos = "", nombres = "";
                    if (nombreCompleto.contains(",")) {
                        String[] subPartes = nombreCompleto.split(",");
                        apellidos = subPartes[0].trim();
                        nombres = (subPartes.length > 1) ? subPartes[1].trim() : "S/N";
                    } else {
                        apellidos = nombreCompleto;
                        nombres = "S/N"; 
                    }

                    // CREAR OBJETO ESTUDIANTE Y LLENAR TODOS LOS CAMPOS
                    estudiante nuevo = new estudiante();
                    nuevo.setCedula(cedulaLimpia);
                    nuevo.setNombres(nombres);     
                    nuevo.setApellidos(apellidos); 
                    nuevo.setCarrera(idCarrera);   // El ID obtenido del DAO
                    nuevo.setSemestre(semestrePDF);
                    
                    // CAMPOS OBLIGATORIOS POR DEFECTO (Para evitar errores de BD)
                    nuevo.setProcedencia("Interno");
                    nuevo.setTelefono("04000000000"); 
                    nuevo.setCorreo("pendiente@estudiante.com");
                    nuevo.setSexo("M"); 

                    // LLAMADO AL DAO PARA INGRESAR
                    if (estDao.Ingresar(nuevo)) {
                        contadorExito++;
                    } else {
                        contadorError++;
                    }
                }
            }
            
            actualizarInterfazEst(); // Refrescar la tabla en tu sistema
            JOptionPane.showMessageDialog(null, 
                "Proceso finalizado:\n" +
                "- Estudiantes cargados: " + contadorExito + "\n" +
                "- Errores (posibles duplicados): " + contadorError);
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error crítico al procesar PDF: " + e.getMessage());
    }
}
// Método auxiliar para Regex
private String extraerDato(String texto, String regex) {
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(texto);
    return m.find() ? m.group(1).trim() : "No especificado";
}
    
}

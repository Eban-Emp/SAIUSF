
package Controllers;

import Models.cbxitem;
import Models.inscripcion;
import Models.inscripcionDao;
import com.formdev.flatlaf.FlatClientProperties;
import com.mycompany.saiusf.util.functionutil;
import com.mycompany.saiusf.views.Inscripcion;
import com.mycompany.saiusf.views.Principal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class inscripcionController implements ActionListener, MouseListener, KeyListener{
    
    private inscripcion ins;
    private inscripcionDao insDao;
    private Principal views;
    
    DefaultTableModel modelo = new DefaultTableModel();
    private TableRowSorter<DefaultTableModel> sorter;

    public inscripcionController(inscripcion ins, inscripcionDao insDao, Principal views) {
        views.txtBuscarIns.setText(""); 
    views.txtBuscarIns.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar carrera...");
    views.txtBuscarIns.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
    views.txtBuscarIns.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
    
    
    java.net.URL imgUrl = getClass().getResource("/img/filtrar.png");
if (imgUrl != null) {
    views.txtBuscarIns.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new ImageIcon(imgUrl));
} else {
    System.err.println("¡No se encontró la imagen en /img/filtrar.png!");
}

    this.modelo = (DefaultTableModel) views.TableIns.getModel();
    
        this.modelo = (DefaultTableModel) views.TableIns.getModel();
        this.sorter = new TableRowSorter<>(modelo);
        
        this.ins = ins;
        this.insDao = insDao;
        this.views = views;
        this.views.btninsmas.addActionListener(this);
        this.views.TableIns.addMouseListener(this);
        this.views.txtBuscarIns.addKeyListener(this);
        this.views.TableIns.setRowSorter(sorter);
        SwingUtilities.invokeLater(() -> actualizarTablaIns());
    }

    public inscripcionController() {
    }

    public void onAgregarInscripcion() {
        agregarInscripcion();
    }

    public void onNuevoInscripcion() {
        limpiarInscripcion();
    }

    public void onEditarInscripcion() {
        editarInscripcion();
    }

    public void onEliminarInscripcion() {
        eliminarInscripcion();
    }

    @Override
public void actionPerformed(ActionEvent e) {
    // --- BOTÓN AGREGAR INSCRIPCIÓN ---
    if (e.getSource() == views.aggins) {
        agregarInscripcion();
    } 

    // --- BOTÓN EDITAR INSCRIPCIÓN ---
    else if (e.getSource() == views.editins) {
        editarInscripcion();
    } 

    // --- BOTÓN ELIMINAR INSCRIPCIÓN ---
    else if (e.getSource() == views.elimins) {
        eliminarInscripcion();
    }
    // --- BOTÓN REFRESCAR carrera ---
    else if (e.getSource() == views.newins){
        limpiarInscripcion();
    }
    else if (e.getSource() == views.btninsmas){
        Inscripcion insviews = new Inscripcion();
        
        insviews.setResizable(false);
        insviews.setLocationRelativeTo(null);
        insviews.setVisible(true);
    }
}

// --- MÉTODOS DE ACCIONES PRINCIPALES ---

private void agregarInscripcion() {
    if (!validarCamposIns()) {
        return;
    }
    llenarObjetoInscripcion();
    if (insDao.Ingresar(ins)) {
        actualizarTablaIns();
        String mensaje = "Datos agregados exitosamente.\n¿Desea agregar un nuevo estudiante?";
        int respuesta = JOptionPane.showConfirmDialog(
            null, 
            mensaje, 
            "Registro Exitoso", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE
        );
        if (respuesta == JOptionPane.YES_OPTION) {
            limpiarCamposins();
            views.jTabbedPane1.setSelectedIndex(0);
            views.panest.setBackground(new Color(190, 55, 55));
            views.txtest.setForeground(Color.WHITE);
            views.panin.setBackground(new Color(235, 218, 218));
            views.txtnins.setForeground(Color.BLACK);
        } else {
            limpiarCamposins();
        }
    } else {
        JOptionPane.showMessageDialog(null, "Error al registrar");
    }
}

private void editarInscripcion() {
    if (views.txtIdins.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        return;
    }
    if (!validarCamposIns()) {
        return;
    }
    int pregunta = JOptionPane.showConfirmDialog(null, "¿Desea editar la información del registro?", "Confirmar", JOptionPane.YES_NO_OPTION);
    if (pregunta != JOptionPane.YES_OPTION) {
        return;
    }
    llenarObjetoInscripcion();
    ins.setId(Integer.parseInt(views.txtIdins.getText()));
    if (insDao.modificar(ins)) {
        actualizarTablaIns();
        JOptionPane.showMessageDialog(null, "Registro Modificado");
    } else {
        JOptionPane.showMessageDialog(null, "Error al modificar");
    }
}

private void eliminarInscripcion() {
    if (views.txtIdins.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún estudiante de la tabla");
        return;
    }
    int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar a este estudiante del curso?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
    if (pregunta != JOptionPane.YES_OPTION) {
        return;
    }
    ins.setId(Integer.parseInt(views.txtIdins.getText()));
    if (insDao.eliminar(ins)) {
        actualizarTablaIns();
        JOptionPane.showMessageDialog(null, "Estudiante Eliminado del Curso");
    } else {
        JOptionPane.showMessageDialog(null, "Error al eliminar");
    }
}

private void limpiarInscripcion() {
    limpiarCamposins();
    actualizarTablaIns();
}

// --- MÉTODOS DE APOYO ---

private boolean validarCamposIns() {
    // Validamos que no sea nulo y que no sea un string vacío o el índice 0 (si tienes un "Seleccione...")
    Object estudiante = views.cbxnomest.getSelectedItem();
    Object curso = views.cbxcurest.getSelectedItem();

    if (estudiante == null || estudiante.toString().equals("") || estudiante.toString().equals("Seleccione...") ||
        curso == null || curso.toString().equals("") || curso.toString().equals("Seleccione...")) {
        
        JOptionPane.showMessageDialog(null, "Debe seleccionar un Estudiante y un Curso");
        return false;
    }
    return true;
}

private void llenarObjetoInscripcion() {
    cbxitem itemEstudiante = (cbxitem) views.cbxnomest.getSelectedItem();
    cbxitem itemCurso = (cbxitem) views.cbxcurest.getSelectedItem();

        if (itemEstudiante != null) {
            ins.setId_estudiante(itemEstudiante.getId()); // Pasas el int
        }
        
        if (itemCurso != null) {
            ins.setId_curso(itemCurso.getId()); // Pasas el int
        }
}

private void actualizarTablaIns() {
    RefrescarTablaEst();
}
    
public void RefrescarTablaEst() {
    // 1. Limpiar las tablas usando sus modelos actuales directamente
    // Esto asegura que el Sorter no se pierda
    modelo.setRowCount(0); // Este es el modelo de TableIns vinculado al sorter
    
    DefaultTableModel modeloestado = (DefaultTableModel) views.TableEstado.getModel();
    DefaultTableModel modelocert = (DefaultTableModel) views.TableCert.getModel();
    DefaultTableModel modelorep = (DefaultTableModel) views.TableReporte.getModel();

    modeloestado.setRowCount(0);
    modelocert.setRowCount(0);
    modelorep.setRowCount(0);
        
    // 2. Llenar Tabla Inscripción (La que tiene el filtro)
    List<inscripcion> lista = insDao.ListaIns();
    for (inscripcion ins1 : lista){
        Object[] fila ={
            ins1.getId(),
            ins1.getNombre(), // Asegúrate que este sea el nombre del estudiante
            ins1.getNombre_curso(),
        };
        this.modelo.addRow(fila); // Usamos la variable global de la clase
    }
//        Estado
        List<inscripcion> lista2 = insDao.ListaIns();
        for (inscripcion ins2 : lista2){
            Object[] fila2 ={
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
        modeloestado.addRow(fila2);
        }
//        Certificado
        List<inscripcion> lista3 = insDao.ListaInsA();
        for (inscripcion ins3 : lista3){
            Object[] fila3 ={
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
        modelocert.addRow(fila3);
        }
//        Reporte
        List<inscripcion> lista4 = insDao.ListaIns();
        for (inscripcion ins4 : lista4){
            Object[] fila4 ={
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
        modelorep.addRow(fila4);
        }
    }

    
    
    public void limpiarCamposins(){
        views.aggins.setEnabled(true);
        views.cbxnomest.setSelectedIndex(0);
        views.cbxcurest.setSelectedIndex(0);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == views.TableIns) {
            int fila = views.TableIns.rowAtPoint(e.getPoint());
            views.txtIdins.setText(views.TableIns.getValueAt(fila, 0).toString());
            seleccionarItemPorNombre(views.cbxnomest, views.TableIns.getValueAt(fila, 1).toString());
            seleccionarItemPorNombre(views.cbxcurest, views.TableIns.getValueAt(fila, 2).toString());
            views.nombreins.setText(views.TableIns.getValueAt(fila, 1).toString());
            views.cursoins.setText(views.TableIns.getValueAt(fila, 2).toString());
            views.nombreins.setForeground(Color.WHITE);
            views.cursoins.setForeground(Color.WHITE);
            views.aggins.setEnabled(false);
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

     public void filtrarInscrito() {
    String filtro = views.txtBuscarIns.getText();
    if (filtro.isEmpty()) {
        sorter.setRowFilter(null);
    } else {
        // El (?i) hace que la búsqueda ignore mayúsculas y minúsculas
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filtro));
    }
}

    @Override
    public void keyTyped(KeyEvent e) {
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == views.txtBuscarIns) {
        // Ejecutar el filtrado centralizado
        filtrarInscrito();
        
        // Lógica de iconos de FlatLaf
        String texto = views.txtBuscarIns.getText();
        if (texto.isEmpty()) {
            views.txtBuscarIns.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, 
                new ImageIcon(getClass().getResource("/img/filtrar.png")));
        } else {
            views.txtBuscarIns.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, null);
        }
        views.txtBuscarIns.repaint();
    }
    }
    
    
    
}

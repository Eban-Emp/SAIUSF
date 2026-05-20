
package Controllers;

import Models.cbxitem;
import Models.cursos;
import Models.cursosDao;
import Models.inscripcion;
import Models.inscripcionDao;
import Models.profesor;
import Models.profesorDao;
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
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class ProfesorController implements ActionListener, MouseListener, KeyListener{
    
    private profesor prof;
    private profesorDao profDao;
    private cursosDao curDao;
    private inscripcionDao insDao;
    private Principal views;
    
    DefaultTableModel modelo = new DefaultTableModel();
    private TableRowSorter<DefaultTableModel> sorter;

    public ProfesorController(profesor prof, profesorDao profDao, cursosDao curDao, inscripcionDao insDao, Principal views) {
        
        views.txtBuscarProf.setText(""); 
    views.txtBuscarProf.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar facilitador...");
    views.txtBuscarProf.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
    views.txtBuscarProf.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
    
    
    java.net.URL imgUrl = getClass().getResource("/img/filtrar.png");
if (imgUrl != null) {
    views.txtBuscarProf.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new ImageIcon(imgUrl));
} else {
    System.err.println("¡No se encontró la imagen en /img/filtrar.png!");
}

    this.modelo = (DefaultTableModel) views.TableProf.getModel();
    
        this.modelo = (DefaultTableModel) views.TableProf.getModel();
        this.sorter = new TableRowSorter<>(modelo);
        
      
        this.prof = prof;
        this.profDao = profDao;
        this.curDao = curDao;
        this.insDao = insDao;
        this.views = views;

        this.views.TableProf.addMouseListener(this);
        this.views.txtBuscarProf.addKeyListener(this);
        this.views.TableProf.setRowSorter(sorter);
        actualizarTabla();
    }

    public ProfesorController() {
        
    }

    // --- MÉTODOS PÚBLICOS PARA CONEXIÓN CON VISTA PRINCIPAL ---

    public void onAgregarProfesor() {
        if (validarCampos()) {
            llenarObjetoProfesor();
            
            if (profDao.Ingresar(prof)) {
                actualizarTabla();
                String mensaje = "Datos agregados exitosamente.\n¿Desea agregar un nuevo profesor?";
                int respuesta = JOptionPane.showConfirmDialog(
                    null, 
                    mensaje, 
                    "Registro Exitoso", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE
                );
                if (respuesta == JOptionPane.YES_OPTION) {
                    limpiarCamposprof();
                } else {
                    limpiarCamposprof();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar el profesor");
            }
        }
    }

    public void onEditarProfesor() {
        if (views.txtIdprof.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un profesor de la tabla");
        } else if (validarCampos()) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Desea editar la información del profesor?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (pregunta == JOptionPane.YES_OPTION) {
                llenarObjetoProfesor();
                prof.setId(Integer.parseInt(views.txtIdprof.getText()));
                
                if (profDao.modificar(prof)) {
                    actualizarTabla();
                    JOptionPane.showMessageDialog(null, "Profesor Modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            }
        }
    }

    public void onEliminarProfesor() {
        if (views.txtIdprof.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un profesor de la tabla");
        } else {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este profesor?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (pregunta == JOptionPane.YES_OPTION) {
                prof.setId(Integer.parseInt(views.txtIdprof.getText()));
                if (profDao.eliminar(prof)) {
                    actualizarTabla();
                    JOptionPane.showMessageDialog(null, "Profesor Eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                }
            }
        }
    }

    public void onNuevoProfesor() {
        limpiarCamposprof();
    }

    

    public void limpiarCamposProf() {
        limpiarCamposprof();
    }

    @Override
public void actionPerformed(ActionEvent e) {
    // --- BOTÓN AGREGAR ---
    if (e.getSource() == views.aggprof) {
    if (validarCampos()) {
        llenarObjetoProfesor();
        
        if (profDao.Ingresar(prof)) {
            actualizarTabla();
            String mensaje = "Datos agregados exitosamente.\n¿Desea agregar un nuevo estudiante?";
            int respuesta = JOptionPane.showConfirmDialog(
                null, 
                mensaje, 
                "Registro Exitoso", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE
            );
            if (respuesta == JOptionPane.YES_OPTION) {
                limpiarCamposprof();
                views.jTabbedPane1.setSelectedIndex(0);
                views.panest.setBackground(new Color (190,55,55));
                views.txtest.setForeground(Color.WHITE);
                views.panprof.setBackground(new Color (235,218,218));
                views.txtprof.setForeground(Color.BLACK);
                
                
            } else {
                limpiarCamposprof();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar");
        }
    }
} 
    
    // --- BOTÓN EDITAR ---
    else if (e.getSource() == views.editprof) {
        if (views.txtIdprof.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        } else if (validarCampos()) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Desea editar el Profesor?", "Pregunta", JOptionPane.YES_NO_OPTION);
            if (pregunta == JOptionPane.YES_OPTION) {
                llenarObjetoProfesor();
                prof.setId(Integer.parseInt(views.txtIdprof.getText())); // Importante para editar
                
                if (profDao.modificar(prof)) {
                    actualizarTabla();
                    JOptionPane.showMessageDialog(null, "Profesor Modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            }
        }
    } 
    
    // --- BOTÓN ELIMINAR ---
    else if (e.getSource() == views.elimprof) {
        if (views.txtIdprof.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún Profesor de la Tabla");
        } else {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar a este profesor?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (pregunta == JOptionPane.YES_OPTION) {
                prof.setId(Integer.parseInt(views.txtIdprof.getText()));
                if (profDao.eliminar(prof)) {
                    actualizarTabla();
                    JOptionPane.showMessageDialog(null, "Profesor Eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                }
            }
        }
    // --- BOTÓN REFRESCAR Profesor ---
    }else if (e.getSource() == views.newprof){
        limpiarCamposprof();
        
    }
}
public void limpiarCamposprof(){
    views.aggprof.setEnabled(true);
        views.txtnomprof.setText("");
        views.txtapeprof.setText("");
        views.cbxgradoac.setSelectedIndex(0);
        views.txtcorprof.setText("");
        views.txtcedprof.setText("");
        views.txttlfprof.setText("");
        actualizarTabla();
}

// --- MÉTODOS DE APOYO PARA MANTENER EL CÓDIGO LIMPIO ---

private boolean validarCampos() {
    String nombre = views.txtnomprof.getText().trim();
    String apellido = views.txtapeprof.getText().trim();
    String correo = views.txtcorprof.getText().trim();
    String cedula = views.txtcedprof.getText().trim();
    String tlf = views.txttlfprof.getText().trim();

    // 1. Validar Vacíos
    if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty() || tlf.isEmpty() || correo.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
        return false;
    }

    // 2. Validar Nombres (Solo letras y espacios)
    if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$") || !apellido.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
        JOptionPane.showMessageDialog(null, "Los nombres y apellidos no deben contener números");
        return false;
    }

    // 3. Validación: Cédula (Mínimo 7 dígitos, máximo 8)
    if (!cedula.matches("^\\d{7,8}$")) {
        JOptionPane.showMessageDialog(null, "La cédula del profesor debe ser numérica y tener entre 7 y 8 dígitos");
        return false;
    }

    // 4. Validación: Teléfono (Prefijos VZLA y exactamente 11 dígitos)
    // 0414/0424 (Movistar), 0412 (Digitel), 0416 (Movilnet)
    if (!tlf.matches("^(0414|0424|0412|0416|0426)\\d{7}$")) {
        JOptionPane.showMessageDialog(null, "El teléfono debe iniciar con un código válido (0414, 0424, 0412, 0416) y tener 11 dígitos");
        return false;
    }

    // 5. Validar Correo
    if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,8}$")) {
        JOptionPane.showMessageDialog(null, "Formato de correo inválido");
        return false;
    }
    
    return true;
}

private void llenarObjetoProfesor() {
    prof.setNombres(views.txtnomprof.getText().trim());
    prof.setApellidos(views.txtapeprof.getText().trim());
    prof.setGrado_academico(views.cbxgradoac.getSelectedItem().toString());
    prof.setCedula(views.txtcedprof.getText().trim());
    prof.setTelefono(views.txttlfprof.getText().trim());
    prof.setCorreo(views.txtcorprof.getText().trim());
}

private void actualizarTabla() {
    RefrescarTablaFac();
    llenarprof();
}
    
    public void RefrescarTablaFac(){

        functionutil.limpiarTabla((DefaultTableModel) views.TableProf.getModel(), views.TableProf);
        functionutil.limpiarTabla((DefaultTableModel) views.TableCur.getModel(), views.TableCur);
        functionutil.limpiarTabla((DefaultTableModel) views.TableIns.getModel(), views.TableIns);
        functionutil.limpiarTabla((DefaultTableModel) views.TableEstado.getModel(), views.TableEstado);
        functionutil.limpiarTabla((DefaultTableModel) views.TableCert.getModel(), views.TableCert);
    
        // Hacer TableProf no editable
        DefaultTableModel modeloOriginal = (DefaultTableModel) views.TableProf.getModel();
        Object[] columnNamesProf = new Object[modeloOriginal.getColumnCount()];
        for (int i = 0; i < modeloOriginal.getColumnCount(); i++) {
            columnNamesProf[i] = modeloOriginal.getColumnName(i);
        }
        DefaultTableModel modeloprof = new DefaultTableModel(columnNamesProf, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        views.TableProf.setRowSorter(null);
        views.TableProf.setModel(modeloprof);
        sorter = new TableRowSorter<>(modeloprof);
        views.TableProf.setRowSorter(sorter);
        
        DefaultTableModel modelocur = (DefaultTableModel) views.TableCur.getModel();
        DefaultTableModel modeloins = (DefaultTableModel) views.TableIns.getModel();
        DefaultTableModel modeloestado = (DefaultTableModel) views.TableEstado.getModel();
        DefaultTableModel modelocert = (DefaultTableModel) views.TableCert.getModel();
//        Facilitador
        List<profesor> lista = profDao.ListaProfesor();
        for (profesor fac1 : lista) {
        Object[] fila = {
            fac1.getId(), 
            fac1.getNombres(),  
            fac1.getApellidos(),
            fac1.getGrado_academico(),
            fac1.getCedula(),  
            fac1.getTelefono(),  
            fac1.getCorreo(),
        };
        modeloprof.addRow(fila);
    }
//        Cursos
        List<cursos> lista2 = curDao.ListaCursos();
        for (cursos cur1 : lista2) {
        Object[] fila2 = {
            cur1.getId(), 
            cur1.getNombre(),  
            cur1.getDetalles(),
            cur1.getDuracion(),
            cur1.getPrecio(),  
            cur1.getNombre_periodo(),  
            cur1.getNombre_facilitador(),
            cur1.getModalidad(),
        };
        modelocur.addRow(fila2);
    }
//        Inscripcion
        List<inscripcion> lista3 = insDao.ListaIns();
        for (inscripcion ins1 : lista3){
            Object[] fila3 ={
            ins1.getId(),
            ins1.getNombre_completo(),
            ins1.getNombre_curso(),
        };
        modeloins.addRow(fila3);
        }
//        Estado
        List<inscripcion> lista4 = insDao.ListaIns();
        for (inscripcion ins2 : lista4){
            Object[] fila4 ={
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
        modeloestado.addRow(fila4);
        }
//        Certificado
        List<inscripcion> lista5 = insDao.ListaInsA();
        for (inscripcion ins3 : lista5){
            Object[] fila5 ={
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
        modelocert.addRow(fila5);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    if(e.getSource() == views.TableProf) {
            int fila = views.TableProf.rowAtPoint(e.getPoint());
            views.txtIdprof.setText(views.TableProf.getValueAt(fila, 0).toString());
            views.txtnomprof.setText(views.TableProf.getValueAt(fila, 1).toString());
            views.nombreprof.setText(views.TableProf.getValueAt(fila, 1).toString());
            views.txtapeprof.setText(views.TableProf.getValueAt(fila, 2).toString());
            views.apellidoprof.setText(views.TableProf.getValueAt(fila, 2).toString());
            seleccionarItemPorNombre(views.cbxgradoac, views.TableProf.getValueAt(fila, 3).toString());
            views.txtcedprof.setText(views.TableProf.getValueAt(fila, 4).toString());
            views.cedulaprof.setText(views.TableProf.getValueAt(fila, 4).toString());
            views.txttlfprof.setText(views.TableProf.getValueAt(fila, 5).toString());
            views.txtcorprof.setText(views.TableProf.getValueAt(fila, 6).toString());
            views.nombreprof.setForeground(Color.WHITE);
            views.apellidoprof.setForeground(Color.WHITE);
            views.cedulaprof.setForeground(Color.WHITE);
            views.aggprof.setEnabled(false);
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
    
    private void llenarprof() {
    List<profesor> lista = profDao.ListaProfesor();
    
    // 1. Validar que la lista no sea nula
    if (lista != null) {
        // 2. Limpiar el combo antes de llenar para evitar duplicados
        views.cbxCurprofesor.removeAllItems();
        
        // 3. Usar for-each para mayor claridad
        for (profesor c : lista) {
            views.cbxCurprofesor.addItem(new cbxitem(c.getId(), c.getNombres()));
        }
    } else {
        // Opcional: registrar un log o avisar al usuario
        System.out.println("Error: La lista de periodos retornó nula.");
    }
}

    public void filtrarFacilitador() {
    String filtro = views.txtBuscarProf.getText();
    if (filtro.isEmpty()) {
        sorter.setRowFilter(null);
    } else {
        // El (?i) hace que la búsqueda ignore mayúsculas y minúsculas
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filtro));
    }
}

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == views.txtBuscarProf) {
        filtrarFacilitador();
    }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == views.txtBuscarProf) {
        String texto = views.txtBuscarProf.getText();
        
        // Aplicar el filtro que ya teníamos
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
        
        // Lógica para quitar/poner el icono
        if (texto.isEmpty()) {
            // Si está vacío, volvemos a poner el icono
            views.txtBuscarProf.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, 
                new ImageIcon(getClass().getResource("/img/filtrar.png")));
        } else {
            // Si hay texto, quitamos el icono (ponemos null)
            views.txtBuscarProf.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, null);
        }
        views.txtBuscarProf.repaint(); // Refrescar para ver el cambio
    }
    }

}

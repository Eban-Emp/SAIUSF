
package Controllers;

import Models.cbxitem;
import Models.cursos;
import Models.cursosDao;
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
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class CursosController implements ActionListener, MouseListener, KeyListener {
    
    private cursos cur;
    private cursosDao curDao;
    private inscripcionDao insDao;
    private Principal views;
    
    DefaultTableModel modelo = new DefaultTableModel();
    private TableRowSorter<DefaultTableModel> sorter;

    public CursosController(cursos cur, cursosDao curDao, inscripcionDao insDao, Principal views) {
        
    views.txtBuscarCur.setText(""); 
    views.txtBuscarCur.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar curso...");
    views.txtBuscarCur.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
    views.txtBuscarCur.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
    
    
    java.net.URL imgUrl = getClass().getResource("/img/filtrar.png");
if (imgUrl != null) {
    views.txtBuscarCur.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new ImageIcon(imgUrl));
} else {
    System.err.println("¡No se encontró la imagen en /img/filtrar.png!");
}

    this.modelo = (DefaultTableModel) views.TableCur.getModel();
        
        this.cur = cur;
        this.curDao = curDao;
        this.insDao = insDao;
        this.views = views;

        this.views.TableCur.addMouseListener(this);
        this.views.txtBuscarCur.addKeyListener(this);
        this.modelo = (DefaultTableModel) views.TableCur.getModel();
        this.sorter = new TableRowSorter<>(modelo);
        this.views.TableCur.setRowSorter(sorter);
        actualizarInterfazCur();
    }

    public CursosController() {
    }

    // --- MÉTODOS PÚBLICOS PARA CONEXIÓN CON VISTA PRINCIPAL ---

    public void onAgregarCurso() {
        if (validarCamposCur()) {
            llenarObjetoCurso();
            
            if (curDao.Ingresar(cur)) {
                actualizarInterfazCur();
                String mensaje = "Datos agregados exitosamente.\n¿Desea agregar un nuevo curso?";
                int respuesta = JOptionPane.showConfirmDialog(
                    null, 
                    mensaje, 
                    "Registro Exitoso", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE
                );
                if (respuesta == JOptionPane.YES_OPTION) {
                    limpiarCamposCur();
                } else {
                    limpiarCamposCur();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar el curso");
            }
        }
    }

    public void onEditarCurso() {
        if (views.txtIdcur.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un curso de la tabla");
        } else if (validarCamposCur()) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Desea editar la información del curso?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (pregunta == JOptionPane.YES_OPTION) {
                llenarObjetoCurso();
                cur.setId(Integer.parseInt(views.txtIdcur.getText()));
                
                if (curDao.modificar(cur)) {
                    actualizarInterfazCur();
                    JOptionPane.showMessageDialog(null, "Curso Modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            }
        }
    }

    public void onEliminarCurso() {
        if (views.txtIdcur.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un curso de la tabla");
        } else {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este curso?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (pregunta == JOptionPane.YES_OPTION) {
                cur.setId(Integer.parseInt(views.txtIdcur.getText()));
                if (curDao.eliminar(cur)) {
                    actualizarInterfazCur();
                    JOptionPane.showMessageDialog(null, "Curso Eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                }
            }
        }
    }

    public void onNuevoCurso() {
        limpiarCamposCur();
    }

    @Override
public void actionPerformed(ActionEvent e) {
    // --- BOTÓN AGREGAR CURSO ---
    if (e.getSource() == views.aggcur) {
    if (validarCamposCur()) {
        llenarObjetoCurso();
        
        if (curDao.Ingresar(cur)) {
            // Actualizamos la interfaz primero para que se vea el nuevo registro al fondo
            actualizarInterfazCur();

            // Creamos el mensaje personalizado
            String mensaje = "Datos agregados exitosamente.\n¿Desea agregar un estudiante en el curso?";
            
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
                limpiarCamposCur();
                views.jTabbedPane1.setSelectedIndex(4);
                views.panin.setBackground(new Color (190,55,55));
                views.txtnins.setForeground(Color.WHITE);
                views.pancur.setBackground(new Color (235,218,218));
                views.txtcur.setForeground(Color.BLACK);
                
            } else {
                // El usuario eligió "No", simplemente limpiamos o nos quedamos ahí
                limpiarCamposCur();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar");
        }
    }
} 

    // --- BOTÓN EDITAR CURSO ---
    else if (e.getSource() == views.editcur) {
        if (views.txtIdcur.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un curso de la tabla para editar");
        } else if (validarCamposCur()) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Desea editar este curso?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (pregunta == JOptionPane.YES_OPTION) {
                llenarObjetoCurso();
                cur.setId(Integer.parseInt(views.txtIdcur.getText()));
                
                if (curDao.modificar(cur)) {
                    actualizarInterfazCur();
                    JOptionPane.showMessageDialog(null, "Información del Curso Actualizada");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar el curso");
                }
            }
        }
    } 

    // --- BOTÓN ELIMINAR CURSO ---
    else if (e.getSource() == views.elimcur) {
        if (views.txtIdcur.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un curso de la tabla para eliminar");
        } else {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este curso?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (pregunta == JOptionPane.YES_OPTION) {
                cur.setId(Integer.parseInt(views.txtIdcur.getText()));
                if (curDao.eliminar(cur)) {
                    actualizarInterfazCur();
                    JOptionPane.showMessageDialog(null, "Curso Eliminado del Sistema");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                }
            }
        }
    // --- BOTÓN REFRESCAR Curso ---
    }else if (e.getSource() == views.newcur){
        limpiarCamposCur();
        
    }
}

// --- MÉTODOS DE APOYO ---

private boolean validarCamposCur() {
    String nombre = views.txtnomcur.getText().trim();
    String duracion = views.txtduracioncur.getText().trim();
    String precio = views.txtpreciocur.getText().trim();

    // 1. Validar Vacíos y Selección de Combos
    if (nombre.isEmpty() || views.txtdetallescur.getText().trim().isEmpty() || 
        duracion.isEmpty() || precio.isEmpty() || 
        views.cbxCurperiodo.getSelectedIndex() == -1 || 
        views.cbxCurprofesor.getSelectedIndex() == -1) {
        
        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
        return false;
    }

    // 2. Validar que Duración y Precio sean números (pueden ser decimales con .)
    // RegEx: ^[0-9]+(\\.[0-9]{1,2})?$ permite números enteros o con 2 decimales
    if (!duracion.matches("^[0-9]+$")) {
        JOptionPane.showMessageDialog(null, "La duración debe ser un número entero (ej: 40)");
        return false;
    }
    
    if (!precio.matches("^[0-9]+(\\.[0-9]{1,2})?$")) {
        JOptionPane.showMessageDialog(null, "El precio debe ser un número válido (ej: 150.00)");
        return false;
    }

    return true;
}

private void llenarObjetoCurso() {
    try {
        cur.setNombre(views.txtnomcur.getText().trim());
        cur.setDetalles(views.txtdetallescur.getText().trim());
        cur.setModalidad(views.cbxModalidad.getSelectedItem().toString());
        cur.setDuracion(Integer.parseInt(views.txtduracioncur.getText().trim()));
        cur.setPrecio(Double.parseDouble(views.txtpreciocur.getText().trim()));

        // --- SOLUCIÓN AL CAST ---
        // Validamos que lo seleccionado sea realmente un cbxitem
        Object seleccionadoPeriodo = views.cbxCurperiodo.getSelectedItem();
        Object seleccionadoProfesor = views.cbxCurprofesor.getSelectedItem();

        if (seleccionadoPeriodo instanceof cbxitem) {
            cbxitem itemP = (cbxitem) seleccionadoPeriodo;
            cur.setId_periodo(itemP.getId());
        } else {
            // Si es un String, podrías mandar un ID por defecto o lanzar error
            JOptionPane.showMessageDialog(null, "Seleccione un periodo válido");
            return; 
        }

        if (seleccionadoProfesor instanceof cbxitem) {
            cbxitem itemPr = (cbxitem) seleccionadoProfesor;
            cur.setId_facilitador(itemPr.getId());
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un facilitador válido");
            return;
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: Duración debe ser entero y Precio debe ser decimal.");
    } catch (Exception e) {
        // Esto atrapará cualquier otro error y te dirá exactamente qué es
        e.printStackTrace(); 
        JOptionPane.showMessageDialog(null, "Error al capturar datos: " + e.getMessage());
    }
}

private void actualizarInterfazCur() {
    RefrescarTablaCur();
    llenarcur();
}
    
    public void RefrescarTablaCur(){
        functionutil.limpiarTabla((DefaultTableModel) views.TableCur.getModel(), views.TableCur);
        functionutil.limpiarTabla((DefaultTableModel) views.TableIns.getModel(), views.TableIns);
        functionutil.limpiarTabla((DefaultTableModel) views.TableEstado.getModel(), views.TableEstado);
        functionutil.limpiarTabla((DefaultTableModel) views.TableCert.getModel(), views.TableCert);
        functionutil.limpiarTabla((DefaultTableModel) views.TableReporte.getModel(), views.TableReporte);
    
        // Hacer TableCur no editable
        DefaultTableModel modeloOriginal = (DefaultTableModel) views.TableCur.getModel();
        Object[] columnNamesCur = new Object[modeloOriginal.getColumnCount()];
        for (int i = 0; i < modeloOriginal.getColumnCount(); i++) {
            columnNamesCur[i] = modeloOriginal.getColumnName(i);
        }
        DefaultTableModel modelocur = new DefaultTableModel(columnNamesCur, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        views.TableCur.setRowSorter(null);
        views.TableCur.setModel(modelocur);
        sorter = new TableRowSorter<>(modelocur);
        views.TableCur.setRowSorter(sorter);
        
        DefaultTableModel modeloins = (DefaultTableModel) views.TableIns.getModel();
        DefaultTableModel modeloestado = (DefaultTableModel) views.TableEstado.getModel();
        DefaultTableModel modelocert = (DefaultTableModel) views.TableCert.getModel();
        DefaultTableModel modelorep = (DefaultTableModel) views.TableReporte.getModel();
//        Cursos
        List<cursos> lista = curDao.ListaCursos();
        for (cursos cur1 : lista) {
        Object[] fila = {
            cur1.getId(), 
            cur1.getNombre(),  
            cur1.getDetalles(),
            cur1.getDuracion(),
            cur1.getPrecio(),  
            cur1.getNombre_periodo(),  
            cur1.getNombre_facilitador(),
            cur1.getModalidad(),
        };
        modelocur.addRow(fila);
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
    
    public void limpiarCamposCur(){
        views.aggcur.setEnabled(true);
        views.nombrecur.setText("");
        views.txtdetallescur.setText("");
        views.txtduracioncur.setText("");
        views.txtpreciocur.setText("");
        views.cbxCurperiodo.setSelectedIndex(0);
        views.cbxCurprofesor.setSelectedIndex(0);
        actualizarInterfazCur();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == views.TableCur) {
            int fila = views.TableCur.rowAtPoint(e.getPoint());
            // Campos de texto y etiquetas
            views.txtIdcur.setText(views.TableCur.getValueAt(fila, 0).toString());
            views.txtnomcur.setText(views.TableCur.getValueAt(fila, 1).toString());
            views.nombrecur.setText(views.TableCur.getValueAt(fila, 1).toString());
            views.txtdetallescur.setText(views.TableCur.getValueAt(fila, 2).toString());
            views.txtduracioncur.setText(views.TableCur.getValueAt(fila, 3).toString());
            views.txtpreciocur.setText(views.TableCur.getValueAt(fila, 4).toString());
            // Aplicamos la búsqueda manual para que coincida con tus objetos cbxitem
            seleccionarItemPorNombre(views.cbxCurperiodo, views.TableCur.getValueAt(fila, 5).toString());
            seleccionarItemPorNombre(views.cbxCurprofesor, views.TableCur.getValueAt(fila, 6).toString());
            // Colores de la tarjeta
            views.nombrecur.setForeground(Color.WHITE);
            views.aggcur.setEnabled(false);
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
    
    private void llenarcur() {
    List<cursos> lista = curDao.ListaCursos();
    
    // 1. Validar que la lista no sea nula
    if (lista != null) {
        // 2. Limpiar el combo antes de llenar para evitar duplicados
        views.cbxcurest.removeAllItems();
        
        
        // 3. Usar for-each para mayor claridad
        for (cursos c : lista) {
            views.cbxcurest.addItem(new cbxitem(c.getId(), c.getNombre()));
            views.cbxCursocert.addItem(new cbxitem(c.getId(), c.getNombre()));
            views.cbxCursoestado.addItem(new cbxitem(c.getId(), c.getNombre()));
            views.cbxCursorep.addItem(new cbxitem(c.getId(), c.getNombre()));
        }
    } else {
        // Opcional: registrar un log o avisar al usuario
        System.out.println("Error: La lista de cursos retornó nula.");
    }
}
    public void filtrarCursos() {
    String filtro = views.txtBuscarCur.getText();
    if (filtro.isEmpty()) {
        sorter.setRowFilter(null);
    } else {
        // El (?i) hace que la búsqueda ignore mayúsculas y minúsculas
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filtro));
    }
}

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == views.txtBuscarCur) {
        filtrarCursos();
    }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == views.txtBuscarCur) {
        String texto = views.txtBuscarCur.getText();
        
        // Aplicar el filtro que ya teníamos
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
        
        // Lógica para quitar/poner el icono
        if (texto.isEmpty()) {
            // Si está vacío, volvemos a poner el icono
            views.txtBuscarCur.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, 
                new ImageIcon(getClass().getResource("/img/filtrar.png")));
        } else {
            // Si hay texto, quitamos el icono (ponemos null)
            views.txtBuscarCur.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, null);
        }
        views.txtBuscarCur.repaint(); // Refrescar para ver el cambio
    }
    }
    
}

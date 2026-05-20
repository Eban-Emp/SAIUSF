
package Controllers;

import Models.cbxitem;
import Models.inscripcion;
import Models.inscripcionDao;
import Models.periodo;
import Models.periodoDao;
import com.mycompany.saiusf.views.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class estadoController implements ActionListener, MouseListener{
    private periodo per;
    private periodoDao perDao;
    private inscripcionDao insDao;
    private Principal views;
    DefaultTableModel modelo = new DefaultTableModel();

    public estadoController(periodo per, periodoDao perDao, inscripcion ins, inscripcionDao insDao, Principal views) {
        this.per = per;
        this.perDao = perDao;
        this.insDao = insDao;
        this.views = views;
        this.views.aggper.addActionListener(this);
        this.views.Aprobar.addActionListener(this);
        this.views.Reprobar.addActionListener(this);
        this.views.Filtrarestado.addActionListener(this);
        this.views.TableEstado.addMouseListener(this);
        listarper();
        listarest();
        llenarper();
//        llenarCursoEstado();
        this.modelo = (DefaultTableModel) views.TablePer.getModel();
    }

    public estadoController() {
    }
    
    
    
    public void listarper(){
        List<periodo> lista = perDao.ListaPeriodo();
        modelo = (DefaultTableModel) views.TablePer.getModel();
        modelo.setRowCount(0);
        Object[] ob = new Object [4];
        for (int i = 0; i < lista.size(); i++){
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getFecha_inicio();
            ob[3] = lista.get(i).getStatus();
            modelo.addRow(ob);
        }
        views.TablePer.setModel(modelo);
    }
    
    private void llenarper() {
    List<periodo> lista = perDao.ListaPeriodo();
    
    // 1. Validar que la lista no sea nula
    if (lista != null) {
            for (periodo p : lista) {
            views.cbxCurperiodo.addItem(new cbxitem(p.getId(), p.getNombre()));    
            views.cbxPeriodoestado.addItem(new cbxitem(p.getId(), p.getNombre()));
            views.cbxPeriodocert.addItem(new cbxitem(p.getId(), p.getNombre()));
            views.cbxPeriodorep.addItem(new cbxitem(p.getId(), p.getNombre()));           
        }
    } else {
        // Opcional: registrar un log o avisar al usuario
        System.out.println("Error: La lista de periodos retornó nula.");
    }
}

    @Override
public void actionPerformed(ActionEvent e) {
    // --- BOTÓN AGREGAR PERIODO ---
    if (e.getSource() == views.aggper) {
        
        // 1. Obtener el texto del periodo para validar
        String periodoTexto = views.txtperiodo.getText().trim();

        // 2. Ejecutar validaciones (Campos generales y formato de periodo)
        if (validarCamposper()) {
            if (validarFormatoPeriodo(periodoTexto)) {
                
                // --- NUEVA VALIDACIÓN DE DUPLICADOS ---
                if (perDao.existePeriodo(periodoTexto)) {
                    JOptionPane.showMessageDialog(null, 
                        "El periodo " + periodoTexto + " ya se encuentra registrado.", 
                        "Dato Duplicado", 
                        JOptionPane.WARNING_MESSAGE);
                    return; // Detiene la ejecución aquí
                }
                
                llenarObjetoPer();
                
                if (perDao.Ingresar(per)) {
                    // Actualización silenciosa de la tabla
                    actualizarInterfazper();
                    
                    // Mensaje simple sin redirecciones
                    JOptionPane.showMessageDialog(null, "Periodo registrado exitosamente.");
                    
                    // Limpiar para el siguiente registro
                    limpiarCamposper();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar en la base de datos.");
                }
            }
        }
// BOTON APROBAR
} else if (e.getSource() == views.Aprobar) {
    String idText = views.idestado.getText().trim(); // Obtenemos el texto y quitamos espacios
    
    if (idText.equals("") || idText.equals("jLabel17")) { // Validación extra por si acaso
        JOptionPane.showMessageDialog(null, "Seleccione un Estudiante de la tabla primero");
    } else {
        try {
            int id = Integer.parseInt(idText);
            if (insDao.accion("Aprobado", id)) {
                limpiartableper();
                listarest();
                JOptionPane.showMessageDialog(null, "Estado actualizado a: Aprobado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar en la base de datos");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El ID seleccionado no es válido");
        }
    }

// BOTON REPROBAR
} else if (e.getSource() == views.Reprobar) {
    // Obtenemos el texto actual del campo de ID
    String idText = views.idestado.getText().trim();
    
    // Validamos que no esté vacío y que no conserve el nombre por defecto del Label
    if (idText.equals("") || idText.equals("jLabel17")) {
        JOptionPane.showMessageDialog(null, "Seleccione un Estudiante de la tabla para Reprobar");
    } else {
        try {
            // Intentamos la conversión de forma segura
            int id = Integer.parseInt(idText);
            
            // Ejecutamos la acción en el DAO (Data Access Object)
            if (insDao.accion("Reprobado", id)) {
                limpiartableper(); // Limpia la tabla actual
                listarest();       // Recarga la lista de estudiantes
                JOptionPane.showMessageDialog(null, "Estado actualizado a: Reprobado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar cambiar el estado en la base de datos");
            }
        } catch (NumberFormatException ex) {
            // Si el texto en idestado no es un número, este bloque evita que el programa se cierre
            JOptionPane.showMessageDialog(null, "Error: El valor del ID ('" + idText + "') no es un número válido.");
        }
    }
} else if (e.getSource() == views.Filtrarestado) {
    filtrarEstado();
}
}

public boolean validarCamposper() {
    // Verificamos si los campos están vacíos o solo tienen espacios
    if (views.txtperiodo.getText().trim().isEmpty()) { // Agrega aquí otros campos si existen
        
        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
        return false;
    }
    return true;
}
public boolean validarFormatoPeriodo(String periodo) {
    // Regex: Año 2026-2099, guion, y una o dos "I" romanas
    String regex = "^[12]-20(2[6-9]|[3-9]\\d)$";
    
    if (!periodo.matches(regex)) {
        JOptionPane.showMessageDialog(null, 
            "Formato de periodo incorrecto.\ntienes que usar: 1-2026 o 2-2026 para arriba", 
            "Validación", 
            JOptionPane.WARNING_MESSAGE);
        return false;
    }
    return true;
}

private void actualizarInterfazper() {
    limpiartableper();
    listarper();
    llenarper();
}

private void llenarObjetoPer() {
    per.setNombre(views.txtperiodo.getText().trim()); 
}

public void limpiartableper() {
        for (int i = 0; 1<modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

public void limpiarCamposper(){
        views.aggper.setText("");
        actualizarInterfazper();
    }

public void listarest(){
        List<inscripcion> lista = insDao.ListaIns();
        // Hacer TableEstado no editable
        DefaultTableModel modeloOriginal = (DefaultTableModel) views.TableEstado.getModel();
        Object[] columnNamesEstado = new Object[modeloOriginal.getColumnCount()];
        for (int i = 0; i < modeloOriginal.getColumnCount(); i++) {
            columnNamesEstado[i] = modeloOriginal.getColumnName(i);
        }
        modelo = new DefaultTableModel(columnNamesEstado, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.setRowCount(0);
        Object[] ob = new Object [9];
        for (int i = 0; i < lista.size(); i++){
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre_completo();
            ob[2] = lista.get(i).getCedula();
            ob[3] = lista.get(i).getNombre_curso();
            ob[4] = lista.get(i).getDuracion();
            ob[5] = lista.get(i).getFecha_inicio();
            ob[6] = lista.get(i).getFacilitador_completo();
            ob[7] = lista.get(i).getEstado();
            ob[8] = lista.get(i).getPeriodo();
            modelo.addRow(ob);
        }
        views.TableEstado.setModel(modelo);
    }

    private void filtrarEstado() {
    // Obtenemos los objetos seleccionados sin forzar el cast todavía
    Object seleccionadoPeriodo = views.cbxPeriodoestado.getSelectedItem();
    Object seleccionadoCurso = views.cbxCursoestado.getSelectedItem();

    // Verificamos que ambos sean instancias de cbxitem y no Strings
    if (seleccionadoPeriodo instanceof cbxitem && seleccionadoCurso instanceof cbxitem) {
        
        cbxitem itemPeriodo = (cbxitem) seleccionadoPeriodo;
        cbxitem itemCurso = (cbxitem) seleccionadoCurso;

        int idPeriodo = itemPeriodo.getId();
        int idCurso = itemCurso.getId();
        
        List<inscripcion> lista = insDao.ListaInsFiltrada(idPeriodo, idCurso);
        DefaultTableModel modeloOriginal = (DefaultTableModel) views.TableEstado.getModel();
        Object[] columnNamesEstado = new Object[modeloOriginal.getColumnCount()];
        for (int i = 0; i < modeloOriginal.getColumnCount(); i++) {
            columnNamesEstado[i] = modeloOriginal.getColumnName(i);
        }
        modelo = new DefaultTableModel(columnNamesEstado, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.setRowCount(0);
        Object[] ob = new Object [9];
        for (int i = 0; i < lista.size(); i++){
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre_completo();
            ob[2] = lista.get(i).getCedula();
            ob[3] = lista.get(i).getNombre_curso();
            ob[4] = lista.get(i).getDuracion();
            ob[5] = lista.get(i).getFecha_inicio();
            ob[6] = lista.get(i).getFacilitador_completo();
            ob[7] = lista.get(i).getEstado();
            ob[8] = lista.get(i).getPeriodo();
            modelo.addRow(ob);
        }
        views.TableEstado.setModel(modelo);
        // (Aquí va todo tu código de llenado de la tabla que ya tienes)
        
    } else {
        // Si entra aquí es porque seleccionaron un String (ej: "Seleccione...")
        JOptionPane.showMessageDialog(null, "Por favor, seleccione un Periodo y un Curso válidos.");
    }
}

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == views.TableEstado) {
            int fila = views.TableEstado.rowAtPoint(e.getPoint());
            views.idestado.setText(views.TableEstado.getValueAt(fila, 0).toString());
            views.idestado.setEnabled(false);
        }
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

    
    
    
    
}

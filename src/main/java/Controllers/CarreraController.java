
package Controllers;

import Models.carrera;
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
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class CarreraController implements ActionListener, MouseListener, KeyListener{
    
    private carrera car;
    private carreraDao carDao;
    private estudianteDao estDao;
    private inscripcionDao insDao;
    private Principal views;
    
    DefaultTableModel modelo = new DefaultTableModel();
    private TableRowSorter<DefaultTableModel> sorter;

    public CarreraController(carrera car, carreraDao carDao, estudianteDao estDao, inscripcionDao insDao, Principal views) {
    
    if (views.txtBuscarCar != null) {
    views.txtBuscarCar.setText("");
    }    
    views.txtBuscarCar.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar carrera...");
    views.txtBuscarCar.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
    views.txtBuscarCar.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
    
    
    java.net.URL imgUrl = getClass().getResource("/img/filtrar.png");
if (imgUrl != null) {
    views.txtBuscarCar.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new ImageIcon(imgUrl));
} else {
    System.err.println("¡No se encontró la imagen en /img/filtrar.png!");
}
    
        this.modelo = (DefaultTableModel) views.TableCar.getModel();
        this.sorter = new TableRowSorter<>(modelo);
        
        
        this.car = car;
        this.carDao = carDao;
        this.estDao = estDao;
        this.insDao = insDao;
        this.views = views;
        
        this.views.TableCar.addMouseListener(this);
        this.views.txtBuscarCar.addKeyListener(this);
        this.views.TableCar.setRowSorter(sorter);
        actualizarInterfazCar();
    }

    public CarreraController() {
    }

    // --- MÉTODOS PÚBLICOS PARA CONEXIÓN CON VISTA PRINCIPAL ---

    public void onAgregarCarrera() {
        if (validarCamposCar()) {
            car.setCarrera(views.txtnewcar.getText().trim());
            if (carDao.Ingresar(car)) {
                actualizarInterfazCar();
                String mensaje = "Datos agregados exitosamente.\n¿Desea agregar una nueva carrera?";
                int respuesta = JOptionPane.showConfirmDialog(
                    null, 
                    mensaje, 
                    "Registro Exitoso", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE
                );
                if (respuesta == JOptionPane.YES_OPTION) {
                    limpiarCamposCar();
                } else {
                    limpiarCamposCar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar la carrera");
            }
        }
    }

    public void onEditarCarrera() {
        if (views.txtIdcar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione una carrera de la tabla");
        } else if (validarCamposCar()) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Desea editar esta carrera?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (pregunta == JOptionPane.YES_OPTION) {
                car.setCarrera(views.txtnewcar.getText().trim());
                car.setId(Integer.parseInt(views.txtIdcar.getText()));
                
                if (carDao.modificar(car)) {
                    actualizarInterfazCar();
                    JOptionPane.showMessageDialog(null, "Carrera Modificada");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            }
        }
    }

    public void onEliminarCarrera() {
        if (views.txtIdcar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione una carrera de la tabla");
        } else {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar esta carrera?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (pregunta == JOptionPane.YES_OPTION) {
                car.setId(Integer.parseInt(views.txtIdcar.getText()));
                if (carDao.eliminar(car)) {
                    actualizarInterfazCar();
                    JOptionPane.showMessageDialog(null, "Carrera Eliminada");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                }
            }
        }
    }

    public void onNuevoCarrera() {
        limpiarCamposCar();
    }

    @Override
public void actionPerformed(ActionEvent e) {
    // --- BOTÓN AGREGAR CARRERA ---
    if (e.getSource() == views.aggcar) {
    if (validarCamposCar()) {
        car.setCarrera(views.txtnewcar.getText().trim());
        if (carDao.Ingresar(car)) {
            actualizarInterfazCar();
            String mensaje = "Datos agregados exitosamente.\n¿Desea agregar un nuevo estudiante?";
            int respuesta = JOptionPane.showConfirmDialog(
                null, 
                mensaje, 
                "Registro Exitoso", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE
            );
            if (respuesta == JOptionPane.YES_OPTION) {
                views.jTabbedPane1.setSelectedIndex(0);
                views.panest.setBackground(new Color (190,55,55));
                views.txtest.setForeground(Color.WHITE);
                views.pancar.setBackground(new Color (235,218,218));
                views.txtcar.setForeground(Color.BLACK);
                limpiarCamposCar();
            } else {
                limpiarCamposCar();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar la carrera");
        }
    }
} 

    // --- BOTÓN EDITAR CARRERA ---
    else if (e.getSource() == views.editcar) {
        if (views.txtIdcar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione una carrera de la tabla");
        } else if (validarCamposCar()) {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Desea editar esta carrera?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (pregunta == JOptionPane.YES_OPTION) {
                car.setCarrera(views.txtnewcar.getText().trim());
                car.setId(Integer.parseInt(views.txtIdcar.getText()));
                
                if (carDao.modificar(car)) {
                    actualizarInterfazCar();
                    JOptionPane.showMessageDialog(null, "Carrera Modificada");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            }
        }
    } 

    // --- BOTÓN ELIMINAR CARRERA ---
    else if (e.getSource() == views.elimcar) {
        if (views.txtIdcar.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione una carrera de la tabla");
        } else {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar esta carrera?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (pregunta == JOptionPane.YES_OPTION) {
                car.setId(Integer.parseInt(views.txtIdcar.getText()));
                if (carDao.eliminar(car)) {
                    actualizarInterfazCar();
                    JOptionPane.showMessageDialog(null, "Carrera Eliminada");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                }
            }
        }
    // --- BOTÓN REFRESCAR carrera ---
    }else if (e.getSource() == views.newcar){
        limpiarCamposCar();
        
    }
}

private void limpiarCamposCar(){
    
        views.aggcar.setEnabled(true);
        views.txtnewcar.setText("");
        actualizarInterfazCar();
}

// --- MÉTODOS DE APOYO ---

private boolean validarCamposCar() {
    String nombreCarrera = views.txtnewcar.getText().trim();

    // 1. Validar Vacío
    if (nombreCarrera.isEmpty()) {
        JOptionPane.showMessageDialog(null, "El nombre de la carrera es obligatorio");
        return false;
    }

    // 2. Validar que no contenga números (Solo letras, tildes y espacios)
    if (!nombreCarrera.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
        JOptionPane.showMessageDialog(null, "El nombre de la carrera no debe contener números ni caracteres especiales");
        return false;
    }

    return true;
}

private void actualizarInterfazCar() {
    RefrescarTablaCar();
    llenarcarrera();
}
    
    public void RefrescarTablaCar(){
        functionutil.limpiarTabla((DefaultTableModel) views.TableCar.getModel(), views.TableCar);
        functionutil.limpiarTabla((DefaultTableModel) views.TableEst.getModel(), views.TableEst);
        functionutil.limpiarTabla((DefaultTableModel) views.TableReporte.getModel(), views.TableReporte);
    
        // Hacer TableCar no editable
        DefaultTableModel modeloOriginal = (DefaultTableModel) views.TableCar.getModel();
        Object[] columnNamesCar = new Object[modeloOriginal.getColumnCount()];
        for (int i = 0; i < modeloOriginal.getColumnCount(); i++) {
            columnNamesCar[i] = modeloOriginal.getColumnName(i);
        }
        DefaultTableModel modelocar = new DefaultTableModel(columnNamesCar, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        views.TableCar.setRowSorter(null);
        views.TableCar.setModel(modelocar);
        sorter = new TableRowSorter<>(modelocar);
        views.TableCar.setRowSorter(sorter);
        
        DefaultTableModel modeloest = (DefaultTableModel) views.TableEst.getModel();
        DefaultTableModel modelorep = (DefaultTableModel) views.TableReporte.getModel();
//        Carrera
        List<carrera> lista = carDao.Listacarrera();
        for (carrera car1 : lista) {
        Object[] fila = {
            car1.getId(), 
            car1.getCarrera(),
        };
        modelocar.addRow(fila);
    }
//        Estudiantes
        List<estudiante> lista2 = estDao.ListaEstudiantes();
        for (estudiante est1 : lista2) {
        Object[] fila2 = {
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
        
        modeloest.addRow(fila2);
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

   
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == views.TableCar) {
            int fila = views.TableCar.rowAtPoint(e.getPoint());
            views.txtIdcar.setText(views.TableCar.getValueAt(fila, 0).toString());
            views.txtnewcar.setText(views.TableCar.getValueAt(fila, 1).toString());
            views.nomcar.setText(views.TableCar.getValueAt(fila, 1).toString());
            views.nomcar.setForeground(Color.WHITE);
            views.aggcar.setEnabled(false);
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
    
    private void llenarcarrera() {
    List<carrera> lista = carDao.Listacarrera();
    
    // 1. Validar que la lista no sea nula
    if (lista != null) {
        // 2. Limpiar el combo antes de llenar para evitar duplicados
        views.cbxCarEst.removeAllItems();
        
        // 3. Usar for-each para mayor claridad
        for (carrera c : lista) {
            views.cbxCarEst.addItem(new cbxitem(c.getId(), c.getCarrera()));
        }
    } else {
        // Opcional: registrar un log o avisar al usuario
        System.out.println("Error: La lista de periodos retornó nula.");
    }
}

     public void filtrarCarrera() {
    String filtro = views.txtBuscarCar.getText();
    if (filtro.isEmpty()) {
        sorter.setRowFilter(null);
    } else {
        // El (?i) hace que la búsqueda ignore mayúsculas y minúsculas
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filtro));
    }
}

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == views.txtBuscarCar) {
        filtrarCarrera();
    }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == views.txtBuscarCar) {
        String texto = views.txtBuscarCar.getText();
        
        // Aplicar el filtro que ya teníamos
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
        
        // Lógica para quitar/poner el icono
        if (texto.isEmpty()) {
            // Si está vacío, volvemos a poner el icono
            views.txtBuscarCar.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, 
                new ImageIcon(getClass().getResource("/img/filtrar.png")));
        } else {
            // Si hay texto, quitamos el icono (ponemos null)
            views.txtBuscarCar.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, null);
        }
        views.txtBuscarCar.repaint(); // Refrescar para ver el cambio
    }
    }
    
    
}

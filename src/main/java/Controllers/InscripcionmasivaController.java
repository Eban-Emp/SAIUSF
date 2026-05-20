
package Controllers;

import Models.carrera;
import Models.carreraDao;
import Models.cbxitem;
import Models.cursos;
import Models.cursosDao;
import Models.estudiante;
import Models.estudianteDao;
import Models.inscripcion;
import Models.inscripcionDao;
import com.mycompany.saiusf.util.functionutil;
import com.mycompany.saiusf.views.Inscripcion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class InscripcionmasivaController implements ActionListener, MouseListener, KeyListener{
    
    private estudiante est;
    private estudianteDao estDao;
    private inscripcion ins;
    private inscripcionDao insDao;
    private cursosDao curDao;
    private carreraDao carDao;
    private Inscripcion viewsins;
    
    
    
    DefaultTableModel modelo = new DefaultTableModel();

    public InscripcionmasivaController(estudiante est, estudianteDao estDao, inscripcion ins, inscripcionDao insDao, cursosDao curDao, carreraDao carDao, Inscripcion viewsins) {
    this.est = est;
    this.estDao = estDao;
    this.ins = ins;
    this.insDao = insDao;
    this.curDao = curDao;
    this.carDao = carDao;
    this.viewsins = viewsins;

    // --- CONFIGURACIÓN DEL MODELO PARA EL CHECKBOX ---
    this.modelo = new DefaultTableModel() {
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            // Si es la última columna (índice 10, ya que hay 11 columnas en total)
            if (columnIndex == 10) { 
                return Boolean.class; 
            }
            return super.getColumnClass(columnIndex);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            // Solo permitimos editar la columna del checkbox
            return column == 10;
        }
    };

    // Asignar el nuevo modelo a la tabla de la vista
    this.viewsins.Tableinsmas.setModel(this.modelo);
    
    // Configurar encabezados (Asegúrate de que coincidan con tu vista)
    String[] titulos = {"Id", "Nombres", "Apellidos", "Cédula", "Teléfono", "Correo", "Sexo", "Procedencia", "Carrera", "Semestre", "Seleccionar"};
    this.modelo.setColumnIdentifiers(titulos);

    actualizarInterfazEst(); 
    this.viewsins.Tableinsmas.addMouseListener(this);
    this.viewsins.btninsmas.addActionListener(this);
    this.viewsins.btnseleccionartodo.addActionListener(this);
    
    // Agregar eventos a los combos para filtrar al cambiar la selección
    this.viewsins.cbxcarrerains.addActionListener(e -> filtrarEstudiantesMasivo());
    this.viewsins.cbxsemestreins.addActionListener(e -> filtrarEstudiantesMasivo());

}

    public InscripcionmasivaController() {
}

    // --- MÉTODOS PÚBLICOS PARA CONEXIÓN CON VISTA PRINCIPAL --- 
    
    private void ejecutarInscripcionMasiva() {
    // 1. Validación inicial: ¿Hay un curso seleccionado?
    cbxitem itemCurso = (cbxitem) viewsins.cbxcursoins.getSelectedItem();
    if (itemCurso == null) {
        JOptionPane.showMessageDialog(null, "Debe seleccionar un curso antes de continuar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 2. Recolectar estudiantes seleccionados en la tabla
    List<inscripcion> listaInscribir = new ArrayList<>();
    int filas = viewsins.Tableinsmas.getRowCount();

    for (int i = 0; i < filas; i++) {
        // Columna 10 es nuestro Checkbox (Boolean)
        Boolean seleccionado = (Boolean) viewsins.Tableinsmas.getValueAt(i, 10);
        
        if (seleccionado != null && seleccionado) {
            inscripcion nueva = new inscripcion();
            // Columna 0 es el ID del estudiante
            int idEst = Integer.parseInt(viewsins.Tableinsmas.getValueAt(i, 0).toString());
            
            nueva.setId_estudiante(idEst);
            nueva.setId_curso(itemCurso.getId());
            
            listaInscribir.add(nueva);
        }
    }

    // 3. Validación: ¿Seleccionó al menos a uno?
    if (listaInscribir.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No ha marcado ningún estudiante en la tabla.", "Atención", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    // 4. Confirmación del usuario
    int confirmar = JOptionPane.showConfirmDialog(null, 
        "¿Está seguro de inscribir a " + listaInscribir.size() + " estudiantes en el curso: " + itemCurso.getNombre() + "?", 
        "Confirmar Inscripción Masiva", 
        JOptionPane.YES_NO_OPTION);

    if (confirmar != JOptionPane.YES_OPTION) {
        return;
    }

    // 5. Llamada al DAO y manejo de respuesta (int)
    int resultado = insDao.registrarInscripcionMasiva(listaInscribir);

    if (resultado > 0) {
        // Éxito: Al menos uno se inscribió
        int omitidos = listaInscribir.size() - resultado;
        String mensaje = "¡Inscripción exitosa!\nEstudiantes nuevos: " + resultado;
        
        if (omitidos > 0) {
            mensaje += "\nOmitidos (ya estaban inscritos): " + omitidos;
        }
        
        JOptionPane.showMessageDialog(null, mensaje, "Resultado del Proceso", JOptionPane.INFORMATION_MESSAGE);
        RefrescarTablaEstmas(); // Recarga la tabla para limpiar los checks
        
    } else if (resultado == 0) {
        // Todos estaban repetidos
        JOptionPane.showMessageDialog(null, "Todos los estudiantes seleccionados ya se encuentran registrados en este curso.", "Registros Duplicados", JOptionPane.WARNING_MESSAGE);
    } else {
        // Error técnico (el DAO retornó -1)
        JOptionPane.showMessageDialog(null, "Hubo un error de conexión con la base de datos MariaDB.", "Error Crítico", JOptionPane.ERROR_MESSAGE);
    }
}

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == viewsins.btninsmas) {
        ejecutarInscripcionMasiva();
        actualizarInterfazEst();
    } 
    //BOTON SELECCIONAR TODO
    else if (e.getSource() == viewsins.btnseleccionartodo) {
        seleccionarTodoTabla();
    } 
}

private void llenarcur() {
    List<cursos> lista = curDao.ListaCursos();
    
    // 1. Validar que la lista no sea nula
    if (lista != null) {
        // 2. Limpiar el combo antes de llenar para evitar duplicados
        viewsins.cbxcursoins.removeAllItems();
        
        // 3. Usar for-each para mayor claridad
        for (cursos c : lista) {
            viewsins.cbxcursoins.addItem(new cbxitem(c.getId(), c.getNombre()));
        }
    } else {
        // Opcional: registrar un log o avisar al usuario
        System.out.println("Error: La lista de periodos retornó nula.");
    }
}

private void llenarcar() {
    List<carrera> lista = carDao.Listacarrera();
    
    // 1. Validar que la lista no sea nula
    if (lista != null) {
        // 2. Limpiar el combo antes de llenar para evitar duplicados
        viewsins.cbxcarrerains.removeAllItems();
        
        // 3. Usar for-each para mayor claridad
        for (carrera ca : lista) {
            viewsins.cbxcarrerains.addItem(new cbxitem(ca.getId(), ca.getCarrera()));
        }
    } else {
        // Opcional: registrar un log o avisar al usuario
        System.out.println("Error: La lista de periodos retornó nula.");
    }
}

private void actualizarInterfazEst() {
    RefrescarTablaEstmas();
    llenarcur();
    llenarcar();
    
}

public void procesarSeleccionados() {
    for (int i = 0; i < viewsins.Tableinsmas.getRowCount(); i++) {
        // Obtenemos el valor de la columna 10
        Boolean isSelected = (Boolean) viewsins.Tableinsmas.getValueAt(i, 10);
        
        if (isSelected != null && isSelected) {
            int idEstudiante = (int) viewsins.Tableinsmas.getValueAt(i, 0);
            // Aquí ejecutas tu lógica de inscripción con insDao
            System.out.println("Inscribiendo estudiante ID: " + idEstudiante);
        }
    }
}
    
    public void RefrescarTablaEstmas() {
    functionutil.limpiarTabla((DefaultTableModel) viewsins.Tableinsmas.getModel(), viewsins.Tableinsmas);
    
    DefaultTableModel modeloest = (DefaultTableModel) viewsins.Tableinsmas.getModel();
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
            false // <--- VALOR PARA LA ÚLTIMA COLUMNA (Checkbox desmarcado por defecto)
        };
        modeloest.addRow(fila);
    }
}
    
    private void filtrarEstudiantesMasivo() {
    // 1. Obtener datos de los ComboBox
    cbxitem itemCarrera = (cbxitem) viewsins.cbxcarrerains.getSelectedItem();
    String semestre = (viewsins.cbxsemestreins.getSelectedItem() != null) 
                       ? viewsins.cbxsemestreins.getSelectedItem().toString() 
                       : "";

    if (itemCarrera != null && !semestre.isEmpty()) {
        int idCarrera = itemCarrera.getId();
        
        // 2. Limpiar tabla antes de llenar
        functionutil.limpiarTabla((DefaultTableModel) viewsins.Tableinsmas.getModel(), viewsins.Tableinsmas);
        
        // 3. Obtener lista filtrada desde el DAO
        // Necesitarás crear este método en estudianteDao que reciba (int, String)
        List<estudiante> lista = estDao.ListaEstudiantesFiltrada(idCarrera, semestre);
        
        DefaultTableModel modeloFiltrado = (DefaultTableModel) viewsins.Tableinsmas.getModel();
        
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
                false // El checkbox desmarcado por defecto
            };
            modeloFiltrado.addRow(fila);
        }
    }
}
    
    private void seleccionarTodoTabla() {
    int totalFilas = viewsins.Tableinsmas.getRowCount();
    
    // Verificamos si ya hay filas para evitar errores
    if (totalFilas <= 0) return;

    // Recorremos el modelo de la tabla
    for (int i = 0; i < totalFilas; i++) {
        // La columna 10 es donde definiste el Boolean.class
        viewsins.Tableinsmas.setValueAt(true, i, 10);
    }
}

    @Override
    public void mouseClicked(MouseEvent e) {
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    } 
}

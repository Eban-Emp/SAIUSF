
package Controllers;

import Models.User;
import Models.UserDao;
import com.formdev.flatlaf.FlatClientProperties;
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
import javax.swing.JPasswordField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class Usercontroller implements ActionListener, MouseListener, KeyListener{
    
    private User us;
    private UserDao usDao;
    private Principal views;
    
    DefaultTableModel modelo = new DefaultTableModel();
    private TableRowSorter<DefaultTableModel> sorter;

    public Usercontroller(User us, UserDao usDao, Principal views) {
        views.txtBuscarUs.setText(""); 
        views.txtBuscarUs.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar carrera...");
        views.txtBuscarUs.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        views.txtBuscarUs.putClientProperty(FlatClientProperties.STYLE, "arc: 20");
    
    
        java.net.URL imgUrl = getClass().getResource("/img/filtrar.png");
            if (imgUrl != null) {
                views.txtBuscarUs.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new ImageIcon(imgUrl));
                } else {
                    System.err.println("¡No se encontró la imagen en /img/filtrar.png!");
            }

        this.modelo = (DefaultTableModel) views.Tableus.getModel();
    
        this.modelo = (DefaultTableModel) views.Tableus.getModel();
        this.sorter = new TableRowSorter<>(modelo);
        
        this.us = us;
        this.usDao = usDao;
        this.views = views;
        this.views.Tableus.addMouseListener(this);
        this.views.txtBuscarUs.addKeyListener(this);
        this.views.Cambiarcontraseña.addActionListener(this);
        this.views.Tableus.setRowSorter(sorter);
        limpiartableus();
        listarus();
    }

    public Usercontroller() {
    }

    // --- MÉTODOS PÚBLICOS PARA CONEXIÓN CON VISTA PRINCIPAL ---

    public void onAgregarUsuario() {
        if (validarCamposUsuario(true)) { // true porque es nuevo y requiere clave
            llenarObjetoUsuario();
            if (usDao.Ingresar(us)) {
                JOptionPane.showMessageDialog(null, "Usuario Registrado Exitosamente");
                actualizarTablaUsuarios();
                limpiarCamposUsuario();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar usuario");
            }
        }
    }

    public void onEditarUsuario() {
        if (views.txtIdus.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario de la tabla");
        } else if (validarCamposUsuario(false)) { // false porque no requiere clave para editar
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Desea editar la información del usuario?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (pregunta == JOptionPane.YES_OPTION) {
                llenarObjetoUsuario();
                us.setId(Integer.parseInt(views.txtIdus.getText()));
                
                if (usDao.modificar(us)) {
                    actualizarTablaUsuarios();
                    JOptionPane.showMessageDialog(null, "Usuario Modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            }
        }
    }

    public void onEliminarUsuario() {
        if (views.txtIdus.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario de la tabla");
        } else {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este usuario?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (pregunta == JOptionPane.YES_OPTION) {
                us.setId(Integer.parseInt(views.txtIdus.getText()));
                if (usDao.eliminar(us)) {
                    actualizarTablaUsuarios();
                    JOptionPane.showMessageDialog(null, "Usuario Eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                }
            }
        }
    }

    public void onNuevoUsuario() {
        limpiarCamposUsuario();
    }

    public void limpiarCamposUsuario() {
        views.txtnomus.setText("");
        views.txtusuario.setText("");
        views.txtcontus.setText("");
        views.txtcontus.setEnabled(true);
        views.aggus.setEnabled(true);
        actualizarTablaUsuarios();
    }

    @Override
public void actionPerformed(ActionEvent e) {
    // --- BOTÓN AGREGAR USUARIO ---
    if (e.getSource() == views.aggus) {
        if (validarCamposUsuario(true)) { // true porque es nuevo y requiere clave
            llenarObjetoUsuario();
            if (usDao.Ingresar(us)) {
                JOptionPane.showMessageDialog(null, "Usuario Registrado Exitosamente");
                actualizarTablaUsuarios();
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar usuario");
            }
        }
    } 

    // --- BOTÓN EDITAR USUARIO ---
    else if (e.getSource() == views.editus) {
        if (views.txtIdus.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario de la tabla");
        } else if (validarCamposUsuario(false)) { // false porque al editar podrías no cambiar la clave
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Desea editar este usuario?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (pregunta == JOptionPane.YES_OPTION) {
                llenarObjetoUsuario();
                us.setId(Integer.parseInt(views.txtIdus.getText()));
                
                if (usDao.modificar(us)) {
                    actualizarTablaUsuarios();
                    JOptionPane.showMessageDialog(null, "Usuario Modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            }
        }
            
    
        // --- BOTÓN ELIMINAR USUARIO ---
    }else if (e.getSource() == views.elimus) {
        if (views.txtIdus.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario de la tabla");
        } else {
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar este usuario?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (pregunta == JOptionPane.YES_OPTION) {
                us.setId(Integer.parseInt(views.txtIdus.getText()));
                if (usDao.eliminar(us)) {
                    actualizarTablaUsuarios();
                    JOptionPane.showMessageDialog(null, "Usuario Eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar");
                }
            }
        }
    // --- BOTÓN REFRESCAR usuarios ---
    }else if (e.getSource() == views.newus){
        views.aggus.setEnabled(true);
        views.txtnomus.setText("");
        views.txtusuario.setText("");
        views.txtcontus.setText("");
        views.txtcontus.setEnabled(true);
        actualizarTablaUsuarios();
//        --- BOTÓN CAMBIAR CONTRASEÑA USUARIO ---
    }else if (e.getSource() == views.Cambiarcontraseña) {
    // Creamos los componentes visuales
    JPasswordField txtAnterior = new JPasswordField();
    JPasswordField txtNueva = new JPasswordField();
    
    // Organizamos el panel
    Object[] mensaje = {
        "Ingrese Contraseña Anterior:", txtAnterior,
        "\nIngrese Nueva Contraseña:", txtNueva
    };

    // Mostramos el cuadro con botón "Aceptar" y "Cancelar"
    int operacion = JOptionPane.showConfirmDialog(
        null, 
        mensaje, 
        "Panel de Cambio de Seguridad", 
        JOptionPane.OK_CANCEL_OPTION, 
        JOptionPane.QUESTION_MESSAGE
    );

    // Si el usuario presiona el botón "Aceptar" (Confirmar)
    if (operacion == JOptionPane.OK_OPTION) {
        
        String passOld = String.valueOf(txtAnterior.getPassword());
        String passNew = String.valueOf(txtNueva.getPassword());
        int idUser = Integer.parseInt(views.idUsuario.getText());

        // 1. Validar campos vacíos
        if (passOld.isEmpty() || passNew.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No puede dejar campos vacíos");
            return;
        }

        // 2. Validar contraseña antigua en la BD
        if (usDao.validarPasswordAntigua(idUser, passOld)) {
            
            // 3. Si es correcta, preparamos el objeto User para actualizar
            us.setId(idUser);
            us.setClave(passNew);

            if (usDao.modificarpassword(us)) {
                JOptionPane.showMessageDialog(null, "¡Contraseña actualizada con éxito!");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "La contraseña anterior es incorrecta", "Error de validación", JOptionPane.ERROR_MESSAGE);
        }
    }
}  
}

// --- MÉTODOS DE APOYO ---

private boolean validarCamposUsuario(boolean esNuevo) {
    String nombre = views.txtnomus.getText().trim();
    String username = views.txtusuario.getText().trim();
    String clave = views.txtcontus.getText().trim();

    // 1. Validar Vacíos (La clave solo es obligatoria si es nuevo)
    if (nombre.isEmpty() || username.isEmpty() || (esNuevo && clave.isEmpty())) {
        JOptionPane.showMessageDialog(null, "Los campos de Nombre y Usuario son obligatorios");
        return false;
    }

    // 2. Validar Nombre (Solo letras y espacios)
    if (!nombre.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
        JOptionPane.showMessageDialog(null, "El nombre no debe contener números");
        return false;
    }

    // 3. Validar Usuario/Login (Sin espacios, puede tener letras y números)
    if (username.contains(" ")) {
        JOptionPane.showMessageDialog(null, "El nombre de usuario no puede contener espacios");
        return false;
    }

    return true;
}

private void llenarObjetoUsuario() {
    us.setNombre(views.txtnomus.getText().trim());
    us.setUsuario(views.txtusuario.getText().trim());
    // Solo enviamos la clave si el campo no está vacío (útil en ediciones)
    if (!views.txtcontus.getText().trim().isEmpty()) {
        us.setClave(views.txtcontus.getText().trim());
    }
}

private void actualizarTablaUsuarios() {
    limpiartableus();
    listarus();
}
    
    public void listarus(){
        List<User> lista = usDao.ListaUser();
        // Hacer Tableus no editable
        DefaultTableModel modeloOriginal = (DefaultTableModel) views.Tableus.getModel();
        Object[] columnNamesUs = new Object[modeloOriginal.getColumnCount()];
        for (int i = 0; i < modeloOriginal.getColumnCount(); i++) {
            columnNamesUs[i] = modeloOriginal.getColumnName(i);
        }
        modelo = new DefaultTableModel(columnNamesUs, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.setRowCount(0);
        Object[] ob = new Object [5];
        for (int i = 0; i < lista.size(); i++){
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getUsuario();
            ob[3] = lista.get(i).getRol();
            ob[4] = lista.get(i).getEstado();            
            modelo.addRow(ob);
        }
        views.Tableus.setRowSorter(null);
        views.Tableus.setModel(modelo);
        sorter = new TableRowSorter<>(modelo);
        views.Tableus.setRowSorter(sorter);
    }

    public void limpiartableus() {
        for (int i = 0; 1<modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == views.Tableus) {
            int fila = views.Tableus.rowAtPoint(e.getPoint());
            views.txtIdus.setText(views.Tableus.getValueAt(fila, 0).toString());
            views.txtnomus.setText(views.Tableus.getValueAt(fila, 1).toString());
            views.nombreUsuario.setText(views.Tableus.getValueAt(fila, 1).toString());
            views.txtusuario.setText(views.Tableus.getValueAt(fila, 2).toString());
            views.Usuario.setText(views.Tableus.getValueAt(fila, 2).toString());
            views.nombreUsuario.setForeground(Color.WHITE);
            views.Usuario.setForeground(Color.WHITE);
            views.aggus.setEnabled(false);
            views.txtcontus.setEnabled(false);
            
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

     public void filtrarUsuario() {
    String filtro = views.txtBuscarUs.getText();
    if (filtro.isEmpty()) {
        sorter.setRowFilter(null);
    } else {
        // El (?i) hace que la búsqueda ignore mayúsculas y minúsculas
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filtro));
    }
}

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == views.txtBuscarUs) {
        filtrarUsuario();
    }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == views.txtBuscarUs) {
        String texto = views.txtBuscarUs.getText();
        
        // Aplicar el filtro que ya teníamos
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
        
        // Lógica para quitar/poner el icono
        if (texto.isEmpty()) {
            // Si está vacío, volvemos a poner el icono
            views.txtBuscarUs.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, 
                new ImageIcon(getClass().getResource("/img/filtrar.png")));
        } else {
            // Si hay texto, quitamos el icono (ponemos null)
            views.txtBuscarUs.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, null);
        }
        views.txtBuscarUs.repaint(); // Refrescar para ver el cambio
    }
    }
    
    
    
    
}

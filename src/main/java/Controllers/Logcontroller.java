
package Controllers;

import Models.User;
import Models.UserDao;
import com.mycompany.saiusf.views.Login;
import com.mycompany.saiusf.views.Principal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class Logcontroller implements ActionListener, MouseListener{
    private Login log;
    private User us;
    private UserDao usDao;

    public Logcontroller(User us, UserDao usDao, Login log) {
        this.log = log;
        this.us = us;
        this.usDao = usDao;
        this.log.btnlog.addActionListener(this);
        this.log.btnlog.addMouseListener(this);
        this.log.btncancelar.addActionListener(this);
        this.log.btncancelar.addMouseListener(this);
        this.log.setLocationRelativeTo(null);
    }
    
    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == log.btnlog) {
        if (log.txtuser.getText().trim().isEmpty()
                || String.valueOf(log.txtpass.getPassword()).trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los campos están vacíos");
            return;
        }

        String usuario = log.txtuser.getText().trim();
        String clave = String.valueOf(log.txtpass.getPassword()).trim();
        us = usDao.login(usuario, clave);

        if (us != null && us.getUsuario() != null) {
            Principal views = new Principal();
            
            // 1. Pasamos los datos a la vista
            views.btncerrars.setText("Bienvenido: " + us.getNombre().toUpperCase());
            views.idUsuario.setText(String.valueOf(us.getId()));
            views.rolUsuario.setText(us.getRol());

            // 2. Ejecutamos la validación de permisos ANTES de mostrar la ventana
            validarAccesos(views, us.getRol());
            
            views.setResizable(false);
            views.setLocationRelativeTo(null);
            views.setVisible(true);
            this.log.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
        }
    } else if (e.getSource() == log.btncancelar) {
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (pregunta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}

// NUEVO MÉTODO PARA GESTIONAR LOS NIVELES
private void validarAccesos(Principal views, String rol) {
    if (rol == null) return;

    switch (rol.trim()) {
        case "Soporte":
            // Soporte tiene acceso total, no ocultamos nada
            break;

        case "Coordinador":
            // El coordinador ve todo menos el botón/módulo de usuarios
            // Ajusta el nombre de la variable según como se llame en tu clase Principal
            views.txtconfiguracion.setVisible(false);
            views.txtus.setVisible(false); 
            break;

        case "Beca":
            // Beca servicio solo funciones específicas
            views.txtus.setVisible(false);
            views.txtrep.setVisible(false);
            views.txtcert.setVisible(false);
            views.txtprof.setVisible(false);
            views.txtestins.setVisible(false);
            views.txtcar.setVisible(false);
            views.txtcur.setVisible(false);
            views.txtconfiguracion.setVisible(false);
            views.txtdocumentacion.setVisible(false);
            views.btnaggmas.setVisible(false);
            views.txtest.setEnabled(true);
            views.txtnins.setEnabled(true);
            break;

        default:
            // Por seguridad, si el rol no coincide, bloqueamos todo
            JOptionPane.showMessageDialog(null, "Rol no autorizado.");
            System.exit(0);
            break;
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
        if (e.getSource() == log.btnlog){
            log.btnlog.setBackground(new Color (126,126,126));    
            }else if (e.getSource() == log.btncancelar){
            log.btncancelar.setBackground(new Color (139,0,0));
            log.btncancelar.setForeground(new Color (255,255,255));
                }  
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == log.btnlog){
            log.btnlog.setBackground(new Color (85,85,85));    
            }else if (e.getSource() == log.btncancelar){
            log.btncancelar.setBackground(new Color (93,93,93));
            log.btncancelar.setForeground(new Color (0,0,0));
                }  
    }
    
    
    
}

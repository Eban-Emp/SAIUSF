
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UserDao {
    Conexion cn = new Conexion();
    
    
    
    //LOGIN USUARIO//
    public User login(String usuario, String clave) {
    String sql = "SELECT id, name, username, rol, status FROM usuarios WHERE username = ? AND password = ?";
    User us = null; // Iniciamos en null para validar si se encontró el usuario

    // El uso de try-with-resources asegura que Connection, PreparedStatement y ResultSet se cierren solos
    try (Connection con = cn.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, usuario);
        ps.setString(2, clave);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                us = new User();
                us.setId(rs.getInt("id"));
                us.setUsuario(rs.getString("username"));
                us.setNombre(rs.getString("name"));
                us.setRol(rs.getString("rol"));
                us.setEstado(rs.getString("status"));
            }
        }
    } catch (SQLException e) {
        // En producción, es mejor usar un Logger que un JOptionPane
        System.err.println("Error en el login: " + e.getMessage());
    }
    return us;
}
    
    public boolean Ingresar(User us) {
        String sql = "INSERT INTO usuarios (username, name, password, rol) VALUES (?, ?, ?, 'Beca')";
        // Al declarar la conexión aquí adentro, Java la cierra sola al salir del try
        try (Connection con = cn.getConexion(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, us.getUsuario());
            ps.setString(2, us.getNombre());
            ps.setString(3, us.getClave());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public List<User> ListaUser() {
        List<User> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        
        try (Connection con = cn.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                User us = new User();
                us.setId(rs.getInt("id"));
                us.setNombre(rs.getString("name"));
                us.setUsuario(rs.getString("username"));
                us.setRol(rs.getString("rol"));
    
    // Capturamos el valor numérico del estado
                int statusValue = rs.getInt("status");
    
    // Evaluamos: si es 1 -> "Activo", de lo contrario -> "Inactivo"
                if (statusValue == 1) {
                    us.setEstado("Activo");
                } else {
                    us.setEstado("Inactivo");
                }
    
                lista.add(us);
}
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return lista;
    }
    
    
    
    
    // Método para validar la contraseña actual
public boolean validarPasswordAntigua(int id, String passwordAntigua) {
    String sql = "SELECT id FROM usuarios WHERE id = ? AND password = ?";
    try (Connection con = cn.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, id);
        ps.setString(2, passwordAntigua);
        
        try (ResultSet rs = ps.executeQuery()) {
            return rs.next(); // Retorna true si encontró el usuario con esa clave
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al validar clave: " + e.toString());
        return false;
    }
}

// Tu método modificar corregido
public boolean modificarpassword(User us) {
    // Agregamos el '=' y el nombre correcto del campo según tu lógica
    String sql1 = "UPDATE usuarios SET password = ? WHERE id = ?"; 
    try (Connection con = cn.getConexion();
         PreparedStatement ps = con.prepareStatement(sql1)) {
        
        ps.setString(1, us.getClave());
        ps.setInt(2, us.getId());
        ps.execute();
        return true;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.toString());
        return false;
    }
}
    
    public boolean modificar(User us) {
        String sql1 = "UPDATE usuarios SET username = ?, name = ? WHERE id = ?";
        try (Connection con = cn.getConexion();
             PreparedStatement ps = con.prepareStatement(sql1)) {
            
            ps.setString(1, us.getUsuario());
            ps.setString(2, us.getNombre());
            ps.setInt(3, us.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
    public boolean eliminar(User us) {
        String sql1 = "DELETE FROM usuarios WHERE id = ?";
        try (Connection con = cn.getConexion();
             PreparedStatement ps = con.prepareStatement(sql1)) {
            
            ps.setInt(1, us.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
}

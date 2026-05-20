package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class carreraDao {
    Conexion cn = new Conexion();

    public boolean Ingresar(carrera car) {
        String sql = "INSERT INTO carreras (nombre) VALUES (?)";
        // Al declarar la conexión aquí adentro, Java la cierra sola al salir del try
        try (Connection con = cn.getConexion(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, car.getCarrera());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    public List<carrera> Listacarrera() {
        List<carrera> lista = new ArrayList<>();
        String sql = "SELECT * FROM carreras";
        
        try (Connection con = cn.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                carrera car = new carrera();
                car.setId(rs.getInt("id"));
                car.setCarrera(rs.getString("nombre"));
                car.setStatus(rs.getInt("status"));
                lista.add(car);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return lista;
    }

    public boolean modificar(carrera car) {
        String sql1 = "UPDATE carreras SET nombre = ? WHERE id = ?";
        try (Connection con = cn.getConexion();
             PreparedStatement ps = con.prepareStatement(sql1)) {
            
            ps.setString(1, car.getCarrera());
            ps.setInt(2, car.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
    public boolean eliminar(carrera car) {
        String sql1 = "DELETE FROM carreras WHERE id = ?";
        try (Connection con = cn.getConexion();
             PreparedStatement ps = con.prepareStatement(sql1)) {
            
            ps.setInt(1, car.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
    public int obtenerIdPorNombre(String nombre) {
    // Asegúrate de que en phpMyAdmin la columna se llame 'nombre'
    String sql = "SELECT id FROM carreras WHERE nombre LIKE ?";
    try (Connection con = cn.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        // El trim() es vital para quitar espacios invisibles del PDF
        ps.setString(1, "%" + nombre.trim() + "%");
        
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error en CarreraDao: " + e.getMessage());
    }
    return 0; 
}
}
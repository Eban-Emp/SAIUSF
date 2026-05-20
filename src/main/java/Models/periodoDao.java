
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class periodoDao {
    Conexion cn = new Conexion();
    
    public boolean Ingresar(periodo per) {
        String sql = "INSERT INTO periodos( nombre, fecha_inicio) VALUES (?, CURDATE())";
        // Al declarar Connection y PreparedStatement aquí, se cierran automáticamente
        try (Connection con = cn.getConexion(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, per.getNombre());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar: " + e.toString());
            return false;
        }
    }
    
    public List<periodo> ListaPeriodo() {
    List<periodo> listaper = new ArrayList<>();
    // Usamos CASE para crear una columna virtual con el texto
    String sql = "SELECT id, nombre, fecha_inicio, " +
                 "CASE WHEN status = 1 THEN 'Activo' ELSE 'Inactivo' END AS estado_texto " +
                 "FROM periodos";
    
    try (Connection con = cn.getConexion();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            periodo per = new periodo();
            per.setId(rs.getInt("id"));
            per.setNombre(rs.getString("nombre"));
            per.setFecha_inicio(rs.getString("fecha_inicio"));
            
            // Asignamos el String que viene del CASE de SQL
            // Asegúrate de que en tu clase 'periodo' el setStatus acepte String
            per.setStatus(rs.getString("estado_texto")); 
            
            listaper.add(per);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al listar periodos: " + e.toString());
    }
    return listaper;
}
    
    public boolean existePeriodo(String nombre) {
    String sql = "SELECT COUNT(*) FROM periodos WHERE nombre = ?";
    try (Connection con = cn.getConexion(); 
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, nombre);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                // Si el conteo es mayor a 0, ya existe
                return rs.getInt(1) > 0;
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al verificar existencia: " + e.toString());
    }
    return false;
}
    
    
    
    
}

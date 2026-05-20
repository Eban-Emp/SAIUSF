
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class profesorDao {
    Conexion cn = new Conexion();

    public boolean Ingresar(profesor prof) {
        String sql = "INSERT INTO facilitadores( nombre, apellido, grado_academico, cedula, telefono, correo, uuid) VALUES (?, ?, ?, ?, ?, ?, UUID())";
        // Al declarar Connection y PreparedStatement aquí, se cierran automáticamente
        try (Connection con = cn.getConexion(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, prof.getNombres());
            ps.setString(2, prof.getApellidos());
            ps.setString(3, prof.getGrado_academico());
            ps.setString(4, prof.getCedula());
            ps.setString(5, prof.getTelefono());
            ps.setString(6, prof.getCorreo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar: " + e.toString());
            return false;
        }
    }

    public List<profesor> ListaProfesor() {
        List<profesor> listaprof = new ArrayList<>();
        String sql = "SELECT * FROM facilitadores";
        
        // El ResultSet también se incluye en el try para cierre automático
        try (Connection con = cn.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                profesor prof = new profesor();
                prof.setId(rs.getInt("id"));
                prof.setNombres(rs.getString("nombre"));
                prof.setApellidos(rs.getString("apellido"));
                prof.setGrado_academico(rs.getString("grado_academico"));
                prof.setCedula(rs.getString("cedula"));
                prof.setTelefono(rs.getString("telefono"));
                prof.setCorreo(rs.getString("correo"));
                listaprof.add(prof);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar: " + e.toString());
        }
        return listaprof;
    }

    public boolean modificar(profesor prof) {
        String sql1 = "UPDATE facilitadores SET nombre = ?, apellido = ?, grado_academico = ?, cedula = ?, telefono = ?, correo = ?  WHERE id = ?";
        try (Connection con = cn.getConexion();
             PreparedStatement ps = con.prepareStatement(sql1)) {
            
            ps.setString(1, prof.getNombres());
            ps.setString(2, prof.getApellidos());
            ps.setString(3, prof.getGrado_academico());
            ps.setString(4, prof.getCedula());
            ps.setString(5, prof.getTelefono());
            ps.setString(6, prof.getCorreo());
            ps.setInt(7, prof.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar: " + e.toString());
            return false;
        }
    }
    
    public boolean eliminar(profesor prof) {
        String sql1 = "DELETE FROM facilitadores WHERE id = ?";
        try (Connection con = cn.getConexion();
             PreparedStatement ps = con.prepareStatement(sql1)) {
            
            ps.setInt(1, prof.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
}
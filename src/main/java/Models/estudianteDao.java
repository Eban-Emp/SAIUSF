
package Models;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class estudianteDao {
    Conexion cn = new Conexion();

    public boolean Ingresar(estudiante est) {
        String sql = "INSERT INTO estudiantes( cedula, nombre, apellido, telefono, correo, sexo, procedencia, semestre, id_carrera, uuid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, UUID())";
        // Al declarar Connection y PreparedStatement aquí, se cierran automáticamente
        try (Connection con = cn.getConexion(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, est.getCedula());
            ps.setString(2, est.getNombres());
            ps.setString(3, est.getApellidos());
            ps.setString(4, est.getTelefono());
            ps.setString(5, est.getCorreo());
            ps.setString(6, est.getSexo());
            ps.setString(7, est.getProcedencia());
            ps.setString(8, est.getSemestre());
            ps.setInt(9, est.getCarrera());           
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar: " + e.toString());
            return false;
        }
    }

    public List<estudiante> ListaEstudiantes() {
    List<estudiante> listaestudiante = new ArrayList<>();
    
    // Consulta que une estudiantes con carreras para obtener el nombre
    String sql = "SELECT e.*, c.nombre AS nombre_carrera \n" +
                    "FROM estudiantes e \n" +
                    "INNER JOIN carreras c ON e.id_carrera = c.id;";
    
    try (Connection con = cn.getConexion();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            estudiante est = new estudiante();
            est.setId(rs.getInt("id"));
            est.setNombres(rs.getString("nombre"));
            est.setApellidos(rs.getString("apellido"));
            est.setCedula(rs.getString("cedula"));
            est.setTelefono(rs.getString("telefono"));
            est.setCorreo(rs.getString("correo"));
            est.setSexo(rs.getString("sexo"));
            est.setProcedencia(rs.getString("procedencia"));
            est.setNombreCarrera(rs.getString("nombre_carrera")); 
            est.setCarrera(rs.getInt("id_carrera")); 
            est.setSemestre(rs.getString("semestre"));
            listaestudiante.add(est);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al listar: " + e.toString());
    }
    return listaestudiante;
}
    
    public List<estudiante> ListaEstudiantesFiltrada(int idCarrera, String semestre) {
    List<estudiante> listaestudiante = new ArrayList<>();
    
    // Consulta con parámetros para filtrar por carrera y semestre
    String sql = "SELECT e.*, c.nombre AS nombre_carrera \n" +
                 "FROM estudiantes e \n" +
                 "INNER JOIN carreras c ON e.id_carrera = c.id \n" +
                 "WHERE e.id_carrera = ? AND e.semestre = ?;";
    
    try (Connection con = cn.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        // Asignamos los valores de los filtros
        ps.setInt(1, idCarrera);
        ps.setString(2, semestre);
        
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                estudiante est = new estudiante();
                est.setId(rs.getInt("id"));
                est.setNombres(rs.getString("nombre"));
                est.setApellidos(rs.getString("apellido"));
                est.setCedula(rs.getString("cedula"));
                est.setTelefono(rs.getString("telefono"));
                est.setCorreo(rs.getString("correo"));
                est.setSexo(rs.getString("sexo"));
                est.setProcedencia(rs.getString("procedencia"));
                est.setNombreCarrera(rs.getString("nombre_carrera")); 
                est.setCarrera(rs.getInt("id_carrera")); 
                est.setSemestre(rs.getString("semestre"));
                
                listaestudiante.add(est);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al filtrar estudiantes: " + e.toString());
    }
    return listaestudiante;
}

    public boolean modificar(estudiante est) {
        String sql1 = "UPDATE estudiantes SET nombre = ?, apellido = ?, cedula = ?, telefono = ?, correo = ?, sexo = ?, procedencia = ?, id_carrera = ?, semestre = ?  WHERE id = ?";
        try (Connection con = cn.getConexion();
             PreparedStatement ps = con.prepareStatement(sql1)) {
            
            ps.setString(1, est.getNombres());
            ps.setString(2, est.getApellidos());
            ps.setString(3, est.getCedula());
            ps.setString(4, est.getTelefono());
            ps.setString(5, est.getCorreo());
            ps.setString(6, est.getSexo());
            ps.setString(7, est.getProcedencia());
            ps.setInt(8, est.getCarrera());
            ps.setString(9, est.getSemestre());            
            ps.setInt(10, est.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar: " + e.toString());
            return false;
        }
    }
    
    public boolean eliminar(estudiante est) {
        String sql1 = "DELETE FROM estudiantes WHERE id = ?";
        try (Connection con = cn.getConexion();
             PreparedStatement ps = con.prepareStatement(sql1)) {
            
            ps.setInt(1, est.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
    
}

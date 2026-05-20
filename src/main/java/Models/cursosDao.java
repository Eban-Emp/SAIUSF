
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class cursosDao {
    Conexion cn = new Conexion();

    public boolean Ingresar(cursos cur) {
        String sql = "INSERT INTO cursos( nombre, detalles, precio, duracion_horas, id_facilitador, id_periodo, modalidad, fecha_inicial, uuid) VALUES (?, ?, ?, ?, ?, ?, ?, CURDATE(), UUID())";
        // Al declarar Connection y PreparedStatement aquí, se cierran automáticamente
        try (Connection con = cn.getConexion(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, cur.getNombre());
            ps.setString(2, cur.getDetalles());
            ps.setDouble(3, cur.getPrecio());
            ps.setInt(4, cur.getDuracion());
            ps.setInt(5, cur.getId_facilitador());
            ps.setInt(6, cur.getId_periodo());
            ps.setString(7, cur.getModalidad());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar: " + e.toString());
            return false;
        }
    }

    public List<cursos> ListaCursos() {
        List<cursos> listacur = new ArrayList<>();
        String sql = "SELECT c.*, " +
                     "p.nombre AS nombre_periodo, " +
                     "f.nombre AS nombre_facilitador " + // Asegúrate de que aquí termine con espacio o la siguiente empiece con uno
                     "FROM cursos c " + // <--- Agregué un espacio antes de FROM
                     "INNER JOIN facilitadores f ON c.id_facilitador = f.id " +
                     "INNER JOIN periodos p ON c.id_periodo = p.id";
        
        // El ResultSet también se incluye en el try para cierre automático
        try (Connection con = cn.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                cursos cur = new cursos();
                cur.setId(rs.getInt("id"));
                cur.setNombre(rs.getString("nombre"));
                cur.setDetalles(rs.getString("detalles"));
                cur.setDuracion(rs.getInt("duracion_horas"));
                cur.setPrecio(rs.getDouble("precio"));
                cur.setNombre_periodo(rs.getString("nombre_periodo"));
                cur.setNombre_facilitador(rs.getString("nombre_facilitador"));
                cur.setModalidad(rs.getString("modalidad"));
                listacur.add(cur);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar: " + e.toString());
        }
        return listacur;
    }

    public List<cursos> ListaCursosTerminados() {
        List<cursos> listacur = new ArrayList<>();
        String sql = "SELECT * FROM cursos WHERE DATE_ADD(fecha_inicial, INTERVAL duracion_horas HOUR) <= NOW() AND status = 1";

        try (Connection con = cn.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                cursos cur = new cursos();
                cur.setId(rs.getInt("id"));
                cur.setNombre(rs.getString("nombre"));
                cur.setDetalles(rs.getString("detalles"));
                cur.setDuracion(rs.getInt("duracion_horas"));
                cur.setPrecio(rs.getDouble("precio"));
                cur.setId_periodo(rs.getInt("nombre_periodo"));
                cur.setId_facilitador(rs.getInt("id_facilitador"));
                cur.setModalidad(rs.getString("modalidad"));
                listacur.add(cur);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar cursos terminados: " + e.toString());
        }
        return listacur;
    }

    public boolean modificar(cursos cur) {
        String sql1 = "UPDATE cursos SET nombre = ?, detalles = ?, duracion_horas = ?, precio = ?, id_facilitador = ?, id_periodo = ?, modalidad = ?  WHERE id = ?";
        try (Connection con = cn.getConexion();
             PreparedStatement ps = con.prepareStatement(sql1)) {
            
            ps.setString(1, cur.getNombre());
            ps.setString(2, cur.getDetalles());
            ps.setInt(3, cur.getDuracion()); 
            ps.setDouble(4, cur.getPrecio());
            ps.setInt(5, cur.getId_facilitador());
            ps.setInt(6, cur.getId_periodo());
            ps.setString(7, cur.getModalidad());
            ps.setInt(8, cur.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar: " + e.toString());
            return false;
        }
    }
    
    public boolean eliminar(cursos cur) {
        String sql1 = "DELETE FROM cursos WHERE id = ?";
        try (Connection con = cn.getConexion();
             PreparedStatement ps = con.prepareStatement(sql1)) {
            
            ps.setInt(1, cur.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
}


package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class inscripcionDao {
    Conexion cn = new Conexion();

    public boolean Ingresar(inscripcion ins) {
        String sql = "INSERT INTO inscripciones (id_estudiante, id_curso) VALUES (?,?)";
        // Al declarar la conexión aquí adentro, Java la cierra sola al salir del try
        try (Connection con = cn.getConexion(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, ins.getId_estudiante());
            ps.setInt(2, ins.getId_curso());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }

    
   public int registrarInscripcionMasiva(List<inscripcion> lista) {
    // INSERT IGNORE evita errores si el estudiante ya está en el curso
    String sql = "INSERT IGNORE INTO inscripciones (id_estudiante, id_curso) VALUES (?, ?)";
    Conexion conectar = new Conexion();
    Connection con = null;
    PreparedStatement ps = null;
    int totalInsertados = 0;

    try {
        con = conectar.getConexion();
        con.setAutoCommit(false); // Iniciamos transacción
        ps = con.prepareStatement(sql);

        for (inscripcion ins : lista) {
            ps.setInt(1, ins.getId_estudiante());
            ps.setInt(2, ins.getId_curso());
            ps.addBatch(); // Empaquetamos la fila
        }

        // Ejecutamos el lote
        int[] resultados = ps.executeBatch();
        
        // Sumamos los registros que realmente se insertaron (valor > 0)
        // MariaDB devuelve 1 si insertó y 0 si ignoró por duplicado
        for (int res : resultados) {
            if (res > 0 || res == PreparedStatement.SUCCESS_NO_INFO) {
                totalInsertados++;
            }
        }

        con.commit(); // Guardamos cambios de forma permanente
        return totalInsertados;

    } catch (SQLException e) {
        // Si hay un error de conexión o SQL, hacemos rollback
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                System.err.println("Error crítico en Rollback: " + ex.getMessage());
            }
        }
        System.err.println("Error en Inscripción Masiva: " + e.getMessage());
        return -1; // Retornamos -1 para indicar que hubo un error técnico
    } finally {
        // Cerramos los recursos para liberar memoria en el servidor MariaDB
        try {
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.err.println("Error al cerrar recursos: " + e.getMessage());
        }
    }
}

    public List<inscripcion> ListaIns() {
    List<inscripcion> ListaIns = new ArrayList<>();
    // SQL con todos los JOINs necesarios
    String sql = "SELECT i.*, " +
                 "e.cedula AS cedula_estudiante, " +
                 "e.nombre AS nombre_estudiante, " +
                 "e.apellido AS apellido_estudiante, "+
                 "e.sexo AS sexo_estudiante, "+
                 "e.procedencia AS procedencia_estudiante, "+
                 "e.semestre AS semestre_estudiante, "+
                 "CONCAT(e.nombre, ' ', e.apellido) AS estudiante_full, " +
                 "c.nombre AS nombre_curso, " +
                 "CONCAT(c.duracion_horas, 'hrs') AS duracion_curso, " +
                 "c.precio AS costo_curso, " +
                 "c.fecha_inicial AS fecha_inicio, " +
                 "c.detalles AS detalle_curso, "+
                 "p.nombre AS nombre_periodo," +
                 "a.nombre AS nombre_carrera," +
                 "CONCAT(f.grado_academico, ' ', f.nombre, ' ', f.apellido) AS facilitador_full " +
                 "FROM inscripciones i " +
                 "INNER JOIN estudiantes e ON i.id_estudiante = e.id " +
                 "INNER JOIN cursos c ON i.id_curso = c.id " +
                 "INNER JOIN facilitadores f ON c.id_facilitador = f.id "+ // Unimos con facilitadores
                 "INNER JOIN carreras a ON e.id_carrera = a.id "+
                 "INNER JOIN periodos p ON c.id_periodo = p.id";
    
    try (Connection con = cn.getConexion();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            inscripcion ins = new inscripcion();
            ins.setId(rs.getInt("id"));
            ins.setId_estudiante(rs.getInt("id_estudiante"));
            ins.setId_curso(rs.getInt("id_curso"));
            
            // Seteamos los nuevos datos extraídos
            ins.setNombre(rs.getString("nombre_estudiante"));
            ins.setApellido(rs.getString("apellido_estudiante"));
            ins.setCedula(rs.getString("cedula_estudiante"));
            ins.setNombre_completo(rs.getString("estudiante_full"));
            ins.setSexo_estudiante(rs.getString("sexo_estudiante"));
            ins.setProcedencia(rs.getString("procedencia_estudiante"));
            ins.setNombre_curso(rs.getString("nombre_curso"));
            ins.setDuracion(rs.getString("duracion_curso"));
            ins.setCosto_curso(rs.getString("costo_curso"));
            ins.setFecha_inicio(rs.getString("fecha_inicio"));
            ins.setFacilitador_completo(rs.getString("facilitador_full"));
            ins.setEstado(rs.getString("estado"));
            ins.setPeriodo(rs.getString("nombre_periodo"));
            ins.setCarrera_estudiante(rs.getString("nombre_carrera"));
            ins.setSemestre(rs.getString("semestre_estudiante"));
            ins.setDetalles(rs.getString("detalle_curso"));
            
            ListaIns.add(ins);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al listar: " + e.toString());
    }
    return ListaIns;
}
    
    public List<inscripcion> ListaInsA() {
    List<inscripcion> ListaIns = new ArrayList<>();
    // Agregamos WHERE i.estado = 'Aprobado' al final de la consulta
    String sql = "SELECT i.*, " +
                 "e.cedula AS cedula_estudiante, " +
                 "CONCAT(e.nombre, ' ', e.apellido) AS estudiante_full, " +
                 "c.nombre AS nombre_curso, " +
                 "CONCAT(c.duracion_horas, 'hrs') AS duracion_curso, " +
                 "c.fecha_inicial AS fecha_inicio, " +
                 "c.detalles AS detalle_curso, "+
                 "p.nombre AS nombre_periodo," +
                 "CONCAT(f.grado_academico, ' ', f.nombre, ' ', f.apellido) AS facilitador_full " +
                 "FROM inscripciones i " +
                 "INNER JOIN estudiantes e ON i.id_estudiante = e.id " +
                 "INNER JOIN cursos c ON i.id_curso = c.id " +
                 "INNER JOIN facilitadores f ON c.id_facilitador = f.id " +
                 "INNER JOIN periodos p ON c.id_periodo = p.id " +
                 "WHERE i.estado = 'Aprobado'"; // <--- Filtro de estado
    
    try (Connection con = cn.getConexion();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            inscripcion ins = new inscripcion();
            ins.setId(rs.getInt("id"));
            ins.setId_estudiante(rs.getInt("id_estudiante"));
            ins.setId_curso(rs.getInt("id_curso"));
            
            // Seteamos los datos extraídos
            ins.setCedula(rs.getString("cedula_estudiante"));
            ins.setNombre_completo(rs.getString("estudiante_full"));
            ins.setNombre_curso(rs.getString("nombre_curso"));
            ins.setDuracion(rs.getString("duracion_curso"));
            ins.setFecha_inicio(rs.getString("fecha_inicio"));
            ins.setFacilitador_completo(rs.getString("facilitador_full"));
            ins.setEstado(rs.getString("estado"));
            ins.setPeriodo(rs.getString("nombre_periodo"));
            ins.setDetalles(rs.getString("detalle_curso"));
            
            ListaIns.add(ins);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al listar inscripciones aprobadas: " + e.toString());
    }
    return ListaIns;
}

    public List<inscripcion> ListaInsFiltrada(int idPeriodo, int idCurso) {
    List<inscripcion> ListaIns = new ArrayList<>();
    String sql = "SELECT i.*, " +
                 "e.cedula AS cedula_estudiante, " +
                 "CONCAT(e.nombre, ' ', e.apellido) AS estudiante_full, " +
                 "c.nombre AS nombre_curso, " +
                 "CONCAT(c.duracion_horas, 'hrs') AS duracion_curso, " +
                 "c.fecha_inicial AS fecha_inicio, " +
                 "c.detalles AS detalle_curso, "+
                 "p.nombre AS nombre_periodo," +
                 "CONCAT(f.grado_academico, ' ', f.nombre, ' ', f.apellido) AS facilitador_full " +
                 "FROM inscripciones i " +
                 "INNER JOIN estudiantes e ON i.id_estudiante = e.id " +
                 "INNER JOIN cursos c ON i.id_curso = c.id " +
                 "INNER JOIN facilitadores f ON c.id_facilitador = f.id " +
                 "INNER JOIN periodos p ON c.id_periodo = p.id " +
                 "WHERE c.id_periodo = ? AND c.id = ?";
    
    try (Connection con = cn.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, idPeriodo);
        ps.setInt(2, idCurso);
        
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                inscripcion ins = new inscripcion();
                ins.setId(rs.getInt("id"));
                ins.setId_estudiante(rs.getInt("id_estudiante"));
                ins.setId_curso(rs.getInt("id_curso"));
                ins.setCedula(rs.getString("cedula_estudiante"));
                ins.setNombre_completo(rs.getString("estudiante_full"));
                ins.setNombre_curso(rs.getString("nombre_curso"));
                ins.setDuracion(rs.getString("duracion_curso"));
                ins.setFecha_inicio(rs.getString("fecha_inicio"));
                ins.setFacilitador_completo(rs.getString("facilitador_full"));
                ins.setEstado(rs.getString("estado"));
                ins.setPeriodo(rs.getString("nombre_periodo"));
                ins.setDetalles(rs.getString("detalle_curso"));
                ListaIns.add(ins);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al listar filtrado: " + e.toString());
    }
    return ListaIns;
}

    public List<inscripcion> ListaInsAFiltrada(int idPeriodo, int idCurso) {
    List<inscripcion> ListaIns = new ArrayList<>();
    String sql = "SELECT i.*, " +
                 "e.cedula AS cedula_estudiante, " +
                 "CONCAT(e.nombre, ' ', e.apellido) AS estudiante_full, " +
                 "c.nombre AS nombre_curso, " +
                 "CONCAT(c.duracion_horas, 'hrs') AS duracion_curso, " +
                 "c.fecha_inicial AS fecha_inicio, " +
                 "c.detalles AS detalle_curso, "+
                 "p.nombre AS nombre_periodo," +
                 "CONCAT(f.grado_academico, ' ', f.nombre, ' ', f.apellido) AS facilitador_full " +
                 "FROM inscripciones i " +
                 "INNER JOIN estudiantes e ON i.id_estudiante = e.id " +
                 "INNER JOIN cursos c ON i.id_curso = c.id " +
                 "INNER JOIN facilitadores f ON c.id_facilitador = f.id " +
                 "INNER JOIN periodos p ON c.id_periodo = p.id " +
                 "WHERE i.estado = 'Aprobado' " +
                 "AND c.id_periodo = ? AND c.id = ? " +
                 "AND DATE_ADD(c.fecha_inicial, INTERVAL c.duracion_horas HOUR) <= NOW() " +
                 "AND i.status = 1 AND c.status = 1";
    
    try (Connection con = cn.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, idPeriodo);
        ps.setInt(2, idCurso);
        
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                inscripcion ins = new inscripcion();
                ins.setId(rs.getInt("id"));
                ins.setId_estudiante(rs.getInt("id_estudiante"));
                ins.setId_curso(rs.getInt("id_curso"));
                ins.setCedula(rs.getString("cedula_estudiante"));
                ins.setNombre_completo(rs.getString("estudiante_full"));
                ins.setNombre_curso(rs.getString("nombre_curso"));
                ins.setDuracion(rs.getString("duracion_curso"));
                ins.setFecha_inicio(rs.getString("fecha_inicio"));
                ins.setFacilitador_completo(rs.getString("facilitador_full"));
                ins.setEstado(rs.getString("estado"));
                ins.setPeriodo(rs.getString("nombre_periodo"));
                ins.setDetalles(rs.getString("detalle_curso"));
                ListaIns.add(ins);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al listar aprobados filtrados: " + e.toString());
    }
    return ListaIns;
}
    
    public List<inscripcion> ListaRepFiltrada(int idPeriodo, int idCurso) {
    List<inscripcion> ListaIns = new ArrayList<>();
    String sql = "SELECT i.*, " +
                 "e.cedula AS cedula_estudiante, " +
                 "e.nombre AS nombre_estudiante, " +
                 "e.apellido AS apellido_estudiante, "+
                 "e.sexo AS sexo_estudiante, "+
                 "e.procedencia AS procedencia_estudiante, "+
                 "e.semestre AS semestre_estudiante, "+
                 "CONCAT(e.nombre, ' ', e.apellido) AS estudiante_full, " +
                 "c.nombre AS nombre_curso, " +
                 "CONCAT(c.duracion_horas, 'hrs') AS duracion_curso, " +
                 "c.precio AS costo_curso, " +
                 "c.fecha_inicial AS fecha_inicio, " +
                 "c.detalles AS detalle_curso, "+
                 "p.nombre AS nombre_periodo," +
                 "a.nombre AS nombre_carrera," +
                 "CONCAT(f.grado_academico, ' ', f.nombre, ' ', f.apellido) AS facilitador_full " +
                 "FROM inscripciones i " +
                 "INNER JOIN estudiantes e ON i.id_estudiante = e.id " +
                 "INNER JOIN cursos c ON i.id_curso = c.id " +
                 "INNER JOIN facilitadores f ON c.id_facilitador = f.id "+ // Unimos con facilitadores
                 "INNER JOIN carreras a ON e.id_carrera = a.id "+
                 "INNER JOIN periodos p ON c.id_periodo = p.id "+
                 "WHERE c.id_periodo = ? AND i.id_curso = ?";
    
    try (Connection con = cn.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setInt(1, idPeriodo);
        ps.setInt(2, idCurso);
        
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                inscripcion ins = new inscripcion();
                ins.setId(rs.getInt("id"));
            ins.setId_estudiante(rs.getInt("id_estudiante"));
            ins.setId_curso(rs.getInt("id_curso"));
            ins.setNombre(rs.getString("nombre_estudiante"));
            ins.setApellido(rs.getString("apellido_estudiante"));
            ins.setCedula(rs.getString("cedula_estudiante"));
            ins.setNombre_completo(rs.getString("estudiante_full"));
            ins.setSexo_estudiante(rs.getString("sexo_estudiante"));
            ins.setProcedencia(rs.getString("procedencia_estudiante"));
            ins.setNombre_curso(rs.getString("nombre_curso"));
            ins.setDuracion(rs.getString("duracion_curso"));
            ins.setCosto_curso(rs.getString("costo_curso"));
            ins.setFecha_inicio(rs.getString("fecha_inicio"));
            ins.setFacilitador_completo(rs.getString("facilitador_full"));
            ins.setEstado(rs.getString("estado"));
            ins.setPeriodo(rs.getString("nombre_periodo"));
            ins.setCarrera_estudiante(rs.getString("nombre_carrera"));
            ins.setSemestre(rs.getString("semestre_estudiante"));
            ins.setDetalles(rs.getString("detalle_curso"));
                ListaIns.add(ins);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al listar filtrado: " + e.toString());
    }
    return ListaIns;
}

    public boolean modificar(inscripcion ins) {
        String sql1 = "UPDATE inscripciones SET id_estudiante = ?, id_curso = ? WHERE id = ?";
        try (Connection con = cn.getConexion();
             PreparedStatement ps = con.prepareStatement(sql1)) {
            
            ps.setInt(1, ins.getId_estudiante());
            ps.setInt(2, ins.getId_curso());
            ps.setInt(3, ins.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
    public boolean eliminar(inscripcion ins) {
        String sql1 = "DELETE FROM inscripciones WHERE id = ?";
        try (Connection con = cn.getConexion();
             PreparedStatement ps = con.prepareStatement(sql1)) {
            
            ps.setInt(1, ins.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    }
    
    public boolean accion(String estado, int id) {
    String sql = "UPDATE inscripciones SET estado = ? WHERE id = ?";
    
    // Usamos try-with-resources solo para Connection y PreparedStatement
    // No necesitamos ResultSet para un UPDATE
    try (Connection con = cn.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        // 1. Primero asignamos los parámetros
        ps.setString(1, estado);
        ps.setInt(2, id);
        
        // 2. Ejecutamos la actualización
        // executeUpdate devuelve el número de filas afectadas
        int filasAfectadas = ps.executeUpdate();
        
        // 3. Retornamos true si se actualizó al menos un registro
        return filasAfectadas > 0;
        
    } catch (SQLException e) {
        // Es mejor imprimir el error en consola para debug y mostrar algo simple al usuario
        System.err.println("Error en accion (Update Estado): " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Error al actualizar el estado: " + e.getMessage());
        return false;
    }
}
}


package Models;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class certificadosDao {
        Conexion cn = new Conexion();

public void generarReporte(DefaultTableModel modelo) {
    try {
        // 1. Generar el JasperPrint de los Certificados
        JRTableModelDataSource dsCert = new JRTableModelDataSource(modelo);
        InputStream isCert = getClass().getResourceAsStream("/reportes/javacert.jrxml");
        JasperReport reporteCert = JasperCompileManager.compileReport(isCert);
        JasperPrint jprintCert = JasperFillManager.fillReport(reporteCert, new HashMap<>(), dsCert);

        // 2. Generar el JasperPrint del Detalle
        // Importante: Crear un nuevo DataSource porque el anterior ya fue consumido
        JRTableModelDataSource dsDetalle = new JRTableModelDataSource(modelo);
        InputStream isDetalle = getClass().getResourceAsStream("/reportes/detalle.jrxml");
        
        if (isDetalle != null) {
            JasperReport reporteDetalle = JasperCompileManager.compileReport(isDetalle);
            JasperPrint jprintDetalle = JasperFillManager.fillReport(reporteDetalle, new HashMap<>(), dsDetalle);

            // --- 3. FUSIÓN DE REPORTES ---
            // Obtenemos las páginas del reporte de detalles y las agregamos al de certificados
            List<JRPrintPage> paginasDetalle = jprintDetalle.getPages();
            for (JRPrintPage pagina : paginasDetalle) {
                jprintCert.addPage(pagina);
            }
        }

        // 4. Mostrar un único visor con todo el contenido
        JasperViewer viewer = new JasperViewer(jprintCert, false);
        viewer.setTitle("Certificados y Detalle de Cursos");
        viewer.setVisible(true);

    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(null, "Error al consolidar reportes: " + e.getMessage());
    }
}

public boolean insertarCertificado(int idInscripcion) {
    String sql = "INSERT INTO certificados (id_inscripcion) VALUES (?)";
    try (Connection con = cn.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idInscripcion);
        ps.execute();
        return true;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al insertar certificado: " + e.toString());
        return false;
    }
}
    
}

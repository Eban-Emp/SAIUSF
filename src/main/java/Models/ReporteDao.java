
package Models;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class ReporteDao {
    
    public void generarReporte(DefaultTableModel modelo) {
    try {
        JRTableModelDataSource dataSource = new JRTableModelDataSource(modelo);
        InputStream is = getClass().getResourceAsStream("/reportes/javarep.jrxml");
        
        if (is == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "No se encontró el archivo JRXML");
            return;
        }

        JasperReport reporteCompilado = JasperCompileManager.compileReport(is);
        
        // Parámetros opcionales si necesitas pasar algo más
        Map<String, Object> parametros = new HashMap<>();

        JasperPrint jprint = JasperFillManager.fillReport(reporteCompilado, parametros, dataSource);
        
        // Esto abrirá el visor con todos los certificados (uno por página)
        JasperViewer viewer = new JasperViewer(jprint, false);
        viewer.setTitle("reporte Generado");
        viewer.setVisible(true);

    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(null, "Error al generar: " + e.getMessage());
    }
}
}

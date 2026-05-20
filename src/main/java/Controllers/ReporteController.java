
package Controllers;

import Models.ReporteDao;
import Models.cbxitem;
import Models.inscripcion;
import Models.inscripcionDao;
import Models.periodo;
import Models.periodoDao;
import com.mycompany.saiusf.util.functionutil;
import com.mycompany.saiusf.views.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ReporteController implements ActionListener{
    private inscripcionDao insDao;
    private ReporteDao repDao;
    private periodoDao perDao;
    private Principal views;
    DefaultTableModel modelo = new DefaultTableModel();

    public ReporteController(inscripcion ins, inscripcionDao insDao, ReporteDao repDao, periodoDao perDao, Principal views) {
        this.insDao = insDao;
        this.repDao = repDao;
        this.perDao = perDao;
        this.views = views;
        this.views.exportarreport.addActionListener(this);
        this.views.Filtrarrep.addActionListener(this);
        this.modelo = (DefaultTableModel) views.TablePer.getModel();
        listarReportes();
    }

    public ReporteController() {
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == views.exportarreport) {
            System.out.println("Clic detectado en Exportar");
        // 1. Obtener el modelo de la tabla
        DefaultTableModel modeloReporte = (DefaultTableModel) views.TableReporte.getModel();
        
        // 2. Validar que tenga datos
        if (modeloReporte.getRowCount() == 0) {
             javax.swing.JOptionPane.showMessageDialog(null, "No hay datos para exportar");
             return;
        }

        // 3. Generar el reporte
        repDao.generarReporte(modeloReporte);
    } else if (e.getSource() == views.Filtrarrep) {
        System.out.println("Clic detectado en Exportar");
        filtrarRep();
    }
    }
    
        public void listarReportes(){
        functionutil.limpiarTabla((DefaultTableModel) views.TableReporte.getModel(), views.TableReporte);
        
        DefaultTableModel modelorep = (DefaultTableModel) views.TableReporte.getModel();
        
        //        Reporte
        List<inscripcion> lista = insDao.ListaIns();
        for (inscripcion ins1 : lista){
            Object[] fila ={
            ins1.getId(),
            ins1.getNombre_curso(),
            ins1.getDuracion(),
            ins1.getFecha_inicio(),
            ins1.getCedula(),
            ins1.getNombre(),
            ins1.getApellido(),
            ins1.getCarrera_estudiante(),
            ins1.getSemestre(),
            ins1.getCosto_curso(),
            ins1.getSexo_estudiante(),
            ins1.getProcedencia(),
            ins1.getPeriodo(),
        };
        modelorep.addRow(fila);
        }
    }
    
    
    private void filtrarRep() {
    // 1. Limpiar antes de empezar
    DefaultTableModel modeloReporte = (DefaultTableModel) views.TableReporte.getModel();
    modeloReporte.setRowCount(0);

    // 2. Obtener seleccionados de forma segura
    Object itemP = views.cbxPeriodorep.getSelectedItem();
    Object itemC = views.cbxCursorep.getSelectedItem();

    if (itemP instanceof cbxitem && itemC instanceof cbxitem) {
        int idPeriodo = ((cbxitem) itemP).getId();
        int idCurso = ((cbxitem) itemC).getId();

        // 3. Consultar al DAO
        List<inscripcion> lista = insDao.ListaRepFiltrada(idPeriodo, idCurso);
        
        if (lista != null && !lista.isEmpty()) {
            for (inscripcion ins : lista) {
                Object[] ob = {
                    ins.getId(), ins.getNombre_curso(), ins.getDuracion(),
                    ins.getFecha_inicio(), ins.getCedula(), ins.getNombre(),
                    ins.getApellido(), ins.getCarrera_estudiante(), ins.getSemestre(),
                    ins.getCosto_curso(), ins.getSexo_estudiante(), ins.getProcedencia(),
                    ins.getPeriodo()
                };
                modeloReporte.addRow(ob);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "No se encontraron registros para este filtro.");
        }
    } else {
        javax.swing.JOptionPane.showMessageDialog(null, "Seleccione un Periodo y Curso válidos.");
    }
}

    
}

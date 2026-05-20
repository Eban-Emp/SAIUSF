
package Controllers;

import Models.certificadosDao;
import Models.certificados;
import Models.inscripcionDao;
import Models.inscripcion;
import Models.cbxitem;
import com.mycompany.saiusf.views.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class certificadoController implements ActionListener, MouseListener, KeyListener{
    
    private certificadosDao certDao;
    private inscripcionDao insDao;
    private Principal views;
    DefaultTableModel modelo = new DefaultTableModel();
    private TableRowSorter<DefaultTableModel> sorter;

    public certificadoController(certificados cert, certificadosDao certDao, Principal views) {
        this.modelo = (DefaultTableModel) views.TableCert.getModel();
        this.sorter = new TableRowSorter<>(modelo);
        this.certDao = certDao;
        this.insDao = new inscripcionDao();
        this.views = views;
        
        this.views.TableCert.addMouseListener(this);
        this.views.cbxPeriodocert.addKeyListener(this);
        this.views.cbxCursocert.addKeyListener(this);
        this.views.FiltrarCert.addActionListener(this);
        this.views.exportarcert.addActionListener(this);
        this.views.TableCert.setRowSorter(sorter);
        limpiartablecert();
        listarCertificados();
        
    }

    public certificadoController() {
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == views.exportarcert) {
        // 1. Obtener el modelo de la tabla
        DefaultTableModel modeloReporte = (DefaultTableModel) views.TableCert.getModel();
        
        // 2. Validar que tenga datos
        if (modeloReporte.getRowCount() == 0) {
             javax.swing.JOptionPane.showMessageDialog(null, "No hay datos para exportar");
             return;
        }

        // 3. Generar el reporte
        certDao.generarReporte(modeloReporte);
    } else if (e.getSource() == views.FiltrarCert) {
        filtrarCert();
    }
}
    
   public void listarCertificados() {
    List<inscripcion> lista = insDao.ListaInsA();
    // Hacer TableCert no editable
    DefaultTableModel modeloOriginal = (DefaultTableModel) views.TableCert.getModel();
    Object[] columnNamesCert = new Object[modeloOriginal.getColumnCount()];
    for (int i = 0; i < modeloOriginal.getColumnCount(); i++) {
        columnNamesCert[i] = modeloOriginal.getColumnName(i);
    }
    DefaultTableModel modelo = new DefaultTableModel(columnNamesCert, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    modelo.setRowCount(0); // Limpiar tabla antes de llenar
    Object[] ob = new Object[10];
    for (int i = 0; i < lista.size(); i++) {
        ob[0] = lista.get(i).getId();
        ob[1] = lista.get(i).getNombre_completo();
        ob[2] = lista.get(i).getCedula();
        ob[3] = lista.get(i).getNombre_curso();
        ob[4] = lista.get(i).getDuracion();
        ob[5] = lista.get(i).getFecha_inicio();
        ob[6] = lista.get(i).getFacilitador_completo();
        ob[7] = lista.get(i).getEstado();
        ob[8] = lista.get(i).getPeriodo();
        ob[9] = lista.get(i).getDetalles();
        modelo.addRow(ob);
    }
    views.TableCert.setRowSorter(null);
    views.TableCert.setModel(modelo);
    sorter = new TableRowSorter<>(modelo);
    views.TableCert.setRowSorter(sorter);
}
    
    public void limpiartablecert() {
        modelo.setRowCount(0);
    }

    private void filtrarCert() {
    limpiartablecert();
    cbxitem itemPeriodo = (cbxitem) views.cbxPeriodocert.getSelectedItem();
    cbxitem itemCurso = (cbxitem) views.cbxCursocert.getSelectedItem();
    if (itemPeriodo != null && itemCurso != null) {
        int idPeriodo = itemPeriodo.getId();
        int idCurso = itemCurso.getId();
        List<inscripcion> lista = insDao.ListaInsAFiltrada(idPeriodo, idCurso);
        // Hacer TableCert no editable
        DefaultTableModel modeloOriginal = (DefaultTableModel) views.TableCert.getModel();
        Object[] columnNamesCert = new Object[modeloOriginal.getColumnCount()];
        for (int i = 0; i < modeloOriginal.getColumnCount(); i++) {
            columnNamesCert[i] = modeloOriginal.getColumnName(i);
        }
        modelo = new DefaultTableModel(columnNamesCert, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelo.setRowCount(0);
        Object[] ob = new Object [10];
        for (inscripcion ins : lista){
            ob[0] = ins.getId();
            ob[1] = ins.getNombre_completo();
            ob[2] = ins.getCedula();
            ob[3] = ins.getNombre_curso();
            ob[4] = ins.getDuracion();
            ob[5] = ins.getFecha_inicio();
            ob[6] = ins.getFacilitador_completo();
            ob[7] = ins.getEstado();
            ob[8] = ins.getPeriodo();
            ob[9] = ins.getDetalles();
            modelo.addRow(ob);
        }
        views.TableCert.setRowSorter(null);
        views.TableCert.setModel(modelo);
        sorter = new TableRowSorter<>(modelo);
        views.TableCert.setRowSorter(sorter);
    }
}

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
    
}

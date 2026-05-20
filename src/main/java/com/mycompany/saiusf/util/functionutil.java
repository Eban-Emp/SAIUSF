
package com.mycompany.saiusf.util;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class functionutil {
    
    public static void limpiarTabla(DefaultTableModel modelo, JTable tabla) {
        tabla.setRowSorter(null);
        modelo.setRowCount(0);
    }
    
}

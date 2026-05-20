package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    public Connection getConexion() throws SQLException {
        try {
            // En MariaDB no hace falta el serverTimezone=UTC para localhost
            String db = "jdbc:mariadb://localhost:3306/saiusf_v2?useSSL=false";
            String user = "root";
            String pass = ""; 
            
            return DriverManager.getConnection(db, user, pass);
            
        } catch (SQLException e) {
            // Imprimimos el error real en consola para que tú y yo podamos verlo
            System.err.println("Error detallado: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.\n"
                    + "¿XAMPP está encendido?\nDetalle: " + e.getMessage());
            throw new SQLException("No se pudo conectar a la base de datos: " + e.getMessage(), e);
        }
    }
}
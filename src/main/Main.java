package main;

import Ventanas.Login;
import java.io.IOException;
import javax.swing.JOptionPane;
import main.DatabaseManager;

/**
 *
 * @author Samuel Chourio
 */
public class Main {
    private static Process xamppStart;
    
    public static void main(String[] args) {
        try {
            xamppStart = Runtime.getRuntime().exec("C:\\xampp\\xampp-control.exe");
            DatabaseManager.initializeDatabase();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar XAMPP: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Login login = new Login();
        login.setVisible(true);
    }
    
    public static void cerrarXampp(){
        xamppStart.destroy();
        
    }
    
}

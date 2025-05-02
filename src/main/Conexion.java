
package main;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    // Método que establece una conexión con la base de datos MySQL.
    // Retorna un objeto Connection que representa la conexión.
    public static Connection conectar(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/serviciofin","root","");   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo conectar la base de datos");
        }
        return con;
    }
    
    public static String[] consultaGraduado(String cedula){
        Connection con=null;
        PreparedStatement ps;
        ResultSet rs;
        String[] datos= new String[4];
        try {
            con=conectar();
            ps=con.prepareStatement("SELECT nombre, area, asiento, estado FROM graduados WHERE cedula=? OR asiento=?");
            ps.setInt(1, parseInt(cedula));
            ps.setInt(2, parseInt(cedula));
            rs=ps.executeQuery();
            if (rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=String.valueOf( rs.getInt(3));
                datos[3]=String.valueOf( rs.getInt(4));
                
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo encontrar ningun graduado con esta cedula");
            }
        } catch (Exception e) {
        }
        return datos;
    }
    
    public static void asistenciaGraduado(String cedula){
        Connection con=null;
        PreparedStatement ps;
        try {
            con=conectar();
            ps=con.prepareStatement("UPDATE graduados SET estado=1 WHERE cedula=? OR asiento=?");
            ps.setInt(1, parseInt(cedula));
            ps.setInt(2, parseInt(cedula));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro de asistencia exitoso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la asistencia");
        }
    }
    
    public static void anadir(String cedula){
        Connection con=null;
        PreparedStatement ps;
        try {
            con=conectar();

            ps=con.prepareStatement("INSERT INTO `cambios`(`id_bien`, `tipo`, `reincorporacion`, `motivo`, `fecha`) VALUES (?,?,?,?,?)");
            ps.setInt(1, id_bien);
            ps.setString(2,tipo);
            ps.setString(3,fecha_r);
            ps.setString(4,motivo);
            ps.setString(5,fecha_s);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro de asistencia exitoso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la asistencia");
        }
    }
}


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
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/acto_grado","root","");   
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
            ps=con.prepareStatement("SELECT name, seat, state, cedula FROM participants WHERE cedula=? OR seat=?");
            ps.setInt(1, parseInt(cedula));
            ps.setInt(2, parseInt(cedula));
            rs=ps.executeQuery();
            if (rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=String.valueOf( rs.getInt(2));
                datos[2]=String.valueOf( rs.getInt(3));
                datos[3]=String.valueOf( rs.getInt(4));
                
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo encontrar ningun graduado con esta cedula");
            }
        } catch (Exception e) {
        }
        return datos;
    }
    
    public static void asistenciaGraduado(String asiento){
        Connection con=null;
        PreparedStatement ps;
        try {
            con=conectar();
            ps=con.prepareStatement("UPDATE participants SET state=1 WHERE seat=?");
            ps.setInt(1, parseInt(asiento));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro de asistencia exitoso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la asistencia");
        }
    }
    
    
    public static boolean login(String usuario,String pass){
        Connection con=null;
        boolean validor=false;
        
        PreparedStatement ps;
        ResultSet rs;
        try{
            con=conectar();
            ps=con.prepareStatement("SELECT * FROM users WHERE user=? and password=? and state=1");
            ps.setString(1,usuario);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            if (rs.next()) {
                
                validor=true;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo realizar la consulta");
        }
        return validor;
    }
}

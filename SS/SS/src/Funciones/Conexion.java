
package Funciones;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    
    Connection conectar = null;
    String usuario= "root";
    String contrasena= "12345";
    String bd= "secretaria_salud";
    String ip= "localhost";
    String puerto= "3308";
    
    String cadena= "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion(){
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar= DriverManager.getConnection(cadena,usuario,contrasena);
            //JOptionPane.showMessageDialog(null, "Conexion Exitosa");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base da datos, error:"+e.toString());
        };
        return conectar;
    }
    
}

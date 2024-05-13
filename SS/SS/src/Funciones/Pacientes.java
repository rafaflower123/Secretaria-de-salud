
package Funciones;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class Pacientes {

    int idPacientes;
    String NombrePaciente;
    String ApellidoPaciente;
    String FechaNaciemientoPaciente;
    String SexoPaciente;
    String ContrasenaPaciente;
    String NumeroSeguridadPaciente;
    String CorreoPaciente;
    
    public int getIdPacientes() {
        return idPacientes;
    }

    public void setIdPacientes(int idPacientes) {
        this.idPacientes = idPacientes;
    }

    public String getNombrePaciente() {
        return NombrePaciente;
    }

    public void setNombrePaciente(String NombrePaciente) {
        this.NombrePaciente = NombrePaciente;
    }

    public String getApellidoPaciente() {
        return ApellidoPaciente;
    }

    public void setApellidoPaciente(String ApellidoPaciente) {
        this.ApellidoPaciente = ApellidoPaciente;
    }

    public String getFechaNaciemientoPaciente() {
        return FechaNaciemientoPaciente;
    }

    public void setFechaNaciemientoPaciente(String FechaNaciemientoPaciente) {
        this.FechaNaciemientoPaciente = FechaNaciemientoPaciente;
    }

    public String getSexoPaciente() {
        return SexoPaciente;
    }

    public void setSexoPaciente(String SexoPaciente) {
        this.SexoPaciente = SexoPaciente;
    }

    public String getContrasenaPaciente() {
        return ContrasenaPaciente;
    }

    public void setContrasenaPaciente(String ContrasenaPaciente) {
        this.ContrasenaPaciente = ContrasenaPaciente;
    }

    public String getNumeroSeguridadPaciente() {
        return NumeroSeguridadPaciente;
    }

    public void setNumeroSeguridadPaciente(String NumeroSeguridadPaciente) {
        this.NumeroSeguridadPaciente = NumeroSeguridadPaciente;
    }

    public String getCorreoPaciente() {
        return CorreoPaciente;
    }

    public void setCorreoPaciente(String CorreoPaciente) {
        this.CorreoPaciente = CorreoPaciente;
    }
    
    public void RegistrarPaciente(JTextField EsNombre, JTextField EsApellido, JTextField EsFechaNacimiento, JTextField EsSexo, JTextField EsContrasena, JTextField EsNumeroSeguridad, JTextField EsCorreo){

    setNombrePaciente(EsNombre.getText());
    setApellidoPaciente(EsApellido.getText());
    setFechaNaciemientoPaciente(EsFechaNacimiento.getText());
    setSexoPaciente(EsSexo.getText());
    setContrasenaPaciente(EsContrasena.getText());
    setNumeroSeguridadPaciente(EsNumeroSeguridad.getText());
    setCorreoPaciente(EsCorreo.getText());

    Conexion conexionsql = new Conexion();

    String consulta = "insert into Pacientes (Nombre,Apellido,FechaNacimiento,Sexo,Contrasena,NumerodeSeguridad,Correo) Values (?,?,?,?,?,?,?);";

    try{
        Connection conn = conexionsql.estableceConexion(); // Obtener la conexión

        // Usar un PreparedStatement con el segundo argumento para indicar que queremos las claves generadas
        PreparedStatement ps = conn.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, getNombrePaciente());
        ps.setString(2, getApellidoPaciente());
        ps.setString(3, getFechaNaciemientoPaciente());
        ps.setString(4, getSexoPaciente());
        ps.setString(5, getContrasenaPaciente());
        ps.setString(6, getNumeroSeguridadPaciente());
        ps.setString(7, getCorreoPaciente());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int idPaciente = rs.getInt(1);
            JOptionPane.showMessageDialog(null, "Se registro correctamente, Recuerde su ID es muy importante: " + idPaciente);
        }

    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error al registrar"+ e.toString());
    }
}


    
    public void MostarPacientes(JTable paraTablaTotalPacientes){
        
         Conexion conexionsql = new Conexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla= new TableRowSorter<TableModel>(modelo);
        paraTablaTotalPacientes.setRowSorter(OrdenarTabla);
                
        String sql="";
        
        modelo.addColumn("IDPaciente");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("FechaDeNacimiento");
        modelo.addColumn("Sexo");
        modelo.addColumn("Contraseña");
        modelo.addColumn("NumeroDeSeguridad");
        modelo.addColumn("Correo");
        
        paraTablaTotalPacientes.setModel(modelo);
        
        sql="SELECT * FROM Pacientes";
        
        String[] datos= new String[8];
        Statement st;
        
        try{
            st = conexionsql.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                
                modelo.addRow(datos);
            }
            paraTablaTotalPacientes.setModel(modelo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar la tabla"+e.toString());
        }
        
    }
   public void MostrarPacienteConID(JTable paraTablaTotalPacientes, int idPaciente){
    Conexion conexionsql = new Conexion();

    DefaultTableModel modelo = new DefaultTableModel();

    TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
    paraTablaTotalPacientes.setRowSorter(OrdenarTabla);

    modelo.addColumn("IDPaciente");
    modelo.addColumn("Nombre");
    modelo.addColumn("Apellido");
    modelo.addColumn("FechaDeNacimiento");
    modelo.addColumn("Sexo");
    modelo.addColumn("Contraseña");
    modelo.addColumn("NumeroDeSeguridad");
    modelo.addColumn("Correo");

    paraTablaTotalPacientes.setModel(modelo);

    String sql = "SELECT * FROM Pacientes WHERE idPaciente = ?";
    
    try {
        PreparedStatement pst = conexionsql.estableceConexion().prepareStatement(sql);
        pst.setInt(1, idPaciente);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Object[] datos = {
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8)
            };

            modelo.addRow(datos);
        }
        paraTablaTotalPacientes.setModel(modelo);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al mostrar la tabla" + e.toString());
    }
}

    
    public void SeleccionarPaciente(JTable paramTablaPacientes,JTextField EsIDPacientes,JTextField EsNombre,JTextField EsApellido,JTextField EsFechaNacimiento,JTextField EsSexo
    ,JTextField EsContrasena,JTextField EsNumeroSeguridad, JTextField EsCorreo){
        
        try{
            int fila= paramTablaPacientes.getSelectedRow();
            if(fila>=0){
                EsIDPacientes.setText((paramTablaPacientes.getValueAt(fila, 0).toString()));
                EsNombre.setText((paramTablaPacientes.getValueAt(fila, 1).toString()));
                EsApellido.setText((paramTablaPacientes.getValueAt(fila, 2).toString()));
                EsFechaNacimiento.setText((paramTablaPacientes.getValueAt(fila, 3).toString()));
                EsSexo.setText((paramTablaPacientes.getValueAt(fila, 4).toString()));
                EsContrasena.setText((paramTablaPacientes.getValueAt(fila, 5).toString()));
                EsNumeroSeguridad.setText((paramTablaPacientes.getValueAt(fila, 6).toString()));
                EsCorreo.setText((paramTablaPacientes.getValueAt(fila, 7).toString()));
            }else{
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al seleccionar" + e.toString());
        }
        
    }
    public void modificarPaciente(JTextField EsIDPacientes,JTextField EsNombre,JTextField EsApellido,JTextField EsFechaNacimiento,JTextField EsSexo
    ,JTextField EsContrasena,JTextField EsNumeroSeguridad, JTextField EsCorreo){
        setIdPacientes(Integer.parseInt(EsIDPacientes.getText()));
        setNombrePaciente(EsNombre.getText());
        setApellidoPaciente(EsApellido.getText());
        setFechaNaciemientoPaciente(EsFechaNacimiento.getText());
        setSexoPaciente(EsSexo.getText());
        setContrasenaPaciente(EsContrasena.getText());
        setNumeroSeguridadPaciente(EsNumeroSeguridad.getText());
        setCorreoPaciente(EsCorreo.getText());
        
        Conexion conexionsql = new Conexion();
        String consulta="UPDATE Pacientes SET Nombre= ?, Apellido = ?, FechaNacimiento=?, Sexo=?, Contrasena=?, NumerodeSeguridad=?, Correo=? WHERE idPaciente=?; ";
        try{
            
            CallableStatement cs = conexionsql.estableceConexion().prepareCall(consulta);
            
            cs.setString(1, getNombrePaciente());
            cs.setString(2, getApellidoPaciente());
            cs.setString(3, getFechaNaciemientoPaciente());
            cs.setString(4, getSexoPaciente());
            cs.setString(5, getContrasenaPaciente());
            cs.setString(6, getNumeroSeguridadPaciente());
            cs.setString(7, getCorreoPaciente());
            cs.setInt(8, getIdPacientes());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se edito correctamente");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al modificar"+e.toString());
        }
    }
    public void EliminarPacientes(JTextField EsIDPacientes){
        setIdPacientes(Integer.parseInt(EsIDPacientes.getText()));
        Conexion conexionsql = new Conexion();
        
        String consulta= "DELETE FROM Pacientes WHERE idPaciente=?;";
        try{
            CallableStatement cs = conexionsql.estableceConexion().prepareCall(consulta);
            cs.setInt(1, getIdPacientes());
            
             cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se elimino Correctamente");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error al intentar eliminar la fila"+e.toString());
        }
    }
    
    
}

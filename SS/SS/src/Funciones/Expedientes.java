package Funciones;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class Expedientes {
    
    int idExpedientes;
    String idPacientes;
    String NombreExpediente;
    String ApellidoExpediente;
    String DiagnosticoEx;
    String FechaEx;
    String IndicacionEx;

    public int getIdExpedientes() {
        return idExpedientes;
    }

    public void setIdExpedientes(int idExpedientes) {
        this.idExpedientes = idExpedientes;
    }

    public String getIdPacientes() {
        return idPacientes;
    }

    public void setIdPacientes(String idPacientes) {
        this.idPacientes = idPacientes;
    }

    public String getNombreExpediente() {
        return NombreExpediente;
    }

    public void setNombreExpediente(String NombreExpediente) {
        this.NombreExpediente = NombreExpediente;
    }

    public String getApellidoExpediente() {
        return ApellidoExpediente;
    }

    public void setApellidoExpediente(String ApellidoExpediente) {
        this.ApellidoExpediente = ApellidoExpediente;
    }

    public String getDiagnosticoEx() {
        return DiagnosticoEx;
    }

    public void setDiagnosticoEx(String DiagnosticoEx) {
        this.DiagnosticoEx = DiagnosticoEx;
    }

    public String getFechaEx() {
        return FechaEx;
    }

    public void setFechaEx(String FechaEx) {
        this.FechaEx = FechaEx;
    }

    public String getIndicacionEx() {
        return IndicacionEx;
    }

    public void setIndicacionEx(String IndicacionEx) {
        this.IndicacionEx = IndicacionEx;
    }
            
            public void RegistrarExpediente(JTextField EsIdPaciente, JTextField EsNombre,JTextField EsApellido,JTextField EsDiagnostico,JTextField EsFecha
    ,JTextField EsIndicacion){
        
        setIdPacientes(EsIdPaciente.getText());
        setNombreExpediente(EsNombre.getText());
        setApellidoExpediente(EsApellido.getText());
        setDiagnosticoEx(EsDiagnostico.getText());
        setFechaEx(EsFecha.getText());
        setIndicacionEx(EsIndicacion.getText());
  
        Conexion conexionsql = new Conexion();
        
        String consulta =("insert into Expediente (idPaciente,Nombre,Apellido,Diagnostico,Fecha,Indicaciones) Values (?,?,?,?,?,?);");

        try{
            
            CallableStatement cs = conexionsql.estableceConexion().prepareCall(consulta);
            
            cs.setString(1, getIdPacientes());
            cs.setString(2, getNombreExpediente());
            cs.setString(3, getApellidoExpediente());
            cs.setString(4, getDiagnosticoEx());
            cs.setString(5, getFechaEx());
            cs.setString(6, getIndicacionEx());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Expediente Registrado");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al crear el expediente"+ e.toString());
        }       
    }
      public void MostarExpediente(JTable paraTablaTotalExpediente){
        
        Conexion conexionsql = new Conexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla= new TableRowSorter<TableModel>(modelo);
        paraTablaTotalExpediente.setRowSorter(OrdenarTabla);
                
        String sql="";
        
        modelo.addColumn("IDExpediente");
        modelo.addColumn("IDPaciente");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Diagnostico");
        modelo.addColumn("Fecha");
        modelo.addColumn("Indicaciones");
        
        paraTablaTotalExpediente.setModel(modelo);
        
        sql="SELECT * FROM Expediente";
        
        String[] datos= new String[7];
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
                
                modelo.addRow(datos);
            }
            paraTablaTotalExpediente.setModel(modelo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar la tabla"+e.toString());
        }       
    }
      
      public void MostarExpedienteIDPaciente(JTable paraTablaTotalExpediente, int idPaciente) {
    Conexion conexionsql = new Conexion();

    DefaultTableModel modelo = new DefaultTableModel();

    TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
    paraTablaTotalExpediente.setRowSorter(OrdenarTabla);

    modelo.addColumn("IDExpediente");
    modelo.addColumn("IDPaciente");
    modelo.addColumn("Nombre");
    modelo.addColumn("Apellido");
    modelo.addColumn("Diagnostico");
    modelo.addColumn("Fecha");
    modelo.addColumn("Indicaciones");

    paraTablaTotalExpediente.setModel(modelo);

    String sql = "SELECT * FROM Expediente WHERE idPaciente = ?";

    try {
        PreparedStatement pst = conexionsql.estableceConexion().prepareStatement(sql);
        pst.setInt(1, idPaciente);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Object[] datos = {
                rs.getInt(1),
                rs.getInt(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7)
            };

            modelo.addRow(datos);
        }
        paraTablaTotalExpediente.setModel(modelo);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al mostrar la tabla" + e.toString());
    }
}

      
    public void SeleccionarExpediente(JTable paraTablaTotalExpediente,JTextField EsIdExpediente){
        
        try{
            int fila=  paraTablaTotalExpediente.getSelectedRow();
            if(fila>=0){
                EsIdExpediente.setText(( paraTablaTotalExpediente.getValueAt(fila, 0).toString()));
            }else{
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al seleccionar" + e.toString());
        }
        
    }
    public void EliminarExpediente(JTextField EsIDExpediente){
        setIdExpedientes(Integer.parseInt(EsIDExpediente.getText()));
        Conexion conexionsql = new Conexion();
        
        String consulta= "DELETE FROM Expediente WHERE idExpediente=?;";
        try{
            CallableStatement cs = conexionsql.estableceConexion().prepareCall(consulta);
            cs.setInt(1, getIdExpedientes());
            
             cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se elimino Correctamente");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error al intentar eliminar la fila"+e.toString());
        }
    }
}

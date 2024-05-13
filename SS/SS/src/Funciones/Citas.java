package Funciones;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class Citas {
    
    int idCitas;
    String idPacienteCitas;
    String NombreCitas;
    String ApellidoCitas;
    String FechadelaCita;
    String DescripcionCita;
    String Lugar;

    public int getIdCitas() {
        return idCitas;
    }

    public void setIdCitas(int idCitas) {
        this.idCitas = idCitas;
    }

    public String getIdPacienteCitas() {
        return idPacienteCitas;
    }

    public void setIdPacienteCitas(String idPacienteCitas) {
        this.idPacienteCitas = idPacienteCitas;
    }

    public String getNombreCitas() {
        return NombreCitas;
    }

    public void setNombreCitas(String NombreCitas) {
        this.NombreCitas = NombreCitas;
    }

    public String getApellidoCitas() {
        return ApellidoCitas;
    }

    public void setApellidoCitas(String ApellidoCitas) {
        this.ApellidoCitas = ApellidoCitas;
    }

    public String getFechadelaCita() {
        return FechadelaCita;
    }

    public void setFechadelaCita(String FechadelaCita) {
        this.FechadelaCita = FechadelaCita;
    }

    public String getDescripcionCita() {
        return DescripcionCita;
    }

    public void setDescripcionCita(String DescripcionCita) {
        this.DescripcionCita = DescripcionCita;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String Lugar) {
        this.Lugar = Lugar;
    }
   
    public void RegistrarCita(JTextField EsIdPaciente, JTextField EsNombre,JTextField EsApellido,
            JTextField EsFechaCita,JTextField EsDescripcion,JTextField EsLugar){
       
        setIdPacienteCitas(EsIdPaciente.getText());
        setNombreCitas(EsNombre.getText());
        setApellidoCitas(EsApellido.getText());
        setFechadelaCita(EsFechaCita.getText());
        setDescripcionCita(EsDescripcion.getText());
        setLugar(EsLugar.getText());
  
        Conexion conexionsql = new Conexion();
        
        String consulta =("insert into Citas (idPacientes,Nombre,Apellido,FechadeCita,Descripcion,Lugar) Values (?,?,?,?,?,?);");

        try{
            
            CallableStatement cs = conexionsql.estableceConexion().prepareCall(consulta);
            
            cs.setString(1, getIdPacienteCitas());
            cs.setString(2, getNombreCitas());
            cs.setString(3, getApellidoCitas());
            cs.setString(4, getFechadelaCita());
            cs.setString(5, getDescripcionCita());
            cs.setString(6, getLugar());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Cita Registrada");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al crear la cita"+ e.toString());
        }       
    }
   public void MostarCita(JTable paraTablaTotalCitas){
        
        Conexion conexionsql = new Conexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla= new TableRowSorter<TableModel>(modelo);
        paraTablaTotalCitas.setRowSorter(OrdenarTabla);
                
        String sql="";
        
        modelo.addColumn("IDCita");
        modelo.addColumn("IDPaciente");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("FechaDeCita");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Lugar");
        
        paraTablaTotalCitas.setModel(modelo);
        
        sql="SELECT * FROM Citas";
        
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
            paraTablaTotalCitas.setModel(modelo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar la tabla"+e.toString());
        }
        
    } 
    public void MostrarCitaConID(JTable paraTablaTotalCitas, int idCita){
    Conexion conexionsql = new Conexion();

    DefaultTableModel modelo = new DefaultTableModel();

    TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
    paraTablaTotalCitas.setRowSorter(OrdenarTabla);

        modelo.addColumn("IDCita");
        modelo.addColumn("IDPaciente");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("FechaDeCita");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Lugar");

    paraTablaTotalCitas.setModel(modelo);

    String sql = "SELECT * FROM Citas WHERE idPacientes = ?";
    
    try {
        PreparedStatement pst = conexionsql.estableceConexion().prepareStatement(sql);
        pst.setInt(1, idCita);
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
            };

            modelo.addRow(datos);
        }
        paraTablaTotalCitas.setModel(modelo);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al mostrar la tabla" + e.toString());
    }
}
     public void SeleccionarExpediente(JTable paraTablaTotalCitas,JTextField EsIdCitas){
        
        try{
            int fila=  paraTablaTotalCitas.getSelectedRow();
            if(fila>=0){
                EsIdCitas.setText((paraTablaTotalCitas.getValueAt(fila, 0).toString()));
            }else{
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al seleccionar" + e.toString());
        }
        
    }
     public void EliminarCita(JTextField EsIDCita){
        setIdCitas(Integer.parseInt(EsIDCita.getText()));
        Conexion conexionsql = new Conexion();
        
        String consulta= "DELETE FROM Citas WHERE idCita=?;";
        try{
            CallableStatement cs = conexionsql.estableceConexion().prepareCall(consulta);
            cs.setInt(1, getIdCitas());
            
             cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se elimino Correctamente");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error al intentar eliminar la fila"+e.toString());
        }
    }
}

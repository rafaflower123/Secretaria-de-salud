
package Funciones;

import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DocumentosPDF {
    
    int codigopdf;
    String nombrepdf;
    byte[] archivopdf;

    public int getCodigopdf() {
        return codigopdf;
    }

    public void setCodigopdf(int codigopdf) {
        this.codigopdf = codigopdf;
    }

    public String getNombrepdf() {
        return nombrepdf;
    }

    public void setNombrepdf(String nombrepdf) {
        this.nombrepdf = nombrepdf;
    }

    public byte[] getArchivopdf() {
        return archivopdf;
    }

    public void setArchivopdf(byte[] archivopdf) {
        this.archivopdf = archivopdf;
    }
    
   public ArrayList<DocumentosPDF> Listar_PdfVO() {
        ArrayList<DocumentosPDF> list = new ArrayList<>();
        Conexion conexionsql = new Conexion();
        String sql = "SELECT * FROM DocumentosPDF;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conexionsql.estableceConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DocumentosPDF vo = new DocumentosPDF();
                vo.setCodigopdf(rs.getInt(1));
                vo.setNombrepdf(rs.getString(2));
                vo.setArchivopdf(rs.getBytes(3));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
        public void Agregar_PdfVO(DocumentosPDF vo) {
        Conexion conexionsql = new Conexion();
        String sql = "INSERT INTO DocumentosPDF (idPDF, NombreArchivo, PDF) VALUES(?, ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = conexionsql.estableceConexion().prepareStatement(sql);
            ps.setInt(1, vo.getCodigopdf());
            ps.setString(2, vo.getNombrepdf());
            ps.setBytes(3, vo.getArchivopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
    }

        public void Modificar_PdfVO(DocumentosPDF vo) {
            Conexion conexionsql = new Conexion();
            String sql = "UPDATE DocumentosPDF SET NombreArchivo = ?, PDF = ? WHERE idPDF = ?;";
            PreparedStatement ps = null;
            try {
                ps = conexionsql.estableceConexion().prepareStatement(sql);
                ps.setString(1, vo.getNombrepdf());
                ps.setBytes(2, vo.getArchivopdf());
                ps.setInt(3, vo.getCodigopdf());
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            } 
        }

        public void Modificar_PdfVO2(DocumentosPDF vo) {
            Conexion conexionsql = new Conexion();
            String sql = "UPDATE DocumentosPDF SET NombreArchivo = ? WHERE idPDF = ?;";
            PreparedStatement ps = null;
            try {
                ps = conexionsql.estableceConexion().prepareStatement(sql);
                ps.setString(1, vo.getNombrepdf());
                ps.setInt(2, vo.getCodigopdf());
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            } 
        }

        public void Eliminar_PdfVO(DocumentosPDF vo) {
            Conexion conexionsql = new Conexion();
            String sql = "DELETE FROM DocumentosPDF WHERE idPDF = ?;";
            PreparedStatement ps = null;
            try {
                ps = conexionsql.estableceConexion().prepareStatement(sql);
                ps.setInt(1, vo.getCodigopdf());
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            } 
        }

// Permite mostrar PDF contenido en la base de datos
        public void ejecutar_archivoPDF(int id) {
    Conexion conexionsql = new Conexion();
    PreparedStatement ps = null;
    ResultSet rs = null;
    byte[] b = null;

    try {
        ps = conexionsql.estableceConexion().prepareStatement("SELECT PDF FROM DocumentosPDF WHERE idPDF = ?;");
        ps.setInt(1, id);
        rs = ps.executeQuery();
        if (rs.next()) {
            b = rs.getBytes("PDF");

            // Guardar el archivo PDF con un nombre único
            String nombreArchivo = "archivo_" + id + ".pdf";
            OutputStream out = new FileOutputStream(nombreArchivo);
            out.write(b);

            // Abrir el archivo PDF
            Desktop.getDesktop().open(new File(nombreArchivo));

            out.close();
        } else {
            System.out.println("No se encontraron datos para el ID: " + id);
        }
    } catch (IOException | SQLException ex) {
        System.out.println("Error al abrir archivo PDF para ID " + id + ": " + ex.getMessage());
    } finally {
        try {
            if (ps != null) ps.close();
            if (rs != null) rs.close();
            //conexionsql.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
        }
    }
}


}

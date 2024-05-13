/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Funciones.Citas;
import Funciones.Conexion;
import Funciones.DocumentosPDF;
import Funciones.Expedientes;
import Funciones.Pacientes;
import TablasPDF.Tabla_PdfVO;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author Diony
 */
public class FrmMedico extends javax.swing.JFrame {

    
    Tabla_PdfVO tpdf = new Tabla_PdfVO();
    String ruta_archivo = "";
    int id = -1;
    
    public FrmMedico() {
        
        initComponents();
        Pacientes obpacientes = new Pacientes(); 
        Expedientes obExpediente = new Expedientes();
        Citas obCitas = new Citas();
        obCitas.MostarCita(TablasCitas);
        obpacientes.MostarPacientes(TBDatosDelPaciente);
        obExpediente.MostarExpediente(TablaExpedientes);
        GrupoBotonesSexo.add(JRHombre);
        GrupoBotonesSexo.add(JRMujer);
        tpdf.visualizar_PdfVO(tabla);
        activa_boton(false, false, false);
        txtname.setEnabled(false);
        PanelEditar.setVisible(false);

        
    }

    public void guardar_pdf(int codigo, String nombre, File ruta) {
    DocumentosPDF documentosPDF = new DocumentosPDF();
    DocumentosPDF po = new DocumentosPDF();
    po.setCodigopdf(codigo);
    po.setNombrepdf(nombre);
    try {
        byte[] pdf = new byte[(int) ruta.length()];
        InputStream input = new FileInputStream(ruta);
        input.read(pdf);
        po.setArchivopdf(pdf);
    } catch (IOException ex) {
        po.setArchivopdf(null);
        //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
    }
    documentosPDF.Agregar_PdfVO(po);
}

    public void modificar_pdf(int codigo, String nombre, File ruta) {
        DocumentosPDF documentosPDF = new DocumentosPDF();
        DocumentosPDF po = new DocumentosPDF();
        po.setCodigopdf(codigo);
        po.setNombrepdf(nombre);
        try {
            byte[] pdf = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(pdf);
            po.setArchivopdf(pdf);
        } catch (IOException ex) {
            po.setArchivopdf(null);
            //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
        }
        documentosPDF.Modificar_PdfVO(po);
    }

    public void modificar_pdf(int codigo, String nombre) {
        DocumentosPDF documentosPDF = new DocumentosPDF();
        DocumentosPDF po = new DocumentosPDF();
        po.setCodigopdf(codigo);
        po.setNombrepdf(nombre);
        documentosPDF.Modificar_PdfVO2(po);
    }

    public void eliminar_pdf(int codigo) {
        DocumentosPDF documentosPDF = new DocumentosPDF();
        DocumentosPDF po = new DocumentosPDF();
        po.setCodigopdf(codigo);
        documentosPDF.Eliminar_PdfVO(po);
    }

    public void seleccionar_pdf() {
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf", "pdf");
        j.setFileFilter(fi);
        int se = j.showOpenDialog(this);
        if (se == 0) {
            this.btnseleccionar.setText("" + j.getSelectedFile().getName());
            ruta_archivo = j.getSelectedFile().getAbsolutePath();
        } else {
        }
    }

    public void activa_boton(boolean a, boolean b, boolean c) {
        btnguardar.setEnabled(a);
        btnmodificar.setEnabled(b);
        btneliminar.setEnabled(c);
        txtname.setText("");
        btnseleccionar.setText("Seleccionar...");
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoBotonesSexo = new javax.swing.ButtonGroup();
        TXTSexoEdit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TXTIDExpediente = new javax.swing.JTextField();
        TxtCitas = new javax.swing.JTextField();
        Radiografias = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        BTActualizar = new javax.swing.JButton();
        BTEliminar = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        TBDatosDelPaciente = new javax.swing.JTable();
        PanelEditar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JRHombre = new javax.swing.JRadioButton();
        JRMujer = new javax.swing.JRadioButton();
        TxtIDPacientesEdit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TXTNombreEdit = new javax.swing.JTextField();
        TXTContrasenaEdit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TXTApellidEdit = new javax.swing.JTextField();
        TXTNumeroSEdit = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TXTCorreoEdit = new javax.swing.JTextField();
        TXTFechaEdit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        BTEditar = new javax.swing.JButton();
        BTEditarMostrar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        BTActualizarExpediente = new javax.swing.JButton();
        BTEliminarExpediente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaExpedientes = new javax.swing.JTable();
        BTAgregarExpediente = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablasCitas = new javax.swing.JTable();
        BTActualizarCita = new javax.swing.JButton();
        BTAgregarCita = new javax.swing.JButton();
        BTEliminarCita = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblImagenes = new javax.swing.JTable();
        txtTitulo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnseleccionar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();

        TXTSexoEdit.setEditable(false);

        jLabel5.setText("Sexo:");

        TXTIDExpediente.setEditable(false);

        TxtCitas.setEditable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Apartado Mediico");

        Radiografias.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        BTActualizar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BTActualizar.setText("Actualizar");
        BTActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTActualizarActionPerformed(evt);
            }
        });

        BTEliminar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BTEliminar.setText("Eliminar");
        BTEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTEliminarActionPerformed(evt);
            }
        });

        TBDatosDelPaciente.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        TBDatosDelPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TBDatosDelPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBDatosDelPacienteMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(TBDatosDelPaciente);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("IDPaciente:");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Sexo:");

        JRHombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JRHombre.setText("Hombre");
        JRHombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRHombreActionPerformed(evt);
            }
        });

        JRMujer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JRMujer.setText("Mujer");
        JRMujer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRMujerActionPerformed(evt);
            }
        });

        TxtIDPacientesEdit.setEditable(false);
        TxtIDPacientesEdit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        TXTNombreEdit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        TXTContrasenaEdit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Numero de seguridad:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Apellido:");

        TXTApellidEdit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        TXTNumeroSEdit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Correo:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Fecha de nacimiento:");

        TXTCorreoEdit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        TXTFechaEdit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Contraseña:");

        BTEditar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BTEditar.setText("Actualizar");
        BTEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelEditarLayout = new javax.swing.GroupLayout(PanelEditar);
        PanelEditar.setLayout(PanelEditarLayout);
        PanelEditarLayout.setHorizontalGroup(
            PanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEditarLayout.createSequentialGroup()
                .addGroup(PanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEditarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JRHombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JRMujer)
                        .addGap(18, 18, 18))
                    .addGroup(PanelEditarLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtIDPacientesEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(PanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelEditarLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTNombreEdit))
                    .addGroup(PanelEditarLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTContrasenaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEditarLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTNumeroSEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTCorreoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelEditarLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTApellidEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTFechaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(BTEditar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelEditarLayout.setVerticalGroup(
            PanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEditarLayout.createSequentialGroup()
                .addGroup(PanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEditarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TxtIDPacientesEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(TXTNombreEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(TXTApellidEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(TXTFechaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TXTContrasenaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(TXTNumeroSEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(TXTCorreoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JRHombre)
                            .addComponent(JRMujer)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)))
                    .addGroup(PanelEditarLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(BTEditar)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        BTEditarMostrar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BTEditarMostrar.setText("Editar");
        BTEditarMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTEditarMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTEditarMostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTEliminar)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane7)
                        .addContainerGap())
                    .addComponent(PanelEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTActualizar)
                    .addComponent(BTEliminar)
                    .addComponent(BTEditarMostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PanelEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        Radiografias.addTab("Pacientes", jPanel1);

        BTActualizarExpediente.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BTActualizarExpediente.setText("Actualizar");
        BTActualizarExpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTActualizarExpedienteActionPerformed(evt);
            }
        });

        BTEliminarExpediente.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BTEliminarExpediente.setText("Eliminar");
        BTEliminarExpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTEliminarExpedienteActionPerformed(evt);
            }
        });

        TablaExpedientes.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        TablaExpedientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaExpedientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaExpedientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaExpedientes);

        BTAgregarExpediente.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BTAgregarExpediente.setText("Agregar");
        BTAgregarExpediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTAgregarExpedienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(BTActualizarExpediente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTAgregarExpediente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTEliminarExpediente)
                        .addGap(18, 18, 18))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTActualizarExpediente)
                    .addComponent(BTEliminarExpediente)
                    .addComponent(BTAgregarExpediente))
                .addContainerGap(125, Short.MAX_VALUE))
        );

        Radiografias.addTab("Expedientes", jPanel4);

        TablasCitas.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        TablasCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablasCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablasCitasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TablasCitas);

        BTActualizarCita.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BTActualizarCita.setText("Actualizar");
        BTActualizarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTActualizarCitaActionPerformed(evt);
            }
        });

        BTAgregarCita.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BTAgregarCita.setText("Agregar");
        BTAgregarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTAgregarCitaActionPerformed(evt);
            }
        });

        BTEliminarCita.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        BTEliminarCita.setText("Eliminar");
        BTEliminarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTEliminarCitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(BTActualizarCita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTAgregarCita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTEliminarCita)
                        .addGap(21, 21, 21))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTActualizarCita)
                    .addComponent(BTAgregarCita)
                    .addComponent(BTEliminarCita))
                .addGap(0, 125, Short.MAX_VALUE))
        );

        Radiografias.addTab("Citas", jPanel5);

        tblImagenes.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tblImagenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblImagenes);

        jLabel12.setText("Titulo de la imagen");

        jButton1.setText("Examinar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar imagen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 436, Short.MAX_VALUE)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Radiografias.addTab("Radiografias", jPanel2);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Nombre del archivo:");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Seleccionar Archivo:");

        btnseleccionar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnseleccionar.setText("Seleccionar...");
        btnseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseleccionarActionPerformed(evt);
            }
        });

        btnnuevo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnmodificar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btneliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        txtname.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tabla.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Archivo"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnnuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnmodificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncancelar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtname, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnseleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(114, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(btnseleccionar)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnuevo)
                    .addComponent(btnguardar)
                    .addComponent(btnmodificar)
                    .addComponent(btneliminar)
                    .addComponent(btncancelar))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        Radiografias.addTab("Documentos PDF", jPanel3);

        jButton10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(153, 51, 0));
        jButton10.setText("Salir");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Radiografias)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Radiografias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        FrmPrincipal juan = new FrmPrincipal();
        juan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void BTActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTActualizarActionPerformed
        Pacientes obpacientes = new Pacientes(); 
        obpacientes.MostarPacientes(TBDatosDelPaciente);
    }//GEN-LAST:event_BTActualizarActionPerformed

    private void TBDatosDelPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBDatosDelPacienteMouseClicked
        
        Pacientes obpacientes = new Pacientes(); 
        obpacientes.SeleccionarPaciente(TBDatosDelPaciente, TxtIDPacientesEdit, TXTNombreEdit, TXTApellidEdit, TXTFechaEdit, TXTSexoEdit, TXTContrasenaEdit, TXTNumeroSEdit, TXTCorreoEdit);
        
        
    }//GEN-LAST:event_TBDatosDelPacienteMouseClicked

    private void BTEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTEditarActionPerformed
       try {
    // Validar campos
    if (TxtIDPacientesEdit.getText().isEmpty() || TXTNombreEdit.getText().isEmpty() ||
        TXTApellidEdit.getText().isEmpty() || TXTFechaEdit.getText().isEmpty() ||
        TXTSexoEdit.getText().isEmpty() || TXTContrasenaEdit.getText().isEmpty() ||
        TXTNumeroSEdit.getText().isEmpty() || TXTCorreoEdit.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
    } else if (!TXTNumeroSEdit.getText().matches("[0-9]+")) {
        JOptionPane.showMessageDialog(null, "El campo de número social solo debe contener números");
    } else {
        Pacientes obpacientes = new Pacientes(); 
        obpacientes.modificarPaciente(TxtIDPacientesEdit, TXTNombreEdit, TXTApellidEdit, TXTFechaEdit, TXTSexoEdit, TXTContrasenaEdit, TXTNumeroSEdit, TXTCorreoEdit);
        obpacientes.MostarPacientes(TBDatosDelPaciente);
    }
} catch(Exception e){
    JOptionPane.showMessageDialog(null, "Por favor selecciona una fila");
}

        
        
    }//GEN-LAST:event_BTEditarActionPerformed

    private void BTEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTEliminarActionPerformed
        try{
        Pacientes obpacientes = new Pacientes(); 
        obpacientes.EliminarPacientes(TxtIDPacientesEdit);
        obpacientes.MostarPacientes(TBDatosDelPaciente);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Porfavor selecciona una fila");
       }
    }//GEN-LAST:event_BTEliminarActionPerformed

    private void JRHombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRHombreActionPerformed
        if(JRMujer.isSelected()){          
            TXTSexoEdit.setText("Mujer");
        } else if(JRHombre.isSelected()){
            TXTSexoEdit.setText("Hombre");
        }else{
            System.out.println("no se selecciono nada");
        }
    }//GEN-LAST:event_JRHombreActionPerformed

    private void JRMujerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRMujerActionPerformed
        if(JRMujer.isSelected()){          
            TXTSexoEdit.setText("Mujer");
        } else if(JRHombre.isSelected()){
            TXTSexoEdit.setText("Hombre");
        }else{
            System.out.println("no se selecciono nada");
        }
    }//GEN-LAST:event_JRMujerActionPerformed

    private void BTActualizarExpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTActualizarExpedienteActionPerformed
        Expedientes obExpediente = new Expedientes();
        obExpediente.MostarExpediente(TablaExpedientes);
    }//GEN-LAST:event_BTActualizarExpedienteActionPerformed

    private void TablaExpedientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaExpedientesMouseClicked
        Expedientes obExpediente = new Expedientes();
        obExpediente.SeleccionarExpediente(TablaExpedientes, TXTIDExpediente);
        
    }//GEN-LAST:event_TablaExpedientesMouseClicked

    private void BTEliminarExpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTEliminarExpedienteActionPerformed
        
       try{
        Expedientes obExpediente = new Expedientes();
        obExpediente.EliminarExpediente(TXTIDExpediente);
        obExpediente.MostarExpediente(TablaExpedientes);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Porfavor selecciona una fila");
       } 
        
    }//GEN-LAST:event_BTEliminarExpedienteActionPerformed

    private void BTAgregarExpedienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTAgregarExpedienteActionPerformed
        FrmAgregarExpediente juan = new FrmAgregarExpediente();
        juan.setVisible(true);
        
    }//GEN-LAST:event_BTAgregarExpedienteActionPerformed

    private void btnseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseleccionarActionPerformed
        seleccionar_pdf();
    }//GEN-LAST:event_btnseleccionarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        activa_boton(true, false, false);
        txtname.setEnabled(true);
        ruta_archivo = "";
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        String nombre = txtname.getText();
        Conexion conexionsql = new Conexion();
        int codigo = 0;
        try {
            PreparedStatement ps = conexionsql.estableceConexion().prepareStatement("SELECT MAX(idPDF) FROM DocumentosPDF;");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                codigo = rs.getInt(1) + 1; // Incrementamos el valor obtenido en 1
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        File ruta = new File(ruta_archivo);
        if (nombre.trim().length() != 0 && ruta_archivo.trim().length() != 0) {
            guardar_pdf(codigo, nombre, ruta);
            tpdf.visualizar_PdfVO(tabla);
            ruta_archivo = "";
            activa_boton(false, false, false);
            txtname.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Rellenar todo los campos");
        }

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        String nombre = txtname.getText();
        File ruta = new File(ruta_archivo);
        if (nombre.trim().length() != 0 && ruta_archivo.trim().length() != 0) {
            modificar_pdf(id, nombre, ruta);
            tpdf.visualizar_PdfVO(tabla);
        } else if (ruta_archivo.trim().length() == 0) {
            modificar_pdf(id, nombre);
            tpdf.visualizar_PdfVO(tabla);
        }
        ruta_archivo = "";
        activa_boton(false, false, false);
        txtname.setEnabled(false);
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminar_pdf(id);
        tpdf.visualizar_PdfVO(tabla);
        activa_boton(false, false, false);
        txtname.setEnabled(false);
        ruta_archivo = "";
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        activa_boton(false, false, false);
        ruta_archivo = "";
        txtname.setEnabled(false);
    }//GEN-LAST:event_btncancelarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int column = tabla.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tabla.getRowHeight();
        activa_boton(false, true, true);
        txtname.setEnabled(true);
        if (row < tabla.getRowCount() && row >= 0 && column < tabla.getColumnCount() && column >= 0) {
            id = (int) tabla.getValueAt(row, 0);
            Object value = tabla.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getText().equals("Vacio")) {
                    JOptionPane.showMessageDialog(null, "No hay archivo");
                } else {
                    DocumentosPDF documentosPDF = new DocumentosPDF();
                    documentosPDF.ejecutar_archivoPDF(id);
                    try {
                        Desktop.getDesktop().open(new File("new.pdf"));
                    } catch (Exception ex) {
                    }
                }

            } else {
                String name = "" + tabla.getValueAt(row, 1);
                txtname.setText(name);
            }
        }

    }//GEN-LAST:event_tablaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        fileChooser.setFileFilter(extensionFilter);

        /*if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            Ruta = fileChooser.getSelectedFile().getAbsolutePath();
            Image mImagen = new ImageIcon(Ruta).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), 0));
            lblImagen.setIcon(mIcono);
        }*/
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        /*ImagenAlmacen mImagen = new ImagenAlmacen();
        if (mBD.conectar()) {
            mImagen.setTitulo(txtTitulo.getText().trim());
            mImagen.setImagen(getImagen(Ruta));
            mBD.AgregarImagen(mImagen);
            Limpiar();
            CargarImagenes();
        }*/
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BTEditarMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTEditarMostrarActionPerformed
        PanelEditar.setVisible(true);
    }//GEN-LAST:event_BTEditarMostrarActionPerformed

    private void TablasCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablasCitasMouseClicked
             
        Citas obCitas = new Citas();
        obCitas.SeleccionarExpediente(TablasCitas, TxtCitas);
        
    }//GEN-LAST:event_TablasCitasMouseClicked

    private void BTEliminarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTEliminarCitaActionPerformed
        ///
        try{
        Citas obCitas = new Citas(); 
        obCitas.EliminarCita(TxtCitas);
        obCitas.MostarCita(TablasCitas);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Porfavor selecciona una fila");
       }
        
    }//GEN-LAST:event_BTEliminarCitaActionPerformed

    private void BTAgregarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTAgregarCitaActionPerformed
        FrmAgregarCita juan = new FrmAgregarCita();
        juan.setVisible(true);
    }//GEN-LAST:event_BTAgregarCitaActionPerformed

    private void BTActualizarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTActualizarCitaActionPerformed
        
        Citas obExpediente = new Citas();
        obExpediente.MostarCita(TablasCitas);
        
    }//GEN-LAST:event_BTActualizarCitaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTActualizar;
    private javax.swing.JButton BTActualizarCita;
    private javax.swing.JButton BTActualizarExpediente;
    private javax.swing.JButton BTAgregarCita;
    private javax.swing.JButton BTAgregarExpediente;
    private javax.swing.JButton BTEditar;
    private javax.swing.JButton BTEditarMostrar;
    private javax.swing.JButton BTEliminar;
    private javax.swing.JButton BTEliminarCita;
    private javax.swing.JButton BTEliminarExpediente;
    private javax.swing.ButtonGroup GrupoBotonesSexo;
    private javax.swing.JRadioButton JRHombre;
    private javax.swing.JRadioButton JRMujer;
    private javax.swing.JPanel PanelEditar;
    private javax.swing.JTabbedPane Radiografias;
    private javax.swing.JTable TBDatosDelPaciente;
    private javax.swing.JTextField TXTApellidEdit;
    private javax.swing.JTextField TXTContrasenaEdit;
    private javax.swing.JTextField TXTCorreoEdit;
    private javax.swing.JTextField TXTFechaEdit;
    private javax.swing.JTextField TXTIDExpediente;
    private javax.swing.JTextField TXTNombreEdit;
    private javax.swing.JTextField TXTNumeroSEdit;
    private javax.swing.JTextField TXTSexoEdit;
    private javax.swing.JTable TablaExpedientes;
    private javax.swing.JTable TablasCitas;
    private javax.swing.JTextField TxtCitas;
    private javax.swing.JTextField TxtIDPacientesEdit;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnseleccionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tblImagenes;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}

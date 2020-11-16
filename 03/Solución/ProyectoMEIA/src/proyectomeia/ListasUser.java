package proyectomeia;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectomeia.Clases.ObjectIndice;
import proyectomeia.Clases.ObjectLista;
import proyectomeia.Clases.Singleton;
import proyectomeia.Clases.UsuarioIndexado;

public class ListasUser extends javax.swing.JFrame {

    public ListasUser() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }

    public ListasUser(Singleton object) {
        this();
        fase = object;
        btnEditarL.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCdesc.setEnabled(false);
        jTextArea1.setEnabled(false);
        btncancel.setEnabled(false);
        btnBuser.setEnabled(false);
        btnauser.setEnabled(false);
        btnEliminarUsuario.setEnabled(false);
        btnBual.setEnabled(false);
        btnCdua.setEnabled(false);
        jTextArea4.setEnabled(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    fase.ListaUsuarios.EliminacionLogicaAlCerrar(fase.current.getUsername().trim());
                } catch (IOException ex) {
                    Logger.getLogger(UserView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private Singleton fase;
    private ObjectLista working;
    private String addUser;
    private String addList;
    private String User;
    private String list;
    private String lista;
    private String Uasociado;
    private String Euasociado;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCrearlista = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNlista = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtBlistaa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnBlistaa = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtBuser = new javax.swing.JTextField();
        btnBuser = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        btnauser = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnBusqueda = new javax.swing.JButton();
        btnEditarL = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnCdesc = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btncancel = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtUsuarioEliminar = new javax.swing.JTextField();
        btnEliminarUsuario = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnBusered = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtBlmod = new javax.swing.JTextField();
        btnBleu = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtUAb = new javax.swing.JTextField();
        btnBual = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        btnCdua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("Crear Lista");

        btnCrearlista.setText("Crear");
        btnCrearlista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearlistaActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre Lista");

        jLabel3.setText("Descripción");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1)
                            .addComponent(txtNlista)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(btnCrearlista)))
                .addContainerGap(255, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNlista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrearlista)
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Crear", jPanel1);

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setText("AGREGAR USUARIO A UNA LISTA");

        jLabel9.setText("Buscar Lista");

        btnBlistaa.setText("Buscar");
        btnBlistaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlistaaActionPerformed(evt);
            }
        });

        jLabel10.setText("Buscar Usuario a Asociar");

        btnBuser.setText("Buscar");
        btnBuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuserActionPerformed(evt);
            }
        });

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane4.setViewportView(jTextArea3);

        btnauser.setText("Agregar");
        btnauser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnauserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtBlistaa, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnBlistaa)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtBuser, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuser)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(btnauser)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBlistaa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBlistaa)
                    .addComponent(txtBuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuser))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnauser)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Agregar", jPanel3);

        jLabel4.setText("Buscar Lista");

        btnBusqueda.setText("Buscar");
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
            }
        });

        btnEditarL.setText("Editar Lista");
        btnEditarL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarLActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar Lista");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel6.setText("Descripción");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        btnCdesc.setText("Cambiar");
        btnCdesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCdescActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel7.setText("Antigua");

        jLabel8.setText("Nueva");

        btncancel.setText("Cancelar");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });

        jLabel11.setText("EDITAR UNA LISTA");

        btnEliminarUsuario.setText("Eliminar usuario lista");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        jLabel12.setText("Buscar Usuario");

        btnBusered.setText("Buscar");
        btnBusered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuseredActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(160, 160, 160)
                                .addComponent(jLabel11)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtUsuarioEliminar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnBusqueda)
                                        .addGap(42, 42, 42)
                                        .addComponent(btnEditarL)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminar))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnBusered)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(btnEliminarUsuario))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                                .addComponent(btncancel))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnCdesc)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBusqueda)
                            .addComponent(btnEditarL)
                            .addComponent(btnEliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnEliminarUsuario)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btncancel)
                                .addGap(5, 5, 5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnBusered)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsuarioEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(btnCdesc)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Acciones", jPanel2);

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel13.setText("EDITAR DESCRIPCIÓN USUARIO");

        jLabel14.setText("Buscar Lista");

        btnBleu.setText("Buscar");
        btnBleu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBleuActionPerformed(evt);
            }
        });

        jLabel15.setText("Buscar Usuario Asociado");

        btnBual.setText("Buscar");
        btnBual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBualActionPerformed(evt);
            }
        });

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane5.setViewportView(jTextArea4);

        jLabel16.setText("Antigua");

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane6.setViewportView(jTextArea5);

        jLabel17.setText("Nueva");

        btnCdua.setText("Cambiar");
        btnCdua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCduaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(172, 172, 172)
                                .addComponent(jLabel13))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtUAb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(txtBlmod, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBleu)
                                    .addComponent(btnBual)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCdua)))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel13))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBlmod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBleu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUAb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCdua, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Editar U.", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearlistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearlistaActionPerformed

        String Nombre = txtNlista.getText().toString();
        String Descripcion = txtDescripcion.getText().toString();
        if (!Nombre.isEmpty()) {
            if (Nombre.length() <= 30) {
                if (!Descripcion.isEmpty()) {
                    if (Descripcion.length() <= 40) {
                        if (!fase.Listas.masterfileLista.exists() && !fase.Listas.bitacora.masterfile.exists()) {
                            ObjectLista nueva = new ObjectLista(Nombre, Descripcion);
                            nueva.setUsuario(fase.current.getUsername());
                            try {
                                fase.Listas.Insertar(nueva.toString());
                                fase.Listas.bitacora.updateAutor(fase.current.getUsername());
                                txtNlista.setText("");
                                txtDescripcion.setText("");
                                JOptionPane.showMessageDialog(null, fase.current.getUsername().trim() + " " + "agrego la lista:" + " " + Nombre);
                            } catch (IOException ex) {
                                Logger.getLogger(ListasUser.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else if (fase.Listas.bitacora.masterfile.exists()) {
                            List<String> res = fase.Listas.bitacora.Busqueda(Nombre + "|" + fase.current.getUsername());
                            if (res.isEmpty()) {
                                if (!fase.Listas.masterfileLista.exists()) {
                                    ObjectLista nueva = new ObjectLista(Nombre, Descripcion);
                                    nueva.setUsuario(fase.current.getUsername());
                                    try {
                                        fase.Listas.Insertar(nueva.toString());
                                        if (fase.Listas.flag) {
                                            fase.Listas.updateAutorMod(fase.current.getUsername());
                                        }
                                        txtNlista.setText("");
                                        txtDescripcion.setText("");
                                        JOptionPane.showMessageDialog(null, fase.current.getUsername().trim() + " " + "agrego la lista:" + " " + Nombre);
                                    } catch (IOException ex) {
                                        Logger.getLogger(ListasUser.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                } else {
                                    try {
                                        String busqueda = fase.Listas.Buscar(Nombre + "|" + fase.current.getUsername());
                                        if (busqueda.isEmpty() || busqueda.trim().equals("")) {
                                            ObjectLista nueva = new ObjectLista(Nombre, Descripcion);
                                            nueva.setUsuario(fase.current.getUsername());
                                            fase.Listas.Insertar(nueva.toString());
                                            if (fase.Listas.flag) {
                                                fase.Listas.updateAutorMod(fase.current.getUsername());
                                            }
                                            txtNlista.setText("");
                                            txtDescripcion.setText("");
                                            JOptionPane.showMessageDialog(null, fase.current.getUsername().trim() + " " + "agrego la lista:" + " " + Nombre);
                                        } else if (busqueda.split("\\|")[busqueda.split("\\|").length - 1].equals("1")) {
                                            JOptionPane.showMessageDialog(null, fase.current.getUsername().trim() + " " + "ya posee una lista con nombre:" + " " + Nombre);
                                        } else {
                                            ObjectLista nueva = new ObjectLista(Nombre, Descripcion);
                                            nueva.setUsuario(fase.current.getUsername());
                                            fase.Listas.Insertar(nueva.toString());
                                            if (fase.Listas.flag) {
                                                fase.Listas.updateAutorMod(fase.current.getUsername());
                                            }
                                            txtNlista.setText("");
                                            txtDescripcion.setText("");
                                            JOptionPane.showMessageDialog(null, fase.current.getUsername().trim() + " " + "agrego la lista:" + " " + Nombre);

                                        }
                                    } catch (IOException ex) {
                                        Logger.getLogger(ListasUser.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }

                            } else {
                                int counter = 0;
                                for (int i = 0; i < res.size(); i++) {
                                    String r = res.get(i);
                                    if (r.split("\\|")[r.split("\\|").length - 1].equals("0")) {
                                        counter++;
                                    }
                                }
                                if (counter == res.size()) {
                                    ObjectLista nueva = new ObjectLista(Nombre, Descripcion);
                                    nueva.setUsuario(fase.current.getUsername());
                                    try {
                                        fase.Listas.Insertar(nueva.toString());
                                        txtNlista.setText("");
                                        txtDescripcion.setText("");
                                        JOptionPane.showMessageDialog(null, fase.current.getUsername().trim() + " " + "agrego la lista:" + " " + Nombre);
                                    } catch (IOException ex) {
                                        Logger.getLogger(ListasUser.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(null, fase.current.getUsername().trim() + " " + "ya posee una lista con nombre:" + " " + Nombre);
                                }
                            }
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "La descripción debe ser máximo de 40 caracteres");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La descripción no puede ser vacía");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El nombre debe ser máximo de 30 caracteres");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío");
        }
    }//GEN-LAST:event_btnCrearlistaActionPerformed

    private void btnEditarLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarLActionPerformed
        btnEditarL.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCdesc.setEnabled(true);
        jTextArea1.setEnabled(true);
        btncancel.setEnabled(true);
    }//GEN-LAST:event_btnEditarLActionPerformed

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        String listaAbuscar = txtBusqueda.getText() + "|" + fase.current.getUsername().trim();
        if (!fase.Listas.masterfileLista.exists() && !fase.Listas.bitacora.masterfile.exists()) {
            JOptionPane.showMessageDialog(null, fase.current.getUsername().trim() + " " + "no posee una lista con ese nombre");

        } else if (fase.Listas.bitacora.masterfile.exists()) {
            List<String> resultado = fase.Listas.bitacora.Busqueda(listaAbuscar);
            if (resultado.isEmpty()) {
                if (!fase.Listas.masterfileLista.exists()) {
                    JOptionPane.showMessageDialog(null, fase.current.getUsername().trim() + " " + "no posee una lista con ese nombre");
                } else {
                    try {
                        String busqueda = fase.Listas.Buscar(listaAbuscar);
                        if (busqueda.isEmpty() || busqueda.equals("")) {
                            JOptionPane.showMessageDialog(null, fase.current.getUsername().trim() + " " + "no posee una lista con ese nombre");
                        } else if (busqueda.split("\\|")[busqueda.split("\\|").length - 1].equals("1")) {
                            ObjectLista encontrado = new ObjectLista();
                            encontrado.CreateFromString(busqueda);
                            jTextArea2.setText(encontrado.getDescripcion());
                            jTextArea2.setEnabled(false);
                            list = txtBusqueda.getText();
                            JOptionPane.showMessageDialog(null, "Se encontró la lista:" + encontrado.getNombre_lista().trim() + " " + "que pertenece al usuario:"
                                    + encontrado.getUsuario().trim());
                            working = encontrado;
                            btnEditarL.setEnabled(true);
                            btnEliminar.setEnabled(true);
                            txtBusqueda.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, fase.current.getUsername().trim() + " " + "no posee una lista con ese nombre");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ListasUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } else {
                int counter = 0;
                for (int i = 0; i < resultado.size(); i++) {
                    String r = resultado.get(i);
                    if (r.split("\\|")[r.split("\\|").length - 1].equals("0")) {
                        counter++;
                    }
                }
                if (counter == resultado.size()) {
                    JOptionPane.showMessageDialog(null, fase.current.getUsername().trim() + " " + "no posee una lista con ese nombre");
                } else {
                    ObjectLista encontrado = new ObjectLista();
                    String linea;
                    for (int j = 0; j < resultado.size(); j++) {
                        linea = resultado.get(j);
                        if (linea.split("\\|")[linea.split("\\|").length - 1].equals("1")) {
                            encontrado.CreateFromString(linea);
                            break;
                        }
                    }
                    jTextArea2.setText(encontrado.getDescripcion());
                    jTextArea2.setEnabled(false);
                    list = txtBusqueda.getText();
                    JOptionPane.showMessageDialog(null, "Se encontró la lista:" + encontrado.getNombre_lista().trim() + " " + "que pertenece al usuario:"
                            + encontrado.getUsuario().trim());
                    working = encontrado;
                    btnEditarL.setEnabled(true);
                    btnEliminar.setEnabled(true);
                    txtBusqueda.setText("");
                }
            }

        }
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void btnCdescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCdescActionPerformed
        String nuevadesc = jTextArea1.getText();
        if (nuevadesc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese una nueva descripción, si desea");
        } else {
            if (nuevadesc.equals(working.getDescripcion().trim())) {
                JOptionPane.showMessageDialog(null, "Ingresó la misma descripción");
            } else {
                try {
                    ObjectLista nuevo = new ObjectLista();
                    nuevo.CreateFromString(working.toString());
                    nuevo.setDescripcion(nuevadesc);
                    fase.Listas.Modificar(nuevo.toString(), working.toString());
                    JOptionPane.showMessageDialog(null, "Se cambió la descripción de la lista:" + nuevo.getNombre_lista().trim());
                    btnEditarL.setEnabled(false);
                    btnEliminar.setEnabled(false);
                    btnBusqueda.setEnabled(true);
                    jTextArea1.setEnabled(false);
                    btncancel.setEnabled(false);
                    jTextArea1.setText("");
                    jTextArea2.setText("");
                    btnCdesc.setEnabled(false);

                } catch (IOException ex) {
                    Logger.getLogger(ListasUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnCdescActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            String anterior = fase.ExistsList(list + "|" + fase.current.getUsername().trim());
            ObjectLista last = new ObjectLista();
            last.CreateFromString(anterior);
            fase.ListaUsuarios.EliminarEnEjecucion(last.getNombre_lista(), last.getUsuario());
            last.setNumero_usuarios(0);
            last.setEstatus(false);
            fase.Listas.Modificar(last.toString(), anterior);
            btnEditarL.setEnabled(false);
            btnEliminar.setEnabled(false);
            btnBusqueda.setEnabled(true);
            working = null;
            JOptionPane.showMessageDialog(null, "Se eliminó la lista:" + last.getNombre_lista().trim());
            jTextArea1.setText("");
            jTextArea2.setText("");
        } catch (IOException ex) {
            Logger.getLogger(ListasUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        btnEditarL.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnBusqueda.setEnabled(true);
        btncancel.setEnabled(false);
        jTextArea1.setText("");
        jTextArea2.setText("");
        jTextArea1.setEnabled(false);
        btnCdesc.setEnabled(false);

    }//GEN-LAST:event_btncancelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UserView view = new UserView(fase);
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBlistaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlistaaActionPerformed
        String blist = txtBlistaa.getText();
        if (blist.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor escriba la lista a la que desea agregar un usuario");
        } else {
            boolean exists = fase.ExistsLista(blist + "|" + fase.current.getUsername());
            if (exists) {
                addList = blist;
                btnBlistaa.setEnabled(false);
                txtBlistaa.setText("");
                btnBuser.setEnabled(true);
                txtBuser.setText("");
                JOptionPane.showMessageDialog(null, blist + " " + "si existe");
            } else {
                JOptionPane.showMessageDialog(null, blist + " " + "no existe");
            }
        }
    }//GEN-LAST:event_btnBlistaaActionPerformed

    private void btnBuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuserActionPerformed
        String buser = txtBuser.getText();
        if (buser.isEmpty() || buser.equals(fase.current.getUsername().trim())) {
            JOptionPane.showMessageDialog(null, "Por favor escriba el usuario que desea agregar || no puede agregarse a una lista");
        } else {
            boolean exists = fase.ExistsUser(buser);
            if (exists) {
                addUser = buser;
                txtBlistaa.setText("");
                btnBuser.setEnabled(false);
                txtBuser.setText("");
                btnauser.setEnabled(true);
                jTextArea3.setText("");
                JOptionPane.showMessageDialog(null, buser + " " + "si existe");
            } else {
                JOptionPane.showMessageDialog(null, buser + " " + "no existe");
            }
        }
    }//GEN-LAST:event_btnBuserActionPerformed

    private void btnauserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnauserActionPerformed

        String desc = jTextArea3.getText();
        if (desc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor agregue una descripción para el usuario");
        } else {
            if (desc.length() <= 40) {
                try {

                    ObjectIndice nuevo = new ObjectIndice(addList, fase.current.getUsername().trim(), addUser);
                    boolean exists = fase.ListaUsuarios.existeUsuario(nuevo.toString());
                    if (!exists) {
                        fase.ListaUsuarios.InsertarIndice(nuevo.toString());
                        UsuarioIndexado newi = new UsuarioIndexado(addList, fase.current.getUsername().trim(), addUser, desc);
                        fase.ListaUsuarios.InsertarLista(newi.toString());
                        String anterior = fase.ExistsList(addList + "|" + fase.current.getUsername().trim());
                        ObjectLista last = new ObjectLista();
                        last.CreateFromString(anterior);
                        int cantidad = last.getNumero_usuarios();
                        cantidad++;
                        ObjectLista nueva = new ObjectLista();
                        nueva.CreateFromString(anterior);
                        nueva.setNumero_usuarios(cantidad);
                        fase.Listas.Modificar(nueva.toString(), last.toString());
                        if (fase.ListaUsuarios.flag) {
                            fase.ListaUsuarios.CrearDescriptorLista(fase.current.getUsername());
                        } else {
                            fase.ListaUsuarios.UpdateDescriptorLista(fase.current.getUsername());
                        }
                        btnauser.setEnabled(false);
                        btnBlistaa.setEnabled(true);
                        jTextArea3.setText("");
                        JOptionPane.showMessageDialog(null, "El usuario:" + fase.current.getUsername().trim() + " " + "agregó a:" + addUser + " "
                                + "a su lista:" + addList);
                    } else {
                        JOptionPane.showMessageDialog(null, "El usuario:" + fase.current.getUsername().trim() + " " + "ya tiene asociado a:" + addUser + " "
                                + "en su lista:" + addList);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ListasUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "La descripción debe ser máximo de 40 caracteres");
            }
        }
    }//GEN-LAST:event_btnauserActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        try {

            fase.ListaUsuarios.EliminarUsuarioLista(list, fase.current.getUsername().trim(), User);
            JOptionPane.showMessageDialog(null, "El usuario:" + txtUsuarioEliminar.getText() + " " + "ya no esta asociado a:" + fase.current.getUsername() + " "
                    + "en su lista:" + addList);
            String anterior = fase.ExistsList(list + "|" + fase.current.getUsername().trim());
            ObjectLista last = new ObjectLista();
            last.CreateFromString(anterior);
            int cantidad = last.getNumero_usuarios();
            cantidad--;
            ObjectLista nueva = new ObjectLista();
            nueva.CreateFromString(anterior);
            nueva.setNumero_usuarios(cantidad);
            fase.Listas.Modificar(nueva.toString(), last.toString());

            btnEliminarUsuario.setEnabled(false);
        } catch (IOException ex) {
            Logger.getLogger(ListasUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnBuseredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuseredActionPerformed
        User = txtUsuarioEliminar.getText();
        if (User.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese Un usuario");
            btnEliminarUsuario.setEnabled(false);
        } else if (User.equals(fase.current.getUsername().trim())) {
            JOptionPane.showMessageDialog(null, "Usted no se encuentra en su propia lista");
            btnEliminarUsuario.setEnabled(false);
        } else if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe buscar primero la lista donde se encuentra el usuario");
            btnEliminarUsuario.setEnabled(false);
        } else {
            boolean exists = fase.ExistsUser(User);
            if (exists) {
                try {
                    ObjectIndice mbe = new ObjectIndice(list, fase.current.getUsername().trim(), User);
                    boolean verify = fase.ListaUsuarios.existeUsuario(mbe.toString());
                    if (verify) {
                        JOptionPane.showMessageDialog(null, "El Usuario se encuentra en la lista indicada");
                        btnEliminarUsuario.setEnabled(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe ese usuario en la lista:" + list);
                        btnEliminarUsuario.setEnabled(false);
                    }

                } catch (IOException ex) {
                    Logger.getLogger(ListasUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {

            }
        }
    }//GEN-LAST:event_btnBuseredActionPerformed

    private void btnBleuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBleuActionPerformed
        lista = txtBlmod.getText();
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre de la lista donde se encuentra el usuario");
        } else {
            boolean verify = fase.ExistsLista(lista + "|" + fase.current.getUsername().trim());
            if (verify) {
                btnBual.setEnabled(true);
                txtBlmod.setText("");
                txtUAb.setText("");
                btnBleu.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Lista Encontrada");
            } else {
                JOptionPane.showMessageDialog(null, "Lista No encontrada");
            }
        }
    }//GEN-LAST:event_btnBleuActionPerformed

    private void btnBualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBualActionPerformed
        Uasociado = txtUAb.getText();
        if (Uasociado.isEmpty()) {

        } else {
            try {
                ObjectIndice ind = new ObjectIndice(lista, fase.current.getUsername().trim(), Uasociado);
                boolean verify = fase.ListaUsuarios.existeUsuario(ind.toString());
                if (verify) {
                    JOptionPane.showMessageDialog(null, "El Usuario se encuentra en la lista indicada");
                    btnCdua.setEnabled(true);
                    btnBual.setEnabled(false);
                    jTextArea5.setText("");
                    String f = fase.ListaUsuarios.Busqueda(ind.toString());
                    ind.CreateFromString(f);
                    String position = ind.getPosicion();
                    Euasociado = fase.ListaUsuarios.Blista_Usuario(position);
                    UsuarioIndexado i = new UsuarioIndexado();
                    i.CreateFromString(Euasociado);
                    jTextArea4.setText(i.getDescripcion().trim());

                } else {
                    JOptionPane.showMessageDialog(null, "No existe ese usuario en la lista:" + list);
                }
            } catch (IOException ex) {
                Logger.getLogger(ListasUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBualActionPerformed

    private void btnCduaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCduaActionPerformed
        String ndesc = jTextArea5.getText();
        if (ndesc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Escriba una descripción");
        } else {
            try {
                UsuarioIndexado nuevo = new UsuarioIndexado();
                nuevo.CreateFromString(Euasociado);
                nuevo.setDescripcion(ndesc);
                fase.ListaUsuarios.ModLista(Euasociado, nuevo.toString());
                JOptionPane.showMessageDialog(null, "Se cambió la descripción del usuario:" + nuevo.getUsuarioAsociado().trim() + " " + System.lineSeparator()
                        + "de la lista:" + nuevo.getNombreLista().trim());
            } catch (IOException ex) {
                Logger.getLogger(ListasUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCduaActionPerformed

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
            java.util.logging.Logger.getLogger(ListasUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListasUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListasUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListasUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListasUser().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBleu;
    private javax.swing.JButton btnBlistaa;
    private javax.swing.JButton btnBual;
    private javax.swing.JButton btnBuser;
    private javax.swing.JButton btnBusered;
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnCdesc;
    private javax.swing.JButton btnCdua;
    private javax.swing.JButton btnCrearlista;
    private javax.swing.JButton btnEditarL;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnauser;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextField txtBlistaa;
    private javax.swing.JTextField txtBlmod;
    private javax.swing.JTextField txtBuser;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNlista;
    private javax.swing.JTextField txtUAb;
    private javax.swing.JTextField txtUsuarioEliminar;
    // End of variables declaration//GEN-END:variables
}
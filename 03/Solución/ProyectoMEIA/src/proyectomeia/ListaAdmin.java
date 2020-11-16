package proyectomeia;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectomeia.Clases.ObjectLista;
import proyectomeia.Clases.Singleton;

public class ListaAdmin extends javax.swing.JFrame {

    public ListaAdmin() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }

    public ListaAdmin(Singleton object) {
        this();
        fase = object;
        jInternalFrame1.setVisible(false);
        jInternalFrame4.setVisible(false);
        btnBLE.setEnabled(false);
        txtLE.setEnabled(false);
        btnEL.setEnabled(false);
        btnElL.setEnabled(false);
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
    private String User;
    private String Uowner;
    private String Lowned;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNlistad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNdesc = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btncan = new javax.swing.JButton();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        labelTituloc = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtBuser = new javax.swing.JTextField();
        btnBuser = new javax.swing.JButton();
        btnregresar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jLabel3 = new javax.swing.JLabel();
        txtUE = new javax.swing.JTextField();
        btnUE = new javax.swing.JButton();
        btnEL = new javax.swing.JButton();
        btnElL = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtLE = new javax.swing.JTextField();
        btnBLE = new javax.swing.JButton();
        jInternalFrame4 = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        Label6 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCambiardesc = new javax.swing.JButton();
        btnCE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("USUARIO: ");

        jLabel4.setText("Nombre Lista");

        txtNdesc.setColumns(20);
        txtNdesc.setRows(5);
        jScrollPane1.setViewportView(txtNdesc);

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel5.setText("Descripción");

        btncan.setText("cancelar");
        btncan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNlistad, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(btncan)
                        .addGap(1, 1, 1))))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNlistad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(btncan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jInternalFrame2.setVisible(true);

        labelTituloc.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        labelTituloc.setText("CREAR LISTA A USUARIO");

        jLabel1.setFont(new java.awt.Font("sansserif", 2, 14)); // NOI18N
        jLabel1.setText("Búsqueda");

        txtBuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuserActionPerformed(evt);
            }
        });

        btnBuser.setText("Buscar");
        btnBuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuserActionPerformed(evt);
            }
        });

        btnregresar.setText("regresar");
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(labelTituloc))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                                .addComponent(txtBuser, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuser)))))
                .addContainerGap(109, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnregresar))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addComponent(btnregresar)
                .addGap(12, 12, 12)
                .addComponent(labelTituloc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuser))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame2)
            .addComponent(jInternalFrame1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jInternalFrame1))
        );

        jTabbedPane1.addTab("Crear ", jPanel1);

        jInternalFrame3.setVisible(true);

        jLabel3.setFont(new java.awt.Font("sansserif", 2, 14)); // NOI18N
        jLabel3.setText("Búsqueda usuario Propietario");

        btnUE.setText("Buscar");
        btnUE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUEActionPerformed(evt);
            }
        });

        btnEL.setText("Editar");
        btnEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnELActionPerformed(evt);
            }
        });

        btnElL.setText("Eliminar");
        btnElL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElLActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("sansserif", 2, 14)); // NOI18N
        jLabel8.setText("Busqueda Lista");

        btnBLE.setText("Buscar");
        btnBLE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBLEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUE, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)))
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLE, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jInternalFrame3Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(83, 83, 83))
                        .addComponent(btnBLE, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElL, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUE)
                    .addComponent(btnBLE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame3Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(btnEL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnElL)
                .addGap(52, 52, 52))
        );

        jInternalFrame4.setVisible(true);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        Label6.setText("Antigua");

        jLabel6.setText("Nueva");

        jLabel7.setFont(new java.awt.Font("sansserif", 2, 14)); // NOI18N
        jLabel7.setText("DESCRIPCIÓN");

        btnCambiardesc.setText("Cambiar");
        btnCambiardesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiardescActionPerformed(evt);
            }
        });

        btnCE.setText("Cancelar");
        btnCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCE))
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Label6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jInternalFrame4Layout.createSequentialGroup()
                                .addGap(205, 205, 205)
                                .addComponent(btnCambiardesc)))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame4Layout.createSequentialGroup()
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addComponent(btnCE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label6)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(btnCambiardesc))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame3)
            .addComponent(jInternalFrame4)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jInternalFrame4))
        );

        jTabbedPane1.addTab("Edición", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtNlistad.getText().isEmpty() || txtNdesc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
        } else {
            String abuscar = txtNlistad.getText() + "|" + User;
            boolean exists = fase.ExistsLista(abuscar);
            if (exists) {
                JOptionPane.showMessageDialog(null, User + " " + "ya cuenta con una lista:" + txtNlistad.getText());
            } else {
                ObjectLista nuevo = new ObjectLista(txtNlistad.getText(), txtNdesc.getText());
                nuevo.setUsuario(User);
                try {
                    fase.Listas.Insertar(nuevo.toString());
                    if (fase.Listas.flag) {
                        fase.Listas.updateAutorMod(fase.current.getUsername());
                    }
                    JOptionPane.showMessageDialog(null, User + " " + "ahora cuenta con la lista:" + txtNlistad.getText());
                    txtNlistad.setText("");
                    txtNdesc.setText("");
                    txtBuser.setText("");
                    jInternalFrame2.setVisible(true);
                    jInternalFrame1.setVisible(false);
                } catch (IOException ex) {
                    Logger.getLogger(ListaAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuserActionPerformed

    private void btnBuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuserActionPerformed
        jInternalFrame2.setVisible(false);
        String user = txtBuser.getText();
        if (user.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un Usuario");
        } else {
            boolean exists = fase.ExistsUser(user);
            if (exists) {
                jInternalFrame1.setVisible(true);
                User = user;
                JOptionPane.showMessageDialog(null, "usuario encontrado" + " " + "puede crear una lista");
            } else {
                jInternalFrame2.setVisible(true);
                JOptionPane.showMessageDialog(null, "usuario no encontrado" + " " + " no puede crear una lista");
            }
        }
    }//GEN-LAST:event_btnBuserActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        MenuCambios menu = new MenuCambios(fase);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnregresarActionPerformed

    private void btncanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncanActionPerformed
        jInternalFrame1.setVisible(false);
        jInternalFrame2.setVisible(true);
        txtNlistad.setText("");
        txtNdesc.setText("");
        txtBuser.setText("");
    }//GEN-LAST:event_btncanActionPerformed

    private void btnUEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUEActionPerformed
        String ubuscar = txtUE.getText();
        if (ubuscar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ingrese el usuario a buscar");
            txtUE.setText("");
        } else {
            boolean exists = fase.ExistsUser(ubuscar);
            if (exists) {
                Uowner = ubuscar;
                btnBLE.setEnabled(true);
                txtLE.setEnabled(true);
                btnUE.setEnabled(false);
                txtUE.setEnabled(false);
                txtUE.setText("");
                JOptionPane.showMessageDialog(null, "usuario:" + Uowner + " " + "encontrado");

            } else {
                JOptionPane.showMessageDialog(null, "usuario no encontrado");
                txtUE.setText("");
            }
        }
    }//GEN-LAST:event_btnUEActionPerformed

    private void btnBLEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBLEActionPerformed
        String Lbuscar = txtLE.getText() + "|" + Uowner;
        if (Lbuscar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ingrese la lista a buscar");
            txtLE.setText("");
        } else {
            boolean exists = fase.ExistsLista(Lbuscar);
            if (exists) {
                Lowned = fase.ExistsList(Lbuscar);
                JOptionPane.showMessageDialog(null, " El usuario:" + Uowner + " " + "posee la lista:" + txtLE.getText());
                btnBLE.setEnabled(false);
                txtLE.setEnabled(false);
                btnEL.setEnabled(true);
                btnElL.setEnabled(true);
                txtLE.setText("");
            } else {
                txtLE.setText("");
                JOptionPane.showMessageDialog(null, "Lista no encontrada");
            }
        }
    }//GEN-LAST:event_btnBLEActionPerformed

    private void btnELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnELActionPerformed
        jInternalFrame3.setVisible(false);
        jInternalFrame4.setVisible(true);
        btnUE.setEnabled(true);
        txtUE.setEnabled(true);
        btnEL.setEnabled(false);
        btnElL.setEnabled(false);
        ObjectLista lista = new ObjectLista();
        lista.CreateFromString(Lowned);
        jTextArea1.setEnabled(false);
        jTextArea1.setText(lista.getDescripcion().trim());
    }//GEN-LAST:event_btnELActionPerformed

    private void btnCambiardescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiardescActionPerformed
        ObjectLista lista = new ObjectLista();
        lista.CreateFromString(Lowned);
        String Ndesc = jTextArea2.getText();
        if (Ndesc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese la nueva descripción");
        } else if (Ndesc.equals(jTextArea1.getText().trim())) {
            JOptionPane.showMessageDialog(null, "La descripción ingresada es igual a la descripción antigua");
        } else {
            try {
                ObjectLista nueva = new ObjectLista();
                nueva.CreateFromString(Lowned);
                nueva.setDescripcion(Ndesc);
                fase.Listas.Modificar(nueva.toString(), lista.toString());
                Uowner = "";
                Lowned = "";
                jTextArea1.setText("");
                jTextArea2.setText("");
                jInternalFrame3.setVisible(true);
                jInternalFrame4.setVisible(false);
                JOptionPane.showMessageDialog(null, "Se modificó la descripción de la lista:" + nueva.getNombre_lista().trim()
                        + System.lineSeparator() + "Propiedad de:" + nueva.getUsuario().trim());

            } catch (IOException ex) {
                Logger.getLogger(ListaAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCambiardescActionPerformed

    private void btnCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCEActionPerformed
        jInternalFrame3.setVisible(true);
        jInternalFrame4.setVisible(false);
    }//GEN-LAST:event_btnCEActionPerformed

    private void btnElLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElLActionPerformed

        try {

            fase.ListaUsuarios.EliminarUsuarioLista(txtLE.getText(), fase.current.getUsername().trim(), txtUE.getText());
            JOptionPane.showMessageDialog(null, "El usuario:" + txtUE.getText() + " " + "ya no esta asociado a:" + fase.current.getUsername() + " "
                    + "en su lista:" + txtLE.getText());
        } catch (IOException ex) {
            Logger.getLogger(ListasUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnElLActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label6;
    private javax.swing.JButton btnBLE;
    private javax.swing.JButton btnBuser;
    private javax.swing.JButton btnCE;
    private javax.swing.JButton btnCambiardesc;
    private javax.swing.JButton btnEL;
    private javax.swing.JButton btnElL;
    private javax.swing.JButton btnUE;
    private javax.swing.JButton btncan;
    private javax.swing.JButton btnregresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel labelTituloc;
    private javax.swing.JTextField txtBuser;
    private javax.swing.JTextField txtLE;
    private javax.swing.JTextArea txtNdesc;
    private javax.swing.JTextField txtNlistad;
    private javax.swing.JTextField txtUE;
    // End of variables declaration//GEN-END:variables
}
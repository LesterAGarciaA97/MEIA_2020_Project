package proyectomeia;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import proyectomeia.Clases.NodoBinario;
import proyectomeia.Clases.ObjectIndice;
import proyectomeia.Clases.Singleton;
import proyectomeia.Clases.UsuarioIndexado;

public class NuevoMensaje extends javax.swing.JFrame {

    public NuevoMensaje() {
        initComponents();
    }

    public NuevoMensaje(Singleton objeto) {
        this();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
        fase = objeto;
        jRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jComboBox1.removeAllItems();

                try {
                    users = fase.getUsers();
                    for (int i = 0; i < users.size(); i++) {
                        jComboBox1.addItem(users.get(i));
                    }
                } catch (IOException ex) {
                    Logger.getLogger(NuevoMensaje.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(NuevoMensaje.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jRadioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jComboBox1.removeAllItems();
                try {
                    lists = fase.Lists(fase.current.getUsername().trim());
                    for (int i = 0; i < lists.size(); i++) {
                        jComboBox1.addItem(lists.get(i));
                    }
                } catch (IOException ex) {
                    Logger.getLogger(NuevoMensaje.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private Singleton fase;
    private List<String> users;
    private List<String> lists;
    private String pathAdjuntado = "";
    private static final String pathadjunto = Paths.get("C:/MEIA/Adjuntos").toString();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtAlocal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnAdlocal = new javax.swing.JButton();
        btnElocal = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 411, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("", jPanel2);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Un Usuario");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Lista de Distribución");

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel1.setText("Asunto:");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("Mensaje");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        btnAdlocal.setText("Adjuntar");
        btnAdlocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdlocalActionPerformed(evt);
            }
        });

        btnElocal.setText("Enviar");
        btnElocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElocalActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jLabel7.setText("Modo de Envio");

        jLabel8.setText("Selección:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(40, 40, 40)
                        .addComponent(jRadioButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtAlocal, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnElocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdlocal, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(btncancelar, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)))
                    .addComponent(btncancelar))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAlocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdlocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnElocal, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Local", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        BandejaSalida bandeja = new BandejaSalida(fase);
        this.dispose();
        bandeja.setVisible(true);
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnElocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElocalActionPerformed
        String asunto = txtAlocal.getText();
        if (asunto.isEmpty()) {
            int dialogbutton = JOptionPane.YES_NO_OPTION;
            dialogbutton = JOptionPane.showConfirmDialog(null, "Está seguro de enviar el mensaje sin asunto", "Aclaración", dialogbutton);
            if (dialogbutton == JOptionPane.YES_OPTION) {
                String mensaje = jTextArea1.getText();
                if (!mensaje.isEmpty() || !pathAdjuntado.isEmpty()) {
                    if (jRadioButton1.isSelected()) {
                        try {
                            // un usuario
                            String usuarioR = String.valueOf(jComboBox1.getSelectedItem());
                            NodoBinario nuevo = new NodoBinario(fase.current.getUsername().trim(), usuarioR, asunto, mensaje, pathAdjuntado);
                            fase.arbol.Insertar(nuevo);
                            txtAlocal.setText("");
                            jTextArea1.setText("");
                            pathAdjuntado = "";
                            fase.arbol.CrearDescriptor();
                            JOptionPane.showMessageDialog(null, "Mensaje enviado a:" + usuarioR);
                        } catch (IOException ex) {
                            Logger.getLogger(NuevoMensaje.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (jRadioButton2.isSelected()) {
                        try {
                            // lista de distribución
                            String lista = String.valueOf(jComboBox1.getSelectedItem());
                            ObjectIndice ind = new ObjectIndice(lista, fase.current.getUsername().trim(), "");
                            List<String> temp = fase.ListaUsuarios.BusuariosLista(ind.toString());
                            List<String> users = new ArrayList<>();
                            for (int i = 0; i < temp.size(); i++) {
                                ObjectIndice nuevo = new ObjectIndice();
                                nuevo.CreateFromString(temp.get(i));
                                UsuarioIndexado user = new UsuarioIndexado();
                                user.CreateFromString(fase.ListaUsuarios.Blista_Usuario(nuevo.getPosicion().trim()));
                                users.add(user.getUsuarioAsociado().trim());
                            }
                            for (String user : users) {
                                fase.arbol.Insertar(new NodoBinario(fase.current.getUsername().trim(), user, asunto, mensaje, pathAdjuntado));
                                fase.arbol.CrearDescriptor();
                            }
                            JOptionPane.showMessageDialog(null, "Mensaje enviado a la lista:" + lista);
                            txtAlocal.setText("");
                            jTextArea1.setText("");
                            pathAdjuntado = "";

                        } catch (IOException ex) {
                            Logger.getLogger(NuevoMensaje.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Agregue el mensaje a enviar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Agregue un asunto");
            }
        } else {
            String mensaje = jTextArea1.getText();
            if (!mensaje.isEmpty()) {
                if (jRadioButton1.isSelected()) { // un usuario
                    try {
                        // un usuario
                        String usuarioR = String.valueOf(jComboBox1.getSelectedItem());
                        NodoBinario nuevo = new NodoBinario(fase.current.getUsername().trim(), usuarioR, asunto, mensaje, pathAdjuntado);
                        fase.arbol.Insertar(nuevo);
                        txtAlocal.setText("");
                        jTextArea1.setText("");
                        pathAdjuntado = "";
                        fase.arbol.CrearDescriptor();
                        JOptionPane.showMessageDialog(null, "Mensaje enviado a:" + usuarioR);
                    } catch (IOException ex) {
                        Logger.getLogger(NuevoMensaje.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (jRadioButton2.isSelected()) {
                    try {
                        // lista de distribución
                        String lista = String.valueOf(jComboBox1.getSelectedItem());
                        ObjectIndice ind = new ObjectIndice(lista, fase.current.getUsername().trim(), "");
                        List<String> temp = fase.ListaUsuarios.BusuariosLista(ind.toString());
                        List<String> users_ = new ArrayList<>();
                        for (int i = 0; i < temp.size(); i++) {
                            ObjectIndice nuevo = new ObjectIndice();
                            nuevo.CreateFromString(temp.get(i));
                            UsuarioIndexado user = new UsuarioIndexado();
                            user.CreateFromString(fase.ListaUsuarios.Blista_Usuario(nuevo.getPosicion().trim()));
                            users_.add(user.getUsuarioAsociado().trim());
                        }
                        for (String user : users_) {
                            fase.arbol.Insertar(new NodoBinario(fase.current.getUsername().trim(), user, asunto, mensaje, pathAdjuntado));
                            fase.arbol.CrearDescriptor();
                        }
                        JOptionPane.showMessageDialog(null, "Mensaje enviado a la lista:" + lista);
                        txtAlocal.setText("");
                        jTextArea1.setText("");
                        pathAdjuntado = "";
                    } catch (IOException ex) {
                        Logger.getLogger(NuevoMensaje.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Agregue el mensaje a enviar");
            }

        }
    }//GEN-LAST:event_btnElocalActionPerformed

    private void btnAdlocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdlocalActionPerformed
        JFileChooser chooser = new JFileChooser();
        int returnval = chooser.showOpenDialog(null);
        if (returnval == JFileChooser.APPROVE_OPTION) {
            try {
                File directory = new File(pathadjunto);
                if (!directory.exists()) {
                    directory.mkdir();
                }
                File selectedFile = chooser.getSelectedFile();
                pathAdjuntado = directory.getPath() + "\\" + selectedFile.getName();
                if (!new File(pathAdjuntado).exists()) {
                    Files.copy(selectedFile.toPath(), Paths.get(pathAdjuntado));
                }
            } catch (IOException ex) {
                Logger.getLogger(NuevoMensaje.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_btnAdlocalActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(NuevoMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoMensaje().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdlocal;
    private javax.swing.JButton btnElocal;
    private javax.swing.JButton btncancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtAlocal;
    // End of variables declaration//GEN-END:variables
}
package proyectomeia;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import proyectomeia.Clases.NodoBinario;
import proyectomeia.Clases.Singleton;

public class BandejaEntrada extends javax.swing.JFrame {

    public BandejaEntrada() {
        initComponents();
    }
    private Singleton fase;
    private ArrayList<String> recibidos;
    private String adjuntopath;
    private int position;
    DefaultListModel model;

    public BandejaEntrada(Singleton object_) {
        this();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
        fase = object_;
        txtAentrada.setEditable(false);
        txtMensajeentrada.setEditable(false);
        btnAdjunto.setEnabled(false);
        try {

            recibidos = fase.arbol.BusquedaBandejaEntrada(fase.current.getUsername().trim());
            model = new DefaultListModel();
            recibidos.forEach((recibido) -> {
                NodoBinario temp = new NodoBinario();
                temp.CreateFromString(recibido);
                model.addElement(temp.getUsuarioEmisor().trim() + "|" + temp.getFechaTransaccion());
            });
            jList2.setModel(model);

            jList2.addListSelectionListener((ListSelectionEvent e) -> {
                position = jList2.getSelectedIndex();
                NodoBinario selection = new NodoBinario();
                selection.CreateFromString(recibidos.get(position));
                txtAentrada.setText(selection.getAsunto().trim());
                txtMensajeentrada.setText(selection.getMensaje().trim());
                if (selection.getAdjunto().trim().equals("null")) {
                    btnAdjunto.setEnabled(false);
                } else {
                    btnAdjunto.setEnabled(true);
                    adjuntopath = selection.getAdjunto().trim();
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(BandejaEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtAentrada = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMensajeentrada = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAdjunto = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        btnEliminarEntrada = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtMensajeentrada.setColumns(20);
        txtMensajeentrada.setRows(5);
        jScrollPane2.setViewportView(txtMensajeentrada);

        jLabel1.setText("Asunto:");

        jLabel2.setFont(new java.awt.Font("sansserif", 2, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BANDEJA DE ENTRADA");

        jLabel3.setText("MENSAJE");

        jLabel4.setFont(new java.awt.Font("sansserif", 2, 12)); // NOI18N
        jLabel4.setText("Usuario Emisor | Fecha");

        btnAdjunto.setText("Ver Adjunto");
        btnAdjunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdjuntoActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(jList2);

        btnEliminarEntrada.setText("Eliminar");
        btnEliminarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEntradaActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(btnRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAdjunto)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(btnEliminarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(166, 166, 166))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(btnRegresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAentrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnAdjunto))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarEntrada))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        UserView view = new UserView(fase);
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEliminarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEntradaActionPerformed
        try {
            String temp = model.getElementAt(position).toString();
            String aEliminar = recibidos.get(position);
            if (temp.contains("||E")) {
                NodoBinario selection = new NodoBinario();
                selection.CreateFromString(aEliminar);
                fase.arbol.Eliminar(selection);
                fase.arbol.CrearDescriptor();
                recibidos = fase.arbol.BusquedaBandejaEntrada(fase.current.getUsername().trim());
                int num = Integer.valueOf(position);
                temp = temp + "||E";
                model.setElementAt(temp, num);
                JOptionPane.showMessageDialog(null, "Correo eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Este correo ya está eliminado");
            }
        } catch (IOException ex) {
            Logger.getLogger(BandejaEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarEntradaActionPerformed

    private void btnAdjuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdjuntoActionPerformed
        String opened = recibidos.get(position);
        NodoBinario temp = new NodoBinario();
        temp.CreateFromString(opened);
        File file = new File(temp.getAdjunto().trim());
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                try {
                    desktop.open(file);
                } catch (IOException ex) {
                    Logger.getLogger(BandejaEntrada.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnAdjuntoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BandejaEntrada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdjunto;
    private javax.swing.JButton btnEliminarEntrada;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtAentrada;
    private javax.swing.JTextArea txtMensajeentrada;
    // End of variables declaration//GEN-END:variables
}
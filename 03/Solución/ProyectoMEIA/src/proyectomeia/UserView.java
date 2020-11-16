package proyectomeia;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import proyectomeia.Clases.Singleton;

public class UserView extends javax.swing.JFrame {

    public UserView() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }

    public UserView(Singleton datos) {
        this();
        this.fase = datos;
        String t1 = labelUsuario.getText();
        t1 = t1 + " " + fase.current.getUsername();
        labelUsuario.setText(t1);
        t1 = "";
        t1 = labelRol.getText();
        if (fase.current.isRol() == true) {
            t1 = t1 + " " + "Administrador";
        } else {
            t1 = t1 + " " + "Usuario Normal";
        }
        labelRol.setText(t1);
        imgIcon.setIcon(new ImageIcon(new ImageIcon(fase.current.getPath_fotografía()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        imgIcon.setText("");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    fase.Usuarios.refactorBitacora();
                } catch (IOException ex) {
                    Logger.getLogger(UserView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    private Singleton fase;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        labelRol = new javax.swing.JLabel();
        imgIcon = new javax.swing.JLabel();
        opcionesButton = new javax.swing.JButton();
        btnListas = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        bbentrada = new javax.swing.JButton();
        bsalida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTitulo.setFont(new java.awt.Font("sansserif", 3, 18)); // NOI18N
        labelTitulo.setText("INFORMACIÓN");

        labelUsuario.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelUsuario.setText("Usuario:");

        labelRol.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        labelRol.setText("Rol:");

        imgIcon.setText("-----");

        opcionesButton.setText("Opciones");
        opcionesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionesButtonActionPerformed(evt);
            }
        });

        btnListas.setText("Listas");
        btnListas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListasActionPerformed(evt);
            }
        });

        logout.setText("Cerrar Sesión");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        bbentrada.setText("Bandeja de Entrada ");
        bbentrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbentradaActionPerformed(evt);
            }
        });

        bsalida.setText("Bandeja de Salida");
        bsalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsalidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(opcionesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imgIcon)
                            .addComponent(labelTitulo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(bbentrada)
                        .addGap(38, 38, 38)
                        .addComponent(bsalida))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUsuario)
                            .addComponent(labelRol))))
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logout))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logout)
                .addGap(3, 3, 3)
                .addComponent(labelTitulo)
                .addGap(10, 10, 10)
                .addComponent(labelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelRol)
                .addGap(25, 25, 25)
                .addComponent(imgIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bbentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bsalida, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListas)
                    .addComponent(opcionesButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcionesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionesButtonActionPerformed
        MenuCambios menu = new MenuCambios(fase);
        menu.show();
        this.dispose();
    }//GEN-LAST:event_opcionesButtonActionPerformed

    private void btnListasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListasActionPerformed
        ListasUser lists = new ListasUser(fase);
        lists.show();
        this.dispose();
    }//GEN-LAST:event_btnListasActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        try {
            fase.arbol.ReorganizarArbol();
        } catch (IOException ex) {
            Logger.getLogger(UserView.class.getName()).log(Level.SEVERE, null, ex);
        }
        fase.current = null;
        Inicio start = new Inicio(fase);
        this.dispose();
        start.setVisible(true);

    }//GEN-LAST:event_logoutActionPerformed

    private void bsalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsalidaActionPerformed
        BandejaSalida bandeja = new BandejaSalida(fase);
        this.dispose();
        bandeja.setVisible(true);
    }//GEN-LAST:event_bsalidaActionPerformed

    private void bbentradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbentradaActionPerformed
        BandejaEntrada bandeja = new BandejaEntrada(fase);
        this.dispose();
        bandeja.show();
    }//GEN-LAST:event_bbentradaActionPerformed

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
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbentrada;
    private javax.swing.JButton bsalida;
    private javax.swing.JButton btnListas;
    private javax.swing.JLabel imgIcon;
    private javax.swing.JLabel labelRol;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JButton logout;
    private javax.swing.JButton opcionesButton;
    // End of variables declaration//GEN-END:variables
}
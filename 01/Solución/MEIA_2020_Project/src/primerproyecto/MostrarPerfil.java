package primerproyecto;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static primerproyecto.Metodos.listadoNombresUsuario;

public class MostrarPerfil extends javax.swing.JFrame {

    File archivo;
    byte[] imagen;
    FileInputStream entrada;
    FileOutputStream salida;
    boolean condicion;

    public MostrarPerfil() {
        initComponents();
        String ruta3 = "C:/MEIA/UsuarioActual.txt";
        Metodos m = new Metodos();
        ArrayList<String> Usuarios3 = new ArrayList<>();
        Usuarios3 = listadoNombresUsuario(new File(ruta3));
        String usuario = Usuarios3.get(0);
        archivo = new File(ObtenerRuta());
        imagen = AbrirArchivo(archivo);
        ImageIcon image = new ImageIcon(imagen);
        Icon icono = new ImageIcon(image.getImage().getScaledInstance(lblmostrar.getWidth(), lblmostrar.getHeight(), Image.SCALE_DEFAULT));
        lblmostrar.setIcon(icono);
        this.repaint();
        lblBienvenida.setText("Bienvenido " + usuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblmostrar = new javax.swing.JLabel();
        lblBienvenida = new javax.swing.JLabel();
        btn_Salir = new javax.swing.JButton();
        btn_CerrarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_MantenimientoUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuario");

        lblmostrar.setBorder(new javax.swing.border.MatteBorder(null));

        lblBienvenida.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N

        btn_Salir.setText("Cerrar Aplicacion");
        btn_Salir.setActionCommand("");
        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalirActionPerformed(evt);
            }
        });

        btn_CerrarSesion.setText("Cerra Sesion");
        btn_CerrarSesion.setActionCommand("");
        btn_CerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CerrarSesionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        jLabel1.setText("Rol: Usuario");

        btn_MantenimientoUsuario.setText("Mantenimiento Usuario");
        btn_MantenimientoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MantenimientoUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lblmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblBienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btn_MantenimientoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_CerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblmostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_CerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_MantenimientoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        Metodos m = new Metodos();
        m.RegistroFinal();
        m.BitacoraSistema();
        m.BitacoraUsuario();
        System.exit(0);
    }//GEN-LAST:event_btn_SalirActionPerformed

    public String ObtenerRuta() {
        String ruta = "C:/MEIA/usuario.txt";
        String ruta2 = "C:/MEIA/bitacora_usuario.txt";
        String ruta3 = "C:/MEIA/UsuarioActual.txt";
        String rutaMensaje = "";
        Metodos m = new Metodos();

        if (new File(ruta).exists()) {
            ArrayList<String> Usuarios = new ArrayList<>();
            Usuarios = listadoNombresUsuario(new File(ruta2));

            ArrayList<String> Usuarios2 = new ArrayList<>();
            Usuarios2 = listadoNombresUsuario(new File(ruta));

            ArrayList<String> Usuarios3 = new ArrayList<>();
            Usuarios3 = listadoNombresUsuario(new File(ruta3));
            String usuario = Usuarios3.get(0);

            for (String s : Usuarios) {
                Usuarios2.add(s);
            }

            for (int i = 0; i < Usuarios2.size(); i++) {
                String[] Split = Usuarios2.get(i).split("\\|");
                if (Objects.equals(usuario, Split[0])) {
                    rutaMensaje = Split[8];
                    break;
                }
            }
        }
        if (!new File(ruta).exists()) {
            ArrayList<String> Usuarios = new ArrayList<>();
            Usuarios = listadoNombresUsuario(new File(ruta2));

            ArrayList<String> Usuarios3 = new ArrayList<>();
            Usuarios3 = listadoNombresUsuario(new File(ruta3));
            String usuario = Usuarios3.get(0);

            for (int i = 0; i < Usuarios.size(); i++) {
                String[] Split = Usuarios.get(i).split("\\|");
                if (Objects.equals(usuario, Split[0])) {
                    rutaMensaje = Split[8];
                    break;
                }
            }
        }
        return rutaMensaje;
    }
    private void btn_CerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CerrarSesionActionPerformed
        try {
            Inicio inicio = new Inicio();
            inicio.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(MostrarPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_CerrarSesionActionPerformed

    private void btn_MantenimientoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MantenimientoUsuarioActionPerformed
        MantenimientoUsuario mantenimiento = new MantenimientoUsuario();
        mantenimiento.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_MantenimientoUsuarioActionPerformed

    public byte[] AbrirArchivo(File archivo) {
        byte[] imagen = new byte[1024 * 100];
        try {
            entrada = new FileInputStream(archivo);
            entrada.read(imagen);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imagen;
    }

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
            java.util.logging.Logger.getLogger(MostrarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CerrarSesion;
    private javax.swing.JButton btn_MantenimientoUsuario;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblmostrar;
    // End of variables declaration//GEN-END:variables
}
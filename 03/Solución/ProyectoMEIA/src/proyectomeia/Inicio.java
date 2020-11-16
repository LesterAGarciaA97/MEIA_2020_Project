package proyectomeia;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectomeia.Clases.Singleton;
import proyectomeia.Clases.Usuario;

public class Inicio extends javax.swing.JFrame {

    //ruta archivo de usuarios
    public static final String pathArchivoApilo = Paths.get("C:/MEIA/bitacora_usuarios.txt").toString();
    public static final String pathArchivoUsuarios = Paths.get("C:/MEIA/usuarios.txt").toString();

    public static final String pathIndice = Paths.get("C:/MEIA/Indice.txt").toString();
    public static final String pathDescIndice = Paths.get("C:/MEIA/desc_Indice.txt").toString();
    public static final String pathLista = Paths.get("C:/MEIA/Lista_usuario.txt").toString();
    public static final String pathDescLista = Paths.get("C:/MEIA/desc_Lista_usuario.txt").toString();
    public static final String pathCorreos = Paths.get("C:/MEIA/correos.txt").toString();
    public static final String pathDescCorreos = Paths.get("C:/MEIA/desc_correos.txt").toString();

    public Inicio() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
    }

    public Inicio(Singleton datos) {
        this();
        fase = datos;
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

        tituloMain = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log In");
        setBackground(new java.awt.Color(153, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        setForeground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(350, 200));

        tituloMain.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tituloMain.setText("CORREO");

        txtUser.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Contraseña:");

        btnLogin.setBackground(new java.awt.Color(255, 204, 51));
        btnLogin.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(102, 102, 102));
        btnLogin.setText("Ingresar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tituloMain)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(tituloMain)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        File temp1 = new File(pathArchivoApilo);
        File temp2 = new File(pathArchivoUsuarios);
        if (!temp1.exists() && !temp2.exists()) {
            CreateUser newuser = new CreateUser(fase, 0);
            newuser.show();
            this.dispose();
            JOptionPane.showMessageDialog(null, "Usuario no encontrado, por favor cree uno");
        } else if (temp1.exists()) {
            List<String> exists = fase.Usuarios.bitacora.Busqueda(txtUser.getText());
            if (!exists.isEmpty()) {
                Usuario actual = new Usuario();
                String line = "";
                for (int i = 0; i < exists.size(); i++) {
                    line = exists.get(i);
                    if (!line.contains("/0")) {
                        line = line;
                    } else {
                        line = "";
                    }

                }
                try {
                    actual.CreatefromString(line);
                    String pass = actual.getPassword().trim();
                    if (pass.equals(new String(txtPassword.getPassword())) && actual.getStatus() == true) {
                        JOptionPane.showMessageDialog(null, "Bienvenido:" + actual.getUsername());
                        fase.current = actual;
                        UserView view = new UserView(fase);
                        view.show();
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta o usuario deshabilitado");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (!temp2.exists()) {
                CreateUser newuser = new CreateUser(fase, 1);
                newuser.show();
                this.dispose();
                JOptionPane.showMessageDialog(null, "Usuario no encontrado, por favor cree uno");

            } else {
                String busqueda = fase.Usuarios.Buscar(txtUser.getText());
                if (!busqueda.isEmpty()) {
                    Usuario actual = new Usuario();
                    try {
                        actual.CreatefromString(busqueda);
                        String pass_ = actual.getPassword().trim();
                        if (pass_.equals(new String(txtPassword.getPassword())) && actual.getStatus() == true) {
                            JOptionPane.showMessageDialog(null, "Bienvenido:" + actual.getUsername());
                            fase.current = actual;
                            UserView view = new UserView(fase);
                            view.show();
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Contraseña incorrecta o usuario deshabilitado");
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    CreateUser newuser = new CreateUser(fase, 1);
                    newuser.show();
                    this.dispose();
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado, por favor cree uno");
                }
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel tituloMain;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

}
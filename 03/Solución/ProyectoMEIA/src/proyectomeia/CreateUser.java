package proyectomeia;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import proyectomeia.Clases.Singleton;
import proyectomeia.Clases.Usuario;

public class CreateUser extends javax.swing.JFrame {

    private static int registros = 0;

    public CreateUser() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
        txtruta.setText("");
        txtPassword.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLabel(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLabel(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLabel(e);
            }

            private void updateLabel(DocumentEvent e) {

                if (registros == 1) {
                    jProgressBar1.setValue(1);
                } else if (registros == 2) {

                    jProgressBar1.setValue(2);
                } else if (registros == 3) {
                    jProgressBar1.setValue(3);
                } else if (registros == 4) {
                    jProgressBar1.setValue(4);
                } else {
                    jProgressBar1.setValue(0);
                }
            }

        });

    }

    public CreateUser(Singleton datos, int code) {
        this();
        fase = datos;
        this.code = code;
    }
    private Singleton fase;
    private int code;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNewuser = new javax.swing.JLabel();
        txtnewPass = new javax.swing.JLabel();
        txtvalidatePass = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtValidatePass = new javax.swing.JPasswordField();
        btnRegistrar = new javax.swing.JButton();
        txtnameNU = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtdbNU = new javax.swing.JLabel();
        txtemailNU = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        txtnumberNU = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        txtppicNU = new javax.swing.JLabel();
        buttonpPicNU = new javax.swing.JButton();
        buttonviewPass = new javax.swing.JToggleButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        labelapellido = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        txtruta = new javax.swing.JLabel();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crear usuario");
        setLocation(new java.awt.Point(350, 200));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("     Crear Usuario");

        txtNewuser.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtNewuser.setText("Usuario:");

        txtnewPass.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtnewPass.setText("Contraseña:");

        txtvalidatePass.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtvalidatePass.setText("Confirmar Contraseña.");

        txtUser.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        txtValidatePass.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        btnRegistrar.setBackground(new java.awt.Color(153, 153, 153));
        btnRegistrar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnRegistrar.setText("Crear");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        txtnameNU.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtnameNU.setText("Nombre:");

        txtName.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        txtdbNU.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtdbNU.setText("Fecha de nacimiento:");

        txtemailNU.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtemailNU.setText("Correo Alterno:");

        txtMail.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        txtnumberNU.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtnumberNU.setText("Teléfono:");

        txtPhoneNumber.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        txtppicNU.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtppicNU.setText("Ruta Fotografía:");

        buttonpPicNU.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        buttonpPicNU.setText("Seleccionar");
        buttonpPicNU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonpPicNUActionPerformed(evt);
            }
        });

        buttonviewPass.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        buttonviewPass.setText("ver");
        buttonviewPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonviewPassActionPerformed(evt);
            }
        });

        labelapellido.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labelapellido.setText("Apellido:");

        txtapellido.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        txtruta.setText("Ruta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtemailNU)
                            .addComponent(txtnumberNU)
                            .addComponent(txtppicNU))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonpPicNU, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdbNU)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtvalidatePass, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtnewPass)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPassword)
                                    .addComponent(txtValidatePass, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(buttonviewPass))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(datePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(69, 69, 69))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNewuser)
                                .addComponent(txtnameNU)
                                .addComponent(labelapellido))
                            .addGap(73, 73, 73)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(txtruta))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNewuser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnameNU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelapellido)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnewPass)
                    .addComponent(buttonviewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValidatePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvalidatePass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdbNU)
                    .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtemailNU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnumberNU)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtppicNU)
                    .addComponent(buttonpPicNU))
                .addGap(18, 18, 18)
                .addComponent(txtruta)
                .addGap(11, 11, 11)
                .addComponent(btnRegistrar)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonpPicNUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonpPicNUActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG", "jpeg", "jpg", "png");
        File imagen;

        chooser.setFileFilter(filter);
        int valor = chooser.showOpenDialog(this);
        if (valor == JFileChooser.APPROVE_OPTION) {
            imagen = chooser.getSelectedFile();
            txtruta.setText(imagen.getPath());
        }

    }//GEN-LAST:event_buttonpPicNUActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (!txtUser.getText().isEmpty() && txtUser.getText().length() <= 20) {
            if ((!txtName.getText().isEmpty() && txtName.getText().length() <= 30) && (!txtapellido.getText().isEmpty() && txtapellido.getText().length() <= 30)) {
                if (onlyLetters(txtName.getText()) && onlyLetters(txtapellido.getText())) {
                    if (txtPassword.getPassword().length >= 6) {
                        if (txtValidatePass.getPassword().length > 0) {
                            if (Arrays.equals(txtValidatePass.getPassword(), txtPassword.getPassword())) {
                                if (StrongEnoughPass(txtPassword.getPassword())) {
                                    JOptionPane.showMessageDialog(null, "Su contraseña es suficientemente segura");
                                    if (!datePicker1.getText().isEmpty()) {
                                        String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
                                        Pattern pattern = Pattern.compile(regex);
                                        Matcher matcher = pattern.matcher(txtMail.getText());
                                        if (matcher.matches()) {
                                            if (onlyNumbers(txtPhoneNumber.getText()) && txtPhoneNumber.getText().length() == 8) {
                                                if (!txtruta.getText().isEmpty()) {
                                                    Usuario nuevo = new Usuario();
                                                    nuevo.setUsername(txtUser.getText());
                                                    nuevo.setNombre(txtName.getText());
                                                    nuevo.setApellido(txtapellido.getText());
                                                    nuevo.setPassword(new String(txtPassword.getPassword()));
                                                    nuevo.setFecha_nacimiento(datePicker1.getText());
                                                    nuevo.setCorreo_alterno(txtMail.getText());
                                                    nuevo.setTelefono(Integer.parseInt(txtPhoneNumber.getText()));
                                                    nuevo.setPath_fotografía(txtruta.getText());
                                                    nuevo.setStatus(true);
                                                    if (code == 0) {
                                                        nuevo.setRol(true);
                                                        try {
                                                            fase.Usuarios.bitacora.updateAutor(nuevo.getUsername());
                                                            fase.Usuarios.updateAutor(nuevo.getUsername());
                                                            fase.Listas.updateAutor(nuevo.getUsername());
                                                        } catch (IOException ex) {
                                                            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
                                                        }
                                                    } else {
                                                        nuevo.setRol(false);
                                                    }
                                                    try {
                                                        fase.Usuarios.Insertar(nuevo.toString());
                                                        if (fase.Usuarios.flag == true) {
                                                            fase.Usuarios.updateAutorMod(fase.current.getUsername());
                                                        }
                                                    } catch (IOException ex) {
                                                        Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
                                                    }
                                                    if (code == 0 || code == 1) {
                                                        fase.current = nuevo;
                                                        Inicio continuacion = new Inicio(fase);
                                                        continuacion.show();
                                                        this.dispose();
                                                    } else {
                                                        MenuCambios menu = new MenuCambios(fase);
                                                        menu.show();
                                                        this.dispose();
                                                    }

                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Seleccione una imagen");
                                                }

                                            } else {
                                                JOptionPane.showMessageDialog(null, "Ingrese sólo numeros en el número de teléfono-Deben ser 8 dígitos");
                                            }

                                        } else {
                                            JOptionPane.showMessageDialog(null, "El formato del correo no es valido");
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Eliga su fecha de nacimiento");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Su contraseña no es suficientemente segura");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Vuelva a ingresar su contraseña");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Su contraseña debe tener mínimo 6 caracteres");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese sólo letras en su nombre/apellido");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Ingrese su nombre/apellido" + "-" + "Tamaño máximo: 30 caracteres");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un usuario" + "-" + "Tamaño máximo: 20 caracteres");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void buttonviewPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonviewPassActionPerformed
        if (buttonviewPass.isSelected()) {
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_buttonviewPassActionPerformed
    private boolean StrongEnoughPass(char[] password) {
        String pass = new String(password);
        int puntuacion;
        String especiales = "/¿?%$#";
        String[] puntuacionArray = new String[]{"3", "2", "1", "2", "4", "6", "3"};
        puntuacion = Integer.parseInt(puntuacionArray[0]) * pass.length();
        ArrayList<String> contadorMayus = new ArrayList<>();
        for (int i = 0; i < pass.length(); i++) {
            if ((Integer.valueOf(pass.charAt(i)) > 64) && (Integer.valueOf(pass.charAt(i)) < 91)) {
                contadorMayus.add(String.valueOf(pass.charAt(i)));
            }
        }
        puntuacion = puntuacion + (Integer.valueOf(puntuacionArray[1]) * contadorMayus.size());
        int counter = 0;
        for (int i = 0; i < pass.length(); i++) {
            if ((!especiales.contains(String.valueOf(pass.charAt(i)))) || Isnumber(String.valueOf(pass.charAt(i))) == false) {
                counter++;
            }

        }
        puntuacion = puntuacion + (counter + Integer.valueOf(puntuacionArray[2]));
        counter = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (Isnumber(String.valueOf(pass.charAt(i)))) {
                counter++;
            }
        }
        puntuacion = puntuacion + (counter + Integer.valueOf(puntuacionArray[3]));
        counter = 0;
        for (int i = 0; i < pass.length(); i++) {
            if (especiales.contains(String.valueOf(pass.charAt(i)))) {
                counter++;
            }
        }
        puntuacion = puntuacion + counter * (pass.length() + Integer.parseInt(puntuacionArray[4]));
        if (counter == 0) {
            if (onlyNumbers(pass) == true) {
                puntuacion = puntuacion - Integer.parseInt(puntuacionArray[6]);
            } else if (onlyLetters(pass) == true) {
                puntuacion = puntuacion - Integer.parseInt(puntuacionArray[5]);
            }
        }
        int seguridad = SecurityCode(puntuacion);
        registros = seguridad;
        if (seguridad >= 3) {
            return true;
        } else {
            return false;
        }

    }

    private boolean Isnumber(String counter) {
        try {
            Integer.parseInt(counter);
        } catch (Exception e) {
            return false;

        }
        return true;
    }

    private boolean onlyNumbers(String cadena) {
        int c = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (Isnumber(String.valueOf(cadena.charAt(i)))) {
                c++;
            }
        }
        if (c == cadena.length()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean onlyLetters(String cadena) {
        int c = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (Character.isLetter(cadena.charAt(i)) == true) {
                c++;
            }
        }
        if (c == cadena.length()) {
            return true;
        } else {
            return false;
        }
    }

    private int SecurityCode(int puntuacion) {
        String[] resultado = new String[]{"0", "25", "26", "35", "36", "50", "51", "100"};

        if (puntuacion > Integer.parseInt(resultado[0]) && puntuacion <= Integer.valueOf(resultado[1])) {
            return 1;
        } else if (puntuacion > Integer.parseInt(resultado[2]) && puntuacion <= Integer.valueOf(resultado[3])) {
            return 2;
        } else if (puntuacion > Integer.parseInt(resultado[4]) && puntuacion <= Integer.valueOf(resultado[5])) {
            return 3;
        } else if (puntuacion > Integer.parseInt(resultado[6]) && puntuacion <= Integer.valueOf(resultado[7])) {
            return 4;
        } else {
            return 0;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton buttonpPicNU;
    private javax.swing.JToggleButton buttonviewPass;
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel labelapellido;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtName;
    private javax.swing.JLabel txtNewuser;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtUser;
    private javax.swing.JPasswordField txtValidatePass;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JLabel txtdbNU;
    private javax.swing.JLabel txtemailNU;
    private javax.swing.JLabel txtnameNU;
    private javax.swing.JLabel txtnewPass;
    private javax.swing.JLabel txtnumberNU;
    private javax.swing.JLabel txtppicNU;
    private javax.swing.JLabel txtruta;
    private javax.swing.JLabel txtvalidatePass;
    // End of variables declaration//GEN-END:variables
}
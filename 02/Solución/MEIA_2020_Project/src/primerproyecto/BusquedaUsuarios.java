package primerproyecto;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import javax.swing.DefaultListModel;


public class BusquedaUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form BúsquedaUsuarios
     */
    public BusquedaUsuarios() {
        initComponents();
        DefaultListModel list = new DefaultListModel();
        
             String path = "C:/MEIA/bitacora_usuario.txt";  
          String path2 = "C:/MEIA/usuario.txt";         
          Metodos m =new Metodos();
          
          if(new File(path).exists()&&new File(path2).exists())
          {
    ArrayList<String> Lista2 = new ArrayList<String>();                         
          Lista2 =m.listadoNombresUsuario(new File(path2));
          
           ArrayList<String> Lista = new ArrayList<String>();                         
          Lista =m.listadoNombresUsuario(new File(path));
                            
          for(String s: Lista2)
              
          {
              Lista.add(s);
          }
               Collections.sort(Lista);
           for(String s: Lista)
              
          {
              String[] tempo = s.split("\\|");
              list.addElement(tempo[0]);              
            //System.out.println(s);
          }
                        
      UsuariosDisponibles.setModel(list);        
          }
          if(new File(path).exists()&&!new File(path2).exists())
          { 
           ArrayList<String> Lista = new ArrayList<String>();                         
          Lista =m.listadoNombresUsuario(new File(path));
                                     
               Collections.sort(Lista);
           for(String s: Lista)   
          {
              String[] tempo = s.split("\\|");
              list.addElement(tempo[0]);              
          }
                        
      UsuariosDisponibles.setModel(list);    
          }                        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        UsuariosDisponibles = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Informacion = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        btn_Regresar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(UsuariosDisponibles);

        jLabel1.setText("Usuarios Disponibles");

        jScrollPane2.setViewportView(Informacion);

        jLabel2.setText("Informacion de usuario");

        jLabel3.setText("Escribir nombre de usuario");

        btnConsultar.setText("Consultar informacion");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btn_Regresar.setText("Regresar");
        btn_Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegresarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setText("Informacion de usuarios");

        jButton1.setText("Modificar Informacion de usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre)
                    .addComponent(btn_Regresar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegresarActionPerformed
        MenuAdministrador m =new MenuAdministrador();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_RegresarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed

            String path = "C:/MEIA/bitacora_usuario.txt"; 
            String path2 = "C:/MEIA/usuario.txt";  
            DefaultListModel list = new DefaultListModel();
            Metodos m = new Metodos();
            String nombre =txtNombre.getText();
            boolean n = m.ValidarNombreUsuario(nombre);
               if(n == true)
           {
                // <editor-fold defaultstate="collapsed" desc="Mostrar ">
               if(new File(path).exists()&&new File(path2).exists())
               {                  
               System.out.println("existe");
                ArrayList<String> Lista1 = new ArrayList<String>();                         
                ArrayList<String> Mostrar = new ArrayList<String>(); 
                ArrayList<String> Lista2 = new ArrayList<String>(); 
                Lista1 =m.listadoNombresUsuario(new File(path));                                                                  
                Lista2 =m.listadoNombresUsuario(new File(path2));  
                int index=-1; 
                for(String s:Lista2)
                {
                 Lista1.add(s);
                }
          for (int i = 0; i < Lista1.size(); i++) 
          {
            String[] tempo = Lista1.get(i).split("\\|");
                        if(Objects.equals(tempo[0], nombre))
                        {
                            index=i;
                            break;
                        }
          }
              String[] tempo = Lista1.get(index).split("\\|");
              list.addElement("Nombre de usuario: "+tempo[0]);
              list.addElement("Nombre: "+tempo[1]);
              list.addElement("Apellido: "+tempo[2]);
              list.addElement("Contraseña: "+tempo[3]);
              list.addElement("Rol: "+tempo[4]);
              list.addElement("Fecha de nacimiento: "+tempo[5]);
              list.addElement("Correo alterno: "+tempo[6]);
             list.addElement("Numero telefonico: "+tempo[7]);
              list.addElement("Ruta imagen de perfil: "+tempo[8]);
              list.addElement("Vigencia: "+tempo[9]);
              
              Informacion.setModel(list);
           }
               // </editor-fold>
               
                // <editor-fold defaultstate="collapsed" desc="Mostrar ">
               if(new File(path).exists()&&!new File(path2).exists())
               {                             
                ArrayList<String> Lista1 = new ArrayList<String>();                         
                ArrayList<String> Mostrar = new ArrayList<String>();               
                Lista1 =m.listadoNombresUsuario(new File(path));                                                                                  
                int index=-1; 
               
          for (int i = 0; i < Lista1.size(); i++) 
          {
            String[] tempo = Lista1.get(i).split("\\|");
                        if(Objects.equals(tempo[0], nombre))
                        {
                            index=i;
                            break;
                        }
          }
          
           String[] tempo = Lista1.get(index).split("\\|");
                list.addElement("Nombre de usuario: "+tempo[0]);
              list.addElement("Nombre: "+tempo[1]);
              list.addElement("Apellido: "+tempo[2]);
              list.addElement("Contraseña: "+tempo[3]);
              list.addElement("Rol: "+tempo[4]);
              list.addElement("Fecha de nacimiento: "+tempo[5]);
              list.addElement("Correo alterno: "+tempo[6]);
             list.addElement("Numero telefonico: "+tempo[7]);
              list.addElement("Ruta imagen de perfil: "+tempo[8]);
              list.addElement("Vigencia: "+tempo[9]);              
              Informacion.setModel(list);
              
           }
               // </editor-fold>
                              
           }
           if(n == false)
           {
                list.addElement("usuario "+ nombre+" no existente");
                Informacion.setModel(list);
           }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          ModificarAdmin m =new ModificarAdmin();
          m.setVisible(true);
          this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(BusquedaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusquedaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusquedaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusquedaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusquedaUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> Informacion;
    private javax.swing.JList<String> UsuariosDisponibles;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btn_Regresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}

package mundial;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class Inicio extends javax.swing.JFrame {

       String pass = "";

       public Inicio() {
              initComponents();
              this.setLocationRelativeTo(null);
              icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("fotos/img.png")));
              us.requestFocus();
       }

       @Override
       public Image getIconImage() {
              Image retValue = Toolkit.getDefaultToolkit().
                      getImage(ClassLoader.getSystemResource("mundial/icon.png"));
              return retValue;
       }

       @SuppressWarnings("unchecked")
       // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
       private void initComponents() {

              icono = new javax.swing.JLabel();
              jPanel1 = new javax.swing.JPanel();
              jButton1 = new javax.swing.JButton();
              tpass = new javax.swing.JPasswordField();
              jLabel1 = new javax.swing.JLabel();
              us = new javax.swing.JTextField();
              jLabel2 = new javax.swing.JLabel();

              setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
              setIconImage(getIconImage());
              setResizable(false);

              jPanel1.setBackground(new java.awt.Color(173, 18, 22));

              jButton1.setText("INGRESAR");
              jButton1.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton1ActionPerformed(evt);
                     }
              });

              jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jLabel1.setForeground(new java.awt.Color(255, 255, 255));
              jLabel1.setText("CONTRASEÑA");

              jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jLabel2.setForeground(new java.awt.Color(255, 255, 255));
              jLabel2.setText("USUARIO");

              javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
              jPanel1.setLayout(jPanel1Layout);
              jPanel1Layout.setHorizontalGroup(
                     jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                          .addGap(231, 231, 231)
                                          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                 .addComponent(us)
                                                 .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                 .addComponent(tpass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                          .addGap(266, 266, 266)
                                          .addComponent(jLabel1))
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                          .addGap(278, 278, 278)
                                          .addComponent(jLabel2)))
                            .addContainerGap(215, Short.MAX_VALUE))
              );
              jPanel1Layout.setVerticalGroup(
                     jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2)
                            .addGap(8, 8, 8)
                            .addComponent(us, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addContainerGap())
              );

              javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
              getContentPane().setLayout(layout);
              layout.setHorizontalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                   .addComponent(icono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(0, 0, Short.MAX_VALUE))
              );
              layout.setVerticalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                            .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
              );

              pack();
       }// </editor-fold>//GEN-END:initComponents

       private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

              System.out.println(pass + "-" + Archivos.Leer("pass.txt").get(1));
              if (new String(tpass.getPassword()).equals(Archivos.Leer("pass.txt").get(1)) && us.getText().equals(Archivos.Leer("pass.txt").get(0))) {
                     ingEquipos prin = new ingEquipos();
                     prin.setVisible(true);
                     this.dispose();
              } else {
                     JOptionPane.showMessageDialog(null, "Datos Incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
              }
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
                     java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (InstantiationException ex) {
                     java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (IllegalAccessException ex) {
                     java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                     java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              }
              //</editor-fold>
              //</editor-fold>

              /* Create and display the form */
              java.awt.EventQueue.invokeLater(new Runnable() {
                     public void run() {
                            new Inicio().setVisible(true);
                     }
              });
       }

       // Variables declaration - do not modify//GEN-BEGIN:variables
       public javax.swing.JLabel icono;
       public javax.swing.JButton jButton1;
       public javax.swing.JLabel jLabel1;
       public javax.swing.JLabel jLabel2;
       public javax.swing.JPanel jPanel1;
       public javax.swing.JPasswordField tpass;
       public javax.swing.JTextField us;
       // End of variables declaration//GEN-END:variables
}

package cryptpass;

/**
 *
 * @author david-cdcb
 */
public class ventana extends javax.swing.JFrame {

       public ventana() {
              initComponents();
              setLocationRelativeTo(null);
              input.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
              clave.requestFocus();

       }
       
       public void nEncriptar(char[] text,char[] arrc, int tip) {
              int as;
              
              if (tip == 0) {
                     text = Transponer(text,arrc.length);
                     text = Truncar(text);
                     text = Rotar(text, (int) arrc[0] + arrc[arrc.length - 1]);
                     text = Inversa(text);

                     for (int f = 0; f < text.length; f++) {
                            System.out.print(text[f]);
                     }
              } else {
                     text = Inversa(text);
                     text = RotarI(text, (int) arrc[0] + arrc[arrc.length - 1]);
                     text = Truncar(text);
                     text = Transponer(text,arrc.length);

              }

              for (int x = 0; x < arrc.length; x++) {
                     as = (int) arrc[x];
                     if (as % 2 != 0)
                            as = (int) arrc[arrc.length - 1 - x];

                     if (as % 2 == 0)
                            as = (int) (arrc[arrc.length - 1]) - x;

                     for (int i = 0; i < text.length; i++) {
                            if (text[i] != 10)
                                   if (tip == 0)
                                          text[i] = (char) (text[i] + (char) as);
                                   else
                                          text[i] = (char) (text[i] + (char) as * -1);
                     }
              }
             
              Mostrar(text,tip);
       }

       public static char[] Transponer(char[] text,int arrc) {
              int ind = 0, in = 0;
              char[][] m = new char[arrc][arrc];
              int size = text.length;
              
              while (ind <= text.length) {
                     size -= (arrc*arrc);
                     if (size > 0) {

                            for (int f = 0; f < m.length; f++) {
                                   for (int c = 0; c < m.length; c++) {
                                          m[f][c] = text[ind];
                                          ind++;
                                   }
                            }
                            char[][] mt = new char[arrc][arrc];

                            for (int f = 0; f < m.length; f++) {
                                   for (int c = 0; c < m[f].length; c++) {
                                          mt[c][f] = m[f][c];
                                   }
                            }
                            m = mt;

                            ind -= (arrc*arrc);
                            for (int f = 0; f < m.length; f++) {
                                   for (int c = 0; c < m.length; c++) {
                                          text[ind] = m[f][c];
                                          ind++;
                                   }
                            }

                     } else
                            ind++;
              }
              return text;
       }

       public static char[] Inversa(char[] text) {
              char[] au = new char[text.length];
              int j = text.length - 1;

              for (int i = 0; i < text.length; i++) {
                     au[j] = text[i];
                     j--;
              }
              text = au;

              return text;
       }

       public static char[] Truncar(char[] text) {
              char t;
              for (int i = 0; i < text.length; i += 2) {
                     if (i < text.length - 1) {
                            t = text[i];
                            text[i] = text[i + 1];
                            text[i + 1] = t;
                     }
              }

              return text;
       }

       public static char[] Rotar(char[] arr, int n) {

              char aux = 0, tran = 0;
              for (int i = 0; i < n; i++) {
                     tran = arr[arr.length - 1];
                     for (int j = 0; j < arr.length; j++) {
                            aux = arr[j];
                            arr[j] = tran;
                            tran = aux;
                     }
              }
              return arr;
       }

       public static char[] RotarI(char[] arr, int n) {

              char aux = 0, tran = 0;
              for (int i = 0; i < n; i++) {
                     tran = arr[0];
                     for (int j = arr.length - 1; j >= 0; j--) {
                            aux = arr[j];
                            arr[j] = tran;
                            tran = aux;
                     }
              }
              return arr;
       }

       
       
       public void Mostrar(char[] text,int tip){
            input.setText("");
              for (int i = 0; i < text.length; i++) {
                     if (text[i] == 10) {
                            if (tip == 0)
                                   input.setText(input.getText() + "\n");
                            else
                                   input.setText(input.getText() + "\n");
                     } else
                            if (tip == 0)
                                   input.setText(input.getText() + text[i]);
                            else
                                   input.setText(input.getText() + text[i]);
              }
              if (tip == 0) {
                     input.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 18), 3));
                     input.selectAll();
                     input.copy();
              } else {
                     input.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 54, 254), 3));
                     input.selectAll();
                     input.copy();
              }
       
       }

       @SuppressWarnings("unchecked")
       // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
       private void initComponents() {

              panel = new javax.swing.JPanel();
              en = new javax.swing.JButton();
              jScrollPane1 = new javax.swing.JScrollPane();
              input = new javax.swing.JTextArea();
              clave = new javax.swing.JPasswordField();
              jLabel1 = new javax.swing.JLabel();
              des = new javax.swing.JButton();

              setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
              setTitle("TextCrypt CDCB");
              setBackground(new java.awt.Color(1, 1, 1));
              setResizable(false);

              panel.setBackground(new java.awt.Color(0, 0, 0));

              en.setBackground(new java.awt.Color(1, 1, 1));
              en.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
              en.setForeground(new java.awt.Color(254, 247, 247));
              en.setText("==>");
              en.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            enActionPerformed(evt);
                     }
              });

              input.setBackground(new java.awt.Color(1, 1, 1));
              input.setColumns(20);
              input.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
              input.setForeground(new java.awt.Color(254, 221, 221));
              input.setRows(5);
              input.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 54, 254), 3));
              input.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
              input.addMouseListener(new java.awt.event.MouseAdapter() {
                     public void mouseClicked(java.awt.event.MouseEvent evt) {
                            inputMouseClicked(evt);
                     }
              });
              input.addKeyListener(new java.awt.event.KeyAdapter() {
                     public void keyPressed(java.awt.event.KeyEvent evt) {
                            inputKeyPressed(evt);
                     }
              });
              jScrollPane1.setViewportView(input);

              clave.setBackground(new java.awt.Color(1, 1, 1));
              clave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
              clave.setForeground(new java.awt.Color(255, 0, 0));
              clave.setFocusCycleRoot(true);
              clave.setFocusTraversalPolicyProvider(true);
              clave.addKeyListener(new java.awt.event.KeyAdapter() {
                     public void keyPressed(java.awt.event.KeyEvent evt) {
                            claveKeyPressed(evt);
                     }
              });

              jLabel1.setBackground(new java.awt.Color(254, 254, 254));
              jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jLabel1.setForeground(new java.awt.Color(255, 0, 0));
              jLabel1.setText("LLAVE:");

              des.setBackground(new java.awt.Color(1, 1, 1));
              des.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
              des.setForeground(new java.awt.Color(254, 254, 254));
              des.setText("<==");
              des.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            desActionPerformed(evt);
                     }
              });

              javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
              panel.setLayout(panelLayout);
              panelLayout.setHorizontalGroup(
                     panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(panelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                   .addComponent(jScrollPane1)
                                   .addGroup(panelLayout.createSequentialGroup()
                                          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addGap(16, 16, 16)
                                          .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addGap(14, 14, 14)
                                          .addComponent(des)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(en)))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              );
              panelLayout.setVerticalGroup(
                     panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(panelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel1)
                                   .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(des, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(en, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addContainerGap())
              );

              javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
              getContentPane().setLayout(layout);
              layout.setHorizontalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              );
              layout.setVerticalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
              );

              pack();
       }// </editor-fold>//GEN-END:initComponents

    private void enActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enActionPerformed
           en.setForeground(new java.awt.Color(0, 255, 18));
           input.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 54, 254), 3));
           char arr[] = input.getText().toCharArray();
           char[] arrc=clave.getText().toCharArray();
           nEncriptar(arr,arrc, 0);


    }//GEN-LAST:event_enActionPerformed

    private void desActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desActionPerformed
           des.setForeground(new java.awt.Color(1, 54, 254));
           input.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 18), 3));
           char arr[] = input.getText().toCharArray();
           char[] arrc=clave.getText().toCharArray();
           nEncriptar(arr,arrc, 1);

    }//GEN-LAST:event_desActionPerformed

    private void inputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputMouseClicked

           input.selectAll();


    }//GEN-LAST:event_inputMouseClicked

       private void inputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputKeyPressed

           switch (evt.getKeyCode()) {

               case 39:
                   en.setForeground(new java.awt.Color(0, 255, 18));
                   input.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 54, 254), 3));
                   char arr[] = input.getText().toCharArray();
                   char[] arrc = clave.getText().toCharArray();
                   nEncriptar(arr, arrc, 0);
                   break;

               case 37:  //izquierda
                   des.setForeground(new java.awt.Color(1, 54, 254));
                   input.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 18), 3));
                   arr = input.getText().toCharArray();
                   arrc = clave.getText().toCharArray();
                   nEncriptar(arr, arrc, 1);
                   break;
           }


       }//GEN-LAST:event_inputKeyPressed

       private void claveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_claveKeyPressed
              switch (evt.getKeyCode()) {

                     case 10:
                            input.requestFocus();
                            input.paste();
                            break;

              }
       }//GEN-LAST:event_claveKeyPressed

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
                     java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (InstantiationException ex) {
                     java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (IllegalAccessException ex) {
                     java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                     java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              }
              //</editor-fold>

              /* Create and display the form */
              java.awt.EventQueue.invokeLater(new Runnable() {
                     public void run() {
                            new ventana().setVisible(true);
                     }
              });
       }

       // Variables declaration - do not modify//GEN-BEGIN:variables
       public javax.swing.JPasswordField clave;
       public javax.swing.JButton des;
       public javax.swing.JButton en;
       public javax.swing.JTextArea input;
       public javax.swing.JLabel jLabel1;
       public javax.swing.JScrollPane jScrollPane1;
       public javax.swing.JPanel panel;
       // End of variables declaration//GEN-END:variables
}

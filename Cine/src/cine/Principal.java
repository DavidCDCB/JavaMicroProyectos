
package cine;

public class Principal extends javax.swing.JFrame {

       public Principal() {
              initComponents();
              
              
              
              
       }


       @SuppressWarnings("unchecked")
       // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
       private void initComponents() {

              IngDat = new javax.swing.JButton();
              jButton2 = new javax.swing.JButton();
              jButton3 = new javax.swing.JButton();

              setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

              IngDat.setText("INGRESAR DATOS");
              IngDat.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            IngDatActionPerformed(evt);
                     }
              });

              jButton2.setText("jButton2");
              jButton2.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton2ActionPerformed(evt);
                     }
              });

              jButton3.setText("jButton3");

              javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
              getContentPane().setLayout(layout);
              layout.setHorizontalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(IngDat, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addGap(32, 32, 32)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addGap(25, 25, 25))
              );
              layout.setVerticalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(248, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(IngDat, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12))
              );

              pack();
       }// </editor-fold>//GEN-END:initComponents

       private void IngDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngDatActionPerformed
              modIng ing=new modIng();
              ing.setVisible(true);
              
              this.setVisible(false);
       }//GEN-LAST:event_IngDatActionPerformed

       private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
              modCon con=new modCon();
              con.setVisible(true);
              
              this.setVisible(false);
       }//GEN-LAST:event_jButton2ActionPerformed


       // Variables declaration - do not modify//GEN-BEGIN:variables
       public javax.swing.JButton IngDat;
       public javax.swing.JButton jButton2;
       public javax.swing.JButton jButton3;
       // End of variables declaration//GEN-END:variables
}

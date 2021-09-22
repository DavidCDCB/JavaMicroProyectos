/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cine;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */
public class modCon extends javax.swing.JFrame {

       /**
        * Creates new form modCon
        */
       
       DefaultTableModel modelo; //para hacer la tabla
       
       public modCon() {
              initComponents();

              String[] titulos = {"Codigo", "Nombre"};
              String[] registro = new String[2];
              modelo = new DefaultTableModel(null, titulos);
              ArrayList<String> registros = new ArrayList<String>();

              registros = Archivos.Leer("Dep.txt");

              // System.out.println( registros.get(0));
              for (int i = 0; i < registros.size(); i++) {

                     if (!" ".equals(registros.get(i))) {
                            String[] arrRegistro = registros.get(i).split(",");
                            registro[0] = arrRegistro[0];
                            registro[1] = arrRegistro[1];
                            modelo.addRow(registro);
                            tblDep.setModel(modelo);
                     }
              }

              int select;
              String id;
              select = tblDep.getSelectedRow();
              id = (String) modelo.getValueAt(0, 0);

       }

       @SuppressWarnings("unchecked")
       // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
       private void initComponents() {

              jPanel1 = new javax.swing.JPanel();
              jScrollPane1 = new javax.swing.JScrollPane();
              tblDep = new javax.swing.JTable();
              vMun = new javax.swing.JButton();
              elDep = new javax.swing.JButton();
              jPanel2 = new javax.swing.JPanel();
              jScrollPane2 = new javax.swing.JScrollPane();
              tblMun = new javax.swing.JTable();
              jButton2 = new javax.swing.JButton();

              setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

              jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Departamentos"));

              tblDep.setModel(new javax.swing.table.DefaultTableModel(
                     new Object [][] {
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null}
                     },
                     new String [] {
                            "Title 1", "Title 2", "Title 3", "Title 4"
                     }
              ));
              jScrollPane1.setViewportView(tblDep);

              vMun.setText("Ver Municipios");
              vMun.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            vMunActionPerformed(evt);
                     }
              });

              elDep.setText("jButton1");
              elDep.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            elDepActionPerformed(evt);
                     }
              });

              javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
              jPanel1.setLayout(jPanel1Layout);
              jPanel1Layout.setHorizontalGroup(
                     jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                          .addComponent(elDep)
                                          .addGap(30, 30, 30)
                                          .addComponent(vMun))
                                   .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 28, Short.MAX_VALUE))
              );
              jPanel1Layout.setVerticalGroup(
                     jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(vMun)
                                   .addComponent(elDep))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(105, Short.MAX_VALUE))
              );

              jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Municipios"));

              tblMun.setModel(new javax.swing.table.DefaultTableModel(
                     new Object [][] {
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null},
                            {null, null, null, null}
                     },
                     new String [] {
                            "Title 1", "Title 2", "Title 3", "Title 4"
                     }
              ));
              jScrollPane2.setViewportView(tblMun);

              jButton2.setText("jButton1");

              javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
              jPanel2.setLayout(jPanel2Layout);
              jPanel2Layout.setHorizontalGroup(
                     jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2)
                            .addGap(31, 31, 31))
                     .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              );
              jPanel2Layout.setVerticalGroup(
                     jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2)
                            .addGap(37, 37, 37)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35))
              );

              javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
              getContentPane().setLayout(layout);
              layout.setHorizontalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(18, Short.MAX_VALUE))
              );
              layout.setVerticalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(64, Short.MAX_VALUE))
              );

              pack();
       }// </editor-fold>//GEN-END:initComponents

       private void vMunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vMunActionPerformed
              int select; //consulta filtrada deacuerdo a la seleccion
              String id;
              select = tblDep.getSelectedRow();
              id = (String) modelo.getValueAt(select, 0);
              System.out.println(id);

              String[] titulos = {"Codigo", "Nombre"};
              String[] registro = new String[2];
              modelo = new DefaultTableModel(null, titulos);
              ArrayList<String> registros = new ArrayList<String>();

              registros = Archivos.Leer("Mun.txt");

              for (int i = 0; i < registros.size(); i++) {

                     if (!" ".equals(registros.get(i))) {
                            String[] arrRegistro = registros.get(i).split(",");

                            if (!arrRegistro[2].equals(id)) {
                                   registros.remove(i);
                            }
                     }
              }

              for (int i = 0; i < registros.size(); i++) {
                     String[] arrRegistro = registros.get(i).split(",");
                     registro[0] = arrRegistro[0];
                     registro[1] = arrRegistro[1];
                     modelo.addRow(registro);
                     tblMun.setModel(modelo);
              }

              
       }//GEN-LAST:event_vMunActionPerformed

       private void elDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elDepActionPerformed
              int select;
              String id;
              select = tblDep.getSelectedRow();
              id = (String) modelo.getValueAt(select, 0);
              System.out.println(id);

              String[] titulos = {"Codigo", "Nombre"};
              String[] registro = new String[2];
              modelo = new DefaultTableModel(null, titulos);
              ArrayList<String> registros = new ArrayList<String>();

              registros = Archivos.Leer("Dep.txt");

              for (int i = 0; i < registros.size(); i++) {

                     if (!" ".equals(registros.get(i))) {

                            String[] arrRegistro = registros.get(i).split(",");

                            if (arrRegistro[0].equals(id)) {
                                   registros.remove(i);
                            }
                     }
              }

              for (int i = 0; i < registros.size(); i++) {
                     String[] arrRegistro = registros.get(i).split(",");
                     System.out.println(registros.size());
                     registro[0] = arrRegistro[0];
                     registro[1] = arrRegistro[1];
                     modelo.addRow(registro);
                     tblDep.setModel(modelo);
              }

              Archivos.Escribir(" ", "Dep.txt", false);

              for (int i = 0; i < registros.size(); i++) {
                     Archivos.Escribir(registros.get(i), "Dep.txt", true);

              }
              
              
       }//GEN-LAST:event_elDepActionPerformed

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
                     java.util.logging.Logger.getLogger(modCon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (InstantiationException ex) {
                     java.util.logging.Logger.getLogger(modCon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (IllegalAccessException ex) {
                     java.util.logging.Logger.getLogger(modCon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                     java.util.logging.Logger.getLogger(modCon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              }
              //</editor-fold>

              /* Create and display the form */
              java.awt.EventQueue.invokeLater(new Runnable() {
                     public void run() {
                            new modCon().setVisible(true);
                     }
              });
       }

       // Variables declaration - do not modify//GEN-BEGIN:variables
       public javax.swing.JButton elDep;
       public javax.swing.JButton jButton2;
       public javax.swing.JPanel jPanel1;
       public javax.swing.JPanel jPanel2;
       public javax.swing.JScrollPane jScrollPane1;
       public javax.swing.JScrollPane jScrollPane2;
       public javax.swing.JTable tblDep;
       public javax.swing.JTable tblMun;
       public javax.swing.JButton vMun;
       // End of variables declaration//GEN-END:variables
}

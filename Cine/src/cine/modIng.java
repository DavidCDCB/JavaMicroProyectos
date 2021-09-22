
package cine;

public class modIng extends javax.swing.JFrame {
       Municipio mun = new Municipio();
      Departamento dep = new Departamento();
       public modIng() {
              initComponents();
              
              
              
       }

       public void enDep(boolean res){
              
              
              codDep.setEnabled(res);
              nomDep.setEnabled(res);
              gDep.setEnabled(res);
              aMun.setEnabled(res);
       
       }

       @SuppressWarnings("unchecked")
       // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
       private void initComponents() {

              pdep = new javax.swing.JPanel();
              gDep = new javax.swing.JButton();
              aMun = new javax.swing.JButton();
              jLabel1 = new javax.swing.JLabel();
              jLabel2 = new javax.swing.JLabel();
              codDep = new javax.swing.JTextField();
              nomDep = new javax.swing.JTextField();
              jPanel2 = new javax.swing.JPanel();
              gMun = new javax.swing.JButton();
              aTe = new javax.swing.JButton();
              jLabel3 = new javax.swing.JLabel();
              jLabel4 = new javax.swing.JLabel();
              codMun = new javax.swing.JTextField();
              nomMun = new javax.swing.JTextField();
              jPanel3 = new javax.swing.JPanel();
              gTe = new javax.swing.JButton();
              aSa = new javax.swing.JButton();
              jLabel7 = new javax.swing.JLabel();
              codTe = new javax.swing.JTextField();
              nomTe = new javax.swing.JTextField();
              jLabel6 = new javax.swing.JLabel();
              jPanel4 = new javax.swing.JPanel();
              gSa = new javax.swing.JButton();
              aPel = new javax.swing.JButton();
              jLabel10 = new javax.swing.JLabel();
              codSa = new javax.swing.JTextField();
              jLabel11 = new javax.swing.JLabel();
              capSa = new javax.swing.JTextField();
              jLabel9 = new javax.swing.JLabel();
              nomSa = new javax.swing.JTextField();
              jLabel12 = new javax.swing.JLabel();
              jScrollPane1 = new javax.swing.JScrollPane();
              proSa = new javax.swing.JTextArea();
              jPanel5 = new javax.swing.JPanel();
              jLabel14 = new javax.swing.JLabel();
              desPel = new javax.swing.JTextField();
              jLabel15 = new javax.swing.JLabel();
              genPel = new javax.swing.JTextField();
              durPel = new javax.swing.JTextField();
              jLabel16 = new javax.swing.JLabel();
              nomPel = new javax.swing.JTextField();
              jLabel17 = new javax.swing.JLabel();
              gPel = new javax.swing.JButton();
              nuevo = new javax.swing.JButton();

              setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

              pdep.setBorder(javax.swing.BorderFactory.createTitledBorder("Departamentos"));

              gDep.setText("Guardar");
              gDep.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            gDepActionPerformed(evt);
                     }
              });

              aMun.setText("Agregar minucipios");
              aMun.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            aMunActionPerformed(evt);
                     }
              });

              jLabel1.setText("Codigo:");

              jLabel2.setText("Nombre: ");

              codDep.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            codDepActionPerformed(evt);
                     }
              });

              javax.swing.GroupLayout pdepLayout = new javax.swing.GroupLayout(pdep);
              pdep.setLayout(pdepLayout);
              pdepLayout.setHorizontalGroup(
                     pdepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(pdepLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(pdepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(pdepLayout.createSequentialGroup()
                                          .addComponent(gDep)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(aMun))
                                   .addGroup(pdepLayout.createSequentialGroup()
                                          .addGroup(pdepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addComponent(jLabel1)
                                                 .addComponent(jLabel2))
                                          .addGap(25, 25, 25)
                                          .addGroup(pdepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addComponent(codDep, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addComponent(nomDep, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap())
              );

              pdepLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {codDep, nomDep});

              pdepLayout.setVerticalGroup(
                     pdepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pdepLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(pdepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel1)
                                   .addComponent(codDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(29, 29, 29)
                            .addGroup(pdepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel2)
                                   .addComponent(nomDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                            .addGroup(pdepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(gDep)
                                   .addComponent(aMun))
                            .addContainerGap())
              );

              jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Municipios"));

              gMun.setText("Guardar");
              gMun.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            gMunActionPerformed(evt);
                     }
              });

              aTe.setText("Agregar teatros");

              jLabel3.setText("Codigo: ");

              jLabel4.setText("Nombre: ");

              nomMun.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            nomMunActionPerformed(evt);
                     }
              });

              javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
              jPanel2.setLayout(jPanel2Layout);
              jPanel2Layout.setHorizontalGroup(
                     jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel2Layout.createSequentialGroup()
                                          .addComponent(gMun)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(aTe))
                                   .addGroup(jPanel2Layout.createSequentialGroup()
                                          .addComponent(jLabel3)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(codMun, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGroup(jPanel2Layout.createSequentialGroup()
                                          .addComponent(jLabel4)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(nomMun, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
              );

              jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {codMun, nomMun});

              jPanel2Layout.setVerticalGroup(
                     jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel3)
                                   .addComponent(codMun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(29, 29, 29)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel4)
                                   .addComponent(nomMun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(gMun)
                                   .addComponent(aTe))
                            .addContainerGap())
              );

              jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Teatros"));

              gTe.setText("Guardar");

              aSa.setText("Agregar Salas");

              jLabel7.setText("Nombre: ");

              jLabel6.setText("Codigo: ");

              javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
              jPanel3.setLayout(jPanel3Layout);
              jPanel3Layout.setHorizontalGroup(
                     jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel3Layout.createSequentialGroup()
                                          .addComponent(gTe)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(aSa))
                                   .addGroup(jPanel3Layout.createSequentialGroup()
                                          .addComponent(jLabel6)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(codTe, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGroup(jPanel3Layout.createSequentialGroup()
                                          .addComponent(jLabel7)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(nomTe, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
              );

              jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {codTe, nomTe});

              jPanel3Layout.setVerticalGroup(
                     jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel6)
                                   .addComponent(codTe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(35, 35, 35)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel7)
                                   .addComponent(nomTe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(gTe, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(aSa))
                            .addGap(20, 20, 20))
              );

              jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {aSa, gTe});

              jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Salas"));

              gSa.setText("Guardar");
              gSa.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            gSaActionPerformed(evt);
                     }
              });

              aPel.setText("Agregar Peliculas");

              jLabel10.setText("Nombre: ");

              codSa.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            codSaActionPerformed(evt);
                     }
              });

              jLabel11.setText("Capacidad: ");

              jLabel9.setText("Codigo: ");

              jLabel12.setText("Programación: ");

              proSa.setColumns(20);
              proSa.setRows(5);
              jScrollPane1.setViewportView(proSa);

              javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
              jPanel4.setLayout(jPanel4Layout);
              jPanel4Layout.setHorizontalGroup(
                     jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel4Layout.createSequentialGroup()
                                          .addComponent(jLabel9)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(codSa, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGroup(jPanel4Layout.createSequentialGroup()
                                          .addComponent(jLabel10)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(nomSa, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGroup(jPanel4Layout.createSequentialGroup()
                                          .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addComponent(gSa)
                                                 .addComponent(jLabel12)
                                                 .addComponent(jLabel11))
                                          .addGap(18, 18, 18)
                                          .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addComponent(capSa, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(aPel))
                                                 .addComponent(jScrollPane1))))
                            .addContainerGap())
              );

              jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {capSa, codSa, nomSa});

              jPanel4Layout.setVerticalGroup(
                     jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel9)
                                   .addComponent(codSa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel10)
                                   .addComponent(nomSa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel11)
                                   .addComponent(capSa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel4Layout.createSequentialGroup()
                                          .addGap(18, 18, 18)
                                          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGroup(jPanel4Layout.createSequentialGroup()
                                          .addGap(35, 35, 35)
                                          .addComponent(jLabel12)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(gSa)
                                   .addComponent(aPel))
                            .addContainerGap())
              );

              jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Peliculas"));

              jLabel14.setText("Descripción: ");

              jLabel15.setText("Genero: ");

              genPel.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            genPelActionPerformed(evt);
                     }
              });

              durPel.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            durPelActionPerformed(evt);
                     }
              });

              jLabel16.setText("Duracion");

              jLabel17.setText("Nombre: ");

              gPel.setText("Guardar");
              gPel.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            gPelActionPerformed(evt);
                     }
              });

              javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
              jPanel5.setLayout(jPanel5Layout);
              jPanel5Layout.setHorizontalGroup(
                     jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel5Layout.createSequentialGroup()
                                          .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(gPel))
                                   .addGroup(jPanel5Layout.createSequentialGroup()
                                          .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addComponent(jLabel17)
                                                 .addComponent(jLabel14))
                                          .addGap(28, 28, 28)
                                          .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addComponent(desPel, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addComponent(nomPel, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                                          .addGap(14, 14, 14)
                                          .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                 .addGroup(jPanel5Layout.createSequentialGroup()
                                                        .addComponent(jLabel16)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(durPel))
                                                 .addGroup(jPanel5Layout.createSequentialGroup()
                                                        .addComponent(jLabel15)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(genPel, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addContainerGap())
              );

              jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {desPel, durPel, genPel, nomPel});

              jPanel5Layout.setVerticalGroup(
                     jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(gPel)
                            .addGap(13, 13, 13)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel5Layout.createSequentialGroup()
                                          .addComponent(genPel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addGap(18, 18, Short.MAX_VALUE)
                                          .addComponent(durPel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGroup(jPanel5Layout.createSequentialGroup()
                                          .addGap(0, 0, Short.MAX_VALUE)
                                          .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                 .addComponent(jLabel17)
                                                 .addComponent(nomPel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addComponent(jLabel15))
                                          .addGap(18, 18, 18)
                                          .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                 .addComponent(jLabel14)
                                                 .addComponent(desPel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addComponent(jLabel16))))
                            .addContainerGap())
              );

              nuevo.setText("NUEVO");
              nuevo.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            nuevoActionPerformed(evt);
                     }
              });

              javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
              getContentPane().setLayout(layout);
              layout.setHorizontalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                   .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                   .addGroup(layout.createSequentialGroup()
                                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                 .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                 .addComponent(pdep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(nuevo)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                 .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                 .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addContainerGap(11, Short.MAX_VALUE))
              );
              layout.setVerticalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                   .addComponent(pdep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(layout.createSequentialGroup()
                                          .addGap(18, 18, 18)
                                          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                 .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                   .addGroup(layout.createSequentialGroup()
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addGap(13, 13, 13)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              );

              pack();
       }// </editor-fold>//GEN-END:initComponents

       private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
              // TODO add your handling code here:
       }//GEN-LAST:event_nuevoActionPerformed

       private void gSaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gSaActionPerformed
              // TODO add your handling code here:
       }//GEN-LAST:event_gSaActionPerformed

       private void gPelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gPelActionPerformed
              // TODO add your handling code here:
       }//GEN-LAST:event_gPelActionPerformed

       private void codDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codDepActionPerformed
              // TODO add your handling code here:
       }//GEN-LAST:event_codDepActionPerformed

       private void nomMunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomMunActionPerformed
              // TODO add your handling code here:
       }//GEN-LAST:event_nomMunActionPerformed

       private void codSaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codSaActionPerformed
              // TODO add your handling code here:
       }//GEN-LAST:event_codSaActionPerformed

       private void genPelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genPelActionPerformed
              // TODO add your handling code here:
       }//GEN-LAST:event_genPelActionPerformed

       private void gMunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gMunActionPerformed
              String datFile;

              
              mun.setCodigo(Integer.parseInt(codMun.getText())); //se convierte de string a entero
              mun.setNombre(nomMun.getText());
              mun.setForDep(Integer.parseInt(codDep.getText()));

              datFile = mun.getNombre() + "," + mun.getCodigo()+","+mun.getForDep();

              Archivos.Escribir(datFile,"Mun.txt",true);
       }//GEN-LAST:event_gMunActionPerformed

       private void durPelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durPelActionPerformed
              // TODO add your handling code here:
       }//GEN-LAST:event_durPelActionPerformed

       private void gDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gDepActionPerformed
              String datFile;


              dep.setCodigo(Integer.parseInt(codDep.getText())); //se convierte de string a entero
              dep.setNombre(nomDep.getText());

              datFile = dep.getNombre() + "," + dep.getCodigo();

              Archivos.Escribir(datFile,"Dep.txt",true);

       }//GEN-LAST:event_gDepActionPerformed

       private void aMunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aMunActionPerformed
       
              enDep(false);
              codMun.requestFocus();
              
       }//GEN-LAST:event_aMunActionPerformed

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
                     java.util.logging.Logger.getLogger(modIng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (InstantiationException ex) {
                     java.util.logging.Logger.getLogger(modIng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (IllegalAccessException ex) {
                     java.util.logging.Logger.getLogger(modIng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                     java.util.logging.Logger.getLogger(modIng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              }
              //</editor-fold>

              /* Create and display the form */
              java.awt.EventQueue.invokeLater(new Runnable() {
                     public void run() {
                            new modIng().setVisible(true);
                     }
              });
       }

       // Variables declaration - do not modify//GEN-BEGIN:variables
       public javax.swing.JButton aMun;
       public javax.swing.JButton aPel;
       public javax.swing.JButton aSa;
       public javax.swing.JButton aTe;
       public javax.swing.JTextField capSa;
       public javax.swing.JTextField codDep;
       public javax.swing.JTextField codMun;
       public javax.swing.JTextField codSa;
       public javax.swing.JTextField codTe;
       public javax.swing.JTextField desPel;
       public javax.swing.JTextField durPel;
       public javax.swing.JButton gDep;
       public javax.swing.JButton gMun;
       public javax.swing.JButton gPel;
       public javax.swing.JButton gSa;
       public javax.swing.JButton gTe;
       public javax.swing.JTextField genPel;
       public javax.swing.JLabel jLabel1;
       public javax.swing.JLabel jLabel10;
       public javax.swing.JLabel jLabel11;
       public javax.swing.JLabel jLabel12;
       public javax.swing.JLabel jLabel14;
       public javax.swing.JLabel jLabel15;
       public javax.swing.JLabel jLabel16;
       public javax.swing.JLabel jLabel17;
       public javax.swing.JLabel jLabel2;
       public javax.swing.JLabel jLabel3;
       public javax.swing.JLabel jLabel4;
       public javax.swing.JLabel jLabel6;
       public javax.swing.JLabel jLabel7;
       public javax.swing.JLabel jLabel9;
       public javax.swing.JPanel jPanel2;
       public javax.swing.JPanel jPanel3;
       public javax.swing.JPanel jPanel4;
       public javax.swing.JPanel jPanel5;
       public javax.swing.JScrollPane jScrollPane1;
       public javax.swing.JTextField nomDep;
       public javax.swing.JTextField nomMun;
       public javax.swing.JTextField nomPel;
       public javax.swing.JTextField nomSa;
       public javax.swing.JTextField nomTe;
       public javax.swing.JButton nuevo;
       public javax.swing.JPanel pdep;
       public javax.swing.JTextArea proSa;
       // End of variables declaration//GEN-END:variables
}

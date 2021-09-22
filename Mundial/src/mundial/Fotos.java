package mundial;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Fotos extends javax.swing.JFrame {

       public DefaultTableModel modelo1; //para hacer la tabla

       public Fotos() {
              initComponents();

              String[] titulos = {"Identificación", "Nombre", "Apellido", "Posición", "N. Camiseta"};
              String[] registro = new String[5];
              modelo1 = new DefaultTableModel(null, titulos);
              ArrayList<String> registros = new ArrayList<String>();

              registros = Archivos.Leer("bdJugadores.txt");

              for (int i = 0; i < registros.size(); i++) {
                     if (!" ".equals(registros.get(i))) {
                            String[] arrRegistro = registros.get(i).split(",");
                            for (int j = 0; j < registro.length; j++) {
                                   registro[j] = arrRegistro[j];
                            }
                            modelo1.addRow(registro);

                     }
              }

              tblJu.setModel(modelo1);
              ingEquipos prin = new ingEquipos();
              //prin.verEq();

       }

       public void PonerFoto(String ruta) {

              foto.setIcon(new javax.swing.ImageIcon(getClass().getResource(ruta)));

       }

       @SuppressWarnings("unchecked")
       // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
       private void initComponents() {

              jScrollPane1 = new javax.swing.JScrollPane();
              tblJu = new javax.swing.JTable();
              foto = new javax.swing.JLabel();
              jButton1 = new javax.swing.JButton();

              setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
              setBackground(new java.awt.Color(173, 18, 22));
              setResizable(false);

              tblJu.setModel(new javax.swing.table.DefaultTableModel(
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
              jScrollPane1.setViewportView(tblJu);

              foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

              jButton1.setText("Ver Foto");
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
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                   .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              );
              layout.setVerticalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                   .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addGroup(layout.createSequentialGroup()
                                          .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              );

              pack();
       }// </editor-fold>//GEN-END:initComponents

       private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
              int select; //consulta filtrada deacuerdo a la seleccion
              String idJugador;
              select = tblJu.getSelectedRow();//El id del jugador seleccionado

              if (select != -1) {//Si encuentra una seleccion
                     idJugador = (String) modelo1.getValueAt(select, 0);//Captura la seleccion de la fila
                     System.out.println(idJugador);

                     //redimencionar imagenes a 208px de ancho
                     //https://www.iloveimg.com/es/redimensionar-imagen
                     System.out.println(foto.getWidth());

                     PonerFoto("fotos/"+idJugador+".png");//Pone la foto si el nombre del archivo corresponde con el dato de la tabla
              } else
                     JOptionPane.showMessageDialog(null, "Seleccione el Equipo", "Aviso", JOptionPane.WARNING_MESSAGE);
       }//GEN-LAST:event_jButton1ActionPerformed


       // Variables declaration - do not modify//GEN-BEGIN:variables
       public javax.swing.JLabel foto;
       public javax.swing.JButton jButton1;
       public javax.swing.JScrollPane jScrollPane1;
       public javax.swing.JTable tblJu;
       // End of variables declaration//GEN-END:variables
}

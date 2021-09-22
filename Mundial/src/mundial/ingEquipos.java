package mundial;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ingEquipos extends javax.swing.JFrame {

       public ArrayList<Equipo> regEq = new ArrayList<>();
       public ArrayList<Jugador> regJug = new ArrayList<>();
       public ArrayList<Tecnico> regTec = new ArrayList<>();
       public ArrayList<Partido> regPar = new ArrayList<>();
       public DefaultTableModel modelo; //para hacer la tabla

       public ingEquipos() {
              initComponents();
              this.setLocationRelativeTo(null);//Centrar ventana
              //verEq(true);
              verPar();
              desEl(false);

       }

       @Override
       public Image getIconImage() {
              Image retValue = Toolkit.getDefaultToolkit().
                      getImage(ClassLoader.getSystemResource("mundial/icon.png"));
              return retValue;
       }

       public void GuardarE() {

              for (int i = 0; i < regEq.size(); i++) {
                     Archivos.Escribir(regEq.get(i).getNombre() + "," + regEq.get(i).getPais() + "," + regEq.get(i).getPosicion(), "bdEquipos.txt", true);//true agrega conservando

              }
              for (int i = 0; i < regJug.size(); i++) {
                     Archivos.Escribir(regJug.get(i).getId() + "," + regJug.get(i).getNombre() + "," + regJug.get(i).getApellido() + "," + regJug.get(i).getPosicion() + "," + regJug.get(i).getCamiseta() + "," + regJug.get(i).getNacimiento() + "," + regJug.get(i).getForEquipo(), "bdJugadores.txt", true);
              }
              for (int i = 0; i < regTec.size(); i++) {
                     Archivos.Escribir(regTec.get(i).getId() + "," + regTec.get(i).getNombre() + "," + regTec.get(i).getApellido() + "," + regTec.get(i).getCargo() + "," + regTec.get(i).getPais() + "," + regTec.get(i).getForEquipo(), "bdTecnicos.txt", true);
              }
              JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
              verEq(true);//true para actualizar la lista de equipos (objetos grafico)
       }

       public void GuardarP() {
              for (int i = 0; i < regPar.size(); i++) {
                     Archivos.Escribir(regPar.get(i).getEquipo1() + "," + regPar.get(i).getEquipo2() + "," + regPar.get(i).getGol1() + "," + regPar.get(i).getGol2() + "," + regPar.get(i).getTarR() + "," + regPar.get(i).getTarA() + "," + regPar.get(i).getTie(), "bdPartidos.txt", true);
                     if (Integer.parseInt(regPar.get(i).getGol1()) > Integer.parseInt(regPar.get(i).getGol2())) {
                            Archivos.Escribir(regPar.get(i).getEquipo1() + "," + regPar.get(i).getEquipo2() + "," + regPar.get(i).getGol1() + "," + regPar.get(i).getGol2(), "bdEquiposDet.txt", true);
                     } else {
                            Archivos.Escribir(regPar.get(i).getEquipo2() + "," + regPar.get(i).getEquipo1() + "," + regPar.get(i).getGol2() + "," + regPar.get(i).getGol1(), "bdEquiposDet.txt", true);
                     }

              }

       }

       public void verPar() {
              String[] titulos = {"Equipo 1", "Equipo 2", "Marcador 1", "Marcador 2", "Tar. Rojas", "Tar. Amarillas", "Tiros Esquina"};
              String[] registro = new String[7];
              modelo = new DefaultTableModel(null, titulos);
              ArrayList<String> registros = new ArrayList<String>();

              registros = Archivos.Leer("bdPartidos.txt");

              // System.out.println( registros.get(0));
              for (int i = 0; i < registros.size(); i++) {

                     if (!" ".equals(registros.get(i))) {//Si hay algo
                            //Se parten los datos de la linea del archivo
                            String[] arrRegistro = registros.get(i).split(",");
                            System.out.println(arrRegistro.length);
                            //Se recorre el arreglo de la linea del archivo
                            for (int j = 0; j < registro.length; j++) {
                                   registro[j] = arrRegistro[j];//se pasan los datos
                            }
                            modelo.addRow(registro);//Se agrega la fila al modelo

                     }
              }
              tblPar.setModel(modelo);
              verEq(false);
       }

       public void verEq(boolean lista) {
              String[] titulos = {"Nombre", "Pais", "Posición"};
              String[] registro = new String[3];
              modelo = new DefaultTableModel(null, titulos);
              ArrayList<String> registros = new ArrayList<String>();

              registros = Archivos.Leer("bdEquipos.txt");

              System.out.println( registros.size());
              for (int i = 0; i < registros.size(); i++) {

                     if (!" ".equals(registros.get(i))) {
                            String[] arrRegistro = registros.get(i).split(",");
                            System.out.println(arrRegistro.length);
                            registro[0] = arrRegistro[0];
                            registro[1] = arrRegistro[1];
                            registro[2] = arrRegistro[2];
                            modelo.addRow(registro);
                            if (lista) {
                                   sE1.addItem(arrRegistro[0]);
                                   sE2.addItem(arrRegistro[0]);
                            }
                     }
              }

              tblEq.setModel(modelo);
              tblE2.setModel(modelo);

       }

       public void verJug() {
              int select; //consulta filtrada deacuerdo a la seleccion
              String id;
              select = tblEq.getSelectedRow();//captura la posicion de la fila en la tabla
              if (select != -1) {
                     id = (String) modelo.getValueAt(select, 0);
                     System.out.println(id);

                     String[] titulos = {"Identificación", "Nombre", "Apellido", "Posición", "N. Camiseta"};
                     String[] registro = new String[5];
                     modelo = new DefaultTableModel(null, titulos);
                     ArrayList<String> registros = new ArrayList<String>();

                     registros = Archivos.Leer("bdJugadores.txt");

                     for (int i = 0; i < registros.size(); i++) {
                            if (!" ".equals(registros.get(i))) {
                                   String[] arrRegistro = registros.get(i).split(",");
                                   if (!arrRegistro[6].equals(id))
                                          registros.remove(i);
                            }
                     }

                     for (int i = 0; i < registros.size(); i++) {
                            if (!" ".equals(registros.get(i))) {
                                   String[] arrRegistro = registros.get(i).split(",");
                                   for (int j = 0; j < registro.length; j++) {
                                          registro[j] = arrRegistro[j];
                                   }
                                   modelo.addRow(registro);

                            }
                     }

                     tblMi.setModel(modelo);
                     verEq(false);
              } else
                     JOptionPane.showMessageDialog(null, "Seleccione el Equipo", "Aviso", JOptionPane.WARNING_MESSAGE);

       }

       public void verTec() {

              int select; //consulta filtrada deacuerdo a la seleccion
              String id;
              select = tblEq.getSelectedRow();//-1
              if (select != -1) {
                     id = (String) modelo.getValueAt(select, 0);

                     String[] titulos = {"Identificación", "Nombre", "Apellido", "Cargo"};
                     String[] registro1 = new String[4];
                     modelo = new DefaultTableModel(null, titulos);
                     ArrayList<String> registros1 = new ArrayList<String>();

                     registros1 = Archivos.Leer("bdTecnicos.txt");

                     for (int i = 0; i < registros1.size(); i++) {
                            if (!" ".equals(registros1.get(i))) {
                                   String[] arrRegistro = registros1.get(i).split(",");
                                   System.out.println(arrRegistro[5] + "------------" + id);
                                   if (!arrRegistro[5].equals(id))
                                          registros1.remove(i);
                            }
                     }

                     for (int i = 0; i < registros1.size(); i++) {
                            if (!" ".equals(registros1.get(i))) {
                                   String[] arrRegistro1 = registros1.get(i).split(",");
                                   for (int j = 0; j < registro1.length; j++) {
                                          registro1[j] = arrRegistro1[j];
                                   }
                                   modelo.addRow(registro1);

                            }
                     }

                     tblMi.setModel(modelo);
                     verEq(false);
              } else
                     JOptionPane.showMessageDialog(null, "Seleccione el Equipo", "Aviso", JOptionPane.WARNING_MESSAGE);
       }

       public void verVic() {

              int select; //consulta filtrada deacuerdo a la seleccion
              String id;
              select = tblE2.getSelectedRow();//-1
              if (select != -1) {
                     id = (String) modelo.getValueAt(select, 0);
                     String[] titulos = {"Ganador", "Perdedor", "Goles a Favor", "Goles en contra"};
                     String[] registro1 = new String[4];
                     modelo = new DefaultTableModel(null, titulos);
                     ArrayList<String> registros1 = new ArrayList<String>();

                     registros1 = Archivos.Leer("bdEquiposDet.txt");

                     for (int i = 0; i < registros1.size(); i++) {
                            if (!" ".equals(registros1.get(i))) {
                                   String[] arrRegistro = registros1.get(i).split(",");
                                   System.out.println(arrRegistro[0] + "------------" + id);
                                   if (!arrRegistro[0].equals(id))
                                          registros1.remove(i);
                            }
                     }

                     for (int i = 0; i < registros1.size(); i++) {
                            if (!" ".equals(registros1.get(i))) {
                                   String[] arrRegistro1 = registros1.get(i).split(",");
                                   for (int j = 0; j < registro1.length; j++) {
                                          registro1[j] = arrRegistro1[j];
                                   }
                                   modelo.addRow(registro1);

                            }
                     }

                     tblDe.setModel(modelo);
                     verEq(false);
              } else
                     JOptionPane.showMessageDialog(null, "Seleccione el Equipo", "Aviso", JOptionPane.WARNING_MESSAGE);
       }

       public void verDer() {

              int select; //consulta filtrada deacuerdo a la seleccion
              String id;
              select = tblE2.getSelectedRow();//-1
              if (select != -1) {
                     id = (String) modelo.getValueAt(select, 0);
                     String[] titulos = {"Ganador", "Perdedor", "Goles a Favor", "Goles en contra"};
                     String[] registro1 = new String[4];
                     modelo = new DefaultTableModel(null, titulos);
                     ArrayList<String> registros1 = new ArrayList<String>();

                     registros1 = Archivos.Leer("bdEquiposDet.txt");

                     for (int i = 0; i < registros1.size(); i++) {
                            if (!" ".equals(registros1.get(i))) {
                                   String[] arrRegistro = registros1.get(i).split(",");
                                   System.out.println(arrRegistro[0] + "------------" + id);
                                   if (!arrRegistro[1].equals(id))
                                          registros1.remove(i);
                            }
                     }

                     for (int i = 0; i < registros1.size(); i++) {
                            if (!" ".equals(registros1.get(i))) {
                                   String[] arrRegistro1 = registros1.get(i).split(",");
                                   for (int j = 0; j < registro1.length; j++) {
                                          registro1[j] = arrRegistro1[j];
                                   }
                                   modelo.addRow(registro1);

                            }
                     }

                     tblDe.setModel(modelo);
                     verEq(false);
              } else
                     JOptionPane.showMessageDialog(null, "Seleccione el Equipo", "Aviso", JOptionPane.WARNING_MESSAGE);
       }

       public void nuevoE() {
              regEq = new ArrayList<>();
              regJug = new ArrayList<>();
              regTec = new ArrayList<>();
              regPar = new ArrayList<>();

              eNom.setText("");
              ePai.setText("");
              ePos.setText("");
              jNom.setText("");
              jApe.setText("");
              jCam.setText("");
              jId.setText("");
              jPos.setText("");
              jNa.setText("");
              tId.setText("");
              tNom.setText("");
              tApe.setText("");
              tCar.setText("");
              tPai.setText("");

       }

       public void desEl(boolean en) {
              jNom.setEnabled(en);
              jApe.setEnabled(en);
              jCam.setEnabled(en);
              jId.setEnabled(en);
              jPos.setEnabled(en);
              jNa.setEnabled(en);
              tId.setEnabled(en);
              tNom.setEnabled(en);
              tApe.setEnabled(en);
              tCar.setEnabled(en);
              tPai.setEnabled(en);

              btnIngJug1.setEnabled(en);
              btnIngTec.setEnabled(en);
       }

       @SuppressWarnings("unchecked")
       // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
       private void initComponents() {

              menuBar1 = new java.awt.MenuBar();
              menu1 = new java.awt.Menu();
              menu2 = new java.awt.Menu();
              jTabbedPane1 = new javax.swing.JTabbedPane();
              jPanel2 = new javax.swing.JPanel();
              pJ = new javax.swing.JPanel();
              jLabel4 = new javax.swing.JLabel();
              jLabel5 = new javax.swing.JLabel();
              jLabel6 = new javax.swing.JLabel();
              jNom = new javax.swing.JTextField();
              jApe = new javax.swing.JTextField();
              jId = new javax.swing.JTextField();
              btnIngJug1 = new javax.swing.JButton();
              jLabel7 = new javax.swing.JLabel();
              jPos = new javax.swing.JTextField();
              jLabel8 = new javax.swing.JLabel();
              jCam = new javax.swing.JTextField();
              jLabel9 = new javax.swing.JLabel();
              jNa = new javax.swing.JTextField();
              jPanel1 = new javax.swing.JPanel();
              jLabel1 = new javax.swing.JLabel();
              jLabel2 = new javax.swing.JLabel();
              jLabel3 = new javax.swing.JLabel();
              eNom = new javax.swing.JTextField();
              ePai = new javax.swing.JTextField();
              ePos = new javax.swing.JTextField();
              btnIngJug = new javax.swing.JButton();
              jButton1 = new javax.swing.JButton();
              jPanel3 = new javax.swing.JPanel();
              jLabel10 = new javax.swing.JLabel();
              jLabel11 = new javax.swing.JLabel();
              jLabel12 = new javax.swing.JLabel();
              tId = new javax.swing.JTextField();
              tNom = new javax.swing.JTextField();
              tApe = new javax.swing.JTextField();
              btnIngTec = new javax.swing.JButton();
              jLabel13 = new javax.swing.JLabel();
              tPai = new javax.swing.JTextField();
              jLabel14 = new javax.swing.JLabel();
              tCar = new javax.swing.JTextField();
              jPanel4 = new javax.swing.JPanel();
              jScrollPane1 = new javax.swing.JScrollPane();
              tblMi = new javax.swing.JTable();
              jScrollPane2 = new javax.swing.JScrollPane();
              tblEq = new javax.swing.JTable();
              btnVEq = new javax.swing.JButton();
              jButton3 = new javax.swing.JButton();
              jButton4 = new javax.swing.JButton();
              jButton2 = new javax.swing.JButton();
              jPanel5 = new javax.swing.JPanel();
              jPanel6 = new javax.swing.JPanel();
              sE1 = new javax.swing.JComboBox<>();
              jLabel15 = new javax.swing.JLabel();
              sE2 = new javax.swing.JComboBox<>();
              jLabel16 = new javax.swing.JLabel();
              jLabel17 = new javax.swing.JLabel();
              mE1 = new javax.swing.JSpinner();
              mE2 = new javax.swing.JSpinner();
              jLabel18 = new javax.swing.JLabel();
              tR = new javax.swing.JSpinner();
              jLabel19 = new javax.swing.JLabel();
              tA = new javax.swing.JSpinner();
              jButton6 = new javax.swing.JButton();
              jLabel20 = new javax.swing.JLabel();
              tE = new javax.swing.JSpinner();
              jPanel7 = new javax.swing.JPanel();
              jScrollPane4 = new javax.swing.JScrollPane();
              tblPar = new javax.swing.JTable();
              jPanel10 = new javax.swing.JPanel();
              jScrollPane8 = new javax.swing.JScrollPane();
              tblE2 = new javax.swing.JTable();
              jButton9 = new javax.swing.JButton();
              jButton10 = new javax.swing.JButton();
              jScrollPane9 = new javax.swing.JScrollPane();
              tblDe = new javax.swing.JTable();

              menu1.setLabel("File");
              menuBar1.add(menu1);

              menu2.setLabel("Edit");
              menuBar1.add(menu2);

              setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
              setTitle("Registros del Mundial 2018");
              setBackground(new java.awt.Color(173, 18, 22));
              setIconImage(getIconImage());
              setResizable(false);

              jPanel2.setBackground(new java.awt.Color(173, 18, 22));

              pJ.setBackground(new java.awt.Color(135, 9, 12));
              pJ.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro De Jugadores", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

              jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jLabel4.setForeground(new java.awt.Color(255, 255, 255));
              jLabel4.setText("Nombre:");

              jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jLabel5.setForeground(new java.awt.Color(255, 255, 255));
              jLabel5.setText("Apellido:");

              jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jLabel6.setForeground(new java.awt.Color(255, 255, 255));
              jLabel6.setText("Idendificación:");

              jNom.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jNomActionPerformed(evt);
                     }
              });

              jApe.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jApeActionPerformed(evt);
                     }
              });

              btnIngJug1.setText("Agregar Jugador");
              btnIngJug1.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            btnIngJug1ActionPerformed(evt);
                     }
              });

              jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jLabel7.setForeground(new java.awt.Color(255, 255, 255));
              jLabel7.setText("Posición:");

              jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jLabel8.setForeground(new java.awt.Color(255, 255, 255));
              jLabel8.setText("Camiseta: ");
              jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
                     public void mouseClicked(java.awt.event.MouseEvent evt) {
                            jLabel8MouseClicked(evt);
                     }
              });

              jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jLabel9.setForeground(new java.awt.Color(255, 255, 255));
              jLabel9.setText("Fecha Nacimiento:");

              javax.swing.GroupLayout pJLayout = new javax.swing.GroupLayout(pJ);
              pJ.setLayout(pJLayout);
              pJLayout.setHorizontalGroup(
                     pJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(pJLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(pJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(pJLayout.createSequentialGroup()
                                          .addComponent(jLabel9)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(jNa, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGroup(pJLayout.createSequentialGroup()
                                          .addGroup(pJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addComponent(jLabel4)
                                                 .addComponent(jLabel5))
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addGroup(pJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addComponent(jApe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addComponent(jNom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pJLayout.createSequentialGroup()
                                          .addGroup(pJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addComponent(jLabel8)
                                                 .addComponent(jLabel7)
                                                 .addComponent(jLabel6))
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addGroup(pJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addComponent(jId, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addGroup(pJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jCam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pJLayout.createSequentialGroup()
                                          .addGap(0, 0, Short.MAX_VALUE)
                                          .addComponent(btnIngJug1)))
                            .addContainerGap())
              );

              pJLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jApe, jCam, jId, jNa, jNom, jPos});

              pJLayout.setVerticalGroup(
                     pJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(pJLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(pJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel4)
                                   .addComponent(jNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(7, 7, 7)
                            .addGroup(pJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel5)
                                   .addComponent(jApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel6)
                                   .addComponent(jId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jPos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jLabel8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel9)
                                   .addComponent(jNa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                            .addComponent(btnIngJug1))
              );

              jPanel1.setBackground(new java.awt.Color(135, 9, 12));
              jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Equipos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

              jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jLabel1.setForeground(new java.awt.Color(255, 255, 255));
              jLabel1.setText("Nombre:");

              jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jLabel2.setForeground(new java.awt.Color(255, 255, 255));
              jLabel2.setText("Pais:");

              jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jLabel3.setForeground(new java.awt.Color(255, 255, 255));
              jLabel3.setText("Posición:");

              eNom.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            eNomActionPerformed(evt);
                     }
              });

              ePai.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            ePaiActionPerformed(evt);
                     }
              });

              btnIngJug.setText("Agregar Miembros");
              btnIngJug.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            btnIngJugActionPerformed(evt);
                     }
              });

              jButton1.setText("NUEVO");
              jButton1.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton1ActionPerformed(evt);
                     }
              });

              javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
              jPanel1.setLayout(jPanel1Layout);
              jPanel1Layout.setHorizontalGroup(
                     jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                          .addComponent(jLabel3)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                          .addComponent(ePos, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addComponent(jLabel1)
                                                 .addComponent(jLabel2))
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addComponent(eNom, javax.swing.GroupLayout.Alignment.TRAILING)
                                                 .addComponent(ePai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))
                                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                          .addComponent(jButton1)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(btnIngJug)))
                            .addContainerGap(17, Short.MAX_VALUE))
              );

              jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {eNom, ePai, ePos});

              jPanel1Layout.setVerticalGroup(
                     jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel1)
                                   .addComponent(eNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel2)
                                   .addComponent(ePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel3)
                                   .addComponent(ePos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(btnIngJug)
                                   .addComponent(jButton1)))
              );

              jPanel3.setBackground(new java.awt.Color(135, 9, 12));
              jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Equipo Tecnico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

              jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jLabel10.setForeground(new java.awt.Color(255, 255, 255));
              jLabel10.setText("Idendificación");

              jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jLabel11.setForeground(new java.awt.Color(255, 255, 255));
              jLabel11.setText("Nombre:");

              jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jLabel12.setForeground(new java.awt.Color(255, 255, 255));
              jLabel12.setText("Apellido:");

              tId.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            tIdActionPerformed(evt);
                     }
              });

              tNom.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            tNomActionPerformed(evt);
                     }
              });

              btnIngTec.setText("Agregar Tecnico");
              btnIngTec.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            btnIngTecActionPerformed(evt);
                     }
              });

              jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jLabel13.setForeground(new java.awt.Color(255, 255, 255));
              jLabel13.setText("Pais");

              jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
              jLabel14.setForeground(new java.awt.Color(255, 255, 255));
              jLabel14.setText("Cargo: ");

              javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
              jPanel3.setLayout(jPanel3Layout);
              jPanel3Layout.setHorizontalGroup(
                     jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel3Layout.createSequentialGroup()
                                          .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addComponent(jLabel10)
                                                 .addComponent(jLabel11)
                                                 .addComponent(jLabel12)
                                                 .addComponent(jLabel13)
                                                 .addComponent(jLabel14))
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                          .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(tId, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                                        .addComponent(tNom))
                                                 .addComponent(tApe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addComponent(tPai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addComponent(tCar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                          .addGap(0, 0, Short.MAX_VALUE)
                                          .addComponent(btnIngTec)))
                            .addContainerGap())
              );

              jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tApe, tCar, tId, tNom, tPai});

              jPanel3Layout.setVerticalGroup(
                     jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel10)
                                   .addComponent(tId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(7, 7, 7)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel11)
                                   .addComponent(tNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel12)
                                   .addComponent(tApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(tPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jLabel13))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(tCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jLabel14))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIngTec))
              );

              jPanel4.setBackground(new java.awt.Color(135, 9, 12));
              jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de Equipos y Miembros", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

              tblMi.setModel(new javax.swing.table.DefaultTableModel(
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
              jScrollPane1.setViewportView(tblMi);

              tblEq.setModel(new javax.swing.table.DefaultTableModel(
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
              jScrollPane2.setViewportView(tblEq);

              btnVEq.setText("Ver Tecnicos");
              btnVEq.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            btnVEqActionPerformed(evt);
                     }
              });

              jButton3.setText("Ver Jugadores");
              jButton3.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton3ActionPerformed(evt);
                     }
              });

              jButton4.setText("Ver Fotos");
              jButton4.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton4ActionPerformed(evt);
                     }
              });

              javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
              jPanel4.setLayout(jPanel4Layout);
              jPanel4Layout.setHorizontalGroup(
                     jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                   .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(btnVEq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              );

              jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

              jPanel4Layout.setVerticalGroup(
                     jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                          .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                   .addGroup(jPanel4Layout.createSequentialGroup()
                                          .addComponent(jButton3)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                          .addComponent(btnVEq)
                                          .addGap(18, 18, 18)
                                          .addComponent(jButton4)))
                            .addContainerGap())
              );

              jButton2.setText("Guardar Datos de Equipo");
              jButton2.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton2ActionPerformed(evt);
                     }
              });

              javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
              jPanel2.setLayout(jPanel2Layout);
              jPanel2Layout.setHorizontalGroup(
                     jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel2Layout.createSequentialGroup()
                                          .addContainerGap()
                                          .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(pJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                   .addGroup(jPanel2Layout.createSequentialGroup()
                                          .addGap(390, 390, 390)
                                          .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              );
              jPanel2Layout.setVerticalGroup(
                     jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                   .addComponent(pJ, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 26, Short.MAX_VALUE))
              );

              jTabbedPane1.addTab("Ingreso de Equipos", jPanel2);

              jPanel5.setBackground(new java.awt.Color(173, 18, 22));
              jPanel5.setToolTipText("");

              jPanel6.setBackground(new java.awt.Color(135, 9, 12));
              jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro por Partidos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

              jLabel15.setForeground(new java.awt.Color(255, 255, 255));
              jLabel15.setText("VS");

              jLabel16.setForeground(new java.awt.Color(255, 255, 255));
              jLabel16.setText("Equipos:");

              jLabel17.setForeground(new java.awt.Color(255, 255, 255));
              jLabel17.setText("Marcador:");

              jLabel18.setForeground(new java.awt.Color(255, 255, 255));
              jLabel18.setText("Targenas Rojas:");

              jLabel19.setForeground(new java.awt.Color(255, 255, 255));
              jLabel19.setText("Targenas Amarillas:");

              jButton6.setText("Guardar Partido");
              jButton6.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton6ActionPerformed(evt);
                     }
              });

              jLabel20.setForeground(new java.awt.Color(255, 255, 255));
              jLabel20.setText("Tiros de Esquina:");

              javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
              jPanel6.setLayout(jPanel6Layout);
              jPanel6Layout.setHorizontalGroup(
                     jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel6Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel6Layout.createSequentialGroup()
                                          .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addGroup(jPanel6Layout.createSequentialGroup()
                                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                               .addComponent(jLabel16)
                                                               .addComponent(jLabel17))
                                                        .addGap(49, 49, 49)
                                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                               .addComponent(sE1, 0, 77, Short.MAX_VALUE)
                                                               .addComponent(mE1))
                                                        .addGap(26, 26, 26)
                                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                               .addComponent(mE2)
                                                               .addComponent(sE2, 0, 74, Short.MAX_VALUE)))
                                                 .addGroup(jPanel6Layout.createSequentialGroup()
                                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                                                      .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                             .addComponent(jLabel19)
                                                                             .addComponent(jLabel18))
                                                                      .addGap(18, 18, 18))
                                                               .addGroup(jPanel6Layout.createSequentialGroup()
                                                                      .addComponent(jLabel20)
                                                                      .addGap(30, 30, 30)))
                                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                               .addComponent(tA, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                                               .addComponent(tR)
                                                               .addComponent(tE))))
                                          .addGap(0, 0, Short.MAX_VALUE))
                                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                          .addGap(0, 0, Short.MAX_VALUE)
                                          .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
              );
              jPanel6Layout.setVerticalGroup(
                     jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel6Layout.createSequentialGroup()
                                          .addContainerGap()
                                          .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addComponent(sE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addComponent(sE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                 .addComponent(jLabel16))
                                          .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addGroup(jPanel6Layout.createSequentialGroup()
                                                        .addGap(19, 19, 19)
                                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                               .addComponent(jLabel17)
                                                               .addComponent(mE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                 .addGroup(jPanel6Layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(mE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                   .addGroup(jPanel6Layout.createSequentialGroup()
                                          .addGap(32, 32, 32)
                                          .addComponent(jLabel15)))
                            .addGap(20, 20, 20)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel18)
                                   .addComponent(tR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel19)
                                   .addComponent(tA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel20)
                                   .addComponent(tE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton6)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              );

              jPanel7.setBackground(new java.awt.Color(135, 9, 12));
              jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de Partidos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

              tblPar.setModel(new javax.swing.table.DefaultTableModel(
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
              jScrollPane4.setViewportView(tblPar);

              javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
              jPanel7.setLayout(jPanel7Layout);
              jPanel7Layout.setHorizontalGroup(
                     jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                            .addContainerGap())
              );
              jPanel7Layout.setVerticalGroup(
                     jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
              );

              jPanel10.setBackground(new java.awt.Color(135, 9, 12));
              jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información de partidos por Equipos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

              tblE2.setModel(new javax.swing.table.DefaultTableModel(
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
              tblE2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
              jScrollPane8.setViewportView(tblE2);

              jButton9.setText("Victorias");
              jButton9.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton9ActionPerformed(evt);
                     }
              });

              jButton10.setText("Derrotas");
              jButton10.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton10ActionPerformed(evt);
                     }
              });

              tblDe.setModel(new javax.swing.table.DefaultTableModel(
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
              jScrollPane9.setViewportView(tblDe);

              javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
              jPanel10.setLayout(jPanel10Layout);
              jPanel10Layout.setHorizontalGroup(
                     jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(jButton10)
                                   .addComponent(jButton9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addContainerGap())
              );
              jPanel10Layout.setVerticalGroup(
                     jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel10Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                          .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGroup(jPanel10Layout.createSequentialGroup()
                                          .addComponent(jButton9)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                          .addComponent(jButton10)))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              );

              javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
              jPanel5.setLayout(jPanel5Layout);
              jPanel5Layout.setHorizontalGroup(
                     jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel5Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addGroup(jPanel5Layout.createSequentialGroup()
                                          .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addContainerGap())
              );
              jPanel5Layout.setVerticalGroup(
                     jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              );

              jTabbedPane1.addTab("Ingreso de Partidos", jPanel5);

              javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
              getContentPane().setLayout(layout);
              layout.setHorizontalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jTabbedPane1)
              );
              layout.setVerticalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                            .addComponent(jTabbedPane1)
                            .addGap(0, 0, 0))
              );

              jTabbedPane1.getAccessibleContext().setAccessibleName("Ingreso de Equipos");

              pack();
       }// </editor-fold>//GEN-END:initComponents

       private void eNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eNomActionPerformed
              // TODO add your handling code here:
       }//GEN-LAST:event_eNomActionPerformed

       private void ePaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ePaiActionPerformed
              // TODO add your handling code here:
       }//GEN-LAST:event_ePaiActionPerformed

       private void btnIngJugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngJugActionPerformed
              regEq.add(new Equipo(eNom.getText(), ePos.getText(), ePai.getText()));
              desEl(true);
       }//GEN-LAST:event_btnIngJugActionPerformed

       private void jNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNomActionPerformed
              // TODO add your handling code here:
       }//GEN-LAST:event_jNomActionPerformed

       private void jApeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jApeActionPerformed
              // TODO add your handling code here:
       }//GEN-LAST:event_jApeActionPerformed

       private void btnIngJug1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngJug1ActionPerformed

              regJug.add(new Jugador(Integer.parseInt(jId.getText()), jNom.getText(), jApe.getText(), jPos.getText(), Integer.parseInt(jCam.getText()), jNa.getText(), eNom.getText()));
              jNom.setText("");
              jApe.setText("");
              jCam.setText("");
              jId.setText("");
              jPos.setText("");
              jNa.setText("");
       }//GEN-LAST:event_btnIngJug1ActionPerformed

       private void tIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIdActionPerformed
              // TODO add your handling code here:
       }//GEN-LAST:event_tIdActionPerformed

       private void tNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNomActionPerformed
              // TODO add your handling code here:
       }//GEN-LAST:event_tNomActionPerformed

       private void btnIngTecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngTecActionPerformed

              regTec.add(new Tecnico(Integer.parseInt(tId.getText()), tNom.getText(), tApe.getText(), tPai.getText(), tCar.getText(), eNom.getText()));
              tId.setText("");
              tNom.setText("");
              tApe.setText("");
              tCar.setText("");
              tPai.setText("");

       }//GEN-LAST:event_btnIngTecActionPerformed

       private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
              GuardarE();
       }//GEN-LAST:event_jButton2ActionPerformed

       private void btnVEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVEqActionPerformed
              verTec();
       }//GEN-LAST:event_btnVEqActionPerformed

       private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
              verJug();
       }//GEN-LAST:event_jButton3ActionPerformed

       private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
              nuevoE();
       }//GEN-LAST:event_jButton1ActionPerformed

       private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

              regPar.add(new Partido(sE1.getSelectedItem().toString(), sE2.getSelectedItem().toString(), mE1.getValue().toString(), mE2.getValue().toString(), tR.getValue().toString(), tA.getValue().toString(), tE.getValue().toString()));
              GuardarP();
              verPar();
       }//GEN-LAST:event_jButton6ActionPerformed

       private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
              verVic();
       }//GEN-LAST:event_jButton9ActionPerformed

       private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
              verDer();
       }//GEN-LAST:event_jButton10ActionPerformed

       private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

              Fotos f = new Fotos();
              f.setVisible(true);
       }//GEN-LAST:event_jButton4ActionPerformed

       private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
             Archivos.Escribir(" ", "bdEquipos.txt", false);
             Archivos.Escribir(" ", "bdJugadores.txt", false);
             Archivos.Escribir(" ", "bdTecnicos.txt", false);
             Archivos.Escribir(" ", "bdPartidos.txt", false);
             Archivos.Escribir(" ", "bdEquiposDet.txt", false);
             JOptionPane.showMessageDialog(null, "BD Purgada", "Aviso", JOptionPane.WARNING_MESSAGE);
       }//GEN-LAST:event_jLabel8MouseClicked

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
                     java.util.logging.Logger.getLogger(ingEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (InstantiationException ex) {
                     java.util.logging.Logger.getLogger(ingEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (IllegalAccessException ex) {
                     java.util.logging.Logger.getLogger(ingEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                     java.util.logging.Logger.getLogger(ingEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              }
              //</editor-fold>

              /* Create and display the form */
              java.awt.EventQueue.invokeLater(new Runnable() {
                     public void run() {
                            new ingEquipos().setVisible(true);
                     }
              });
       }

       // Variables declaration - do not modify//GEN-BEGIN:variables
       public javax.swing.JButton btnIngJug;
       public javax.swing.JButton btnIngJug1;
       public javax.swing.JButton btnIngTec;
       public javax.swing.JButton btnVEq;
       public javax.swing.JTextField eNom;
       public javax.swing.JTextField ePai;
       public javax.swing.JTextField ePos;
       public javax.swing.JTextField jApe;
       public javax.swing.JButton jButton1;
       public javax.swing.JButton jButton10;
       public javax.swing.JButton jButton2;
       public javax.swing.JButton jButton3;
       public javax.swing.JButton jButton4;
       public javax.swing.JButton jButton6;
       public javax.swing.JButton jButton9;
       public javax.swing.JTextField jCam;
       public javax.swing.JTextField jId;
       public javax.swing.JLabel jLabel1;
       public javax.swing.JLabel jLabel10;
       public javax.swing.JLabel jLabel11;
       public javax.swing.JLabel jLabel12;
       public javax.swing.JLabel jLabel13;
       public javax.swing.JLabel jLabel14;
       public javax.swing.JLabel jLabel15;
       public javax.swing.JLabel jLabel16;
       public javax.swing.JLabel jLabel17;
       public javax.swing.JLabel jLabel18;
       public javax.swing.JLabel jLabel19;
       public javax.swing.JLabel jLabel2;
       public javax.swing.JLabel jLabel20;
       public javax.swing.JLabel jLabel3;
       public javax.swing.JLabel jLabel4;
       public javax.swing.JLabel jLabel5;
       public javax.swing.JLabel jLabel6;
       public javax.swing.JLabel jLabel7;
       public javax.swing.JLabel jLabel8;
       public javax.swing.JLabel jLabel9;
       public javax.swing.JTextField jNa;
       public javax.swing.JTextField jNom;
       public javax.swing.JPanel jPanel1;
       public javax.swing.JPanel jPanel10;
       public javax.swing.JPanel jPanel2;
       public javax.swing.JPanel jPanel3;
       public javax.swing.JPanel jPanel4;
       public javax.swing.JPanel jPanel5;
       public javax.swing.JPanel jPanel6;
       public javax.swing.JPanel jPanel7;
       public javax.swing.JTextField jPos;
       public javax.swing.JScrollPane jScrollPane1;
       public javax.swing.JScrollPane jScrollPane2;
       public javax.swing.JScrollPane jScrollPane4;
       public javax.swing.JScrollPane jScrollPane8;
       public javax.swing.JScrollPane jScrollPane9;
       public javax.swing.JTabbedPane jTabbedPane1;
       public javax.swing.JSpinner mE1;
       public javax.swing.JSpinner mE2;
       public java.awt.Menu menu1;
       public java.awt.Menu menu2;
       public java.awt.MenuBar menuBar1;
       public javax.swing.JPanel pJ;
       public javax.swing.JComboBox<String> sE1;
       public javax.swing.JComboBox<String> sE2;
       public javax.swing.JSpinner tA;
       public javax.swing.JTextField tApe;
       public javax.swing.JTextField tCar;
       public javax.swing.JSpinner tE;
       public javax.swing.JTextField tId;
       public javax.swing.JTextField tNom;
       public javax.swing.JTextField tPai;
       public javax.swing.JSpinner tR;
       public javax.swing.JTable tblDe;
       public javax.swing.JTable tblE2;
       public javax.swing.JTable tblEq;
       public javax.swing.JTable tblMi;
       public javax.swing.JTable tblPar;
       // End of variables declaration//GEN-END:variables
}

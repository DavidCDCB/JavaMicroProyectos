package pkg2024gui;

import javax.swing.JLabel;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.applet.AudioClip;
import javax.swing.JOptionPane;

/**
 *
 * @author david-cdcb
 */
public class gui extends javax.swing.JFrame {

       public int[][] m = new int[4][4];//Matriz principal
       int[][] m1 = new int[4][4];//Matriz auxiliar
       JLabel arrl[] = new JLabel[17];
       public boolean est;//Estado de suma
       public boolean est1;//Estado de traslacion
       public int punt;
       public AudioClip sonido;
       public int arr[]=new int[16];
        public int cont=0;
       public gui() {
              initComponents();

              setLocationRelativeTo(null);
              //pun.setText("Best: " + Outxt("puntaje.txt", 0));
              sonido = crearSon("bub1.wav");
           
              arrl[0] = l1;
              arrl[1] = l2;
              arrl[2] = l3;
              arrl[3] = l4;
              arrl[4] = l5;
              arrl[5] = l6;
              arrl[6] = l7;
              arrl[7] = l8;
              arrl[8] = l9;
              arrl[9] = l10;
              arrl[10] = l11;
              arrl[11] = l12;
              arrl[12] = l13;
              arrl[13] = l14;
              arrl[14] = l15;
              arrl[15] = l16;

             
               llenar(gen(arr, 16));
              
              mostrar(m, arrl);
              
       }

       public final AudioClip crearSon(String url) {
              return java.applet.Applet.newAudioClip(getClass().getResource(url));
       }

       
       public static void mostrar(int[][] M, int cf, int cc) {

              for (int i = 0; i < cc; i++) {
                     System.out.print("+--");
              }
              System.out.print("+\n");
              for (int f = 0; f <= cf - 1; f++) {

                     for (int c = 0; c <= cc - 1; c++) {
                            if (M[f][c] <= 9) {
                                   System.out.print("| " + M[f][c]);
                            } else {
                                   System.out.print("|" + M[f][c]);
                            }
                     }
                     System.out.println("|");
                     for (int i = 0; i < cc; i++) {
                            System.out.print("+--");
                     }
                     System.out.print("+\n");

              }

       }
       
       public static int[] gen(int numeros[], int sal) {

              for (int i = 0; i < numeros.length; i++) {
                     numeros[i] = 0;
              }
              Random rnd = new Random();
              int n = 0;
              for (int i = 0; i < numeros.length; i++) {
                     do {
                            n = rnd.nextInt(sal);
         
                     } while (comp(numeros, i, n));
                     System.out.println(n);
                     numeros[i] = n;
              }
              return numeros;
       }

       public static boolean comp(int[] numeros, int indice, int valor) {
              for (int i = 0; i < indice; i++) {
                     if (numeros[i] == valor) {
                            return true;
                     }
              }
              return false;
       }
       
       public void mostrar(int[][] M, JLabel arrl[]) {
              int ind = 0;
 
              for (int i = 0; i < M.length; i++) {
                     for (int j = 0; j < M.length; j++) {
                            arrl[ind].setText("" + M[i][j]);
                          
                            if ("0".equals(arrl[ind].getText())) {
                                   arrl[ind].setText(" ");
                                   arrl[ind].setBackground(new java.awt.Color(0, 153, 153));
                                   arrl[ind].setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 3, true));
                            }else{
                                   arrl[ind].setBackground(new java.awt.Color(0, 204, 204));
                                   arrl[ind].setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
                            } 
                            if (ind < arrl.length) {
                                   ind++;
                            }
                     }
              }

       }

      

       public void  llenar(int numeros[]) {
              int ind=0;
              for (int i = 0; i < m.length; i++) {
                     for (int j = 0; j < m.length; j++) {
                           if(ind<numeros.length){
                                  m[i][j]=numeros[ind];
                                  ind++;
                           }
                     }
                     
              }
    
       }

       public static boolean compv(int[][] m) {//Comprovacion cion de victoria
              boolean est = true;
              int num=0;
              for (int f = 0; f < m.length; f++) {

                     for (int c = 0; c < m.length; c++) {
                            num++;
                            if(num==16)
                                   num=0;
                            //System.out.println(num+"-"+m[f][c]);
                            if (m[f][c] != num) {
                                   est = false;
                            }      
                     }

              }

              return est;
       }

      

 

       public int[][] derN3(int m[][]) {//Suma de Iguales hacia la derecha
              int aux;
              for (int f = 0; f < m.length; f++) {
                     for (int c = 0; c < m.length; c++) {
                           if(m[f][c]==0&&c+1<m.length){
                                  cont++;
                                  aux=m[f][c];
                                  m[f][c]=m[f][c+1];
                                  m[f][c+1]=aux;
                                  break;
                           }
                     }
              }

              
              return m;
       }

       public int[][] izN3(int m[][]) {
            int aux;
              for (int f = 0; f < m.length; f++) {
                     for (int c = 0; c < m.length; c++) {
                           if(m[f][c]==0&&c>0){
                                  cont++;
                                  aux=m[f][c];
                                  m[f][c]=m[f][c-1];
                                  m[f][c-1]=aux;
                           }
                     }
              }

              return m;
       }

       public int[][] abN3(int m[][]) {
              int aux;
              boolean b = false;
              for (int f = 0; f < m.length; f++) {
                     for (int c = 0; c < m.length; c++) {
                            if (b == false) {
                                   if (m[f][c] == 0 && f + 1 < m.length) {
                                          cont++;
                                          aux = m[f][c];
                                          m[f][c] = m[f + 1][c];
                                          m[f + 1][c] = aux;
                                          b = true;
                                   }
                            }
                     }

              }

              return m;
       }

       public int[][] arN3(int m[][]) {
              int aux;
              for (int f = 0; f < m.length; f++) {
                     for (int c = 0; c < m.length; c++) {
                           if(m[f][c]==0&&f>0){
                                  cont++;
                                  aux=m[f][c];
                                  m[f][c]=m[f-1][c];
                                  m[f-1][c]=aux;
                                  break;
                           }
                     }
              }
              return m;
       }

       public void ver() {

              if (cont > 500)
                     t1.setText("JAJAJAJAJAJA");

              if (compv(getM())) {
                     t1.setForeground(Color.yellow);
                     t1.setText("YOU WIN");
                     JOptionPane.showMessageDialog(this, "Ok me toca trapear .");
              }
              System.out.println(est + "-" + cont);

              if (est || est1) {
                     // setM(llenar(getM()));
                     est1 = false;
              }

              sonido.play();
              pun1.setText("Movimientos: " + cont);
              mostrar(getM(), arrl);
              mostrar(m, 4, 4);

       }

       @SuppressWarnings("unchecked")
       // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
       private void initComponents() {

              jPanel1 = new javax.swing.JPanel();
              t1 = new javax.swing.JLabel();
              jButton2 = new javax.swing.JButton();
              pun1 = new javax.swing.JLabel();
              jButton4 = new javax.swing.JButton();
              l4 = new javax.swing.JLabel();
              l3 = new javax.swing.JLabel();
              l2 = new javax.swing.JLabel();
              l1 = new javax.swing.JLabel();
              l5 = new javax.swing.JLabel();
              l6 = new javax.swing.JLabel();
              l7 = new javax.swing.JLabel();
              l8 = new javax.swing.JLabel();
              l12 = new javax.swing.JLabel();
              l11 = new javax.swing.JLabel();
              l10 = new javax.swing.JLabel();
              l9 = new javax.swing.JLabel();
              l13 = new javax.swing.JLabel();
              l14 = new javax.swing.JLabel();
              l15 = new javax.swing.JLabel();
              l16 = new javax.swing.JLabel();

              setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
              setUndecorated(true);
              setResizable(false);
              addKeyListener(new java.awt.event.KeyAdapter() {
                     public void keyPressed(java.awt.event.KeyEvent evt) {
                            formKeyPressed(evt);
                     }
              });

              jPanel1.setBackground(new java.awt.Color(0, 153, 153));
              jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 2, true));

              t1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
              t1.setForeground(new java.awt.Color(255, 255, 255));
              t1.setText("PUZZLE 15 By CDCB");

              jButton2.setBackground(new java.awt.Color(0, 204, 204));
              jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
              jButton2.setForeground(new java.awt.Color(255, 255, 255));
              jButton2.setText("RESET");
              jButton2.setFocusPainted(false);
              jButton2.setFocusable(false);
              jButton2.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton2ActionPerformed(evt);
                     }
              });

              pun1.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
              pun1.setForeground(new java.awt.Color(251, 244, 0));
              pun1.setText("Movimientos: ");

              jButton4.setBackground(new java.awt.Color(255, 0, 0));
              jButton4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
              jButton4.setForeground(new java.awt.Color(255, 255, 255));
              jButton4.setText("X");
              jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
              jButton4.setFocusable(false);
              jButton4.setRequestFocusEnabled(false);
              jButton4.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton4ActionPerformed(evt);
                     }
              });

              l4.setBackground(new java.awt.Color(0, 204, 204));
              l4.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
              l4.setForeground(new java.awt.Color(248, 248, 248));
              l4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l4.setText("0");
              l4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
              l4.setMaximumSize(new java.awt.Dimension(30, 30));
              l4.setMinimumSize(new java.awt.Dimension(30, 30));
              l4.setOpaque(true);
              l4.setPreferredSize(new java.awt.Dimension(20, 20));

              l3.setBackground(new java.awt.Color(0, 204, 204));
              l3.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
              l3.setForeground(new java.awt.Color(248, 248, 248));
              l3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l3.setText("0");
              l3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
              l3.setMaximumSize(new java.awt.Dimension(30, 30));
              l3.setMinimumSize(new java.awt.Dimension(30, 30));
              l3.setOpaque(true);
              l3.setPreferredSize(new java.awt.Dimension(20, 20));

              l2.setBackground(new java.awt.Color(0, 204, 204));
              l2.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
              l2.setForeground(new java.awt.Color(248, 248, 248));
              l2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l2.setText("0");
              l2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
              l2.setMaximumSize(new java.awt.Dimension(30, 30));
              l2.setMinimumSize(new java.awt.Dimension(30, 30));
              l2.setOpaque(true);
              l2.setPreferredSize(new java.awt.Dimension(20, 20));

              l1.setBackground(new java.awt.Color(0, 204, 204));
              l1.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
              l1.setForeground(new java.awt.Color(248, 248, 248));
              l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l1.setText("0");
              l1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
              l1.setMaximumSize(new java.awt.Dimension(30, 30));
              l1.setMinimumSize(new java.awt.Dimension(30, 30));
              l1.setOpaque(true);
              l1.setPreferredSize(new java.awt.Dimension(20, 20));

              l5.setBackground(new java.awt.Color(0, 204, 204));
              l5.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
              l5.setForeground(new java.awt.Color(248, 248, 248));
              l5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l5.setText("0");
              l5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
              l5.setMaximumSize(new java.awt.Dimension(30, 30));
              l5.setMinimumSize(new java.awt.Dimension(30, 30));
              l5.setOpaque(true);
              l5.setPreferredSize(new java.awt.Dimension(20, 20));

              l6.setBackground(new java.awt.Color(0, 204, 204));
              l6.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
              l6.setForeground(new java.awt.Color(248, 248, 248));
              l6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l6.setText("0");
              l6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
              l6.setMaximumSize(new java.awt.Dimension(30, 30));
              l6.setMinimumSize(new java.awt.Dimension(30, 30));
              l6.setOpaque(true);
              l6.setPreferredSize(new java.awt.Dimension(20, 20));

              l7.setBackground(new java.awt.Color(0, 204, 204));
              l7.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
              l7.setForeground(new java.awt.Color(248, 248, 248));
              l7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l7.setText("0");
              l7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
              l7.setMaximumSize(new java.awt.Dimension(30, 30));
              l7.setMinimumSize(new java.awt.Dimension(30, 30));
              l7.setOpaque(true);
              l7.setPreferredSize(new java.awt.Dimension(20, 20));
              l7.addMouseListener(new java.awt.event.MouseAdapter() {
                     public void mouseClicked(java.awt.event.MouseEvent evt) {
                            l7MouseClicked(evt);
                     }
              });

              l8.setBackground(new java.awt.Color(0, 204, 204));
              l8.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
              l8.setForeground(new java.awt.Color(248, 248, 248));
              l8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l8.setText("0");
              l8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
              l8.setMaximumSize(new java.awt.Dimension(30, 30));
              l8.setMinimumSize(new java.awt.Dimension(30, 30));
              l8.setOpaque(true);
              l8.setPreferredSize(new java.awt.Dimension(20, 20));

              l12.setBackground(new java.awt.Color(0, 204, 204));
              l12.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
              l12.setForeground(new java.awt.Color(248, 248, 248));
              l12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l12.setText("0");
              l12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
              l12.setMaximumSize(new java.awt.Dimension(30, 30));
              l12.setMinimumSize(new java.awt.Dimension(30, 30));
              l12.setOpaque(true);
              l12.setPreferredSize(new java.awt.Dimension(20, 20));
              l12.addMouseListener(new java.awt.event.MouseAdapter() {
                     public void mouseClicked(java.awt.event.MouseEvent evt) {
                            l12MouseClicked(evt);
                     }
              });

              l11.setBackground(new java.awt.Color(0, 204, 204));
              l11.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
              l11.setForeground(new java.awt.Color(248, 248, 248));
              l11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l11.setText("0");
              l11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
              l11.setMaximumSize(new java.awt.Dimension(30, 30));
              l11.setMinimumSize(new java.awt.Dimension(30, 30));
              l11.setOpaque(true);
              l11.setPreferredSize(new java.awt.Dimension(20, 20));

              l10.setBackground(new java.awt.Color(0, 204, 204));
              l10.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
              l10.setForeground(new java.awt.Color(248, 248, 248));
              l10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l10.setText("0");
              l10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
              l10.setMaximumSize(new java.awt.Dimension(30, 30));
              l10.setMinimumSize(new java.awt.Dimension(30, 30));
              l10.setOpaque(true);
              l10.setPreferredSize(new java.awt.Dimension(20, 20));
              l10.addMouseListener(new java.awt.event.MouseAdapter() {
                     public void mouseClicked(java.awt.event.MouseEvent evt) {
                            l10MouseClicked(evt);
                     }
              });

              l9.setBackground(new java.awt.Color(0, 204, 204));
              l9.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
              l9.setForeground(new java.awt.Color(248, 248, 248));
              l9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l9.setText("0");
              l9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
              l9.setMaximumSize(new java.awt.Dimension(30, 30));
              l9.setMinimumSize(new java.awt.Dimension(30, 30));
              l9.setOpaque(true);
              l9.setPreferredSize(new java.awt.Dimension(20, 20));

              l13.setBackground(new java.awt.Color(0, 204, 204));
              l13.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
              l13.setForeground(new java.awt.Color(248, 248, 248));
              l13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l13.setText("0");
              l13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
              l13.setMaximumSize(new java.awt.Dimension(30, 30));
              l13.setMinimumSize(new java.awt.Dimension(30, 30));
              l13.setOpaque(true);
              l13.setPreferredSize(new java.awt.Dimension(20, 20));

              l14.setBackground(new java.awt.Color(0, 204, 204));
              l14.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
              l14.setForeground(new java.awt.Color(248, 248, 248));
              l14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l14.setText("0");
              l14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
              l14.setMaximumSize(new java.awt.Dimension(30, 30));
              l14.setMinimumSize(new java.awt.Dimension(30, 30));
              l14.setOpaque(true);
              l14.setPreferredSize(new java.awt.Dimension(20, 20));

              l15.setBackground(new java.awt.Color(0, 204, 204));
              l15.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
              l15.setForeground(new java.awt.Color(248, 248, 248));
              l15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l15.setText("0");
              l15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
              l15.setMaximumSize(new java.awt.Dimension(30, 30));
              l15.setMinimumSize(new java.awt.Dimension(30, 30));
              l15.setOpaque(true);
              l15.setPreferredSize(new java.awt.Dimension(20, 20));
              l15.addMouseListener(new java.awt.event.MouseAdapter() {
                     public void mouseClicked(java.awt.event.MouseEvent evt) {
                            l15MouseClicked(evt);
                     }
              });

              l16.setBackground(new java.awt.Color(0, 204, 204));
              l16.setFont(new java.awt.Font("Ravie", 1, 36)); // NOI18N
              l16.setForeground(new java.awt.Color(248, 248, 248));
              l16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l16.setText("0");
              l16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
              l16.setMaximumSize(new java.awt.Dimension(30, 30));
              l16.setMinimumSize(new java.awt.Dimension(30, 30));
              l16.setOpaque(true);
              l16.setPreferredSize(new java.awt.Dimension(20, 20));

              javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
              jPanel1.setLayout(jPanel1Layout);
              jPanel1Layout.setHorizontalGroup(
                     jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                          .addComponent(pun1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                          .addComponent(jButton2))
                                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                          .addGap(0, 0, Short.MAX_VALUE)
                                          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                 .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(l5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(l6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(l7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(l8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                 .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                               .addComponent(l9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                               .addComponent(l13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                               .addGroup(jPanel1Layout.createSequentialGroup()
                                                                      .addComponent(l10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                      .addComponent(l11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                      .addComponent(l12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                               .addGroup(jPanel1Layout.createSequentialGroup()
                                                                      .addComponent(l14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                      .addComponent(l15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                      .addComponent(l16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                 .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                               .addComponent(t1)
                                                               .addGroup(jPanel1Layout.createSequentialGroup()
                                                                      .addComponent(l1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                      .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                      .addComponent(l3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                               .addGroup(jPanel1Layout.createSequentialGroup()
                                                                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                      .addComponent(l4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                      .addGap(67, 67, 67)
                                                                      .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addContainerGap())
              );

              jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {l1, l10, l11, l12, l13, l14, l15, l16, l2, l3, l4, l5, l6, l7, l8, l9});

              jPanel1Layout.setVerticalGroup(
                     jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(t1, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(pun1)
                                   .addComponent(jButton2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(l3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(l4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(l6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(l5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(l7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(l8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(l9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(l10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(l11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(l12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(l13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(l14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(l15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(l16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              );

              jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {l1, l10, l11, l12, l13, l14, l15, l16, l2, l3, l4, l5, l6, l7, l8, l9});

              javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
              getContentPane().setLayout(layout);
              layout.setHorizontalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              );
              layout.setVerticalGroup(
                     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              );

              pack();
       }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
           System.out.println(evt.getKeyCode());
           switch (evt.getKeyCode()) {

                  case 65:  //izquierda 65
                        
                         derN3(getM());
                         ver();
                        
                         break;
                  case 68:  // derecha 68

                         izN3(getM());
                        ver();
      
                         break;
                  case 87:  // arriba 87

                         abN3(getM());      
                         ver();

                         break;
                  case 83:  // abajo 83

                         arN3(getM());
                         ver();

                         break;
                         
                  case 37:  // abajo 83

                         derN3(getM());
                         ver();

                         break;
                         
                  case 39:  // abajo 83

                          izN3(getM());
                         ver();

                         break;
                  case 38:  // abajo 83

                         abN3(getM()); 
                         ver();

                         break;
                 case 40:  // abajo 83

                         arN3(getM());
                         ver();

                         break;
           }
    }//GEN-LAST:event_formKeyPressed

       private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
             cont=0;
              llenar(gen(arr, 16));
              mostrar(getM(), arrl);
       }//GEN-LAST:event_jButton2ActionPerformed

       private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
              System.exit(0);
       }//GEN-LAST:event_jButton4ActionPerformed

       private void l7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l7MouseClicked
   
              arN3(getM());
              ver();
       }//GEN-LAST:event_l7MouseClicked

       private void l15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l15MouseClicked

              abN3(getM());
              ver();
       }//GEN-LAST:event_l15MouseClicked

       private void l10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l10MouseClicked
    
              izN3(getM());
              ver();
       }//GEN-LAST:event_l10MouseClicked

       private void l12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l12MouseClicked
         
              derN3(getM());
              ver();
       }//GEN-LAST:event_l12MouseClicked

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
                     java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (InstantiationException ex) {
                     java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (IllegalAccessException ex) {
                     java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                     java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
              }
              //</editor-fold>

              /* Create and display the form */
              java.awt.EventQueue.invokeLater(new Runnable() {
                     public void run() {
                            new gui().setVisible(true);
                     }
              });
       }

       // Variables declaration - do not modify//GEN-BEGIN:variables
       public javax.swing.JButton jButton2;
       public javax.swing.JButton jButton4;
       public javax.swing.JPanel jPanel1;
       public javax.swing.JLabel l1;
       public javax.swing.JLabel l10;
       public javax.swing.JLabel l11;
       public javax.swing.JLabel l12;
       public javax.swing.JLabel l13;
       public javax.swing.JLabel l14;
       public javax.swing.JLabel l15;
       public javax.swing.JLabel l16;
       public javax.swing.JLabel l2;
       public javax.swing.JLabel l3;
       public javax.swing.JLabel l4;
       public javax.swing.JLabel l5;
       public javax.swing.JLabel l6;
       public javax.swing.JLabel l7;
       public javax.swing.JLabel l8;
       public javax.swing.JLabel l9;
       public javax.swing.JLabel pun1;
       public javax.swing.JLabel t1;
       // End of variables declaration//GEN-END:variables

       public int getPunt() {
              return punt;
       }

       public void setPunt(int punt) {
              this.punt = punt;
       }

       public int[][] getM() {
              return m;
       }

       public void setM(int[][] m) {
              this.m = m;
       }
}

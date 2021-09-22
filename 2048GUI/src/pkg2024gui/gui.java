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

       public gui() {
              initComponents();
              setLocationRelativeTo(null);
              pun.setText("Best: " + Outxt("puntaje.txt", 0));
              sonido = crearSon("bub1.wav");
              jPanel1.setBackground(Color.black);

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

              mostrar(llenar(m), arrl);
       }

       public final AudioClip crearSon(String url) {
              return java.applet.Applet.newAudioClip(getClass().getResource(url));
       }

       public void mostrar(int[][] M, JLabel arrl[]) {
              int ind = 0;

              
              
              for (int i = 0; i < M.length; i++) {
                     for (int j = 0; j < M.length; j++) {
                            arrl[ind].setText("" + M[i][j]);

                            if ("0".equals(arrl[ind].getText())) {
                                   arrl[ind].setForeground(Color.white);
                            } else if ("2".equals(arrl[ind].getText())) {
                                   arrl[ind].setForeground(Color.yellow);
                            } else if ("4".equals(arrl[ind].getText())) {
                                   arrl[ind].setForeground(Color.red);
                            } else {
                                   arrl[ind].setForeground(Color.green);
                            }
                            if (ind < arrl.length) {
                                   ind++;
                            }
                     }
              }

       }

       public String save(int[][] M) {//Guardado en cadena
              String cad = "";
              for (int i = 0; i < M.length; i++) {
                     for (int j = 0; j < M.length; j++) {
                            cad = cad + M[i][j] + "-";
                     }
              }
              System.out.println(cad);
              return cad;
       }

       public int[][] load(int[][] M) {//Cargado de cadena
              char[] arr = Outxt("partida.txt", 1).toCharArray();
              String[] nums = new String[arr.length];
              String num = "";
              int ind1 = 0;
              for (int i = 0; i < arr.length; i++) {

                     if (arr[i] != '-') {

                            if (arr[i + 1] != '-') {
                                   num = num + arr[i];

                            } else {
                                   if ("".equals(num))
                                          num = arr[i] + "";
                                   else
                                          num = num + arr[i];

                                   nums[ind1] = num;

                                   if (ind1 < nums.length)
                                          ind1++;
                            }
                     } else
                            num = "";
              }
              int ind = 0;
              for (int i = 0; i < M.length; i++) {
                     for (int j = 0; j < M.length; j++) {
                            M[i][j] = Integer.parseInt(nums[ind]);
                            if (ind < nums.length)
                                   ind++;
                     }
              }
              pun1.setText("Score: " + punt);
              return M;
       }

       public void aPunt(int n) {//Actualizar puntaje
              setPunt(getPunt() + n);
              est = true;
              pun1.setText("Score: " + punt);
       }

       public void gDes() {//Guardar en temporal
              for (int i = 0; i < getM().length; i++) {
                     for (int j = 0; j < getM().length; j++) {
                            m1[i][j] = getM()[i][j];
                            System.out.println(m1[i][j] + "");
                     }
              }

       }

       public final String Intxt(String txt, String ndat) {

              File fichero;
              PrintWriter insertar;
              int cont = 0;

              char[] arrc = ndat.toCharArray();
              for (int i = 0; i < arrc.length; i++) {
                     arrc[i] = (char) (arrc[i] + (char) 3);
              }
              ndat = String.valueOf(arrc);

              fichero = new File(txt);
              if (!fichero.exists()) {
                     try {
                            fichero.createNewFile();
                            insertar = new PrintWriter(fichero, "utf-8");
                            insertar.println("0");
                            insertar.close();

                     } catch (IOException ex) {
                     }
              } else {
                     try {
                            System.out.println("------");
                            insertar = new PrintWriter(fichero, "utf-8");
                            insertar.println(ndat);
                            insertar.println(punt);
                            insertar.close();

                     } catch (IOException ex) {
                     }

              }
              return ndat;
       }

       public final String Outxt(String file, int b) {
              int cont = 0;
              String tmp = "";
              String tmp1 = "";
              try {

                     FileReader r = new FileReader(file);
                     BufferedReader buf = new BufferedReader(r);
                     tmp = buf.readLine();
                     if (b == 1) {

                            tmp1 = buf.readLine();
                            punt = Integer.parseInt(tmp1);
                     }

              } catch (IOException ex) {
              }

              char[] arrc = tmp.toCharArray();
              for (int i = 0; i < arrc.length; i++) {
                     arrc[i] = (char) (arrc[i] - (char) 3);
              }
              tmp = String.valueOf(arrc);

              return tmp;
       }

       public int[][] llenar(int numeros[][]) {

              Random rnd = new Random();
              int n = 0, m = 0;
              for (int i = 0; i < 1; i++) {
                     if (!compp(numeros)) {
                            do {
                                   n = rnd.nextInt(4);
                                   m = rnd.nextInt(4);
                            } while (numeros[n][m] != 0);
                            numeros[n][m] = 2;
                     }
              }

              return numeros;
       }

       public static boolean compv(int[][] m) {//Comprovacion cion de victoria
              boolean est = false;
              for (int f = 0; f < 4; f++) {

                     for (int c = 0; c < 4; c++) {
                            if (m[f][c] == 2040) {
                                   est = true;
                            }
                     }

              }

              return est;
       }

       public boolean compp(int[][] m) {//Comprovacion de perdida
              boolean est = true;
              for (int f = 0; f < 4; f++) {

                     for (int c = 0; c < 4; c++) {
                            if (m[f][c] == 0) {
                                   est = false;
                            }
                     }
              }
              if (est == true) {
                     Intxt("puntaje.txt", "" + getPunt());
              }
              return est;
       }

       public int[][] cerosd(int m[][]) {//iz 0 Barrido de ceros a la Izquierda

              for (int f = 0; f < 4; f++) {
                     for (int c = 4 - 1; c >= 0; c--) {
                            if (c > 0) {
                                   if (m[f][c] == 0 && m[f][c - 1] != 0) {
                                          est1 = true;
                                          m[f][c] = m[f][c - 1];
                                          m[f][c - 1] = 0;
                                   }
                            }
                     }
              }
              return m;
       }

       public int[][] cerosi(int m[][]) {//de 0

              for (int f = 0; f < 4; f++) {
                     for (int c = 0; c < 4; c++) {
                            if (c < 3) {
                                   if (m[f][c] == 0 && m[f][c + 1] != 0) {
                                          est1 = true;
                                          m[f][c] = m[f][c + 1];
                                          m[f][c + 1] = 0;
                                   }
                            }
                     }
              }
              return m;
       }

       public int[][] cerosab(int m[][]) {//arr 0

              for (int f = 4 - 1; f >= 0; f--) {
                     for (int c = 4 - 1; c >= 0; c--) {
                            if (f > 0) {
                                   if (m[f][c] == 0 && m[f - 1][c] != 0) {
                                          est1 = true;
                                          m[f][c] = m[f - 1][c];
                                          m[f - 1][c] = 0;
                                   }
                            }
                     }
              }
              return m;
       }

       public int[][] cerosar(int m[][]) {//ab 0

              for (int f = 0; f < 4; f++) {
                     for (int c = 0; c < 4; c++) {
                            if (f < 3) {
                                   if (m[f][c] == 0 && m[f + 1][c] != 0) {
                                          est1 = true;
                                          m[f][c] = m[f + 1][c];
                                          m[f + 1][c] = 0;
                                   }
                            }
                     }
              }
              return m;
       }

       public int[][] derN3(int m[][]) {//Suma de Iguales hacia la derecha
              int b = 0;
              for (int f = 0; f < 3; f++)
                     cerosd(m);
              for (int f = 0; f < 4; f++) {
                     for (int c = 3; c >= 0; c--) {
                            if (c > 0) {
                                   if (m[f][c] == m[f][c - 1] && (m[f][c] != 0 && m[f][c - 1] != 0)) {
                                          b = 1;
                                          m[f][c] = m[f][c] + m[f][c - 1];
                                          aPunt(m[f][c]);
                                          m[f][c - 1] = 0;
                                   } else
                                          if (b == 0)
                                                 est = false;
                            }
                     }
              }

              for (int f = 0; f < 3; f++)
                     cerosd(m);
              return m;
       }

       public int[][] izN3(int m[][]) {
              int b = 0;
              for (int f = 0; f < 3; f++)
                     cerosi(m);
              for (int f = 0; f < 4; f++) {
                     for (int c = 0; c < 4; c++) {
                            if (c < 3) {
                                   if (m[f][c] == m[f][c + 1] && (m[f][c] != 0 && m[f][c + 1] != 0)) {
                                          b = 1;
                                          m[f][c] = m[f][c] + m[f][c + 1];
                                          aPunt(m[f][c]);
                                          m[f][c + 1] = 0;

                                   } else if (b == 0)
                                          est = false;
                            }
                     }
              }

              for (int f = 0; f < 3; f++)
                     cerosi(m);
              return m;
       }

       public int[][] abN3(int m[][]) {
              int b = 0;
              for (int f = 0; f < 3; f++)
                     cerosab(m);

              for (int f = 4 - 1; f >= 0; f--) {
                     for (int c = 4 - 1; c >= 0; c--) {
                            if (f > 0) {
                                   if (m[f][c] == m[f - 1][c] && (m[f][c] != 0 && m[f - 1][c] != 0)) {
                                          b = 1;
                                          m[f][c] = m[f][c] + m[f - 1][c];
                                          aPunt(m[f][c]);
                                          m[f - 1][c] = 0;

                                   } else if (b == 0)
                                          est = false;
                            }
                     }
              }
              for (int f = 0; f < 3; f++)
                     cerosab(m);

              return m;
       }

       public int[][] arN3(int m[][]) {
              int b = 0;
              for (int f = 0; f < 3; f++)
                     cerosar(m);

              for (int f = 0; f < 4; f++) {
                     for (int c = 0; c < 4; c++) {
                            if (f < 3) {
                                   if (m[f + 1][c] == m[f][c] && (m[f][c] != 0 && m[f + 1][c] != 0)) {
                                          b = 1;
                                          m[f][c] = m[f][c] + m[f + 1][c];
                                          aPunt(m[f][c]);
                                          m[f + 1][c] = 0;
                                   } else if (b == 0)
                                          est = false;
                            }
                     }
              }
              for (int f = 0; f < 3; f++)
                     cerosar(m);
              return m;
       }

       public void ver() {
              if (compp(getM())) {
                     t1.setForeground(Color.red);
                     t1.setText("GAME OVER");
              }
              if (compv(getM())) {
                     t1.setForeground(Color.yellow);
                     t1.setText("YOU WIN");
              }
              System.out.println(est + "-" + est1);

              if (est || est1) {
                     setM(llenar(getM()));
                     est1 = false;
              }
              if (est)
                     sonido.play();

              mostrar(getM(), arrl);

              if (Integer.parseInt(Outxt("puntaje.txt", 0)) < punt) {
                     Intxt("puntaje.txt", "" + punt);
              }
              pun.setText("Best: " + Outxt("puntaje.txt", 0));

       }

       @SuppressWarnings("unchecked")
       // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
       private void initComponents() {

              jPanel1 = new javax.swing.JPanel();
              l3 = new javax.swing.JLabel();
              l12 = new javax.swing.JLabel();
              l4 = new javax.swing.JLabel();
              l15 = new javax.swing.JLabel();
              l5 = new javax.swing.JLabel();
              l16 = new javax.swing.JLabel();
              l13 = new javax.swing.JLabel();
              l6 = new javax.swing.JLabel();
              l7 = new javax.swing.JLabel();
              l8 = new javax.swing.JLabel();
              l14 = new javax.swing.JLabel();
              l9 = new javax.swing.JLabel();
              l1 = new javax.swing.JLabel();
              l10 = new javax.swing.JLabel();
              l2 = new javax.swing.JLabel();
              l11 = new javax.swing.JLabel();
              pun = new javax.swing.JLabel();
              t1 = new javax.swing.JLabel();
              jButton1 = new javax.swing.JButton();
              jButton2 = new javax.swing.JButton();
              pun1 = new javax.swing.JLabel();
              jButton3 = new javax.swing.JButton();
              jButton4 = new javax.swing.JButton();

              setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
              setUndecorated(true);
              setResizable(false);
              addKeyListener(new java.awt.event.KeyAdapter() {
                     public void keyPressed(java.awt.event.KeyEvent evt) {
                            formKeyPressed(evt);
                     }
              });

              jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 255, 51), 2, true));

              l3.setBackground(new java.awt.Color(8, 1, 1));
              l3.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
              l3.setForeground(new java.awt.Color(248, 248, 248));
              l3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l3.setText("0");
              l3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 152, 253), 3, true));
              l3.setMaximumSize(new java.awt.Dimension(40, 40));
              l3.setMinimumSize(new java.awt.Dimension(40, 40));

              l12.setBackground(new java.awt.Color(8, 1, 1));
              l12.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
              l12.setForeground(new java.awt.Color(248, 248, 248));
              l12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l12.setText("0");
              l12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 152, 253), 3, true));
              l12.setMaximumSize(new java.awt.Dimension(40, 40));
              l12.setMinimumSize(new java.awt.Dimension(40, 40));
              l12.addMouseListener(new java.awt.event.MouseAdapter() {
                     public void mouseClicked(java.awt.event.MouseEvent evt) {
                            l12MouseClicked(evt);
                     }
              });

              l4.setBackground(new java.awt.Color(8, 1, 1));
              l4.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
              l4.setForeground(new java.awt.Color(248, 248, 248));
              l4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l4.setText("0");
              l4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 152, 253), 3, true));
              l4.setMaximumSize(new java.awt.Dimension(40, 40));
              l4.setMinimumSize(new java.awt.Dimension(40, 40));

              l15.setBackground(new java.awt.Color(8, 1, 1));
              l15.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
              l15.setForeground(new java.awt.Color(248, 248, 248));
              l15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l15.setText("0");
              l15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 152, 253), 3, true));
              l15.setMaximumSize(new java.awt.Dimension(40, 40));
              l15.setMinimumSize(new java.awt.Dimension(40, 40));
              l15.addMouseListener(new java.awt.event.MouseAdapter() {
                     public void mouseClicked(java.awt.event.MouseEvent evt) {
                            l15MouseClicked(evt);
                     }
              });

              l5.setBackground(new java.awt.Color(8, 1, 1));
              l5.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
              l5.setForeground(new java.awt.Color(248, 248, 248));
              l5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l5.setText("0");
              l5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 152, 253), 3, true));
              l5.setMaximumSize(new java.awt.Dimension(40, 40));
              l5.setMinimumSize(new java.awt.Dimension(40, 40));

              l16.setBackground(new java.awt.Color(8, 1, 1));
              l16.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
              l16.setForeground(new java.awt.Color(248, 248, 248));
              l16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l16.setText("0");
              l16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 152, 253), 3, true));
              l16.setMaximumSize(new java.awt.Dimension(40, 40));
              l16.setMinimumSize(new java.awt.Dimension(40, 40));

              l13.setBackground(new java.awt.Color(8, 1, 1));
              l13.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
              l13.setForeground(new java.awt.Color(248, 248, 248));
              l13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l13.setText("0");
              l13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 152, 253), 3, true));
              l13.setMaximumSize(new java.awt.Dimension(40, 40));
              l13.setMinimumSize(new java.awt.Dimension(40, 40));

              l6.setBackground(new java.awt.Color(8, 1, 1));
              l6.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
              l6.setForeground(new java.awt.Color(248, 248, 248));
              l6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l6.setText("0");
              l6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 152, 253), 3, true));
              l6.setMaximumSize(new java.awt.Dimension(40, 40));
              l6.setMinimumSize(new java.awt.Dimension(40, 40));

              l7.setBackground(new java.awt.Color(8, 1, 1));
              l7.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
              l7.setForeground(new java.awt.Color(248, 248, 248));
              l7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l7.setText("0");
              l7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 152, 253), 3, true));
              l7.setMaximumSize(new java.awt.Dimension(40, 40));
              l7.setMinimumSize(new java.awt.Dimension(40, 40));
              l7.addMouseListener(new java.awt.event.MouseAdapter() {
                     public void mouseClicked(java.awt.event.MouseEvent evt) {
                            l7MouseClicked(evt);
                     }
              });

              l8.setBackground(new java.awt.Color(8, 1, 1));
              l8.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
              l8.setForeground(new java.awt.Color(248, 248, 248));
              l8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l8.setText("0");
              l8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 152, 253), 3, true));
              l8.setMaximumSize(new java.awt.Dimension(40, 40));
              l8.setMinimumSize(new java.awt.Dimension(40, 40));

              l14.setBackground(new java.awt.Color(8, 1, 1));
              l14.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
              l14.setForeground(new java.awt.Color(248, 248, 248));
              l14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l14.setText("0");
              l14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 152, 253), 3, true));
              l14.setMaximumSize(new java.awt.Dimension(40, 40));
              l14.setMinimumSize(new java.awt.Dimension(40, 40));

              l9.setBackground(new java.awt.Color(8, 1, 1));
              l9.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
              l9.setForeground(new java.awt.Color(248, 248, 248));
              l9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l9.setText("0");
              l9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 152, 253), 3, true));
              l9.setMaximumSize(new java.awt.Dimension(40, 40));
              l9.setMinimumSize(new java.awt.Dimension(40, 40));

              l1.setBackground(new java.awt.Color(8, 1, 1));
              l1.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
              l1.setForeground(new java.awt.Color(248, 248, 248));
              l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l1.setText("0");
              l1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 152, 253), 3, true));
              l1.setMaximumSize(new java.awt.Dimension(40, 40));
              l1.setMinimumSize(new java.awt.Dimension(40, 40));

              l10.setBackground(new java.awt.Color(8, 1, 1));
              l10.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
              l10.setForeground(new java.awt.Color(248, 248, 248));
              l10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l10.setText("0");
              l10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 152, 253), 3, true));
              l10.setMaximumSize(new java.awt.Dimension(40, 40));
              l10.setMinimumSize(new java.awt.Dimension(40, 40));
              l10.addMouseListener(new java.awt.event.MouseAdapter() {
                     public void mouseClicked(java.awt.event.MouseEvent evt) {
                            l10MouseClicked(evt);
                     }
              });

              l2.setBackground(new java.awt.Color(8, 1, 1));
              l2.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
              l2.setForeground(new java.awt.Color(248, 248, 248));
              l2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l2.setText("0");
              l2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 152, 253), 3, true));
              l2.setMaximumSize(new java.awt.Dimension(40, 40));
              l2.setMinimumSize(new java.awt.Dimension(40, 40));

              l11.setBackground(new java.awt.Color(8, 1, 1));
              l11.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
              l11.setForeground(new java.awt.Color(248, 248, 248));
              l11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
              l11.setText("0");
              l11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 152, 253), 3, true));
              l11.setMaximumSize(new java.awt.Dimension(40, 40));
              l11.setMinimumSize(new java.awt.Dimension(40, 40));

              pun.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
              pun.setForeground(new java.awt.Color(251, 244, 0));
              pun.setText("Best:");

              t1.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
              t1.setForeground(new java.awt.Color(0, 133, 251));
              t1.setText("2048");

              jButton1.setBackground(new java.awt.Color(51, 51, 51));
              jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
              jButton1.setForeground(new java.awt.Color(0, 204, 204));
              jButton1.setText("SAVE");
              jButton1.setFocusPainted(false);
              jButton1.setFocusable(false);
              jButton1.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton1ActionPerformed(evt);
                     }
              });

              jButton2.setBackground(new java.awt.Color(51, 51, 51));
              jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
              jButton2.setForeground(new java.awt.Color(0, 204, 204));
              jButton2.setText("LOAD");
              jButton2.setFocusPainted(false);
              jButton2.setFocusable(false);
              jButton2.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton2ActionPerformed(evt);
                     }
              });

              pun1.setFont(new java.awt.Font("Noto Sans", 1, 14)); // NOI18N
              pun1.setForeground(new java.awt.Color(251, 244, 0));
              pun1.setText("Score:");

              jButton3.setBackground(new java.awt.Color(51, 51, 51));
              jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
              jButton3.setForeground(new java.awt.Color(0, 204, 204));
              jButton3.setText("UNDO");
              jButton3.setFocusPainted(false);
              jButton3.setFocusable(false);
              jButton3.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton3ActionPerformed(evt);
                     }
              });

              jButton4.setBackground(new java.awt.Color(0, 0, 0));
              jButton4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
              jButton4.setForeground(new java.awt.Color(255, 0, 0));
              jButton4.setText("X");
              jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
              jButton4.setFocusable(false);
              jButton4.setRequestFocusEnabled(false);
              jButton4.addActionListener(new java.awt.event.ActionListener() {
                     public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton4ActionPerformed(evt);
                     }
              });

              javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
              jPanel1.setLayout(jPanel1Layout);
              jPanel1Layout.setHorizontalGroup(
                     jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
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
                                          .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(l3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                          .addComponent(l4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jButton1)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jButton2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jButton3))
                                                 .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(83, 83, 83)
                                                        .addComponent(t1)))
                                          .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                 .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(pun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                 .addComponent(pun1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              );

              jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {l1, l10, l11, l12, l13, l14, l15, l16, l2, l3, l4, l5, l6, l7, l8, l9});

              jPanel1Layout.setVerticalGroup(
                     jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                          .addComponent(t1)
                                          .addComponent(pun)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jButton1)
                                   .addComponent(jButton2)
                                   .addComponent(pun1)
                                   .addComponent(jButton3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addContainerGap())
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
                     .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              );

              pack();
       }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
           System.out.println(evt.getKeyCode());
           switch (evt.getKeyCode()) {

                  case 65:  //izquierda 65
                         gDes();
                         izN3(getM());
                         ver();
                         break;
                  case 68:  // derecha 68
                         gDes();
                         derN3(getM());
                         ver();
                         break;
                  case 87:  // arriba 87
                         gDes();
                         arN3(getM());
                         ver();
                         break;
                  case 83:  // abajo 83
                         gDes();
                         abN3(getM());
                         ver();
                         break;
           }
    }//GEN-LAST:event_formKeyPressed

       private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
              Intxt("partida.txt", save(getM()));
       }//GEN-LAST:event_jButton1ActionPerformed

       private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
              setM(load(getM()));
              mostrar(getM(), arrl);
       }//GEN-LAST:event_jButton2ActionPerformed

       private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
              mostrar(m1, arrl);
       }//GEN-LAST:event_jButton3ActionPerformed

       private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
              System.exit(0);
       }//GEN-LAST:event_jButton4ActionPerformed

       private void l7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l7MouseClicked
              gDes();
              arN3(getM());
              ver();
       }//GEN-LAST:event_l7MouseClicked

       private void l15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l15MouseClicked
              gDes();
              abN3(getM());
              ver();
       }//GEN-LAST:event_l15MouseClicked

       private void l10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l10MouseClicked
              gDes();
              izN3(getM());
              ver();
       }//GEN-LAST:event_l10MouseClicked

       private void l12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l12MouseClicked
              gDes();
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
       public javax.swing.JButton jButton1;
       public javax.swing.JButton jButton2;
       public javax.swing.JButton jButton3;
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
       public javax.swing.JLabel pun;
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

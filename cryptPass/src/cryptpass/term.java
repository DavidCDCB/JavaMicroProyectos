/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptpass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author David
 */
public class term {
      
        public static void main(String[] args) {
                BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
                String textUs="",key="",us="";
   
               try { 
                      System.out.println("Ingrese Texto:");
                      textUs=buff.readLine();
                      System.out.println("Llave Texto:");
                      key=buff.readLine(); 
                      
                      System.out.println("1-Encriptar 2-Desencriptar");
                     us=buff.readLine();
                      
               } catch (IOException ex) {
                      Logger.getLogger(term.class.getName()).log(Level.SEVERE, null, ex);
               }
             
               if("1".equals(us))
                      nEncriptar(textUs.toCharArray(),key.toCharArray(),0);
               else
                      nEncriptar(textUs.toCharArray(),key.toCharArray(),1);            
        
        }
        
        public static  char[] nEncriptar(char[] text,char[] arrc, int tip) {
              int as;
              
              if (tip == 0) {
                     text = Transponer(text,arrc.length);
                     Mostrar(text);
                     text = Truncar(text);
                     Mostrar(text);
                     text = Rotar(text, (int) arrc[0] + arrc[arrc.length - 1]);
                     Mostrar(text);
                     text = Inversa(text);
                     Mostrar(text);

              } else {
                     text = Inversa(text);
                     Mostrar(text);
                     text = RotarI(text, (int) arrc[0] + arrc[arrc.length - 1]);
                     Mostrar(text);
                     text = Truncar(text);
                     Mostrar(text);
                     text = Transponer(text,arrc.length);
                     Mostrar(text);

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
               System.out.println("----");
               Mostrar(text);
               
               return text;
       }

        public static void Mostrar(char[] text){
               for (int i = 0; i < text.length; i++) {
                      System.out.print(text[i]);
               }
               System.out.println("");
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

       
}

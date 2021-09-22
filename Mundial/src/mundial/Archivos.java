package mundial;

import java.io.*;
import java.util.ArrayList;

public class Archivos {

       public static void main(String[] args) {
   
       }

       public static ArrayList<String> Leer(String file) {
              File archivo = null;
              FileReader fr = null;
              BufferedReader br = null;
              ArrayList<String> lista = new ArrayList<String>();
            
              try {
                     archivo = new File(file);
                     fr = new FileReader(archivo);
                     br = new BufferedReader(fr);
                     String linea = "";

                     for (int i = 0; (linea = br.readLine()) != null; i++) {
                            lista.add(linea);
                            System.out.println(lista.get(i));
                     }

              } catch (Exception e) {
                     e.printStackTrace();
              } finally {
                     try {
                            if (null != fr)
                                   fr.close();

                     } catch (Exception e2) {
                            e2.printStackTrace();
                     }
              }
              return lista;
       }

       public static void Escribir(String text, String file,boolean rem) {
              FileWriter fichero = null;
              PrintWriter pw = null;
              try {
                     fichero = new FileWriter(file, rem);
                     pw = new PrintWriter(fichero);
                     System.out.println(text);
                     pw.println(text);

              } catch (Exception e) {
                     e.printStackTrace();
              } finally {
                     try {
                            if (null != fichero)
                                   fichero.close();
                     } catch (Exception e2) {
                            e2.printStackTrace();
                     }
              }

       }
}

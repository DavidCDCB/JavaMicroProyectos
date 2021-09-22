
package cine;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Cine {


       public static void main(String[] args) {
              
              try {
                  UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
              } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
              }
            Principal prin=new Principal();
            prin.setVisible(true);
            
            
            
       }
       
}

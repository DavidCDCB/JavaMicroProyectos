
package mundial;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Mundial {

       public static void main(String[] args) {
               try {
                  UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
              } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
              }
             Inicio prin=new Inicio();
             prin.setVisible(true);
       }
       
}

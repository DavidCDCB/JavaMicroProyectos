/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptpass;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;

/**
 *
 * @author david-cdcb
 */
public class CryptPass {

    /**
     * @param args the command line arguments
     */
    public static ventana v = new ventana();
    public static void main(String[] args) {
        
         
        v.setVisible(true);
        
        String pass="";
        
        System.out.println(v.input.getText());
        //pass=v.input.getText();
        

        
        char arr[]= pass.toCharArray();
        
       
        //Encriptar(arr);
        
       
    }
    
    
    
    
}

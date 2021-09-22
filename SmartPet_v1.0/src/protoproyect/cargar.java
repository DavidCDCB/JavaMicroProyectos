/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package protoproyect;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author CRISTIAN
 */
public class cargar {
    


public void cargarJpg(){
        try{
            Icon ico = new ImageIcon(getClass().getResource("logo.jpg"));
            Login.icono.setIcon(ico);
            menu.icono.setIcon(ico);
        }catch(Exception err){
            System.out.println("ds");
        }
}



}
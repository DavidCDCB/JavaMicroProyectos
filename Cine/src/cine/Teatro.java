
package cine;


public class Teatro {
       private int codigo;
       private String nombre;
       private int forMun;

       public Teatro() {
       }

       public Teatro(int codigo, String nombre, int forMun) {
              this.codigo = codigo;
              this.nombre = nombre;
              this.forMun = forMun;
       }

       public int getCodigo() {
              return codigo;
       }

       public void setCodigo(int codigo) {
              this.codigo = codigo;
       }

       public String getNombre() {
              return nombre;
       }

       public void setNombre(String nombre) {
              this.nombre = nombre;
       }

       public int getForMun() {
              return forMun;
       }

       public void setForMun(int forMun) {
              this.forMun = forMun;
       }
       
       
}

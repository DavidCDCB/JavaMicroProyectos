
package cine;


public class Municipio {
       private int codigo;
       private String nombre;
       private int forDep;

       public Municipio() {
       }

       public Municipio(int codigo, String nombre, int forDep) {
              this.codigo = codigo;
              this.nombre = nombre;
              this.forDep = forDep;
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

       public int getForDep() {
              return forDep;
       }

       public void setForDep(int forDep) {
              this.forDep = forDep;
       }
       
       
       
}

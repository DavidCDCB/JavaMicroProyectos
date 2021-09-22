
package cine;


public class Sala {
       private int codigo;
       private int nombre;
       private int capacidad;
       private String programacion;
       private int forTe;

       public Sala() {
       }

       public Sala(int codigo, int nombre, int capacidad, String programacion, int forTe) {
              this.codigo = codigo;
              this.nombre = nombre;
              this.capacidad = capacidad;
              this.programacion = programacion;
              this.forTe = forTe;
       }

       public int getCodigo() {
              return codigo;
       }

       public void setCodigo(int codigo) {
              this.codigo = codigo;
       }

       public int getNombre() {
              return nombre;
       }

       public void setNombre(int nombre) {
              this.nombre = nombre;
       }

       public int getCapacidad() {
              return capacidad;
       }

       public void setCapacidad(int capacidad) {
              this.capacidad = capacidad;
       }

       public String getProgramacion() {
              return programacion;
       }

       public void setProgramacion(String programacion) {
              this.programacion = programacion;
       }

       public int getForTe() {
              return forTe;
       }

       public void setForTe(int forTe) {
              this.forTe = forTe;
       }
       
       
}

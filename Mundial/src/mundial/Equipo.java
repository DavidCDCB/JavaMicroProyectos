package mundial;

public class Equipo {
       private String Nombre;
       private String Posicion;
       private String Pais;
       private int golF;
       private int golC;
       private String clasificacion;

       public Equipo() {
       }

       public Equipo(String Nombre, String Posicion, String Pais) {
              this.Nombre = Nombre;
              this.Posicion = Posicion;
              this.Pais = Pais;
       }

       public String getNombre() {
              return Nombre;
       }

       public void setNombre(String Nombre) {
              this.Nombre = Nombre;
       }

       public String getPosicion() {
              return Posicion;
       }

       public void setPosicion(String Posicion) {
              this.Posicion = Posicion;
       }

       public String getPais() {
              return Pais;
       }

       public void setPais(String Pais) {
              this.Pais = Pais;
       }

       public int getGolF() {
              return golF;
       }

       public void setGolF(int golF) {
              this.golF = golF;
       }

       public int getGolC() {
              return golC;
       }

       public void setGolC(int golC) {
              this.golC = golC;
       }

       public String getClasificacion() {
              return clasificacion;
       }

       public void setClasificacion(String clasificacion) {
              this.clasificacion = clasificacion;
       }
       
       
       
       
}

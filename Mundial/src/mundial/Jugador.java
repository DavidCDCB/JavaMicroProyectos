
package mundial;


public class Jugador {
       private int id;
       private String Nombre;
       private String Apellido;
       private String Posicion;
       private int Camiseta;
       private String Nacimiento;
       private String forEquipo;

       public Jugador() {
       }

       public Jugador(int id, String Nombre, String Apellido, String Posicion, int Camiseta, String Nacimiento, String forEquipo) {
              this.id = id;
              this.Nombre = Nombre;
              this.Apellido = Apellido;
              this.Posicion = Posicion;
              this.Camiseta = Camiseta;
              this.Nacimiento = Nacimiento;
              this.forEquipo= forEquipo;
       }

       public int getId() {
              return id;
       }

       public void setId(int id) {
              this.id = id;
       }

       public String getNombre() {
              return Nombre;
       }

       public void setNombre(String Nombre) {
              this.Nombre = Nombre;
       }

       public String getApellido() {
              return Apellido;
       }

       public void setApellido(String Apellido) {
              this.Apellido = Apellido;
       }

       public String getPosicion() {
              return Posicion;
       }

       public void setPosicion(String Posicion) {
              this.Posicion = Posicion;
       }

       public int getCamiseta() {
              return Camiseta;
       }

       public void setCamiseta(int Camiseta) {
              this.Camiseta = Camiseta;
       }

       public String getNacimiento() {
              return Nacimiento;
       }

       public void setNacimiento(String Nacimiento) {
              this.Nacimiento = Nacimiento;
       }

       public String getForEquipo() {
              return forEquipo;
       }

       public void setForEquipo(String forEquipo) {
              this.forEquipo = forEquipo;
       }
       
       
}

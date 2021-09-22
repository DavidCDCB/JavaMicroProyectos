
package mundial;


public class Tecnico {
       private int id;
       private String Nombre;
       private String Apellido;
       private String Pais;
       private String Cargo;
       private String forEquipo;

       public Tecnico() {
       }

       public Tecnico(int id, String Nombre, String Apellido, String Pais, String Cargo, String forEquipo) {
              this.id = id;
              this.Nombre = Nombre;
              this.Apellido = Apellido;
              this.Pais = Pais;
              this.Cargo = Cargo;
              this.forEquipo = forEquipo;
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

       public String getPais() {
              return Pais;
       }

       public void setPais(String Pais) {
              this.Pais = Pais;
       }

       public String getCargo() {
              return Cargo;
       }

       public void setCargo(String Cargo) {
              this.Cargo = Cargo;
       }

       public String getForEquipo() {
              return forEquipo;
       }

       public void setForEquipo(String forEquipo) {
              this.forEquipo = forEquipo;
       }
       
       
       
}

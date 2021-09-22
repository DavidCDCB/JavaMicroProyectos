
package cine;


public class Pelicula {
     private String nombre;
     private String poster;
     private String genero;
     private String descripcion;
     private String duracion;
     private String forSa;

       public Pelicula() {
       }

       public Pelicula(String nombre, String poster, String genero, String descripcion, String duracion, String forSa) {
              this.nombre = nombre;
              this.poster = poster;
              this.genero = genero;
              this.descripcion = descripcion;
              this.duracion = duracion;
              this.forSa = forSa;
       }

       public String getNombre() {
              return nombre;
       }

       public void setNombre(String nombre) {
              this.nombre = nombre;
       }

       public String getPoster() {
              return poster;
       }

       public void setPoster(String poster) {
              this.poster = poster;
       }

       public String getGenero() {
              return genero;
       }

       public void setGenero(String genero) {
              this.genero = genero;
       }

       public String getDescripcion() {
              return descripcion;
       }

       public void setDescripcion(String descripcion) {
              this.descripcion = descripcion;
       }

       public String getDuracion() {
              return duracion;
       }

       public void setDuracion(String duracion) {
              this.duracion = duracion;
       }

       public String getForSa() {
              return forSa;
       }

       public void setForSa(String forSa) {
              this.forSa = forSa;
       }
     
}

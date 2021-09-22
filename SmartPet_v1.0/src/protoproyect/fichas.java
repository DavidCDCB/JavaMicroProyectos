/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package protoproyect;

/**
 *
 * @author CRISTIAN
 */
public class fichas {



     public int id;
    public int telefono;
    public String nombre;
    public String direccion;
    public String correo;
    public String masnombre;
    public String mraza;
    
    //FALTAN LA ESPECIE Y EL SEXO
    
  public   fichas(int id, int telefono, String nombre, String direccion, String correo, String mascnombre, String mraza) {
        this.id = id;
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.masnombre = mascnombre;
        this.mraza = mraza;
    }




    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the masnombre
     */
    public String getMasnombre() {
        return masnombre;
    }

    /**
     * @param masnombre the masnombre to set
     */
    public void setMasnombre(String masnombre) {
        this.masnombre = masnombre;
    }

    /**
     * @return the raza
     */
    public String getRaza() {
        return mraza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(String raza) {
        this.mraza = mraza;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contratos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author CRISTIAN
 */
public class conexion {

    public String password = "cdcb";
    public String servidor = "localhost";
    public String usuario = "root";
    public String bd = "contratos";

    protected Connection conn = null;

    //se utiliza para proteger el sistema de inyecciones de código SQL, ya que la consulta no se crea en tiempo de ejecución, sino, previamente
    protected PreparedStatement consulta;

    //Objeto para guardar los resultados de la base de datos
    protected ResultSet datos;

    public Connection conectar() throws ClassNotFoundException, SQLException {

        try {

            //Llamar o incluir el Driver de MySQL
            Class.forName("com.mysql.jdbc.Driver");

            //Crear la conexión con la BD
            conn = DriverManager.getConnection("jdbc:Mysql://" + servidor + "/" + bd, usuario, password);

            if (conn != null) {
                JOptionPane.showMessageDialog(null, "Conexión a base de datos, LISTA " + ".\nBienvenido");

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Datos de conexion incorrectos ", "Error de conexion a " + bd, JOptionPane.ERROR_MESSAGE);

        }//fin del método conectar
        return null;

    }

    //Método para desconectar la BD
    public void desconectar() throws SQLException {
        this.conn.close();
        this.consulta.close();
    }//fin del método desconectar

    public void desconectar(ResultSet rs) throws SQLException {
        this.desconectar();
        rs.close();
    }

    int ejec(String sql) throws Exception {
        int res = 0;
        Statement st = conn.createStatement();
        res = st.executeUpdate(sql);
        return res;

    }

}

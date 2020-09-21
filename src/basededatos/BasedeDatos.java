/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class BasedeDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ConexionMySQL mysql = new ConexionMySQL();

        java.sql.Connection cn = mysql.Conectar();

        if (!cn.equals(null)) {

            JOptionPane.showMessageDialog(null, "Conectado");

            try {
                String sql = "insert into img (ruta) values ('insertando desde java con los amigos')";
                String sql2 = "delete from img where id_imagen = 7";
                Statement st = cn.createStatement();

                //st.executeUpdate(sql);
                st.executeUpdate(sql2);
                ResultSet rs = st.executeQuery("SELECT * FROM img");
                while (rs.next()) {
                    System.out.println("Valor del campo ruta que esta en mysql=" + rs.getObject("ruta"));
                }

                cn.close();

            } catch (SQLException ex) {

                System.out.println("Error al desconectar " + ex);

            }

        }

    }

}

/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */

package com.leonet.app.model;

/**
 * Clase que tiene toda la parte logica del programa
 *
 * @author WILMER
 */
public class Model extends ConectionBD {

    private Usuario usuario;
//    private Statement stmt;
//    private ResultSet rs;
//    private ResultSet rt;

    public Model() {
        super();
        iniciarTablas();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    private void iniciarTablas() {
        usuario = new Usuario(this.getBasicDataSource());
    }

//    /**
//     * *
//     * Coneccion a base de datos
//     */
//    private void conectar() {
//        String pass = "1110";
//        String user = "postgres";
//        String driver = "org.postgresql.Driver";
//        String url = "jdbc:postgresql://localhost:5432/AppEducativa";
//
//        Connection cn = null;
//        try {
//            Class.forName(driver);
//            cn = DriverManager.getConnection(url, user, pass);
//            System.out.println("Coneccion exitosa");
//        } catch (ClassNotFoundException ex) {
//            JOptionPane.showMessageDialog(null, "Salio mal " + ex);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "No se realizó la conexion" + ex);
//        }
//
//        try {
//            stmt = cn.createStatement();
//            rs = stmt.executeQuery("select* from Usuario order by nickname ASC");
//
//            while (rs.next()) {
//                System.out.print("\tnick: " + rs.getObject(1));
//                System.out.print("\tpass: " + rs.getObject(4));
//                System.out.println("");
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error" + e);
//        }
//    }
//
//
//    public Statement getStmt() {
//        return stmt;
//    }
//
//    public ResultSet getRs() {
//        return rs;
//    }
//
//    public ResultSet getRt() {
//        return rt;
//    }
}

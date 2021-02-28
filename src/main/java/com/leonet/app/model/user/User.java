/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */

package com.leonet.app.model.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.leonet.app.model.databaseConection.QueriesSQL;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Clase que controla el inicio y registro de los usuarios en la base de datos
 *
 * @author WILMER
 */
public class User extends QueriesSQL {

    private static final String TABLA_USUARIO = "Usuario";
    private static final String USUARIO_BASICO = "Usuario(nickname, nombre, email, contraseña, fecha_nac, areatrabajo, ocupacion, pais)";
    private static final String USUARIO_COMPLETO = "Usuario(nickname, nombre, email, contraseña, fecha_nac, fecha_reg, nivel, coin, gemas, areatrabajo, ocupacion, pais)";
    private static final String NICKNAME = "nickname";
    private static final String EMAIL = "email";

    private String usuarioModificado = "";
    private String values = "";


    private final PasswordAuthentication ps;

    public User(BasicDataSource basicDataSource) {
        super(basicDataSource);
        ps = new PasswordAuthentication();
    }

    /**
     * Permite comprobar si las credenciales son correctas para iniciar sesión
     *
     * @param user Nombre de user registrado (Nickname o Email)
     * @param password Contraseña correspondiente del user
     * @return true si las credenciales son correctas
     */
    public boolean login(String user, String password) {
        boolean correcto = verifyLogin(user.toLowerCase(), password, NICKNAME);
        if (!correcto) {
            correcto = verifyLogin(user.toLowerCase(), password, EMAIL);
        }
        return correcto;
    }

    private boolean verifyLogin(String user, String password, String loginType) {
        Connection connection = null;
        try {
            connection = basicDataSource.getConnection();
            ResultSet rs = consulta("LOWER("+loginType + "), contrasenha", "LOWER("+loginType +") = LOWER('" + user + "')", TABLA_USUARIO, connection);
            return verifyPassword(password, rs);
        } catch (SQLException ex) {
            //System.out.println("CL: User. Usuario inexistente por tipo:  "+loginType+"  " + user + "  " + password);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                //System.out.println("Error en el cierre de la conexion  " + e);
            }
        }
        return false;
    }

    private boolean verifyPassword(String password, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.next();
            //System.out.println("User " + rs.getObject(1));
            return ps.authenticate(password.toCharArray(), (String) rs.getObject(2));
        }
        return false;
    }
}

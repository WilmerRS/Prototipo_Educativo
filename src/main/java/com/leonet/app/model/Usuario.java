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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Clase que controla el inicio y registro de los usuarios en la base de datos
 *
 * @author WILMER
 */
public class Usuario extends SentenciasSQL {

    private static final String TABLA_USUARIO = "Usuario";
    private static final String USUARIO_BASICO = "Usuario(nickname, nombre, email, contraseña, fecha_nac, areatrabajo, ocupacion, pais)";
    private static final String USUARIO_COMPLETO = "Usuario(nickname, nombre, email, contraseña, fecha_nac, fecha_reg, nivel, coin, gemas, areatrabajo, ocupacion, pais)";
    private static final String NICKNAME = "nickname";
    private static final String EMAIL = "email";

    private String usuarioModificado = "";
    private String values = "";

    private BasicDataSource basicDataSource = null;
    private final PasswordAuthentication ps;

    public Usuario(BasicDataSource basicDataSource) {
        super();
        this.basicDataSource = basicDataSource;
        ps = new PasswordAuthentication();
    }

    /**
     * Permite comprobar si las credenciales son correctas para iniciar sesión
     *
     * @param usuario Nombre de usuario registrado (Nickname o Email)
     * @param password Contraseña correspondiente del usuario
     * @return true si las credenciales son correctas
     */
    public boolean iniciarSesion(String usuario, String password) {
        boolean correcto = verificarInicio(usuario.toLowerCase(), password, NICKNAME);
        if (!correcto) {
            correcto = verificarInicio(usuario.toLowerCase(), password, EMAIL);
        }
        return correcto;
    }

    private boolean verificarInicio(String usuario, String password, String tipoInicio) {
        Connection conexion = null;
        try {
            conexion = basicDataSource.getConnection();
            ResultSet rs = consulta("LOWER("+tipoInicio + "), contrasenha", "LOWER("+tipoInicio +") = LOWER('" + usuario + "')", TABLA_USUARIO, conexion);
            return verificarPassword(password, rs);
        } catch (SQLException ex) {
            System.out.println("Usuario inexistente por tipo:  "+tipoInicio+"  " + usuario + "  " + password);
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error en el cierre de la conexion  " + e);
            }
        }
        return false;
    }

    private boolean verificarPassword(String password, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.next();
            System.out.println("User " + rs.getObject(1));
            return ps.authenticate(password.toCharArray(), (String) rs.getObject(2));
        }
        return false;
    }
}

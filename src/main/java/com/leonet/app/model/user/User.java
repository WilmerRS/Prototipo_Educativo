/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 * <p>
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

    private static final String TABLA_USUARIO = "userProfile";
    private static final String USUARIO_BASICO = "Usuario(nickname, nombre, email, contraseña, fecha_nac, areatrabajo, ocupacion, pais)";
    private static final String USUARIO_COMPLETO = "Usuario(nickname, nombre, email, contraseña, fecha_nac, fecha_reg, nivel, coin, gemas, areatrabajo, ocupacion, pais)";
    private static final String NICKNAME = "nickname";
    private static final String EMAIL = "email";

    private String usuarioModificado = "";
    private String values = "";

    private final PasswordAuthentication ps;
    private UserRepository userProfile;

    public User(BasicDataSource basicDataSource) {
        super(basicDataSource);
        ps = new PasswordAuthentication();
    }

    /**
     * Permite comprobar si las credenciales son correctas para iniciar sesión
     *
     * @param user     Nombre de user registrado (Nickname o Email)
     * @param password Contraseña correspondiente del user
     * @return true si las credenciales son correctas
     */
    public UserRepository login(String user, String password) {
        userProfile = verifyLogin(user.toLowerCase(), password, NICKNAME);
        if (userProfile == null) {
            userProfile = verifyLogin(user.toLowerCase(), password, EMAIL);
        }
        return userProfile;
    }

    private UserRepository verifyLogin(String user, String password, String loginType) {
        Connection connection = null;
        UserRepository userProfile;
        try {
            connection = basicDataSource.getConnection();
            userProfile = getUserProfile(user);
            ResultSet rs = consulta("LOWER(" + loginType + "), password", "LOWER(" + loginType + ") = LOWER('" + user + "')", TABLA_USUARIO, connection);
            if (verifyPassword(password, rs)) {
                return userProfile;
            }
            return null;
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
        return null;
    }

    public UserRepository getUserProfile() {
        return userProfile;
    }

    public UserRepository getUserProfile(String user) {
        ResultSet rs = null;
        Connection connection = null;
        try {
            connection = basicDataSource.getConnection();
            rs = consulta("*", "LOWER(" + NICKNAME + ") = LOWER('" + user + "')", TABLA_USUARIO, connection);
            UserRepository userProfile = null;
            // System.out.println("getProfile");
            try {
                while (rs.next()) {
                    //System.out.println(rs.getString(2) + " " + rs.getString(3));
                    userProfile = new UserRepository(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getInt(7),
                            rs.getInt(8),
                            rs.getInt(9)
                    );
                }
                return userProfile;
            } catch (SQLException ex) {
                System.out.println("erro 89 USer");
            }
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
        return null;
    }


    public boolean advanceToNextTheme(String nickname) {
        Connection connection = null;
        try {
            connection = basicDataSource.getConnection();
            String updateUserInfo =
                    "update userProfile " +
                            "set level = " +
                            "        (select levelCategory " +
                            "         from theme_category " +
                            "                  join theme t on theme_category.id = t.theme_category " +
                            "                  join UserxTheme UT on t.id = UT.theme " +
                            "                  join userProfile uP on uP.nickname = UT.userProfile " +
                            "         where uP.nickname = lower('" + nickname + "')), " +
                            "    coin = coin +" +
                            "        (select reward_coin " +
                            "         from theme " +
                            "        join UserxTheme U on theme.id = U.theme " +
                            "        join userProfile P on P.nickname = U.userProfile " +
                            "         where P.nickname = lower('" + nickname + "')) " +
                            "where nickname = lower('" + nickname + "');";
            String updateUserxTheme =
                    "update userxtheme ust " +
                    "set theme = " +
                    "        (select id " +
                    "         from theme the " +
                    "                  join userProfile usP on ust.userProfile = usp.nickname " +
                    "         where ust.theme = the.previous_theme " +
                    "           and usP.nickname = lower('" + nickname + "')) " +
                    "where userProfile = lower('" + nickname + "');";
            update(updateUserInfo, connection);
            update(updateUserxTheme, connection);
            return true;
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

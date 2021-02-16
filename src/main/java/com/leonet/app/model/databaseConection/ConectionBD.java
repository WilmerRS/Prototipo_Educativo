/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */

package com.leonet.app.model.databaseConection;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConectionBD {

    private final String PASSWORD = "1110";
    private final String USER = "postgres";
    private final String DRIVER = "org.postgresql.Driver";
    private final String URL = "jdbc:postgresql://localhost:5432/AppEducativa";
    private BasicDataSource basicDataSource;

    public ConectionBD() {
        conectar();
    }

    /**
     * Permite conectar con la BD. Esta conexión solo se debe hacer una vez.
     * Para una conexion secundaria se debe hacer uso del metodo getConection()
     * de BasicDataSource.
     *
     * @return True si la conección es correcta
     */
    public boolean conectar() {
        try {
            basicDataSource = new BasicDataSource();
            basicDataSource.setDriverClassName(DRIVER);
            basicDataSource.setUsername(USER);
            basicDataSource.setPassword(PASSWORD);
            basicDataSource.setUrl(URL);

            //Prueba de la conexion
            basicDataSource.setValidationQuery("select 1");
        } catch (Exception e) {
            System.out.println("Error en la conexion general\n" + e);
            return false;
        }
        return true;
    }

    public boolean desconectar() {
        try {
            basicDataSource.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public BasicDataSource getBasicDataSource() {
        return basicDataSource;
    }

    public void setBasicDataSource(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }
}

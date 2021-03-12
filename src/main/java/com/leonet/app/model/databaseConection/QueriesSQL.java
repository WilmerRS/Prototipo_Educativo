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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Permite un tener métodos rápidos para hacer sentencias SQL No es una clase
 * que deba ser instanciada, aunque lo permite.
 *
 * @author WILMER
 */
public class QueriesSQL {

    protected BasicDataSource basicDataSource = null;
    public QueriesSQL(BasicDataSource basicDataSource){
        this.basicDataSource = basicDataSource;
    }

    /**
     * Permite hacer una sentencia SELECT [columnas] FROM [tablas]
     *
     * @param columnas columna(s) a consultar ["col1, col2, col3"]
     * @param tabla tabla(s) de donde se desea obtener el resultado ["tabla1, tabla2, tabla3"]
     * @param conexion conexion con la base de datos
     * @return ResulSet con el resultado de la consulta
     */
    public ResultSet consulta(String columnas, String tabla, Connection conexion) {
        ResultSet rs = null;
        try {
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery("SELECT " + columnas + " FROM " + tabla);
        } catch (SQLException ex) {
            System.out.println("ERROR AL REALIZAR LA CONSULTA SQL: " + ex);
            System.out.println("--- " + columnas + "  ");
        }
        return rs;
    }

    /**
     * Permite hacer una sentencia SELECT [columnas] FROM [tablas] WHERE [condicion]
     *
     * @param columnas columna(s) a consultar ["col1, col2, col3"]
     * @param condicion condición(es) que debe cumplir el resultado ["col1 = 'registro' AND col2 = 'registro'"]
     * @param tabla tabla(s) de donde se desea obtener el resultado ["tabla1, tabla2, tabla3"]
     * @param conexion conexion con la base de datos
     * @return ResulSet con el resultado de la consulta
     */
    public ResultSet consulta(String columnas, String condicion, String tabla, Connection conexion) {
        ResultSet rs = null;
        try {
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery("SELECT " + columnas + " FROM " + tabla + " WHERE " + condicion);
        } catch (SQLException ex) {
            System.out.println("ERROR AL REALIZAR LA CONSULTA SQL: " + ex);
            System.out.println("--- " + columnas + "  " + condicion);
        }
        return rs;
    }

    /**
     * Permite hacer una sentencia SELECT, UPDATE, DELETE, INSERT
     * ["SELECT colomnas FROM tabla WHERE condicion"]
     * ["UPDATE tabla SET nombre = 'cambio' WHERE condicion"]
     * ["DELETE FROM tabla WHERE condicion"]
     * ["INSERT INTO tabla(colmunas) VALUES (valores)"]
     *
     * @param query consulta o modificacion que se desea hacer en la BD
     * @param conexion conexion con la base de datos
     * @return ResulSet con el resultado de la consulta
     */
    public ResultSet query(String query, Connection conexion) {
        ResultSet rs = null;
        try {
            Statement stmt = conexion.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("ERROR AL REALIZAR LA CONSULTA SQL: " + ex);
            System.out.println("------- " + query);
        }
        return rs;
    }

    public boolean update(String query, Connection conexion) {
        try {
            Statement stmt = conexion.createStatement();
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            System.out.println("ERROR AL REALIZAR LA CONSULTA SQL: " + ex);
            System.out.println("------- " + query);
        }
        return false;
    }

}

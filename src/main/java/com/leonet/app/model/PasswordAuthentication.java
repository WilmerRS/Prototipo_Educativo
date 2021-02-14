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

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * PBKDF2
 * Hash passwords para almacenamiento y pruebe las contraseñas con los tokens de contraseña.
 *
 * Las instancias de esta clase pueden ser utilizadas simultáneamente por multiles threads.
 *
 */
public final class PasswordAuthentication {

    /**
     * Cada token producido por esta clase usa este identificador como prefijo
     */
    public static final String ID = "$31$";

    /**
     * El costo mínimo recomendado, utilizado de forma predeterminada
     */
    public static final int DEFAULT_COST = 16;

    private static final String ALGORITHM = "PBKDF2WithHmacSHA1";

    private static final int SIZE = 128;

    private static final Pattern layout = Pattern.compile("\\$31\\$(\\d\\d?)\\$(.{43})");

    private final SecureRandom random;

    private final int cost;

    /**
     * Crea un administrador de contraseñas con un costo por defecto
     * DEFAULT_COST= 16
     */
    public PasswordAuthentication() {
        this(DEFAULT_COST);
    }

    /**
     * Crea un administrador de contraseñas con un costo específico
     *
     * @param cost el costo computacional exponencial de hash de una
     * contraseña, 0 a 30
     */
    public PasswordAuthentication(int cost) {
        iterations(cost);
        /* Validar costo */
        this.cost = cost;
        this.random = new SecureRandom();
    }

    private static int iterations(int cost) {
        if ((cost < 0) || (cost > 30)) {
            throw new IllegalArgumentException("cost: " + cost);
        }
        return 1 << cost;
    }

    /**
     * Hash de password para almacenar
     *
     * @param password Contraseña a codificar
     * @return un token de autenticación seguro que se almacenará para
     * una autenticación posterior
     */
    public String hash(char[] password) {
        byte[] salt = new byte[SIZE / 8];
        random.nextBytes(salt);
        byte[] dk = pbkdf2(password, salt, 1 << cost);
        byte[] hash = new byte[salt.length + dk.length];
        System.arraycopy(salt, 0, hash, 0, salt.length);
        System.arraycopy(dk, 0, hash, salt.length, dk.length);
        Base64.Encoder enc = Base64.getUrlEncoder().withoutPadding();
        return ID + cost + '$' + enc.encodeToString(hash);
    }

    /**
     * Autentíquese con una contraseña y un token de contraseña almacenado.
     *
     * @param password Contraseña ingresada y a verificar
     * @param token hash guardado de la contraseña (Contraseña real codificada)
     * @return verdadero si la contraseña y el token coinciden
     */
    public boolean authenticate(char[] password, String token) {
        Matcher m = layout.matcher(token);
        if (!m.matches()) {
            throw new IllegalArgumentException("Invalid token format");
        }
        int iterations = iterations(Integer.parseInt(m.group(1)));
        byte[] hash = Base64.getUrlDecoder().decode(m.group(2));
        byte[] salt = Arrays.copyOfRange(hash, 0, SIZE / 8);
        byte[] check = pbkdf2(password, salt, iterations);
        int zero = 0;
        for (int i = 0; i < check.length; ++i) {
            zero |= hash[salt.length + i] ^ check[i];
        }
        return zero == 0;
    }

    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations) {
        KeySpec spec = new PBEKeySpec(password, salt, iterations, SIZE);
        try {
            SecretKeyFactory f = SecretKeyFactory.getInstance(ALGORITHM);
            return f.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException ex) {
            throw new IllegalStateException("Missing algorithm: " + ALGORITHM, ex);
        } catch (InvalidKeySpecException ex) {
            throw new IllegalStateException("Invalid SecretKeyFactory", ex);
        }
    }
}

/**
 * APP EDUCATIVA
 * Prototipo de una aplicacion para la enseñanza de programacion de a jovenes
 * y adultos, de manera didactica y sencilla.
 *
 * WILMER RODRIGUEZ SANCHEZ
 * LUIS ALFREDO ACOSTA
 * 2021
 */
package com.leonet.app.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import static java.awt.Cursor.HAND_CURSOR;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author WILMER
 */
public class Login extends JPanel {

    private JPanel cab;
    private JPanel abajo;

    private JLabel label;
    private JLabel usuario;
    private JLabel pass;
    private JTextField txtUsuario;
    private JPasswordField txtPass;
    private JLabel mensaje;
    private JButton btnRegistar;

    private Font SEGOE_18 = new Font("Segoe UI Semibold", 0, 18);
    private Font SEGOE_15 = new Font("Segoe UI Semibold", 0, 15);

    private JButton btn;

    public Login() {
        crearLogin();
    }

    private void crearLogin() {
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(500, 300));
        this.setLayout(new BorderLayout());

        cab = new JPanel();
        cab.setLayout(new BorderLayout());

        label = new JLabel("Login");
        label.setFont(SEGOE_18);
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        cab.add(label);

        abajo = new JPanel();
        abajo.setLayout(new GridLayout(0, 1, 5, 5));

        usuario = new JLabel(" Usuario");
        usuario.setFont(SEGOE_15);
        usuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        pass = new JLabel(" Contraseña");
        pass.setFont(SEGOE_15);
        pass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        txtUsuario = new JTextField("leonet");
        txtUsuario.setFont(SEGOE_15);
        txtPass = new JPasswordField("leonet");
        txtPass.setFont(SEGOE_15);
        btn = new JButton("Entrar");
        btn.setCursor(new Cursor(HAND_CURSOR));
        btn.setFont(SEGOE_15);

        mensaje = new JLabel("Ingrese credenciales");
        mensaje.setFont(SEGOE_15);

        btnRegistar = new JButton("Registrarse");
        btnRegistar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegistar.setFont(SEGOE_15);
        btnRegistar.setForeground(new Color(50,50,150));
        btnRegistar.setBorder(null);
        btnRegistar.setContentAreaFilled(false);
        btnRegistar.setDefaultCapable(false);
        btnRegistar.setCursor(new Cursor(HAND_CURSOR));
        btnRegistar.setBorder(null);

        abajo.add(usuario);
        abajo.add(txtUsuario);
        abajo.add(pass);
        abajo.add(txtPass);
        abajo.add(btn);
        abajo.add(btnRegistar);
        abajo.add(mensaje);

        this.add(cab, BorderLayout.NORTH);
        this.add(abajo, BorderLayout.CENTER);

        JPanel temp = new JPanel();
        temp.setPreferredSize(new Dimension(90, 50));
        this.add(temp, BorderLayout.WEST);

        temp = new JPanel();
        temp.setPreferredSize(new Dimension(90, 50));
        this.add(temp, BorderLayout.EAST);
    }

    public void isLogin(boolean isLogin) {

        Color VERDE_RESALTADOR = new Color(67, 150, 69);
        mensaje.setFont(SEGOE_18);

        if (isLogin) {
            mensaje.setForeground(VERDE_RESALTADOR);
            mensaje.setText("Inicio exitoso");
        } else {
            mensaje.setForeground(Color.red);
            mensaje.setText("Credenciales incorrectas");
        }
        abajo.updateUI();
    }

    public JLabel getLabel() {
        return label;
    }

    public JLabel getUsuario() {
        return usuario;
    }

    public JLabel getPass() {
        return pass;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public JTextField getTxtPass() {
        return txtPass;
    }

    public JButton getBtn() {
        return btn;
    }
}

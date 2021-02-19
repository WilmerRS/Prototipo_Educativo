package com.leonet.app.view;

import com.leonet.app.view.blog.PnBlog;
import com.leonet.app.view.login.PnLogin;
import com.leonet.app.view.shared.Patron;
import com.leonet.app.view.shared.PnHeader;
import com.leonet.app.view.shared.ScrollPane;

import javax.swing.*;
import java.awt.*;


public class View extends JFrame implements Patron {

    private String title = "App Educativa - Iniciar sesión";

    private JPanel pnBackgroug;
    private ScrollPane spMain;

    private PnHeader pnHeader;
    private PnLogin pnLogin;
    private PnBlog pnBlog;


    /**
     * Inicia la interfaz
     */
    public View() {
        initComponent();
        this.setLocationRelativeTo(null);
    }

    private void initComponent() {
        this.setTitle(title);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon(resUrlBase + "Iconos/logo1.png").getImage());
        this.setPreferredSize(new Dimension((int) (ANCHO * 0.8), (int) (ALTO * 0.8)));
        this.setMinimumSize(new Dimension((int) (ANCHO * 0.5), (int) (ALTO * 0.5)));

        pnBackgroug = new JPanel(new BorderLayout());
        pnBackgroug.setBackground(COLOR_PRINCIPAL);

        addHeaderComponent();
        addCenterTabs();

        // pnBackgroug.add(pnCenterTabs, BorderLayout.CENTER);
        this.add(pnBackgroug);
        pack();
    }

    private void addHeaderComponent() {
        pnHeader = new PnHeader("INICIO");
        pnBackgroug.add(pnHeader, BorderLayout.NORTH);
    }

    private void addCenterTabs() {
        pnLogin = new PnLogin();
        pnBlog = new PnBlog();
        // panel home con su getter
        // panel ayuda con su getter

        spMain = new ScrollPane(pnLogin,
                ScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        pnBackgroug.add(spMain, BorderLayout.CENTER);
    }

    public PnLogin getPnLogin() {
        return pnLogin;
    }

    public PnBlog getPnBlog() {
        return pnBlog;
    }

    public PnHeader getPnHeader() {
        return pnHeader;
    }

    public void updateTab(Component cmpnt){
        spMain.setViewportView(cmpnt);
    }
}

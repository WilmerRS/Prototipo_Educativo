package com.leonet.app.view;

import com.leonet.app.view.blog.PnBlog;
import com.leonet.app.view.help.PnHelp;
import com.leonet.app.view.home.PnLeonetApp;
import com.leonet.app.view.login.PnLogin;
import com.leonet.app.view.shared.Patron;
import com.leonet.app.view.shared.PnHeader;
import com.leonet.app.view.shared.ScrollPane;

import javax.swing.*;
import java.awt.*;


public class View extends JFrame implements Patron {

    private final String title = "LeonetAPP - ";

    private JPanel pnBackgroug;
    private ScrollPane spMain;

    private PnHeader pnHeader;
    private PnLogin pnLogin;
    private PnBlog pnBlog;
    private PnLeonetApp pnLeonetApp;
    private PnHelp pnHelp;


    /**
     * Inicia la interfaz
     */
    public View() {
        initComponent();
        this.setLocationRelativeTo(null);
    }

    private void initComponent() {
        this.setTitle(title + "Iniciar sesión");
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon(resUrlBase + "Iconos/logo1.png").getImage());
        this.setPreferredSize(new Dimension((int) (ANCHO * 0.87), (int) (ALTO * 0.87)));
        this.setMinimumSize(new Dimension((int) (ANCHO * 0.5), (int) (ALTO * 0.5)));

        pnBackgroug = new JPanel(new BorderLayout());
        pnBackgroug.setBackground(COLOR_PRINCIPAL);

        addHeaderComponent();
        addCenterTabs();

        this.add(pnBackgroug);
        pack();
    }

    private void addHeaderComponent() {
        pnHeader = new PnHeader("INICIO");
        pnBackgroug.add(pnHeader, BorderLayout.NORTH);
    }

    private void addCenterTabs() {
        pnLogin = new PnLogin();

        spMain = new ScrollPane(pnLogin,
                ScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        pnBackgroug.add(spMain, BorderLayout.CENTER);
    }

    public PnLogin getPnLogin() {
        return pnLogin;
    }

    public PnLeonetApp getPnLeonetApp() {
        return pnLeonetApp;
    }

    public PnBlog getPnBlog() {
        return pnBlog;
    }

    public PnHeader getPnHeader() {
        return pnHeader;
    }

    public PnHelp getPnHelp() {
        return pnHelp;
    }

    public void updateTab(Component cmpnt, String title) {
        if (cmpnt == null) {
            switch (title) {
                case "Inicio":
                    pnLeonetApp = new PnLeonetApp();
                    spMain.setViewportView(pnLeonetApp);
                    break;
                case "Blog":
                    pnBlog = new PnBlog();
                    spMain.setViewportView(pnBlog);
                    break;
                case "Ayuda":
                    pnHelp = new PnHelp();
                    spMain.setViewportView(pnHelp);
                    break;
                case "Iniciar sesión":
                    pnLogin = new PnLogin();
                    spMain.setViewportView(pnLogin);
                    break;
            }
        }else {
            spMain.setViewportView(cmpnt);
        }
        this.setTitle(this.title + title);
    }

    public void userHasLogged() {
        pnHeader.setLogin(true);
    }

    public void userHasLoggedOut() {
        pnHeader.setLogin(false);
    }

    public boolean isLogin() {
        return pnHeader.isLogin();
    }
}

package com.leonet.app.view;

import com.leonet.app.view.blog.PnBlog;
import com.leonet.app.view.login.PnLogin;
import com.leonet.app.view.shared.Patron;
import com.leonet.app.view.shared.PnHeader;

import javax.swing.*;
import java.awt.*;


public class View extends JFrame implements Patron {

    private String title = "App Educativa - ";

    private JPanel pnBackgroug;
    private JPanel pnCenterTabs;
    private JScrollPane spMain;

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

        pnCenterTabs = new JPanel(new FlowLayout());
        pnCenterTabs.setBackground(COLOR_PRINCIPAL);

        addHeader();
        centerTabs();

        pnBackgroug.add(pnCenterTabs, BorderLayout.CENTER);
        this.add(pnBackgroug);
        pack();
    }

    private void addHeader() {
        pnHeader = new PnHeader("INICIO");
        pnBackgroug.add(pnHeader, BorderLayout.NORTH);
    }

    private void centerTabs() {
        pnLogin = new PnLogin();
        pnBlog = new PnBlog();
        // panel blog
        // panel home

        spMain = new JScrollPane(pnBlog,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        spMain.setBorder(null);
        spMain.setOpaque(false);
        spMain.getViewport().setOpaque(false);
        spMain.setViewportView(pnBlog);

        spMain.getHorizontalScrollBar().setPreferredSize(new Dimension(4, 4));
        spMain.getHorizontalScrollBar().setBorder(null);

        pnCenterTabs.add(spMain);
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

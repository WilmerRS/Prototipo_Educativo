package com.leonet.app.view.shared;

import javax.swing.*;
import java.awt.*;

public class ResultDialog extends JDialog implements Patron {
    private final String title;
    private final String typeModal;
    private JLabel lbTitle;
    private IconMod icon;

    public ResultDialog(java.awt.Frame parent, boolean modal, String title, String typeModal) {
        super(parent, modal);
        this.title = title;
        this.typeModal = typeModal;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.setPreferredSize(new java.awt.Dimension((int) (ANCHO * 0.25), (int) (ANCHO * 0.2)));
        this.setLayout(new java.awt.BorderLayout(5,5));
        this.setBackground(COLOR_PRINCIPAL);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setLayout(new java.awt.BorderLayout());
        this.setResizable(false);
        this.setIconImage(new ImageIcon(resUrlBase + "Iconos/logo1.png").getImage());
        this.setTitle(title);

        JPanel pn = new JPanel(new BorderLayout(MARGEN, MARGEN));
        pn.setOpaque(false);
        UIComponents.marginAll(pn);

        RoundedPanel pnBack = new RoundedPanel(RADIO, COLOR_PRINCIPAL, COLOR_PRINCIPAL);
        pnBack.setLayout(new BorderLayout(MARGEN_2, MARGEN_2));
        
        UIComponents.marginAll(pnBack);

        lbTitle = new JLabel(title);
        lbTitle.setFont(TITLE_FONT);
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setOpaque(false);
        lbTitle.setForeground(COLOR_GRIS_OSCURO);
        icon = new IconMod(typeModal, (int) (ANCHO * 0.17),(int) (ANCHO * 0.16));

        JPanel pnCenter = new JPanel(new BorderLayout(MARGEN, MARGEN));
        pnCenter.setOpaque(false);
        pnCenter.add(lbTitle, BorderLayout.NORTH);
        pnCenter.add(icon, BorderLayout.CENTER);

        pnBack.add(pnCenter);

        pn.add(pnBack);
        this.add(pn);
        pack();
    }
}

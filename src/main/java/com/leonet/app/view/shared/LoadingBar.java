package com.leonet.app.view.shared;

import javax.swing.*;
import java.awt.*;

public class LoadingBar extends JPanel implements Patron {
    private final int RADIUS_BAR_LOADING = (int) (ANCHO * 0.013);
    private final int PROGRESS_PERCENTAGE;

    private Dimension dimension;

    private JLabel lbTitle;
    private JLabel lbPercentage;

    private RoundedPanel rpBackgroundBorder;
    private RoundedPanel rpBackground;
    private RoundedPanel rpBarLoading;
    private RoundedPanel pContainerBar;

    private String title;
    private int pointAdvance;
    private int pointLimit;


    public LoadingBar(Dimension barDimension, String title, int pointAdvance, int pointLimit) {
        this.dimension = barDimension;
        this.title = title;
        if(pointAdvance < pointLimit){
            this.pointAdvance = pointAdvance + 100;
            this.pointLimit = pointLimit;
        }else{
            this.pointAdvance = 0;
            this.pointLimit = 100;
        }
        PROGRESS_PERCENTAGE = (int) (ANCHO * 0.1); // 100%
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout(MARGEN_2 - 2, MARGEN_2 - 2));
        this.setBackground(COLOR_PRINCIPAL);

        lbTitle = new JLabel(title);
        lbTitle.setFont(SUBTITlE3_FONT);
        lbTitle.setForeground(COLOR_GRIS_OSCURO);
        this.add(lbTitle, BorderLayout.NORTH);

        rpBackgroundBorder = new RoundedPanel(RADIUS_BAR_LOADING, COLOR_VERDE_MEDIO, COLOR_VERDE_MEDIO);
        rpBackgroundBorder.setLayout(new BorderLayout(MARGEN_2 - 2, MARGEN_2 - 2));
        UIComponents.marginBottom(rpBackgroundBorder);

        rpBackground = new RoundedPanel(RADIUS_BAR_LOADING, COLOR_GRIS, COLOR_GRIS);
        rpBackground.setLayout(new BorderLayout(MARGEN_2 - 2, MARGEN_2 - 2));
        rpBackground.setPreferredSize(dimension);

        pContainerBar = new RoundedPanel(RADIUS_BAR_LOADING, COLOR_GRIS, COLOR_GRIS);
        pContainerBar.setLayout(new BorderLayout(PROGRESS_PERCENTAGE, 0));

        UIComponents.marginRight(pContainerBar);

        rpBarLoading = new RoundedPanel(RADIUS_BAR_LOADING, COLOR_VERDE, COLOR_VERDE);
        rpBarLoading.setLayout(new BorderLayout(MARGEN_2, MARGEN_2));

        UIComponents.marginAll(rpBarLoading);

        JPanel pnCenterBarLoading = new JPanel(new BorderLayout());
        pnCenterBarLoading.setBackground(COLOR_VERDE);

        RoundedPanel rpBarShine = new RoundedPanel(RADIUS_BAR_LOADING - 8, COLOR_VERDE_CLARO, COLOR_VERDE_CLARO);
        rpBarShine.setPreferredSize(new Dimension(0, (int) (ALTO * 0.00578)));

        pnCenterBarLoading.add(rpBarShine, BorderLayout.NORTH);

        JPanel pnPaddingBar = new JPanel(new BorderLayout());
        pnPaddingBar.setBackground(COLOR_VERDE);
        pnCenterBarLoading.add(pnPaddingBar, BorderLayout.CENTER);

        rpBarLoading.add(pnCenterBarLoading, BorderLayout.CENTER);

        pContainerBar.add(rpBarLoading, BorderLayout.CENTER);

        rpBackground.add(pContainerBar);

        rpBackgroundBorder.add(rpBackground, BorderLayout.CENTER);

        JPanel pnLabelPercentage = new JPanel(new BorderLayout());
        pnLabelPercentage.setBackground(COLOR_PRINCIPAL);
        pnLabelPercentage.setPreferredSize(new Dimension((int) (ANCHO * 0.048), 0));

        lbPercentage = new JLabel();
        lbPercentage.setFont(CONTENT_FONT);
        lbPercentage.setForeground(COLOR_GRIS_OSCURO);
        lbPercentage.setHorizontalAlignment(SwingConstants.RIGHT);
        pnLabelPercentage.add(lbPercentage);

        increasePoints(0);

        this.add(pnLabelPercentage, BorderLayout.EAST);
        this.add(rpBackgroundBorder, BorderLayout.CENTER);
    }

    public boolean increasePercentage(float increasePercentage) {
        if (increasePercentage < 0 || increasePercentage > 100) {
            return false;
        }
        // pointAdvance = (int)(increasePercentage);
        int currentPercentage = (int) (PROGRESS_PERCENTAGE * (increasePercentage / 100));
        if (PROGRESS_PERCENTAGE - currentPercentage < 0) currentPercentage = 0;

        BorderLayout bl = (BorderLayout) pContainerBar.getLayout();
        // System.out.println(currentPercentage);
        bl.setHgap(PROGRESS_PERCENTAGE - currentPercentage);
        pContainerBar.setLayout(bl);
        pContainerBar.repaint();
        // updatePointsLabel();
        return true;
    }

    public boolean increasePoints(int points) {
        if (pointAdvance + points > pointLimit) {
            return false;
        }

        pointAdvance = points;
        boolean done = increasePercentage((pointAdvance * 100) / pointLimit);
        if (!done) {
            return false;
        }
        updatePointsLabel();
        return true;
    }

    public void setPointAdvance(int pointAdvance) {
        this.pointAdvance = pointAdvance;
    }

    public void setPointLimit(int pointLimit) {
        this.pointLimit = pointLimit;
    }

    private void updatePointsLabel() {
        lbPercentage.setText(pointAdvance + "/" + pointLimit + " Pts.");
    }

    public void resetCurrentPercentage() {
        pointAdvance = 0;
    }
}

package com.leonet.app.view.home.problems.listProblem;

import com.leonet.app.model.problems.itemsListProblem.ItemList;
import com.leonet.app.view.shared.Patron;
import com.leonet.app.view.shared.RoundedPanel;
import com.leonet.app.view.shared.UIComponents;
import com.leonet.app.view.shared.TextField;

import javax.swing.*;
import java.awt.*;

public class PnItemList extends JPanel implements Patron {
    private final int correctPosition;
    private int currentPosition;
    private ItemList itemList;

    private RoundedPanel pnBackground;

    private TextField txtItemList;

    private JLabel lbIdItem;
    private JLabel lbTextItem;

    private int widthItem;

    private boolean active = false;

    public volatile int screenY = 0;
    public volatile int myY = 0;
    private JPanel pnIdItem;

    public PnItemList(int currentPosition,int correctPosition, ItemList itemList) {
        this.currentPosition = currentPosition;
        this.correctPosition = correctPosition;
        this.itemList = itemList;
        this.widthItem = UIComponents.getTextWidth(itemList.getTextItem(), CONTENT_FONT);
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setBounds(0, currentPosition * (ITEM_HEIGHT + MARGEN_2), widthItem + 95, ITEM_HEIGHT);
        this.setOpaque(false);

        pnBackground = new RoundedPanel(RADIO_BUTTON, itemList.getBackgroundColor(), itemList.getBackgroundColor());
        pnBackground.setLayout(new BorderLayout(MARGEN_2 - 3, MARGEN_2 - 3));
        UIComponents.marginAll(pnBackground);

        JPanel pnCenterTemp = new JPanel(new BorderLayout(MARGEN_2, MARGEN_2));
        pnCenterTemp.setOpaque(false);
        pnCenterTemp.setBackground(itemList.getBackgroundColor());

        pnIdItem = new JPanel(new BorderLayout(MARGEN + 2, MARGEN + 2));
        pnIdItem.setOpaque(false);
        UIComponents.marginHorizontal(pnIdItem);

        lbIdItem = new JLabel((currentPosition + 1) + ".");
        lbIdItem.setFont(SUBTITlE2_FONT);
        lbIdItem.setForeground(COLOR_PRINCIPAL);

        pnIdItem.add(lbIdItem, BorderLayout.CENTER);

        txtItemList = new TextField(new Dimension(widthItem + 36, ITEM_HEIGHT),
                itemList.getTextItem(), itemList.getBackgroundColor());
        txtItemList.getTxtField().setEditable(false);

        pnCenterTemp.add(pnIdItem, BorderLayout.WEST);
        pnCenterTemp.add(txtItemList, BorderLayout.CENTER);

        pnBackground.add(pnCenterTemp, BorderLayout.CENTER);

        JPanel pnPadding = new JPanel();
        pnPadding.setOpaque(false);

        this.add(pnBackground, BorderLayout.WEST);
        this.add(pnPadding, BorderLayout.CENTER);
    }

    public void updateTextIdItem(int idItem) {
        this.currentPosition = idItem;
        lbIdItem.setText((currentPosition + 1) + ".");
    }

    public int getCorrectPosition() {
        return correctPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getWidthItem() {
        return widthItem;
    }

    public JLabel getLbIdItem() {
        return lbIdItem;
    }

    public int getScreenY() {
        return screenY;
    }

    public int getMyY() {
        return myY;
    }

}

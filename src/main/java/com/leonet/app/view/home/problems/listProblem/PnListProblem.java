package com.leonet.app.view.home.problems.listProblem;

import com.leonet.app.model.problems.itemsListProblem.ItemList;
import com.leonet.app.view.shared.Patron;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PnListProblem extends JPanel implements Patron {
    private ArrayList<ItemList> itemListArray;
    private ArrayList<PnItemList> pnItemListArray;

    private int itemCounts;

    public PnListProblem(ArrayList<ItemList> itemListArray) {
        this.itemListArray = itemListArray;
        this.pnItemListArray = new ArrayList<>();
        this.itemCounts = itemListArray.size();
        initComponents();
    }

    private void initComponents() {
        createPnList();
        this.setPreferredSize(new Dimension(getLongestItem(), (itemCounts * (ITEM_HEIGHT + MARGEN_2))));
        this.setBackground(COLOR_PRINCIPAL);
        this.setLayout(null);
    }

    private void createPnList() {
        for (int i = 0; i < itemListArray.size(); i++) {
            ItemList item = itemListArray.get(i);
            PnItemList pnItemList = new PnItemList(i , itemListArray.get(i).getId(), item);
            pnItemListArray.add(pnItemList);
            this.add(pnItemList);
        }
    }

    public void rearrangePanels(PnItemList item) {
        this.remove(item);
        this.add(item, 0);
    }

    public void updateIdItems() {
        for (PnItemList item : pnItemListArray) {
            item.updateTextIdItem(item.getLocation().y / (ITEM_HEIGHT+MARGEN_2));
        }
    }

    private int getLongestItem() {
        int longestItem = 0;
        for (PnItemList item : pnItemListArray) {
            if (item.getWidthItem() > longestItem) {
                longestItem = item.getWidthItem();
            }
        }
        return longestItem;
    }

    public ArrayList<ItemList> getItemListArray() {
        return itemListArray;
    }

    public int getItemCounts() {
        return itemCounts;
    }

    public ArrayList<PnItemList> getPnItemListArray() {
        return pnItemListArray;
    }
}

package com.leonet.app.model.problems.itemsListProblem;

import com.leonet.app.view.shared.UIComponents;

import java.awt.*;

public class ItemList {
    private int id;
    private String textItem;
    private Color backgroundColor;

    public ItemList(int id, String textItem) {
        this.id = id;
        this.textItem = textItem;
        this.backgroundColor = UIComponents.getRandomColor();
    }

    public int getId() {
        return id;
    }

    public String getTextItem() {
        return textItem;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }
}

package com.leonet.app.view.shared;

import javax.swing.*;
import java.awt.*;

public class ScrollPane extends JScrollPane {

    private final int BAR_WITH = 10;

    public ScrollPane(JComponent component, int vsbPolicy, int hsbPolicy) {
        super(component,vsbPolicy, hsbPolicy);
        this.setViewportView(component);
        initialSetting();
    }

    private void initialSetting(){
        this.setBorder(null);
        this.setOpaque(false);
        this.getViewport().setOpaque(false);

        this.getHorizontalScrollBar().setPreferredSize(new Dimension(BAR_WITH, BAR_WITH));
        this.getHorizontalScrollBar().setBorder(null);

        this.getVerticalScrollBar().setPreferredSize(new Dimension(BAR_WITH, BAR_WITH));
        this.getVerticalScrollBar().setBorder(null);
    }
}

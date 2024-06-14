package com.fje.builder;

import com.fje.factory.*;
import com.fje.factory.outtime.RectangleDefaultFormatterFactory;
import com.fje.factory.outtime.RectanglePokerFormatterFactory;
import com.fje.factory.outtime.TreeDefaultFormatterFactor;
import com.fje.factory.outtime.TreePokerFormatterFactory;

public class FactoryBuilder {
    private String style;
    private String icon;

    public void setStyle(String style) {
        this.style = style;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public IFormatterFactory build() {
        IFormatterFactory formatterFactory = null;
        if(style.equals("rectangle") && icon.equals("default")) {
            formatterFactory = new RectangleDefaultFormatterFactory();
        } else if (style.equals("rectangle") && icon.equals("poker")) {
            formatterFactory = new RectanglePokerFormatterFactory();
        } else if (style.equals("tree") && icon.equals("default")) {
            formatterFactory = new TreeDefaultFormatterFactor();
        }else {
            formatterFactory = new TreePokerFormatterFactory();
        }
        return formatterFactory;
//        Formatter formatter = formatterFactory.createFormatter();
//        formatter.hello();
//        String[] styles = {"rectangle", "tree"};
//        String[] icons = {"default", "poker"};
//
//        for (String style : styles) {
//            for (String icon : icons) {
//
//            }
//        }
    }
}

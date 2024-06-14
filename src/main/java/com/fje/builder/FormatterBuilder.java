package com.fje.builder;

import com.fje.component.Formatter;
import com.fje.component.icon.IIConfigImpl;
import com.fje.component.icon.IIconConfig;
import com.fje.component.style.Style;
import com.fje.factory.*;

public class FormatterBuilder {
    private String style;
    private String icon;

    public void setStyle(String style) {
        this.style = style;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    private Style buildStyle(){
        IStyleFactory factory = null;
        if ("rectangle".equals(style)) {
            factory = new RectangleFactory();
        } else if ("tree".equals(style)) {
            factory = new TreeFactory();
        } else {
            // 默认矩形style
            factory = new RectangleFactory();
        }
        return factory.createStyle();
    }

    private IIconConfig buildIcon(){
        IIconConfig iIconConfig = new IIConfigImpl();
        iIconConfig.setIcon(this.icon);
        return iIconConfig;
    }
    public Formatter build() {
        Style style = buildStyle();
        IIconConfig iIconConfig = this.buildIcon();
        Formatter formatter = new Formatter();
        formatter.setStyle(style);
        formatter.setIcon(iIconConfig);
        return formatter;
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

package com.fje.component;

import com.fje.component.icon.IIconConfig;
import com.fje.component.style.Style;

public class Formatter {
    private Style style;
    private IIconConfig icon;

    public void setStyle(Style style) {
        this.style = style;
    }

    public void setIcon(IIconConfig icon) {
        this.icon = icon;
    }

    public Formatter() {
    }

    public Formatter(Style style, IIconConfig icon) {
        this.style = style;
        this.icon = icon;
    }

    public void format(String json) {
        this.style.format(json, icon);
    }

    @Override
    public String toString() {
        return "Formatter{" +
                "style=" + style +
                ", icon=" + icon +
                '}';
    }
}

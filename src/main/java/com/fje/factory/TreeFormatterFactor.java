package com.fje.factory;

import com.fje.component.Formatter;
import com.fje.component.icon.DefaultIcon;
import com.fje.component.icon.Icon;
import com.fje.component.style.Style;
import com.fje.component.style.TreeStyle;

public class TreeFormatterFactor implements IFormatterFactory{
    public Formatter createFormatter() {
        Style treeStyle = new TreeStyle();
        Icon icon = new DefaultIcon();
        return new Formatter(treeStyle, icon);
    }
}

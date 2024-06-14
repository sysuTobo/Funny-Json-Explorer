package com.fje.factory.outtime;

import com.fje.component.Formatter;
import com.fje.component.icon.DefaultIcon;
import com.fje.component.icon.Icon;
import com.fje.component.style.Style;
import com.fje.component.style.TreeStyle;
import com.fje.factory.IFormatterFactory;

public class TreeDefaultFormatterFactor implements IFormatterFactory {
    public Formatter createFormatter() {
        Style treeStyle = new TreeStyle();
        Icon icon = new DefaultIcon();
        return new Formatter(treeStyle, icon);
    }
}

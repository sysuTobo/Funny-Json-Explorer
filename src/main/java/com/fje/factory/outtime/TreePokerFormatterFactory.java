package com.fje.factory.outtime;

import com.fje.component.Formatter;
import com.fje.component.icon.Icon;
import com.fje.component.icon.PokerIcon;
import com.fje.component.style.Style;
import com.fje.component.style.TreeStyle;
import com.fje.factory.IFormatterFactory;

public class TreePokerFormatterFactory implements IFormatterFactory {
    public Formatter createFormatter() {
        Style treeStyle = new TreeStyle();
        Icon icon = new PokerIcon();
        return new Formatter(treeStyle, icon);
    }
}

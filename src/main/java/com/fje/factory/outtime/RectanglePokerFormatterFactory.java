package com.fje.factory.outtime;

import com.fje.component.Formatter;
import com.fje.component.icon.Icon;
import com.fje.component.icon.PokerIcon;
import com.fje.component.style.RectangleStyle;
import com.fje.component.style.Style;
import com.fje.factory.IFormatterFactory;

public class RectanglePokerFormatterFactory implements IFormatterFactory {

    public Formatter createFormatter() {
        Style rectangleStyle = new RectangleStyle();
        Icon icon = new PokerIcon();
        return new Formatter(rectangleStyle, icon);
    }
}

package com.fje.factory.outtime;

import com.fje.component.Formatter;
import com.fje.component.icon.DefaultIcon;
import com.fje.component.icon.Icon;
import com.fje.component.style.RectangleStyle;
import com.fje.component.style.Style;
import com.fje.factory.IFormatterFactory;

public class RectangleDefaultFormatterFactory implements IFormatterFactory {

    public Formatter createFormatter() {
        Style rectangleStyle = new RectangleStyle();
        Icon defaultIcon = new DefaultIcon();
        return new Formatter(rectangleStyle, defaultIcon);
    }
}

package com.fje.factory;

import com.fje.component.Formatter;
import com.fje.component.icon.DefaultIcon;
import com.fje.component.icon.IIConfigImpl;
import com.fje.component.icon.IIconConfig;
import com.fje.component.icon.Icon;
import com.fje.component.style.RectangleStyle;
import com.fje.component.style.Style;

public class RectangleFormatterFactory implements IFormatterFactory{

    public Formatter createFormatter() {
        return null;
    }

    public Formatter createFormatter(String icon) {
        Formatter formatter = new Formatter();
        formatter.setStyle(new RectangleStyle());
        IIconConfig iconConfig = new IIConfigImpl();
        iconConfig.setIcon(icon);
        formatter.setIcon(iconConfig);
        return  formatter;
    }
}

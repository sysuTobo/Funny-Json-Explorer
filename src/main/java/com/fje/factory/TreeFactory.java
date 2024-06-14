package com.fje.factory;

import com.fje.component.Formatter;
import com.fje.component.style.RectangleStyle;
import com.fje.component.style.Style;
import com.fje.component.style.TreeStyle;

public class TreeFactory implements IStyleFactory {
    public Style createStyle() {
        return new TreeStyle();
    }
}

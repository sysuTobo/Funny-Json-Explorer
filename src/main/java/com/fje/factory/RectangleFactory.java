package com.fje.factory;

import com.fje.component.Formatter;
import com.fje.component.style.RectangleStyle;
import com.fje.component.style.Style;

public class RectangleFactory implements IStyleFactory {


    public Style createStyle() {
        return new RectangleStyle();
    }
}

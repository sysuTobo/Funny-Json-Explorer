package com.fje.component;

import com.fje.component.icon.IIconConfig;
import com.fje.component.icon.Icon;
import com.fje.component.style.Style;
import org.json.JSONObject;

import java.util.Map;

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

    public void format(String json) {
        this.style.format(json, icon);
    }
}

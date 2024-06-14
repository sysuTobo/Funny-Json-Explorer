package com.fje.component.style;

import com.fje.component.icon.IIconConfig;
import org.json.JSONObject;

import java.util.Map;

public abstract class Style{
    public abstract void format(String json, IIconConfig iconConfig);
}

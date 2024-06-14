package com.fje.component.icon;

import com.fje.utils.PropertiesUtil;

import java.util.HashMap;
import java.util.Map;

public class IIConfigImpl implements IIconConfig{

    private static final String POSTFIX = ".properties";

    private Map<String, String> map = new HashMap<String, String>();
    public void setIcon(String iconName) {
        System.out.println(iconName + POSTFIX);
        PropertiesUtil propertiesUtil = new PropertiesUtil(iconName + POSTFIX);
        map.put("node", propertiesUtil.get("node"));
        map.put("leaf", propertiesUtil.get("leaf"));
        System.out.println(map);
    }

    public String getIconNode() {
        return map.get("node");
    }

    public String getIconLeaf() {
        return map.get("leaf");
    }
}

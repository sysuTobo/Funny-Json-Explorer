package com.fje;

import com.fje.builder.FactoryBuilder;
import com.fje.component.Formatter;
import com.fje.factory.*;

import java.util.HashMap;
import java.util.Map;

public class JsonExplorer {

    public static void main(String[] args) {
        FactoryBuilder builder = new FactoryBuilder();
        String style = "";
        String icon = "";
        Map<String, Object> map = new HashMap();
        builder.setStyle(style);
        builder.setIcon(icon);
        IFormatterFactory factory = builder.build();
        Formatter formatter = factory.createFormatter();
        //formatter.draw(map);
    }
}

package com.fje;

import com.alibaba.fastjson.JSONObject;
import com.fje.builder.FormatterBuilder;
import com.fje.component.Formatter;
import com.fje.utils.JsonUtils;
import com.fje.utils.OptionUtils;
import org.apache.commons.cli.*;

import java.util.HashMap;
import java.util.Map;
public class JsonExplorer {

    public static void main(String[] args) {
        CommandLine cmd = OptionUtils.generateCl(args);
        if(cmd == null) {
            System.out.println("请检查输入");
        }
        FormatterBuilder formatterBuilder = new FormatterBuilder();
        formatterBuilder.setStyle(cmd.getOptionValue("style"));
        formatterBuilder.setIcon(cmd.getOptionValue("icon"));
        Formatter formatter = formatterBuilder.build();

        String jsonStr = JsonUtils.fromFile2String(cmd.getOptionValue("file"));
        formatter.format(jsonStr);
    }
}

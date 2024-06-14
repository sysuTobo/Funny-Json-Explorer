package com.fje;

import com.fje.builder.FormatterBuilder;
import com.fje.component.Formatter;
import com.fje.factory.*;

import java.util.HashMap;
import java.util.Map;
public class JsonExplorer {

    public static void main(String[] args) {
        FormatterBuilder formatterBuilder = new FormatterBuilder();
        formatterBuilder.setStyle("rectangle");
        formatterBuilder.setIcon("default");
        Formatter formatter = formatterBuilder.build();

        System.out.println(formatter.toString());
        formatter.format("{\"oranges\":{\"mandarin\":{\"clementine\":{},\"tangerine\":\"cheap & juicy!\"}},\"apples\":{\"gala\":\"gala\"}}");
//        Options options = new Options();
//
//        Option jsonFile = new Option("f", "file", true, "JSON file path");
//        jsonFile.setRequired(true);
//        options.addOption(jsonFile);
//
//        Option styleOption = new Option("s", "style", true, "Display style (tree/rectangle)");
//        styleOption.setRequired(true);
//        options.addOption(styleOption);
//
//        Option iconFamilyOption = new Option("i", "iconFamily", true, "Icon family (poker/love)");
//        iconFamilyOption.setRequired(true);
//        options.addOption(iconFamilyOption);
//
//        CommandLineParser parser = new DefaultParser();
//        HelpFormatter formatter = new HelpFormatter();
//
//        try {
//            CommandLine cmd = parser.parse(options, args);
//
//            String jsonFilePath = cmd.getOptionValue("file");
//            String style = cmd.getOptionValue("style");
//            String iconFamily = cmd.getOptionValue("iconFamily");
//
//            // 读取 JSON 文件内容
//            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
//
//            // 使用建造者模式创建不同样式的 JSONExplorer
//            JSONBuilder builder = new JSONBuilder();
//
//            // 根据参数设置样式工厂
////            if ("tree".equals(style)) {
////                builder.setStyleFactory(new TreeJSONStyleFactory());
////            } else if ("rectangle".equals(style)) {
////                builder.setStyleFactory(new RectangleJSONStyleFactory());
////            } else {
////                throw new IllegalArgumentException("Unsupported style: " + style);
////            }
//            builder.setStyle(style);
//            // 根据参数设置图标族工厂
////            if ("circle".equals(iconFamily)) {
////                builder.setIconFamily(new CircleIconFamily());
////            } else if ("math".equals(iconFamily)) {
////                builder.setIconFamily(new MathIconFamily());
////            } else {
////                throw new IllegalArgumentException("Unsupported icon family: " + iconFamily);
////            }
//            builder.setIcon(iconFamily);
//            JSONDirector director = new JSONDirector(builder);
//            JSONExplorer explorer = director.build();
//            explorer.display(jsonContent);
//
//        } catch (ParseException e) {
//            System.out.println(e.getMessage());
//            formatter.printHelp("fje", options);
//
//            System.exit(1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        FormatterBuilder builder = new FormatterBuilder();
//        String style = "";
//        String icon = "";
//        Map<String, Object> map = new HashMap();
//        builder.setStyle(style);
//        builder.setIcon(icon);
//        IStyleFactory factory = builder.build();
        //Formatter formatter = factory.createFormatter();
        //formatter.draw(map);
    }
}

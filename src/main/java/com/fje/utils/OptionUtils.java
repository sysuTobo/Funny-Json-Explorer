package com.fje.utils;

import org.apache.commons.cli.*;

public class OptionUtils {
    public static CommandLine generateCl(String[] args) {
        // 定义命令行选项
        Options options = new Options();

        Option fileOption = new Option("f", "file", true, "JSON file path");
        fileOption.setRequired(true);
        options.addOption(fileOption);

        Option styleOption = new Option("s", "style", true, "Style (rectangle/tree)");
        styleOption.setRequired(true);
        options.addOption(styleOption);

        Option iconOption = new Option("i", "icon", true, "Icon family (default/poker)");
        iconOption.setRequired(true);
        options.addOption(iconOption);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
            return cmd;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("fje", options);
            return null;
        }
    }
}

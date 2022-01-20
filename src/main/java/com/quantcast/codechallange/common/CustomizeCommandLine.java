package com.quantcast.codechallange.common;

import com.quantcast.codechallange.config.AppConfig;
import org.apache.commons.cli.*;

import java.util.logging.Logger;

public class CustomizeCommandLine {

    private static final Logger log = Logger.getLogger(CustomizeCommandLine.class.getName());

    private String[] args;
    private static final String ARG_ONE = "f";
    private static final String ARG_TWO = "d";


    public CustomizeCommandLine(String[] args) {
        this.args = args;
    }

    public CommandLine getCommandLine() {

        Options options = new Options();

        Option fileOpt = new Option(ARG_ONE, true, AppConfig.getProperty("app.args.one.des"));
        options.addOption(fileOpt);

        Option target = new Option(ARG_TWO, true,AppConfig.getProperty("app.args.two.des"));
        options.addOption(target);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter helper = new HelpFormatter();

        try {
            return parser.parse(options, args);
        } catch (ParseException e) {
            log.info(e.getMessage());
            helper.printHelp("Usage:", options);
            System.exit(0);
        }
        return null;
    }

}

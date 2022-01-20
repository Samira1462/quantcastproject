package com.quantcast.codechallange;


import com.quantcast.codechallange.common.CustomizeCommandLine;
import com.quantcast.codechallange.common.Validation;
import com.quantcast.codechallange.controller.ProcessController;
import com.quantcast.codechallange.model.constant.ArgsEnum;
import org.apache.commons.cli.CommandLine;

import static com.quantcast.codechallange.common.Validation.validateArgs;

public class App  {

    public static void main(String[] args) {
        validateArgs(args);
        CommandLine cmd = new CustomizeCommandLine(args).getCommandLine();
        final String filePath = cmd.getOptionValue(ArgsEnum.F.value);
        final String date = cmd.getOptionValue(ArgsEnum.D.value);
        Validation.validate(filePath, date);
        ProcessController processController = new ProcessController();
        processController.findMostActiveCookie(filePath, date);
    }
}

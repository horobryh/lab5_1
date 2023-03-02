package commands.baseCommands;

import commands.Executable;

import java.util.Scanner;

public class ExitCommand implements Executable {
    @Override
    public void execute(String[] args, Scanner... scanners) {
        System.exit(0);
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getArgs() {
        return "";
    }

    @Override
    public String getDescription() {
        return "завершить программу (без сохранения в файл)";
    }
}

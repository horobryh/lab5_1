package commands.baseCommands;

import commands.CommandManager;
import commands.Executable;

import java.util.Scanner;

public class HelpCommand implements Executable {
    private final CommandManager commandManager;
    @Override
    public void execute(String[] args, Scanner... scanners) {
        for (Executable command: commandManager.getCommands().values()) {
            System.out.println(command.getName() + " " + command.getArgs() + "\t" + command.getDescription());
        }
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getArgs() {
        return "";
    }

    @Override
    public String getDescription() {
        return "Вывести справку по доступным командам";
    }

    public HelpCommand(CommandManager commandManager) {
        this.commandManager = commandManager;
    }
}

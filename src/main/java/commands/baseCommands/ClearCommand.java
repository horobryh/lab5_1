package commands.baseCommands;

import collectionManager.CollectionManager;
import commands.Executable;

import java.util.Scanner;

public class ClearCommand implements Executable {
    private final CollectionManager collectionManager;
    @Override
    public void execute(String[] args, Scanner... scanners) {
        collectionManager.clear();
        System.out.println("Очистка прошла успешно");
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getArgs() {
        return "";
    }

    @Override
    public String getDescription() {
        return "очистить коллекцию";
    }

    public ClearCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
}

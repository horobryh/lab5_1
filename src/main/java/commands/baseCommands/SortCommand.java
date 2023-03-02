package commands.baseCommands;

import collectionManager.CollectionManager;
import commands.Executable;

import java.util.Scanner;

public class SortCommand implements Executable {
    private final CollectionManager collectionManager;

    @Override
    public void execute(String[] args, Scanner... scanners) {
        collectionManager.sortCollection();
        System.out.println(collectionManager.getCollection());
    }

    @Override
    public String getName() {
        return "sort";
    }

    @Override
    public String getArgs() {
        return "";
    }

    @Override
    public String getDescription() {
        return "отсортировать коллекцию в естественном порядке";
    }

    public SortCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
}

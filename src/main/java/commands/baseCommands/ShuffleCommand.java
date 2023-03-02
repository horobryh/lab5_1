package commands.baseCommands;

import collectionManager.CollectionManager;
import commands.Executable;

import java.util.Scanner;

public class ShuffleCommand implements Executable {
    private final CollectionManager collectionManager;
    @Override
    public void execute(String[] args, Scanner... scanners) {
        collectionManager.shuffle();
        System.out.println("Коллекция перемешана.");
    }

    @Override
    public String getName() {
        return "shuffle";
    }

    @Override
    public String getArgs() {
        return "";
    }

    @Override
    public String getDescription() {
        return "перемешать элементы коллекции в случайном порядке";
    }

    public ShuffleCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
}

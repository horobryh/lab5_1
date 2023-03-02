package commands.baseCommands;

import collectionManager.CollectionManager;
import commands.Executable;
import models.Ticket;

import java.util.List;
import java.util.Scanner;

public class PrintUniquePrice implements Executable {
    private final CollectionManager collectionManager;
    @Override
    public void execute(String[] args, Scanner... scanners) {
        List<Integer> prices = collectionManager.getCollection().stream().map(Ticket::getPrice).distinct().sorted().toList();
        System.out.println(prices);
    }

    @Override
    public String getName() {
        return "print_unique_price";
    }

    @Override
    public String getArgs() {
        return "";
    }

    @Override
    public String getDescription() {
        return "вывести уникальные значения поля price всех элементов в коллекции";
    }

    public PrintUniquePrice(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
}

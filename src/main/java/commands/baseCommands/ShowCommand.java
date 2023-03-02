package commands.baseCommands;

import collectionManager.CollectionManager;
import commands.Executable;
import models.Ticket;

import java.util.Collections;
import java.util.Scanner;

public class ShowCommand implements Executable {
    private final CollectionManager collectionManager;
    @Override
    public void execute(String[] args, Scanner... scanner) {
        System.out.println("Элементы коллекции:");
        int i = 1;
        for (Ticket element : collectionManager.getCollection()) {
            System.out.println(i++ + ". " + element.beautifulString());
        }
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getArgs() {
        return "";
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    public ShowCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
}

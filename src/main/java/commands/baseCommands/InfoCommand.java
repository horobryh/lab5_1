package commands.baseCommands;

import collectionManager.CollectionManager;
import commands.Executable;
import models.Ticket;

import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class InfoCommand implements Executable {
    private final CollectionManager collectionManager;
    @Override
    public void execute(String[] args, Scanner... scanners) {
        Vector<Ticket> collectionElements = collectionManager.getCollection();
        Date initializationDate = collectionManager.getInitializationDate();
        System.out.println("Коллекция типа Vector<Ticket>");
        System.out.println("Дата инициализации: " + initializationDate);
        System.out.println("Количество элементов: " + collectionElements.size());
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getArgs() {
        return "";
    }

    @Override
    public String getDescription() {
        return "вывести в стандартный поток вывода информацию о коллекции";
    }

    public InfoCommand (CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
}

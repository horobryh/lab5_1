package commands.baseCommands;

import builders.TicketBuilder;
import collectionManager.CollectionManager;
import commands.Executable;
import models.Ticket;
import models.comparators.TicketIDComparator;
import models.comparators.TicketNameComparator;
import validators.exceptions.EmptyCollectionException;

import java.util.Scanner;

public class AddIfMinCommand implements Executable {
    private final CollectionManager collectionManager;
    @Override
    public void execute(String[] args, Scanner... scanners) {
        Ticket element;
        try {
            element = collectionManager.getMinElement();
        } catch (EmptyCollectionException e) {
            System.out.println(e.getMessage());
            return;
        }

        Ticket newTicket = new TicketBuilder(scanners[0]).buildObject();
        if (new TicketNameComparator().compare(element, newTicket) < 0) {
            collectionManager.add(newTicket);
            System.out.println("Добавление прошло успешно");
        } else {
            System.out.println("Объект больше минимального, не добавлен");
        }
    }

    @Override
    public String getName() {
        return "add_if_min";
    }

    @Override
    public String getArgs() {
        return "{element}";
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }

    public AddIfMinCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
}

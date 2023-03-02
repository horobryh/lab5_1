package commands.baseCommands;

import builders.TicketBuilder;
import collectionManager.CollectionManager;
import commands.Executable;
import models.Ticket;
import validators.exceptions.EmptyCollectionException;
import validators.exceptions.IDNotFoundException;

import java.net.IDN;
import java.util.Scanner;

public class UpdateCommand implements Executable {
    private final CollectionManager collectionManager;
    @Override
    public void execute(String[] args, Scanner... scanners) {
        Integer id;
        try {
            id = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Введенный аргумент не может быть представлен в качестве id");
            return;
        }
        if (!Ticket.checkIDInUsed(id)) {
            System.out.println("Введенный id не существует в элементах коллекции");
            return;
        }
        Ticket elementForUpdating;
        try {
            elementForUpdating = collectionManager.getElementByID(id);
        } catch (IDNotFoundException e) {
            System.out.println("Введенный ID отсутствует в коллекции");
            return;
        } catch (EmptyCollectionException e) {
            System.out.println("В данный момент коллекция пуста");
            return;
        }
        Ticket newElement = new TicketBuilder(scanners[0]).buildObject();
        elementForUpdating.setName(newElement.getName());
        elementForUpdating.setComment(newElement.getComment());
        elementForUpdating.setCoordinates(newElement.getCoordinates());
        elementForUpdating.setDiscount(newElement.getDiscount());
        elementForUpdating.setEvent(newElement.getEvent());
        elementForUpdating.setPrice(newElement.getPrice());
        elementForUpdating.setType(newElement.getType());

        System.out.println("Элемент успешно обновлен");

    }

    @Override
    public String getName() {
        return "update";
    }

    @Override
    public String getArgs() {
        return "id {element}";
    }

    @Override
    public String getDescription() {
        return "обновить значение элемента коллекции, id которого равен заданному";
    }

    public UpdateCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
}

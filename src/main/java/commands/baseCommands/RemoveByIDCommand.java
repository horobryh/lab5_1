package commands.baseCommands;

import collectionManager.CollectionManager;
import commands.Executable;
import models.Ticket;

import java.util.Scanner;

public class RemoveByIDCommand implements Executable {
    private final CollectionManager collectionManager;
    @Override
    public void execute(String[] args, Scanner... scanners) {
        Integer id;
        try {
            id = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Введенный аргумент не является числом");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("В аргументах команды не найден ID");
            return;
        }

        if (Ticket.checkIDInUsed(id)) {
            collectionManager.removeByID(id);
            System.out.println("Удаление прошло успешно");
        } else {
            System.out.println("Данный ID не найден в элементах коллекции");
        }
    }

    @Override
    public String getName() {
        return "remove by id";
    }

    @Override
    public String getArgs() {
        return "id";
    }

    @Override
    public String getDescription() {
        return "Удалить элемент из коллекции по его id";
    }

    public RemoveByIDCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
}

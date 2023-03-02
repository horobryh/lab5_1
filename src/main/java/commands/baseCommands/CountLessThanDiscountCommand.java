package commands.baseCommands;

import collectionManager.CollectionManager;
import commands.Executable;
import models.Ticket;

import java.util.List;
import java.util.Scanner;

public class CountLessThanDiscountCommand implements Executable {
    private final CollectionManager collectionManager;

    @Override
    public void execute(String[] args, Scanner... scanners) {
        List<Long> discounts = collectionManager.getCollection().stream().map(Ticket::getDiscount).toList();
        Long discount;
        try {
            discount = Long.parseLong(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Введенный аргумент не содержит числа");
            return;
        }
        System.out.println(discounts.stream().filter(x -> x < discount).count());
    }

    @Override
    public String getName() {
        return "count_less_than_discount";
    }

    @Override
    public String getArgs() {
        return "discount";
    }

    @Override
    public String getDescription() {
        return " вывести количество элементов, значение поля discount которых меньше заданного";
    }

    public CountLessThanDiscountCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
}

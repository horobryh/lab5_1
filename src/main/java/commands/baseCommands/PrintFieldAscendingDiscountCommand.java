package commands.baseCommands;

import collectionManager.CollectionManager;
import commands.CommandRegister;
import commands.Executable;
import models.Ticket;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PrintFieldAscendingDiscountCommand implements Executable {
    private final CollectionManager collectionManager;
    @Override
    public void execute(String[] args, Scanner... scanners) {
        List<Long> discounts = collectionManager.getCollection().stream().map(Ticket::getDiscount).sorted().toList();
        System.out.println(discounts);
    }

    @Override
    public String getName() {
        return "print_field_ascending_discount";
    }

    @Override
    public String getArgs() {
        return "";
    }

    @Override
    public String getDescription() {
        return "вывести значения поля discount всех элементов в порядке возрастания";
    }

    public PrintFieldAscendingDiscountCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
}

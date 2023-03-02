package commands.baseCommands;

import builders.TicketBuilder;
import collectionManager.CollectionManager;
import commands.Executable;
import scannerManager.ScannerManager;

import java.util.Scanner;

public class AddCommand implements Executable {
    private final CollectionManager collectionManager;


    public AddCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args, Scanner... scanner) {
        this.collectionManager.add(new TicketBuilder(scanner[0]).buildObject());
        System.out.println("Добавление прошло успешно");
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getArgs() {
        return "{element}";
    }

    @Override
    public String getDescription() {
        return "Добавить новый элемент в коллекцию";
    }
}

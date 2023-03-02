import builders.FirstStartingBuilderFromFile;
import collectionManager.CollectionManager;
import commands.CommandManager;
import commands.CommandRegister;
import scannerManager.ScannerManager;
import validators.exceptions.NullException;

import java.io.File;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        FirstStartingBuilderFromFile builder = null;
        String filename = "output.csv";
        try {
            builder = FirstStartingBuilderFromFile.getInstance(args[0]);
            filename = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Имя файла не передано. В дальнейшем возможны проблемы с сохранением данных.");
        }
        File file = new File(filename);

        CollectionManager collectionManager;
        try {
            collectionManager = builder.buildObject();
            System.out.println("Данные из файла успешно загружены.");
        } catch (NullException | NullPointerException e) {
            collectionManager = CollectionManager.getInstance();
        }
        CommandManager commandManager = CommandManager.getInstance();
        CommandRegister commandRegister = CommandRegister.getInstance();

        commandRegister.registerCommands(commandManager, collectionManager, file);

        InputStream inputStream = System.in;

        ScannerManager scannerManager = new ScannerManager(inputStream, commandManager, true);
        scannerManager.startScan();
    }
}
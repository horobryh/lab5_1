package commands.baseCommands;

import collectionManager.CollectionManager;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import commands.Executable;
import models.Ticket;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class SaveCommand implements Executable {
    private final CollectionManager collectionManager;
    private File file;
    @Override
    public void execute(String[] args, Scanner... scanners) {
        try {
            Writer writer = new FileWriter(file);
            StatefulBeanToCsv<Ticket> beanToCsv = new StatefulBeanToCsvBuilder<Ticket>(writer).build();
            beanToCsv.write(collectionManager.getCollection().stream().toList());
            writer.close();
            System.out.println("Сохранение прошло успешно. Путь к файлу: " + file.getAbsolutePath());
        } catch (SecurityException e) {
            System.out.println("Запрещен доступ к файлу");
        } catch (CsvDataTypeMismatchException e) {
            System.out.println("Ошибка несоответствия типа данных. CSV.");
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода.");
        } catch (CsvRequiredFieldEmptyException e) {
            System.out.println("Ошибка записи в формат CSV");
        }

    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getArgs() {
        return "";
    }

    @Override
    public String getDescription() {
        return "сохранить коллекцию в файл";
    }

    public SaveCommand(CollectionManager collectionManager, File file) {
        this.collectionManager = collectionManager;
        this.file = file;
    }
}

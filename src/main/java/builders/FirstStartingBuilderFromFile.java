package builders;

import com.opencsv.bean.CsvToBeanBuilder;
import collectionManager.CollectionManager;
import models.Ticket;
import validators.exceptions.NullException;

import java.io.*;
import java.util.List;

public class FirstStartingBuilderFromFile {
    private final String filename;
    private static FirstStartingBuilderFromFile instance = null;

    public CollectionManager buildObject() throws NullException {
        List<Ticket> beans = null;
        try (InputStream fis = new FileInputStream(filename)) {
            BufferedInputStream bis = new BufferedInputStream(fis);
            Reader rd = new BufferedReader(new InputStreamReader(bis));
            try {
                beans = new CsvToBeanBuilder<Ticket>(rd).withType(Ticket.class).build().parse();
            } catch (Exception e) {
                System.out.println("Произошла ошибка при распаковке файла с коллекцией. Операция отменена.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new CollectionManager(beans);
    }

    private FirstStartingBuilderFromFile(String filename) {
        this.filename = filename;
    }

    public static FirstStartingBuilderFromFile getInstance(String filename) {
        if (instance == null) {
            instance = new FirstStartingBuilderFromFile(filename);
        }
        return instance;
    }
}

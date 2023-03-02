package collectionManager;

import models.Ticket;
import models.comparators.TicketIDComparator;
import validators.exceptions.EmptyCollectionException;
import validators.exceptions.IDNotFoundException;
import validators.exceptions.NullException;

import java.util.*;

public class CollectionManager {
    private Vector<Ticket> collection = new Vector<>();
    private final Date initializationDate;
    private static CollectionManager instance = null;
    private CollectionManager() {
        initializationDate = new Date();
    };
    public static CollectionManager getInstance() {
        if (instance == null) {
            instance = new CollectionManager();
        }
        return instance;
    }

    public void add(Ticket element) {
        collection.add(element);
    }

    public Vector<Ticket> getCollection() {
        return collection;
    }

    public Date getInitializationDate() {
        return initializationDate;
    }

    public void removeByID(Integer id) {
        collection.removeIf(n -> (n.getId() == id));
        Ticket.removeInUsedID(id);
    }

    public void clear() {
        this.collection.clear();
    }

    public void shuffle() {
        Collections.shuffle(collection);
    }

    public Ticket getMinElement() throws EmptyCollectionException{
        if (collection.isEmpty()) {
            throw new EmptyCollectionException("Коллекция пуста, минимальных элементов нет.");
        }
        sortCollection();
        return collection.get(0);
    }

    public void sortCollection() {
        collection.sort(new TicketIDComparator());
    }

    public Ticket getElementByID(Integer id) throws IDNotFoundException, EmptyCollectionException {
        if (!Ticket.checkIDInUsed(id)) {
            throw new IDNotFoundException("ID не найден в коллекции");
        }
        List<Ticket> element = collection.stream().filter(x -> x.getId() == id).toList();
        if (element.isEmpty()) {
            throw new EmptyCollectionException("Коллекция пуста.");
        }
        return element.get(0);
    }

    public CollectionManager(List<Ticket> collection) throws NullException {
        if (collection == null) {
            throw new NullException("Вместо коллекции передан null.");
        }
        this.collection = new Vector<>(collection);
        this.initializationDate = new Date();
    }
}

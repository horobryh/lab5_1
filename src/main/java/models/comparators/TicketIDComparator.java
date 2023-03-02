package models.comparators;

import models.Ticket;

import java.util.Comparator;

public class TicketIDComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}

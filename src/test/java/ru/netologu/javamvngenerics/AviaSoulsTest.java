package ru.netologu.javamvngenerics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void shouldGetPrice() {

        Ticket ticket = new Ticket("MOW", "KUF", 5015, 19, 22);
        int expected = 5015;
        int actual = ticket.getPrice();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldFindAll() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MOW", "KUF", 5015, 19, 22);
        Ticket ticket2 = new Ticket("MOW", "LED", 7185, 19, 20);
        Ticket ticket3 = new Ticket("MOW", "AER", 12785, 7, 11);
        Ticket ticket4 = new Ticket("MOW", "KUF", 6915, 19, 22);
        Ticket ticket5 = new Ticket("MOW", "TAS", 9461, 12, 16);
        Ticket ticket6 = new Ticket("MOW", "KUF", 4115, 19, 22);
        Ticket ticket7 = new Ticket("MOW", "LED", 5485, 19, 22);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7};
        Ticket[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortSomeTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MOW", "KUF", 5015, 19, 22);
        Ticket ticket2 = new Ticket("MOW", "LED", 7185, 19, 20);
        Ticket ticket3 = new Ticket("MOW", "AER", 12785, 7, 11);
        Ticket ticket4 = new Ticket("MOW", "KUF", 6915, 19, 22);
        Ticket ticket5 = new Ticket("MOW", "TAS", 9461, 12, 16);
        Ticket ticket6 = new Ticket("MOW", "KUF", 4115, 19, 22);
        Ticket ticket7 = new Ticket("MOW", "LED", 5485, 19, 22);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket6, ticket1, ticket4};
        Ticket[] actual = manager.search("MOW", "KUF");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MOW", "KUF", 5015, 19, 22);
        Ticket ticket2 = new Ticket("MOW", "LED", 7185, 19, 20);
        Ticket ticket3 = new Ticket("MOW", "AER", 12785, 7, 11);
        Ticket ticket4 = new Ticket("MOW", "KUF", 6915, 19, 22);
        Ticket ticket5 = new Ticket("MOW", "TAS", 9461, 12, 16);
        Ticket ticket6 = new Ticket("MOW", "KUF", 4115, 19, 22);
        Ticket ticket7 = new Ticket("MOW", "LED", 5485, 19, 22);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.search("MOW", "AER");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortZeroTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MOW", "KUF", 5015, 19, 22);
        Ticket ticket2 = new Ticket("MOW", "LED", 7185, 19, 20);
        Ticket ticket3 = new Ticket("MOW", "AER", 12785, 7, 11);
        Ticket ticket4 = new Ticket("MOW", "KUF", 6915, 19, 22);
        Ticket ticket5 = new Ticket("MOW", "TAS", 9461, 12, 16);
        Ticket ticket6 = new Ticket("MOW", "KUF", 4115, 19, 22);
        Ticket ticket7 = new Ticket("MOW", "LED", 5485, 19, 22);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("LED", "KUF");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortSomeTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MOW", "KUF", 5015, 19, 22);
        Ticket ticket2 = new Ticket("MOW", "LED", 7185, 19, 22);
        Ticket ticket3 = new Ticket("MOW", "AER", 12785, 7, 11);
        Ticket ticket4 = new Ticket("MOW", "KUF", 6915, 19, 20);
        Ticket ticket5 = new Ticket("MOW", "TAS", 9461, 12, 16);
        Ticket ticket6 = new Ticket("MOW", "KUF", 4115, 19, 21);
        Ticket ticket7 = new Ticket("MOW", "LED", 5485, 19, 22);
        Ticket ticket8 = new Ticket("MOW", "KUF", 5485, 19, 21);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket6, ticket8, ticket1};
        Ticket[] actual = manager.search("MOW", "KUF", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MOW", "KUF", 5015, 19, 22);
        Ticket ticket2 = new Ticket("MOW", "LED", 7185, 19, 22);
        Ticket ticket3 = new Ticket("MOW", "AER", 12785, 7, 11);
        Ticket ticket4 = new Ticket("MOW", "KUF", 6915, 19, 20);
        Ticket ticket5 = new Ticket("MOW", "TAS", 9461, 12, 16);
        Ticket ticket6 = new Ticket("MOW", "KUF", 4115, 19, 21);
        Ticket ticket7 = new Ticket("MOW", "LED", 5485, 19, 22);
        Ticket ticket8 = new Ticket("MOW", "KUF", 5485, 19, 21);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.search("MOW", "AER", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortZeroTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MOW", "KUF", 5015, 19, 22);
        Ticket ticket2 = new Ticket("MOW", "LED", 7185, 19, 22);
        Ticket ticket3 = new Ticket("MOW", "AER", 12785, 7, 11);
        Ticket ticket4 = new Ticket("MOW", "KUF", 6915, 19, 20);
        Ticket ticket5 = new Ticket("MOW", "TAS", 9461, 12, 16);
        Ticket ticket6 = new Ticket("MOW", "KUF", 4115, 19, 21);
        Ticket ticket7 = new Ticket("MOW", "LED", 5485, 19, 22);
        Ticket ticket8 = new Ticket("MOW", "KUF", 5485, 19, 21);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("AER", "KUF", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}

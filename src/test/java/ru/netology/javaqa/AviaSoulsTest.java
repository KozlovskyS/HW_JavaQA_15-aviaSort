package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class AviaSoulsTest {
    AviaSouls souls = new AviaSouls();
    TicketTimeComparator ticketComparator = new TicketTimeComparator();

    Ticket ticket1 = new Ticket(
            "пункт 1",
            "пункт 2",
            1_000,
            2,
            7
    );
    Ticket ticket2 = new Ticket(
            "пункт 1",
            "пункт 3",
            500,
            2,
            12
    );
    Ticket ticket3 = new Ticket(
            "пункт 2",
            "пункт 3",
            500,
            4,
            23
    );
    Ticket ticket4 = new Ticket(
            "пункт 1",
            "пункт 3",
            2_200,
            3,
            8
    );
    Ticket ticket5 = new Ticket(
            "пункт 1",
            "пункт 3",
            2_000,
            5,
            7
    );

    @Test
    public void testAddTickets() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = souls.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testCompareToMax() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);

        int expected = 1;
        int actual = ticket1.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCompareToMin() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);

        int expected = -1;
        int actual = ticket2.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCompareToIdent() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);

        int expected = 0;
        int actual = ticket2.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearchMultipleItem() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);

        Ticket[] expected = {ticket2, ticket5, ticket4};
        Ticket[] actual = souls.search("пункт 1", "пункт 3");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchOneItem() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);

        Ticket[] expected = {ticket3};
        Ticket[] actual = souls.search("пункт 2", "пункт 3");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNoItem() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = souls.search("пункт 3", "пункт 1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTicketTimeComparatorMin() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);

        int expected = -1;
        int actual = ticketComparator.compare(ticket2, ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTicketTimeComparatorMax() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);

        int expected = 1;
        int actual = ticketComparator.compare(ticket3, ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTicketTimeComparatorIdent() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);

        int expected = 0;
        int actual = ticketComparator.compare(ticket4, ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortByMultipleItem() {
        TicketTimeComparator ticketComparator = new TicketTimeComparator();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);

        Ticket[] expected = {ticket5, ticket4, ticket2};
        Ticket[] actual = souls.searchAndSortBy("пункт 1", "пункт 3", ticketComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortByOneItem() {
        TicketTimeComparator ticketComparator = new TicketTimeComparator();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);

        Ticket[] expected = {ticket3};
        Ticket[] actual = souls.searchAndSortBy("пункт 2", "пункт 3", ticketComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortByNoItem() {
        TicketTimeComparator ticketComparator = new TicketTimeComparator();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = souls.searchAndSortBy("пункт 2", "пункт 1", ticketComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}
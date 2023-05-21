package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();
    Ticket ticket1 = new Ticket("Москва", "Новосибирск", 35_000, 7_00, 13_00);
    Ticket ticket2 = new Ticket("Москва", "Новосибирск", 20_000, 13_00, 17_00);
    Ticket ticket3 = new Ticket("Москва", "Новосибирск", 40_000, 18_00, 22_00);
    Ticket ticket4 = new Ticket("Москва", "Новосибирск", 55_000, 3_00, 8_00);
    Ticket ticket5 = new Ticket("Москва", "Новосибирск", 15_000, 16_00, 21_00);


    @BeforeEach
    public void setup() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
    }

    @Test
    public void testTicketPriceCompareTo() {
        Assertions.assertEquals(1, ticket1.compareTo(ticket2));
        Assertions.assertEquals(1, ticket2.compareTo(ticket5));
        Assertions.assertEquals(-1, ticket3.compareTo(ticket4));
    }

    @Test
    public void testTicketTimeComparator() {
        Ticket[] tickets = aviaSouls.findAll();
        Arrays.sort(tickets, ticketTimeComparator);

        Ticket[] expected = {ticket2, ticket3, ticket4, ticket5, ticket1};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchCompareTo() {
        Ticket[] expected = {ticket5, ticket2, ticket1, ticket3, ticket4};
        Ticket[] actual = aviaSouls.search("Москва", "Новосибирск");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortBy() {
        Ticket[] expected = {ticket2, ticket3, ticket4, ticket5, ticket1};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Новосибирск", ticketTimeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}

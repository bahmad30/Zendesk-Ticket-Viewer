package com.company;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class ViewerTest {
    @Test
    public void getFirstPage() throws InterruptedException, IOException, URISyntaxException {
        Viewer viewer = Viewer.getFirstPage();
        assertEquals(1, viewer.getTickets()[0].getId());
        assertEquals(25, viewer.getTickets()[24].getId());
        assertEquals(1, viewer.getPage());
    }

    @Test
    public void getNextPage() throws InterruptedException, IOException, URISyntaxException {
        Viewer viewer = Viewer.getFirstPage();
        viewer = viewer.getNextPage();
        assertEquals(26, viewer.getTickets()[0].getId());
        assertEquals(50, viewer.getTickets()[24].getId());
        assertEquals(2, viewer.getPage());
    }

    @Test
    public void getPreviousPage() throws InterruptedException, IOException, URISyntaxException {
        Viewer viewer = Viewer.getFirstPage();
        viewer = viewer.getNextPage();
        viewer = viewer.getPreviousPage();
        assertEquals(1, viewer.getTickets()[0].getId());
        assertEquals(25, viewer.getTickets()[24].getId());
        assertEquals(1, viewer.getPage());
    }

    @Test
    public void getSingleTicket() throws InterruptedException, IOException, URISyntaxException {
        Viewer viewer = Viewer.getFirstPage();
        viewer = viewer.getSingleTicket(30);
        assertEquals(1, viewer.getTickets().length);
        assertEquals(30, viewer.getTickets()[0].getId());
    }

    @Test
    public void getNextPageInvalid() throws InterruptedException, IOException, URISyntaxException {
        Viewer viewer = Viewer.getFirstPage();
        viewer = viewer.getNextPage();
        viewer = viewer.getNextPage();
        viewer = viewer.getNextPage();
        viewer = viewer.getNextPage();
        viewer = viewer.getNextPage();
        viewer = viewer.getNextPage();

        assertEquals(5, viewer.getPage());
    }

    @Test
    public void getPreviousPageInvalid() throws InterruptedException, IOException, URISyntaxException {
        Viewer viewer = Viewer.getFirstPage();
        viewer = viewer.getPreviousPage();
        assertEquals(1, viewer.getPage());
    }

    @Test
    public void getSingleTicketInvalid() throws InterruptedException, IOException, URISyntaxException {
        Viewer viewer = Viewer.getFirstPage();
        viewer = viewer.getSingleTicket(500);
        assertEquals(25, viewer.getTickets().length);
    }
}
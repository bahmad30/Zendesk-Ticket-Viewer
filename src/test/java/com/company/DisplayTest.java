package com.company;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class DisplayTest {

    @Test
    public void displayPreview() throws InterruptedException, IOException, URISyntaxException {
        Viewer viewer = Viewer.getFirstPage();
        String actual = viewer.getTickets()[1].displayPreview();
        String expected = "2\t\tvelit eiusmod re...\t\t2021-11-24 00:59";
        assertEquals(actual, expected);
    }

    @Test
    public void displayDetails() throws InterruptedException, IOException, URISyntaxException {
        Viewer viewer = Viewer.getFirstPage();
        String actual = viewer.getTickets()[1].displayDetails();
        String expected = "SUBJECT:      velit eiusmod reprehenderit officia cupidatat\n" +
                "REQUESTER ID: 1902305425404\n" + "ASSIGNEE ID:  1902305425404\n" +
                "CREATED AT:   2021-11-24T00:59:55Z\n\n" +
                "DESCRIPTION:  Aute ex sunt culpa ex ea esse sint cupidatat aliqua ex consequat sit reprehenderit. " +
                "Velit labore proident quis culpa ad duis adipisicing laboris voluptate velit incididunt minim " +
                "consequat nulla. Laboris adipisicing reprehenderit minim tempor officia ullamco occaecat ut laborum.\n\n" +
                "Aliquip velit adipisicing exercitation irure aliqua qui. Commodo eu laborum cillum nostrud eu. " +
                "Mollit duis qui non ea deserunt est est et officia ut excepteur Lorem pariatur deserunt.\n\n" +
                "TAGS: est, incididunt, nisi";
        assertEquals(actual, expected);
    }
}
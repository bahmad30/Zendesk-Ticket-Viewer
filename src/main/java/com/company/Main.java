package com.company;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        Viewer viewer = Viewer.getFirstPage();

        System.out.println(viewer.getTickets()[0].getId());





    }
}

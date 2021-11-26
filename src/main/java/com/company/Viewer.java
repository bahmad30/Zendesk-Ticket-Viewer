package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import javax.swing.text.View;
import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Viewer {

    // url for requesting from Zendesk API
    private static final String API_URL = "https://zcctina.zendesk.com/api/v2/tickets";

    // tickets displayed per page
    private static final int PAGE_SIZE = 25;

    // array of tickets on single page
    private Ticket[] tickets;

    // current page being viewed (one indexed)
    private int page;

    // temporary credentials
    private static final String API_AUTH = "bmahmad2@illinois.edu/token:2UM9VcRwPTeOWPJEgsi6FCi7aMqxVsZbGidE6RUX";

    /**
     * Default constructor.
     */
    public Viewer() {}

    /**
     * Detailed constructor.
     * @param tickets tickets on current page
     * @param page current page number
     */
    public Viewer(Ticket[] tickets, int page) {
        this.tickets = tickets;
        this.page = page;
    }

    /**
     * Requests all tickets for an account.
     * @return Viewer with populated tickets, meta, links, and page fields.
     * @throws URISyntaxException exception
     * @throws IOException exception
     * @throws InterruptedException exception
     */
    public static Viewer getTickets() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        // build request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(API_URL + ".json?page[size]=" + PAGE_SIZE))
                .header("Authorization", "Basic" + API_AUTH)
                .header("Accept", "application/json")
                .GET()
                .build();

        // send request and get response. catch and throw exceptions if needed
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            if (e instanceof IOException) {
                throw new IOException();
            } else {
                throw new InterruptedException();
            }
        }

        // convert json to instance of viewer class
        ObjectMapper mapper = new ObjectMapper();
        Viewer viewer = mapper.readValue(response.body(), Viewer.class);
        viewer.page = 1;

        return viewer;
    }

    public Viewer getNextPage() {
        return new Viewer();
    }

    public Viewer getPreviousPage() {
        return new Viewer();
    }

    public Viewer getSingleTicket(int id) throws IOException {
        return new Viewer();
    }








}

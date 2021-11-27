package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


/**
 * Represents viewer object. Fetches tickets, manages pagination.
 */
public class Viewer {

    // url for requesting from Zendesk API
    private static final String API_URL = "https://zccbilaal.zendesk.com/api/v2/tickets";

    // tickets displayed per page
    private static final int PAGE_SIZE = 25;

    // array of tickets for account
    private Ticket[] tickets;

    // meta for account
    private Meta meta;

    // current page being viewed (one indexed)
    private int page;

    // TEMPORARY credentials
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
    public Viewer(Ticket[] tickets, Meta meta, int page) {
        this.tickets = tickets;
        this.meta = meta;
        this.page = page;
    }

    /**
     * Requests all tickets for an account.
     * @return Viewer for first page with populated fields.
     * @throws URISyntaxException exception
     * @throws IOException exception
     * @throws InterruptedException exception
     */
    public static Viewer getTickets() throws URISyntaxException, IOException, InterruptedException {
        // get first page
        URI uri = new URI(API_URL + ".json?page[size]=" + PAGE_SIZE);
        Viewer viewer = getPageHelper(uri);
        viewer.page = 1;

        return viewer;
    }

    /**
     * Requests next page of tickets.
     * @return Viewer for next page with populated fields. Return current page if next DNE.
     * @throws IOException exception
     * @throws InterruptedException exception
     * @throws URISyntaxException exception
     */
    public Viewer getNextPage() throws IOException, InterruptedException, URISyntaxException {
        // check if no more pages
        if (!this.meta.isHas_more()) return this;

        // get next page
        URI uri = new URI(API_URL + ".json?page[size]=" + PAGE_SIZE + "&page[after]=" + meta.getAfter_cursor());
        Viewer viewer = getPageHelper(uri);
        viewer.page = this.page + 1;

        // check for case where there are no more tickets despite after_cursor being true
        if (viewer.tickets.length != 0) return viewer;

        return this;
    }

    /**
     * Requests previous page of tickets.
     * @return Viewer for previous page with populated fields. Return current page if previous DNE.
     * @throws IOException exception
     * @throws InterruptedException exception
     * @throws URISyntaxException exception
     */
    public Viewer getPreviousPage() throws URISyntaxException, IOException, InterruptedException {
        // check if no previous pages
        if (this.page <= 1) return this;

        // get previous page
        URI uri = new URI(API_URL + ".json?page[size]=" + PAGE_SIZE + "&page[before]=" + meta.getBefore_cursor());
        Viewer viewer = getPageHelper(uri);
        viewer.page = this.page - 1;

        return viewer;
    }

    /**
     * Requests individual ticket.
     * @param id of ticket.
     * @return Viewer containing array with single ticket.
     * @throws IOException if ticket with provided id doesn't exist.
     * @throws URISyntaxException exception
     * @throws InterruptedException exception
     */
    public Viewer getSingleTicket(int id) throws IOException, URISyntaxException, InterruptedException {
        URI uri = new URI(API_URL + "/show_many.json?ids=" + id);
        Viewer viewer = getPageHelper(uri);
        viewer.page = 1;

        // check for non-existent id
        if (viewer.tickets.length != 0) return viewer;

        throw new IOException();
    }

    /**
     * Helper for all get-page methods. Sends requests, handles exceptions if needed.
     * @param uri URI for specific page.
     * @return Viewer with populated fields.
     * @throws IOException exception
     * @throws InterruptedException exception
     */
    private static Viewer getPageHelper(URI uri) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response;

        // build request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Authorization", "Basic" + API_AUTH)
                .header("Accept", "application/json")
                .GET()
                .build();

        // send request and get response. catch and throw exceptions if needed
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            if (e instanceof IOException) {
                throw new IOException();
            } else {
                throw new InterruptedException();
            }
        }

        // convert json to instance of viewer class (tickets, meta, and links auto-populated)
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), Viewer.class);
    }

}

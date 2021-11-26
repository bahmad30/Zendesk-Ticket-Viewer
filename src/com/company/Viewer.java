package com.company;


import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class Viewer {

    // url for requesting from Zendesk API
    private static final String API_URL = "https://zcctina.zendesk.com/api/v2/tickets";

    // tickets displayed per page
    private static final int PAGE_SIZE = 25;

    // array of tickets on single page
    private Ticket[] tickets;

    // current page being viewed (one indexed)
    private int currentPage;

    // total number of tickets
    private int ticketCount;

    private static final String API_AUTH = "bmahmad2@illinois.edu/token:2UM9VcRwPTeOWPJEgsi6FCi7aMqxVsZbGidE6RUX";

    /**
     * Default constructor.
     */
    public Viewer() {}

    /**
     * Detailed constructor.
     * @param tickets tickets on current page
     * @param currentPage current page number
     */
    public Viewer(Ticket[] tickets, int currentPage) {
        this.tickets = tickets;
        this.currentPage = currentPage;
    }

    public Viewer getTickets() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String credentials = "bmahmad2@illinois.edu:Create123";

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






        return new Viewer();
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

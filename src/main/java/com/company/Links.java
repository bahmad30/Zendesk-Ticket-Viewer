package com.company;

/**
 * Represents links for previous and next pages in pagination.
 */
public class Links {

    // links properties
    private String prev;
    private String next;

    /**
     * Default constructor
     */
    public Links() {}

    /**
     * Detailed constructor
     * @param prev link to previous page
     * @param next link to next page
     */
    public Links(String prev, String next) {
        this.prev = prev;
        this.next = next;
    }

    // getters and setters

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}

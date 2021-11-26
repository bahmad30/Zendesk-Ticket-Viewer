package com.company;


/**
 * Represents meta object and maintains data for pagination.
 */
public class Meta {

    // meta properties
    private boolean has_more;
    private String before_cursor;
    private String after_cursor;

    /**
     * Default constructor
     */
    public Meta() {}

    /**
     * Detailed constructor
     * @param has_more more pages available?
     * @param before_cursor before cursor
     * @param after_cursor after cursor
     */
    public Meta(boolean has_more, String before_cursor, String after_cursor) {
        this.has_more = has_more;
        this.before_cursor = before_cursor;
        this.after_cursor = after_cursor;
    }

    // getters and setters

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public String getBefore_cursor() {
        return before_cursor;
    }

    public void setBefore_cursor(String before_cursor) {
        this.before_cursor = before_cursor;
    }

    public String getAfter_cursor() {
        return after_cursor;
    }

    public void setAfter_cursor(String after_cursor) {
        this.after_cursor = after_cursor;
    }
}

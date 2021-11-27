package com.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Represents single ticket object.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {

    // ticket properties
    private int id;
    private long requester_id;
    private long assignee_id;
    private String subject;
    private String description;
    private String[] tags;
    private String created_at;

    /**
     * Default constructor
     */
    public Ticket() {}

    /**
     * Detailed constructor
     * @param id ticket id
     * @param requester_id requester id
     * @param assignee_id assignee id
     * @param subject ticket subject
     * @param description ticket body
     * @param tags array of ticket tags
     * @param created_at when ticket was created
     */
    public Ticket(int id, long requester_id, long assignee_id, String subject,
                  String description, String[] tags, String created_at) {
        this.id = id;
        this.requester_id = requester_id;
        this.assignee_id = assignee_id;
        this.subject = subject;
        this.description = description;
        this.tags = tags;
        this.created_at = created_at;
    }

    /**
     * Displays the preview for a ticket (used when displaying pages)
     * @return formatted string containing id, subject, and creation time
     */
    public String displayPreview() {
        StringBuilder subj = new StringBuilder(this.subject);

        if (subj.length() >= 20) {
            subj = new StringBuilder(subj.substring(0, 16) + "...");
        } else {
            int diff = 20 - subj.length();
            subj.append(" ".repeat(diff));
        }

        String date = this.created_at.substring(0,10) + " " + this.created_at.substring(11,16);

        return this.id + "\t\t" + subj + "\t\t" + date;
    }

    /**
     * Displays details for a ticket (used when displaying single ticket)
     * @return formatted string with all ticket details
     */
    public String displayDetails() {
        StringBuilder res = new StringBuilder();
        res.append("SUBJECT:      ").append(subject).append("\n");
        res.append("REQUESTER ID: ").append(requester_id).append("\n");
        res.append("ASSIGNEE ID:  ").append(assignee_id).append("\n");
        res.append("CREATED AT:   ").append(created_at).append("\n\n");
        res.append("DESCRIPTION:  ").append(description).append("\n\n");
        res.append("TAGS: ");
        for (String tag : tags) {
            res.append(tag).append(", ");
        }
        return res.toString().substring(0, res.length()-2);
    }


    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getRequester_id() {
        return requester_id;
    }

    public void setRequester_id(long requester_id) {
        this.requester_id = requester_id;
    }

    public long getAssignee_id() {
        return assignee_id;
    }

    public void setAssignee_id(long assignee_id) {
        this.assignee_id = assignee_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}


package com.company;

/**
 * Represents a single ticket object.
 */
public class Ticket {

    // ticket properties
    private int id;
    private int requester_id;
    private int assignee_id;
    private String subject;
    private String description;
    private String[] tags;
    private String type;
    private String created_at;
    private String due_at;

    /**
     * Default constructor.
     */
    public Ticket() {}

    /**
     * Detailed constructor.
     * @param id ticket id
     * @param requester_id requester id
     * @param assignee_id assignee id
     * @param subject ticket subject
     * @param description ticket body
     * @param tags array of ticket tags
     * @param type type of ticket (problem, incident, question, task)
     * @param created_at when ticket was created
     * @param due_at when ticket is due (only for task types)
     */
    public Ticket(int id, int requester_id, int assignee_id, String subject, String description,
                  String[] tags, String type, String created_at, String due_at) {
        this.id = id;
        this.requester_id = requester_id;
        this.assignee_id = assignee_id;
        this.subject = subject;
        this.description = description;
        this.tags = tags;
        this.type = type;
        this.created_at = created_at;
        this.due_at = due_at;
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRequester_id() {
        return requester_id;
    }

    public void setRequester_id(int requester_id) {
        this.requester_id = requester_id;
    }

    public int getAssignee_id() {
        return assignee_id;
    }

    public void setAssignee_id(int assignee_id) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDue_at() {
        return due_at;
    }

    public void setDue_at(String due_at) {
        this.due_at = due_at;
    }
}

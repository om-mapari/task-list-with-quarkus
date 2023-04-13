package org.finarkein.resource;


public class Task {
    private boolean completed;
    private String id;
    private String name;

    public Task(boolean completed, String id, String name) {
        this.completed = completed;
        this.id = id;
        this.name = name;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

package main.Objects;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Task {
    private String id;
    private Topic topic;
    private String title;
    private String description;
    private List<String> notes;
    private LocalDate deadline;
    private boolean complete;
    private Priority priority;

    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    public Task(Topic topic, String title, String description, List<String> notes, LocalDate deadline, boolean complete, Priority priority) {
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        this.topic = topic;
        this.title = title;
        this.description = description;
        this.notes = notes;
        this.deadline = deadline;
        this.complete = complete;
        this.priority = priority;

    }

    public String getId() {
        return id;
    }


    public String getTopic() {
        return topic.getTitle();
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", topic=" + topic.getTitle() +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", notes=" + notes +
                ", deadline=" + deadline +
                ", complete=" + complete +
                ", priority=" + priority +
                '}';
    }

    ;


}

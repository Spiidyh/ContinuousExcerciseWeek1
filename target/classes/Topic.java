package main.resources;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Topic {
    private String id;
    private String title;
    private String description;
    private String additionalSource;
    private boolean complete;
    private LocalDate creationDate;
    private LocalDate completionDate;
    private List<Task> taskList;

    public Topic() {
        taskList = new ArrayList<>();
    }
    public Topic(String title, String description, String additionalSource, boolean complete, LocalDate creationDate, LocalDate completionDate) throws ParseException {
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        this.title = title;
        this.description = description;
        this.additionalSource = additionalSource;
        this.complete = complete;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
        taskList = new ArrayList<>();

    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public Topic(String title, String description, String additionalSource, boolean complete) {
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        this.title = title;
        this.description = description;
        this.additionalSource = additionalSource;
        this.complete = complete;
        this.creationDate = LocalDate.now();
        this.completionDate = null;
        taskList = new ArrayList<>();
    }

    public Topic(String title, String description, String additionalSource, boolean complete, LocalDate completionDate) {
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        this.title = title;
        this.description = description;
        this.additionalSource = additionalSource;
        this.complete = complete;
        this.creationDate = LocalDate.now();
        this.completionDate = completionDate;
        taskList = new ArrayList<>();
    }

    public Topic(String id, String title, String description, String additionalSource, boolean complete, LocalDate creationDate, LocalDate completionDate, List<Task> taskList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.additionalSource = additionalSource;
        this.complete = complete;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
        this.taskList = taskList;
    }

    public void addNewTask(Task t) {
        taskList.add(t);
    }
    public void addNewListOfTasks(List<Task> t) {
        taskList.addAll(t);
    }

    public String getId() {
        return id.toString();
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
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

    public String getAdditionalSource() {
        return additionalSource;
    }

    public void setAdditionalSource(String additionalSource) {
        this.additionalSource = additionalSource;
    }

    public boolean isComplete() {
        return complete;
    }


    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return Objects.equals(title, topic.title) &&
                Objects.equals(description, topic.description) &&
                Objects.equals(additionalSource, topic.additionalSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, additionalSource);
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", additionalSource='" + additionalSource + '\'' +
                ", complete=" + complete +
                ", creationDate=" + creationDate +
                ", completionDate=" + completionDate +
                '}';
    }


}

package Classes.Topic;

import java.time.LocalDate;

public class Topic {
    private static int idcounter;
    private final int id = idcounter;
    private String title;
    private String description;
    private String additionalSource;
    private boolean complete;
    private LocalDate creationDate;
    private LocalDate completionDate;

    public Topic(String title, String description, String additionalSource, boolean complete, LocalDate creationDate, LocalDate completionDate) {
        this.idcounter++;
        this.title = title;
        this.description = description;
        this.additionalSource = additionalSource;
        this.complete = complete;
        this.creationDate = creationDate;
        this.completionDate = completionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }


}

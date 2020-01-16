package Classes.Topic;

import java.time.LocalDate;
import java.util.Date;

public class Topic {
    private static int idcounter;
    private final int id = idcounter;
    private String title;
    private String description;
    private String additionalSource;
    private boolean complete;
    private Date creationDate;
    private Date completionDate;


    public Topic(String title, String description, String additionalSource, boolean complete, String creationDate, String completionDate) {
        this.idcounter++;
        this.title = title;
        this.description = description;
        this.additionalSource = additionalSource;
        this.complete = complete;
        String[] creation = creationDate.split("/");
        this.creationDate = new Date(Integer.valueOf(creation[0]), Integer.valueOf(creation[1]), Integer.valueOf(creation[2]));
        if (completionDate != null) {
            String[] completion = completionDate.split("/");
            this.completionDate = new Date(Integer.valueOf(completion[0]), Integer.valueOf(completion[1]), Integer.valueOf(completion[2]));
        } else {
            this.completionDate = null;
        }
    }
    public Topic(String title, String description, String additionalSource, boolean complete)    {
        this.idcounter++;
        this.title = title;
        this.description = description;
        this.additionalSource = additionalSource;
        this.complete = complete;
        this.creationDate = new LocalDate();
        this.completionDate = null;
    }

    public int getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
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


}

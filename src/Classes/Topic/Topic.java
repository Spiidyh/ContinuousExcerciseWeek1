package Classes.Topic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Topic {
    private static int idcounter;
    private final int id = idcounter;
    private String title;
    private final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private String description;
    private String additionalSource;
    private boolean complete;
    private LocalDate creationDate;
    private LocalDate completionDate;


    public Topic(String title, String description, String additionalSource, boolean complete, String creationDate, String completionDate) throws ParseException {
        this.idcounter++;
        this.title = title;
        this.description = description;
        this.additionalSource = additionalSource;
        this.complete = complete;
        this.creationDate = LocalDate.parse(creationDate, df);
        if (completionDate != null) {
            this.completionDate = LocalDate.parse(completionDate, df);
        } else {
            this.completionDate = null;
        }
    }

    public Topic(String title, String description, String additionalSource, boolean complete) {
        this.idcounter++;
        this.title = title;
        this.description = description;
        this.additionalSource = additionalSource;
        this.complete = complete;
        this.creationDate = LocalDate.now();
        this.completionDate = null;
    }

    public Topic(String title, String description, String additionalSource, boolean complete, String completionDate) {
        this.idcounter++;
        this.title = title;
        this.description = description;
        this.additionalSource = additionalSource;
        this.complete = complete;
        this.creationDate = LocalDate.parse(LocalDate.now().toString(), df);
        this.completionDate = LocalDate.parse(completionDate, df);
    }

    public int getId() {
        return id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getCreationDateString() {
        return df.format(creationDate);
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public String getCompletionDateString() {
        return df.format(this.completionDate);
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

    public String getFileWriteString() {
        if (getCompletionDate() == null) {
            return getTitle() + "!/!" + getDescription() + "!/!" + getAdditionalSource() + "!/!" + isComplete() + "!/!" + getCreationDateString() + "!/!" + "01/01/1010" + "!/!";
        }
        return getTitle() + "!/!" + getDescription() + "!/!" + getAdditionalSource() + "!/!" + isComplete() + "!/!" + getCreationDateString() + "!/!" + getCompletionDateString() + "!/!";
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

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


}

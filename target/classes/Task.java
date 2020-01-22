package main.resources;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Task {
    /*
    − id –intTähän talletetaan kyseisen tehtäväntunniste−
    Topic -TopicAihe, johon tehtävä liittyy−
    title –StringAiheen otsikko−
    description –StringAiheen kuvaus−
    notes –ArrayList<String>Muistiinpanoja liittyen tehtävään−
     deadline –LocalDateMilloin tulisi olla valmis−
     priority –enumKuinka kiireinen kyseinen tehtävä on−
     complete –boolOnko tehtävä valmis
     */
    private String id;
    private Topic topic;
    private String title;
    private String description;
    private List<String> notes;
    private LocalDate deadline;
    private boolean complete;
    private Priority priority = Priority.LOW;

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


    public Topic getTopic() {
        return topic;
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



    ;


}

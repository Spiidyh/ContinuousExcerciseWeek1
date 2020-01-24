package main.UI;

import main.FileReadWrite.FileWrite;
import main.FileReadWrite.FileRead;
import main.Objects.Task;
import main.Objects.Topic;
import main.TopicRepo.TopicRepo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {
    private Scanner reader;
    private TopicRepo repo;
    private FileRead fr;
    private FileWrite fw;

    public UI(Scanner reader) {
        this.reader = reader;
        this.repo = new TopicRepo();
        this.fr = new FileRead();
        this.fw = new FileWrite();
    }

    public void launchTextUI() throws IOException {
        System.out.println("Week 1 Excercise");

        repo.addTopicList(fr.readJSONFile());

        while (true) {
            System.out.println("COMMANDS\n" +
                    "1 Add topic\n" +
                    "2 Print all topics\n" +
                    "3 Modify topic\n" +
                    "4 Print specific topic\n" +
                    "5 Delete topic\n" +
                    "6 Add a new task to topic \n" +
                    "Input command: \n");
            System.out.print(">");
            String command = reader.nextLine();
            switch (command) {
                case "1":
                    addTopic();
                    break;
                case "2":
                    printAllTopics();
                    break;
                case "3":
                    modifyTopic();
                    break;
                case "4":
                    printSpecificTopic();
                    break;
                case "5":
                    deleteSpecificTopic();
                    break;
                case "6":
                    addTaskToTopic();
                    break;
                default: break;


            }
        }
    }


    private void addTopic() throws IOException {
        System.out.println("Enter topic name: ");
        System.out.print(">");
        String name = reader.nextLine();
        System.out.println("Enter description: ");
        System.out.print(">");
        String descr = reader.nextLine();
        System.out.println("Enter additional sources: ");
        System.out.print(">");
        String addsource = reader.nextLine();
        System.out.println("Is the topic completed? y/n");
        System.out.print(">");
        String yesno = reader.nextLine();
        Boolean comp;
        if (yesno.equalsIgnoreCase("y") || yesno.equalsIgnoreCase("yes")) {
            comp = true;
        } else {
            comp = false;
        }
        Topic t = new Topic(name, descr, addsource, comp);
        repo.addTopic(t);
        fw.writeJSONFileUpdateFile(repo);

    }

    private void printAllTopics() {
        repo.printTopics();
    }

    private void getSpecificTopic() {
        for (int i = 0; i < repo.getList().size(); i++) {
            System.out.println("Topic number '" + (i + 1) + "', Title: " + repo.getList().get(i).getTitle());
        }
    }

    private void modifyTopic() throws IOException {
        System.out.println("Which topic do you want modify");
        getSpecificTopic();
        System.out.print(">");
        int input = Integer.parseInt(reader.nextLine()) - 1;
        Topic t = repo.getList().get(input);
        System.out.println("Which property do you want to modify?\n" +
                "1 Title\n" +
                "2 Description\n" +
                "3 Additional sources\n" +
                "4 Is the topic completed\n" +
                "5 Creation Date\n" +
                "6 Completion Date"
        );
        System.out.print(">");
        String input2 = reader.nextLine();
        switch (input2) {
            case "1":
                System.out.println("Enter new title");
                System.out.print(">");
                String title = reader.nextLine();
                repo.getList().get(input).setTitle(title);
                System.out.println("Title has been modified");
                System.out.print(">");
                fw.writeJSONFileUpdateFile(repo);
                break;
            case "2":
                System.out.println("Enter new description");
                System.out.print(">");
                String description = reader.nextLine();
                repo.getList().get(input).setDescription(description);
                System.out.println("Description has been modified");
                System.out.print(">");
                fw.writeJSONFileUpdateFile(repo);
                break;
            case "3":
                System.out.println("Enter new additional sources");
                System.out.print(">");
                String addsource = reader.nextLine();
                repo.getList().get(input).setAdditionalSource(addsource);
                System.out.println("Additional sources has been modified");
                System.out.print(">");
                fw.writeJSONFileUpdateFile(repo);
                break;
            case "4":
                System.out.println("Is the topic complete? y/n");
                System.out.print(">");
                String yesno = reader.nextLine();
                boolean comp;
                if (yesno.equalsIgnoreCase("y") || yesno.equalsIgnoreCase("yes")) {
                    comp = true;
                } else {
                    comp = false;
                }
                repo.getList().get(input).setComplete(comp);
                System.out.println("Topic completion has been modified");
                fw.writeJSONFileUpdateFile(repo);
                break;
            case "5":
                System.out.println("Enter new creation date in the form (01/01/0101) or (01.01.0101)");
                System.out.print(">");
                String creationdate = reader.nextLine();
                String[] split = creationdate.split("\\.|\\/");
                repo.getList().get(input).setCreationDate(LocalDate.of(Integer.parseInt(split[2]), Integer.parseInt(split[1]), Integer.parseInt(split[0])));
                System.out.println("Creation date has been modified");
                fw.writeJSONFileUpdateFile(repo);
                break;
            case "6":
                System.out.println("Enter new completion date in the form (01/01/0101) or (01.01.0101)");
                System.out.print(">");
                String completiondate = reader.nextLine();
                String[] splitc = completiondate.split("\\.|\\/");
                repo.getList().get(input).setCreationDate(LocalDate.of(Integer.parseInt(splitc[2]), Integer.parseInt(splitc[1]), Integer.parseInt(splitc[0])));
                System.out.println("Completion date has been modified");
                fw.writeJSONFileUpdateFile(repo);
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    private void printSpecificTopic() {
        System.out.println("Which topic do you want print?");
        System.out.print(">");
        getSpecificTopic();
        int input = Integer.parseInt(reader.nextLine()) - 1;
        System.out.println(repo.getList().get(input).toString());
    }

    private void deleteSpecificTopic() throws IOException {
        System.out.println("Which topic do you want to delete?");
        System.out.print(">");
        getSpecificTopic();
        int input = Integer.parseInt(reader.nextLine()) - 1;
        String topicname = repo.getList().get(input).getTitle();
        repo.removeTopic(input);
        System.out.println(topicname + " has been deleted");
        fw.writeJSONFileUpdateFile(repo);

    }

    private void addTaskToTopic() throws IOException {
        System.out.println("To which topic do you want to add a task?");
        getSpecificTopic();
        System.out.print(">");
        int input = Integer.parseInt(reader.nextLine()) - 1;
        System.out.println("INFORMATION FOR TASK");
        System.out.println("Enter task title");
        System.out.print(">");
        String title = reader.nextLine();
        System.out.println("Enter task description");
        System.out.print(">");
        String description = reader.nextLine();
        List<String> notes = new ArrayList<>();
        while(true) {
            System.out.println("Add a new note to the list of notes (type 'end' to stop adding)");
            System.out.print(">");
            String note = reader.nextLine();
            if(note.equalsIgnoreCase("end")) {
                break;
            }
            else {
                notes.add(note);
            }
        }
        System.out.println("Enter deadline date in the form (01/01/0101) or (01.01.0101)");
        System.out.print(">");
        String deadlinedatestring = reader.nextLine();
        String[] split = deadlinedatestring.split("\\.|\\/");
        LocalDate deadline = LocalDate.of(Integer.parseInt(split[2]), Integer.parseInt(split[1]), Integer.parseInt(split[0]));
        System.out.println("Is the task completed? y/n");
        System.out.print(">");
        String yesno = reader.nextLine();
        Boolean comp;
        if (yesno.equalsIgnoreCase("y") || yesno.equalsIgnoreCase("yes")) {
            comp = true;
        } else {
            comp = false;
        }
        System.out.println("What is the tasks priority level? (LOW, MEDIUM, HIGH)");
        System.out.print(">");
        Task.Priority prio = Task.Priority.LOW;
        String prioinput = reader.nextLine();
        if(prioinput.equalsIgnoreCase("medium")) {
            prio = Task.Priority.MEDIUM;
        }
        if(prioinput.equalsIgnoreCase("high")) {
            prio = Task.Priority.HIGH;
        }

        Task t = new Task(repo.getList().get(input), title, description, notes, deadline, comp, prio);
        repo.addTaskToTopic(t, input);
        fw.writeJSONFileUpdateFile(repo);



    }

}





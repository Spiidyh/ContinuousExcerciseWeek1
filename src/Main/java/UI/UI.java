package UI;

import Classes.FileReadWrite.FileRead;
import Classes.FileReadWrite.FileWrite;
import Classes.Topic.Topic;
import Classes.TopicRepo.TopicRepo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class UI {
    private Scanner reader;
    private TopicRepo repo;

    public UI(Scanner reader) {
        this.reader = reader;
        this.repo = new TopicRepo();
    }

    public void launchTextUI() throws IOException {
        System.out.println("Week 1 Excercise");
        FileRead fr = new FileRead();
        FileWrite fw = new FileWrite();
        repo.addTopicList(fr.readJSONFile());

        while(true) {
            System.out.println("COMMANDS");
            System.out.println("1 ADD TOPIC");
            System.out.println("2 PRINT ALL TOPICS");
            System.out.println("Input command: ");
            System.out.print(">");
            String command = reader.nextLine();
            switch (command) {
                case "1":
                    System.out.println("Enter topic name: ");
                    System.out.print(">");
                    String name = reader.nextLine();
                    System.out.println("Enter description: ");
                    System.out.print(">");
                    String descr = reader.nextLine();
                    System.out.println("Enter additional sources: ");
                    String addsource = reader.nextLine();
                    System.out.println("Is the topic completed? y/n");
                    String yesno = reader.nextLine();
                    Boolean comp;
                    if(yesno.equalsIgnoreCase("y") || yesno.equalsIgnoreCase("yes"))) {
                        comp = true;
                    }
                    else {
                        comp = false;
                    }
                    Topic t = new Topic(name, descr, addsource, comp);
                    fw.writeJSONFileTopic(t);
                    repo.addTopic(t);
                    break,
                case "2":
                    System.out.println("TOPICS");
                    repo.printTopics();
                    break;

    }
}





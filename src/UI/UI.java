package UI;

import Classes.Topic.Topic;
import Classes.TopicRepo.TopicRepo;

import java.time.LocalDate;
import java.util.Scanner;

public class UI {
    private Scanner reader;
    private TopicRepo repo;

    public UI(Scanner reader) {
        this.reader = reader;
        this.repo = new TopicRepo();
    }

    public void launchTextUI() {
        System.out.println("Week 1 Excercise");
        this.repo.openFile();
        this.repo.addTopic(this.repo.getTopicById(0));

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
                    if(yesno.equalsIgnoreCase("y")) {
                        comp = true;
                    }
                    else {
                        comp = false;
                    }
                    repo.addTopic(new Topic(name, descr, addsource, comp));
                case "2":
                    System.out.println("TOPICS");
                    repo.printTopics();

            }
        }

    }
}

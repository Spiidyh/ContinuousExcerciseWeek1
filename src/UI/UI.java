package UI;

import Classes.Topic.Topic;
import Classes.TopicRepo.TopicRepo;

import java.util.Scanner;

public class UI {
    private Scanner reader;
    private TopicRepo repo;

    public UI(Scanner reader) {
        this.reader = reader;
        this.repo = new TopicRepo();
    }

    public launchTextUI() {
        System.out.println("Week 1 Excercise");
        while(true) {
            System.out.println("COMMANDS");
            System.out.println("1 ADD TOPIC");
            System.out.println("2 PRINT ALL TOPICS");
            System.out.println("Input command: ");
            System.out.print(">");
            String command = reader.nextLine();
            switch (command) {
                case "1":
                    System.out.println("Enter topic name");
                    String name = reader.nextLine();
                    this.repo.addTopic(new Topic(name));

            }
        }
    }
}

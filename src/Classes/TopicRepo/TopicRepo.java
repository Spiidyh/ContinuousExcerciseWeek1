package Classes.TopicRepo;

import Classes.Topic.Topic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class TopicRepo {
    private List<Topic> repo;

    public TopicRepo() {
        this.repo = new ArrayList<>();

    }

    public void openFile() {
        try (FileReader fr = new FileReader("./data/topics.txt"); BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] nTopicSplit = line.split("!/!");
                repo.add(new Topic(nTopicSplit[0], nTopicSplit[1], nTopicSplit[2], Boolean.parseBoolean(nTopicSplit[3]), nTopicSplit[4], nTopicSplit[5]));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addTopicToFile(Topic t) {
        try {
            FileWriter fr = new FileWriter("./data/topics.txt", true);
            PrintWriter pw = new PrintWriter(fr);
            pw.println(t.getFileWriteString());
            pw.println();
            fr.close();
            pw.close();
        } catch (Exception e) {
            System.err.println("Write error: " + e.getMessage());
        }
    }

    public void printTopics() {
        for (Topic t : this.repo) {
            System.out.println(t.getTitle());
        }
    }

    public void addTopic(Topic topic) {
        this.repo.add(topic);
        addTopicToFile(topic);

    }


    public Topic getTopicById(int i) {
       return this.repo.get(i);
    }
}

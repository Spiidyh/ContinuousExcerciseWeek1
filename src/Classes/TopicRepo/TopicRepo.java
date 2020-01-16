package Classes.TopicRepo;

import Classes.Topic.Topic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class TopicRepo {
    private List<Topic> repo;

    public TopicRepo() {
    this.repo = new ArrayList<>();

    }
    public void openFile() {
        try(FileReader fr = new FileReader("./data/topics.txt"); BufferedReader br = new BufferedReader(fr)) {
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = br.readLine() != null) {
            String[] nTopicSplit = br.readLine().split(":");
            for(String part : nTopicSplit) {
                repo.add(new Topic(part[0], part[1], part[2], part[3], part[4], part[5]));
            }
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void addTopic(Topic topic) {


        }


}

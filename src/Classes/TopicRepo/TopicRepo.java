package Classes.TopicRepo;

import Classes.Topic.Topic;
import java.util.ArrayList;
import java.util.List;


public class TopicRepo {
    private List<Topic> repo;

    public TopicRepo() {
        this.repo = new ArrayList<>();

    }
    public void printTopics() {
        for (Topic t : this.repo) {
            System.out.println(t.getTitle());
        }
    }

    public void addTopic(Topic topic) {
        this.repo.add(topic);

    }
    public void addTopicList(List<Topic> l) {
        this.repo.addAll(l);
    }


    public Topic getTopicById(String id) {
       for(Topic t : this.repo) {
           if(t.getId().equals(id)) {
               return t;
           }
       }
       return null;
    }
}

package main.FileReadWrite;

import com.fasterxml.jackson.databind.DeserializationFeature;
import main.TopicRepo.TopicRepo;
import main.resources.Task;
import main.resources.Topic;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileWrite {


    public void writeJSONFileTopic(Topic t) throws IOException {
        //     Topic t = new Topic("Java collections", "Information about classes, collections arraylists etc.", "No additional sources", false);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        List<Topic> tlist = mapper.readValue(new File("JSONObjects/topiclist.json"), new TypeReference<List<Topic>>() {
        });
        tlist.add(t);
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("JSONObjects/topiclist.json"), tlist);
    }

    public void writeJSONFileUpdateFile() throws IOException {
        //     Topic t = new Topic("Java collections", "Information about classes, collections arraylists etc.", "No additional sources", false);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        List<Topic> tlist = mapper.readValue(new File("JSONObjects/topiclist.json"), new TypeReference<List<Topic>>() {
        });
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("JSONObjects/topiclist.json"), tlist);

    }

    public void writeJSONFileUpdateFileWithNewTask(Task t, int topicid) throws IOException {
        //     Topic t = new Topic("Java collections", "Information about classes, collections arraylists etc.", "No additional sources", false);
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
          List<Topic> tlist = mapper.readValue(new File("JSONObjects/topiclist.json"), new TypeReference<List<Topic>>() {
          });
          tlist.get(topicid).addNewTask(t);
          mapper.writerWithDefaultPrettyPrinter().writeValue(new File("JSONObjects/topiclist.json"), tlist);

    }
}

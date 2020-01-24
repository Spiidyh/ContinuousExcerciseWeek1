package main.FileReadWrite;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.google.gson.Gson;
import main.Objects.Topic;
import main.TopicRepo.TopicRepo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileWrite {


    public void writeJSONFileUpdateFile(TopicRepo repo) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        List<Topic> tlist = repo.getList();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("JSONObjects/topiclist.json"), tlist);


    }
}

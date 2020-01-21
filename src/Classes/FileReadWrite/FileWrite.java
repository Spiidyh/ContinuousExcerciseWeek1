package Classes.FileReadWrite;
import Classes.Topic.Topic;
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
        List<Topic> tlist = mapper.readValue(new File("data/topictest.json"), new TypeReference<List<Topic>>(){});
        tlist.add(t);
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("data/topictest.json"), tlist);
    }

}

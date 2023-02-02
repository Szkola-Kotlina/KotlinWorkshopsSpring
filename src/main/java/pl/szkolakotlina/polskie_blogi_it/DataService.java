package pl.szkolakotlina.polskie_blogi_it;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class DataService {
  @Value("classpath:data.json")
  Resource resourceFile;

  public JsonNode readResourceData() {
    JsonNode json;
    try {
      json = new ObjectMapper().readTree(resourceFile.getFile());
    } catch (IOException e) {
      json = TextNode.valueOf("");
    }
    return json;
  }
}

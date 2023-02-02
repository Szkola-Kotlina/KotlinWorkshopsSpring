package pl.szkolakotlina.polskie_blogi_it;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogsController {

  private final DataService service;

  public BlogsController(DataService service) {
    this.service = service;
  }

  @GetMapping("/all")
  public JsonNode getAll() {
    return service.readResourceData();
  }
}

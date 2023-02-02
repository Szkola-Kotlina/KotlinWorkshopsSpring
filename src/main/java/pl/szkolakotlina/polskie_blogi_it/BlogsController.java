package pl.szkolakotlina.polskie_blogi_it;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogsController {

  private final DataServiceKotlin service;

  public BlogsController(DataServiceKotlin service) {
    this.service = service;
  }

  @GetMapping("/blogs")
  public List<BlogEntry> getBlogs(){
    return service.getBlogs();
  }

  @GetMapping("/podcasts")
  public List<BlogEntry> getPodcasts(){
    return service.getPodcasts();
  }

  @GetMapping("/newsletters")
  public List<BlogEntry> getNewsletters(){
    return service.getNewsletters();
  }

  @GetMapping("/all")
  public List<BlogEntry> getAll(){
    return service.getAll();
  }
}

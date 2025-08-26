package pl.coderslab.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PublisherController {
    private final PublisherDao publisherDao;

    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping("/publisher/add")
    @ResponseBody
    public String addPublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("wydawnictwo");
        publisherDao.save(publisher);
        return "ID dodanego publishera to: " +publisher.getId();

    }

    @RequestMapping("/publisher/get/{id}")
    @ResponseBody
    public String getPublisher(@PathVariable Long id){
        Publisher publisher = publisherDao.getById(id);
        return publisher.toString();
    }

    @RequestMapping("/publisher/update/{id}/{title}")
    @ResponseBody
    public String updatePublisher(@PathVariable Long id, @PathVariable String title){
        Publisher publisher = publisherDao.getById(id);
        publisher.setName(title);
        publisherDao.update(publisher);
        return publisher.toString();
    }

    @RequestMapping("/publisher/delete/{id}")
    @ResponseBody
    public String deletePublisher(@PathVariable Long id){
        Publisher publisher = publisherDao.getById(id);
        publisherDao.delete(publisher);
        return "deleted";
    }
    @RequestMapping("/publisher/all")
    @ResponseBody
    public List<Publisher> getAll() {
        return publisherDao.findAll();
    }


}

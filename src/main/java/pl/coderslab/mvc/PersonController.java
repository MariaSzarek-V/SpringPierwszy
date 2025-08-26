package pl.coderslab.mvc;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.wstep.zadanie05.PersonService;

@Controller
public class PersonController {
    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;

    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }


    @RequestMapping("/person/add")
    @ResponseBody
    public String addPerson() {
        Person person = new Person();
        person.setLogin("moj_login");
        person.setPassword("moj_password");
        person.setEmail("moj_email");

        PersonDetails personDetails = new PersonDetails();
        personDetails.setFirstName("moj_firstname");
        personDetails.setLastName("moj_lastname");
        personDetails.setCity("moj_city");
        personDetails.setStreet("moj_street");
        personDetails.setStreetNumber(123);

        personDetailsDao.save(personDetails);
        person.setPersonDetails(personDetails);

        personDao.save(person);

        return "Id dodanego persona: " + person.getId();
    }

}

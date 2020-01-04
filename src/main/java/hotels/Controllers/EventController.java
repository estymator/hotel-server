package hotels.Controllers;

import hotels.Repositories.PersonelWydarzeniePokojRepository;
import hotels.Repositories.WydarzenieRepository;
import hotels.models.PersonelWydarzeniePokoj;
import hotels.models.Wydarzenie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class EventController {

    @Autowired
    WydarzenieRepository wydarzenieRepository;

    @Autowired
    PersonelWydarzeniePokojRepository personelWydarzeniePokojRepository;

    @GetMapping(path = "/event/all")
    public @ResponseBody Iterable<Wydarzenie> getAllEvents()
    {
        System.out.println("wszystkie wydarzenia");
        return wydarzenieRepository.findAll();
    }

    @PostMapping(path = "event/add")
    public @ResponseBody Wydarzenie addEvent(@RequestParam Integer id_pokoju,
                                                @RequestParam Integer id_personelu,
                                                @RequestParam String data_wydarzenia,
                                                @RequestParam String godzina_wydarzenia,
                                                @RequestParam String typ)
    {
        Wydarzenie wydarzenie = new Wydarzenie();
        wydarzenie.setDataWydarzenia(data_wydarzenia);
        wydarzenie.setGodzinaWydarzenia(godzina_wydarzenia);
        wydarzenie.setTyp(typ);
        wydarzenieRepository.save(wydarzenie);
        PersonelWydarzeniePokoj pwp = new PersonelWydarzeniePokoj();
        pwp.setIdPersonelu(id_personelu);
        pwp.setIdPokoju(id_pokoju);
        pwp.setIdWydarzenia(wydarzenie.getIdWydarzenia());
        personelWydarzeniePokojRepository.save(pwp);

        return wydarzenie;
    }

    @GetMapping(path="event/id", params = "id_pokoju")
    public @ResponseBody Iterable<Wydarzenie> getEventByIdPokoju(@RequestParam Integer id_pokoju)
    {
        return wydarzenieRepository.getEventByIdPokoju(id_pokoju);
    }

    @DeleteMapping(path="event/id")
    public @ResponseBody String deleteEventById(@RequestParam Integer id_wydarzenia)
    {
        wydarzenieRepository.deleteById(id_wydarzenia);
        return "deleted";
    }

    @GetMapping(path="event/id", params = "id_personelu")
    public @ResponseBody Iterable<Wydarzenie> getEventByIdPersonelu(@RequestParam Integer id_personelu)
    {
        return wydarzenieRepository.getEventByIdPersonelu(id_personelu);
    }
}

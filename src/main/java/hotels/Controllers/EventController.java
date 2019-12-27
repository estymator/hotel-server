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
    @ResponseBody Iterable<Wydarzenie> getAllEvents()
    {
        System.out.println("wszystkie wydarzenia");
        return wydarzenieRepository.findAll();
    }

    @PostMapping(path = "event/add")
    @ResponseBody Wydarzenie addEvent(@RequestParam Integer idPokoju,
                                                @RequestParam Integer idPersonelu,
                                                @RequestParam String dataWydarzenia,
                                                @RequestParam String godzinaWydarzenia,
                                                @RequestParam String typ)
    {
        Wydarzenie wydarzenie = new Wydarzenie();
        wydarzenie.setDataWydarzenia(dataWydarzenia);
        wydarzenie.setGodzinaWydarzenia(godzinaWydarzenia);
        wydarzenie.setTyp(typ);
        wydarzenieRepository.save(wydarzenie);
        PersonelWydarzeniePokoj pwp = new PersonelWydarzeniePokoj();
        pwp.setIdPersonelu(idPersonelu);
        pwp.setIdPokoju(idPokoju);
        pwp.setIdWydarzenia(wydarzenie.getIdWydarzenia());
        personelWydarzeniePokojRepository.save(pwp);

        return wydarzenie;
    }

    @GetMapping(path="event/id", params = "idPokoju")
    @ResponseBody Iterable<Wydarzenie> getEventByIdPokoju(@RequestParam Integer idPokoju)
    {
        return wydarzenieRepository.getEventByIdPokoju(idPokoju);
    }

    @GetMapping(path="event/id", params = "idPersonelu")
    @ResponseBody Iterable<Wydarzenie> getEventByIdPersonelu(@RequestParam Integer idPersonelu)
    {
        return wydarzenieRepository.getEventByIdPersonelu(idPersonelu);
    }
}

package hotels.Controllers;

import hotels.Repositories.PersonelWydarzeniePokojRepository;
import hotels.Repositories.WydarzenieRepository;
import hotels.models.PersonelWydarzeniePokoj;
import hotels.models.Wydarzenie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start_wydarzenia,
                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate koniec_wydarzenia,
                                                @RequestParam String tytul,
                                                @RequestParam String tresc,
                                             @RequestParam String kolor)
    {
        Wydarzenie wydarzenie = new Wydarzenie();
        wydarzenie.setStartWydarzenia(start_wydarzenia);
        wydarzenie.setKoniecWydarzenia(koniec_wydarzenia);
        wydarzenie.setTytul(tytul);
        wydarzenie.setTresc(tresc);
        wydarzenie.setKolor(kolor);
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

    @GetMapping(path="event/id", params ="id_wydarzenia")
    public @ResponseBody Optional<Wydarzenie> getById(@RequestParam Integer id_wydarzenia)
    {
        return wydarzenieRepository.findById(id_wydarzenia);
    }

    @GetMapping(path="event/id", params = "id_personelu")
    public @ResponseBody Iterable<Wydarzenie> getEventByIdPersonelu(@RequestParam Integer id_personelu)
    {
        return wydarzenieRepository.getEventByIdPersonelu(id_personelu);
    }

    @PutMapping(path="event/update")
    public @ResponseBody Optional<Wydarzenie> updateEvent(@RequestParam Integer id_wydarzenia,
                                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start_wydarzenia,
                                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate koniec_wydarzenia,
                                                          @RequestParam String tytul,
                                                          @RequestParam String tresc,
                                                          @RequestParam String kolor)
    {
        wydarzenieRepository.updateWydarzenie(id_wydarzenia, start_wydarzenia, koniec_wydarzenia, tytul, tresc, kolor);
        return wydarzenieRepository.findById(id_wydarzenia);
    }
}

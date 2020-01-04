package hotels.Controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import hotels.Repositories.*;
import hotels.models.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;


@CrossOrigin
@RestController
public class RoomController {

    @Autowired
    private PokojRepository pokojRepository;

    @PostMapping(path="/room/add")
    public @ResponseBody Pokoj addPokoj(@RequestParam Integer ilosc_osob,
                                        @RequestParam String standart,
                                        @RequestParam String status,
                                        @RequestParam Integer id_hotelu,
                                        @RequestParam Integer cena){
        Pokoj p =new Pokoj();
        p.setIloscOsob(ilosc_osob);
        p.setStandart(standart);
        p.setStatus(status);
        p.setCena(cena);
        p.setIdHotelu(id_hotelu);
        pokojRepository.save(p);
        System.out.println("Dodano pokoj");
        return p;
    }

    @GetMapping(path="/room/id")
    public @ResponseBody
    Optional<Pokoj> findPokojById(@RequestParam Integer id_pokoju)
    {
        System.out.println("Pokoj id");
        return pokojRepository.findById(id_pokoju);
    }

    @DeleteMapping(path="/room/id")
    public @ResponseBody
    String deletePokojById(@RequestParam Integer id_pokoju)
    {
        pokojRepository.deleteById(id_pokoju);
        return "deleted";
    }

    @PostMapping(path="room/reservation") //nieprzydatny
    public @ResponseBody Optional<Pokoj>reservation(@RequestParam Integer id_pokoju,
                                                    @RequestParam Integer id_hotelu)
    {
       Integer result = pokojRepository.findPokojByIdPokojuAndIdHotelu(id_pokoju,id_hotelu);
       System.out.println("Zmieniono wierszy- "+result);
       return findPokojById(id_pokoju);


    }


    @GetMapping(path="room/booked")
    public @ResponseBody Iterable<Pokoj>getTaken()
    {
        Iterable<Pokoj> result = pokojRepository.findByStatus("zajety");
        return result;

    }

    @PutMapping(path="room/update")
    public @ResponseBody Optional<Pokoj> updateRoom(@RequestParam Integer id_pokoju,
                                          @RequestParam Integer ilosc_osob,
                                          @RequestParam String standart,
                                          @RequestParam String status,
                                          @RequestParam Integer cena)
    {
        pokojRepository.updatePokoj(id_pokoju,status,ilosc_osob,standart,cena);
        return pokojRepository.findById(id_pokoju);
    }

    @GetMapping(path="room/attribute")
    public @ResponseBody Iterable<Pokoj>getByAttribute(@RequestParam Integer id_hotelu,
                                                       @RequestParam Integer ilosc_osob,
                                                       @RequestParam String standart,
                                                       @RequestParam Integer cena_min,
                                                       @RequestParam Integer cena_max)
    {
        Iterable<Pokoj> result = pokojRepository.findByIdHoteluAndIloscOsobAndStandartAndStatusAndCenaGreaterThanAndCenaLessThan(id_hotelu,ilosc_osob,standart,"wolny", cena_min, cena_max);
        return result;

    }

    @GetMapping(path="room/all")
    public @ResponseBody Iterable<Pokoj>getAll()
    {
        Iterable<Pokoj> result = pokojRepository.findAll();
        return result;
    }

    @GetMapping(path="room/available")
    public @ResponseBody Iterable<Pokoj>getAvailable()
    {
        Iterable<Pokoj> result = pokojRepository.findByStatus("wolny");
        return result;

    }
}

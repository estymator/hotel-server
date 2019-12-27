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
    public @ResponseBody Pokoj addPokoj(@RequestParam Integer iloscOsob,
                                        @RequestParam String standart,
                                        @RequestParam String status,
                                        @RequestParam Integer idHotelu){
        Pokoj p =new Pokoj();
        p.setIloscOsob(iloscOsob);
        p.setStandart(standart);
        p.setStatus(status);
        p.setIdHotelu(idHotelu);
        pokojRepository.save(p);
        System.out.println("Dodano pokoj");
        return p;
    }

    @GetMapping(path="/room/id")
    public @ResponseBody
    Optional<Pokoj> findPokojById(@RequestParam Integer idPokoju)
    {
        System.out.println("Pokoj id");
        return pokojRepository.findById(idPokoju);
    }

    @PostMapping(path="room/reservation") //nieprzydatny
    public @ResponseBody Optional<Pokoj>reservation(@RequestParam Integer idPokoju,
                                                    @RequestParam Integer idHotelu)
    {
       Integer result = pokojRepository.findPokojByIdPokojuAndIdHotelu(idPokoju,idHotelu);
       System.out.println("Zmieniono wierszy- "+result);
       return findPokojById(idPokoju);


    }


    @GetMapping(path="room/booked")
    public @ResponseBody Iterable<Pokoj>getTaken()
    {
        Iterable<Pokoj> result = pokojRepository.findByStatus("zajety");
        return result;

    }

    @GetMapping(path="room/attribute")
    public @ResponseBody Iterable<Pokoj>getByAttribute(@RequestParam Integer idHotelu,
                                                       @RequestParam Integer iloscOsob,
                                                       @RequestParam String standart)
    {
        Iterable<Pokoj> result = pokojRepository.findByIdHoteluAndIloscOsobAndStandartAndStatus(idHotelu,iloscOsob,standart,"wolny");
        return result;

    }

    @GetMapping(path="room/available")
    public @ResponseBody Iterable<Pokoj>getAvailable()
    {
        Iterable<Pokoj> result = pokojRepository.findByStatus("wolny");
        return result;

    }
}

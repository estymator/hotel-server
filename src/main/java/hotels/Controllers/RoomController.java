package hotels.Controllers;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import hotels.Repositories.*;
import hotels.models.*;
import org.springframework.format.annotation.DateTimeFormat;
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
                                        @RequestParam Integer id_hotelu,
                                        @RequestParam String zdjecie,
                                        @RequestParam Integer cena){
        Pokoj p =new Pokoj();
        p.setIloscOsob(ilosc_osob);
        p.setStandart(standart);
        p.setZdjecie(zdjecie);
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






    @PutMapping(path="room/update")
    public @ResponseBody Optional<Pokoj> updateRoom(@RequestParam Integer id_pokoju,
                                          @RequestParam Integer ilosc_osob,
                                          @RequestParam String standart,
                                          @RequestParam String zdjecie,
                                          @RequestParam Integer cena)
    {
        pokojRepository.updatePokoj(id_pokoju,ilosc_osob,standart,cena,zdjecie);
        return pokojRepository.findById(id_pokoju);
    }


    @GetMapping(path="room/attribute", params = {"id_hotelu", "ilosc_osob","standart","cena_min","cena_max"})
    public @ResponseBody Iterable<Pokoj>getByAttribute(@RequestParam Integer id_hotelu,
                                                       @RequestParam Integer ilosc_osob,
                                                       @RequestParam String standart,
                                                       @RequestParam Integer cena_min,
                                                       @RequestParam Integer cena_max)
    {
        Iterable<Pokoj> result = pokojRepository.findByIdHoteluAndIloscOsobAndStandartAndCenaGreaterThanAndCenaLessThan(id_hotelu,ilosc_osob,standart, cena_min, cena_max);
        return result;

    }

    @GetMapping(path="room/attribute", params = "id_hotelu")
    public @ResponseBody Iterable<Pokoj>getByAttribute(@RequestParam Integer id_hotelu)
    {
        Iterable<Pokoj> result = pokojRepository.findByIdHotelu(id_hotelu);
        return result;

    }

    @GetMapping(path="room/all")
    public @ResponseBody Iterable<Pokoj>getAll()
    {
        Iterable<Pokoj> result = pokojRepository.findAll();
        return result;
    }

    @GetMapping(path="room/available")
    public @ResponseBody Iterable<Rezerwacja>getAvailable(@RequestParam Integer id_pokoju,
                                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data_rozpoczecia,
                                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data_zakonczenia)
    {
        Iterable<Rezerwacja> result = pokojRepository.checkAvailable(id_pokoju,data_rozpoczecia,data_zakonczenia);
        return result;
    }
}

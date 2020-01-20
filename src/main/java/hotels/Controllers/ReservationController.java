package hotels.Controllers;


import hotels.Repositories.PokojRepository;
import hotels.Repositories.RezerwacjaRepository;
import hotels.models.Rezerwacja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@CrossOrigin
@RestController
public class ReservationController {

    @Autowired
    RezerwacjaRepository rezerwacjaRepository;

    @Autowired
    PokojRepository pokojRepository;

    @PostMapping(path="/reservation/add")
    public @ResponseBody
    Rezerwacja addReservation(@RequestParam Integer id_pokoju,
                                        @RequestParam Integer id_klienta,
                                        @RequestParam String rodzaj,
                                        @RequestParam String stan,
                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data_rozpoczecia,
                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data_zakonczenia){
        Iterable<Rezerwacja> check = pokojRepository.checkAvailable(id_pokoju, data_rozpoczecia, data_zakonczenia);
        int counter = 0;
        Rezerwacja r = new Rezerwacja();
        for (Rezerwacja i : check) {
            counter++;
        }
        if(counter>0)
        {
            return null;
        }else
        {

            r.setIdKlienta(id_klienta);
            r.setIdPokoju(id_pokoju);
            r.setRodzaj(rodzaj);
            r.setStan(stan);
            r.setDataRozpoczecia(data_rozpoczecia);
            r.setDataZakonczenia(data_zakonczenia);
            rezerwacjaRepository.save(r);
            return r;
        }



    }

    @GetMapping(path="/reservation/id", params = "id_pokoju")
    public @ResponseBody
    Iterable<Rezerwacja> getReservationByRoomId(@RequestParam Integer id_pokoju){
        System.out.println("rezerwacje pokoju "+id_pokoju);
        return rezerwacjaRepository.findRezerwacjaByIdPokoju(id_pokoju);
    }

    @GetMapping(path="/reservation/id", params = "id_klienta")
    public @ResponseBody
    Iterable<Rezerwacja> getReservationById(@RequestParam Integer id_klienta){
        System.out.println("rezerwacje klienta "+id_klienta);
        return rezerwacjaRepository.findRezerwacjaByIdKlienta(id_klienta);
    }

    @GetMapping(path="/reservation/id", params = "id_hotelu")
    public @ResponseBody
    Iterable<Rezerwacja> getReservationByHotelId(@RequestParam Integer id_hotelu){
        System.out.println("rezerwacje w hotelu "+id_hotelu);
        return rezerwacjaRepository.findRezerwacjaByIdHotelu(id_hotelu);
    }

    @GetMapping(path="/reservation/id", params = {"id_pokoju", "id_klienta"})
    public @ResponseBody
    Iterable<Rezerwacja> getReservation(@RequestParam Integer id_pokoju,
                                        @RequestParam Integer id_klienta){
        System.out.println("rezerwacje klienta "+id_klienta+id_pokoju);
        return rezerwacjaRepository.findRezerwacjaByIdKlientaAndIdPokoju(id_klienta, id_pokoju);
    }

    @DeleteMapping(path="/reservation")
    public @ResponseBody String deleteReservation(Integer id_rezerwacji)
    {
        rezerwacjaRepository.deleteById(id_rezerwacji);
        return "Deleted";

    }

}

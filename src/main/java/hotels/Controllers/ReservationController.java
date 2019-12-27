package hotels.Controllers;


import hotels.Repositories.RezerwacjaRepository;
import hotels.models.Rezerwacja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class ReservationController {

    @Autowired
    RezerwacjaRepository rezerwacjaRepository;

    @PostMapping(path="/reservation/add")
    public @ResponseBody
    Rezerwacja addReservation(@RequestParam Integer idPokoju,
                                        @RequestParam Integer idKlienta,
                                        @RequestParam String rodzaj,
                                        @RequestParam String stan,
                                        @RequestParam String dataRozpoczecia,
                                        @RequestParam String dataZakonczenia){
        Rezerwacja r = new Rezerwacja();
        r.setIdKlienta(idKlienta);
        r.setIdPokoju(idPokoju);
        r.setRodzaj(rodzaj);
        r.setStan(stan);
        r.setDataRozpoczęcia(dataRozpoczecia);
        r.setDataZakonczenia(dataZakonczenia);
        rezerwacjaRepository.save(r);
        return r;
    }

    @GetMapping(path="/reservation/id", params = "idPokoju")
    public @ResponseBody
    Iterable<Rezerwacja> getReservationByRoomId(@RequestParam Integer idPokoju){
        System.out.println("rezerwacje pokoju "+idPokoju);
        return rezerwacjaRepository.findRezerwacjaByIdPokoju(idPokoju);
    }

    @GetMapping(path="/reservation/id", params = "idKlienta")
    public @ResponseBody
    Iterable<Rezerwacja> getReservationByHotelId(@RequestParam Integer idKlienta){
        System.out.println("rezerwacje klienta "+idKlienta);
        return rezerwacjaRepository.findRezerwacjaByIdKlienta(idKlienta);
    }

    @GetMapping(path="/reservation/id", params = {"idPokoju", "idKlienta"})
    public @ResponseBody
    Iterable<Rezerwacja> getReservation(@RequestParam Integer idPokoju,
                                        @RequestParam Integer idKlienta){
        System.out.println("rezerwacje klienta "+idKlienta+idPokoju);
        return rezerwacjaRepository.findRezerwacjaByIdKlientaAndIdPokoju(idKlienta, idPokoju);
    }

    @DeleteMapping(path="/reservation")
    public @ResponseBody String deleteReservation(Integer idPokoju, Integer idKlienta)
    {
        if(rezerwacjaRepository.deleteByIdKlientaAndIdPokoju(idKlienta, idPokoju)==1)
        {
            System.out.println("usunieto personel");
            return "Deleted";
        }else
        {
            System.out.println("Błąd");
            return "Błąd";
        }


    }

}

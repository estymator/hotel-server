package hotels.Controllers;


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

    @PostMapping(path="/reservation/add")
    public @ResponseBody
    Rezerwacja addReservation(@RequestParam Integer id_pokoju,
                                        @RequestParam Integer id_klienta,
                                        @RequestParam String rodzaj,
                                        @RequestParam String stan,
                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data_rozpoczecia,
                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data_zakonczenia){
        Rezerwacja r = new Rezerwacja();
        r.setIdKlienta(id_klienta);
        r.setIdPokoju(id_pokoju);
        r.setRodzaj(rodzaj);
        r.setStan(stan);
        r.setDataRozpoczęcia(data_rozpoczecia);
        r.setDataZakonczenia(data_zakonczenia);
        rezerwacjaRepository.save(r);
        return r;
    }

    @GetMapping(path="/reservation/id", params = "id_pokoju")
    public @ResponseBody
    Iterable<Rezerwacja> getReservationByRoomId(@RequestParam Integer id_pokoju){
        System.out.println("rezerwacje pokoju "+id_pokoju);
        return rezerwacjaRepository.findRezerwacjaByIdPokoju(id_pokoju);
    }

    @GetMapping(path="/reservation/id", params = "id_klienta")
    public @ResponseBody
    Iterable<Rezerwacja> getReservationByHotelId(@RequestParam Integer id_klienta){
        System.out.println("rezerwacje klienta "+id_klienta);
        return rezerwacjaRepository.findRezerwacjaByIdKlienta(id_klienta);
    }

    @GetMapping(path="/reservation/id", params = {"id_pokoju", "id_klienta"})
    public @ResponseBody
    Iterable<Rezerwacja> getReservation(@RequestParam Integer id_pokoju,
                                        @RequestParam Integer id_klienta){
        System.out.println("rezerwacje klienta "+id_klienta+id_pokoju);
        return rezerwacjaRepository.findRezerwacjaByIdKlientaAndIdPokoju(id_klienta, id_pokoju);
    }

    @DeleteMapping(path="/reservation")
    public @ResponseBody String deleteReservation(Integer id_pokoju, Integer id_klienta)
    {
        if(rezerwacjaRepository.deleteByIdKlientaAndIdPokoju(id_klienta, id_pokoju)==1)
        {
            System.out.println("usunieto personel");
            return "Deleted";
        }else
        {
            System.out.println("Błąd");
            return "Error";
        }


    }

}

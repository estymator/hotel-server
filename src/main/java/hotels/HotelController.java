package hotels;


import java.security.Principal;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import hotels.Repositories.*;
import hotels.models.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HotelController {


    @Autowired // This means to get the bean called PersonelRepository Which is auto-generated by Spring, we will use it to handle the data
    private HotelRepository hotelRepository;
    @Autowired
    private PersonelRepository personelRepository;
    @Autowired
    private KlientRepository klientRepository;
    @Autowired
    private DaneLogowaniaRepository daneLogowaniaRepository;
    @Autowired
    private PokojRepository pokojRepository;

    @PostMapping(path="/register")
    public @ResponseBody Klient addNewUser(@RequestParam String imie,
                                           @RequestParam String nazwisko,
                                           @RequestParam String telefon,
                                           @RequestParam String email,
                                           @RequestParam String login,
                                           @RequestParam String haslo){
        DaneLogowania d = new DaneLogowania();
        d.setHaslo(haslo);
        d.setLogin(login);
        daneLogowaniaRepository.save(d);
        Klient k = new Klient();
        k.setImie(imie);
        k.setNazwisko(nazwisko);
        k.setAdres_mail(email);
        k.setNr_telefonu(telefon);
        k.setLogin(login);
        klientRepository.save(k);
        System.out.println("Rejestracja " + k.getImie());
        return k;
    }

    @GetMapping(path="/home")
    public @ResponseBody Iterable<Klient> sendHome(Principal principal)
    {
        System.out.println("/home "+principal.getName());
        return findKlientByLogin(principal.getName());
    }

    @PostMapping(path="/klient/id")
    public @ResponseBody
    Optional<Klient> findKlientById(@RequestParam Integer id_klienta)
    {
        System.out.println("Klient id");
        return klientRepository.findById(id_klienta);
    }

    @PostMapping(path="/klient/login")
    public @ResponseBody
    Iterable<Klient> findKlientByLogin(@RequestParam String login)
    {
        System.out.println("Klient login");
        return klientRepository.findBylogin(login);
    }

    /*@GetMapping(path="/error")
    public ModelAndView errorPage()
    {
        System.out.println("Error");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }*/


    @PostMapping(path="/hotel/add") // Map ONLY POST Requests
    public @ResponseBody Hotel addNewHotel (@RequestParam String nazwa
            , @RequestParam String adres
            , @RequestParam String email
            , @RequestParam String telefon
            , @RequestParam Integer id_admina) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Hotel h = new Hotel();
        h.setNazwa(nazwa);
        h.setAdres(adres);
        h.setAdres_mail(email);
        h.setNr_telefonu(telefon);
        h.setId_admina(id_admina);
        System.out.println("Dodano hotel "+ h.getNazwa());
        hotelRepository.save(h);
        return h;
    }

    @GetMapping(path="/hotel/all")
    public @ResponseBody Iterable<Hotel> getAllUsers() {
        // This returns a JSON or XML with the users
        System.out.println("hotel all");
        return hotelRepository.findAll();
    }

    @PostMapping(path="/personel/add")
    public @ResponseBody Personel addNewPersonel(@RequestParam String imie,
                                               @RequestParam String nazwisko,
                                               @RequestParam String email,
                                               @RequestParam String telefon,
                                               @RequestParam Integer idHotelu){
        System.out.println(imie+nazwisko+email+telefon+idHotelu);
        Personel  p =new Personel();
        p.setImie(imie);
        p.setNazwisko(nazwisko);
        p.setAdres_mail(email);
        p.setNr_telefonu(telefon);
        p.setIdHotelu(idHotelu);
        personelRepository.save(p);
        System.out.println("Dodano personel "+p.getImie());
        return p;
    }

    @PostMapping(path="/personel/delete")
    public @ResponseBody
    String deletePersonel(@RequestParam Integer id_personelu)
    {
        personelRepository.deleteById(id_personelu);
        System.out.println("usunieto personel");
        return "Deleted";
    }

    @PostMapping(path="/personel/id", params = "id_personelu")
    public @ResponseBody
    Optional<Personel> findPersonelById(@RequestParam Integer id_personelu)
    {
        System.out.println("Personel id");
        return personelRepository.findById(id_personelu);
    }

    @PostMapping(path="/personel/id", params = "idHotelu")
    public @ResponseBody
    Iterable<Personel> findPersonelByIdHotelu(@RequestParam Integer idHotelu)
    {
        System.out.println("Personel id");
        System.out.println(idHotelu);
        return personelRepository.findByidHotelu(idHotelu);
    }


    @GetMapping(path="/personel/all")
    public @ResponseBody Iterable<Personel> getAllPersonel()
    {
        System.out.println("Personel All");
        return personelRepository.findAll();
    }

    @GetMapping(path="/")
    public @ResponseBody String sendRoot()
    {
        return "root";
    }

    @GetMapping(path="/login")
    public ModelAndView login()
    {
        System.out.println("Logowanie");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }



    @PostMapping(path="/pokoj/add")
    public @ResponseBody Pokoj addPokoj(@RequestParam Integer ilosc_osob,
                                         @RequestParam String standart,
                                         @RequestParam String status,
                                         @RequestParam Integer idHotelu){
        Pokoj p =new Pokoj();
        p.setIloscOsob(ilosc_osob);
        p.setStandart(standart);
        p.setStatus(status);
        p.setIdHotelu(idHotelu);
        pokojRepository.save(p);
        System.out.println("Dodano pokoj");
        return p;
    }


}
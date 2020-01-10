package hotels.Controllers;


import java.security.Principal;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import hotels.Repositories.*;
import hotels.models.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;


@CrossOrigin
@RestController
public class StaffController {


    @Autowired
    private PersonelRepository personelRepository;

    @PostMapping(path="/personel/add")
    public @ResponseBody Personel addNewPersonel(@RequestParam String imie,
                                                 @RequestParam String nazwisko,
                                                 @RequestParam String adres_mail,
                                                 @RequestParam String nr_telefonu,
                                                 @RequestParam String pensja,
                                                 @RequestParam Integer id_hotelu){
        System.out.println(imie+nazwisko+adres_mail+nr_telefonu+id_hotelu);
        Personel  p =new Personel();
        p.setImie(imie);
        p.setNazwisko(nazwisko);
        p.setPensja(pensja);
        p.setAdres_mail(adres_mail);
        p.setNr_telefonu(nr_telefonu);
        p.setIdHotelu(id_hotelu);
        personelRepository.save(p);
        System.out.println("Dodano personel "+p.getImie());
        return p;
    }

    @DeleteMapping(path="/personel/id")
    public @ResponseBody
    String deletePersonel(@RequestParam Integer id_personelu)
    {
        personelRepository.deleteById(id_personelu);
        System.out.println("usunieto personel");
        return "Deleted";
    }

    @GetMapping(path="/personel/id", params = "id_personelu")
    public @ResponseBody
    Optional<Personel> findPersonelById(@RequestParam Integer id_personelu)
    {
        System.out.println("Personel id");
        return personelRepository.findById(id_personelu);
    }

    @GetMapping(path="/personel/id", params = "id_hotelu")
    public @ResponseBody
    Iterable<Personel> findPersonelByIdHotelu(@RequestParam Integer id_hotelu)
    {
        System.out.println("Personel id");
        System.out.println(id_hotelu);
        return personelRepository.findByIdHotelu(id_hotelu);
    }


    @GetMapping(path="/personel/all")
    public @ResponseBody Iterable<Personel> getAllPersonel()
    {
        System.out.println("Personel All");
        return personelRepository.findAll();
    }




}

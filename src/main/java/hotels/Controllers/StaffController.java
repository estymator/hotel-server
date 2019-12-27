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

    @DeleteMapping(path="/personel/id")
    public @ResponseBody
    String deletePersonel(@RequestParam Integer idPersonelu)
    {
        personelRepository.deleteById(idPersonelu);
        System.out.println("usunieto personel");
        return "Deleted";
    }

    @GetMapping(path="/personel/id", params = "idPersonelu")
    public @ResponseBody
    Optional<Personel> findPersonelById(@RequestParam Integer idPersonelu)
    {
        System.out.println("Personel id");
        return personelRepository.findById(idPersonelu);
    }

    @GetMapping(path="/personel/id", params = "idHotelu")
    public @ResponseBody
    Iterable<Personel> findPersonelByIdHotelu(@RequestParam Integer idHotelu)
    {
        System.out.println("Personel id");
        System.out.println(idHotelu);
        return personelRepository.findByIdHotelu(idHotelu);
    }


    @GetMapping(path="/personel/all")
    public @ResponseBody Iterable<Personel> getAllPersonel()
    {
        System.out.println("Personel All");
        return personelRepository.findAll();
    }

}

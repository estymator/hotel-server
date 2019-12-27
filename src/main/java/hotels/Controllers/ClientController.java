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
public class ClientController {

    @Autowired
    private KlientRepository klientRepository;


    @GetMapping(path="/klient/id")
    public @ResponseBody
    Optional<Klient> findKlientById(@RequestParam Integer idKlienta)
    {
        System.out.println("Klient id");
        return klientRepository.findById(idKlienta);
    }

    @GetMapping(path="/klient/all")
    public @ResponseBody
    Iterable<Klient> getAll()
    {
        System.out.println("Wszyscy klienci");
        return klientRepository.findAll();
    }



    @GetMapping(path="/klient/login")
    public @ResponseBody
    Iterable<Klient> findKlientByLogin(@RequestParam String login)
    {
        System.out.println("Klient login");
        return klientRepository.findBylogin(login);
    }
}

package hotels.Controllers;

import hotels.Repositories.WydarzenieRepository;
import hotels.models.Wydarzenie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class EventController {

    @Autowired
    WydarzenieRepository wydarzenieRepository;

    @GetMapping(path = "/event/all")
    @ResponseBody Iterable<Wydarzenie> getAllEvents()
    {
        System.out.println("wszystkie wydarzenia");
        return wydarzenieRepository.findAll();
    }
}

package hotels.Controllers;

import hotels.Repositories.OpiniaRepository;
import hotels.models.Opinia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class OpinionController {

    @Autowired
    private OpiniaRepository opiniaRepository;


    @PostMapping(path="opinion/add")
    public @ResponseBody Opinia addOpinion(@RequestParam String data_wystawienia,
                      @RequestParam Integer gwiazdki,
                      @RequestParam Integer id_hotelu,
                      @RequestParam String tresc)
    {
        Opinia o = new Opinia();
        o.setDataWystawienia(data_wystawienia);
        o.setGwiazdki(gwiazdki);
        o.setIdHotelu(id_hotelu);
        o.setTresc(tresc);
        opiniaRepository.save(o);
        return o;
    }

    @DeleteMapping(path="opinion/id")
    public @ResponseBody String deleteOpinion(@RequestParam Integer id)
    {
        opiniaRepository.deleteById(id);
        return "deleted";
    }

    @GetMapping(path="opinion/id")
    public @ResponseBody Iterable<Opinia> getOpinionByIdHotelu(@RequestParam Integer id_hotelu)
    {
       return opiniaRepository.findByIdHotelu(id_hotelu);
    }
}

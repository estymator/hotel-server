package hotels.Controllers;


import hotels.Repositories.PosilekRepository;
import hotels.models.Posilek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class MealController {

    @Autowired
    PosilekRepository posilekRepository;

    @GetMapping(path="/meal/all")
    public @ResponseBody
    Iterable<Posilek> getAllMeals()
    {
        return posilekRepository.findAll();
    }

    @GetMapping(path="/meal/id", params = "id_menu")
    public @ResponseBody
    Iterable<Posilek> getMealsByIdMenu(@RequestParam Integer id_menu)
    {
        return posilekRepository.findByIdMenu(id_menu);
    }

    @GetMapping(path="/meal/id", params = "id_posilku")
    public @ResponseBody
    Optional<Posilek> getMealById(@RequestParam Integer id_posilku)
    {
        return posilekRepository.findById(id_posilku);
    }

    @DeleteMapping(path="/meal/id")
    public @ResponseBody
    String deleteMealById(@RequestParam Integer id_posilku)
    {
        posilekRepository.deleteById(id_posilku);
       return "Deleted";
    }


    @DeleteMapping(path="/meal/name")
    public @ResponseBody
    String deleteMealById(@RequestParam String nazwa)
    {

        if(posilekRepository.deleteByNazwa(nazwa)>0)
        {
            return "Deleted";
        }else
        {
            return "Not found";
        }
    }

    @PostMapping(path="/meal/add")
    public @ResponseBody
    Posilek addMeal(@RequestParam Integer id_menu,
                    @RequestParam String nazwa)
    {
        Posilek p = new Posilek();
        p.setIdMenu(id_menu);
        p.setNazwa(nazwa);
        posilekRepository.save(p);
        return p;
    }

    @PutMapping(path="/meal/update")
    public @ResponseBody Optional<Posilek> updateMeal(@RequestParam Integer id_posilku,
                                                      @RequestParam Integer id_menu,
                                                      @RequestParam String nazwa)
    {
        posilekRepository.updateMeal(id_posilku,id_menu, nazwa);
        return getMealById(id_posilku);
    }

}

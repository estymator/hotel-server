package hotels.Controllers;


import hotels.Repositories.MenuRepository;
import hotels.models.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    @GetMapping(path = "/menu/all")
    public @ResponseBody Iterable<Menu> getAll()
    {
        return menuRepository.findAll();
    }

    @DeleteMapping(path = "/menu/id")
    public String deleteMenu(@RequestParam Integer id_menu)
    {
        menuRepository.deleteById(id_menu);
        return "Deleted";
    }

    @PostMapping(path = "/menu/add")
    public Menu addMenu(@RequestParam Integer id_hotelu)
    {
        Menu m=new Menu();
        m.setIdHotelu(id_hotelu);
        menuRepository.save(m);
        return m;
    }

    @GetMapping(path = "/menu/id", params = "id_hotelu")
    public @ResponseBody Iterable<Menu> getMenuByIdHotelu(@RequestParam Integer id_hotelu)
    {
        return menuRepository.findByIdHotelu(id_hotelu);
    }

    @GetMapping(path = "/menu/id", params = "id_menu")
    public @ResponseBody
    Optional<Menu> getMenuById(@RequestParam Integer id_menu)
    {
        return menuRepository.findById(id_menu);
    }
}

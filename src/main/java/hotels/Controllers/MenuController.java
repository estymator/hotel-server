package hotels.Controllers;


import hotels.Repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MenuController {

    @Autowired
    MenuRepository menuRepository;
}

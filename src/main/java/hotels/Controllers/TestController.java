package hotels.Controllers;

import hotels.Repositories.TestRepository;
import hotels.models.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin
@RestController
public class TestController {

    @Autowired
    TestRepository testRepository;

    @PostMapping(path="test/add")
    public @ResponseBody
    Test addTest(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate d1,
                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate d2)
    {
        Test t = new Test();
        t.setDataPierwsza(d1);
        t.setDataDruga(d2);
        testRepository.save(t);
        return t;
    }

    @GetMapping(path="test/all")
    public @ResponseBody Iterable<Test> showAllTests()
    {
        return testRepository.findAll();
    }

    @GetMapping(path="test/check")
    public @ResponseBody Iterable<Test> check(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate d1,
                                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate d2)
    {
        return testRepository.check(d1,d2);
    }
}

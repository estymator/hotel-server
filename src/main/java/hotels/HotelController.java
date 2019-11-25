package hotels;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.*;

@RestController
public class HotelController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping("/hotels")
    public Hotel hotel(@RequestParam(value="nazwa", defaultValue="Default") String nazwa) {
        return new Hotel(counter.incrementAndGet(),
                String.format(template, nazwa));
    }


}
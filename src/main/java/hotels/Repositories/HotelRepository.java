package hotels.Repositories;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<hotels.models.Hotel, Integer> {
}

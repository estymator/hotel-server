package hotels.Repositories;

import hotels.models.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface TestRepository extends CrudRepository<Test, Integer> {

    @Query("Select t from Test t where t.dataPierwsza <= :d1 and t.dataDruga >= :d1 or t.dataPierwsza <= :d2 and t.dataDruga >= :d2")
    Iterable<Test> check(@Param("d1") LocalDate d1, @Param("d2") LocalDate d2);
}

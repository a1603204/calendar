package fi.haagahelia.calendar.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByDate(String date);
    
}
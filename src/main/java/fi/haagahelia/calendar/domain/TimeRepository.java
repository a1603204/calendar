package fi.haagahelia.calendar.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import fi.haagahelia.calendar.domain.Time;

public interface TimeRepository extends CrudRepository<Time, Long> {

    List<Time> findByClock(String clock);
    
}
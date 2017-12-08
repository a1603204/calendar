package fi.haagahelia.calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import fi.haagahelia.calendar.domain.Time;
import fi.haagahelia.calendar.domain.TimeRepository;
import fi.haagahelia.calendar.domain.Person;
import fi.haagahelia.calendar.domain.PersonRepository;
import fi.haagahelia.calendar.domain.User;
import fi.haagahelia.calendar.domain.UserRepository;

@SpringBootApplication
public class CalendarApplication {
	private static final Logger log = LoggerFactory.getLogger(CalendarApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(CalendarApplication.class, args);
	}
	
	@Bean 
	public CommandLineRunner personDemo(PersonRepository prepository, TimeRepository trepository, UserRepository urepository) {
		return (args) -> {
			
		//creating of time to chose
			log.info("save a time");
			trepository.save(new Time("08:00"));
			trepository.save(new Time("09:00"));
			trepository.save(new Time("10:00"));
			trepository.save(new Time("11:00"));
			trepository.save(new Time("12:00"));
			trepository.save(new Time("13:00"));
			trepository.save(new Time("14:00"));
			trepository.save(new Time("15:00"));
			trepository.save(new Time("16:00"));
			trepository.save(new Time("17:00"));
			trepository.save(new Time("18:00"));
			trepository.save(new Time("19:00"));
			trepository.save(new Time("20:00"));
			trepository.save(new Time("21:00"));
			trepository.save(new Time("22:00"));
			
		//Creating user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			urepository.save(user1);
			
			log.info("fetch all list");
			for (Person person : prepository.findAll()) {
				log.info(person.toString());
			}
};
	}}

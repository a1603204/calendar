package fi.haagahelia.calendar.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Time {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long timeid;
	private String clock;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "time")
	private List<Person> persons;
	
	public Time() {}
	
	public Time(String clock) {
		super();
		this.clock = clock;
	}

	public Long getTimeid() {
		return timeid;
	}

	public void setTimeid(Long timeid) {
		this.timeid = timeid;
	}

	public String getClock() {
		return clock;
	}

	public void setClock(String clock) {
		this.clock = clock;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	@Override
	public String toString() {
		return "Time [timeid=" + timeid + ", clock=" + clock + "]";
	}
}

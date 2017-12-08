package fi.haagahelia.calendar.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Person {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long id;
	private String date;
	
	@ManyToOne
    @JsonIgnore
    @JoinColumn(name = "timeid")
	private Time time;
	
	private String location;
	private String description;
	
	public Person() {}
	
	public Person(String date, Time time, String location, String description){
	super();
	this.date = date;
	this.time = time;
	this.location = location;
	this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		if (this.time != null)
			return "Person [id=" + id + ", date=" + date + ", time" + this.getTime() + ", location=" + location + " description =" + this.description + "]";		
		else
			return "Person [id=" + id + ", location=" + location + ", description=" + description + "]";
	}
	}
	
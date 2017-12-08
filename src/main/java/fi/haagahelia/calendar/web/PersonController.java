package fi.haagahelia.calendar.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.calendar.domain.TimeRepository;
import fi.haagahelia.calendar.domain.Person;
import fi.haagahelia.calendar.domain.PersonRepository;

@Controller
public class PersonController {
	
	@Autowired
	private PersonRepository repository;
	
	
	@Autowired
	private TimeRepository trepository;
	
	// Login to website
	 @RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    }	
		
	 // Open the main page
	 @RequestMapping(value="/calendar")
	    public String calendar(Model model) {	
	        model.addAttribute("persons", repository.findAll());
	        return "calendar";
	    }

	 // Add new things to do
	    @RequestMapping(value = "/add")
	    public String addCalendar(Model model){
	    	model.addAttribute("person", new Person());
	    	model.addAttribute("times", trepository.findAll());
	        return "addperson";
}
	    
	 // Save new things new things
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Person person){
	        repository.save(person);
	        return "redirect:calendar";
	    }   

	 // Delete things
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteStudent(@PathVariable("id") Long personId, Model model) {
	    	repository.delete(personId);
	        return "redirect:../calendar";
	    }     
	}

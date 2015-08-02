package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

@Controller
public class CRUDController {
	@Autowired
	private PersonRepository repository;
    @RequestMapping("/crud")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("person", new Person());
        return "crud";
    }
    
    @RequestMapping(value="/deletePerson")
	public String deletePerson(@ModelAttribute("form-delete") Person person){
    	Iterable<Person> allPersons = this.repository.findAll();
    	Iterable<Person> filterPersons = findTheRightPerson(person, allPersons);
    	this.repository.delete(filterPersons.iterator().next());
		return "redirect:/crud";
	}

    @RequestMapping(value="/updatePerson")
   	public String updatePerson(@ModelAttribute("form-delete") Person person){
       	this.repository.save(person);
   		return "redirect:/crud";
   	}
	private Iterable<Person> findTheRightPerson(Person person, Iterable<Person> allPersons) {
		Iterable<Person> filterPersons=Iterables.filter(allPersons, new Predicate<Person>() {
    	    @Override
    	    public boolean apply(Person p) {
    	        return p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName());
    	    }
    	});
		return filterPersons;
	}
    @RequestMapping(value="/insertPerson")
   	public String insertPerson(@ModelAttribute("form-delete") Person person){
       
       	this.repository.save(person);
   		return "redirect:/crud";
   	}
   
    
    @ModelAttribute("allPersons")
    public List<Person> populateSeedStarters() {
        return Lists.newArrayList(this.repository.findAll());
    }
       
}

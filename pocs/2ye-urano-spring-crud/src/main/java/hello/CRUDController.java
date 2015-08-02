package hello;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
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
    	Iterable<Person> filterPersons=Iterables.filter(allPersons, new Predicate<Person>() {
    	    @Override
    	    public boolean apply(Person p) {
    	        return p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName());
    	    }
    	});
    	this.repository.delete(filterPersons.iterator().next());
		return "redirect:/crud";
	}
    @RequestMapping(value="/insertPerson")
   	public String insertPerson(@ModelAttribute("form-delete") Person person){
       
       	this.repository.save(person);
   		return "redirect:/crud";
   	}
    @RequestMapping(value = "/find")
	public String teste(Model model) {	
    	Iterable<Person> allPersonsIterable = this.repository.findAll();
    	ArrayList<Person> allPersons = Lists.newArrayList(allPersonsIterable);
    	model.addAttribute("allPersons", allPersons);
		return allPersons.toString();
	}
    
    @ModelAttribute("allPersons")
    public List<Person> populateSeedStarters() {
        return Lists.newArrayList(this.repository.findAll());
    }
       
}

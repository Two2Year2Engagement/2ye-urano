package hello;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

@Controller
public class CacheController {
	@Autowired
	private PersonRepository repository;

	private static final Logger log = LoggerFactory.getLogger(AutocompleteCacheApplication.class);

	
	@RequestMapping("/cache")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("person", new Person());
		return "cache";
	}

	
	@RequestMapping(value = "/autocompletePerson")
	public @ResponseBody List<String> autocompletePerson(@RequestParam("term") String name) {

		log.info("autocomplete name: " + name);
		List<Person> personList = this.getPerson(name);

		Collection<String> personToStringList = Collections2.transform(personList, new Function<Person, String>() {
			@Override
			public String apply(final Person person) {
				return person.toString();
			}
		});
		return Lists.newArrayList(personToStringList);
	}


	@RequestMapping(value = "/find")
	public @ResponseBody List<String> findPerson(@RequestParam(value="name") String name) {
		log.info("RequestMapping find, name: "+name);
		String[] names=name.split(" ");
		List<Person> personList = this.repository.findByFirstName(names[0]);

		Collection<String> personToStringList = Collections2.transform(personList, new Function<Person, String>() {
			@Override
			public String apply(final Person person) {
				return person.toStringForFind();
			}
		});
		return Lists.newArrayList(personToStringList);
	}
	

	@Cacheable("firstName")
	public List<Person> getPerson(String name) {

		return repository.findByFirstNameContaining(name);
	}

}

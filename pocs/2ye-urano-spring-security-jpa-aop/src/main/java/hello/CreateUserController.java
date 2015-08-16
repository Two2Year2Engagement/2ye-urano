package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateUserController {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository  UserRepository;
	
	
	@RequestMapping("/login")
	public String login(Model model){
	model.addAttribute("user",new User());
		return "login";
	}
	
	@RequestMapping(value="/saveUser")
	public String saveUser(){
		System.out.println("save user");
		return "/hello";
	}
	@RequestMapping("/hello")
	public String hello(Model model){
	model.addAttribute("user",new Users());
		return "hello";
	}
	
	@RequestMapping("/home")
	public String home(Model model){
	model.addAttribute("user",new Users());
		return "home";
	}
	
	@RequestMapping(value="/createUser")
	public String createUser(@ModelAttribute Users user){
		System.out.println("CREATE USER");
		System.out.println("user>"+user.toString());
		UserRepository.save(user);
		roleRepository.save(new Authorities(user.getUsername(), "ROLE_ADMIN"));
		return "/login";
	}
}

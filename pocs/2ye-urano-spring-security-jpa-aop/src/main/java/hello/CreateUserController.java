package hello;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateUserController {

	
	
	@RequestMapping("/createUser")
	public void createUser(@RequestParam(value="username") String username,@RequestParam(value="password") String password){
		System.out.println(username+password);
		
		
		
	}
	
	@RequestMapping("/login")
	public String login(Model model){
	model.addAttribute("user",new Users());
		return "login";
	}
}

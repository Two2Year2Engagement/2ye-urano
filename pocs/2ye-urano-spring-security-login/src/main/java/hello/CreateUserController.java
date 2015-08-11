package hello;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateUserController {

	@Autowired
	private DataSource dataSource;
	
	@RequestMapping(value="/createUser", method=RequestMethod.POST)
	public String createUser(@ModelAttribute User user){
		System.out.println(user);
		try {
			Connection connection = dataSource.getConnection();
			Statement createStatement = connection.createStatement();
			createStatement.executeUpdate("insert into users (username, password, enabled) values ('"+user.getUsername()+"', '"+user.getPassword()+"', true);");
			createStatement.executeUpdate("insert into authorities (username, authority) values ('"+user.getUsername()+"', 'ROLE_ADMIN');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "/login";
		
	}
	
	@RequestMapping("/login")
	public String login(Model model){
	model.addAttribute("user",new User());
		return "login";
	}
	
	
	@RequestMapping("/hello")
	public String hello(Model model){
	model.addAttribute("user",new User());
		return "hello";
	}
}

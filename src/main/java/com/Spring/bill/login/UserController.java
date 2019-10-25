package com.Spring.bill.login;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class UserController  {

	@RequestMapping(value="/users", method=RequestMethod.GET)
	@ResponseBody
	public String getController(Model model) {
		return "hello Spring"+model;
	}
	
	@RequestMapping("/")
	public String showHome() {
	    return "home";
	}

	@RequestMapping(value = "/login" , method = RequestMethod.GET) 
	public String showLogin(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST) 
	public String customer(@ModelAttribute User user, Model model) { 
		model.addAttribute("name",user.getName());
		model.addAttribute("password",user.getPassword());

		return "test"; 
	} 
	/*@RequestMapping(value = "/test")
    public String index(Model model){ 
		String students ="刘洋";
		model.addAttribute("s",students);
		return "test";
    }*/
	@RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return principal.toString();
    }
	
	@RequestMapping("/admin")
	@ResponseBody
	public String printAdmin() {
	   return "如果你看见这句话，说明你有ROLE_ADMIN角色";
	}

	@RequestMapping("/user")
	@ResponseBody
	public String printUser() {
		return "如果你看见这句话，说明你有ROLE_USER角色";
	}
	
}

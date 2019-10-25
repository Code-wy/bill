package com.Spring.bill.register;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Spring.bill.login.User;


@Controller
public class RegisterController {

	@Autowired
	RegisterService registerService;
	
	@RequestMapping(value="/register", method={RequestMethod.GET,RequestMethod.POST})
	public String oldStyleRegisterUser(HttpServletRequest request,
			@ModelAttribute User user,RedirectAttributes redirectAttributes, Model model) {		
		
		if(request.getMethod().equals("GET") ){//判断用户的请求		
			return "registerForm";
		}else if (request.getMethod().equals("POST")){ //注册必须用POST请求
			if(user != null && user.getName() !=null && !user.getName().isEmpty()
					&& user.getPassword() != ""){  //.isEmpty()用于判断user内是否有元素
				
				if(registerService.selectByName(user.getName()) != null){
				       model.addAttribute("errorMessage", "您的用户名已经被注册");				
				}else{						
					registerService.insert(user);//向user表添加用户
					int id =registerService.selectByName(user.getName()).getId();//获得用户id
					registerService.insertUserRole(id);//为用户授予user角色
					
					System.out.println("用户名：" + user.getName());
					System.out.println("密码：" + user.getPassword());
					redirectAttributes.addFlashAttribute("succeedMessage", "账号注册成功");						
				    //return "redirect:/register";//跳转回自身，即刷新页面
					return "login";
				}					
				
			}else{
				model.addAttribute("errorMessage", "内容不能为空");
			}
			return "registerForm";						
		}                
		return "registerForm";	
	}	
}

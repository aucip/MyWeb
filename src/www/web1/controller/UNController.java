package www.web1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import www.web1.javaBean.User;
import www.web1.mapper.UserMapper;
import www.web1.service.impl.UserServiceImpl;

@Controller
@SessionAttributes("user")
public class UNController {
	@Autowired
	UserMapper um;
	
	@Autowired
	UserServiceImpl us;
	
	@PostMapping("login")
	public ModelAndView Login(@RequestParam("email")String email,
			@RequestParam("password")String password,
			Model model){
		ModelAndView mav = new ModelAndView();
		User user = us.checklogin(email, password);
		if(user != null){
			model.addAttribute("user", user);
			mav.setViewName("redirect:/ed-index");
		}else{
			mav.setViewName("login?message=0");
		}
		return mav;
	}
	
	@PostMapping("rigister")
	public String Rigister(User user){
		int i = us.register(user);
		if(i == 0 || i == 1){
			return "rigister";
		}else{
			return "login";
		}
	}
}

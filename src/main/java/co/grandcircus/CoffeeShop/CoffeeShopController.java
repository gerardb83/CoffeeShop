package co.grandcircus.CoffeeShop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeShopController {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("redirect:/index");
	}
	
	@RequestMapping("/index")
	public ModelAndView list() {
		List<Product> listOfProducts = productDao.findAll();
		return new ModelAndView("index", "products", listOfProducts);
	}
	
	@RequestMapping("/index/userForm")
	public ModelAndView addUser() {
		return new ModelAndView("userForm");
	}
	
	@PostMapping("/index/userForm")
	public ModelAndView addSubmit(User user) {
		userDao.create(user);
		return new ModelAndView("redirect:/index/userSubmitted");
	}
	
	@RequestMapping("/index/userSubmitted")
	public ModelAndView userDetail(@RequestParam("name") String name) {
		ModelAndView mv = new ModelAndView("/userSubmitted");
		mv.addObject("name", name);
		
		return mv;
	}
}
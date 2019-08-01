package co.grandcircus.CoffeeShop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeShopController {
	
	@Autowired
	UserDao userDao;
	@Autowired
	ProductDao productDao;
	
	@RequestMapping("/")
	public ModelAndView index(@SessionAttribute(name = "user", required = false) User user) {
		List<Product> listOfProducts = productDao.findAll();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("products", listOfProducts);
		if (user != null) {
			mv.addObject("name", user.getName());
		}
		return mv;
	}
	
	@RequestMapping("/userForm")
	public ModelAndView addUser() {
		return new ModelAndView("userForm");
	}
	
	@PostMapping("/userForm")
	public ModelAndView addSubmit(User user) {
		userDao.create(user);
		ModelAndView mv = new ModelAndView("userSubmitted");
		mv.addObject("name", user.getName());
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@PostMapping("/login")
	public ModelAndView loginSubmit(User formCredentials, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		List<User> listOfUsers = new ArrayList<>(userDao.findAll());
		String notFound = "User ID and/or password not recognized.";
		String id = formCredentials.getUserId();
		String password = formCredentials.getPassword();
		for (int i = 0; i < listOfUsers.size(); i++) {
			 if (id.equals(listOfUsers.get(i).getUserId()) && password.equals(listOfUsers.get(i).getPassword())) {
				session.setAttribute("user", listOfUsers.get(i));
				if(id.equals("admin") && password.equals("sesame")) {  
					mv = new ModelAndView("redirect:/adminIndex");
					break;
				} else {
				mv = new ModelAndView("redirect:/");
				break;
				}
			} else {
				mv = new ModelAndView("login", "notFound", notFound);
			}
		}
		return mv;
	}
	
	@RequestMapping("/adminIndex")
	public ModelAndView admin() {
		List<Product> listOfProducts = productDao.findAll();
		return new ModelAndView("adminIndex", "products", listOfProducts);
	}
	
	@RequestMapping("/productAdd")
	public ModelAndView addProduct() {
		return new ModelAndView("productForm");
	}
	
	@PostMapping("/productAdd")
	public ModelAndView createProduct(Product product) {
		productDao.create(product);
		return new ModelAndView("redirect:/adminIndex");
	}
	
	@RequestMapping("/productDelete")
	public ModelAndView deleteProduct(@RequestParam("id") int id) {
		productDao.delete(id);
		return new ModelAndView("redirect:/adminIndex");
	}
	
	@RequestMapping("/productEdit")
	public ModelAndView editForm(@RequestParam("id") int id) {
		ModelAndView mav = new ModelAndView("editForm");
		mav.addObject("product", productDao.findById(id));
		mav.addObject("title", "Edit Product");
		return mav;
	}
	
	@PostMapping("/productEdit")
	public ModelAndView submitEdit(Product product) {
		productDao.update(product);
		return new ModelAndView("redirect:/adminIndex");
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:/");
	}
}
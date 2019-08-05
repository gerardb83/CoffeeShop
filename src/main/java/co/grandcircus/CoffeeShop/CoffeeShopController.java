package co.grandcircus.CoffeeShop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	@Autowired
	CartDao cartDao;
	
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
		userDao.save(user);
		ModelAndView mv = new ModelAndView("userSubmitted");
		mv.addObject("name", user.getName());
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@PostMapping("/login")
	public ModelAndView loginSubmit(User userObject, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		List<User> listOfUsers = new ArrayList<>(userDao.findAll());
		String notFound = "User ID and/or password not recognized.";
		String id = userObject.getUserId();
		String password = userObject.getPassword();
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
	
	@RequestMapping("/addCart")
	public ModelAndView addCart(	
			@SessionAttribute(name="user") User user, @RequestParam("product") Integer productId) {
			Product product = productDao.getOne(productId);
			user = userDao.getOne(user.getId());			
			Cart cart = new Cart();
			cart.setProduct(product);
			cart.setQuantity(1);
			cart.setUser(user);
			cartDao.save(cart);		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/checkout")
	public ModelAndView checkout(
			@SessionAttribute(name="user") User user) {
		ModelAndView mv = new ModelAndView("checkout");
		List<Cart> bigCart = cartDao.findAll();
		List<Cart> userCart = new ArrayList<>();
		for (Cart each : bigCart) {
			if (each.getUser().getId() == user.getId()) {
				userCart.add(each);
			}
		}
		System.out.println("user cart: " + userCart);
		
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		for (Cart each : userCart) {
			if(each.getProduct().getId() == 1) {
				count1 += 1;
			} else if (each.getProduct().getId() == 2) {
				count2 += 1;
			} else if (each.getProduct().getId() == 3) {
				count3 += 1;
			} else if (each.getProduct().getId() == 4) {
				count4 += 1;
		}
		}
		double total1 = count1 * 1.25;
		double total2 = count2 * 1.50;
		double total3 = count3 * 14.0;
		double total4 = count4 * 1.75;
		
		mv.addObject("count1", count1);
		mv.addObject("count2", count2);
		mv.addObject("count3", count3);
		mv.addObject("count4", count4);
		mv.addObject("total1", total1);
		mv.addObject("total2", total2);
		mv.addObject("total3", total3);
		mv.addObject("total4", total4);
		
		return mv;
	}
			
	
	
	@RequestMapping("/adminIndex")
	public ModelAndView admin(
			@SessionAttribute(name="user", required=false) User user) {
		if (user == null || user.getId() != 8) { 
			return new ModelAndView("redirect:/");
		} else {
		List<Product> listOfProducts = productDao.findAll();
		return new ModelAndView("adminIndex", "products", listOfProducts);
		}
	}
	
	@RequestMapping("/productAdd")
	public ModelAndView addProduct(		
			@SessionAttribute(name="user", required=false) User user) {
		ModelAndView mv = new ModelAndView("productForm");
		if (user == null || user.getId() != 8) { 
			return new ModelAndView("redirect:/");
		} else {
			return mv;
		}
	}
	
	@PostMapping("/productAdd")
	public ModelAndView createProduct(Product product) {
		productDao.save(product);
		return new ModelAndView("redirect:/adminIndex");
	}
	
	@RequestMapping("/productDelete")
	public ModelAndView deleteProduct(@RequestParam("id") int id) {
		productDao.deleteById(id);
		return new ModelAndView("redirect:/adminIndex");
	}
	
	@RequestMapping("/productEdit")
	public ModelAndView editForm(	
			@RequestParam("id") int id,
			@SessionAttribute(name="user", required=false) User user) {
		ModelAndView mav = new ModelAndView("editForm");
		if (user == null || user.getId() != 8) { 
			return new ModelAndView("redirect:/");
		} else {
		mav.addObject("product", productDao.findById(id));
		mav.addObject("title", "Edit Product");
		return mav;
		}
	}
	
	@PostMapping("/productEdit")
	public ModelAndView submitEdit(Product product) {
		productDao.save(product);
		return new ModelAndView("redirect:/adminIndex");
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:/");
	}
}
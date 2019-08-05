package co.grandcircus.CoffeeShop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Cart {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cartId")
	private Long id;
	@ManyToOne
	private User user;
	@ManyToOne
	private Product product;
	private Integer quantity;

	public Cart() {
		super();	
}

	public Cart(Long id, User user, Product product, Integer quantity) {
		super();
		this.id = id;
		this.user = user;
		this.product = product;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", product=" + product + ", quantity=" + quantity + "]";
	}
	
	
}
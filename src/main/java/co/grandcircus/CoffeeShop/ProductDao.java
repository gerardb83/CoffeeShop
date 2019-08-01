package co.grandcircus.CoffeeShop;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProductDao {

	@PersistenceContext
	private EntityManager em;
	
	public List<Product> findAll() {
		return em.createQuery("FROM Product", Product.class).getResultList();
	}
	
	public Product findById(int id) {
		return em.find(Product.class, id);
	}
	
	public List<Product> findByCategory(String category) {
		return em.createQuery("FROM Product WHERE category = :category", Product.class)
				.setParameter("category", category)
				.getResultList();
	}
	
	public List<Product> findByKeyword(String keyword) {
		return em.createQuery("FROM Product WHERE LOWER(name) LIKE :regex", Product.class)
				.setParameter("regex", "%" + keyword.toLowerCase() + "%")
				.getResultList();
	}
	
	public void create(Product product) {
		em.persist(product);
	}
	
	public void update(Product product) {
		em.merge(product);
	}
	
	public void delete(int id) {
		Product product = em.getReference(Product.class, id);
		em.remove(product);
	}
	
	public Set<String> findAllCategories() {
		List<String> categoryList = em.createQuery("SELECT DISTINCT category FROM Product", String.class)
				.getResultList();
		return new TreeSet<>(categoryList);
	}
}

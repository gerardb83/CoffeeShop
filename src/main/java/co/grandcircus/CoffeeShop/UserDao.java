package co.grandcircus.CoffeeShop;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDao {


	@PersistenceContext
	private EntityManager em;
	
	public List<User> findAll() {
		return em.createQuery("FROM User", User.class).getResultList();
	}
	
	public User findById(int id) {
		return em.find(User.class, id);
	}	
	 
	public void create(User user) {
		em.persist(user);
	}
	
	public void update(User user) {
		em.merge(user);
	}
	
	public void delete(int id) {
		User user = em.getReference(User.class, id);
		em.remove(user);
	}
}

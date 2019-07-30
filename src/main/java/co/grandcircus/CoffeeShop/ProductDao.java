package co.grandcircus.CoffeeShop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Product> findAll() {
		// BeanPropertyRowMapper uses the rows from the SQL result create
		// new Room objects and fill in the values by calling the setters.
		// Use .query for SQL SELECT statements.
		return jdbcTemplate.query("SELECT * FROM Products", new BeanPropertyRowMapper<>(Product.class));
	}
}

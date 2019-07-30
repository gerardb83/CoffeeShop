package co.grandcircus.CoffeeShop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<User> findAll() {
		// BeanPropertyRowMapper uses the rows from the SQL result create
		// new Room objects and fill in the values by calling the setters.
		// Use .query for SQL SELECT statements.
		return jdbcTemplate.query("SELECT * FROM Products", new BeanPropertyRowMapper<>(User.class));
	}
	
	public User findById(int id) {
		// The last parameters of .query let us specify values for the (?) parameters in our SQL statement.
		// While .query returns a list, .queryForObject assumes only one result. 
		User match = jdbcTemplate.queryForObject("SELECT * FROM Users WHERE id = ?", new BeanPropertyRowMapper<>(User.class), id);
		// If nothing matched, match will be null.
		return match;
	}
	
	 
	public void create(User user) {
		String sql = "INSERT INTO Users (user_id, password, name) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, user.getUserId(), user.getPassword(), user.getName());
	}
}

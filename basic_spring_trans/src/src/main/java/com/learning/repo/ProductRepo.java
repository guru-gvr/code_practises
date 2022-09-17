package src.main.java.com.learning.repo;

import com.learning.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@Repository
public class ProductRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void saveProduct(Product product) {
        String sql = "Insert into product (id,name) VALUES(?,?)";
        Object[] args ={product.getId(),product.getName()};
        jdbcTemplate.update(sql,args);

    }
}

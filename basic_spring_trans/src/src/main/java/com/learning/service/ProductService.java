package src.main.java.com.learning.service;

import com.learning.domain.Product;
import com.learning.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    @Transactional(rollbackFor = Exception.class)
    public void saveProductInfo() {
        for (int i = 1; i <= 10; i++) {
            Product product = new Product(i, "Tech" + i);
            productRepo.saveProduct(product);
            if(i == 7){
                throw new RuntimeException("Hiii");
            }
            System.out.println("Product Saved");
        }

    }
}

package src.main.java.com.learning;

import com.learning.config.ProductConfig;
import com.learning.service.ProductService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class MainApplication {
    public static void main(String[] args) {
        try {
            ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ProductConfig.class);
            ProductService ps = context.getBean("productService", ProductService.class);
            ps.saveProductInfo();
            context.registerShutdownHook();
            context.close();
        }catch (Exception exception) {
            System.out.println("Exception occurred");
            exception.printStackTrace();
        }
    }
}

package com.example.sdjpaorderservice2.repositories;

import com.example.sdjpaorderservice2.domain.Category;
import com.example.sdjpaorderservice2.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("prod")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryPostgreSQLTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testObtainRecord() {
        Product fetchedRecord = productRepository.findByDescription("PRODUCT2").get();
        assertNotNull(fetchedRecord);
        assertTrue(fetchedRecord.getCategories().size() == 1);
        Category productCategory = fetchedRecord.getCategories().iterator().next();
        assertEquals("CAT1", productCategory.getDescription());

    }

    @Test
    public void testGetAllProducts() {
        List<Product> products = productRepository.findAll();
        assertNotNull(products);
        assertTrue(products.size() > 0);
        for (Product aProduct:products) {
            System.out.println("PRODUCT: \n" + aProduct.toString());
        }
    }
}

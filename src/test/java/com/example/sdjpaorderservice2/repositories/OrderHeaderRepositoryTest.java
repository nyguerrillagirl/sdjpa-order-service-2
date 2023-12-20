package com.example.sdjpaorderservice2.repositories;

import com.example.sdjpaorderservice2.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
class OrderHeaderRepositoryTest {
    @Autowired
    OrderHeaderRepository orderHeaderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    Product product;

    @BeforeEach
    void setUp() {
        Product newProduct = new Product();
        newProduct.setProductStatus(ProductStatus.NEW);
        newProduct.setDescription("test product");
        product = productRepository.saveAndFlush(newProduct);
    }
    @Test
    void testSaveOrder() {
        OrderHeader orderHeader = new OrderHeader();
        Customer aCustomer = new Customer();
        aCustomer.setCustomerName("Samantha Neill");
        aCustomer.setPhone("0123456789");

        Address address = new Address();
        address.setCity("012345678901234567890123456789");
        aCustomer.setAddress(address);

        Customer savedCustomer = customerRepository.save(aCustomer);

        orderHeader.setCustomer(savedCustomer);

        OrderHeader savedOrder = orderHeaderRepository.save(orderHeader);
        // test it was saved
        assertNotNull(savedOrder);
        assertNotNull(savedOrder.getId());
        // check by fetching
        OrderHeader fetchedOrder = orderHeaderRepository.getReferenceById(savedOrder.getId());
        assertNotNull(fetchedOrder);
        assertEquals("Samantha Neill", fetchedOrder.getCustomer().getCustomerName());
        assertNotNull(fetchedOrder.getCreatedDate());
        assertNotNull(fetchedOrder.getLastModifiedDate());
    }

    @Test
    void testDeleteCascade() {
        OrderHeader orderHeader = new OrderHeader();
        Customer customer = new Customer();
        customer.setCustomerName("Sam Spade");
        orderHeader.setCustomer(customerRepository.save(customer)); // note how we save the customer first

        OrderLine orderLine = new OrderLine();
        orderLine.setQuantityOrdered(3);
        orderLine.setProduct(product);  // note: how we use the product

        orderHeader.addOrderLine(orderLine);

        // Set up an orderApproval for this Order
        OrderApproval orderApproval = new OrderApproval();
        orderApproval.setApprovedBy("me");
        orderHeader.setOrderApproval(orderApproval);

        OrderHeader savedOrder = orderHeaderRepository.saveAndFlush(orderHeader);

        System.out.println("order saved and flushed.");
        orderHeaderRepository.deleteById(savedOrder.getId());
        orderHeaderRepository.flush();

        Optional<OrderHeader> optFetchedOrder = orderHeaderRepository.findById(savedOrder.getId());
        assertFalse(optFetchedOrder.isPresent());

    }
    @Test
    void testSaveOrderWithLine() {
        Customer aCustomer = new Customer();
        aCustomer.setCustomerName("Samantha Neill");
        Customer savedCustomer = customerRepository.save(aCustomer);

        OrderHeader orderHeader = new OrderHeader();
        orderHeader.setCustomer(savedCustomer);


        OrderLine orderLine = new OrderLine();
        orderLine.setQuantityOrdered(5);
        orderLine.setProduct(product);

        orderHeader.addOrderLine(orderLine);

        OrderApproval orderApproval = new OrderApproval();
        orderApproval.setApprovedBy("me");
        //OrderApproval savedApproval = orderApprovalRepository.save(orderApproval);

        orderHeader.setOrderApproval(orderApproval);

        OrderHeader savedOrder = orderHeaderRepository.save(orderHeader);

        // test it was saved
        assertNotNull(savedOrder);
        assertNotNull(savedOrder.getId());
        assertNotNull(savedOrder.getOrderLines());
        assertEquals(savedOrder.getOrderLines().size(), 1);

        // Let's fetch the saved order
        OrderHeader fetchedOrder = orderHeaderRepository.getReferenceById(savedOrder.getId());
        // Let's check that order_line exists
        assertTrue(fetchedOrder.getOrderLines().size() > 0);
    }

}
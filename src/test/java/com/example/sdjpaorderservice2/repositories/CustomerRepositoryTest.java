package com.example.sdjpaorderservice2.repositories;

import com.example.sdjpaorderservice2.domain.Address;
import com.example.sdjpaorderservice2.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testAddingCustomer() {
        Customer newCustomer = new Customer();
        newCustomer.setCustomerName("figgy");

        Customer savedCustomer = customerRepository.save(newCustomer);
        assertNotNull(savedCustomer);

        // retrieve the customer
        Customer fetchedCustomer = customerRepository.findById(savedCustomer.getId()).get();
        assertNotNull(fetchedCustomer);
        assertEquals("figgy", fetchedCustomer.getCustomerName());
    }

    @Test
    public void testFindCustomerByCustomerNameContainingIgnoreCase() {
        Customer newCustomer = new Customer();
        newCustomer.setCustomerName("figgy");
        Address address = new Address();
        address.setAddress("1010 Mockingbird Lane");
        address.setCity("Addams Township");
        address.setState("PA");
        address.setZipCode("55555");
        newCustomer.setAddress(address);

        Customer savedCustomer = customerRepository.save(newCustomer);
        assertNotNull(savedCustomer);

        Customer fetchedCustomer = customerRepository.findCustomerByCustomerNameContainingIgnoreCase("FIGGY").get();
        assertNotNull(fetchedCustomer);
        assertEquals("figgy", fetchedCustomer.getCustomerName());
        System.out.println("===>\n" + fetchedCustomer.toString());


    }

}
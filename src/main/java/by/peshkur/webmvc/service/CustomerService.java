package by.peshkur.webmvc.service;

import by.peshkur.webmvc.entity.Customer;
import by.peshkur.webmvc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void create(Customer customer) {
        customerRepository.saveAndFlush(customer);
    }

    public void delete(UUID uuid) {
        customerRepository.deleteById(uuid);
    }

}

package by.peshkur.webmvc.service;

import by.peshkur.webmvc.entity.Customer;
import by.peshkur.webmvc.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    CustomerRepository customerRepository;



    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}

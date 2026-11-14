package org.example.thuc_hanh.service;


import org.example.thuc_hanh.entity.Customer;
import org.example.thuc_hanh.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HibernateCustomerService implements ICustomerService{
    private final ICustomerRepository customerRepository;

    public HibernateCustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        customerRepository.remove(id);
    }
}

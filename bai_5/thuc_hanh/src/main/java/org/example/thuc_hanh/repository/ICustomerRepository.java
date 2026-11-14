package org.example.thuc_hanh.repository;

import org.example.thuc_hanh.entity.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void remove(int id);
}

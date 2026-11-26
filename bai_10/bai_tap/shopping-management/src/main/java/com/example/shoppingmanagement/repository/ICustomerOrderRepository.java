package com.example.shoppingmanagement.repository;

import com.example.shoppingmanagement.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerOrderRepository extends JpaRepository<CustomerOrder,Long> {
}

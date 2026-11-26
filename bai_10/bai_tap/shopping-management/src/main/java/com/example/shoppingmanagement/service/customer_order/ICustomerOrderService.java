package com.example.shoppingmanagement.service.customer_order;

import com.example.shoppingmanagement.dto.CustomerOrderDto;
import com.example.shoppingmanagement.entity.Cart;

public interface ICustomerOrderService {
    boolean createOrder(CustomerOrderDto customerOrderDto, Cart cart);
}

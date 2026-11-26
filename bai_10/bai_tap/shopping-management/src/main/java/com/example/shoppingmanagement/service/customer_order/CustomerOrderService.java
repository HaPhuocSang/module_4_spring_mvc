package com.example.shoppingmanagement.service.customer_order;

import com.example.shoppingmanagement.converter.ProductDtoToProductConverter;
import com.example.shoppingmanagement.dto.CustomerOrderDto;
import com.example.shoppingmanagement.dto.ProductDto;
import com.example.shoppingmanagement.entity.Cart;
import com.example.shoppingmanagement.entity.CustomerOrder;
import com.example.shoppingmanagement.entity.OrderItem;
import com.example.shoppingmanagement.entity.Product;
import com.example.shoppingmanagement.repository.ICustomerOrderRepository;
import com.example.shoppingmanagement.repository.IOrderItemRepository;
import com.example.shoppingmanagement.repository.IProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CustomerOrderService implements ICustomerOrderService {
    private final ICustomerOrderRepository customerOrderRepository;
    private final IOrderItemRepository orderItemRepository;
    private final IProductRepository productRepository;

    public CustomerOrderService(ICustomerOrderRepository customerOrderRepository, IOrderItemRepository orderItemRepository, IProductRepository productRepository) {
        this.customerOrderRepository = customerOrderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public boolean createOrder(CustomerOrderDto customerOrderDto, Cart cart) {
        if(cart == null || cart.getProductDtoMap().isEmpty()){
            return false;
        }
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setReceiverName(customerOrderDto.getReceiverName());
        customerOrder.setPhone(customerOrderDto.getPhone());
        customerOrder.setAddress(customerOrderDto.getAddress());
        customerOrder.setPaymentMethod(customerOrderDto.getPaymentMethod());
        customerOrder.setStatus("PENDING");
        customerOrderRepository.save(customerOrder);
        for(Map.Entry<ProductDto, Integer> entry : cart.getProductDtoMap().entrySet()){
            Long productId = entry.getKey().getId();
            String productName = entry.getKey().getName();
            Integer quantity = entry.getValue();
            if (quantity == null || quantity <= 0) {
                throw new IllegalArgumentException("Số lượng sản phẩm không hợp lệ!");
            }
            Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalStateException("Không tìm thấy sản phẩm: " + productName));
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(quantity);
            orderItem.setPrice(product.getPrice());
            orderItem.setCustomerOrder(customerOrder);
            orderItemRepository.save(orderItem);
        }
        return true;
    }
}

package com.example.medly_pharma.medly_pharma_web_springboot.Service;

import com.example.medly_pharma.medly_pharma_web_springboot.Modal.Medicine;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface OrderService {
    void addItemToCart(Medicine product);
    void removeItemFromCart(Medicine product);
    double getTotalCost();

    // You can add more methods like getOrderHistoryForUser, cancelOrder, etc.
}

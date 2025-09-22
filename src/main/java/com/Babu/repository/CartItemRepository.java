package com.Babu.repository;

import com.Babu.model.Cart;
import com.Babu.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {


}

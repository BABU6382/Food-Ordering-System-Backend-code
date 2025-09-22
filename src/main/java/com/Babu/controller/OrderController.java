package com.Babu.controller;

import com.Babu.model.CartItem;
import com.Babu.model.Order;
import com.Babu.model.User;
import com.Babu.request.AddCartItemRequest;
import com.Babu.request.OrderRequest;
import com.Babu.response.PaymentResponse;
import com.Babu.service.OrderService;
import com.Babu.service.PaymentService;
import com.Babu.service.UserService;
import org.apache.tomcat.Jar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/order")
    public ResponseEntity<PaymentResponse> createOrder(
            @RequestBody OrderRequest req,
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        Order order = orderService.createOrder(req,user);

        PaymentResponse res = paymentService.createPaymentLink(order);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getOrderHistory(
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        List<Order> orders = orderService.getUserOrder(user.getId());

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}

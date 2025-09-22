package com.Babu.service;

import com.Babu.model.Order;
import com.Babu.response.PaymentResponse;
import com.stripe.exception.StripeException;

public interface PaymentService {

    public PaymentResponse createPaymentLink(Order order) throws StripeException;
}

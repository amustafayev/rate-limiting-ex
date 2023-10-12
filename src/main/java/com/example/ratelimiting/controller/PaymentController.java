package com.example.ratelimiting.controller;

import com.example.ratelimiting.model.PaymentDto;
import com.example.ratelimiting.model.StatementRequestDto;
import com.example.ratelimiting.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;


    @GetMapping("/{id}")
    public PaymentDto fetchData(@PathVariable Long id) {
        return paymentService.fetchData(id);
    }

    @GetMapping("/statements")
    public List<PaymentDto> createPayment(@RequestBody StatementRequestDto requestDto) {
        return paymentService.fetchStatements(requestDto);
    }
}

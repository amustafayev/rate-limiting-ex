package com.example.ratelimiting.service;

import com.example.ratelimiting.model.PaymentDto;
import com.example.ratelimiting.model.StatementRequestDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaymentService {
    public PaymentDto fetchData(Long id) {
        return new PaymentDto(id,4.5,"Test descr");
    }

    public List<PaymentDto> fetchStatements(StatementRequestDto requestDto) {

        System.out.println("Fetch data from " + requestDto.getFrom() + " to " + requestDto.getTo());

        //Fetched data from db
        return Arrays.asList(
                new PaymentDto(1L,4.5,"Test descr"),
                new PaymentDto(3L,4.5,"Test descr2"),
                new PaymentDto(2L,4.5,"Test descr3"),
                new PaymentDto(5L,4.5,"Test descr4")
        );
    }
}

package com.example.ratelimiting.service;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import io.github.bucket4j.Refill;

import java.time.Duration;

public class RateLimitingEx {

    public static void main(String[] args) {


        Refill refill = Refill.intervally(10,
                Duration.ofMinutes(1)
        );

        Bandwidth limit = Bandwidth.classic(10,
                refill);


        Bucket bucket = Bucket.builder()
                .addLimit(limit)
                .build();

        for (int i = 1; i <= 10; i++) {
            bucket.tryConsume(1); // true
        }
        bucket.tryConsume(1); // false


        ConsumptionProbe consumptionProbe = bucket
                .tryConsumeAndReturnRemaining(1);

        if (consumptionProbe.isConsumed()) {
            // There is still token remaining in bucket
        }

    }
}

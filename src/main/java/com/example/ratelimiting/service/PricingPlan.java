package com.example.ratelimiting.service;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Refill;

import java.time.Duration;

public enum PricingPlan {
    FREE(2),

    BASIC(5),

    PROFESSIONAL(10);

    private int bucketCapacity;

    PricingPlan(int bucketCapacity) {
        this.bucketCapacity = bucketCapacity;
    }

    Bandwidth getLimit() {
        return Bandwidth
                .classic(bucketCapacity,
                        Refill.intervally(bucketCapacity, Duration.ofMinutes(1))
                );
    }

    public int bucketCapacity() {
        return bucketCapacity;
    }

    static PricingPlan resolvePlanFromApiKey(String apiKey) {
        if (apiKey == null || apiKey.isEmpty()) {
            return FREE;

        } else if (apiKey.startsWith("PX001-")) {
            return PROFESSIONAL;

        } else if (apiKey.startsWith("BX001-")) {
            return BASIC;
        }
        return FREE;
    }

}

package com.example.cart.integration;

import com.example.cart.dto.QuoteStatusRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "integration-hub",
        // default to localhost if property not set
        url = "${integration.hub.url:http://localhost:8081}"
)
public interface IntegrationClient {

    @PostMapping("/integration/mybusiness/quote-status")
    void updateQuoteStatus(@RequestBody QuoteStatusRequest request);
}

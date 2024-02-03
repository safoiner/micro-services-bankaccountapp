package com.adib.accountservice.clients;

import com.adib.accountservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping("/api/customers/{id}")
    @CircuitBreaker(name = "cusomerService", fallbackMethod = "getDefaultCustomer" )
    Customer findCustomerByid(@PathVariable Long id);
    @GetMapping("/api/customers")
    @CircuitBreaker(name ="customerService", fallbackMethod = "getAllCustomers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id){
        Customer customer = new Customer();
        return customer;
    }

    default List<Customer> getAllCustomers(Exception exception){
        return List.of();
    }
}

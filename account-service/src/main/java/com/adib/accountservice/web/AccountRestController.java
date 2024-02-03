package com.adib.accountservice.web;

import com.adib.accountservice.clients.CustomerRestClient;
import com.adib.accountservice.entities.BankAccount;
import com.adib.accountservice.model.Customer;
import com.adib.accountservice.reposiotry.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private BankAccountRepository accountRepository;
    private CustomerRestClient customerRestClient;

    public AccountRestController(BankAccountRepository accountRepository, CustomerRestClient customerRestClient) {
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }
    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
     return accountRepository.findAll();

    }
    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountByid(@PathVariable String id){

        BankAccount bankAccount = accountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerByid(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}

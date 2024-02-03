package com.adib.accountservice.entities;

import com.adib.accountservice.enums.AccountType;
import com.adib.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class BankAccount {
    @Id
    private String accountId;
    private  double balance;
     private LocalDate createAt;
     private String currency;
     @Enumerated(EnumType.ORDINAL)
     private AccountType type;
     @Transient
     private Customer customer;
     private Long customerId;


}

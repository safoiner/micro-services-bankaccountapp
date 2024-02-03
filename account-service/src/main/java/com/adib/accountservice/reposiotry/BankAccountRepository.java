package com.adib.accountservice.reposiotry;

import com.adib.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository <BankAccount, String> {

}

package com.adib.accountservice;

import com.adib.accountservice.entities.BankAccount;
import com.adib.accountservice.enums.AccountType;
import com.adib.accountservice.reposiotry.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static final CommandLineRunner COMMAND_LINE_RUNNER = args -> {
    };

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository){
        return args -> {

            BankAccount bankAccount1 = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .balance(900090)
                    .currency("MAD")
                    .createAt(LocalDate.now())
                    .customerId(Long.valueOf(1))
                    .type(AccountType.SAVING_ACCOUNT)
                    .build();

            BankAccount bankAccount2 = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .balance(900090)
                    .currency("MAD")
                    .createAt(LocalDate.now())
                    .customerId(Long.valueOf(1))
                    .type(AccountType.SAVING_ACCOUNT)
                    .build();

            BankAccount bankAccount3 = BankAccount.builder()
                    .accountId(UUID.randomUUID().toString())
                    .balance(900090)
                    .currency("MAD")
                    .createAt(LocalDate.now())
                    .type(AccountType.SAVING_ACCOUNT)
                    .customerId(Long.valueOf(1))
                    .build();
            bankAccountRepository.save(bankAccount1);
            bankAccountRepository.save(bankAccount2);
            bankAccountRepository.save(bankAccount3);


        };
    }


}

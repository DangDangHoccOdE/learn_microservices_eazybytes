package com.eazybytes.accounts.functions;

import com.eazybytes.accounts.service.impll.AccountsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class AccountsFunction {
    private static final Logger log = LoggerFactory.getLogger(AccountsFunction.class);

    // Dữ liệu từ HTTP request body sẽ được chuyển đổi sang kiểu dữ liệu mà Consumer nhận,
    @Bean
    public Consumer<Long> updateCommunication(AccountsServiceImpl accountsService) {
        return accountNumber -> {
            log.info("Updating Communication status for the account number: "+accountNumber);
            accountsService.updateCommunicationStatus(accountNumber);
        };
    }
}

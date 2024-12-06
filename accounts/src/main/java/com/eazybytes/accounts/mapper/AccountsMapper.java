package com.eazybytes.accounts.mapper;

import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.entity.Accounts;

public class AccountsMapper {
    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto){
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        accountsDto.setAccountNumber(accounts.getAccountNumber());

        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto,Accounts accounts){
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        return accounts;
    }
}

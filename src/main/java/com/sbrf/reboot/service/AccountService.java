package com.sbrf.reboot.service;

import com.sbrf.reboot.repository.AccountRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class AccountService {
    @NonNull
    AccountRepository accountRepository;

    public boolean isClientHasContract(long clientId, long contractNumber) {
        return accountRepository.getAllAccountsByClientId(clientId).contains(contractNumber);
    }

    public boolean isClientIdHasAccount(long clientId, long account) {
        return accountRepository.getAccountByClientId(clientId).equals(account);
    }


}

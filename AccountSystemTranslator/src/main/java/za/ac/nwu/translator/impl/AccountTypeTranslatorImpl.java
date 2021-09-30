package za.ac.nwu.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;
import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.domain.persistence.AccountType;
import za.ac.nwu.repo.persistence.AccountTypeRepository;
import za.ac.nwu.translator.AccountTypeTranslator;

import java.util.ArrayList;
import java.util.List;


@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {

    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {

        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try {
            for (AccountType accountType : accountTypeRepository.findAll()) {
                accountTypeDtos.add(new AccountTypeDto(accountType));
            }
        } catch (Exception e) {
            // TODO: Log
            throw new RuntimeException("Unable to read from database", e);
        }
        return accountTypeDtos;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto) {

        try {
            AccountType accountType = accountTypeRepository.save(accountTypeDto.getAccountType());
            return new AccountTypeDto(accountType);

        } catch (Exception e) {
            throw new RuntimeException("Unable to read from database", e);
        }

    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic) {
        try {
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonicNativeQuery(mnemonic);
            return new AccountTypeDto(accountType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the database", e);
        }
    }

        @Override
        public AccountTypeDto getAccountTypeByMnemonic (String mnemonic) {
            try {
                AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
                return new AccountTypeDto(accountType);
            } catch (Exception e) {
                throw new RuntimeException("Unable to read from the database", e);
            }
        }
            @Override
            public AccountTypeDto getAccountTypeDtoByMnemonic (String mnemonic){
                try {
                    AccountTypeDto accountType = accountTypeRepository.getAccountTypeDtoByMnemonic(mnemonic);
                    return new AccountTypeDto(accountType);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to read from the database", e);
                }
            }

    @Override
    public void someMethod() {

    }
}


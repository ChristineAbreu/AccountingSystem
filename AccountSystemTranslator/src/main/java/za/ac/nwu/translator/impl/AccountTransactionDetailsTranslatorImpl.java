package za.ac.nwu.translator.impl;

import za.ac.nwu.domain.persistence.AccountTransactionDetails;
import za.ac.nwu.repo.persistence.AccountTransactionDetailsRepository;
import za.ac.nwu.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.translator.AccountTransactionDetailsTranslator;

public class AccountTransactionDetailsTranslatorImpl implements AccountTransactionDetailsTranslator {
    private AccountTransactionDetailsRepository repo;

    public AccountTransactionDetailsTranslatorImpl(AccountTransactionDetailsRepository accountTransactionDetailsRepository) {

        this.repo = accountTransactionDetailsRepository;
    }

    @Override
    public AccountTransactionDetails save(AccountTransactionDetails accountTransactionDetails) {
        try {
            return repo.save(accountTransactionDetails);

        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}

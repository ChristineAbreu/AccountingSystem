package za.ac.nwu.translator.impl;

import za.ac.nwu.domain.persistence.AccountTransaction;

import java.util.List;

public interface AccountTransactionTranslator {
    AccountTransaction save(AccountTransaction accountTransaction);


    AccountTransaction getAccountTransactionByPk(Long transactionId);
    List<AccountTransaction> getAllAccountTransactions();
}

package za.ac.nwu.translator;

import za.ac.nwu.domain.persistence.AccountTransaction;

public interface AccountTransactionTranslator {
    AccountTransaction[] getAllAccountTransactions();

    AccountTransaction getAccountTransactionByPk(Long transactionId);
}

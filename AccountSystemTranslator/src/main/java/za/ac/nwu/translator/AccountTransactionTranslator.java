package za.ac.nwu.translator;

import za.ac.nwu.domain.persistence.AccountTransaction;

import java.util.List;

public interface AccountTransactionTranslator {

    AccountTransaction save(AccountTransaction accountTransaction);

    List<AccountTransaction> getAllAccountTransactions();

    AccountTransaction getAccountTransactionByPk(Long transactionId);
}

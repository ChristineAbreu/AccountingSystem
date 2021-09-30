package za.ac.nwu.translator;

import za.ac.nwu.domain.persistence.AccountTransactionDetails;

public interface AccountTransactionDetailsTranslator {
    AccountTransactionDetails save(AccountTransactionDetails accountTransactionDetails);
}

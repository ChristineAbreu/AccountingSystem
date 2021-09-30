package za.ac.nwu.repo.persistence;

import za.ac.nwu.domain.persistence.AccountTransactionDetails;

public interface AccountTransactionDetailsRepository {
    AccountTransactionDetails save(AccountTransactionDetails accountTransactionDetails);
}

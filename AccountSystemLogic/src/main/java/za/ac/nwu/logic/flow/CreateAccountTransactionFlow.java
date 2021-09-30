package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.AccountTransactionDto;

public interface CreateAccountTransactionFlow {
    AccountTransactionDto create(AccountTransactionDto accountTransaction);
}

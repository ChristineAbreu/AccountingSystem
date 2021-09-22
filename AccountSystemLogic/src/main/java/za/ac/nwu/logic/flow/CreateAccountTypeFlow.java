package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.AccountTypeDto;

public interface CreateAccountTypeFlow {
    default AccountTypeDto create() {
        return create();
    }

    AccountTypeDto create(AccountTypeDto accountType);
}

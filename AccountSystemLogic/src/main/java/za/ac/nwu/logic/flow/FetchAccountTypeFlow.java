package za.ac.nwu.logic.flow;





import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.domain.persistence.AccountType;

import java.util.List;

public interface FetchAccountTypeFlow {
List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    AccountType getAccountTypeDbEntityByMnemonic(Object accountTypeMnemonic);
}

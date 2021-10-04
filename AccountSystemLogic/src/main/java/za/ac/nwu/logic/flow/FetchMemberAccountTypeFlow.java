package za.ac.nwu.logic.flow;





import za.ac.nwu.domain.dto.MemberAccountTypeDto;
import za.ac.nwu.domain.persistence.MemberAccountType;

import java.util.List;

public interface FetchMemberAccountTypeFlow {
List<MemberAccountTypeDto> getAllAccountTypes();

    MemberAccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    MemberAccountType getAccountTypeDbEntityByMnemonic(Object accountTypeMnemonic);
}

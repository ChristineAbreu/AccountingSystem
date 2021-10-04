package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.MemberAccountTypeDto;

import java.time.LocalDate;

public interface ModifyMemberAccountTypeFlow {
    MemberAccountTypeDto deleteAccountType(String mnemonic);

    MemberAccountTypeDto updateAccountType(String mnemonic, String newAccountTypeName, LocalDate newCreationDate);
}

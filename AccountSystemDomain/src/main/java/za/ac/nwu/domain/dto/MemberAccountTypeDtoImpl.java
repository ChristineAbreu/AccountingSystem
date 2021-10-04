package za.ac.nwu.domain.dto;

import java.time.LocalDate;

public class MemberAccountTypeDtoImpl extends MemberAccountTypeDto {
    public MemberAccountTypeDtoImpl(String mnemonic, String accountTypeName, LocalDate creationDate) {
        super(mnemonic, accountTypeName, creationDate);
    }
}

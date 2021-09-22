package za.ac.nwu.domain.dto;

import java.time.LocalDate;

public class AccountTypeDtoImpl extends AccountTypeDto {
    public AccountTypeDtoImpl(String mnemonic, String accountTypeName, LocalDate creationDate) {
        super(mnemonic, accountTypeName, creationDate);
    }
}

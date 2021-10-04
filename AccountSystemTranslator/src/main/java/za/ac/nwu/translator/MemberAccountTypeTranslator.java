package za.ac.nwu.translator;

import za.ac.nwu.domain.dto.MemberAccountTypeDto;

import java.util.List;

public interface MemberAccountTypeTranslator {
    List<MemberAccountTypeDto> getAllAccountTypes();

    MemberAccountTypeDto create(MemberAccountTypeDto accountType);

    MemberAccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic);
    MemberAccountTypeDto getAccountTypeByMnemonic(String mnemonic);
    MemberAccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);

    void someMethod();

}

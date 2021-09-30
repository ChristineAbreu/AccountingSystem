package za.ac.nwu.logic.flow.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.domain.persistence.AccountType;
import za.ac.nwu.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component

public class FetchAccountTypeImpl implements FetchAccountTypeFlow {
    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired


    public FetchAccountTypeImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
    return accountTypeTranslator.getAllAccountTypes();
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic) {
        return accountTypeTranslator.getAccountTypeByMnemonicNativeQuery(mnemonic);
    }

    @Override
    public AccountType getAccountTypeDbEntityByMnemonic(Object accountTypeMnemonic) {
        return null;
    }

    public boolean methodToTest(){
        return true;
    }
//    @Override
//    public List<AccountTypeDto> getAllAccountTypes(){
//        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
//        accountTypeDtos.add(new AccountTypeDto("MILES","Miles", LocalDate.now()));
//        return accountTypeDtos;
//    }
}

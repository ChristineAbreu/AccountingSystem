package za.ac.nwu.logic.flow.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.MemberAccountTypeDto;
import za.ac.nwu.domain.persistence.Member;
import za.ac.nwu.logic.flow.FetchMemberAccountTypeFlow;
import za.ac.nwu.translator.MemberAccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component

public class FetchMemberAccountTypeImpl implements FetchMemberAccountTypeFlow {
    private final MemberAccountTypeTranslator memberAccountTypeTranslator;

    @Autowired


    public FetchMemberAccountTypeImpl(MemberAccountTypeTranslator memberAccountTypeTranslator) {
        this.memberAccountTypeTranslator = memberAccountTypeTranslator;
    }

    @Override
    public List<MemberAccountTypeDto> getAllAccountTypes() {
    return memberAccountTypeTranslator.getAllAccountTypes();
    }

    @Override
    public MemberAccountTypeDto getAccountTypeByMnemonic(String mnemonic) {
        return memberAccountTypeTranslator.getAccountTypeByMnemonicNativeQuery(mnemonic);
    }

    @Override
    public Member getAccountTypeDbEntityByMnemonic(Object accountTypeMnemonic) {
        return null;
    }

   public boolean methodToTest(){
        return true;
    }
//   @Override
//   public List<MemberAccountTypeDto> getAllAccountTypes(){
//        List<MemberAccountTypeDto> accountTypeDtos = new ArrayList<>();
//       accountTypeDtos.add(new MemberAccountTypeDto("MILES","Miles", LocalDate.now()));
//       return accountTypeDtos;
//  }
}

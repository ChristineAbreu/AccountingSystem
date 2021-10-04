package za.ac.nwu.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.MemberAccountTypeDto;

import za.ac.nwu.logic.flow.CreateMemberAccountTypeFlow;
import za.ac.nwu.translator.MemberAccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateMemberAccountTypeFlowImpl implements CreateMemberAccountTypeFlow {
    private final MemberAccountTypeTranslator memberAccountTypeTranslator;

    public CreateMemberAccountTypeFlowImpl(MemberAccountTypeTranslator memberAccountTypeTranslator) {
        this.memberAccountTypeTranslator = memberAccountTypeTranslator;

    }

    @Override
    public MemberAccountTypeDto create(MemberAccountTypeDto accountType) {
if(null == accountType.getCreationDate()){
    accountType.setCreationDate(LocalDate.now());
}
MemberAccountTypeDto memberAccountTypeDto = memberAccountTypeTranslator.create(accountType);
return memberAccountTypeTranslator.create(memberAccountTypeDto);
    }


}





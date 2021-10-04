package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.MemberAccountTypeDto;

public interface CreateMemberAccountTypeFlow {
    default MemberAccountTypeDto create() {
        return create();
    }

    MemberAccountTypeDto create(MemberAccountTypeDto accountType);
}

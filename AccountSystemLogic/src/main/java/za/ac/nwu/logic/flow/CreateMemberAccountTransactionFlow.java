package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.MemberAccountTransactionDto;

public interface CreateMemberAccountTransactionFlow {
    MemberAccountTransactionDto create(MemberAccountTransactionDto accountTransaction);
}

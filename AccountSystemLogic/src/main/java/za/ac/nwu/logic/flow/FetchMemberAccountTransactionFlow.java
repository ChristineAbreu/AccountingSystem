package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.MemberAccountTransactionDto;

import java.util.List;

public interface FetchMemberAccountTransactionFlow {
    List<MemberAccountTransactionDto> getAllAccountTransactions();

    MemberAccountTransactionDto getAccountTransactionById(Long transactionId);
}

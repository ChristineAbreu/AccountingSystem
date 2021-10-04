package za.ac.nwu.repo.persistence;

import za.ac.nwu.domain.persistence.MemberAccountTransactionDetails;

public interface MemberAccountTransactionDetailsRepository {
    MemberAccountTransactionDetails save(MemberAccountTransactionDetails memberAccountTransactionDetails);
}

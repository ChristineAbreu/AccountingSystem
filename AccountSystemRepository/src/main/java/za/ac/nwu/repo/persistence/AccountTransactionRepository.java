package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.persistence.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
    AccountTransaction findByTransactionDate(Long transactionDate);
    AccountTransaction findByAmount(Long amount);
    AccountTransaction findByMemberId(Long memberId);
    AccountTransaction findByAccountType(Long accountType);
    AccountTransaction findByTransactionId(Long transactionId);
}
package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.persistence.MemberAccountTransaction;

import java.time.LocalDate;

@Repository
public interface MemberAccountTransactionRepository extends JpaRepository<MemberAccountTransaction, Long> {
    MemberAccountTransaction findByTransactionDate(LocalDate transactionDate);
    MemberAccountTransaction findByAmount(Long amount);
    MemberAccountTransaction findByMemberId(Long memberId);
    MemberAccountTransaction findByAccountType(Long accountType);
    MemberAccountTransaction findByTransactionId(Long transactionId);

}
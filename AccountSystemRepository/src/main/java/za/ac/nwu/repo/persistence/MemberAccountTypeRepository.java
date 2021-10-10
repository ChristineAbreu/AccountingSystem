package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.dto.MemberAccountTypeDto;
import za.ac.nwu.domain.persistence.Member;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface MemberAccountTypeRepository extends JpaRepository<Member, Long> {
    @Query(value = "SELECT"+
    "ACCOUNT_TYPE_ID,"+
    "ACCOUNT_TYPE_NAME,"+
   "CREATION_DATE,"+
    "MNEMONIC"+
    "FROM"+ "CHRISTINE_ACCOUNT_TYPE"+
    "WHERE MNEMONIC = :mnemonic", nativeQuery = true)
    Member getAccountTypeByMnemonicNativeQuery(String mnemonic);
//native queries is not recommended
    @Query(value = "SELECT"+
            "at"+
            "FROM"+
            "Member at"+
            "MNEMONIC"+
            "WHERE MNEMONIC = :mnemonic")
    Member getAccountTypeByMnemonic(String mnemonic);

    @Query(value = "SELECT new za.ac.nwu.domain.dto.MemberAccountTypeDto("+
            "at.mnemonic,"+
            "at.accountTypeName,"+
            "at.creationDate"+
            "FROM"+
            "Member at"+
    "WHERE at. mnemonic =: mnemonic")
    MemberAccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);

    Member findByCreationDate(LocalDate creationDate);
    Member findByAccountTypeName(String accountTypeName);
    Member findByMnemonic(String mnemonic);
    Member findByAccountTypeId(Long accountTypeId);
    @Override
    Optional<Member> findById(Long aLong);

}

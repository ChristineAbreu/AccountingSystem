package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.dto.MemberAccountTypeDto;
import za.ac.nwu.domain.persistence.MemberAccountType;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface MemberAccountTypeRepository extends JpaRepository<MemberAccountType, Long> {
    @Query(value = "SELECT"+
    "ACCOUNT_TYPE_ID,"+
    "ACCOUNT_TYPE_NAME,"+
   "CREATION_DATE,"+
    "MNEMONIC"+
    "FROM"+ "VITRSA_SANDBOX_ACCOUNT_TYPE"+
    "WHERE MNEMONIC = :mnemonic", nativeQuery = true)
    MemberAccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);
//native queries is not recommended
    @Query(value = "SELECT"+
            "at"+
            "FROM"+
            "MemberAccountType at"+
            "MNEMONIC"+
            "WHERE MNEMONIC = :mnemonic")
    MemberAccountType getAccountTypeByMnemonic(String mnemonic);

    @Query(value = "SELECT new za.ac.nwu.domain.dto.MemberAccountTypeDto("+
            "at.mnemonic,"+
            "at.accountTypeName,"+
            "at.creationDate"+
            "FROM"+
            "MemberAccountType at"+
    "WHERE at. mnemonic =: mnemonic")
    MemberAccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);

    MemberAccountType findByCreationDate(LocalDate creationDate);
    MemberAccountType findByAccountTypeName(String accountTypeName);
    MemberAccountType findByMnemonic(String mnemonic);
    MemberAccountType findByAccountTypeId(Long accountTypeId);
    @Override
    Optional<MemberAccountType> findById(Long aLong);

}

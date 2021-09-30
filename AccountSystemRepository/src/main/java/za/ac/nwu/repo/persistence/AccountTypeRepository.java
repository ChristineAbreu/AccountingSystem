package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.persistence.AccountType;
import org.springframework.data.jpa.repository.Query;
import za.ac.nwu.domain.dto.AccountTypeDto;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {
    @Query(value = "SELECT"+
    "ACCOUNT_TYPE_ID,"+
    "ACCOUNT_TYPE_NAME,"+
   "CREATION_DATE,"+
    "MNEMONIC"+
    "FROM"+ "VITRSA_SANDBOX_DEMO_ACCOUNT_TYPE"+
    "WHERE MNEMONIC = :mnemonic", nativeQuery = true)
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);
//native queries is not recommended
    @Query(value = "SELECT"+
            "at"+
            "FROM"+
            "AccountType at"+
            "MNEMONIC"+
            "WHERE MNEMONIC = :mnemonic")
    AccountType getAccountTypeByMnemonic(String mnemonic);

    @Query(value = "SELECT new za.ac.nwu.domain.dto.AccountTypeDto("+
            "at.mnemonic,"+
            "at.accountTypeName,"+
            "at.creationDate"+
            "FROM"+
            "AccountType at"+
    "WHERE at. mnemonic =: mnemonic")
    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);

    AccountType findByCreationDate(LocalDate creationDate);
    AccountType findByAccountTypeName(Long accountTypeName);
    AccountType findByMnemonic(String mnemonic);
    AccountType findByAccountTypeId(Long accountTypeId);
    @Override
    Optional<AccountType> findById(Long aLong);

}

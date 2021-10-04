package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.domain.persistence.AccountType;
import za.ac.nwu.domain.persistence.CurrencyType;


import java.util.List;
import java.util.Optional;


    @Repository
    public interface CurrencyRepository extends JpaRepository<CurrencyType, Long> {
        @Query(value = "SELECT"+
                "CURRENCY_TYPE_ID,"+
                "CURRENCY_TYPE_NAME,"+
                "MNEMONIC"+
                "FROM"+ "VITRSA_SANDBOX_CURRENCY_TYPE"+
                "WHERE MNEMONIC = :mnemonic", nativeQuery = true)
        AccountType getCURRENCYTypeByMnemonicNativeQuery(String mnemonic);
        //native queries is not recommended
        @Query(value = "SELECT"+
                "at"+
                "FROM"+
                "CurrencyType at"+
                "MNEMONIC"+
                "WHERE MNEMONIC = :mnemonic")
        AccountType getCURRENCYTypeByMnemonic(String mnemonic);

        @Query(value = "SELECT new za.ac.nwu.domain.dto.CurrencyDto("+
                "at.mnemonic,"+
                "at.currencyTypeName,"+
                "FROM"+
                "CurrencyType at"+
                "WHERE at. mnemonic =: mnemonic")


        @Override
        Optional<CurrencyType> findById(Long aLong);


        List<CurrencyType> findAll();

    CurrencyType getCurrencyTypeByMnemonicNativeQuery(String mnemonic);

    CurrencyType getCurrencyTypeByMnemonic(String mnemonic);

    CurrencyDto getCurrencyDtoByMnemonic(String mnemonic);

}


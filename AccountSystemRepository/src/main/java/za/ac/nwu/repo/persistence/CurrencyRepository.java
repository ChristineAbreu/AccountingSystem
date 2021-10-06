package za.ac.nwu.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.domain.persistence.Currency;


import java.util.List;
import java.util.Optional;


    @Repository
    public interface CurrencyRepository extends JpaRepository<Currency, Long> {


        @Query(value = "SELECT" +
                "CURRENCY_TYPE_ID," +
                "CURRENCY_TYPE_NAME," +
                "MNEMONIC" +
                "FROM" + "VITRSA_SANDBOX_CURRENCY_TYPE" +
                "WHERE MNEMONIC = :mnemonic", nativeQuery = true)
        static Currency getCurrencyTypeByMnemonicNativeQuery(String mnemonic) {
            return null;
        }

        //native queries is not recommended
        @Query(value = "SELECT"+
                "at"+
                "FROM"+
                "Currency at"+
                "MNEMONIC"+
                "WHERE MNEMONIC = :mnemonic")
        Currency getCurrencyTypeByMnemonic(String mnemonic);

        @Query(value = "SELECT new za.ac.nwu.domain.dto.CurrencyDto("+
                "at.mnemonic,"+
                "at.currencyTypeName,"+
                "FROM"+
                "Currency at"+
                "WHERE at. mnemonic =: mnemonic")
        CurrencyDto getCurrencyDtoByMnemonic(String mnemonic);

        @Override
        Optional<Currency> findById(Long aLong);


        List<Currency> findAll();


}


package za.ac.nwu.repo.persistence;

import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.domain.persistence.CurrencyType;

public interface CurrencyRepository {
    CurrencyType[] findAll();

    CurrencyType getCurrencyTypeByMnemonicNativeQuery(String mnemonic);

    CurrencyType getCurrencyTypeByMnemonic(String mnemonic);

    CurrencyDto getCurrencyDtoByMnemonic(String mnemonic);

    CurrencyType save(Object currencyType);
}

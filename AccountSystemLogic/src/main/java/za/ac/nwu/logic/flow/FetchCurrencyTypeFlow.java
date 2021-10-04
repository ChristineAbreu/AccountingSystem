package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.CurrencyDto;

import java.util.List;

public interface FetchCurrencyTypeFlow {
    CurrencyDto getCurrencyTypeByMnemonic(String mnemonic);

    CurrencyDto getCurrencyTypeDbEntityByMnemonic(Object currencyTypeMnemonic);

    List<CurrencyDto> getAllCurrencyTypes();
}

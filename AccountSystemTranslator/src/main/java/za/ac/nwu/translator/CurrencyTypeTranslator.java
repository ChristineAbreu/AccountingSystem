package za.ac.nwu.translator;

import za.ac.nwu.domain.dto.CurrencyDto;

import java.util.List;

public interface CurrencyTypeTranslator {


    List<CurrencyDto> getAllCurrencyTypes();

    CurrencyDto delete(CurrencyDto currencyDto);

    CurrencyDto add(CurrencyDto currencyDto);

    CurrencyDto create(CurrencyDto currencyDto);

    CurrencyDto getCurrencyTypeByMnemonicNativeQuery(String mnemonic);

    CurrencyDto getCurrencyTypeByMnemonic(String mnemonic);

    void someMethod();


}

package za.ac.nwu.translator.impl;

import za.ac.nwu.domain.dto.CurrencyDto;

import java.util.List;

public interface CurrencyTypeTranslator {


    List<CurrencyDto> getAllCurrencyTypes();

    CurrencyDto create(CurrencyDto currencyDto);

    CurrencyDto getCurrencyTypeByMnemonicNativeQuery(String mnemonic);

    CurrencyDto getCurrencyTypeByMnemonic(String mnemonic);

    void someMethod();


}

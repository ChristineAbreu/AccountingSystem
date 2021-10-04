package za.ac.nwu.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.logic.flow.FetchCurrencyTypeFlow;
import za.ac.nwu.translator.CurrencyTypeTranslator;

import java.util.ArrayList;
import java.util.List;

public class FetchCurrencyTypeImpl implements FetchCurrencyTypeFlow {

    private final CurrencyTypeTranslator currencyTypeTranslator;

    @Autowired


    public FetchCurrencyTypeImpl(CurrencyTypeTranslator currencyTypeTranslator) {
        this.currencyTypeTranslator = currencyTypeTranslator;
    }


    @Override
    public CurrencyDto getCurrencyTypeByMnemonic(String mnemonic) {
        return currencyTypeTranslator.getCurrencyTypeByMnemonicNativeQuery(mnemonic);
    }

    @Override
    public CurrencyDto getCurrencyTypeDbEntityByMnemonic(Object currencyTypeMnemonic) {
        return null;
    }


    public boolean methodToTest(){
        return true;
    }
    @Override
    public List<CurrencyDto> getAllCurrencyTypes(){
        List<CurrencyDto> currencyDtos = new ArrayList<>();
        currencyDtos.add(new CurrencyDto("MILES","Miles"));
       return currencyDtos;
   }



}




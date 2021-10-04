package za.ac.nwu.logic.flow.impl;

import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.logic.flow.CreateCurrencyTypeFlow;
import za.ac.nwu.translator.impl.CurrencyTypeTranslator;


import javax.persistence.Index;
import javax.persistence.Table;

public class CreateCurrencyTypeFlowImpl implements CreateCurrencyTypeFlow {

    private CurrencyTypeTranslator currencyTypeTranslator;

    public CreateCurrencyTypeFlowImpl(CurrencyTypeTranslator currencyTypeTranslator) {
        this.currencyTypeTranslator = currencyTypeTranslator;

    }

    private CurrencyDto currencyType;
    public CurrencyDto create(AccountTypeDto accountType) {
        CurrencyDto currencyDto = currencyTypeTranslator.create(currencyType);
        return currencyTypeTranslator.create(currencyDto);
    }

    @Override
    public CurrencyDto create() {
        return CreateCurrencyTypeFlow.super.create();
    }

    @Override
    public CurrencyDto create(CurrencyDto currencyType) {
        return null;
    }
}



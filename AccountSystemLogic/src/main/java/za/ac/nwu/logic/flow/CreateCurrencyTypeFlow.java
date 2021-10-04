package za.ac.nwu.logic.flow;


import za.ac.nwu.domain.dto.CurrencyDto;

public interface CreateCurrencyTypeFlow {
    default CurrencyDto create() {
        return create();
    }

    CurrencyDto create(CurrencyDto currencyType);

}


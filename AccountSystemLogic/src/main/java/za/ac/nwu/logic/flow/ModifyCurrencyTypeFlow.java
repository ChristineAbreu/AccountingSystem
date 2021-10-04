package za.ac.nwu.logic.flow;


import za.ac.nwu.domain.dto.CurrencyDto;

import java.time.LocalDate;

public interface ModifyCurrencyTypeFlow {

    CurrencyDto deleteCurrencyType(String mnemonic);

    CurrencyDto updateCurrencyType(String mnemonic, String newCurrencyTypeName);
}

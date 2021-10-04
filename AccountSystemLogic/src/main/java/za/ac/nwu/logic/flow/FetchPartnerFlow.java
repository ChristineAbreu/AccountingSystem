package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.PartnerDto;

import java.util.List;

public interface FetchPartnerFlow {
    PartnerDto getPartnerTypeByMnemonic(String mnemonic);

    PartnerDto getPartnerTypeDbEntityByMnemonic(Object currencyTypeMnemonic);

    List<PartnerDto> getAllPartnerTypes();
}

package za.ac.nwu.translator;

import za.ac.nwu.domain.dto.PartnerDto;

import java.util.List;

public interface PartnerTranslator {
    List<PartnerDto> getAllPartnerTypes();

    PartnerDto create(PartnerDto partnerType);

    PartnerDto getPartnerTypeByMnemonicNativeQuery(String mnemonic);

    PartnerDto getPartnerTypeByMnemonic(String mnemonic);

    void someMethod();
}

package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.PartnerDto;

public interface ModifyPartnerTypeFlow {


    PartnerDto deletePartnerType(String mnemonic);

    PartnerDto updatePartnerType(String mnemonic, String newPartnerTypeName);
}

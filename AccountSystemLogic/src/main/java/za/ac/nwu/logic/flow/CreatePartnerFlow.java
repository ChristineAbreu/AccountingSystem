package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.PartnerDto;

public interface CreatePartnerFlow {
    default PartnerDto create() {
        return null;
    }

    PartnerDto create(PartnerDto partnerType);
}

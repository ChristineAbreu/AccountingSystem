package za.ac.nwu.logic.flow;

import za.ac.nwu.domain.dto.PartnerDto;

public interface CreatePartnerTypeFlow {
    default PartnerDto create() {
        return null;
    }

    PartnerDto create(PartnerDto partnerType);
}

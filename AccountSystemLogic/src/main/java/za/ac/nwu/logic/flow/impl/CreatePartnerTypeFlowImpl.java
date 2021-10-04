package za.ac.nwu.logic.flow.impl;

import za.ac.nwu.domain.dto.MemberAccountTypeDto;
import za.ac.nwu.domain.dto.PartnerDto;
import za.ac.nwu.logic.flow.CreatePartnerTypeFlow;
import za.ac.nwu.translator.PartnerTranslator;


public class CreatePartnerTypeFlowImpl implements CreatePartnerTypeFlow {

    private PartnerTranslator partnerTranslator;

    public CreatePartnerTypeFlowImpl(PartnerTranslator partnerTranslator) {
        this.partnerTranslator = partnerTranslator;

    }

    private PartnerDto partnerType;
    public PartnerDto create(MemberAccountTypeDto accountType) {
        PartnerDto partnerDto = partnerTranslator.create(partnerType);
        return partnerTranslator.create(partnerDto);
    }

    @Override
    public PartnerDto create() {
        return CreatePartnerTypeFlow.super.create();
    }

    @Override
    public PartnerDto create(PartnerDto partnerType) {
        return null;
    }
}



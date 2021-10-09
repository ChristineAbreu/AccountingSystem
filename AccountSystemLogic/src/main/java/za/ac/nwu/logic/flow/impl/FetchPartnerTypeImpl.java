package za.ac.nwu.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.nwu.domain.dto.PartnerDto;
import za.ac.nwu.logic.flow.FetchPartnerTypeFlow;
import za.ac.nwu.translator.PartnerTranslator;

import java.util.ArrayList;
import java.util.List;

public class FetchPartnerTypeImpl implements FetchPartnerTypeFlow {

    private final PartnerTranslator partnerTranslator;

    @Autowired


    public FetchPartnerTypeImpl(PartnerTranslator partnerTranslator) {
        this.partnerTranslator = partnerTranslator;
    }


    @Override
    public PartnerDto getPartnerTypeByMnemonic(String mnemonic) {
        return partnerTranslator.getPartnerTypeByMnemonicNativeQuery(mnemonic);
    }

    @Override
    public PartnerDto getPartnerTypeDbEntityByMnemonic(Object partnerTypeMnemonic) {
        return null;
    }


    public boolean methodToTest() {
        return true;
    }

    @Override
    public List<PartnerDto> getAllPartnerTypes() {
        List<PartnerDto> partnerDtos = new ArrayList<>();
        partnerDtos.add(new PartnerDto("Temporary Partner", "Takealot"));
        return partnerDtos;
    }
}
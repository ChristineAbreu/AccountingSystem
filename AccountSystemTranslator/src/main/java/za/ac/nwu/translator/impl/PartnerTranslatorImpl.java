package za.ac.nwu.translator.impl;

import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.PartnerDto;
import za.ac.nwu.domain.persistence.PartnerType;
import za.ac.nwu.repo.persistence.PartnerRepository;
import za.ac.nwu.translator.PartnerTranslator;

import java.util.ArrayList;
import java.util.List;


@Component
public class PartnerTranslatorImpl implements PartnerTranslator {

    private final PartnerRepository partnerRepository;
    private PartnerDto partnerDto;


    @Contract(pure = true)
    @Autowired

    public PartnerTranslatorImpl() {
        partnerRepository = null;
    }

    @Override
    public List<PartnerDto> getAllPartnerTypes() {

        List<PartnerDto> partnerDtos = new ArrayList<>();
        try {
            for (PartnerType partnerType : partnerRepository.findAll()) {
                partnerDtos.add(new PartnerDto(partnerType));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from DB", e);
        }
        return partnerDtos;
    }



    @Override
    public PartnerDto create(PartnerDto partnerDto) {

        try {
            PartnerType partnerType = partnerRepository.save(partnerDto.getPartnerType());
            return new PartnerDto(partnerType);

        } catch (Exception e) {
            throw new RuntimeException("Unable to read from DB", e);
        }

    }


    @Override
    public PartnerDto getPartnerTypeByMnemonicNativeQuery(String mnemonic) {
        try {
            PartnerType partnerType = PartnerRepository.getPartnerTypeByMnemonicNativeQuery(mnemonic);
            return new PartnerDto(partnerType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }


    @Override
    public PartnerDto getPartnerTypeByMnemonic (String mnemonic) {
        try {
            PartnerType partnerType = partnerRepository.getPartnerTypeByMnemonic(mnemonic);
            return new PartnerDto(partnerType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }
    public PartnerDto getPartnerDtoByMnemonic(String mnemonic, PartnerDto partnerDto){
        try {
            PartnerDto partnerType = partnerRepository.getPartnerDtoByMnemonic(mnemonic);
            return new PartnerDto(partnerType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public void someMethod() {

    }
}
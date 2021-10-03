package za.ac.nwu.translator.impl;


import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.domain.persistence.CurrencyType;
import za.ac.nwu.repo.persistence.CurrencyRepository;

import java.util.ArrayList;
import java.util.List;


@Component
public class CurrencyImpl implements CurrencyTypeTranslator {

    private final CurrencyRepository currencyRepository;


    @Contract(pure = true)
    @Autowired

    public CurrencyImpl() {
        currencyRepository = null;
    }

    @Override
    public List<CurrencyDto> getAllCurrencyTypes() {

        List<CurrencyDto> currencyDtos = new ArrayList<>();
        try {
            for (CurrencyType currencyType : currencyRepository.findAll()) {
                currencyDtos.add(new CurrencyDto(currencyType));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from DB", e);
        }
        return currencyDtos;
    }



    @Override
    public CurrencyDto create(CurrencyDto currencyDto) {

        try {
            CurrencyType currencyType = currencyRepository.save(currencyDto.getCurrencyType());
            return new CurrencyDto(currencyDto);

        } catch (Exception e) {
            throw new RuntimeException("Unable to read from DB", e);
        }

    }

    @Override
    public CurrencyDto getAccountTypeByMnemonicNativeQuery(String mnemonic) {
        return null;
    }

    @Override
    public CurrencyDto getAccountTypeByMnemonic(String mnemonic) {
        return null;
    }

    @Override
    public CurrencyDto getAccountTypeDtoByMnemonic(String mnemonic) {
        return null;
    }

    @Override
    public CurrencyDto getCurrencyTypeByMnemonicNativeQuery(String mnemonic) {
        try {
            CurrencyType currencyType = currencyRepository.getCurrencyTypeByMnemonicNativeQuery(mnemonic);
            return new CurrencyDto(currencyDto);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }


    @Override
    public CurrencyDto getCurrencyTypeByMnemonic (String mnemonic) {
        try {
            CurrencyType currencyType = currencyRepository.getCurrencyTypeByMnemonic(mnemonic);
            return new CurrencyDto(currencyDto);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }
    public CurrencyDto getCurrencyDtoByMnemonic(String mnemonic, CurrencyDto currencyDto){
        try {
            CurrencyDto currencyType = currencyRepository.getCurrencyDtoByMnemonic(mnemonic);
            return new CurrencyDto(currencyDto);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public void someMethod() {

    }
}
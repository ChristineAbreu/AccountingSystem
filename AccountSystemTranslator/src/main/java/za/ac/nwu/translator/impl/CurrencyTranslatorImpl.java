package za.ac.nwu.translator.impl;


import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.domain.persistence.Currency;
import za.ac.nwu.repo.persistence.CurrencyRepository;
import za.ac.nwu.translator.CurrencyTypeTranslator;

import java.util.ArrayList;
import java.util.List;


@Component
public class CurrencyTranslatorImpl implements CurrencyTypeTranslator {

    private final CurrencyRepository currencyRepository;
    private CurrencyDto currencyDto;


    @Contract(pure = true)
    @Autowired

    public CurrencyTranslatorImpl() {
        currencyRepository = null;
    }

    @Override
    public List<CurrencyDto> getAllCurrencyTypes() {

        List<CurrencyDto> currencyDtos = new ArrayList<>();
        try {
            for (Currency currency : currencyRepository.findAll()) {
                currencyDtos.add(new CurrencyDto(currency));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from DB", e);
        }
        return currencyDtos;
    }



    @Override
    public CurrencyDto create(CurrencyDto currencyDto) {

        try {
            Currency currency = currencyRepository.save(currencyDto.getCurrencyType());
            return new CurrencyDto(currency);

        } catch (Exception e) {
            throw new RuntimeException("Unable to read from DB", e);
        }

    }


    @Override
    public CurrencyDto getCurrencyTypeByMnemonicNativeQuery(String mnemonic) {
        try {
            Currency currency = CurrencyRepository.getCurrencyTypeByMnemonicNativeQuery(mnemonic);
            return new CurrencyDto(currency);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }


    @Override
    public CurrencyDto getCurrencyTypeByMnemonic (String mnemonic) {
        try {
            Currency currency = currencyRepository.getCurrencyTypeByMnemonic(mnemonic);
            return new CurrencyDto(currency);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }
    public CurrencyDto getCurrencyDtoByMnemonic(String mnemonic, CurrencyDto currencyDto){
        try {
            CurrencyDto currencyType = currencyRepository.getCurrencyDtoByMnemonic(mnemonic);
            return new CurrencyDto(currencyType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public void someMethod() {

    }
}
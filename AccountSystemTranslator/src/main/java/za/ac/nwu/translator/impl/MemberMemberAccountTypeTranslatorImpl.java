package za.ac.nwu.translator.impl;

import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.MemberAccountTypeDto;
import za.ac.nwu.domain.persistence.Member;
import za.ac.nwu.repo.persistence.MemberAccountTypeRepository;
import za.ac.nwu.translator.MemberAccountTypeTranslator;

import java.util.ArrayList;
import java.util.List;


@Component
public class MemberMemberAccountTypeTranslatorImpl implements MemberAccountTypeTranslator {

    private final MemberAccountTypeRepository memberAccountTypeRepository;

    @Contract(pure = true)
    @Autowired
    public MemberMemberAccountTypeTranslatorImpl(MemberAccountTypeRepository memberAccountTypeRepository) {
        this.memberAccountTypeRepository = memberAccountTypeRepository;
    }

    @Override
    public List<MemberAccountTypeDto> getAllAccountTypes() {

        List<MemberAccountTypeDto> memberAccountTypeDtos = new ArrayList<>();
        try {
            for (Member member : memberAccountTypeRepository.findAll()) {
                memberAccountTypeDtos.add(new MemberAccountTypeDto(member));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from DB", e);
        }
        return memberAccountTypeDtos;
    }

    @Override
    public MemberAccountTypeDto create(MemberAccountTypeDto memberAccountTypeDto) {

        try {
            Member member = memberAccountTypeRepository.save(memberAccountTypeDto.getAccountType());
            return new MemberAccountTypeDto(member);

        } catch (Exception e) {
            throw new RuntimeException("Unable to read from DB", e);
        }

    }
    @Override
    public MemberAccountTypeDto delete(MemberAccountTypeDto memberAccountTypeDto) {

        try {
            Member member = memberAccountTypeRepository.save(memberAccountTypeDto.getAccountType());
            return new MemberAccountTypeDto(member);

        } catch (Exception e) {
            throw new RuntimeException("Unable to read from DB", e);
        }

    }
    @Override
    public MemberAccountTypeDto getAccountTypeByMnemonicNativeQuery(String mnemonic) {
        try {
            Member member = memberAccountTypeRepository.getAccountTypeByMnemonicNativeQuery(mnemonic);
            return new MemberAccountTypeDto(member);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }


        @Override
        public MemberAccountTypeDto getAccountTypeByMnemonic (String mnemonic) {
            try {
                Member member = memberAccountTypeRepository.getAccountTypeByMnemonic(mnemonic);
                return new MemberAccountTypeDto(member);
            } catch (Exception e) {
                throw new RuntimeException("Unable to read from the DB", e);
            }
        }
            @Override
            public MemberAccountTypeDto getAccountTypeDtoByMnemonic (String mnemonic){
                try {
                    MemberAccountTypeDto accountType = memberAccountTypeRepository.getAccountTypeDtoByMnemonic(mnemonic);
                    return new MemberAccountTypeDto(accountType);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to read from the DB", e);
                }
            }

    @Override
    public void someMethod() {

    }
}


package za.ac.nwu.translator.impl;

import za.ac.nwu.domain.persistence.MemberAccountTransactionDetails;
import za.ac.nwu.repo.persistence.MemberAccountTransactionDetailsRepository;
import za.ac.nwu.translator.MemberAccountTransactionDetailsTranslator;

public class MemberMemberAccountTransactionDetailsTranslatorImpl implements MemberAccountTransactionDetailsTranslator {
    private MemberAccountTransactionDetailsRepository repo;

    public MemberMemberAccountTransactionDetailsTranslatorImpl(MemberAccountTransactionDetailsRepository memberAccountTransactionDetailsRepository) {

        this.repo = memberAccountTransactionDetailsRepository;
    }

    @Override
    public MemberAccountTransactionDetails save(MemberAccountTransactionDetails memberAccountTransactionDetails) {
        try {
            return repo.save(memberAccountTransactionDetails);

        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}

package za.ac.nwu.logic.flow.impl;

import za.ac.nwu.domain.dto.MemberAccountTransactionDto;
import za.ac.nwu.domain.persistence.MemberAccountTransaction;
import za.ac.nwu.logic.flow.FetchMemberAccountTransactionFlow;
import za.ac.nwu.translator.MemberAccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

public class FetchMemberAccountTransactionFlowImpl implements FetchMemberAccountTransactionFlow {

    private MemberAccountTransactionTranslator translator;

    public FetchMemberAccountTransactionFlowImpl(MemberAccountTransactionTranslator translator){
        this.translator = translator;
    }

    @Override
    public List<MemberAccountTransactionDto> getAllAccountTransactions(){
        List<MemberAccountTransactionDto> memberAccountTransactionDtos = new ArrayList<>();
        for (MemberAccountTransaction memberAccountTransaction : translator.getAllAccountTransactions()){
            memberAccountTransactionDtos.add(new MemberAccountTransactionDto(memberAccountTransaction));

        }
        return memberAccountTransactionDtos;
    }

    @Override
    public MemberAccountTransactionDto getAccountTransactionById(Long transactionId) {
        MemberAccountTransaction memberAccountTransaction = translator.getAccountTransactionByPk(transactionId);
        return null!= memberAccountTransaction ? new MemberAccountTransactionDto(memberAccountTransaction) : null;
    }
}

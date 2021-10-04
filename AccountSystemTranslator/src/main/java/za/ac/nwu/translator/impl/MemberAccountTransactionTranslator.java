package za.ac.nwu.translator.impl;

import za.ac.nwu.domain.persistence.MemberAccountTransaction;

import java.util.List;

public interface MemberAccountTransactionTranslator {
    MemberAccountTransaction save(MemberAccountTransaction memberAccountTransaction);


    MemberAccountTransaction getAccountTransactionByPk(Long transactionId);
    List<MemberAccountTransaction> getAllAccountTransactions();
}

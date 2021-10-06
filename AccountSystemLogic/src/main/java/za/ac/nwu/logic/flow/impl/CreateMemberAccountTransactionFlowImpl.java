package za.ac.nwu.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.domain.dto.MemberAccountTransactionDto;
import za.ac.nwu.domain.persistence.Member;
import za.ac.nwu.domain.persistence.MemberAccountTransaction;
import za.ac.nwu.domain.persistence.MemberAccountTransactionDetails;
import za.ac.nwu.logic.flow.CreateMemberAccountTransactionFlow;
import za.ac.nwu.logic.flow.FetchMemberAccountTypeFlow;
import za.ac.nwu.translator.MemberAccountTransactionDetailsTranslator;
import za.ac.nwu.translator.MemberAccountTransactionTranslator;

@Component
public class CreateMemberAccountTransactionFlowImpl implements CreateMemberAccountTransactionFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateMemberAccountTransactionFlowImpl.class);

    private final MemberAccountTransactionTranslator memberAccountTransactionTranslator;
    private final MemberAccountTransactionDetailsTranslator memberAccountTransactionDetailsTranslator;
    private final FetchMemberAccountTypeFlow fetchMemberAccountTypeFlow;


    public CreateMemberAccountTransactionFlowImpl(MemberAccountTransactionTranslator memberAccountTransactionTranslator,
                                                  MemberAccountTransactionDetailsTranslator memberAccountTransactionDetailsTranslator,
                                                  FetchMemberAccountTypeFlow fetchMemberAccountTypeFlow) {
        this.memberAccountTransactionTranslator = memberAccountTransactionTranslator;
        this.memberAccountTransactionDetailsTranslator = memberAccountTransactionDetailsTranslator;
        this.fetchMemberAccountTypeFlow = fetchMemberAccountTypeFlow;
    }

    @Override
    public MemberAccountTransactionDto create(MemberAccountTransactionDto memberAccountTransactionDto) {
        if (LOGGER.isInfoEnabled()) {
            String outputForLogging = "null";
            if ((null != memberAccountTransactionDto) && (null != memberAccountTransactionDto.getDetails())) {
outputForLogging = memberAccountTransactionDto.getDetails().toString();
            }


            LOGGER.info("The input object was {} and the Details are {}", memberAccountTransactionDto.outputForLogging);
        }
            Member member = fetchMemberAccountTypeFlow.getAccountTypeDbEntityByMnemonic(
                    memberAccountTransactionDto.getAccountTypeMnemonic());
            LOGGER.debug("Got Member for {} and the AccountTypeID is {}", memberAccountTransactionDto.getAccountTypeMnemonic(), member.getAccountTypeId());
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Got Member for {} and the AccountTypeID is {}", memberAccountTransactionDto.getAccountTypeMnemonic(), member.getAccountTypeId());
            }
            MemberAccountTransaction memberAccountTransaction = memberAccountTransactionDto.buildAccountTransaction(member);

            MemberAccountTransaction createdMemberAccountTransaction = memberAccountTransactionTranslator.save(memberAccountTransaction);

            if (null != memberAccountTransactionDto.getDetails()) {
                MemberAccountTransactionDetails memberAccountTransactionDetails = memberAccountTransactionDto.getDetails().buildAccountTransactionDetails(createdMemberAccountTransaction);
                memberAccountTransactionDetailsTranslator.save(memberAccountTransactionDetails);
            }

            if (null != memberAccountTransactionDto.getDetails()) {
                MemberAccountTransactionDetails memberAccountTransactionDetails = memberAccountTransactionDto.getDetails().buildAccountTransactionDetails(createdMemberAccountTransaction);
                createdMemberAccountTransaction.setDetails(memberAccountTransactionDetails);
                memberAccountTransactionDetailsTranslator.save(memberAccountTransactionDetails);
            }
            MemberAccountTransactionDto results = new MemberAccountTransactionDto(createdMemberAccountTransaction);
            LOGGER.warn("The return object is {}", results);
            return results;
        }

    }




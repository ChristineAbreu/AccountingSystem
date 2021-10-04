package za.ac.nwu.web.sb.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.domain.dto.MemberAccountTransactionDto;
import za.ac.nwu.domain.service.GeneralResponse;
import za.ac.nwu.logic.flow.CreateMemberAccountTransactionFlow;
import za.ac.nwu.logic.flow.FetchMemberAccountTransactionFlow;

import java.util.List;

@RestController
@RequestMapping("account-transaction")
public class MemberAccountTransactionController {

    public final CreateMemberAccountTransactionFlow createMemberAccountTransactionFlow;
    public final FetchMemberAccountTransactionFlow fetchMemberAccountTransactionFlow;


    @Autowired
    public MemberAccountTransactionController(CreateMemberAccountTransactionFlow createMemberAccountTransactionFlow,
                                              FetchMemberAccountTransactionFlow fetchMemberAccountTransactionFlow) {
        this.createMemberAccountTransactionFlow = createMemberAccountTransactionFlow;
        this.fetchMemberAccountTransactionFlow = fetchMemberAccountTransactionFlow;
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new MemberAccountTransaction.", notes = "Creates a new MemberAccountTransaction in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The MemberAccountTransaction was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberAccountTransactionDto>> create(
            @ApiParam(value = "Request body to create a new MemberAccountTransaction.", required = true)
            @RequestBody MemberAccountTransactionDto AccountTransaction) {
        MemberAccountTransactionDto AccountTransactionResponse = createMemberAccountTransactionFlow.create(AccountTransaction);
        GeneralResponse<MemberAccountTransactionDto> response = new GeneralResponse<>(true, AccountTransactionResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account types.", notes = "Returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<MemberAccountTransactionDto>>> getAll() {

        List<MemberAccountTransactionDto> AccountTransactions = fetchMemberAccountTransactionFlow.getAllAccountTransactions();

        GeneralResponse<List<MemberAccountTransactionDto>> response = new GeneralResponse<>(true, AccountTransactions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/transactionId")
    @ApiOperation(value = "Fetches the specified MemberAccountTransaction.", notes = "Fetched the MemberAccountTransaction corresponding to the given transactionId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "MemberAccountTransaction Found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class),})
    public ResponseEntity<GeneralResponse<MemberAccountTransactionDto>> getAccountTransaction(
            @ApiParam(value = "The transactionId that uniquely identifies the MemberAccountTransaction.",
                    example = "50002",
                    name = "transactionId",
                    required = true)
            @PathVariable("transactionId") final Long transactionId) {

        MemberAccountTransactionDto AccountTransaction = fetchMemberAccountTransactionFlow.getAccountTransactionById(transactionId);
        GeneralResponse<MemberAccountTransactionDto> response = new GeneralResponse<>(true, AccountTransaction);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}






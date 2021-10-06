package za.ac.nwu.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.domain.dto.MemberAccountTypeDto;
import za.ac.nwu.domain.service.GeneralResponse;
import za.ac.nwu.logic.flow.CreateMemberAccountTypeFlow;
import za.ac.nwu.logic.flow.FetchMemberAccountTypeFlow;
import za.ac.nwu.logic.flow.ModifyMemberAccountTypeFlow;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("account-type")
public class AccountController {


    private final FetchMemberAccountTypeFlow fetchMemberAccountTypeFlow;
    private final CreateMemberAccountTypeFlow createMemberAccountTypeFlow;
    private final ModifyMemberAccountTypeFlow modifyMemberAccountTypeFlow;
    private MemberAccountTypeDto accountType;


    @Autowired
    public AccountController(FetchMemberAccountTypeFlow fetchMemberAccountTypeFlow,
                             @Qualifier("createAccountTypeFlowName") CreateMemberAccountTypeFlow createMemberAccountTypeFlow, ModifyMemberAccountTypeFlow modifyMemberAccountTypeFlow) {
        this.fetchMemberAccountTypeFlow = fetchMemberAccountTypeFlow;
        this.createMemberAccountTypeFlow = createMemberAccountTypeFlow;
        this.modifyMemberAccountTypeFlow = modifyMemberAccountTypeFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account types.", notes = "Returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<MemberAccountTypeDto>>> getAll() {

        List<MemberAccountTypeDto> accountTypes = fetchMemberAccountTypeFlow.getAllAccountTypes();

        GeneralResponse<List<MemberAccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new Member.", notes = "Creates a new Member in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The Member was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberAccountTypeDto>> create(
            @ApiParam(value = "Request body to create a new Member.", required = true)
            @RequestBody MemberAccountTypeDto accountType) {
        MemberAccountTypeDto accountTypeResponse = createMemberAccountTypeFlow.create(accountType);
        GeneralResponse<MemberAccountTypeDto> response = new GeneralResponse<>(true, accountTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("{mnemonic}")
    @ApiOperation(value = "Fetches the specified Member.", notes = "Fetched the Member corresponding to the given mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Member Found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class),})
    public ResponseEntity<GeneralResponse<MemberAccountTypeDto>> getAccountType(
            @ApiParam(value = "The mnemonic that uniquely identifies the Member.",
            example = "MILES",
            name = "mnemonic",
            required = true)
            @PathVariable("mnemonic") final String mnemonic) {

        MemberAccountTypeDto accountType = fetchMemberAccountTypeFlow.getAccountTypeByMnemonic(mnemonic);
        GeneralResponse<MemberAccountTypeDto> response = new GeneralResponse<>(true, accountType);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("{mnemonic}")
    @ApiOperation(value = "Deletes the specified Member.",notes = "Deletes the Member corresponding to the given mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Member deleted", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<MemberAccountTypeDto>> deleteAccountType(
            @ApiParam(value = "The mnemonic that uniquely identifies the Member.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic) {
        MemberAccountTypeDto accountType = modifyMemberAccountTypeFlow.deleteAccountType(mnemonic);
        GeneralResponse<MemberAccountTypeDto> response = new GeneralResponse<>(true, accountType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("{mnemonic}")
    @ApiOperation(value = "Updates the specified Member.", notes= "Updates the Member corresponding to the given mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Member updated", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MemberAccountTypeDto>> updateAccountType(
            @ApiParam(value = "The mnemonic that uniquely identifies the Member.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic,
            @ApiParam(value = "The new AccountTypeName that the specified Member should be updated with.",
                    name = "newAccountTypeName",
                    required = true)

            @RequestParam ("newAccountTypeName") final String newAccountTypeName,

           @ApiParam(value = "The optional new date with which to update the CreationDate in ISO date format (yyyy-MM-dd\r\n If empty/null it will not be updated.",
           name = "newCreationDate")
            @RequestParam (value = "newCreationDate",
                    required=false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate newCreationDate)
            {
                MemberAccountTypeDto accountType = modifyMemberAccountTypeFlow.updateAccountType(mnemonic, newAccountTypeName, newCreationDate);
                GeneralResponse<MemberAccountTypeDto> response = new GeneralResponse<>(true, accountType);
                return new ResponseEntity<>(response, HttpStatus.OK);
    }



}


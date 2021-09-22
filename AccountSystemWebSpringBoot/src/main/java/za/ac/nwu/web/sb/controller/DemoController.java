package za.ac.nwu.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.domain.dto.AccountTypeDto;
import za.ac.nwu.domain.service.GeneralResponse;
import za.ac.nwu.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.logic.flow.FetchAccountTypeFlow;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("account-type")
public class DemoController {


    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;
    private AccountTypeDto accountType;


    @Autowired
    public DemoController(FetchAccountTypeFlow fetchAccountTypeFlow,
    @Qualifier("createAccountTypeFlowName") CreateAccountTypeFlow createAccountTypeFlow){
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.createAccountTypeFlow = createAccountTypeFlow;
    }
    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account types.", notes = "Returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll()
             {
list
                 List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();

        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountType.", notes = "Creates a new AccountType in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountType was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> create(
            @ApiParam(value = "Request body to create a new AccountType.", required = true)
    @RequestBody AccountTypeDto accountType){
        AccountTypeDto accountTypeResponse = createAccountTypeFlow.create(accountType);
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("")
    @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to the client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<String>> getPing(@RequestParam(value = "echo", defaultValue = "pong", required = false) String echo) {
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<String> response = new GeneralResponse<String>(true, echo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


@GetMapping("/ping")

@ApiOperation(value = "Creates a new Ping.", notes = "Creates a new Pong in the system.")
@ApiResponses(value = {
@ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
@ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
@ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
@ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
public ResponseEntity<GeneralResponse<String>> ping(@RequestParam(value = "echo", defaultValue = "pong", required =false) String echo){
        GeneralResponse<String> response=new GeneralResponse<String>(true,echo);
        return new ResponseEntity<>(response,HttpStatus.OK);
        }

        @PostMapping("/ping")
@ApiOperation(value = "Create a new Pong.",notes = "Creates a new Pong in the system.")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "The Pong was created succesfully", response = GeneralResponse.class),
                @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
public ResponseEntity<GeneralResponse<Pong>> postPong(
        @ApiParam(value = "Request body to create a new Pong.",
        required = true)
@RequestBody Pong pong){
        GeneralResponse<Pong> response=new GeneralResponse<>(true,pong);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
        }


        @PutMapping("/ping")
        @ApiOperation(value = "Update the Pong")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "The Pong updated", response = GeneralResponse.class),
                @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
        public ResponseEntity<GeneralResponse<Pong>> putPong(@RequestParam(value = "The number of days to add", defaultValue = "2")
int daysToAdd,
        @ApiParam(value = "The Pong.",
        required = true)
@RequestBody Pong pong){
    pong.setOnDate(pong.getOnDate().plusDays(daysToAdd));
    GeneralResponse<Pong> response = new GeneralResponse<>(true, pong);
    return new ResponseEntity<>(response, HttpStatus.OK);
        }

        @DeleteMapping("/ping")
        @ApiOperation(value = "Delete the Pong")
        @ApiResponses(value = {
                @ApiResponse(code = 200, message = "The Pong deleted", response = GeneralResponse.class),
                @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
                @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

        public ResponseEntity<GeneralResponse<Pong>> deletePong(
@ApiParam(value = "The Pong.",
        required = true)
@RequestBody Pong pong){
        GeneralResponse<Pong> response = new GeneralResponse<>(true, pong);
        return new ResponseEntity<>(response, HttpStatus.OK);
        }

@GetMapping("/error")
@ApiOperation(value = "Throws an exception")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
        @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

public ResponseEntity<GeneralResponse<AccountTypeDto>> getAccountType(
        @ApiParam(value = "The mnemonic that uniquely identifies the AccountType.",
        example = "MILES",
        name= "mnemonic",
        required = true)
                @PathVariable("mnemonic") final String mnemonic){
            AccountTypeDto accountTypeDto = fetchAccountTypeFlow.getAccountTypeByMnemonic(mnemonic);
            GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountType);
            return new ResponseEntity<>(response, HttpStatus.OK);
            
}

public ResponseEntity<GeneralResponse<String>> ping(){
        throw new RuntimeException("Give an error");
        }

    private class Pong {
        public LocalDate getOnDate() {
            return null;
        }

        public void setOnDate(LocalDate plusDays) {
        }
    }
}

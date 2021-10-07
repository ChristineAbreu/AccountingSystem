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
import za.ac.nwu.domain.dto.CurrencyDto;
import za.ac.nwu.domain.service.GeneralResponse;
import za.ac.nwu.logic.flow.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("currency-type")
public class CurrencyController {


    private final FetchCurrencyTypeFlow fetchCurrencyTypeFlow;
    private final CreateCurrencyTypeFlow createCurrencyTypeFlow;
    private final ModifyCurrencyTypeFlow modifyCurrencyTypeFlow;
    private CurrencyDto currencyDto;


    @Autowired
    public CurrencyController(FetchCurrencyTypeFlow fetchCurrencyTypeFlow,
                             @Qualifier("createCurrencyTypeFlow") CreateCurrencyTypeFlow createCurrencyTypeFlow, ModifyCurrencyTypeFlow modifyCurrencyTypeFlow) {
        this.fetchCurrencyTypeFlow = fetchCurrencyTypeFlow;
        this.createCurrencyTypeFlow = createCurrencyTypeFlow;
        this.modifyCurrencyTypeFlow = modifyCurrencyTypeFlow;
    }

    @GetMapping("/getAllCurrencyTypes")
    @ApiOperation(value = "Gets all the configured Currency types.", notes = "Returns a list of Currency types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Currency types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<CurrencyDto>>> getAll() {

        List<CurrencyDto> currencyTypes = fetchCurrencyTypeFlow.getAllCurrencyTypes();

        GeneralResponse<List<CurrencyDto>> response = new GeneralResponse<>(true, currencyTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new Currency.", notes = "Creates a new Currency in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The Currency was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<CurrencyDto>> create(
            @ApiParam(value = "Request body to create a new Currency.", required = true)
            @RequestBody CurrencyDto currencyType) {
        CurrencyDto currencyTypeResponse = createCurrencyTypeFlow.create(currencyType);
        GeneralResponse<CurrencyDto> response = new GeneralResponse<>(true, currencyTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("{mnemonic}")
    @ApiOperation(value = "Fetches the specified Currency.", notes = "Fetched the Currency corresponding to the given mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Currency Found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class),})
    public ResponseEntity<GeneralResponse<CurrencyDto>> getCurrencyType(
            @ApiParam(value = "The mnemonic that uniquely identifies the Currency.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic) {

        CurrencyDto currencyType = fetchCurrencyTypeFlow.getCurrencyTypeByMnemonic(mnemonic);
        GeneralResponse<CurrencyDto> response = new GeneralResponse<>(true, currencyType);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("{mnemonic}")
    @ApiOperation(value = "Deletes the specified Currency.",notes = "Deletes the Currency corresponding to the given mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Currency deleted", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<CurrencyDto>> deleteCurrencyType(
            @ApiParam(value = "The mnemonic that uniquely identifies the Currency.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic) {
        CurrencyDto currencyType = modifyCurrencyTypeFlow.deleteCurrencyType(mnemonic);
        GeneralResponse<CurrencyDto> response = new GeneralResponse<>(true, currencyType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("{mnemonic}")
    @ApiOperation(value = "Updates the specified Currency.", notes= "Updates the Currency corresponding to the given mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Currency updated", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<CurrencyDto>> updateCurrencyType(
            @ApiParam(value = "The mnemonic that uniquely identifies the Currency.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic,
            @ApiParam(value = "The new CurrencyTypeName that the specified Currency should be updated with.",
                    name = "newCurrencyTypeName",
                    required = true)

            @RequestParam ("newCurrencyTypeName") final String newCurrencyTypeName,

            @ApiParam(value = "The optional new date with which to update the CreationDate in ISO date format (yyyy-MM-dd\r\n If empty/null it will not be updated.",
                    name = "newCreationDate")
            @RequestParam (value = "newCreationDate",
                    required=false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate newCreationDate)
    {
        CurrencyDto currencyType = modifyCurrencyTypeFlow.updateCurrencyType(mnemonic, newCurrencyTypeName);
        GeneralResponse<CurrencyDto> response = new GeneralResponse<>(true, currencyType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}


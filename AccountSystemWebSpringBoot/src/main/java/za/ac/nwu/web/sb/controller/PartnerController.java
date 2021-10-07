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
import za.ac.nwu.domain.dto.PartnerDto;
import za.ac.nwu.domain.service.GeneralResponse;
import za.ac.nwu.logic.flow.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("Partner-type")
public class PartnerController {


    private final FetchPartnerTypeFlow fetchPartnerTypeFlow ;
    private final CreatePartnerTypeFlow createPartnerTypeFlow;
    private final ModifyPartnerTypeFlow modifyPartnerTypeFlow;
    private PartnerDto partnerDto;


    @Autowired
    public PartnerController(FetchPartnerTypeFlow fetchPartnerTypeFlow,
                              @Qualifier("createPartnerTypeFlow") CreatePartnerTypeFlow createPartnerTypeFlow, ModifyPartnerTypeFlow modifyPartnerTypeFlow) {
        this.fetchPartnerTypeFlow = fetchPartnerTypeFlow;
        this.createPartnerTypeFlow = createPartnerTypeFlow;
        this.modifyPartnerTypeFlow = modifyPartnerTypeFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Partner types.", notes = "Returns a list of Partner types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Partner types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<PartnerDto>>> getAll() {

        List<PartnerDto> partnerTypes = fetchPartnerTypeFlow.getAllPartnerTypes();

        GeneralResponse<List<PartnerDto>> response = new GeneralResponse<>(true, partnerTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new PartnerType.", notes = "Creates a new PartnerType in the DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The PartnerType was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<PartnerDto>> create(
            @ApiParam(value = "Request body to create a new PartnerType.", required = true)
            @RequestBody PartnerDto partnerType) {
        PartnerDto partnerTypeResponse = createPartnerTypeFlow.create(partnerType);
        GeneralResponse<PartnerDto> response = new GeneralResponse<>(true, partnerTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("{mnemonic}")
    @ApiOperation(value = "Fetches the specified PartnerType.", notes = "Fetched the PartnerType corresponding to the given mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "PartnerType Found"),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class),})
    public ResponseEntity<GeneralResponse<PartnerDto>> getPartnerType(
            @ApiParam(value = "The mnemonic that uniquely identifies the PartnerType.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic) {

        PartnerDto partnerType = fetchPartnerTypeFlow.getPartnerTypeByMnemonic(mnemonic);
        GeneralResponse<PartnerDto> response = new GeneralResponse<>(true, partnerType);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("{mnemonic}")
    @ApiOperation(value = "Deletes the specified PartnerType.",notes = "Deletes the PartnerType corresponding to the given mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "PartnerType deleted", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})

    public ResponseEntity<GeneralResponse<PartnerDto>> deletePartnerType(
            @ApiParam(value = "The mnemonic that uniquely identifies the PartnerType.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic) {
        PartnerDto partnerType = modifyPartnerTypeFlow.deletePartnerType(mnemonic);
        GeneralResponse<PartnerDto> response = new GeneralResponse<>(true, partnerType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("{mnemonic}")
    @ApiOperation(value = "Updates the specified PartnerType.", notes= "Updates the PartnerType corresponding to the given mnemonic")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "PartnerType updated", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Resource not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<PartnerDto>> updatePartnerType(
            @ApiParam(value = "The mnemonic that uniquely identifies the PartnerType.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic,
            @ApiParam(value = "The new PartnerTypeName that the specified PartnerType should be updated with.",
                    name = "newPartnerTypeName",
                    required = true)

            @RequestParam ("newPartnerTypeName") final String newPartnerTypeName,

            @ApiParam(value = "The optional new date with which to update the CreationDate in ISO date format (yyyy-MM-dd\r\n If empty/null it will not be updated.",
                    name = "newCreationDate")
            @RequestParam (value = "newCreationDate",
                    required=false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate newCreationDate)
    {
        PartnerDto partnerType = modifyPartnerTypeFlow.updatePartnerType(mnemonic, newPartnerTypeName);
        GeneralResponse<PartnerDto> response = new GeneralResponse<>(true, partnerType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}

package com.example.ciscocasemanagementsystem.cases;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CasesController {

    private final CasesService casesService;

    @Autowired
    public CasesController(CasesService casesService) {
        this.casesService = casesService;
    }

    //Get all cases
    @GetMapping
    public List<Cases> getCases() {
        return casesService.getCases();
    }

    //Post a new case
    @PostMapping
    public void registerNewCase(@RequestBody Cases cases){

        casesService.addNewCase(cases);
    }

    //Delete a case by it Id
    @DeleteMapping("{caseId}")
    public void deleteCase(@PathVariable("caseId") Long caseId) {
        casesService.deleteCase(caseId);
    }

    //Updating status and severity of case
    @PutMapping(path = "{caseId}")
    public void updateCase(
            @PathVariable("caseId") Long caseId,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String severity) {
        casesService.updateCase(caseId, status, severity);
    }

}

package com.example.ciscocasemanagementsystem.cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CasesService {

    private final CasesRepository casesRepository;

    @Autowired
    public CasesService(CasesRepository casesRepository) {
        this.casesRepository = casesRepository;
    }

    public List<Cases> getCases() {
       return casesRepository.findAll();

    }

    public void addNewCase(Cases cases) {
        Optional<Cases> casesOptional = casesRepository
                .findCasesByDescription(cases.getDescription());
        if (casesOptional.isPresent()) {
            throw new IllegalStateException("Case already exit");
        }

        casesRepository.save(cases);
    }

    public void deleteCase(Long caseId) {
        boolean exists = casesRepository.existsById(caseId);
        if(!exists) {
            throw new IllegalStateException(
                    "case with Id " +caseId + " does not exist"
            );
        }
        casesRepository.deleteById(caseId);
        }
    @Transactional
    public void updateCase(Long caseId,
                           String status,
                           String severity) {
        Cases cases = casesRepository.findById(caseId)
                .orElseThrow(() -> new IllegalStateException(
                        "case with id " + caseId + " does not exist"));

        if (status != null && status.length() > 0 &&
                !Objects.equals(cases.getStatus(), status)) {
            cases.setStatus(status);
        }

        if (severity != null && severity.length() > 0 &&
                !Objects.equals(cases.getSeverity(), severity)) {
            cases.setSeverity(severity);
        }
    }
}


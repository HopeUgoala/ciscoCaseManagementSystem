package com.example.ciscocasemanagementsystem.cases;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CasesRepository
        extends JpaRepository<Cases, Long> {

    @Query("SELECT c FROM Cases c WHERE c.description =?1")
    Optional<Cases> findCasesByDescription(String description);

}

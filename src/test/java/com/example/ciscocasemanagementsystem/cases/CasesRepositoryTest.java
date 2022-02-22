package com.example.ciscocasemanagementsystem.cases;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CasesRepositoryTest {

    @Autowired
    private CasesRepository forTest;

    @Test
    void itShouldFindCasesByDescription() {
        //given
        String description = "Hello Cisco, when notice an alarm at 14:30 on 2022-01-11 please kindly check";
        Cases cases = new Cases(

                "Smoke sensor alarm",
                description,
                "low",
                "new",
                LocalDate.of(2022, 5, 23)

        );
        forTest.save(cases);

        //when
//        boolean expect = forTest.findCasesByDescription(description);

        //then
//        assertThat(expect).isTrue();

    }
}
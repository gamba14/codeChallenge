package com.code.challenge.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Agustin Gambirassi
 **/
@SpringBootTest
public class MutanServiceTest {

    @Autowired
    private MutantService mutantService;

    @Test
    public void isMutantServiceTest() throws Exception{
        String[] dna1 = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGC", "GCGTCA", "TCACTG"}; //No mutante
        String[] dna2 = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"}; //Mutante
        assertFalse(mutantService.isMutant(dna1));
        assertTrue(mutantService.isMutant(dna2));
    }

}

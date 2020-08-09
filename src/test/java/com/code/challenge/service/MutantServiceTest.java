package com.code.challenge.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Agustin Gambirassi
 **/
@SpringBootTest
public class MutantServiceTest {

    @Autowired
    private MutantService mutantService;

    private static String[] dna1, dna2, dna3, dna4, dna5;

    @BeforeAll
    static void setUp() {
        dna1 = new String[]{"ATGCGA", "CAGTGC", "TTATTT", "AGACGC", "GCGTCA", "TCACTG"}; //No mutante
        dna2 = new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"}; //Mutante
        dna3 = new String[]{"ATGCGAA", "CAGTGCG", "TTCTATT", "AGAAGGT", "CCTCTAC", "TCAACTG", "ATCGTGA"}; //No mutante
        dna4 = new String[]{"ATGATGCGA", "CGTAGCTAG", "ATCTACTAA", "ATGCTAGCT", "GTACGTAGC", "TAGCTAGCT", "CGTCGCTGA", "CTCTTACTC", "GTAGTCAAG"};//Mutante
        dna5 = new String[]{"ACYACT","ATCAGA","CCCCCA","AGAGTAC","ATCATR","DNAATC"};
    }

    @Test
    public void isMutantServiceTest() throws Exception {
        assertFalse(mutantService.isMutant(dna1));
        assertTrue(mutantService.isMutant(dna2));
        assertFalse(mutantService.isMutant(dna3));
        assertTrue(mutantService.isMutant(dna4));
    }

    @Test
    public void isValidTest() throws Exception {
        assertTrue(mutantService.isValid(dna1));
        assertTrue(mutantService.isValid(dna4));
        assertFalse(mutantService.isValid(dna5));
    }

}

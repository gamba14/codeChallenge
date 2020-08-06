package com.code.challenge.controller;

import com.code.challenge.domain.MutantMapDTO;
import com.code.challenge.service.IMutantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Agustin Gambirassi
 **/
@RestController("/v1/api")
public class MutantResource {
    private final IMutantService mutantService;

    public MutantResource(IMutantService mutantService) {
        this.mutantService = mutantService;
    }

    @PostMapping("/analize")
    private ResponseEntity<String> analizeDna(@RequestBody MutantMapDTO dto){
        String result = mutantService.isMutant(dto.getDnaMap()) ? "Mutante" : "No mutante";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ExceptionHandler({Exception.class})
    private ResponseEntity<String> exceptionHandler(){
        return new ResponseEntity<>("Hubo un error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

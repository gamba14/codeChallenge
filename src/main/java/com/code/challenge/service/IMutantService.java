package com.code.challenge.service;

/**
 * @author Agustin Gambirassi
 **/
public interface IMutantService {
    boolean isMutant(String[] dnaMap);
    boolean isValid(String[] dnaMap);
}

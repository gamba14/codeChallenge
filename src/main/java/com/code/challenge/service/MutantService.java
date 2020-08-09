package com.code.challenge.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Agustin Gambirassi
 **/
@Service
@Slf4j
public class MutantService implements IMutantService{

    final String pattern = "[ATCG]+\\w";

    @Override
    public boolean isValid(String[] dnaMap) {
        return Arrays.stream(dnaMap).allMatch(x -> x.matches(pattern));
    }

    @Override
    public boolean isMutant(String[] dnaMap) {
        Integer rows = isMutantByRow(dnaMap);
        Integer columns = isMutantByColumn(dnaMap);
        Integer diagonalDown = isMutantByDiagonalDown(dnaMap);
        Integer diagonalUp = isMutantByDiagonalUp(dnaMap);

        return rows + columns + diagonalDown + diagonalUp > 1;
    }

    private Integer isMutantByRow(String[] dnaMap) {
        log.info("Analizando filas");
        int coincidences = 0;
        for (String row : dnaMap) {
            char[] columns = row.toCharArray();
            Stack<Character> rowStack = new Stack<>();
            rowStack.push(columns[0]);
            for (int i = 1; i < columns.length; i++) {
                if (rowStack.isEmpty()) {
                    rowStack.push(columns[i - 1]);
                }
                if (columns[i] == rowStack.peek()) {
                    rowStack.push(columns[i]);
                } else {
                    rowStack.clear();
                }
                if (rowStack.size() >= 4) coincidences++;
            }
        }
        return coincidences;
    }

    private Integer isMutantByColumn(String[] dna) {
        log.info("Analizando columnas");
        int coincidences = 0;
        Stack<Character> columnStack = new Stack<>();
        for (int i = 0; i < dna.length; i++) {
            columnStack.push(dna[0].charAt(i));
            for (int j = 0; j < dna.length - 1; j++) {
                if (columnStack.isEmpty()) {
                    columnStack.push(dna[j+1].charAt(i));
                }
                if (dna[j+1].charAt(i) == columnStack.peek()) {
                    columnStack.push(dna[j+1].charAt(i));
                } else {
                    columnStack.clear();
                }
                if (columnStack.size() >= 4) coincidences++;
            }
            columnStack.clear();
        }
        return coincidences;
    }

    private Integer isMutantByDiagonalDown(String[] dna) {
        log.info("Analizando diagonal descendente");
        int width = dna[0].length();
        int coincidences = 0;
        Stack<Character> diagonalStack = new Stack<>();
        for (int i = 0; i < width - 3; i++) {
            for (int j = 0; j < width - i; j++) {
                if (diagonalStack.isEmpty()) {
                    log.debug("{}", dna[i].charAt(j));
                    diagonalStack.push(dna[i].charAt(j));
                }
                if (dna[i + j].charAt(j) == diagonalStack.peek()) {
                    diagonalStack.push(dna[i + j].charAt(j));
                } else {
                    diagonalStack.clear();
                }
                if (diagonalStack.size() >= 4) coincidences++;
            }
            diagonalStack.clear();
        }
        return coincidences;
    }

    private Integer isMutantByDiagonalUp(String[] dna) {
        log.info("Analizando diagonales ascendente");
        int width = dna[0].length();
        int coincidences = 0;
        Stack<Character> diagonalStack = new Stack<>();
        for (int i = 1; i < width - 3; i++) {
            for (int j = 0; j < width - i; j++) {
                if (diagonalStack.isEmpty()) {
                    diagonalStack.push(dna[j].charAt(i + j));
                }
                if (dna[j].charAt(i + j) == diagonalStack.peek()) {
                    diagonalStack.push(dna[j].charAt(i + j));
                } else {
                    diagonalStack.clear();
                }
            }
            if (diagonalStack.size() >= 4) coincidences++;
        }
        return coincidences;
    }
}

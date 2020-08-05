package com.code.challenge.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Stack;

/**
 * @author Agustin Gambirassi
 **/
@Service
@Slf4j
public class MutantService {
    public boolean isMutant(String[] dnaMap) {
        Integer rows = isMutantByRow(dnaMap);
        Integer columns = isMutantByColumn(dnaMap);
        return rows + columns  > 1;
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
        for (String row : dna) {
            Stack<Character> columnStack = new Stack<>();
            columnStack.push(row.charAt(0));
            for (int j = 1; j < dna.length; j++) {
                if (columnStack.isEmpty()) {
                    columnStack.push(row.charAt(j - 1));
                }
                if (row.charAt(j) == columnStack.peek()) {
                    columnStack.push(row.charAt(j));
                } else {
                    columnStack.clear();
                }
                if (columnStack.size() >= 4) coincidences++;
            }
        }
        return coincidences;
    }
}

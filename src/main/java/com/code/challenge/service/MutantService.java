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
        return rows  > 1;
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
}

package com.gepardec.tdd.factories;

import javax.enterprise.context.Dependent;

@Dependent
public class StringFactory {
    public String getString(String entry) {
        return "Factory: ".concat(entry);
    }    
}

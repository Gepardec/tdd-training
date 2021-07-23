package at.gepardec.trainings.tdd.jersey.factories;

import javax.enterprise.context.Dependent;

@Dependent
public class StringFactory {
    public String getString(String entry) {
        return "Factory: ".concat(entry);
    }    
}

package org.rotation;

import java.util.List;
import java.util.Random;

public class ValidatorRotation {
    private final Random random;

    public ValidatorRotation() {
        this.random = new Random();
    }

    public String selectNextValidator(List<String> activeValidators) {
        if (activeValidators.isEmpty()) return null;
        int index = random.nextInt(activeValidators.size());
        return activeValidators.get(index);
    }
}

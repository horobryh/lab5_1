package validators.baseValidators;

import validators.Verifiable;
import validators.exceptions.BlankPointerException;

public class NotBlank implements Verifiable {
    @Override
    public void checkCondition(String object) throws BlankPointerException {
        if (object.isBlank()) {
            throw new BlankPointerException("Аргумент не может быть пустым.");
        }
    }
}

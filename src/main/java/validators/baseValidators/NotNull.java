package validators.baseValidators;

import validators.Verifiable;

public class NotNull implements Verifiable {
    @Override
    public void checkCondition(String object) throws NullPointerException {
        if (object == null) {
            throw new NullPointerException("Аргумент не может быть null");
        }
    }
}

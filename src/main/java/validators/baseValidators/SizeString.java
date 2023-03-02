package validators.baseValidators;

import validators.Verifiable;
import validators.exceptions.SizeLimitedException;

public class SizeString implements Verifiable {
    private final int minLength;
    private final int maxLength;

    public SizeString(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public void checkCondition(String object) throws SizeLimitedException {
        if (object.length() < minLength || object.length() > maxLength) {
            throw new SizeLimitedException("Значение аргумента не помещается в установленные пределы");
        }
    }
}

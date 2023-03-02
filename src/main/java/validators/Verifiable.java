package validators;

import validators.exceptions.BlankPointerException;
import validators.exceptions.NullException;
import validators.exceptions.SizeLimitedException;

public interface Verifiable {
    void checkCondition(String object) throws BlankPointerException, NullException, SizeLimitedException;
}

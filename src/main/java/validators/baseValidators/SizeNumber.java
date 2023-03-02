package validators.baseValidators;

import validators.Verifiable;
import validators.exceptions.SizeLimitedException;

import javax.naming.SizeLimitExceededException;

public class SizeNumber<N extends Number> implements Verifiable {
    private final N minValue;
    private final N maxValue;
    public SizeNumber(N minValue, N maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
    @Override
    public void checkCondition(String object) throws SizeLimitedException {
        double checkedObject = Double.parseDouble(object);
        if (checkedObject < minValue.doubleValue() || checkedObject > maxValue.doubleValue()) {
            throw new SizeLimitedException("Значение аргумента не помещается в установленные пределы");
        }
    }
}

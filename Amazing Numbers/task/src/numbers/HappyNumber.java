package numbers;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber extends NumberProperty {
    private final List<Long> observedNumbers = new ArrayList<>();
    public HappyNumber(String number) {
        super(number);
        name = "happy";
        mutuallyExclusiveProperties.add("sad");
    }

    @Override
    boolean match() {
        observedNumbers.clear();
        return checkHappy(squareSumOfDigits(number));
    }

    private boolean checkHappy(long currentNumber) {
        if (currentNumber == 1) {
            return true;
        }

        if (observedNumbers.contains(currentNumber)) {
            return false;
        }

        observedNumbers.add(currentNumber);

        return checkHappy(squareSumOfDigits(String.valueOf(currentNumber)));
    }

    private long squareSumOfDigits(String number) {
        long sum = 0;
        for (int i = 0; i < number.length(); i++) {
            long digit = Long.parseLong(String.valueOf(number.charAt(i)));
            sum += digit * digit;
        }

        return sum;
    }
}

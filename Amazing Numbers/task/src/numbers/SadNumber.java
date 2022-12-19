package numbers;

import java.util.ArrayList;
import java.util.List;

public class SadNumber extends NumberProperty {
    private final List<Long> observedNumbers = new ArrayList<>();
    public SadNumber(String number) {
        super(number);
        name = "sad";
        mutuallyExclusiveProperties.add("happy");
    }

    @Override
    boolean match() {
        observedNumbers.clear();
        return checkSad(squareSumOfDigits(number));
    }

    private boolean checkSad(long currentNumber) {
        if (currentNumber == 1) {
            return false;
        }

        if (observedNumbers.contains(currentNumber)) {
            return true;
        }

        observedNumbers.add(currentNumber);

        return checkSad(squareSumOfDigits(String.valueOf(currentNumber)));
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

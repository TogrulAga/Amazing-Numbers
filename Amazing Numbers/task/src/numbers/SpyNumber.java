package numbers;

public class SpyNumber extends NumberProperty {
    public SpyNumber(String number) {
        super(number);
        name = "spy";
        mutuallyExclusiveProperties.add("duck");
    }

    @Override
    boolean match() {
        long sum = 0;
        long product = 1;
        for (int i = 0; i < number.length(); i++) {
            long digit = Long.parseLong(String.valueOf(number.charAt(i)));
            sum += digit;
            product *= digit;
        }
        return sum == product;
    }
}

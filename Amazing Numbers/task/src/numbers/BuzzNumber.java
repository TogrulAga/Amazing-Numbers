package numbers;

public class BuzzNumber extends NumberProperty {
    public BuzzNumber(String number) {
        super(number);
        name = "buzz";
    }

    private boolean match(long number) {
        return number % 10 == 7 || number % 7 == 0;
    }

    public boolean match() {
        return match(Long.parseLong(number));
    }
}

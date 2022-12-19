package numbers;

public class GapfulNumber extends NumberProperty {
    public GapfulNumber(String number) {
        super(number);
        name = "gapful";
    }

    @Override
    boolean match() {
        if (number.length() <= 2) {
            return false;
        }

        String newNumber = "%c%c".formatted(number.charAt(0), number.charAt(number.length() - 1));

        return Long.parseLong(number) % Long.parseLong(newNumber) == 0;
    }
}

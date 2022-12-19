package numbers;

public class PalindromicNumber extends NumberProperty {
    public PalindromicNumber(String number) {
        super(number);
        name = "palindromic";
    }

    @Override
    boolean match() {
        return number.equals(new StringBuilder(number).reverse().toString());
    }
}

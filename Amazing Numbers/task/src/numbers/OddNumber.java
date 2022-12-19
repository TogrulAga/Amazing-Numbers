package numbers;

public class OddNumber extends NumberProperty {
    public OddNumber(String number) {
        super(number);
        name = "odd";
        mutuallyExclusiveProperties.add("even");
    }

    @Override
    boolean match() {
        return Long.parseLong(number) % 2 != 0;
    }
}

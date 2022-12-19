package numbers;

public class DuckNumber extends NumberProperty {
    public DuckNumber(String number) {
        super(number);
        name = "duck";
        mutuallyExclusiveProperties.add("spy");
    }

    @Override
    boolean match() {
        return number.contains("0");
    }
}

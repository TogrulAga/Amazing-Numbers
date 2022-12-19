package numbers;

public class SunnyNumber extends NumberProperty {
    public SunnyNumber(String number) {
        super(number);
        name = "sunny";
        mutuallyExclusiveProperties.add("square");
    }

    @Override
    boolean match() {
        return isSquare(Long.parseLong(number) + 1);
    }

    private boolean isSquare(long other) {
        long squareRoot = (long) Math.sqrt((double) other);
        return squareRoot * squareRoot == other;
    }
}

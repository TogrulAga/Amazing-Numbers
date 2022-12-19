package numbers;

public class SquareNumber extends NumberProperty {
    public SquareNumber(String number) {
        super(number);
        name = "square";
        mutuallyExclusiveProperties.add("sunny");
    }

    @Override
    boolean match() {
        long squareRoot = (long) Math.sqrt(Double.parseDouble(number));
        return squareRoot * squareRoot == Long.parseLong(number);
    }
}

package numbers;

public class EvenNumber extends NumberProperty {
    public EvenNumber(String number) {
        super(number);
        name = "even";
        mutuallyExclusiveProperties.add("odd");
    }

    @Override
    boolean match() {
        return Long.parseLong(number) % 2 == 0;
    }
}

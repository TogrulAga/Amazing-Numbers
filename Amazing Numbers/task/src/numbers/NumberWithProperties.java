package numbers;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberWithProperties {
    private final String number;
    private final List<NumberProperty> properties = new ArrayList<>();

    public NumberWithProperties(String number) {
        this.number = number;

        properties.add(new BuzzNumber(number));
        properties.add(new DuckNumber(number));
        properties.add(new PalindromicNumber(number));
        properties.add(new GapfulNumber(number));
        properties.add(new SpyNumber(number));
        properties.add(new SquareNumber(number));
        properties.add(new SunnyNumber(number));
        properties.add(new JumpingNumber(number));
        properties.add(new HappyNumber(number));
        properties.add(new SadNumber(number));
        properties.add(new EvenNumber(number));
        properties.add(new OddNumber(number));
    }

    public NumberWithProperties(long number) {
        this(String.valueOf(number));
    }

    public String getProperties() {
        return "%s is ".formatted(number) + properties.stream().filter(NumberProperty::match).map(NumberProperty::getName).collect(Collectors.joining(", "));
    }

    public String getAllProperties() {
        return String.format("Properties of %s%n", number) + properties.stream().map(property -> "%s: %b%n".formatted(property.getName(), property.match())).collect(Collectors.joining());
    }

    public boolean matchesAll(List<String> parameters) {
        return properties.stream().filter(property -> property.nameMatchesAny(parameters)).allMatch(NumberProperty::match);
    }

    public boolean matchesAny(List<String> parameters) {
        return properties.stream().filter(property -> property.nameMatchesAny(parameters)).anyMatch(NumberProperty::match);
    }
}

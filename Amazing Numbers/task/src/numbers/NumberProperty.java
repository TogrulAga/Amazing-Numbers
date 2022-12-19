package numbers;

import java.util.ArrayList;
import java.util.List;

public abstract class NumberProperty {
    protected String number;
    protected String name;
    protected List<String> mutuallyExclusiveProperties = new ArrayList<>();
    NumberProperty(String number) {
        this.number = number;
        mutuallyExclusiveProperties.add("-" + name);
    }

    abstract boolean match();

    boolean nameMatches(String name) {
        return name.toLowerCase().equals(this.name);
    }

    public boolean nameMatchesAny(List<String> names) {
        return names.stream().map(String::toLowerCase).anyMatch(this::nameMatches);
    }

    public String getName() {
        return name;
    }

    public boolean mutuallyExclusiveWith(String other) {
        return mutuallyExclusiveProperties.stream().anyMatch(other::equals);
    }
}
